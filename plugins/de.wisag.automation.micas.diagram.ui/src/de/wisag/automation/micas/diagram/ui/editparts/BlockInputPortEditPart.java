package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.InputPort;

public class BlockInputPortEditPart extends org.eclipselabs.damos.diagram.ui.editparts.BlockInputPortEditPart {

    public BlockInputPortEditPart(View view) {
        super(view);
    }

    @Override
    protected NodeFigure createNodeFigure() {
        InputPort inputPort = (InputPort) resolveSemanticElement();
        PortFigure figure = (PortFigure) super.createNodeFigure();
        if (inputPort.getInput() instanceof BlockInput) {
            figure.setText(((BlockInput) inputPort.getInput()).getDefinition().getName());
        }
        return figure;
    }

}
