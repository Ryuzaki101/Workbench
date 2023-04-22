package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class VariablePropertySectionFilter implements IFilter {

    @Override
    public boolean select(Object toTest) {

        if (toTest instanceof IAdaptable) {
            FragmentElement fragmentElement = ((IAdaptable) toTest).getAdapter(FragmentElement.class);
            if (fragmentElement instanceof Connection) {
                Connection connection = (Connection) fragmentElement;
                OutputPort source = ModuleUtil.getConnectionSource(connection);
                InputPort target = ModuleUtil.getConnectionTarget(connection);
                return source instanceof BlockOutputPort && target instanceof BlockInputPort;
            }
            return fragmentElement instanceof IncomingOffpageConnector
                    || fragmentElement instanceof OutgoingOffpageConnector;
        }
        return false;
    }

}
