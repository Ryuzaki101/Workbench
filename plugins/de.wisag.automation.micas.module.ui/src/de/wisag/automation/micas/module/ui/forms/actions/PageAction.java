package de.wisag.automation.micas.module.ui.forms.actions;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Shell;

import de.wisag.automation.micas.module.Page;

public class PageAction extends ModelAction<Page> {
    public PageAction(String text, IObservableValue<Page> value, Shell shell) {
        super(text, value, shell);
    }

}