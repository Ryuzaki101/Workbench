package de.wisag.automation.micas.module.ui.internal.printing;

import static de.wisag.automation.micas.module.ui.internal.printing.VariableResolver.FQN_PAGENUMBER_PROPERTY;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.w3c.dom.Document;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.ui.internal.printing.OutputPage.Type;
import de.wisag.automation.micas.module.ui.internal.printing.SvgPlaceholderInserter.PlaceholderCallback;
import de.wisag.automation.micas.module.ui.internal.printing.pdfbox.PdfboxEngine;

public class ModulePdfExporter {
    private final IPdfEngine pdfEngine = new PdfboxEngine();

    public IStatus exportAllPdf(IProgressMonitor monitor, Module module) {
        IFile moduleFile = ResourceUtils.toIFile(module.eResource());
        String projectName = moduleFile.getProject().getName();
        String fileName = moduleFile.getName();

        final List<OutputPage> pages = Lists.newArrayList();

        IStatus result = exportAllPdf(monitor, projectName, fileName, module, pages);

        if (!result.isOK()) {
            return result;
        }
        final SubMonitor saveAsSubMonitor = SubMonitor.convert(monitor, "Writing pdf-file : ", pages.size());
        if (!pages.isEmpty()) {
            try {
                byte[] mergedPages = mergePages(saveAsSubMonitor, pages);
                saveAsOnePdf(saveAsSubMonitor, module, mergedPages);
                saveAsSubMonitor.worked(1);
            } catch (CoreException e) {
                return Policy.errorStatus(e);
            }
        }
        monitor.done();
        return Status.OK_STATUS;
    }

    public IStatus exportAllPdf(IProgressMonitor monitor, String projectName, String fileName, Module module,
            final List<OutputPage> pages) {
        List<Page> allPages = allPages(module);
        monitor.beginTask("Saving module as pdf", allPages.size() * 2);

        SvgDocumentTemplate svgBackgroundTemplate;
        try {
            svgBackgroundTemplate = TemplateUtil.loadTemplate("template", TemplateUtil.map(module.getPageFormat()));
        } catch (CoreException e1) {
            return e1.getStatus();
        }

        try {
            OutputPage bannerPage = createBanner(projectName, fileName, module);
            pages.add(bannerPage);
        } catch (Exception e) {

            return Policy.errorStatus("Banner generation failed", e);
        }

        Multimap<Page, FKGDescription> fkgDescriptions = FKGIndexer.buildIndex(module);

        int pageCount = 1;
        final SubMonitor prepareSubMonitor = SubMonitor.convert(monitor, "Preparing pdf-file : ", allPages.size());
        for (Page page : allPages) {
            try {
                // todo erst nur Zeichnungsanteil und FKG's erzeugen
                prepareSubMonitor.subTask(String.format("Add page %s", page.getName()));
                TemplateDrawingArea diagramArea = svgBackgroundTemplate.getDiagramArea();
                /**
                 * producePdfPageFor(page, svgBackgroundTemplate, pageCount,
                 * contentData)
                 */
                pages.add(createPage(svgBackgroundTemplate, pageCount, page, diagramArea));
                pageCount++;

                // look for FKG's to add additional pages
                Optional<OutputPage> fkgPage = createFkgPage(svgBackgroundTemplate, fkgDescriptions, pageCount, page);
                if (fkgPage.isPresent()) {
                    pages.add(fkgPage.get());
                    pageCount++;
                }

                prepareSubMonitor.worked(1);
            } catch (Exception e) {
                pages.clear();
                return Policy.errorStatus(e);
            }
        }

        try {
            SvgDocumentTemplate svgTemplate = svgBackgroundTemplate.getDocumentCopy();

            List<OutputPage> tableOfContentsPage = getPdfEngine()
                    .createTableOfContentPages(svgTemplate.getDiagramArea(), pages);
            //
            // PageBackground background =
            // fillAndRederPageBackground(svgTemplate,
            // new VariableResolver(projectName, fileName, module)
            // .setOverrides(ImmutableMap.of(FQN_PAGENUMBER_PROPERTY, "")));

            pages.addAll(1, tableOfContentsPage);
            long pageCount2 = pages.stream().filter(new Predicate<OutputPage>() {

                @Override
                public boolean test(OutputPage outputPage) {
                    // TODO Auto-generated method stub
                    return outputPage.getType() == Type.PAGE || outputPage.getType() == Type.FKGLISTING;
                }
            }).count();
            for (OutputPage outputPage : pages) {
                if (outputPage.getType() == Type.PAGE || outputPage.getType() == Type.FKGLISTING) {
                    final VariableResolver labelMapper = new VariableResolver(projectName, fileName,
                            outputPage.getPage()).setOverrides(
                                    ImmutableMap.of(//
                                            FQN_PAGENUMBER_PROPERTY, String.format("%d", outputPage.getNo()),
                                            VariableResolver.PAGECOUNT_PROPERTY, String.format("%d", pageCount2))

                    );

                    PageData bg = fillAndRederPageBackground(svgBackgroundTemplate, labelMapper);
                    PageData completePage = getPdfEngine().placeContentOnPage(svgBackgroundTemplate.getDiagramArea(),
                            svgBackgroundTemplate.getFormat(), bg, outputPage.getPageData());
                    outputPage.setFinalPageData(completePage);

                } else if (outputPage.getType() == Type.CONTENT) {
                    PageData bg = fillAndRederPageBackground(svgTemplate,
                            new VariableResolver(projectName, fileName, module).setOverrides(ImmutableMap
                                    .of(FQN_PAGENUMBER_PROPERTY, "", VariableResolver.PAGECOUNT_PROPERTY, "")));
                    PageData completePage = getPdfEngine().placeContentOnPage(svgBackgroundTemplate.getDiagramArea(),
                            svgBackgroundTemplate.getFormat(), bg, outputPage.getPageData());
                    outputPage.setFinalPageData(completePage);
                }
            }

        } catch (CoreException e) {
            pages.clear();
            return e.getStatus();
        }
        return Status.OK_STATUS;
    }

    private Optional<OutputPage> createFkgPage(SvgDocumentTemplate svgBackgroundTemplate,
            Multimap<Page, FKGDescription> fkgDescriptions, int pageCount, Page page)
            throws IOException, CoreException {
        Optional<OutputPage> fkgPage = Optional.empty();
        if (fkgDescriptions.containsKey(page)) {
            SvgDocumentTemplate pageTemplate = svgBackgroundTemplate.getDocumentCopy();
            PageData pkgListingContent = getPdfEngine().getFKGPageCreator().createFkgListing(fkgDescriptions.get(page),
                    pageTemplate.getDiagramArea());
            OutputPage outputPage = new OutputPage(Type.FKGLISTING, page, pageCount, pkgListingContent);
            fkgPage = Optional.of(outputPage);
        }
        return fkgPage;
    }

    private OutputPage createPage(SvgDocumentTemplate svgBackgroundTemplate, int pageCount, Page page,
            TemplateDrawingArea diagramArea) throws CoreException {
        return new OutputPage(Type.PAGE, page, pageCount, produceContentPage(page, svgBackgroundTemplate, diagramArea));
    }

    private OutputPage createBanner(String projectName, String fileName, Module module) throws IOException, Exception {
        PageData bannerData = produceBannerPdfPage(projectName, fileName, module);
        OutputPage bannerPage = new OutputPage(Type.BANNER, null, -1, null);
        bannerPage.setFinalPageData(bannerData);
        return bannerPage;
    }

    public static List<Page> allPages(Module module) {
        final List<Page> allPages = Lists.newLinkedList();
        for (Task task : module.getTasks()) {
            allPages.addAll(task.getPages());
        }
        return allPages;
    }

    private void saveAsOnePdf(IProgressMonitor monitor, Module module, byte[] mergePages) throws CoreException {
        IFile moduleFile = ResourceUtils.toIFile(module.eResource());
        IPath pdfPath = moduleFile.getProjectRelativePath().removeFileExtension().addFileExtension("pdf");
        IFile pdfFile = moduleFile.getProject().getFile(pdfPath);

        monitor.subTask("Save to disk");

        try (ByteArrayInputStream bin = new ByteArrayInputStream(mergePages)) {
            if (pdfFile.exists()) {
                pdfFile.setContents(bin, IResource.FORCE, monitor);
            } else {
                pdfFile.create(bin, true, monitor);
            }
        } catch (IOException e) {
            throw new CoreException(Policy.errorStatus(e));
        }
    }

    public byte[] mergePages(IProgressMonitor monitor, List<OutputPage> list) throws CoreException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        monitor.subTask("Merge pages");
        getPdfEngine().mergeThemAll(list, outputStream);
        return outputStream.toByteArray();
    }

    private PageData produceContentPage(Page page, SvgDocumentTemplate documentTemplate,
            TemplateDrawingArea diagramArea) throws CoreException {
        PageData diagPdfData = new GmfDrawingExport().exportDrawingPart(page, diagramArea.getWidth(),
                documentTemplate.getDiagramArea().getHeight());
        return diagPdfData;
    }

    public PageData produceBannerPdfPage(String projectName, String fileName, Module module)
            throws IOException, Exception {
        SvgDocumentTemplate bannerTemplate = TemplateUtil.loadTemplate("banner",
                TemplateUtil.map(module.getPageFormat()), true);
        return fillAndRederPageBackground(bannerTemplate, new VariableResolver(projectName, fileName, module)
                .setOverrides(ImmutableMap.of(FQN_PAGENUMBER_PROPERTY, "")));

    }

    private PageData fillAndRederPageBackground(SvgDocumentTemplate template, final VariableResolver variableResolver)
            throws CoreException {
        Document document = template.getDocumentCopy().getDocument();

        final PlaceholderResolver resolver = new PlaceholderResolver(new PlaceholderResolver.Resolver() {
            @Override
            public String resolve(String key) {
                return variableResolver.getProperty(key);
            }
        });
        new SvgPlaceholderInserter().process(document, new PlaceholderCallback() {
            @Override
            public String resolvePlaceholders(String text) {
                return resolver.resolve(text);
            }
        });
        return new ByteArrayPageData(new SvgToPdf().transcode(document));
    }

    public IPdfEngine getPdfEngine() {
        return pdfEngine;
    }

}
