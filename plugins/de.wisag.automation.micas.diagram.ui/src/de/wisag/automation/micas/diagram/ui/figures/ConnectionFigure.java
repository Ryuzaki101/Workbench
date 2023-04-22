package de.wisag.automation.micas.diagram.ui.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;

public class ConnectionFigure extends org.eclipselabs.damos.diagram.ui.figures.ConnectionFigure {

    private static final int JUNCTION_RADIUS = 100;

    private boolean blanked;

    public ConnectionFigure() {
        setLineWidth(DEFAULT_LINE_WIDTH);
    }

    @Override
    public boolean isVisible() {
        return !isBlanked() && super.isVisible();
    }

    public boolean isBlanked() {
        return blanked;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipselabs.damos.diagram.ui.internal.figures.IBlankableFigure#
     * setBlank(boolean)
     */
    public void setBlanked(boolean blanked) {
        this.blanked = blanked;
        revalidate();
        repaint();
    }

    public void setTargetDecorationVisible(boolean visible) {
        if (visible != (getTargetDecoration() != null)) {
            setTargetDecoration(visible ? new TargetDecoration() : null);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.draw2d.Shape#paintFigure(org.eclipse.draw2d.Graphics)
     */
    @Override
    public void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);
        if (hasJunction()) {
            Point p = getPoints().getPoint(1);
            graphics.setBackgroundColor(graphics.getForegroundColor());
            graphics.fillOval(p.x - JUNCTION_RADIUS, p.y - JUNCTION_RADIUS, 2 * JUNCTION_RADIUS, 2 * JUNCTION_RADIUS);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#
     * getSmoothPoints(boolean)
     */
    @Override
    public PointList getSmoothPoints(boolean calculateAppox) {
        PointList points = PointListUtilities.copyPoints(getPoints());
        if (points.size() > 0 && hasJunction()) {
            points.removePoint(0);
        }
        return points;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.draw2d.Figure#findFigureAt(int, int,
     * org.eclipse.draw2d.TreeSearch)
     */
    @Override
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        IFigure figure = findTerminalFigure(getSourceAnchor(), x, y);
        if (figure == null) {
            figure = findTerminalFigure(getTargetAnchor(), x, y);
        }
        if (figure != null) {
            return figure;
        }
        return super.findFigureAt(x, y, search);
    }

    private TerminalFigure findTerminalFigure(ConnectionAnchor anchor, int x, int y) {
        // if (anchor instanceof IConnectorAnchor) {
        // IConnectorAnchor connectorAnchor = (IConnectorAnchor) anchor;
        // IConnectorFigure connectorFigure =
        // connectorAnchor.getConnectorFigure();
        // TerminalFigure terminalFigure = connectorFigure.getTerminalFigure();
        // if (terminalFigure != null) {
        // Point p = new PrecisionPoint(x, y);
        // translateToAbsolute(p);
        // terminalFigure.translateToRelative(p);
        // if (terminalFigure.containsPoint(p)) {
        // return terminalFigure;
        // }
        // }
        // }
        return null;
    }

    private boolean hasJunction() {
        boolean foundThis = false;
        for (Object o : getParent().getChildren()) {
            if (o == this) {
                foundThis = true;
                continue;
            }
            if (o instanceof ConnectionFigure) {
                ConnectionFigure connectionFigure = (ConnectionFigure) o;
                if (connectionFigure.isVisible()
                        && connectionFigure.getSourceAnchor().getOwner() == getSourceAnchor().getOwner()
                        && connectionFigure.getStart().equals(getStart())) {
                    Point junctionPoint = getPoints().getPoint(1);
                    Point otherPoint1 = connectionFigure.getPoints().getPoint(0);
                    Point otherPoint2 = connectionFigure.getPoints().getPoint(1);
                    if (junctionPoint.x == otherPoint2.x) {
                        int otherY1 = Math.min(otherPoint1.y, otherPoint2.y);
                        int otherY2 = Math.max(otherPoint1.y, otherPoint2.y);
                        if (foundThis && (junctionPoint.y == otherY1 || junctionPoint.y == otherY2)) {
                            return true;
                        } else if (junctionPoint.y > otherY1 && junctionPoint.y < otherY2) {
                            return true;
                        }
                    } else if (junctionPoint.y == otherPoint2.y) {
                        int otherX1 = Math.min(otherPoint1.x, otherPoint2.x);
                        int otherX2 = Math.max(otherPoint1.x, otherPoint2.x);
                        if (foundThis && (junctionPoint.x == otherX1 && junctionPoint.x == otherX2)) {
                            return true;
                        } else if (junctionPoint.x > otherX1 && junctionPoint.x < otherX2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * @author Andreas Unger
     */
    private static final class TargetDecoration extends PolygonDecoration {

        private static final double DECORATION_SCALE_X = 7 * DEFAULT_LINE_WIDTH;
        private static final double DECORATION_SCALE_Y = 3 * DEFAULT_LINE_WIDTH;

        /**
         *
         */
        public TargetDecoration() {
            setScale(DECORATION_SCALE_X, DECORATION_SCALE_Y);
        }

        @Override
        public Rectangle getBounds() {
            return super.getBounds().getExpanded(DEFAULT_LINE_WIDTH, DEFAULT_LINE_WIDTH);
        }

    }

}
