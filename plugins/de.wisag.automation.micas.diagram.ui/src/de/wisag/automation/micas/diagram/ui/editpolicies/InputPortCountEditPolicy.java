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
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.InputPort;

/**
 * @author Andreas Unger
 */
public class InputPortCountEditPolicy extends org.eclipselabs.damos.diagram.ui.editpolicies.InputPortCountEditPolicy {

    @Override
    protected InputPort getInputPortToBeRemoved(Request request) {
        BlockInput input = getInput(request);
        if (input != null) {
            List<InputPort> inputPorts = input.getPorts();
            if (inputPorts.size() > input.getDefinition().getMinimumPortCount()) {
                for (InputPort inputPort : inputPorts) {
                    if (inputPort.getConnections().isEmpty()) {
                        return inputPort;
                    }
                }
            }
        }
        return super.getInputPortToBeRemoved(request);
    }

}
