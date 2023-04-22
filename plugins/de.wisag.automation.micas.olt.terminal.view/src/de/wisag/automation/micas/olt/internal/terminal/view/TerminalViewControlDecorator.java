/*******************************************************************************
 * Copyright (c) 2008 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Michael Scharf (Wind River) - initial API and implementation
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.view;

import java.io.UnsupportedEncodingException;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Control;

import de.wisag.automation.micas.olt.internal.terminal.control.ICommandInputField;
import de.wisag.automation.micas.olt.internal.terminal.control.ITerminalViewControl;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ITerminalConnector;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.TerminalState;

// TODO (scharf): this decorator is only there to deal with the common
// actions. Find a better solution.
public class TerminalViewControlDecorator implements ITerminalViewControl {
    ITerminalViewControl fViewContoler;

    @Override
    public void clearTerminal() {
        fViewContoler.clearTerminal();
    }

    @Override
    public void connectTerminal() {
        fViewContoler.connectTerminal();
    }

    @Override
    public void copy() {
        fViewContoler.copy();
    }

    @Override
    public void disconnectTerminal() {
        fViewContoler.disconnectTerminal();
    }

    @Override
    public void disposeTerminal() {
        fViewContoler.disposeTerminal();
    }

    @Override
    public int getBufferLineLimit() {
        return fViewContoler.getBufferLineLimit();
    }

    @Override
    public Clipboard getClipboard() {
        return fViewContoler.getClipboard();
    }

    @Override
    public ICommandInputField getCommandInputField() {
        return fViewContoler.getCommandInputField();
    }

    @Override
    public ITerminalConnector[] getConnectors() {
        return fViewContoler.getConnectors();
    }

    @Override
    public Control getControl() {
        return fViewContoler.getControl();
    }

    @Override
    public String getEncoding() {
        return fViewContoler.getEncoding();
    }

    @Override
    public Font getFont() {
        return fViewContoler.getFont();
    }

    @Override
    public Control getRootControl() {
        return fViewContoler.getRootControl();
    }

    @Override
    public String getSelection() {
        return fViewContoler.getSelection();
    }

    @Override
    public String getSettingsSummary() {
        return fViewContoler.getSettingsSummary();
    }

    @Override
    public TerminalState getState() {
        return fViewContoler.getState();
    }

    @Override
    public ITerminalConnector getTerminalConnector() {
        return fViewContoler.getTerminalConnector();
    }

    @Override
    public boolean isConnected() {
        return fViewContoler.isConnected();
    }

    @Override
    public boolean isDisposed() {
        return fViewContoler.isDisposed();
    }

    @Override
    public boolean isEmpty() {
        return fViewContoler.isEmpty();
    }

    @Override
    public boolean isScrollLock() {
        return fViewContoler.isScrollLock();
    }

    @Override
    public void paste() {
        fViewContoler.paste();
    }

    @Override
    public boolean pasteString(String string) {
        return fViewContoler.pasteString(string);
    }

    @Override
    public void selectAll() {
        fViewContoler.selectAll();
    }

    @Override
    public void sendKey(char arg0) {
        fViewContoler.sendKey(arg0);
    }

    @Override
    public void setBufferLineLimit(int bufferLineLimit) {
        fViewContoler.setBufferLineLimit(bufferLineLimit);
    }

    @Override
    public void setCommandInputField(ICommandInputField inputField) {
        fViewContoler.setCommandInputField(inputField);
    }

    @Override
    public void setConnector(ITerminalConnector connector) {
        fViewContoler.setConnector(connector);
    }

    @Override
    public void setEncoding(String encoding) throws UnsupportedEncodingException {
        fViewContoler.setEncoding(encoding);
    }

    @Override
    public void setFocus() {
        fViewContoler.setFocus();
    }

    @Override
    public void setFont(Font font) {
        fViewContoler.setFont(font);
    }

    @Override
    public void setInvertedColors(boolean invert) {
        fViewContoler.setInvertedColors(invert);
    }

    @Override
    public void setScrollLock(boolean on) {
        fViewContoler.setScrollLock(on);
    }

    public ITerminalViewControl getViewContoler() {
        return fViewContoler;
    }

    public void setViewContoler(ITerminalViewControl viewContoler) {
        fViewContoler = viewContoler;
    }
}
