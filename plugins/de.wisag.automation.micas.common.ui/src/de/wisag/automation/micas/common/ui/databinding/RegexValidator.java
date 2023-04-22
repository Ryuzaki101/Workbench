package de.wisag.automation.micas.common.ui.databinding;

import java.util.regex.Pattern;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class RegexValidator implements IValidator {
    private String errorMessage;
    private Pattern pattern;

    public RegexValidator(Pattern pattern, String errorMessage) {
        this.errorMessage = errorMessage;
        this.pattern = pattern;
    }

    @Override
    public IStatus validate(Object value) {
        String s = String.valueOf(value);
        if (!pattern.matcher(s).matches()) {
            return ValidationStatus.error(errorMessage);
        }

        return ValidationStatus.ok();
    }

}
