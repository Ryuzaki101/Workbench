package de.wisag.automation.micas.common.ui.databinding;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;

import de.wisag.automation.micas.common.ui.internal.Activator;

/**
 * Factory to create update strategies
 */
public class UpdateStrategyFactory {
    /**
     * Create an update strategy which converts a string to a date
     *
     * @param message
     *            the message when the conversion fails
     * @return the update strategy
     */
    public static EMFUpdateValueStrategy stringToDate(String message) {
        EMFUpdateValueStrategy strat = new EMFUpdateValueStrategy();
        StringToDateConverter c = new StringToDateConverter(message);
        strat.setConverter(c);
        return strat;
    }

    /**
     * Create an update strategy which converts a string to a date and ensures
     * that the date value on the destinations is not set to null
     *
     * @param convertMessage
     *            the message shown when the conversion fails
     * @param validationMessage
     *            the message when the value is set to null
     * @return the update strategy
     */
    public static EMFUpdateValueStrategy stringToDateNotNull(String convertMessage, final String validationMessage) {
        EMFUpdateValueStrategy strat = stringToDate(convertMessage);
        strat.setBeforeSetValidator(new IValidator() {

            @Override
            public IStatus validate(Object value) {
                if (value == null) {
                    return new Status(IStatus.ERROR, Activator.PLUGIN_ID, validationMessage);
                }

                return Status.OK_STATUS;
            }
        });
        return strat;
    }

    /**
     * Create an update strategy which converts a date to a string
     *
     * @return the update strategy
     */
    public static EMFUpdateValueStrategy dateToString() {
        EMFUpdateValueStrategy strat = new EMFUpdateValueStrategy();
        DateToStringConverter c = new DateToStringConverter();
        strat.setConverter(c);
        return strat;
    }
}