package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public abstract class SymbolEditorDialogPage extends Composite {
    public SymbolEditorDialogPage(Composite parent, int style) {
        super(parent, style);
    }

    public abstract Text getTxtSymbolName();

    public abstract Text getTxtSymbolDescription();

}
