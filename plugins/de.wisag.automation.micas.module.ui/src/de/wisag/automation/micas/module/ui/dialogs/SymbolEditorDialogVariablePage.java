package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class SymbolEditorDialogVariablePage extends SymbolEditorDialogPage {
    private Text txtSymbolName;

    private Combo cmbSymbolType;

    private Label lblSymbolName;
    private Label lblSymbolType;
    private Button btnCreateSerial;
    private Label lblCount;
    private Spinner count;

    private Text txtSymbolDescription;

    public SymbolEditorDialogVariablePage(Composite parent, int style) {
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

        btnCreateSerial = new Button(this, SWT.CHECK);
        btnCreateSerial.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        btnCreateSerial.setText("Create serials");

        lblCount = new Label(this, SWT.NONE);
        lblCount.setText("Count :");

        count = new Spinner(this, SWT.BORDER);
        count.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        Group grpDescription = new Group(this, SWT.NONE);
        grpDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
        grpDescription.setText("Beschreibung");
        grpDescription.setLayout(new FillLayout(SWT.HORIZONTAL));

        txtSymbolDescription = new Text(grpDescription, SWT.BORDER);
    }

    @Override
    public Text getTxtSymbolName() {
        return txtSymbolName;
    }

    public Combo getCmbSymbolType() {
        return cmbSymbolType;
    }

    public Label getLblSymbolName() {
        return lblSymbolName;
    }

    public Label getLblSymbolType() {
        return lblSymbolType;
    }

    public Button getBtnCreateSerial() {
        return btnCreateSerial;
    }

    public Spinner getCount() {
        return count;
    }

    public Label getLblCount() {
        return lblCount;
    }

    @Override
    public Text getTxtSymbolDescription() {
        return txtSymbolDescription;
    }

}
