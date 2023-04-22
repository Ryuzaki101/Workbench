package de.wisag.automation.micas.common.ui.databinding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.ui.internal.Activator;

/**
 * Convert a String to a date
 */
public class StringToDateConverter extends Converter implements IValidator {
    private List<DateFormat> formats = new ArrayList<>();
    private String message;

    /**
     * New converter
     *
     * @param message
     *            message when conversion fails
     */
    public StringToDateConverter(String message) {
        super(String.class, Date.class);
        this.message = message;
        formats.add(DateFormat.getDateInstance(DateFormat.SHORT));
        formats.add(new SimpleDateFormat("yyyy-MM-dd"));
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject != null && fromObject.toString().trim().length() == 0) {
            return null;
        }

        for (DateFormat f : formats) {
            try {
                return f.parse(fromObject.toString());
            } catch (ParseException e) {
                // Ignore
            }
        }

        throw new RuntimeException(message);
    }

    @Override
    public IStatus validate(Object value) {
        try {
            convert(value);
        } catch (Exception e) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message);
        }
        return Status.OK_STATUS;
    }
}