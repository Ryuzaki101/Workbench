package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;

import de.wisag.automation.micas.module.Reference;

public class ReferencePropertySectionFilter implements IFilter {

    @Override
    public boolean select(Object toTest) {
        if (toTest instanceof IAdaptable) {
            return ((IAdaptable) toTest).getAdapter(Reference.class) != null;
        }
        return false;
    }

}
