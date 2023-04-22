package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.multipdf.LayerUtility;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.util.Matrix;
import org.eclipse.core.runtime.CoreException;

import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.ui.internal.printing.ByteArrayPageData;
import de.wisag.automation.micas.module.ui.internal.printing.IFKGPageCreator;
import de.wisag.automation.micas.module.ui.internal.printing.IPdfEngine;
import de.wisag.automation.micas.module.ui.internal.printing.OutputPage;
import de.wisag.automation.micas.module.ui.internal.printing.PageData;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateDrawingArea;

public class PdfboxEngine implements IPdfEngine {

    @Override
    public List<OutputPage> createTableOfContentPages(TemplateDrawingArea drawingArea, List<OutputPage> pages)
            throws CoreException {
        return new PdfBoxTableOfContentCreator(drawingArea, pages).create();
    }

    @Override
    public PageData placeContentOnPage(TemplateDrawingArea drawingArea, Format format, PageData background,
            PageData content) throws CoreException {

        try (PDDocument backgroundPage = PDDocument.load((byte[]) background.getPageData());

                PDDocument overlayDocument = PDDocument.load((byte[]) content.getPageData());) {
            PDRectangle diagBB = overlayDocument.getPage(0).getBBox();

            LayerUtility layerUtility = new LayerUtility(backgroundPage);

            float diagHeightFromPdf = diagBB.getHeight();

            float newX = drawingArea.getX() + (drawingArea.getWidth() - diagBB.getWidth()) / 2;
            float newY = 0f;
            if (format == Format.A4) {
                newY = (drawingArea.getHeight() - diagHeightFromPdf) / 2;
            } else {
                newY = (drawingArea.getHeight() - diagHeightFromPdf) / 2;
            }

            PDFormXObject form = layerUtility.importPageAsForm(overlayDocument, 0);

            try (PDPageContentStream contents = new PDPageContentStream(backgroundPage, backgroundPage.getPage(0),
                    AppendMode.APPEND, true)) {

                contents.saveGraphicsState();
                Matrix flipVert = Matrix.getScaleInstance(1f, -1f);
                flipVert.translate(0, -1 * diagBB.getHeight());

                Matrix move = Matrix.getTranslateInstance(newX, newY);
                contents.transform(Matrix.concatenate(move, flipVert));
                contents.drawForm(form);
                contents.restoreGraphicsState();
            }
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            backgroundPage.save(output);
            return new ByteArrayPageData(output.toByteArray());
        } catch (IOException e) {
            throw new CoreException(Policy.errorStatus("Place content failed", e));
        }

    }

    @Override
    public void mergeThemAll(List<OutputPage> pages, OutputStream out) throws CoreException {
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        for (OutputPage outputPage : pages) {
            if (outputPage.getFinalPageData() == null) {
                Policy.logError(String.format("No final pagedata for page %s,type=%s", outputPage.getTitle(),
                        outputPage.getType()), null);
            }
            mergerUtility.addSource(new ByteArrayInputStream((byte[]) outputPage.getFinalPageData().getPageData()));
        }
        mergerUtility.setDestinationStream(out);
        try {
            mergerUtility.mergeDocuments(null);
        } catch (IOException e) {
            throw new CoreException(Policy.errorStatus("Merge documents failed", e));
        }
    }

    @Override
    public IFKGPageCreator getFKGPageCreator() {
        return new PdfboxFKGPageCreator();
    }

}
