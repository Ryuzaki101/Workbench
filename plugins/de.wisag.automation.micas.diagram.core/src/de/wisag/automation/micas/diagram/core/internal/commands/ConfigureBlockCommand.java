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

package de.wisag.automation.micas.diagram.core.internal.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipselabs.damos.dml.Block;

import de.wisag.automation.micas.module.util.BlockUtils;

public class ConfigureBlockCommand extends ConfigureElementCommand {

    public ConfigureBlockCommand(ConfigureRequest request, EClass configurableType) {
        super(request);
        setEClass(configurableType);
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        ConfigureRequest request = (ConfigureRequest) getRequest();
        Block block = (Block) request.getElementToConfigure();

        BlockUtils.incrementBlockIndexIfNotExists(block);

        return CommandResult.newOKCommandResult(block);
    }

}
