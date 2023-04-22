package de.wisag.automation.micas.common.ui.databinding;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NumberValidator implements IValidator {
    final String fieldName;

    public NumberValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public IStatus validate(Object value) {
        String s = String.valueOf(value);
        boolean matches = s.matches("\\d*");
        if (matches) {

            return ValidationStatus.ok();
        }
        return ValidationStatus.error("Zur Zahlen erlaubt im Feld '" + fieldName + "'");
    }
}