/*******************************************************************************
 * Copyright (c) 2003, 2008 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial Contributors:
 * The following Wind River employees contributed to the Terminal component
 * that contains this file: Chris Thew, Fran Litterio, Stephen Lamb,
 * Helmut Haigermoser and Ted Williams.
 *
 * Contributors:
 * Michael Scharf (Wind River) - split into core, view and connector plugins
 * Martin Oberhuber (Wind River) - fixed copyright headers and beautified
 * Martin Oberhuber (Wind River) - [206892] State handling: Only allow connect when CLOSED
 * Martin Oberhuber (Wind River) - [206883] Serial Terminal leaks Jobs
 * Martin Oberhuber (Wind River) - [208145] Terminal prints garbage after quick disconnect/reconnect
 * Martin Oberhuber (Wind River) - [207785] NPE when trying to send char while no longer connected
 * Michael Scharf (Wind River) - [209665] Add ability to log byte streams from terminal
 * Ruslan Sychev (Xored Software) - [217675] NPE or SWTException when closing Terminal View while connection establishing
 * Michael Scharf (Wing River) - [196447] The optional terminal input line should be resizeable
 * Martin Oberhuber (Wind River) - [168197] Replace JFace MessagDialog by SWT MessageBox
 * Martin Oberhuber (Wind River) - [204796] Terminal should allow setting the encoding to use
 * Michael Scharf (Wind River) - [237398] Terminal get Invalid Thread Access when the title is set
 * Martin Oberhuber (Wind River) - [240745] Pressing Ctrl+F1 in the Terminal should bring up context help
 * Michael Scharf (Wind River) - [240098] The cursor should not blink when the terminal is disconnected
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.emulator;

import static org.osgi.framework.FrameworkUtil.getBundle;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.keys.IBindingService;
import org.osgi.framework.ServiceRegistration;

import de.wisag.automation.micas.olt.base.connection.CallbackProcessor;
import de.wisag.automation.micas.olt.base.connection.IConnectedDevice;
import de.wisag.automation.micas.olt.base.connection.IMessageSink;
import de.wisag.automation.micas.olt.internal.terminal.control.ICommandInputField;
import de.wisag.automation.micas.olt.internal.terminal.control.ITerminalListener;
import de.wisag.automation.micas.olt.internal.terminal.control.ITerminalViewControl;
import de.wisag.automation.micas.olt.internal.terminal.control.impl.ITerminalControlForText;
import de.wisag.automation.micas.olt.internal.terminal.control.impl.TerminalMessages;
import de.wisag.automation.micas.olt.internal.terminal.control.impl.TerminalPlugin;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ITerminalConnector;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ITerminalControl;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.Logger;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.TerminalState;
import de.wisag.automation.micas.olt.internal.terminal.textcanvas.ITextCanvasModel;
import de.wisag.automation.micas.olt.internal.terminal.textcanvas.PipedInputStream;
import de.wisag.automation.micas.olt.internal.terminal.textcanvas.PollingTextCanvasModel;
import de.wisag.automation.micas.olt.internal.terminal.textcanvas.TextCanvas;
import de.wisag.automation.micas.olt.internal.terminal.textcanvas.TextLineRenderer;
import de.wisag.automation.micas.olt.terminal.model.ITerminalTextData;
import de.wisag.automation.micas.olt.terminal.model.ITerminalTextDataSnapshot;
import de.wisag.automation.micas.olt.terminal.model.TerminalTextDataFactory;

/**
 * This class was originally written to use nested classes, which unfortunately
 * makes this source file larger and more complex than it needs to be. In
 * particular, the methods in the nested classes directly access the fields of
 * the enclosing class. One day we should pull the nested classes out into their
 * own source files (but still in this package).
 *
 * @author Chris Thew <chris.thew@windriver.com>
 */
public class VT100TerminalControl
        implements ITerminalControlForText, ITerminalControl, ITerminalViewControl, IMessageSink, IConnectedDevice {
    protected final static String[] LINE_DELIMITERS = { "\n" }; //$NON-NLS-1$

    /**
     * This field holds a reference to a TerminalText object that performs all
     * ANSI text processing on data received from the remote host and controls
     * how text is displayed using the view's StyledText widget.
     */
    private final VT100Emulator fTerminalText;
    private Display fDisplay;
    private TextCanvas fCtlText;
    private Composite fWndParent;
    private Clipboard fClipboard;
    private KeyListener fKeyHandler;
    private final ITerminalListener fTerminalListener;
    private String fMsg = ""; //$NON-NLS-1$
    private FocusListener fFocusListener;
    private ITerminalConnector fConnector;
    private final ITerminalConnector[] fConnectors;
    PipedInputStream fInputStream;
    private static final String defaultEncoding = new java.io.InputStreamReader(
            new java.io.ByteArrayInputStream(new byte[0])).getEncoding();
    private String fEncoding = defaultEncoding;
    private InputStreamReader fInputStreamReader;

    private ICommandInputField fCommandInputField;

    private volatile TerminalState fState;

    private final ITerminalTextData fTerminalModel;

    /**
     * Is protected by synchronize on this
     */
    volatile private Job fJob;

    private ServiceRegistration<IConnectedDevice> controlRegistration;
    private AtomicReference<CallbackProcessor> currentCallbackProcessor = new AtomicReference<>(null);
    private final CloseableReentrantLock callbackProcessorLock = new CloseableReentrantLock();

    public VT100TerminalControl(ITerminalListener target, Composite wndParent, ITerminalConnector[] connectors) {
        fConnectors = connectors;
        fTerminalListener = target;
        fTerminalModel = TerminalTextDataFactory.makeTerminalTextData();
        fTerminalModel.setMaxHeight(1000);
        fInputStream = new PipedInputStream(8 * 1024);
        fTerminalText = new VT100Emulator(fTerminalModel, this, null);
        try {
            // Use Default Encoding as start, until setEncoding() is called
            setEncoding(null);
        } catch (UnsupportedEncodingException e) {
            // Should never happen
            e.printStackTrace();
            // Fall back to local Platform Default Encoding
            fEncoding = defaultEncoding;
            fInputStreamReader = new InputStreamReader(fInputStream);
            fTerminalText.setInputStreamReader(fInputStreamReader);
        }

        setupTerminal(wndParent);
    }

    @Override
    public void setEncoding(String encoding) throws UnsupportedEncodingException {
        if (encoding == null) {
            // TODO better use a standard remote-to-local encoding?
            encoding = "ISO-8859-1"; //$NON-NLS-1$
            // TODO or better use the local default encoding?
            // encoding = defaultEncoding;
        }
        fInputStreamReader = new InputStreamReader(fInputStream, encoding);
        // remember encoding if above didn't throw an exception
        fEncoding = encoding;
        fTerminalText.setInputStreamReader(fInputStreamReader);
    }

    @Override
    public String getEncoding() {
        return fEncoding;
    }

    @Override
    public ITerminalConnector[] getConnectors() {
        return fConnectors;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#copy()
     */
    @Override
    public void copy() {
        getCtlText().copy();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#paste()
     */
    @Override
    public void paste() {
        TextTransfer textTransfer = TextTransfer.getInstance();
        String strText = (String) fClipboard.getContents(textTransfer);
        pasteString(strText);
        // TODO paste in another thread.... to avoid blocking
        // new Thread() {
        // public void run() {
        // for (int i = 0; i < strText.length(); i++) {
        // sendChar(strText.charAt(i), false);
        // }
        //
        // }
        // }.start();
    }

    /**
     * @param strText
     *            the text to paste
     */
    @Override
    public boolean pasteString(String strText) {
        if (!isConnected()) {
            return false;
        }
        if (strText == null) {
            return false;
        }
        if (!fEncoding.equals(defaultEncoding)) {
            sendString(strText);
        } else {
            // TODO I do not understand why pasteString would do this here...
            for (int i = 0; i < strText.length(); i++) {
                sendChar(strText.charAt(i), false);
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#selectAll()
     */
    @Override
    public void selectAll() {
        getCtlText().selectAll();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#sendKey(char)
     */
    @Override
    public void sendKey(char character) {
        Event event;
        KeyEvent keyEvent;

        event = new Event();
        event.widget = getCtlText();
        event.character = character;
        event.keyCode = 0;
        event.stateMask = 0;
        event.doit = true;
        keyEvent = new KeyEvent(event);

        fKeyHandler.keyPressed(keyEvent);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#clearTerminal()
     */
    @Override
    public void clearTerminal() {
        // The TerminalText object does all text manipulation.

        getTerminalText().clearTerminal();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#getClipboard()
     */
    @Override
    public Clipboard getClipboard() {
        return fClipboard;
    }

    /**
     * @return non null selection
     */
    @Override
    public String getSelection() {
        String txt = fCtlText.getSelectionText();
        if (txt == null) {
            txt = ""; //$NON-NLS-1$
        }
        return txt;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#setFocus()
     */
    @Override
    public void setFocus() {
        getCtlText().setFocus();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return getCtlText().isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#isDisposed()
     */
    @Override
    public boolean isDisposed() {
        return getCtlText().isDisposed();
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#isConnected()
     */
    @Override
    public boolean isConnected() {
        return fState == TerminalState.CONNECTED;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#disposeTerminal()
     */
    @Override
    public void disposeTerminal() {
        Logger.log("entered."); //$NON-NLS-1$
        disconnectTerminal();
        fClipboard.dispose();
        getTerminalText().dispose();
    }

    @Override
    public void connectTerminal() {
        Logger.log("entered."); //$NON-NLS-1$

        if (getTerminalConnector() == null) {
            return;
        }
        fTerminalText.resetState();
        if (fConnector.getInitializationErrorMessage() != null) {
            showErrorMessage(NLS.bind(TerminalMessages.CannotConnectTo, fConnector.getName(),
                    fConnector.getInitializationErrorMessage()));
            // we cannot connect because the connector was not initialized
            return;
        }
        getTerminalConnector().connect(this);
        // clean the error message
        setMsg(""); //$NON-NLS-1$
        waitForConnect();

    }

    @Override
    public ITerminalConnector getTerminalConnector() {
        return fConnector;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#disconnectTerminal()
     */
    @Override
    public void disconnectTerminal() {
        Logger.log("entered."); //$NON-NLS-1$
        onDisconnect();
        // Ensure that a new Job can be started; then clean up old Job.
        // TODO not sure whether the fInputStream needs to be cleaned too,
        // or whether the Job could actually cancel in case the fInputStream is
        // closed.
        Job job;
        synchronized (this) {
            job = fJob;
            fJob = null;
        }
        if (job != null) {
            job.cancel();
            // There's not really a need to interrupt, since the job will
            // check its cancel status after 500 msec latest anyways...
            // Thread t = job.getThread();
            // if(t!=null) t.interrupt();
        }
        if (getState() == TerminalState.CLOSED) {
            return;
        }
        if (getTerminalConnector() != null) {
            getTerminalConnector().disconnect();
        }
    }

    // TODO
    private void waitForConnect() {
        Logger.log("entered."); //$NON-NLS-1$
        // TODO
        // Eliminate this code
        while (getState() == TerminalState.CONNECTING) {
            if (fDisplay.readAndDispatch()) {
                continue;
            }

            fDisplay.sleep();
        }
        if (getCtlText().isDisposed()) {
            disconnectTerminal();
            return;
        }
        if (!getMsg().equals("")) //$NON-NLS-1$
        {
            showErrorMessage(getMsg());

            disconnectTerminal();
            return;
        }
        getCtlText().setFocus();
        startReaderJob();

    }

    private synchronized void startReaderJob() {
        if (fJob == null) {
            fJob = new Job("Terminal data reader") { //$NON-NLS-1$

                @Override
                protected IStatus run(IProgressMonitor monitor) {
                    IStatus status = Status.OK_STATUS;
                    try {
                        while (true) {
                            while (fInputStream.available() == 0 && !monitor.isCanceled()) {
                                try {
                                    fInputStream.waitForAvailable(500);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            if (monitor.isCanceled()) {
                                // Do not disconnect terminal here because
                                // another reader job may already be running
                                status = Status.CANCEL_STATUS;
                                break;
                            }
                            try {

                                try (CloseableReentrantLock lock = callbackProcessorLock.open()) {
                                    if (currentCallbackProcessor.get() != null) {
                                        if (currentCallbackProcessor.get()
                                                .processTextAndReturnReadiness(fInputStreamReader)) {
                                            releaseCallbackProcessor();
                                        }
                                    } else {
                                        fTerminalText.processText();
                                    }
                                }
                            } catch (Exception e) {
                                try (CloseableReentrantLock lock = callbackProcessorLock.open()) {
                                    if (currentCallbackProcessor.get() != null) {
                                        currentCallbackProcessor.get().errorOccured(//
                                                new Status(IStatus.ERROR, TerminalPlugin.PLUGIN_ID,
                                                        e.getLocalizedMessage(), e));
                                    }

                                } finally {
                                    releaseCallbackProcessor();
                                }
                                disconnectTerminal();
                                status = new Status(IStatus.ERROR, TerminalPlugin.PLUGIN_ID, e.getLocalizedMessage(),
                                        e);
                                break;
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();

                    } finally {
                        // clean the job: start a new one when the connection
                        // gets restarted
                        // Bug 208145: make sure we do not clean an other job
                        // that's already started (since it would become a
                        // Zombie)
                        synchronized (VT100TerminalControl.this) {
                            if (fJob == this) {
                                fJob = null;
                            }
                        }
                    }
                    return status;
                }

            };
            fJob.setSystem(true);
            fJob.schedule();
        }

    }

    private void showErrorMessage(String message) {
        String strTitle = TerminalMessages.TerminalError;
        // [168197] Replace JFace MessagDialog by SWT MessageBox
        // MessageDialog.openError( getShell(), strTitle, message);
        MessageBox mb = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
        mb.setText(strTitle);
        mb.setMessage(message);
        mb.open();
    }

    @Override
    public void sendString(String string) {
        try {
            // Send the string after converting it to an array of bytes using
            // the
            // platform's default character encoding.
            //
            // TODO: Find a way to force this to use the ISO Latin-1 encoding.
            // TODO: handle Encoding Errors in a better way
            getOutputStream().write(string.getBytes(fEncoding));
            getOutputStream().flush();
        } catch (SocketException socketException) {
            displayTextInTerminal(socketException.getMessage());

            String strMsg = TerminalMessages.SocketError + "!\n" + socketException.getMessage(); //$NON-NLS-1$
            showErrorMessage(strMsg);

            Logger.logException(socketException);

            disconnectTerminal();
        } catch (IOException ioException) {
            showErrorMessage(TerminalMessages.IOError + "!\n" + ioException.getMessage());//$NON-NLS-1$

            Logger.logException(ioException);

            disconnectTerminal();
        }
    }

    @Override
    public Shell getShell() {
        return getCtlText().getShell();
    }

    protected void sendChar(char chKey, boolean altKeyPressed) {
        try {
            int byteToSend = chKey;
            OutputStream os = getOutputStream();
            if (os == null) {
                // Bug 207785: NPE when trying to send char while no longer
                // connected
                Logger.log("NOT sending '" + byteToSend + "' because no longer connected"); //$NON-NLS-1$ //$NON-NLS-2$
            } else {
                if (altKeyPressed) {
                    // When the ALT key is pressed at the same time that a
                    // character is
                    // typed, translate it into an ESCAPE followed by the
                    // character. The
                    // alternative in this case is to set the high bit of the
                    // character
                    // being transmitted, but that will cause input such as
                    // ALT-f to be
                    // seen as the ISO Latin-1 character '�', which can be
                    // confusing to
                    // European users running Emacs, for whom Alt-f should move
                    // forward a
                    // word instead of inserting the '�' character.
                    //
                    // TODO: Make the ESCAPE-vs-highbit behavior user
                    // configurable.

                    Logger.log("sending ESC + '" + byteToSend + "'"); //$NON-NLS-1$ //$NON-NLS-2$
                    getOutputStream().write('\u001b');
                    getOutputStream().write(byteToSend);
                } else {
                    Logger.log("sending '" + byteToSend + "'"); //$NON-NLS-1$ //$NON-NLS-2$
                    getOutputStream().write(byteToSend);
                }
                getOutputStream().flush();
            }
        } catch (SocketException socketException) {
            Logger.logException(socketException);

            displayTextInTerminal(socketException.getMessage());

            String strMsg = TerminalMessages.SocketError + "!\n" + socketException.getMessage(); //$NON-NLS-1$

            showErrorMessage(strMsg);
            Logger.logException(socketException);

            disconnectTerminal();
        } catch (IOException ioException) {
            Logger.logException(ioException);

            displayTextInTerminal(ioException.getMessage());

            String strMsg = TerminalMessages.IOError + "!\n" + ioException.getMessage(); //$NON-NLS-1$

            showErrorMessage(strMsg);
            Logger.logException(ioException);

            disconnectTerminal();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#setupTerminal()
     */
    public void setupTerminal(Composite parent) {
        fState = TerminalState.CLOSED;
        setupControls(parent);
        setupListeners();
        setupHelp(fWndParent, TerminalPlugin.HELP_VIEW);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#onFontChanged()
     */
    @Override
    public void setFont(Font font) {
        getCtlText().setFont(font);
        if (fCommandInputField != null) {
            fCommandInputField.setFont(font);
        }

        // Tell the TerminalControl singleton that the font has changed.
        fCtlText.onFontChange();
        getTerminalText().fontChanged();
    }

    @Override
    public Font getFont() {
        return getCtlText().getFont();
    }

    @Override
    public Control getControl() {
        return fCtlText;
    }

    @Override
    public Control getRootControl() {
        return fWndParent;
    }

    protected void setupControls(Composite parent) {
        // The Terminal view now aims to be an ANSI-conforming terminal
        // emulator, so it
        // can't have a horizontal scroll bar (but a vertical one is ok). Also,
        // do
        // _not_ make the TextViewer read-only, because that prevents it from
        // seeing a
        // TAB character when the user presses TAB (instead, the TAB causes
        // focus to
        // switch to another Workbench control). We prevent local keyboard input
        // from
        // modifying the text in method TerminalVerifyKeyListener.verifyKey().

        fWndParent = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        layout.verticalSpacing = 0;
        fWndParent.setLayout(layout);

        ITerminalTextDataSnapshot snapshot = fTerminalModel.makeSnapshot();
        // TODO how to get the initial size correctly!
        snapshot.updateSnapshot(false);
        ITextCanvasModel canvasModel = new PollingTextCanvasModel(snapshot);
        fCtlText = new TextCanvas(fWndParent, canvasModel, SWT.NONE, new TextLineRenderer(fCtlText, canvasModel));

        fCtlText.setLayoutData(new GridData(GridData.FILL_BOTH));
        fCtlText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        fCtlText.addResizeHandler(new TextCanvas.ResizeListener() {
            @Override
            public void sizeChanged(int lines, int columns) {
                fTerminalText.setDimensions(lines, columns);
            }
        });

        fDisplay = getCtlText().getDisplay();
        fClipboard = new Clipboard(fDisplay);
        // fViewer.setDocument(new TerminalDocument());
        setFont(JFaceResources.getTextFont());
    }

    protected void setupListeners() {
        fKeyHandler = new TerminalKeyHandler();
        fFocusListener = new TerminalFocusListener();

        getCtlText().addKeyListener(fKeyHandler);
        getCtlText().addFocusListener(fFocusListener);

    }

    /**
     * Setup all the help contexts for the controls.
     */
    protected void setupHelp(Composite parent, String id) {
        Control[] children = parent.getChildren();

        for (int nIndex = 0; nIndex < children.length; nIndex++) {
            if (children[nIndex] instanceof Composite) {
                setupHelp((Composite) children[nIndex], id);
            }
        }

        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, id);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#displayTextInTerminal(java.lang.String)
     */
    @Override
    public void displayTextInTerminal(String text) {
        writeToTerminal("\r\n" + text + "\r\n"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void writeToTerminal(String text) {
        try {
            fInputStream.getOutputStream().write(text.getBytes(fEncoding));
        } catch (UnsupportedEncodingException e) {
            // should never happen!
            e.printStackTrace();
        } catch (IOException e) {
            // should never happen!
            e.printStackTrace();
        }

    }

    @Override
    public OutputStream getRemoteToTerminalOutputStream() {
        if (Logger.isLogEnabled()) {
            return new LoggingOutputStream(fInputStream.getOutputStream());
        } else {
            return fInputStream.getOutputStream();
        }
    }

    protected boolean isLogCharEnabled() {
        return TerminalPlugin.isOptionEnabled(Logger.TRACE_DEBUG_LOG_CHAR);
    }

    protected boolean isLogBufferSizeEnabled() {
        return TerminalPlugin.isOptionEnabled(Logger.TRACE_DEBUG_LOG_BUFFER_SIZE);
    }

    @Override
    public OutputStream getOutputStream() {
        if (getTerminalConnector() != null) {
            return getTerminalConnector().getTerminalToRemoteStream();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#setMsg(java.lang.String)
     */
    @Override
    public void setMsg(String msg) {
        fMsg = msg;
    }

    public String getMsg() {
        return fMsg;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#getCtlText()
     */
    protected TextCanvas getCtlText() {
        return fCtlText;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.provisional.api.
     * ITerminalControl#getTerminalText()
     */
    public VT100Emulator getTerminalText() {
        return fTerminalText;
    }

    protected class TerminalFocusListener implements FocusListener {
        private IContextActivation contextActivation = null;

        protected TerminalFocusListener() {
            super();
        }

        @Override
        public void focusGained(FocusEvent event) {
            // Disable all keyboard accelerators (e.g., Control-B) so the
            // Terminal view
            // can see every keystroke. Without this, Emacs, vi, and Bash are
            // unusable
            // in the Terminal view.

            IBindingService bindingService = PlatformUI.getWorkbench().getAdapter(IBindingService.class);
            bindingService.setKeyFilterEnabled(false);

            // The above code fails to cause Eclipse to disable menu-activation
            // accelerators (e.g., Alt-F for the File menu), so we set the
            // command
            // context to be the Terminal view's command context. This enables
            // us to
            // override menu-activation accelerators with no-op commands in our
            // plugin.xml file, which enables the Terminal view to see absolutly
            // _all_
            // key-presses.

            IContextService contextService = PlatformUI.getWorkbench().getAdapter(IContextService.class);
            contextActivation = contextService
                    .activateContext("de.wisag.automation.micas.olt.terminal.TerminalContext"); //$NON-NLS-1$
        }

        @Override
        public void focusLost(FocusEvent event) {
            // Enable all keybindings.

            IBindingService bindingService = PlatformUI.getWorkbench().getAdapter(IBindingService.class);
            bindingService.setKeyFilterEnabled(true);

            // Restore the command context to its previous value.

            IContextService contextService = PlatformUI.getWorkbench().getAdapter(IContextService.class);
            contextService.deactivateContext(contextActivation);
        }
    }

    protected class TerminalKeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            if (getState() == TerminalState.CONNECTING) {
                return;
            }

            // We set the event.doit to false to prevent any further processing
            // of this
            // key event. The only reason this is here is because I was seeing
            // the F10
            // key both send an escape sequence (due to this method) and switch
            // focus
            // to the Workbench File menu (forcing the user to click in the
            // Terminal
            // view again to continue entering text). This fixes that.

            event.doit = false;

            char character = event.character;

            // if (!isConnected()) {
            if (fState == TerminalState.CLOSED) {
                // Pressing ENTER while not connected causes us to connect.
                if (character == '\r') {
                    connectTerminal();
                    return;
                }

                // Ignore all other keyboard input when not connected.
                // Allow other key handlers (such as Ctrl+F1) do their work
                event.doit = true;
                return;
            }

            // If the event character is NUL ('\u0000'), then a special key was
            // pressed
            // (e.g., PageUp, PageDown, an arrow key, a function key, Shift,
            // Alt,
            // Control, etc.). The one exception is when the user presses
            // Control-@,
            // which sends a NUL character, in which case we must send the NUL
            // to the
            // remote endpoint. This is necessary so that Emacs will work
            // correctly,
            // because Control-@ (i.e., NUL) invokes Emacs' set-mark-command
            // when Emacs
            // is running on a terminal. When the user presses Control-@, the
            // keyCode
            // is 50.

            if (character == '\u0000' && event.keyCode != 50) {
                // A special key was pressed. Figure out which one it was and
                // send the
                // appropriate ANSI escape sequence.
                //
                // IMPORTANT: Control will not enter this method for these
                // special keys
                // unless certain <keybinding> tags are present in the
                // plugin.xml file
                // for the Terminal view. Do not delete those tags.

                switch (event.keyCode) {
                case 0x1000001: // Up arrow.
                    sendString("\u001b[A"); //$NON-NLS-1$
                    break;

                case 0x1000002: // Down arrow.
                    sendString("\u001b[B"); //$NON-NLS-1$
                    break;

                case 0x1000003: // Left arrow.
                    sendString("\u001b[D"); //$NON-NLS-1$
                    break;

                case 0x1000004: // Right arrow.
                    sendString("\u001b[C"); //$NON-NLS-1$
                    break;

                case 0x1000005: // PgUp key.
                    sendString("\u001b[I"); //$NON-NLS-1$
                    break;

                case 0x1000006: // PgDn key.
                    sendString("\u001b[G"); //$NON-NLS-1$
                    break;

                case 0x1000007: // Home key.
                    sendString("\u001b[H"); //$NON-NLS-1$
                    break;

                case 0x1000008: // End key.
                    sendString("\u001b[F"); //$NON-NLS-1$
                    break;

                case 0x100000a: // F1 key.
                    if ((event.stateMask & SWT.CTRL) != 0) {
                        // Allow Ctrl+F1 to act locally as well as on the
                        // remote, because it is
                        // typically non-intrusive
                        event.doit = true;
                    }
                    sendString("\u001b[M"); //$NON-NLS-1$
                    break;

                case 0x100000b: // F2 key.
                    sendString("\u001b[N"); //$NON-NLS-1$
                    break;

                case 0x100000c: // F3 key.
                    sendString("\u001b[O"); //$NON-NLS-1$
                    break;

                case 0x100000d: // F4 key.
                    sendString("\u001b[P"); //$NON-NLS-1$
                    break;

                case 0x100000e: // F5 key.
                    sendString("\u001b[Q"); //$NON-NLS-1$
                    break;

                case 0x100000f: // F6 key.
                    sendString("\u001b[R"); //$NON-NLS-1$
                    break;

                case 0x1000010: // F7 key.
                    sendString("\u001b[S"); //$NON-NLS-1$
                    break;

                case 0x1000011: // F8 key.
                    sendString("\u001b[T"); //$NON-NLS-1$
                    break;

                case 0x1000012: // F9 key.
                    sendString("\u001b[U"); //$NON-NLS-1$
                    break;

                case 0x1000013: // F10 key.
                    sendString("\u001b[V"); //$NON-NLS-1$
                    break;

                case 0x1000014: // F11 key.
                    sendString("\u001b[W"); //$NON-NLS-1$
                    break;

                case 0x1000015: // F12 key.
                    sendString("\u001b[X"); //$NON-NLS-1$
                    break;

                default:
                    // Ignore other special keys. Control flows through this
                    // case when
                    // the user presses SHIFT, CONTROL, ALT, and any other key
                    // not
                    // handled by the above cases.
                    break;
                }

                // It's ok to return here, because we never locally echo special
                // keys.

                return;
            }

            // To fix SPR 110341, we consider the Alt key to be pressed only
            // when the
            // Control key is _not_ also pressed. This works around a bug in SWT
            // where,
            // on European keyboards, the AltGr key being pressed appears to us
            // as Control
            // + Alt being pressed simultaneously.

            Logger.log("stateMask = " + event.stateMask); //$NON-NLS-1$

            boolean altKeyPressed = (((event.stateMask & SWT.ALT) != 0) && ((event.stateMask & SWT.CTRL) == 0));

            if (!altKeyPressed && (event.stateMask & SWT.CTRL) != 0 && character == ' ') {
                // Send a NUL character -- many terminal emulators send NUL when
                // Control-Space is pressed. This is used to set the mark in
                // Emacs.

                character = '\u0000';
            }

            sendChar(character, altKeyPressed);

            // Special case: When we are in a TCP connection and echoing
            // characters
            // locally, send a LF after sending a CR.
            // ISSUE: Is this absolutely required?

            if (character == '\r' && getTerminalConnector() != null && isConnected()
                    && getTerminalConnector().isLocalEcho()) {
                // sendChar('\n', false);
            }

            // Now decide if we should locally echo the character we just sent.
            // We do
            // _not_ locally echo the character if any of these conditions are
            // true:
            //
            // o This is a serial connection.
            //
            // o This is a TCP connection (i.e., m_telnetConnection is not null)
            // and
            // the remote endpoint is not a TELNET server.
            //
            // o The ALT (or META) key is pressed.
            //
            // o The character is any of the first 32 ISO Latin-1 characters
            // except
            // Control-I or Control-M.
            //
            // o The character is the DELETE character.

            if (getTerminalConnector() == null || getTerminalConnector().isLocalEcho() == false || altKeyPressed
                    || (character >= '\u0001' && character < '\t') || (character > '\t' && character < '\r')
                    || (character > '\r' && character <= '\u001f') || character == '\u007f') {
                // No local echoing.
                return;
            }

            // Locally echo the character.

            StringBuffer charBuffer = new StringBuffer();
            charBuffer.append(character);

            // If the character is a carriage return, we locally echo it as a CR
            // + LF
            // combination.

            if (character == '\r') {
                charBuffer.append('\n');
            }

            writeToTerminal(charBuffer.toString());
        }

    }

    @Override
    public void setTerminalTitle(String title) {
        fTerminalListener.setTerminalTitle(title);
    }

    @Override
    public TerminalState getState() {
        return fState;
    }

    @Override
    public void setState(TerminalState state) {
        fState = state;
        fTerminalListener.setState(state);
        // enable the (blinking) cursor if the terminal is connected
        runAsyncInDisplayThread(new Runnable() {
            @Override
            public void run() {
                if (fCtlText != null && !fCtlText.isDisposed()) {
                    fCtlText.setCursorEnabled(isConnected());
                }
            }
        });
        if (TerminalState.CLOSED.equals(state)) {
            disconnectTerminal();
        }
    }

    /**
     * @param runnable
     *            run in display thread
     */
    private void runAsyncInDisplayThread(Runnable runnable) {
        if (Display.findDisplay(Thread.currentThread()) != null) {
            runnable.run();
        } else if (PlatformUI.isWorkbenchRunning()) {
            PlatformUI.getWorkbench().getDisplay().asyncExec(runnable);
            // else should not happen and we ignore it...
        }
    }

    @Override
    public String getSettingsSummary() {
        if (getTerminalConnector() != null) {
            return getTerminalConnector().getSettingsSummary();
        }
        return ""; //$NON-NLS-1$
    }

    @Override
    public void setConnector(ITerminalConnector connector) {
        fConnector = connector;

    }

    @Override
    public ICommandInputField getCommandInputField() {
        return fCommandInputField;
    }

    @Override
    public void setCommandInputField(ICommandInputField inputField) {
        if (fCommandInputField != null) {
            fCommandInputField.dispose();
        }
        fCommandInputField = inputField;
        if (fCommandInputField != null) {
            fCommandInputField.createControl(fWndParent, this);
        }
        if (fWndParent.isVisible()) {
            fWndParent.layout(true);
        }
    }

    @Override
    public int getBufferLineLimit() {
        return fTerminalModel.getMaxHeight();
    }

    @Override
    public void setBufferLineLimit(int bufferLineLimit) {
        if (bufferLineLimit <= 0) {
            return;
        }
        synchronized (fTerminalModel) {
            if (fTerminalModel.getHeight() > bufferLineLimit) {
                fTerminalModel.setDimensions(bufferLineLimit, fTerminalModel.getWidth());
            }
            fTerminalModel.setMaxHeight(bufferLineLimit);
        }
    }

    @Override
    public boolean isScrollLock() {
        return fCtlText.isScrollLock();
    }

    @Override
    public void setScrollLock(boolean on) {
        fCtlText.setScrollLock(on);
    }

    @Override
    public void setInvertedColors(boolean invert) {
        fCtlText.setInvertedColors(invert);
    }

    @Override
    public String getConnectionName() {
        if (getTerminalConnector() != null) {
            return "Micas Device " + getTerminalConnector().getSettingsSummary(); //$NON-NLS-1$
        }

        return "<Unknown device>"; //$NON-NLS-1$
    }

    @Override
    public void disconnect() {
        disconnectTerminal();

    }

    @Override
    public boolean isBusy() {
        return currentCallbackProcessor.get() != null;
    }

    @Override
    public void sendCommandWithCallback(ReadCallback readCallback) {
        CallbackProcessor callback = new CallbackProcessor(readCallback, this);
        try (CloseableReentrantLock lock = callbackProcessorLock.open()) {
            if (!currentCallbackProcessor.compareAndSet(null, callback)) {
                CallbackProcessor oldCallback = currentCallbackProcessor.get();
                oldCallback.caller().printStackTrace();
                throw new IllegalStateException("Multible callbacks are not allowed");
            }
            currentCallbackProcessor.get().begin();
        }
    }

    @Override
    public void forceRemoveOwnCallback() {
        if (callbackProcessorLock.tryLock()) {
            CallbackProcessor processor = currentCallbackProcessor.get();
            if (processor != null && processor.callerThread().getId() == Thread.currentThread().getId()) {
                currentCallbackProcessor.set(null);
            }
        }
    }

    @Override
    public void sendStringToDevice(String string) {
        System.out.println("SEND>" + string.replace("\r", "<CR>"));
        if (Display.getCurrent() != null) {
            sendString(string);
        } else {
            Display.getDefault().syncExec(() -> {
                sendString(string);
            });
        }

    }

    @Override
    public void onConnectionSynchronized() {
        if (this.controlRegistration != null) {
            // dont register twice
            return;
        }
        this.controlRegistration = getBundle(getClass()).getBundleContext().registerService(IConnectedDevice.class,
                this, null);

    }

    public void onDisconnect() {
        releaseCallbackProcessor();
        if (this.controlRegistration != null) {
            this.controlRegistration.unregister();
            this.controlRegistration = null;
        }
    }

    private void releaseCallbackProcessor() {
        try (CloseableReentrantLock lock = callbackProcessorLock.open()) {
            CallbackProcessor processor = currentCallbackProcessor.getAndSet(null);
            if (processor != null) {
                processor.signalDone();
            }
        }
    }

    @Override
    public void sendStringToUser(String string) {
        if (Display.getCurrent() != null) {
            displayTextInTerminal(string);
        } else {
            Display.getDefault().asyncExec(() -> {
                displayTextInTerminal(string);
            });
        }

    }

    @SuppressWarnings("serial")
    private static class CloseableReentrantLock extends ReentrantLock implements AutoCloseable {
        public CloseableReentrantLock open() {
            this.lock();
            return this;
        }

        @Override
        public void close() {
            this.unlock();
        }
    }
}
