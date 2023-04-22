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

public class SymbolEditorDialogReferencePage extends SymbolEditorDialogPage {
    private Text txtSymbolName;
    private Text txtColumnValue;
    private Text txtRowValue;
    private Combo cmbReferenzType;

    private Label lblSymbolName;
    private Label lblReferenzType;
    private Label lblRowValue;
    private Label lblColumnValue;
    private Group grpDescription;
    private Text txtSymbolDescription;

    public SymbolEditorDialogReferencePage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(4, false));

        lblSymbolName = new Label(this, SWT.NONE);
        lblSymbolName.setText("Name :");

        txtSymbolName = new Text(this, SWT.BORDER);
        txtSymbolName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblReferenzType = new Label(this, SWT.NONE);
        lblReferenzType.setBounds(0, 0, 70, 17);
        lblReferenzType.setText("Referenztyp :");

        cmbReferenzType = new Combo(this, SWT.READ_ONLY);
        cmbReferenzType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        cmbReferenzType.setBounds(0, 0, 189, 29);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);

        lblRowValue = new Label(this, SWT.NONE);
        lblRowValue.setText("Zeilenwert :");

        txtRowValue = new Text(this, SWT.BORDER);
        txtRowValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblColumnValue = new Label(this, SWT.NONE);
        lblColumnValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblColumnValue.setText("Spaltenwert :");

        txtColumnValue = new Text(this, SWT.BORDER);
        txtColumnValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        grpDescription = new Group(this, SWT.NONE);
        grpDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
        grpDescription.setText("Beschreibung");
        grpDescription.setLayout(new FillLayout(SWT.HORIZONTAL));

        txtSymbolDescription = new Text(grpDescription, SWT.BORDER);
    }

    @Override
    public Text getTxtSymbolName() {
        return txtSymbolName;
    }

    public Text getTxtColumnValue() {
        return txtColumnValue;
    }

    public Text getTxtRowValue() {
        return txtRowValue;
    }

    public Combo getCmbReferenzType() {
        return cmbReferenzType;
    }

    public Label getLblSymbolName() {
        return lblSymbolName;
    }

    public Label getLblReferenzType() {
        return lblReferenzType;
    }

    public Label getLblRowValue() {
        return lblRowValue;
    }

    public Label getLblColumnValue() {
        return lblColumnValue;
    }

    @Override
    public Text getTxtSymbolDescription() {
        return txtSymbolDescription;
    }
}
