package de.wisag.automation.micas.module.ui.internal.printing;

import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;

public class PageBackground {
    private PageData filledTemplatePdf;
    private TemplateDrawingArea diagramArea;
    private final Format format;

    public PageData getFilledTemplatePdf() {
        return filledTemplatePdf;
    }

    public TemplateDrawingArea getDiagramArea() {
        return diagramArea;
    }

    public PageBackground(PageData filledTemplatePdf, TemplateDrawingArea diagramArea, Format format) {
        super();
        this.filledTemplatePdf = filledTemplatePdf;
        this.diagramArea = diagramArea;
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }
}