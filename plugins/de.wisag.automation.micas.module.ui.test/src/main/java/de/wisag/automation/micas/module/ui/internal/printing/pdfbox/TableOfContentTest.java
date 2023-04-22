package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.ui.internal.printing.ModulePdfExporter;
import de.wisag.automation.micas.module.ui.internal.printing.OutputPage;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;
import de.wisag.automation.micas.module.ui.internal.printing.TemplateUtil;

public class TableOfContentTest {

	@Test
	public void generationTest() throws Exception {
		Module micasModules = ModuleHelper
				.loadModule(TableOfContentTest.class.getResourceAsStream("/ISP01_M02.module"));

		List<Page> pages = ModulePdfExporter.allPages(micasModules);
		List<PdfboxTableOfContent.PageEntry> entries = Lists.newArrayList();
		int pageCount = 1;
		for (Page page : pages) {
			entries.add(new PdfboxTableOfContent.PageEntry(page.getName(), pageCount++));
		}
		PdfboxTableOfContent content = new PdfboxTableOfContent();
		SvgDocumentTemplate template = TemplateUtil.loadTemplate("template", Format.A3);
		List<OutputPage> pdfContent = content.generate(template.getDiagramArea(), entries);
		Files.write(Paths.get("nul"), (byte[]) pdfContent.iterator().next().getPageData().getPageData());
	}
}
