package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.google.common.collect.Lists;

import de.wisag.automation.micas.module.ui.internal.printing.OutputPage;
import de.wisag.automation.micas.module.ui.internal.printing.OutputPage.Type;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateDrawingArea;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateUtil;

public class PdfBoxTableOfContentCreator {
    private final TemplateDrawingArea drawingArea;
    private final List<OutputPage> pages;

    public PdfBoxTableOfContentCreator(TemplateDrawingArea drawingArea, List<OutputPage> pages) {
        super();
        this.drawingArea = drawingArea;
        this.pages = pages;
    }

    public TemplateDrawingArea getDrawingArea() {
        return drawingArea;
    }

    public List<OutputPage> getPages() {
        return pages;
    }

    public List<OutputPage> create() throws CoreException {

        List<PdfboxTableOfContent.PageEntry> entries = Lists.newArrayList();

        for (OutputPage outputPage : getPages()) {
            if (outputPage.getType() == Type.BANNER) {
                continue;
            }
            if (outputPage.getType() == Type.CONTENT) {
                continue;
            }
            entries.add(new PdfboxTableOfContent.PageEntry(outputPage.getTitle(), outputPage.getNo()));
        }
        PdfboxTableOfContent content = new PdfboxTableOfContent();
        SvgDocumentTemplate template = TemplateUtil.loadTemplate("template", Format.A3);
        return content.generate(template.getDiagramArea(), entries);
    }

}
