package de.wisag.automation.micas.diagram.ui.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.dml.Connection;

public class CreateEdgesCommand extends AbstractTransactionalCommand {

    private DiagramEditPart ep;
    private List<Connection> connections;

    public CreateEdgesCommand(DiagramEditPart ep, List<Connection> connections, TransactionalEditingDomain ed) {
        super(ed, "", null);
        this.ep = ep;
        this.connections = connections;
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        for (Connection con : connections) {
            View source = getView(ep.getChildren(), con.getSource());
            View target = getView(ep.getChildren(), con.getTarget());
            if (source != null && target != null) {
                ViewService.createEdge(source, target, con, "", DiagramUIPlugin.DIAGRAM_PREFERENCES_HINT);
            }
        }
        return CommandResult.newOKCommandResult();
    }

    private static View getView(List<?> epList, EObject element) {
        for (IGraphicalEditPart part : filter(epList, IGraphicalEditPart.class)) {
            if (part.getNotationView().getElement() == element) {
                return part.getNotationView();
            }
            if (part.getChildren().size() > 0) {
                View tmpView = getView(part.getChildren(), element);
                if (tmpView != null) {
                    return tmpView;
                }
            }
        }
        return null;
    }

    private static <T> Collection<T> filter(List<?> children, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        for (Object o : children) {
            if (clazz.isInstance(o)) {
                list.add(clazz.cast(o));
            }
        }
        return list;
    }

    @Override
    public boolean canExecute() {
        if (ep == null) {
            return false;
        }
        return true;
    }

}
