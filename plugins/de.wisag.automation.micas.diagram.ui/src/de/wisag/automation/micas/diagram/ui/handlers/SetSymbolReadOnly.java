package de.wisag.automation.micas.diagram.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Input;

import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.Reference;

public class SetSymbolReadOnly extends AbstractHandler implements IHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IGraphicalEditPart element = SelectionUtils.singleSelection(IGraphicalEditPart.class,
                HandlerUtil.getCurrentSelectionChecked(event));
        if (element != null) {
            Constant constant = null;
            Reference ref = null;
            if ((ref = element.getAdapter(Reference.class)) != null && ref.getInputs().size() == 1) {
                setReadOnly(element.getEditingDomain(), ref);
            } else if ((constant = element.getAdapter(Constant.class)) != null && constant.getInputs().size() == 1) {
                setReadOnly(element.getEditingDomain(), constant);
            }
        }
        return null;
    }

    static void setReadOnly(TransactionalEditingDomain domain, final Component command) {
        domain.getCommandStack().execute(new RecordingCommand(domain) {
            @Override
            protected void doExecute() {
                // command.getInputPorts().clear();
                EList<Input> inputs = command.getInputs();
                for (Input input : inputs) {
                    input.getPorts().clear();
                }
                inputs.clear();
            }
        });

    }

}
