package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.ValueSpecification;

/**
 * @author Andreas Unger
 */
public class SetArgumentValueCommand extends SetValueCommand {

    public SetArgumentValueCommand(Argument argument, ValueSpecification value) {
        super(new SetRequest(TransactionUtil.getEditingDomain(argument), argument, DMLPackage.Literals.ARGUMENT__VALUE,
                value));
        setLabel("'" + argument.getParameter().getName() + "' Parameter Change");
    }

}