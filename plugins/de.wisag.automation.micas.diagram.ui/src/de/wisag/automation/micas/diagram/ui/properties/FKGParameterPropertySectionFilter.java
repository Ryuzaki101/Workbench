package de.wisag.automation.micas.diagram.ui.properties;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Block;

import de.wisag.automation.micas.diagram.ui.ISpecialBlockNames;

public class FKGParameterPropertySectionFilter implements IFilter {

    @Override
    public boolean select(Object toTest) {
        if (toTest instanceof IAdaptable) {
            IAdaptable adaptable = (IAdaptable) toTest;
            Block block = adaptable.getAdapter(Block.class);
            return block != null && StringUtils.contains(block.getName(), ISpecialBlockNames.FKG_NAME)
                    && block.getArguments().size() > 0;

        }
        return false;
    }
}
