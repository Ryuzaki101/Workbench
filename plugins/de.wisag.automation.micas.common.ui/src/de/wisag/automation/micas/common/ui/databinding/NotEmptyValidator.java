package de.wisag.automation.micas.common.ui.databinding;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NotEmptyValidator implements IValidator {
    @Override
    public IStatus validate(Object value) {
        String s = value == null ? "" : String.valueOf(value);

        if (s.length() > 0) {
            return ValidationStatus.ok();
        }
        return ValidationStatus.error("Value must not be empty");
    }
}