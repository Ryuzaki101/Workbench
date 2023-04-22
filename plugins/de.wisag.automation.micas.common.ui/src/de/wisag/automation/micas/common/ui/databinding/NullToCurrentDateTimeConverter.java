package de.wisag.automation.micas.common.ui.databinding;

import java.util.Date;

import org.eclipse.core.databinding.conversion.IConverter;

public class NullToCurrentDateTimeConverter implements IConverter {
    @Override
    public Object getToType() {
        return Date.class;
    }

    @Override
    public Object getFromType() {
        return Date.class;
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return new Date(System.currentTimeMillis());
        }
        return fromObject;
    }
}