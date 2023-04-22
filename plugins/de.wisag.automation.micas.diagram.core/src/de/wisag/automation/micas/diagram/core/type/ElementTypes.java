package de.wisag.automation.micas.diagram.core.type;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class ElementTypes extends AbstractElementTypeEnumerator {

    public static final String INCOMING_OFFPAGE_CONNECTOR_ID = "de.wisag.automation.micas.diagram.core.incomingOffPageConnector"; //$NON-NLS-1$
    public static final IElementType INCOMING_OFFPAGE_CONNECTOR = getElementType(INCOMING_OFFPAGE_CONNECTOR_ID);

    public static final String OUTGOING_OFFPAGE_CONNECTOR_ID = "de.wisag.automation.micas.diagram.core.outgoingOffPageConnector"; //$NON-NLS-1$
    public static final IElementType OUTGOING_OFFPAGE_CONNECTOR = getElementType(OUTGOING_OFFPAGE_CONNECTOR_ID);

    public static final String CONSTANT_ID = "de.wisag.automation.micas.diagram.core.constant"; //$NON-NLS-1$
    public static final IElementType CONSTANT = getElementType(CONSTANT_ID);

    public static final String REFERENCE_ID = "de.wisag.automation.micas.diagram.core.reference"; //$NON-NLS-1$
    public static final IElementType REFERENCE = getElementType(REFERENCE_ID);
}
