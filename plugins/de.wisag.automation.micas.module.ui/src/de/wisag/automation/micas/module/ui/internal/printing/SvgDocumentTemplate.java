package de.wisag.automation.micas.module.ui.internal.printing;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class SvgDocumentTemplate {
    public enum Format {
        A3, A4, UNKNOWN
    }

    private final Format format;
    private final Document document;
    private final TemplateDrawingArea diagramArea;

    public SvgDocumentTemplate(Document document, TemplateDrawingArea diagramArea, Format format) {
        super();
        this.document = document;
        this.diagramArea = diagramArea;
        this.format = format;
    }

    public SvgDocumentTemplate getDocumentCopy() {
        DOMImplementation impl = document.getImplementation();
        Document documentCopy = impl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        documentCopy.replaceChild(documentCopy.importNode(document.getDocumentElement(), true),
                documentCopy.getDocumentElement());

        return new SvgDocumentTemplate(documentCopy, this.diagramArea, format);
    }

    public TemplateDrawingArea getDiagramArea() {
        return diagramArea;
    }

    public Document getDocument() {
        return document;
    }

    public Format getFormat() {
        return format;
    }
}