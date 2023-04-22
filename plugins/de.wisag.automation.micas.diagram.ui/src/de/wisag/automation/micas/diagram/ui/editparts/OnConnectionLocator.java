package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;

/**
 * This locator places the figure on the connection, a specified percentage of
 * the connection length away from the source end.
 */
public class OnConnectionLocator extends ConnectionLocator {

    /** percentage away from source end */
    private final int percentageFromSource;

    /**
     * Constructor for <code>OnConnectionLocator</code>.
     *
     * @param connection
     *            the parent <code>Connection</code> figure
     * @param percentageFromSource
     *            percentage of the connection length away from the source end
     *            (range is from 0 to 100)
     */
    public OnConnectionLocator(Connection connection, int percentageFromSource) {

        super(connection);
        this.percentageFromSource = percentageFromSource;
    }

    /**
     * Puts the figure a percentage of the connection length away from the
     * source end.
     *
     * @see org.eclipse.draw2d.ConnectionLocator#getLocation(PointList)
     */
    @Override
    protected Point getLocation(PointList points) {
        Point p = PointListUtilities.calculatePointRelativeToLine(PointListUtilities.copyPoints(points), 0,
                getPercentageFromSource(), true);
        return p;
    }

    /**
     * Gets the value of <code>percentageFromSource</code>.
     *
     * @return int the value of <code>percentageFromSource</code>
     */
    protected int getPercentageFromSource() {
        return this.percentageFromSource;
    }

}