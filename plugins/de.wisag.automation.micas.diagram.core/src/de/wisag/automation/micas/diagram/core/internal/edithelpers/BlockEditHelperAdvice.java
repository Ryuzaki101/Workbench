package de.wisag.automation.micas.diagram.core.internal.edithelpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipselabs.damos.dml.DMLPackage;

import de.wisag.automation.micas.diagram.core.internal.commands.ConfigureBlockCommand;

public class BlockEditHelperAdvice extends AbstractEditHelperAdvice {

    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        return new ConfigureBlockCommand(request, DMLPackage.Literals.BLOCK);
    }

}
