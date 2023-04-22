package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.eclipse.core.runtime.CoreException;

import com.google.common.collect.Lists;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.ui.internal.printing.ByteArrayPageData;
import de.wisag.automation.micas.module.ui.internal.printing.OutputPage;
import de.wisag.automation.micas.module.ui.internal.printing.OutputPage.Type;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateDrawingArea;

public class PdfboxTableOfContent {
    private static final String HEADING = "Inhalt";

    public static class PageEntry {
        private final String title;
        private final int pageNumber;

        public PageEntry(String title, int pageNumber) {
            super();
            this.title = title;
            this.pageNumber = pageNumber;
        }

        public String getTitle() {
            return title;
        }

        public int getPageNumber() {
            return pageNumber;
        }
    }

    List<OutputPage> generate(TemplateDrawingArea area, List<PageEntry> pageEntries) throws CoreException {
        // Set margins
        float margin = 10;
        float leftMargin = 2;
        // Initialize Document

        try (PDDocument doc = new PDDocument()) {
            float width = area.getWidth();
            PDPage page = addNewPage(doc, Math.round((width - area.getX()) * 0.25f), area.getHeight() - area.getY());
            float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
            // Initialize table
            float tableWidth = page.getMediaBox().getWidth() - (2 * leftMargin);
            boolean drawContent = true;
            float yStart = yStartNewPage;
            float bottomMargin = margin;
            BaseTable table = new BaseTable(yStart, //
                    yStartNewPage, //
                    bottomMargin, //
                    tableWidth, //
                    leftMargin, //
                    doc, //
                    page, //
                    true, //
                    drawContent);

            // Create Header row
            // Create Header row
            Row<PDPage> headerRow = table.createRow(15f);
            Cell<PDPage> cell = headerRow.createCell(100f, HEADING);
            cell.setFont(PDType1Font.HELVETICA_BOLD);
            cell.setAlign(HorizontalAlignment.CENTER);

            table.addHeaderRow(headerRow);
            Row<PDPage> row = table.createRow(30f);
            cell = row.createCell(100f, "");

            // Create 2 column row
            for (PageEntry pageEntry : pageEntries) {
                row = table.createRow(15f);
                cell = row.createCell(50f, pageEntry.getTitle());
                cell.setFont(PDType1Font.HELVETICA);

                cell = row.createCell(50f, String.format("%d", pageEntry.getPageNumber()));
                cell.setFont(PDType1Font.HELVETICA);
                cell.setAlign(HorizontalAlignment.RIGHT);
            }
            table.draw();
            Splitter splitter = new Splitter();
            List<PDDocument> pages = splitter.split(doc);
            List<OutputPage> outputPages = Lists.newArrayList();
            for (PDDocument pdDocument : pages) {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                pdDocument.save(os);
                OutputPage outputPage = new OutputPage(Type.CONTENT, null, -1, new ByteArrayPageData(os.toByteArray()));
                outputPages.add(outputPage);
                pdDocument.close();
            }
            return outputPages;

        } catch (IOException e) {
            throw new CoreException(Policy.errorStatus("Tableof content creation failed", e));
        }

    }

    private static PDPage addNewPage(PDDocument doc, float width, float height) {
        PDPage page = new PDPage(new PDRectangle(width, height));
        doc.addPage(page);
        return page;
    }
}
