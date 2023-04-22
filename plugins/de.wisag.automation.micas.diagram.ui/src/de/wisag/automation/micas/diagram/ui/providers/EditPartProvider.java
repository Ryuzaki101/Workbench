package de.wisag.automation.micas.diagram.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateRootEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.view.ISemanticHints;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.System;

import de.wisag.automation.micas.diagram.ui.editparts.BlockEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.BlockInputPortEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.BlockOutputPortEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.ConnectionEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.ConstantEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.CustomBlockDiagramEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.IncomingOffpageConnectorEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.OutgoingOffpageConnectorEditPart;
import de.wisag.automation.micas.diagram.ui.editparts.ReferenceEditPart;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;

public class EditPartProvider extends AbstractEditPartProvider {

    private static final String QUALIFIER = "de.wisag.automation.micas.library";

    @Override
    protected Class<?> getNodeEditPartClass(View view) {
        EObject element = view.getElement();

        if (element instanceof BlockInputPort) {
            BlockInputPort port = (BlockInputPort) element;
            if (port.getComponent() instanceof Block
                    && QUALIFIER.equals(((Block) port.getComponent()).getType().getQualifier())) {
                return BlockInputPortEditPart.class;
            }
        }

        if (element instanceof BlockOutputPort) {
            BlockOutputPort port = (BlockOutputPort) element;
            if (port.getComponent() instanceof Block
                    && QUALIFIER.equals(((Block) port.getComponent()).getType().getQualifier())) {
                return BlockOutputPortEditPart.class;
            }
        }

        if (element instanceof Block) {
            String semanticHint = view.getType();
            if (!ISemanticHints.COMPONENT_NAME.equals(semanticHint)) {
                Block block = (Block) element;
                if (QUALIFIER.equals(block.getType().getQualifier())) {
                    return BlockEditPart.class;
                }
            }
        }

        if (element instanceof IncomingOffpageConnector) {
            return IncomingOffpageConnectorEditPart.class;
        }

        if (element instanceof OutgoingOffpageConnector) {
            return OutgoingOffpageConnectorEditPart.class;
        }

        if (element instanceof Constant) {
            return ConstantEditPart.class;
        }

        if (element instanceof Reference) {
            return ReferenceEditPart.class;
        }

        return super.getNodeEditPartClass(view);
    }

    @Override
    protected Class<?> getEdgeEditPartClass(View view) {
        EObject element = view.getElement();

        if (element instanceof Connection) {
            Connection connection = (Connection) element;
            if (connection.getOwningFragment() instanceof Page) {
                return ConnectionEditPart.class;
            }
        }

        return super.getEdgeEditPartClass(view);
    }

    @Override
    public boolean provides(IOperation operation) {
        if (operation instanceof CreateGraphicEditPartOperation || operation instanceof CreateRootEditPartOperation) {
            if (operation instanceof CreateRootEditPartOperation) {
                return true;
            }
            View view = ((IEditPartOperation) operation).getView();
            return getEditPartClass(view) != null;
        }
        return false;
    }

    @SuppressWarnings("rawtypes")
    private Class getEditPartClass(View view) {
        if (view instanceof Diagram) {
            return getDiagramEditPartClass(view);
        } else if (view instanceof Edge) {
            return getEdgeEditPartClass(view);
        } else if (view instanceof Node) {
            return getNodeEditPartClass(view);
        }
        return null;
    }

    @Override
    protected Class<?> getDiagramEditPartClass(View view) {
        if (view.getElement() instanceof System) {
            return CustomBlockDiagramEditPart.class;
        }
        return super.getDiagramEditPartClass(view);
    }

}
