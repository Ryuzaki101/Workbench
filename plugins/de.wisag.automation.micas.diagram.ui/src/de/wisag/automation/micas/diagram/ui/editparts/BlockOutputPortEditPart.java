package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.OutputPort;

public class BlockOutputPortEditPart extends org.eclipselabs.damos.diagram.ui.editparts.BlockOutputPortEditPart {

    public BlockOutputPortEditPart(View view) {
        super(view);
    }

    @Override
    protected NodeFigure createNodeFigure() {
        OutputPort outputPort = (OutputPort) resolveSemanticElement();
        PortFigure figure = (PortFigure) super.createNodeFigure();
        if (outputPort.getOutput() instanceof BlockOutput) {
            figure.setText(((BlockOutput) outputPort.getOutput()).getDefinition().getName());
        }
        return figure;
    }
}
