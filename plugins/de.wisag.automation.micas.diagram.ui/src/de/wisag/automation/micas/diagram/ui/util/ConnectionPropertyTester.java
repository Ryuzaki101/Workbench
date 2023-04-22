package de.wisag.automation.micas.diagram.ui.util;

import org.eclipse.core.expressions.PropertyTester;

import de.wisag.automation.micas.diagram.ui.editparts.ConnectionEditPart;

public class ConnectionPropertyTester extends PropertyTester {
    public static final String PROPERTY_NAMESPACE = "de.wisag.automation.micas.diagram.ui";
    public static final String PROPERTY_IS_BLOCK_INTERCONNECTION = "isBlockInterconnection";

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        if (PROPERTY_IS_BLOCK_INTERCONNECTION.equals(property) && receiver instanceof ConnectionEditPart) {
            ConnectionEditPart editPart = (ConnectionEditPart) receiver;
            return editPart.isInterBlockConnection();
        }
        return false;
    }

}
