package de.wisag.automation.micas.common.ui.databinding;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.ui.internal.Activator;

/**
 * Validator which ensures that no empty string is set
 */
public class EmptyStringValidator implements IValidator {
    private String message;

    /**
     * New validator
     *
     * @param message
     *            message displayed when validation failed
     */
    public EmptyStringValidator(String message) {
        this.message = message;
    }

    @Override
    public IStatus validate(Object value) {
        return value == null || value.toString().trim().length() == 0
                ? new Status(IStatus.ERROR, Activator.PLUGIN_ID, message)
                : Status.OK_STATUS;
    }

}