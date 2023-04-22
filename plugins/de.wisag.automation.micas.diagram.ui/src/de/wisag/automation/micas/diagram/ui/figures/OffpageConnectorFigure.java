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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.figures.ICanvasContext;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentFigure;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayout;

/**
 * @author Andreas Unger
 */
public class OffpageConnectorFigure extends StandardComponentFigure implements IFigureConstants {

    private int[] points = new int[10];
    private LabelEx textLabel;

    public OffpageConnectorFigure() {
        ((StandardComponentLayout) getLayoutManager()).setHorizontalContentAlignment(SWT.LEFT);
        textLabel = new LabelEx("BLUBB");
        add(textLabel);
    }

    @Override
    public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
        if (minSize == null) {
            minSize = getPreferredCanvasSize().getCopy();
            minSize.width += minSize.height / 2
                    - ((StandardComponentLayout) getLayoutManager()).getHorizontalContentPadding();
            if (minSize.width < minSize.height * 3 / 2) {
                minSize.width = minSize.height * 3 / 2;
            }
        }
        return minSize;
    }

    @Override
    protected void paintCanvas(ICanvasContext cc) {
        Dimension size = getCanvasSize();
        // cc.setBackgroundColor(ColorConstants.darkBlue);

        cc.setLineWidth(DEFAULT_LINE_WIDTH);
        points[0] = DEFAULT_LINE_WIDTH_HALF;
        points[1] = DEFAULT_LINE_WIDTH_HALF;
        points[2] = size.width - size.height / 2 - DEFAULT_LINE_WIDTH_HALF;
        points[3] = DEFAULT_LINE_WIDTH_HALF;
        points[4] = size.width - DEFAULT_LINE_WIDTH_HALF;
        points[5] = size.height / 2;
        points[6] = points[2];
        points[7] = size.height - DEFAULT_LINE_WIDTH_HALF;
        points[8] = points[0];
        points[9] = points[7];
        cc.drawPolygon(new PointList(points));

    }

    @Override
    public IFigure getPrimaryContentFigure() {

        return textLabel;
    }
}
