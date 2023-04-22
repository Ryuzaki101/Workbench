package de.wisag.automation.micas.diagram.core.internal.edithelpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.wisag.automation.micas.diagram.core.internal.commands.AfterConfigureConnectionCommand;
import de.wisag.automation.micas.diagram.core.internal.commands.BeforeCreateCommand;

public class ConnectionEditHelperAdvice extends AbstractEditHelperAdvice {
    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        return new AfterConfigureConnectionCommand(request);
    }

    @Override
    protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
        return new BeforeCreateCommand(request);
    }

}
