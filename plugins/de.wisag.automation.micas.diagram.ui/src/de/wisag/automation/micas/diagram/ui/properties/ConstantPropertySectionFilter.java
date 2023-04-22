package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;

import de.wisag.automation.micas.module.Constant;

public class ConstantPropertySectionFilter implements IFilter {

    @Override
    public boolean select(Object toTest) {
        if (toTest instanceof IAdaptable) {
            return ((IAdaptable) toTest).getAdapter(Constant.class) != null;
        }
        return false;
    }

}
