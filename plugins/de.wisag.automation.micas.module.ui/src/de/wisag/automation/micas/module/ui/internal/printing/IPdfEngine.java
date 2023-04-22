package de.wisag.automation.micas.module.ui.internal.printing;

import java.io.OutputStream;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;

public interface IPdfEngine {

    List<OutputPage> createTableOfContentPages(TemplateDrawingArea drawingArea, List<OutputPage> pages)
            throws CoreException;

    PageData placeContentOnPage(TemplateDrawingArea drawingArea, Format format, PageData filledTemplatePdf,
            PageData contentPdf) throws CoreException;

    void mergeThemAll(List<OutputPage> pages, OutputStream out) throws CoreException;

    IFKGPageCreator getFKGPageCreator();

}
