package de.wisag.automation.micas.module.ui.internal.printing;

import static java.lang.Float.parseFloat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

import de.wisag.automation.micas.module.PageFormat;
import de.wisag.automation.micas.module.ui.internal.Activator;
import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.ui.internal.printing.SvgDocumentTemplate.Format;

public class TemplateUtil {
    public final static String ID_DRAWING_AREA = "DRAWING_AREA";

    private static URL selectBackgroundTemplate(String prefix, Format pageFormat) throws FileNotFoundException {
        String templateResource = String.format("%s_%s.svg", prefix, pageFormat.name().toLowerCase()).toLowerCase();
        URL resource = TemplateUtil.class.getResource(templateResource);
        if (resource == null) {
            throw new FileNotFoundException("Template " + templateResource + " not found");
        }
        return resource;
    }

    public static SvgDocumentTemplate loadTemplate(String namePrefix, Format fmt) throws CoreException {
        return loadTemplate(namePrefix, fmt, false);
    }

    public static SvgDocumentTemplate loadTemplate(String namePrefix, Format fmt, boolean pagesizeAsArea)
            throws CoreException {
        URL res = null;
        try {
            res = selectBackgroundTemplate(namePrefix, fmt);
        } catch (FileNotFoundException e) {
            Policy.newLoggedCoreException(String.format("Could not find template for Pageformat %s", fmt.name()), e);

        }
        Document template = null;
        try {
            template = loadSvg(res.toURI(), res.openStream());
        } catch (IOException e) {
            Policy.newLoggedCoreException(String.format("Could not find template for Pageformat %s", fmt.name()), e);

        } catch (URISyntaxException e) {
            Policy.newLoggedCoreException(e);
        }

        TemplateDrawingArea diagArea = pagesizeAsArea ? findPageSize(template) : TemplateUtil.findDrawingArea(template);
        return new SvgDocumentTemplate(template, diagArea, fmt);

    }

    public static Format map(PageFormat format) {
        Format fmt = Format.UNKNOWN;
        switch (format) {
        case A3:
            fmt = Format.A3;
            break;
        case A4:
            fmt = Format.A4;
            break;
        default:
            break;
        }
        return fmt;
    }

    private static final String SAX2_PARSER_CLASS = "org.apache.xerces.parsers.SAXParser";

    public static Document loadSvg(URI uri, InputStream is) throws IOException, FileNotFoundException {
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(SAX2_PARSER_CLASS);
        return f.createDocument(uri.toASCIIString(), is);
    }

    static TemplateDrawingArea findDrawingArea(Document template) throws CoreException {
        DocumentTraversal traversal = (DocumentTraversal) template;
        NodeIterator iterator = traversal.createNodeIterator(template.getDocumentElement(), NodeFilter.SHOW_ELEMENT,
                null, true);
        Element rectElement = null;
        for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
            Element element = (Element) n;
            if ("rect".equals(element.getNodeName())
                    && TemplateUtil.ID_DRAWING_AREA.equals(element.getAttributeNS(null, "id"))) {
                rectElement = element;
                break;
            }

        }
        if (rectElement == null) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("No rectangle (rect) found with id=%s", TemplateUtil.ID_DRAWING_AREA)));
        }
        float x = pxToPt(parseFloat(rectElement.getAttributeNS(null, "x")));
        float y = pxToPt(parseFloat(rectElement.getAttributeNS(null, "y")));
        float width = pxToPt(parseFloat(rectElement.getAttributeNS(null, "width")));
        float height = pxToPt(parseFloat(rectElement.getAttributeNS(null, "height")));
        // Rectangle rect = new Rectangle(x, y, x + width, y + height);
        return new TemplateDrawingArea(x, y, width, height);

    }

    static TemplateDrawingArea findPageSize(Document template) throws CoreException {
        DocumentTraversal traversal = (DocumentTraversal) template;
        NodeIterator iterator = traversal.createNodeIterator(template.getDocumentElement(), NodeFilter.SHOW_ELEMENT,
                null, true);
        Element rectElement = null;
        for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
            Element element = (Element) n;
            if ("svg".equals(element.getNodeName())) {
                rectElement = element;
                break;
            }

        }
        if (rectElement == null) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("No rectangle (rect) found with id=%s", TemplateUtil.ID_DRAWING_AREA)));
        }

        float width = pxToPt(parseFloat(rectElement.getAttributeNS(null, "width")));
        float height = pxToPt(parseFloat(rectElement.getAttributeNS(null, "height")));
        // Rectangle rect = new Rectangle(x, y, x + width, y + height);
        return new TemplateDrawingArea(0, 0, width, height);

    }

    private static float pxToPt(float px) {
        return (px * 72) / 96;
    }
}
