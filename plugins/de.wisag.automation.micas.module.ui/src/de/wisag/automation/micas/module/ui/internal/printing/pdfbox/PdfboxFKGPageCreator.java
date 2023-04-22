package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.eclipse.core.runtime.CoreException;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.ui.internal.printing.ByteArrayPageData;
import de.wisag.automation.micas.module.ui.internal.printing.FKGDescription;
import de.wisag.automation.micas.module.ui.internal.printing.IFKGPageCreator;
import de.wisag.automation.micas.module.ui.internal.printing.PageData;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateDrawingArea;

public class PdfboxFKGPageCreator implements IFKGPageCreator {

    private static final DecimalFormat POINT_FORMAT = new DecimalFormat("0.00");

    @Override
    public PageData createFkgListing(Collection<FKGDescription> descriptions, TemplateDrawingArea area)
            throws IOException, CoreException {
        float margin = 10;
        float leftMargin = 10;
        try (PDDocument doc = new PDDocument()) {
            float width = area.getWidth();
            PDPage page = addNewPage(doc, Math.round(width * 0.25f), area.getHeight() - area.getY());
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

            Row<PDPage> headerRow = table.createRow(15f);
            Cell<PDPage> cell = headerRow.createCell(100f, "FKG's");
            cell.setFont(PDType1Font.HELVETICA_BOLD);
            cell.setAlign(HorizontalAlignment.CENTER);

            table.addHeaderRow(headerRow);
            Row<PDPage> row = table.createRow(30f);
            cell = row.createCell(100f, "");
            for (FKGDescription description : descriptions) {
                row = table.createRow(15f);
                cell = row.createCell(100f,
                        String.format("%s (Prio:%d)", description.getName(), description.getIndex()));
                cell.setFont(PDType1Font.HELVETICA);
                cell.setAlign(HorizontalAlignment.RIGHT);

                /** HEADER **/
                row = table.createRow(15f);
                cell = row.createCell(20f, "IDX");
                cell.setFont(PDType1Font.HELVETICA);
                cell.setAlign(HorizontalAlignment.LEFT);

                cell = row.createCell(40f, "X");
                cell.setFont(PDType1Font.HELVETICA);
                cell.setAlign(HorizontalAlignment.LEFT);

                cell = row.createCell(40f, "Y");
                cell.setFont(PDType1Font.HELVETICA);
                cell.setAlign(HorizontalAlignment.LEFT);
                /** POINTS */
                int i = 0;
                for (de.wisag.automation.micas.module.util.Row pointRow : description.getSupportingPoints()) {
                    row = table.createRow(15f);
                    cell = row.createCell(20f, String.format("%d", i));
                    cell.setFont(PDType1Font.HELVETICA);
                    cell.setAlign(HorizontalAlignment.LEFT);

                    cell = row.createCell(40f, String.format("%s", POINT_FORMAT.format(pointRow.getX())));
                    cell.setFont(PDType1Font.HELVETICA);
                    cell.setAlign(HorizontalAlignment.LEFT);

                    cell = row.createCell(40f, String.format("%s", POINT_FORMAT.format(pointRow.getY())));
                    cell.setFont(PDType1Font.HELVETICA);
                    cell.setAlign(HorizontalAlignment.LEFT);

                }
            }
            table.draw();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            doc.save(output);
            return new ByteArrayPageData(output.toByteArray());
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
