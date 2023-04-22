/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation
 ****************************************************************************/

package de.wisag.automation.micas.diagram.ui.editpolicies;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.OutputPort;

/**
 * @author Andreas Unger
 */
public class OutputPortCountEditPolicy extends org.eclipselabs.damos.diagram.ui.editpolicies.OutputPortCountEditPolicy {

    @Override
    protected OutputPort getOutputPortToBeRemoved(Request request) {
        BlockOutput output = getOutput(request);
        if (output != null) {
            List<OutputPort> outputPorts = output.getPorts();
            if (outputPorts.size() > output.getDefinition().getMinimumPortCount()) {
                for (OutputPort outputPort : outputPorts) {
                    if (outputPort.getConnections().isEmpty()) {
                        return outputPort;
                    }
                }
            }
        }
        return super.getOutputPortToBeRemoved(request);
    }

}
