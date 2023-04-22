package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TaskEditorDialogPage extends Composite {
    private Text txtTaskName;
    private Text txtTxtcycletime;
    private Combo cmbTaskType;
    private Label lblIndex;
    private Text txtTaskIndex;

    public TaskEditorDialogPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(4, false));

        lblIndex = new Label(this, SWT.NONE);
        lblIndex.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblIndex.setText("Index :");

        txtTaskIndex = new Text(this, SWT.BORDER);
        txtTaskIndex.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblName = new Label(this, SWT.NONE);
        lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblName.setText("Name  :");

        txtTaskName = new Text(this, SWT.BORDER);
        txtTaskName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblTyp = new Label(this, SWT.NONE);
        lblTyp.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblTyp.setText("Typ :");

        cmbTaskType = new Combo(this, SWT.READ_ONLY);
        cmbTaskType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblCycleTime = new Label(this, SWT.NONE);
        lblCycleTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblCycleTime.setText("Zykluszeit :");

        txtTxtcycletime = new Text(this, SWT.BORDER);
        txtTxtcycletime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    }

    public Text getTxtTaskName() {
        return txtTaskName;
    }

    public Text getTxtTxtcycletime() {
        return txtTxtcycletime;
    }

    public Combo getCmbTaskType() {
        return cmbTaskType;
    }

    public Text getTxtTaskIndex() {
        return txtTaskIndex;
    }
}
