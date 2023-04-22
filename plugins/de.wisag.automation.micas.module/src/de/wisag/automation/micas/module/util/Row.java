package de.wisag.automation.micas.module.util;

import de.wisag.automation.micas.common.model.AbstractModelObject;

public class Row extends AbstractModelObject {
    public static final String PROP_Y = "y";
    public static final String PROP_X = "x";
    private double x;
    private double y;

    public Row(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        firePropertyChange(PROP_X, this.x, this.x = x);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        firePropertyChange(PROP_Y, this.y, this.y = y);
    }

    @Override
    public String toString() {
        return "Row [x=" + x + ", y=" + y + "]";
    }

}