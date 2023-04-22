package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class VariablePropertySection extends AbstractAttributePropertySection {

    @Override
    protected String getPropertyChangeCommandName() {
        return "Change Variable";
    }

    @Override
    protected String getPropertyNameLabel() {
        return "Variable:";
    }

    @Override
    protected boolean isEditable() {
        return true;
    }

    @Override
    protected OutputPort getOutputPort() {
        IAdaptable adaptable = (IAdaptable) getPrimarySelection();
        if (adaptable != null) {

            FragmentElement fragmentElement = adaptable.getAdapter(FragmentElement.class);
            if (fragmentElement instanceof Connection) {
                OutputPort outputPort = (OutputPort) ((Connection) fragmentElement).getSource();
                if (outputPort != null) {
                    Component component = outputPort.getComponent();
                    if (component instanceof Block || component instanceof IncomingOffpageConnector) {
                        return outputPort;
                    }
                }
            } else if (fragmentElement instanceof IncomingOffpageConnector) {
                return ((Component) fragmentElement).getFirstOutputPort();
            } else if (fragmentElement instanceof OutgoingOffpageConnector) {
                Connection connection = ModuleUtil.getIncomingConnection((OutgoingOffpageConnector) fragmentElement);
                return ModuleUtil.getConnectionSource(connection);
            }
        }
        return null;
    }

    @Override
    protected boolean considerAttribute(Attribute attribute) {
        return attribute instanceof VariableAttribute;
    }

    @Override
    protected Attribute handleMissingAttribute(String name) {
        boolean ok = MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                "Variable Selection", "Specified variable does not exist. Do you want to create a new variable?");
        if (ok) {
            VariableAttribute variable = ModuleFactory.eINSTANCE.createVariableAttribute();
            variable.setName(name);
            variable.setDataType(DataType.WORD);

            return variable;
        }
        return null;
    }

    @Override
    protected boolean propertyValueStringsChanged() {
        return true;
    }

}
