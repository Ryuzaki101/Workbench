/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation
 ****************************************************************************/

package de.wisag.automation.micas.diagram.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentFigure;

public class ReferenceFigure extends StandardComponentFigure implements IFigureConstants {

    public ReferenceFigure() {
        add(new LabelEx());
    }

    @Override
    protected void paintCanvas(ICanvasContext cc) {
        Dimension size = getCanvasSize();
        cc.setLineWidth(DEFAULT_LINE_WIDTH);
        cc.drawRoundRectangle(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF, size.width - DEFAULT_LINE_WIDTH,
                size.height - DEFAULT_LINE_WIDTH, size.height, size.height);
    }

}