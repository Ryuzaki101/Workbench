package de.wisag.automation.micas.common.ui.databinding;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.ui.forms.widgets.Form;

/**
 * Property to deal with {@link Form#setText(String)} and {@link Form#getText()}
 */
public class FormTextProperty extends WidgetValueProperty {
    private FormTextProperty() {
        super();
    }

    @Override
    protected Object doGetValue(Object source) {
        return ((Form) source).getText();
    }

    @Override
    protected void doSetValue(Object source, Object value) {
        ((Form) source).setText(value != null ? value.toString() : "");
    }

    @Override
    public Object getValueType() {
        return String.class;
    }

    /**
     * @return a property instance
     */
    public static IValueProperty create() {
        return new FormTextProperty();
    }
}