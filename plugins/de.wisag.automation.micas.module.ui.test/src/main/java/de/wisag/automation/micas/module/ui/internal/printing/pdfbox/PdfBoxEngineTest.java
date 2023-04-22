package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.google.common.io.Resources;

import de.wisag.automation.micas.module.ui.internal.printing.ByteArrayPageData;
import de.wisag.automation.micas.module.ui.internal.printing.PageData;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateUtil;

public class PdfBoxEngineTest {

	@Test
	public void testPlaceContent() throws Exception {
		PdfboxEngine engine = new PdfboxEngine();
		SvgDocumentTemplate template = TemplateUtil.loadTemplate("template", Format.A3);
		URL url = Resources.getResource("template_a3.pdf");

		byte[] data = Resources.asByteSource(url).read();

		URL url2 = Resources.getResource("02_sample_a3.pdf");

		byte[] content = Resources.asByteSource(url2).read();

		PageData background = new ByteArrayPageData(data);
		PageData content2 = new ByteArrayPageData(content);

		PageData x = engine.placeContentOnPage(template.getDiagramArea(), template.getFormat(), background, content2);

		Files.write(Paths.get("C:\\tmp\\merges.pdf"), (byte[]) x.getPageData());
		// engine.mergeThemAll(pages, out);
	}
}
