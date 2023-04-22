package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DiagrammEditorDialogPage extends Composite {
    private Text txtDiagrammName;

    public DiagrammEditorDialogPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(2, false));

        Label lblDiagrammName = new Label(this, SWT.NONE);
        lblDiagrammName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblDiagrammName.setText("Diagramm name :");

        txtDiagrammName = new Text(this, SWT.BORDER);
        txtDiagrammName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    }

    public Text getTxtDiagrammName() {
        return txtDiagrammName;
    }

}
