package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.ControlDecoration;

import de.wisag.automation.micas.workbench.licmgr.rcp.internal.Activator;

/**
 * Validator which ensures that no empty string is set
 */
public class StringNotEmptyValidator implements IValidator {
    private String message;
    private final ControlDecoration controlDecoration;

    /**
     * New validator
     *
     * @param message
     *            message displayed when validation failed
     */
    public StringNotEmptyValidator(ControlDecoration controlDecoration, String message) {
        this.message = message;
        this.controlDecoration = controlDecoration;
    }

    @Override
    public IStatus validate(Object value) {
        IStatus status = StringUtils.isEmpty((String) value) ? new Status(IStatus.ERROR, Activator.PLUGIN_ID, message)
                : Status.OK_STATUS;
        if (status.isOK()) {
            controlDecoration.hide();
        } else {
            controlDecoration.setDescriptionText(message);
            controlDecoration.show();
        }

        return status;
    }

}