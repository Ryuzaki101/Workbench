package de.wisag.automation.micas.module.ui.internal.printing;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Shell;

import de.wisag.automation.micas.diagram.ui.util.EditorUtil;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.ui.internal.Policy;

public class GmfDrawingExport {
    public ByteArrayPageData exportDrawingPart(Page page, float width, float height) throws CoreException {
        Diagram diagram = EditorUtil.findDiagramForPage(page);
        DiagramEditPart root = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, new Shell());
        byte[] diagramPdf = null;
        try {
            diagramPdf = new CopyToImageUtil().copyToImageByteArray(root, root.getPrimaryEditParts(), (int) width,
                    (int) height, ImageFileFormat.PDF, new NullProgressMonitor(), true);
        } catch (CoreException e) {
            Policy.newLoggedCoreException(e);
        }
        return new ByteArrayPageData(diagramPdf);
    }
}
