package de.wisag.automation.micas.diagram.core.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.util.BlockUtils;

public class AfterConfigureConnectionCommand extends ConfigureElementCommand {

    public AfterConfigureConnectionCommand(ConfigureRequest request) {
        super(request);
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable adaptable)
            throws ExecutionException {
        ConfigureRequest request = (ConfigureRequest) getRequest();

        Connection connection = (Connection) request.getElementToConfigure();
        OutputPort sourcePort = (OutputPort) connection.getSource();

        DataType sourceDataType = BlockUtils.dataTypeFromOutputPort(sourcePort);
        InputPort targetPort = (InputPort) connection.getTarget();
        DataType targetDataType = BlockUtils.dataTypeFromInputPort(targetPort);

        if (sourceDataType == null && targetDataType != null) {
            sourceDataType = targetDataType;
        } else if (targetDataType == null && sourceDataType != null) {
            targetDataType = sourceDataType;
        } else if (sourceDataType == null && targetDataType == null) {
            return CommandResult.newErrorCommandResult("Kann Verbindung nicht anlegen");
        } else if (sourceDataType != targetDataType) {
            //
            return CommandResult.newErrorCommandResult(
                    String.format("Kann Verbindung nicht anlegen: Quelltyp:%s ist nicht gleich Zieltyp:%s",
                            sourceDataType.getName(), targetDataType.getName()));
        }
        if (targetPort.getComponent() instanceof Constant || targetPort.getComponent() instanceof Reference) {
            // take the output of the element Constant or Reference and apply it
            // to the source of the connection
            Component component = targetPort.getComponent();
            OutputPort port = component.getFirstOutputPort();
            if (port.getSignal() != null && ((AttributeSpecification) port.getSignal()).getAttribute() != null) {
                sourcePort.setSignal(BlockUtils.createSpec(((AttributeSpecification) port.getSignal()).getAttribute()));
                return CommandResult.newOKCommandResult(connection);
            } else {
                // AttributeSpecification attributeSpecification =
                // createAnonymousAttributeSpecification(sourceDataType,connection);
                // sourcePort.setSignal(attributeSpecification);
                // ((Page)
                // connection.getOwningFragment()).getTask().getModule().getAttributes().add(attributeSpecification.getAttribute());
            }
        } else if (sourcePort.getSignal() == null) {
            AttributeSpecification attributeSpecification = BlockUtils
                    .createAnonymousAttributeSpecification(sourceDataType, connection);
            sourcePort.setSignal(attributeSpecification);
            ((Page) connection.getOwningFragment()).getTask().getModule().getAttributes()
                    .add(attributeSpecification.getAttribute());
        }
        return CommandResult.newOKCommandResult(connection);
    }

}
