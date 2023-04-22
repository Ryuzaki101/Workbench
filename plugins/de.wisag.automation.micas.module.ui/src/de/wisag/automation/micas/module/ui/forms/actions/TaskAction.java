package de.wisag.automation.micas.module.ui.forms.actions;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Shell;

import de.wisag.automation.micas.module.Task;

public class TaskAction extends ModelAction<Task> {
    public TaskAction(String text, IObservableValue<Task> value, Shell shell) {
        super(text, value, shell);
    }

}