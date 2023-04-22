package de.wisag.automation.micas.workbench.licmgr.ui.internal;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NotEmptyValidator implements IValidator {

    private String errorMessage;

    public NotEmptyValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public IStatus validate(Object value) {
        String s = value == null ? "" : String.valueOf(value);

        if (s.length() > 0) {
            return ValidationStatus.ok();
        }
        return ValidationStatus.error(errorMessage);
    }
}