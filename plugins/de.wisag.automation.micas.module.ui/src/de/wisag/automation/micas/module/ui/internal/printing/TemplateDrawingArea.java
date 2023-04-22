package de.wisag.automation.micas.module.ui.internal.printing;

public class TemplateDrawingArea {
    private final float x;
    private final float y;
    private final float width;
    private final float height;

    public TemplateDrawingArea(float x, float y, float width, float height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}