package de.wisag.automation.micas.common.ui.dialogs;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 *
 *
 */
public interface ISymbolFilterDialogProvider {
    SelectionStatusDialog createDialog(Shell activeShell, Object... args);
}
