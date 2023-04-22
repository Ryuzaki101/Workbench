package de.wisag.automation.micas.module.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MicasCompilerPropertiesComposite extends Composite {

    private Button btnRunOldCompiler;
    private Button btnGeneratertFile;
    private Button btnRemoveUnusedSymbols;

    public MicasCompilerPropertiesComposite(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));

        btnRunOldCompiler = new Button(this, SWT.CHECK);
        btnRunOldCompiler.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnRunOldCompiler.setText("Run old Compiler mic.exe on *.mic files");

        btnGeneratertFile = new Button(this, SWT.CHECK);
        btnGeneratertFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnGeneratertFile.setText("Generate *.rt File for Compiler run");

        btnRemoveUnusedSymbols = new Button(this, SWT.CHECK);
        btnRemoveUnusedSymbols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnRemoveUnusedSymbols.setText("Remove unused Symbols from Image");
        new Label(this, SWT.NONE);
        new Label(this, SWT.NONE);

        Label lblThisFeatureIs = new Label(this, SWT.NONE);
        lblThisFeatureIs.setText("This feature is comming soon");
    }

    public Button getBtnRunOldCompiler() {
        return btnRunOldCompiler;
    }

    public Button getBtnGeneratertFile() {
        return btnGeneratertFile;
    }

    public Button getBtnRemoveUnusedSymbols() {
        return btnRemoveUnusedSymbols;
    }

}
