package de.wisag.automation.micas.module.ui.symbolimporter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class SymbolImporterDialogPage extends Composite {
    private Text txtSourcePath;
    // private Table tblAvailableFieldbusNumbers;
    private Table tblImportableSymbols;
    private Button btnSelectFromWorkspace;
    private Button btnSelectFromFilesystem;
    // private Composite availableFieldbusNumbersParent;
    private Composite importableSymbolsParent;

    public SymbolImporterDialogPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));

        Group grpSymbolquelle = new Group(this, SWT.NONE);
        grpSymbolquelle.setLayout(new GridLayout(4, false));
        grpSymbolquelle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        grpSymbolquelle.setText("Symbolquelle");

        Label lblPfad = new Label(grpSymbolquelle, SWT.NONE);
        lblPfad.setText("Pfad");

        txtSourcePath = new Text(grpSymbolquelle, SWT.BORDER);
        txtSourcePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        btnSelectFromWorkspace = new Button(grpSymbolquelle, SWT.NONE);
        btnSelectFromWorkspace.setText("Workspace...");

        btnSelectFromFilesystem = new Button(grpSymbolquelle, SWT.NONE);
        btnSelectFromFilesystem.setText("Dateisystem...");

        Group grpFilter = new Group(this, SWT.NONE);
        grpFilter.setLayout(new FillLayout());
        grpFilter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        grpFilter.setText("Importierte Symbole");
        importableSymbolsParent = new Composite(grpFilter, SWT.NONE);
        importableSymbolsParent.setLayout(new FillLayout());
        tblImportableSymbols = new Table(importableSymbolsParent, SWT.BORDER | SWT.FULL_SELECTION);
        tblImportableSymbols.setHeaderVisible(true);
        tblImportableSymbols.setLinesVisible(true);
        // sf.setWeights(new int[]{20,80});

    }

    public Text getTxtSourcePath() {
        return txtSourcePath;
    }

    public Table getTblImportableSymbols() {
        return tblImportableSymbols;
    }

    public Button getBtnSelectFromWorkspace() {
        return btnSelectFromWorkspace;
    }

    public Button getBtnSelectFromFilesystem() {
        return btnSelectFromFilesystem;
    }

    public Composite getImportableSymbolsParent() {
        return importableSymbolsParent;
    }
}
