package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.IConverter;

final class NotNullToBooleanTrueConverter implements IConverter {
    @Override
    public Object getFromType() {
        return String.class;
    }

    @Override
    public Object getToType() {
        return Boolean.class;
    }

    @Override
    public Object convert(Object fromObject) {
        return StringUtils.isEmpty((String) fromObject) ? Boolean.FALSE : Boolean.TRUE;
    }
}