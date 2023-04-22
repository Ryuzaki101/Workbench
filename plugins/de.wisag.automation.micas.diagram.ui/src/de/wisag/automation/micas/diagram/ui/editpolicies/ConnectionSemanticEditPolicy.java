package de.wisag.automation.micas.diagram.ui.editpolicies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.diagram.ui.editparts.ConnectionEditPart;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class ConnectionSemanticEditPolicy extends SemanticEditPolicy {

    @Override
    protected Command getSemanticCommand(IEditCommandRequest request) {
        if (request instanceof DestroyElementRequest) {
            ConnectionEditPart editPart = (ConnectionEditPart) getHost();
            Connection connection = (Connection) editPart.resolveSemanticElement();
            Command command = super.getSemanticCommand(request);
            tryCompleteDestroyCommand(command, connection);
            return command;
        }

        return super.getSemanticCommand(request);
    }

    private void tryCompleteDestroyCommand(Command command, Connection connection) {

        final OutputPort sourcePort = ModuleUtil.getSourcePort(connection);
        // BUG: 2016/08/10 : if more then one outgoing connection, do not remove
        // attribute from
        // Signal
        if (command instanceof ICommandProxy && sourcePort.getConnections().size() == 1) {
            ICommandProxy proxy = (ICommandProxy) command;
            if (proxy.getICommand() instanceof CompositeTransactionalCommand) {
                CompositeTransactionalCommand compositeCommand = (CompositeTransactionalCommand) proxy.getICommand();

                AbstractTransactionalCommand tx = new AbstractTransactionalCommand(compositeCommand.getEditingDomain(),
                        "", null) {

                    @Override
                    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                            throws ExecutionException {
                        CompoundCommand compoundCommand = new CompoundCommand();

                        org.eclipse.emf.common.command.Command setSignal = SetCommand.create(getEditingDomain(),
                                sourcePort, DMLPackage.Literals.OUTPUT_PORT__SIGNAL, null);
                        compoundCommand.append(setSignal);

                        AttributeSpecification spec = (AttributeSpecification) sourcePort.getSignal();
                        if (spec != null) {
                            compoundCommand.append(SetCommand.create(getEditingDomain(), spec,
                                    ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE, null));
                        }
                        getEditingDomain().getCommandStack().execute(compoundCommand);
                        return CommandResult.newOKCommandResult();
                    }

                };
                compositeCommand.compose(tx);
            }
        }
    }
}
