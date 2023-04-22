package de.wisag.automation.micas.diagram.core.internal.edithelpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

import de.wisag.automation.micas.diagram.core.internal.commands.ConfigureConstantCommand;
import de.wisag.automation.micas.module.ModulePackage;

public class ConstantEditHelper extends AbstractEditHelper {

    @Override
    protected ICommand getConfigureCommand(ConfigureRequest request) {
        return new ConfigureConstantCommand(request, ModulePackage.Literals.CONSTANT);
    }

}
