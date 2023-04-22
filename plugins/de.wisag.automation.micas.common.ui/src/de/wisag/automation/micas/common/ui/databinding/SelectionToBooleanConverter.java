package de.wisag.automation.micas.common.ui.databinding;

import org.eclipse.core.databinding.conversion.IConverter;

public class SelectionToBooleanConverter implements IConverter {

    @Override
    public Object getFromType() {
        return Object.class;
    }

    @Override
    public Object getToType() {
        return Boolean.class;
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
