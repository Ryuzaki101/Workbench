package de.wisag.automation.micas.diagram.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;

/**
 * @author Andy
 */
public class TemplateFigure extends BorderItemsAwareFreeFormLayer {

    Module module;
    private Rectangle pageBounds;
    private final int footerHeight = 1700;
    private final int lineWidth = 2;

    public TemplateFigure(Rectangle pageBounds, IMapMode mapMode, Page page) {
        this.module = page.getTask().getModule();
        this.setLayoutManager(new FreeFormLayoutEx());
        this.addLayoutListener(LayoutAnimator.getDefault());
        this.pageBounds = pageBounds;
        setBounds(pageBounds);
        createContents();

    }

    @Override
    public boolean containsPoint(int x, int y) {
        return getBounds().contains(x, y);
    }

    @Override
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        if (!isEnabled()) {
            return null;
        }
        if (!containsPoint(x, y)) {
            return null;
        }
        if (search.prune(this)) {
            return null;
        }
        IFigure child = findDescendantAtExcluding(x, y, search);
        if (child != null) {
            return child;
        }
        if (search.accept(this)) {
            return this;
        }
        return null;
    }

    private void createContents() {
        createFooterBorder();
    }

    private Point createFooterBorder() {
        RectangleFigure fig = new RectangleFigure();
        fig.setLineWidth(lineWidth);
        Point footerPos = new Point(pageBounds.x, pageBounds.height - footerHeight);
        fig.setBounds(new Rectangle(footerPos.x, footerPos.y, pageBounds.width, footerHeight));
        this.add(fig);
        return footerPos;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawRectangle(pageBounds);
    }

}
