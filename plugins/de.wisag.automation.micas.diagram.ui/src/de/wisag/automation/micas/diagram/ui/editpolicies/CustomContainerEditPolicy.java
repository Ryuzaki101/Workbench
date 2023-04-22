package de.wisag.automation.micas.diagram.ui.editpolicies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.PasteViewRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.wisag.automation.micas.diagram.ui.commands.CustomPasteCommand;

@SuppressWarnings("restriction")
public class CustomContainerEditPolicy extends ContainerEditPolicy {

    /**
     * @return the custom paste command
     *         {@link de.wisag.automation.micas.diagram.ui.commands.CustomPasteCommand}
     */
    @Override
    protected Command getPasteCommand(PasteViewRequest request) {
        /* Get the view context */
        IGraphicalEditPart editPart = (IGraphicalEditPart) getHost();
        View viewContext = ((IAdaptable) editPart).getAdapter(View.class);

        /* Get the clipboard data */
        ICustomData[] data = request.getData();

        /* Return the paste command */
        if (data != null && viewContext != null && editPart instanceof ISurfaceEditPart) {
            return new ICommandProxy(new CustomPasteCommand(editPart.getEditingDomain(),
                    DiagramUIMessages.PasteCommand_Label, viewContext, data,
                    MapModeUtil.getMapMode(((org.eclipse.gef.GraphicalEditPart) getHost()).getFigure())));
        }

        return null;
    }

}
