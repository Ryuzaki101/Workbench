package de.wisag.automation.micas.module.ui.forms.actions;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

public abstract class ModelAction<O> extends Action {
    private final Shell shell;
    private IObservableValue<O> value;

    ModelAction(String text, IObservableValue<O> value, Shell shell) {
        super(text);
        this.shell = shell;
        this.value = value;

    }

    public O getValue() {
        return value.getValue();
    }

    @Override
    public boolean isEnabled() {
        return value.getValue() != null;
    }

    public Shell getShell() {
        return shell;
    }

}