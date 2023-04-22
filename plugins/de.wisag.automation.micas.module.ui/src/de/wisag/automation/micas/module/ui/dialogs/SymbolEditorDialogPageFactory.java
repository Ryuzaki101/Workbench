package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class SymbolEditorDialogPageFactory {
    public static SymbolEditorDialogPage create(Composite parent, EditedType editedType) {
        switch (editedType) {
        case CONSTANT:
            SymbolEditorDialogConstantPage symbolEditorDialogConstantPage = new SymbolEditorDialogConstantPage(parent,
                    SWT.NONE);
            return symbolEditorDialogConstantPage;
        case REFERENCE:
            return new SymbolEditorDialogReferencePage(parent, SWT.NONE);
        case VARIABLE:
            return new SymbolEditorDialogVariablePage(parent, SWT.NONE);
        }
        throw new RuntimeException("Unsupported type " + editedType);
    }
}
