package de.wisag.automation.micas.olt.ui.internal.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ShowTextDialog extends Dialog {
    private String text;
    private String title;

    public ShowTextDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Text text = new Text(parent, SWT.MULTI | SWT.READ_ONLY | SWT.V_SCROLL);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(text);
        text.setText(this.text);
        return text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected int getShellStyle() {
        return super.getShellStyle() | SWT.RESIZE;
    }

    public static void open(Shell shell, String title, String text) {
        ShowTextDialog dlg = new ShowTextDialog(shell);
        dlg.setText(text != null ? text : "no data");
        dlg.setTitle(title);
        dlg.open();
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(title != null ? title : "");
        newShell.setImage(newShell.getDisplay().getSystemImage(SWT.ICON_INFORMATION));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
