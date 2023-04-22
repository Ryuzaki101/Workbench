/*******************************************************************************
 * Copyright (c) 2008, 2009 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Michael Scharf (Wind River) - initial API and implementation
 * Michael Scharf (Wind River) - [240097] Allow paste with the middle mouse button
 * Michael Scharf (Wind River) - [262996] get rid of TerminalState.OPENED
 *******************************************************************************/
/**
 *
 */
package de.wisag.automation.micas.olt.internal.terminal.view;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import de.wisag.automation.micas.olt.internal.terminal.control.CommandInputFieldWithHistory;
import de.wisag.automation.micas.olt.internal.terminal.control.ITerminalViewControl;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ISettingsStore;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ITerminalConnector;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.TerminalState;

/**
 * This class represents one connection. The connection might be closed or open.
 */
class TerminalViewConnection implements ITerminalViewConnection {
    private static final String STORE_SUMMARY = "Summary"; //$NON-NLS-1$
    private static final String STORE_PART_NAME = "PartName"; //$NON-NLS-1$
    private static final String STORE_CONNECTION_TYPE = "ConnectionType"; //$NON-NLS-1$
    private static final String STORE_HAS_COMMAND_INPUT_FIELD = "HasCommandInputField"; //$NON-NLS-1$
    private static final String STORE_COMMAND_INPUT_FIELD_HISTORY = "CommandInputFieldHistory"; //$NON-NLS-1$

    final private ITerminalViewControl fCtlTerminal;
    private String fTitle;
    private String fSummary;
    private String fHistory;
    private CommandInputFieldWithHistory fCommandInputField;
    private String fPartName;

    public TerminalViewConnection(ITerminalViewControl ctl) {
        fCtlTerminal = ctl;
        fCtlTerminal.getControl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseUp(MouseEvent e) {
                // paste when the middle button is clicked
                if (e.button == 2) {
                    fCtlTerminal.paste();
                }
            }
        });
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.actions.
     * ITerminalViewConnection#getName()
     */
    @Override
    public String getFullSummary() {
        // if the title is set, then we return the title, else the summary
        if (fTitle == null) {
            return makeSummary();
        }
        return fTitle;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.olt.internal.terminal.view.
     * ITerminalViewConnection#getImageDescriptor()
     */
    @Override
    public ImageDescriptor getImageDescriptor() {
        return TerminalViewPlugin.getDefault().getImageRegistry().getDescriptor(ImageConsts.IMAGE_TERMINAL_VIEW);
    }

    @Override
    public ITerminalViewControl getCtlTerminal() {
        return fCtlTerminal;
    }

    private ISettingsStore getStore(ISettingsStore store, ITerminalConnector connector) {
        return new SettingStorePrefixDecorator(store, connector.getId() + "."); //$NON-NLS-1$
    }

    @Override
    public void loadState(ISettingsStore store) {
        fPartName = store.get(STORE_PART_NAME);
        fSummary = store.get(STORE_SUMMARY);
        fHistory = store.get(STORE_COMMAND_INPUT_FIELD_HISTORY);

        // load the state of the connection types
        ITerminalConnector[] connectors = fCtlTerminal.getConnectors();
        String connectionType = store.get(STORE_CONNECTION_TYPE);
        for (int i = 0; i < connectors.length; i++) {
            connectors[i].load(getStore(store, connectors[i]));
            // if this is active connection type
            if (connectors[i].getId().equals(connectionType)) {
                fCtlTerminal.setConnector(connectors[i]);
            }
        }

        if ("true".equals(store.get(STORE_HAS_COMMAND_INPUT_FIELD))) {
            setCommandInputField(true);
        }
    }

    @Override
    public void saveState(ISettingsStore store) {
        store.put(STORE_PART_NAME, fPartName);
        store.put(STORE_SUMMARY, fSummary);
        store.put(STORE_COMMAND_INPUT_FIELD_HISTORY, fHistory);
        if (fCommandInputField != null) {
            store.put(STORE_COMMAND_INPUT_FIELD_HISTORY, fCommandInputField.getHistory());
        } else {
            store.put(STORE_COMMAND_INPUT_FIELD_HISTORY, fHistory);
        }
        store.put(STORE_HAS_COMMAND_INPUT_FIELD, hasCommandInputField() ? "true" : "false"); //$NON-NLS-1$//$NON-NLS-2$
        ITerminalConnector[] connectors = fCtlTerminal.getConnectors();
        for (int i = 0; i < connectors.length; i++) {
            connectors[i].save(getStore(store, connectors[i]));
        }
        if (fCtlTerminal.getTerminalConnector() != null) {
            store.put(STORE_CONNECTION_TYPE, fCtlTerminal.getTerminalConnector().getId());
        }
    }

    @Override
    public boolean hasCommandInputField() {
        return fCommandInputField != null;
    }

    @Override
    public void setCommandInputField(boolean on) {
        // save the old history
        if (fCommandInputField != null) {
            fHistory = fCommandInputField.getHistory();
            fCommandInputField = null;
        }
        if (on) {
            // TODO make history size configurable
            fCommandInputField = new CommandInputFieldWithHistory(100);
            fCommandInputField.setHistory(fHistory);
        }
        fCtlTerminal.setCommandInputField(fCommandInputField);
    }

    @Override
    public void setState(TerminalState state) {
        // update the title....
        fTitle = null;
    }

    @Override
    public void setTerminalTitle(String title) {
        // When parameter 'title' is not null, it is a String containing text to
        // display in the view's content description line. This is used by class
        // TerminalText when it processes an ANSI OSC escape sequence that
        // commands
        // the terminal to display text in its title bar.
        fTitle = title;
    }

    private String getStateDisplayName(TerminalState state) {
        if (state == TerminalState.CONNECTED) {
            return ViewMessages.STATE_CONNECTED;
        } else if (state == TerminalState.CONNECTING) {
            return ViewMessages.STATE_CONNECTING;
        } else if (state == TerminalState.CLOSED) {
            return ViewMessages.STATE_CLOSED;
        } else {
            throw new IllegalStateException(state.toString());
        }
    }

    private String makeSummary() {
        String strTitle = ""; //$NON-NLS-1$
        if (fCtlTerminal.getTerminalConnector() == null) {
            strTitle = ViewMessages.NO_CONNECTION_SELECTED;
        } else {
            // When parameter 'data' is null, we construct a descriptive string
            // to
            // display in the content description line.
            String strConnected = getStateDisplayName(fCtlTerminal.getState());
            String summary = getSettingsSummary();
            // TODO Title should use an NLS String and com.ibm.icu.MessageFormat
            // In order to make the logic of assembling, and the separators,
            // better adapt to foreign languages
            if (summary.length() > 0) {
                summary = summary + " - "; //$NON-NLS-1$
            }
            String name = fCtlTerminal.getTerminalConnector().getName();
            if (name.length() > 0) {
                name += ": "; //$NON-NLS-1$
            }
            strTitle = name + "(" + summary + strConnected + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return strTitle;
    }

    /**
     * @return the setting summary. If there is no connection, or the connection
     *         has not been initialized, use the last stored state.
     */
    private String getSettingsSummary() {
        if (fCtlTerminal.getTerminalConnector().isInitialized()) {
            fSummary = fCtlTerminal.getSettingsSummary();
        }
        if (fSummary == null) {
            return ""; //$NON-NLS-1$
        }
        return fSummary;
    }

    @Override
    public void setSummary(String summary) {
        fSummary = summary;
    }

    @Override
    public String getPartName() {
        return fPartName == null ? ViewMessages.PROP_TITLE : fPartName;
    }

    @Override
    public void setPartName(String name) {
        fPartName = name;

    }

}