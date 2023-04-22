/*******************************************************************************
 * Copyright (c) 2007 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse synchronized public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Michael Scharf (Wind River) - initial API and implementation
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.model;

import de.wisag.automation.micas.olt.terminal.model.ITerminalTextData;
import de.wisag.automation.micas.olt.terminal.model.ITerminalTextDataSnapshot;
import de.wisag.automation.micas.olt.terminal.model.LineSegment;
import de.wisag.automation.micas.olt.terminal.model.Style;

/**
 * This is a decorator to make all access to ITerminalTextData synchronized
 */
public class SynchronizedTerminalTextData implements ITerminalTextData {
    final ITerminalTextData fData;

    public SynchronizedTerminalTextData(ITerminalTextData data) {
        fData = data;
    }

    @Override
    synchronized public void addLine() {
        fData.addLine();
    }

    @Override
    synchronized public void cleanLine(int line) {
        fData.cleanLine(line);
    }

    @Override
    synchronized public void copy(ITerminalTextData source) {
        fData.copy(source);
    }

    @Override
    synchronized public void copyLine(ITerminalTextData source, int sourceLine, int destLine) {
        fData.copyLine(source, sourceLine, destLine);
    }

    @Override
    synchronized public void copyRange(ITerminalTextData source, int sourceStartLine, int destStartLine, int length) {
        fData.copyRange(source, sourceStartLine, destStartLine, length);
    }

    @Override
    synchronized public char getChar(int line, int column) {
        return fData.getChar(line, column);
    }

    @Override
    synchronized public char[] getChars(int line) {
        return fData.getChars(line);
    }

    @Override
    synchronized public int getCursorColumn() {
        return fData.getCursorColumn();
    }

    @Override
    synchronized public int getCursorLine() {
        return fData.getCursorLine();
    }

    @Override
    synchronized public int getHeight() {
        return fData.getHeight();
    }

    @Override
    synchronized public LineSegment[] getLineSegments(int line, int startCol, int numberOfCols) {
        return fData.getLineSegments(line, startCol, numberOfCols);
    }

    @Override
    synchronized public int getMaxHeight() {
        return fData.getMaxHeight();
    }

    @Override
    synchronized public Style getStyle(int line, int column) {
        return fData.getStyle(line, column);
    }

    @Override
    synchronized public Style[] getStyles(int line) {
        return fData.getStyles(line);
    }

    @Override
    synchronized public int getWidth() {
        return fData.getWidth();
    }

    @Override
    synchronized public ITerminalTextDataSnapshot makeSnapshot() {
        return fData.makeSnapshot();
    }

    @Override
    synchronized public void scroll(int startLine, int size, int shift) {
        fData.scroll(startLine, size, shift);
    }

    @Override
    synchronized public void setChar(int line, int column, char c, Style style) {
        fData.setChar(line, column, c, style);
    }

    @Override
    synchronized public void setChars(int line, int column, char[] chars, int start, int len, Style style) {
        fData.setChars(line, column, chars, start, len, style);
    }

    @Override
    synchronized public void setChars(int line, int column, char[] chars, Style style) {
        fData.setChars(line, column, chars, style);
    }

    @Override
    synchronized public void setCursorColumn(int column) {
        fData.setCursorColumn(column);
    }

    @Override
    synchronized public void setCursorLine(int line) {
        fData.setCursorLine(line);
    }

    @Override
    synchronized public void setDimensions(int height, int width) {
        fData.setDimensions(height, width);
    }

    @Override
    synchronized public void setMaxHeight(int height) {
        fData.setMaxHeight(height);
    }
}
