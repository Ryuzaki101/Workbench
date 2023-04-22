package de.wisag.automation.micas.diagram.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.figures.FBComponentLayout;
import org.eclipselabs.damos.diagram.ui.figures.FBComponentLayoutData;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.diagram.ui.figures.RectangularComponentFigure;

public class BlockFigure extends RectangularComponentFigure {

    private Label headerLabel;
    private Label indexLabel;

    public BlockFigure() {
        FBComponentLayout layout = new FBComponentLayout();
        layout.setEqualPortExtents(true);
        layout.setBottomFooterPadding(IFigureConstants.DEFAULT_LINE_WIDTH_HALF);
        layout.setHorizontalFooterPadding(IFigureConstants.DEFAULT_LINE_WIDTH_HALF);
        setLayoutManager(layout);

        headerLabel = new HeaderFigure();
        add(headerLabel, new FBComponentLayoutData(FBComponentLayoutData.HEADER, SWT.FILL, SWT.FILL));
        add(new LabelEx(), new FBComponentLayoutData(FBComponentLayoutData.BODY, SWT.FILL, SWT.FILL));

        indexLabel = new LabelEx();
        indexLabel.setOpaque(true);
        indexLabel.setForegroundColor(ColorConstants.white);
        indexLabel.setBackgroundColor(ColorConstants.black);
        add(indexLabel, new FBComponentLayoutData(FBComponentLayoutData.FOOTER, SWT.END, SWT.END));
    }

    public void setHeaderText(String text) {
        headerLabel.setText(text);
    }

    public void setIndex(int index) {
        indexLabel.setText(Integer.toString(index));
    }

    private static class HeaderFigure extends LabelEx {

        @Override
        protected void paintFigure(Graphics g) {
            super.paintFigure(g);
            Rectangle bounds = getBounds();
            g.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
            g.drawLine(bounds.x, bounds.bottom(), bounds.right(), bounds.bottom());
        }

    }

}
