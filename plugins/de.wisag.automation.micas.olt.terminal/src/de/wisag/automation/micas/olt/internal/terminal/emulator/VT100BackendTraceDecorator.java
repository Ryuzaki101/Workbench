/*******************************************************************************
 * Copyright (c) 2007 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Michael Scharf (Wind River) - initial API and implementation
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.emulator;

import java.io.PrintStream;

import de.wisag.automation.micas.olt.terminal.model.Style;

public class VT100BackendTraceDecorator implements IVT100EmulatorBackend {
    final IVT100EmulatorBackend fBackend;
    final PrintStream fWriter;

    public VT100BackendTraceDecorator(IVT100EmulatorBackend backend, PrintStream out) {
        fBackend = backend;
        fWriter = out;
    }

    @Override
    public void appendString(String buffer) {
        fWriter.println("appendString(\"" + buffer + "\")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.appendString(buffer);
    }

    @Override
    public void clearAll() {
        fWriter.println("clearAll()"); //$NON-NLS-1$
        fBackend.clearAll();
    }

    @Override
    public void deleteCharacters(int n) {
        fWriter.println("deleteCharacters(" + n + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.deleteCharacters(n);
    }

    @Override
    public void deleteLines(int n) {
        fWriter.println("deleteLines(" + n + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.deleteLines(n);
    }

    @Override
    public void eraseAll() {
        fWriter.println("eraseAll()"); //$NON-NLS-1$
        fBackend.eraseAll();
    }

    @Override
    public void eraseLine() {
        fWriter.println("eraseLine()"); //$NON-NLS-1$
        fBackend.eraseLine();
    }

    @Override
    public void eraseLineToCursor() {
        fWriter.println("eraseLineToCursor()"); //$NON-NLS-1$
        fBackend.eraseLineToCursor();
    }

    @Override
    public void eraseLineToEnd() {
        fWriter.println("eraseLineToEnd()"); //$NON-NLS-1$
        fBackend.eraseLineToEnd();
    }

    @Override
    public void eraseToCursor() {
        fWriter.println("eraseToCursor()"); //$NON-NLS-1$
        fBackend.eraseToCursor();
    }

    @Override
    public void eraseToEndOfScreen() {
        fWriter.println("eraseToEndOfScreen()"); //$NON-NLS-1$
        fBackend.eraseToEndOfScreen();
    }

    @Override
    public int getColumns() {
        return fBackend.getColumns();
    }

    @Override
    public int getCursorColumn() {
        return fBackend.getCursorColumn();
    }

    @Override
    public int getCursorLine() {
        return fBackend.getCursorLine();
    }

    @Override
    public Style getDefaultStyle() {
        return fBackend.getDefaultStyle();
    }

    @Override
    public int getLines() {
        return fBackend.getLines();
    }

    @Override
    public Style getStyle() {
        return fBackend.getStyle();
    }

    @Override
    public void insertCharacters(int charactersToInsert) {
        fWriter.println("insertCharacters(" + charactersToInsert + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.insertCharacters(charactersToInsert);
    }

    @Override
    public void insertLines(int n) {
        fWriter.println("insertLines(" + n + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.insertLines(n);
    }

    @Override
    public void processNewline() {
        fWriter.println("processNewline()"); //$NON-NLS-1$
        fBackend.processNewline();
    }

    @Override
    public void setCursor(int targetLine, int targetColumn) {
        fWriter.println("setCursor(" + targetLine + ", " + targetColumn + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        fBackend.setCursor(targetLine, targetColumn);
    }

    @Override
    public void setCursorColumn(int targetColumn) {
        fWriter.println("setCursorColumn(" + targetColumn + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.setCursorColumn(targetColumn);
    }

    @Override
    public void setCursorLine(int targetLine) {
        fWriter.println("setCursorLine(" + targetLine + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.setCursorLine(targetLine);
    }

    @Override
    public void setDefaultStyle(Style defaultStyle) {
        fWriter.println("setDefaultStyle(" + defaultStyle + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.setDefaultStyle(defaultStyle);
    }

    @Override
    public void setDimensions(int lines, int cols) {
        fWriter.println("setDimensions(" + lines + "," + cols + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        fBackend.setDimensions(lines, cols);
    }

    @Override
    public void setStyle(Style style) {
        fWriter.println("setStyle(" + style + ")"); //$NON-NLS-1$ //$NON-NLS-2$
        fBackend.setStyle(style);
    }

}
