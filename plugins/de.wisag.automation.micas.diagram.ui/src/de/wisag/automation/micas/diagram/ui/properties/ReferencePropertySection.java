package de.wisag.automation.micas.diagram.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;

public class ReferencePropertySection extends AbstractAttributePropertySection {

    @Override
    protected String getPropertyChangeCommandName() {
        return "Change Reference";
    }

    @Override
    protected String getPropertyNameLabel() {
        return "Reference:";
    }

    @Override
    protected OutputPort getOutputPort() {
        IAdaptable adaptable = (IAdaptable) getPrimarySelection();
        if (adaptable != null) {
            Reference constant = adaptable.getAdapter(Reference.class);
            if (constant != null) {
                return constant.getFirstOutputPort();
            }
        }
        return null;
    }

    @Override
    protected boolean considerAttribute(Attribute attribute) {
        return attribute instanceof ReferenceAttribute;
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
