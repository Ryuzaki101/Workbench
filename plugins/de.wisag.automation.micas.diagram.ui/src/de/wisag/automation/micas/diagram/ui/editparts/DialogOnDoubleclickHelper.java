package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipselabs.damos.dml.FragmentElement;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.module.Attribute;

public class DialogOnDoubleclickHelper {
    interface ISymbolSelectionHelper {
        SymbolFilter getSymbolFilter();

        ICommand createCommand(IGraphicalEditPart ep);

        void setAttribute(FragmentElement fe, Attribute attribute);
    }

    static void installAssignSymbolDialogOnDoubleClick(IGraphicalEditPart part, ISymbolSelectionHelper resultSetter) {
        part.installEditPolicy(EditPolicyRoles.OPEN_ROLE, createEditPolicy(resultSetter));
    }

    static OpenEditPolicy createEditPolicy(final ISymbolSelectionHelper sh) {
        return new OpenEditPolicy() {
            @Override
            protected Command getOpenCommand(Request request) {
                IGraphicalEditPart ep = (IGraphicalEditPart) getTargetEditPart(request);
                return new ICommandProxy(sh.createCommand(ep));
            }
        };
    }
}
