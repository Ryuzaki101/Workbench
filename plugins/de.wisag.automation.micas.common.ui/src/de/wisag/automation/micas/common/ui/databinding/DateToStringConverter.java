package de.wisag.automation.micas.common.ui.databinding;

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Convert a date to a string
 */
public class DateToStringConverter extends Converter {
    private DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);

    /**
     * New converter
     */
    public DateToStringConverter() {
        super(Date.class, String.class);
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return "";
        }
        return format.format(fromObject);
    }
}