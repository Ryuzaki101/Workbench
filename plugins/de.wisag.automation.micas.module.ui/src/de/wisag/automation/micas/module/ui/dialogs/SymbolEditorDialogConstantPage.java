package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SymbolEditorDialogConstantPage extends SymbolEditorDialogPage {
    private Text txtSymbolName;
    private Text txtConstantValue;

    private Combo cmbSymbolType;

    private Label lblSymbolName;
    private Label lblSymbolType;
    private Label lblConstantValue;
    private Group grpDescription;
    private Text txtSymbolDescription;

    public SymbolEditorDialogConstantPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(4, false));

        lblSymbolName = new Label(this, SWT.NONE);
        lblSymbolName.setText("Name :");

        txtSymbolName = new Text(this, SWT.BORDER);
        txtSymbolName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblSymbolType = new Label(this, SWT.NONE);
        lblSymbolType.setText("Datentyp :");

        cmbSymbolType = new Combo(this, SWT.READ_ONLY);
        cmbSymbolType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblConstantValue = new Label(this, SWT.NONE);
        lblConstantValue.setText("Wert :");

        txtConstantValue = new Text(this, SWT.BORDER);
        txtConstantValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);

        grpDescription = new Group(this, SWT.NONE);
        grpDescription.setText("Beschreibung");
        grpDescription.setLayout(new FillLayout(SWT.HORIZONTAL));
        grpDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 4, 1));

        txtSymbolDescription = new Text(grpDescription, SWT.BORDER);
    }

    @Override
    public Text getTxtSymbolName() {
        return txtSymbolName;
    }

    public Text getTxtConstantValue() {
        return txtConstantValue;
    }

    public Label getLblSymbolName() {
        return lblSymbolName;
    }

    public Label getLblSymbolType() {
        return lblSymbolType;
    }

    public Label getLblConstantValue() {
        return lblConstantValue;
    }

    public Combo getCmbSymbolType() {
        return cmbSymbolType;
    }

    @Override
    public Text getTxtSymbolDescription() {
        return txtSymbolDescription;
    }

    public void setTxtSymbolDescription(Text txtSymbolDescription) {
        this.txtSymbolDescription = txtSymbolDescription;
    }
}
