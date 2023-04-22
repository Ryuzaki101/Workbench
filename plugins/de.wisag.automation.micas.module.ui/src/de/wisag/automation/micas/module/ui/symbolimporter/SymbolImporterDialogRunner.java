package de.wisag.automation.micas.module.ui.symbolimporter;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SymbolImporterDialogRunner {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        SymbolImporterDialog dialog = new SymbolImporterDialog(shell);
        dialog.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
