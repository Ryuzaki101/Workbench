package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;

public class ConstantPropertySection extends AbstractAttributePropertySection {

    @Override
    protected String getPropertyChangeCommandName() {
        return "Change Constant";
    }

    @Override
    protected String getPropertyNameLabel() {
        return "Constant:";
    }

    @Override
    protected OutputPort getOutputPort() {
        IAdaptable adaptable = (IAdaptable) getPrimarySelection();
        if (adaptable != null) {
            Constant constant = adaptable.getAdapter(Constant.class);
            if (constant != null) {
                return constant.getFirstOutputPort();
            }
        }
        return null;
    }

    @Override
    protected boolean considerAttribute(Attribute attribute) {
        return attribute instanceof ConstantAttribute;
    }

    @Override
    protected Attribute handleMissingAttribute(String name) {
        return null;
    }

    @Override
    protected boolean propertyValueStringsChanged() {
        return true;
    }

}
