package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

@SuppressWarnings("unused")
public class SymbolsPage extends FormPage {
    private Text txtSymbolFilter;
    private Table tblSymbols;
    private Button btnEditSymbol;
    private Button btnNewSymbol;
    private Button btnDeleteSymbol;
    private Button btnImportSymbols;

    private TableColumn tcType;
    private TableColumn tcSymbolName;
    private TableColumn tcSymbolDataType;
    private TableColumn tcSymbolValue;
    private TableColumn tcSymbolReferenceRow;
    private TableColumn tcSymbolReferenceColumn;
    private TableColumn tcSymbolDescription;
    private Table tblSymbolUsage;

    private IController controller;
    private SashForm verticalSash;
    private TableColumn tcRefSymbolName;
    private TableColumn tcRefPageName;
    private TableColumn tcRefTaskName;
    private Composite composite_3;
    private Button btnResetFilter;
    private Group grpUsage;
    private Button btnCleanSymbols;

    /**
     * Create the form page.
     *
     * @param id
     * @param title
     */
    public SymbolsPage(String id, String title) {
        super(id, title);
    }

    /**
     * Create the form page.
     *
     * @param editor
     * @param id
     * @param title
     * @wbp.parser.constructor
     * @wbp.eval.method.parameter id "Some id"
     * @wbp.eval.method.parameter title "Some title"
     */
    public SymbolsPage(FormEditor editor, String id, String title) {
        super(editor, id, title);
    }

    /**
     * Create contents of the form.
     *
     * @param managedForm
     */
    @Override
    protected void createFormContent(IManagedForm managedForm) {
        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        form.setText("Micas Modules Symbols");
        Composite body = form.getBody();
        toolkit.decorateFormHeading(form.getForm());
        toolkit.paintBordersFor(body);
        managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

        Section sctnSymbole = toolkit.createSection(managedForm.getForm().getBody(), ExpandableComposite.TITLE_BAR);
        toolkit.paintBordersFor(sctnSymbole);
        sctnSymbole.setText("Symbole");

        Composite composite = toolkit.createComposite(sctnSymbole, SWT.NONE);
        toolkit.paintBordersFor(composite);
        sctnSymbole.setClient(composite);
        composite.setLayout(new GridLayout(2, false));

        Composite composite_1 = toolkit.createComposite(composite, SWT.NONE);

        composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        toolkit.paintBordersFor(composite_1);
        composite_1.setLayout(new GridLayout(1, false));

        composite_3 = new Composite(composite_1, SWT.NONE);
        GridLayout gl_composite_3 = new GridLayout(2, false);
        gl_composite_3.verticalSpacing = 0;
        gl_composite_3.marginWidth = 0;
        gl_composite_3.marginHeight = 0;
        gl_composite_3.horizontalSpacing = 0;
        composite_3.setLayout(gl_composite_3);
        composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        managedForm.getToolkit().adapt(composite_3);
        managedForm.getToolkit().paintBordersFor(composite_3);

        txtSymbolFilter = toolkit.createText(composite_3, "New Text", SWT.NONE);
        txtSymbolFilter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        txtSymbolFilter.setBounds(0, 0, 66, 21);

        btnResetFilter = new Button(composite_3, SWT.NONE);
        managedForm.getToolkit().adapt(btnResetFilter, true, true);
        btnResetFilter.setText("Reset");

        verticalSash = new SashForm(composite_1, SWT.VERTICAL);
        GridData gd_composite_3 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        gd_composite_3.heightHint = 474;
        verticalSash.setLayoutData(gd_composite_3);
        toolkit.adapt(verticalSash);
        toolkit.paintBordersFor(verticalSash);
        gl_composite_3 = new GridLayout(1, false);
        gl_composite_3.marginWidth = 0;
        verticalSash.setLayout(gl_composite_3);
        //
        tblSymbols = toolkit.createTable(verticalSash,
                SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
        tblSymbols.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        toolkit.paintBordersFor(tblSymbols);
        tblSymbols.setLinesVisible(true);
        tblSymbols.setHeaderVisible(true);

        tcType = new TableColumn(tblSymbols, SWT.NONE);
        tcType.setWidth(51);
        tcType.setText("Type");

        tcSymbolName = new TableColumn(tblSymbols, SWT.NONE);
        tcSymbolName.setWidth(120);
        tcSymbolName.setText("Name");

        tcSymbolDataType = new TableColumn(tblSymbols, SWT.NONE);
        tcSymbolDataType.setWidth(60);
        tcSymbolDataType.setText("Datentyp");

        tcSymbolValue = new TableColumn(tblSymbols, SWT.RIGHT);
        tcSymbolValue.setWidth(62);
        tcSymbolValue.setText("Value");

        tcSymbolReferenceRow = new TableColumn(tblSymbols, SWT.RIGHT);
        tcSymbolReferenceRow.setWidth(40);
        tcSymbolReferenceRow.setText("Zeile");

        tcSymbolReferenceColumn = new TableColumn(tblSymbols, SWT.RIGHT);
        tcSymbolReferenceColumn.setWidth(50);
        tcSymbolReferenceColumn.setText("Spalte");

        tcSymbolDescription = new TableColumn(tblSymbols, SWT.NONE);
        tcSymbolDescription.setWidth(140);
        tcSymbolDescription.setText("Beschreibung");
        grpUsage = new Group(verticalSash, SWT.NONE);
        grpUsage.setText("Verwendung");
        grpUsage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        grpUsage.setLayout(new FillLayout());
        tblSymbolUsage = toolkit.createTable(grpUsage, SWT.BORDER | SWT.FULL_SELECTION);
        tblSymbolUsage.setHeaderVisible(true);
        toolkit.paintBordersFor(tblSymbolUsage);
        tblSymbolUsage.setLinesVisible(true);

        tcRefSymbolName = new TableColumn(tblSymbolUsage, SWT.NONE);
        tcRefSymbolName.setWidth(100);
        tcRefSymbolName.setText("Symbol");

        tcRefPageName = new TableColumn(tblSymbolUsage, SWT.NONE);
        tcRefPageName.setWidth(100);
        tcRefPageName.setText("Page");

        tcRefTaskName = new TableColumn(tblSymbolUsage, SWT.NONE);
        tcRefTaskName.setWidth(323);
        tcRefTaskName.setText("Task");
        verticalSash.setWeights(new int[] { 204, 267 });

        Composite composite_2 = toolkit.createComposite(composite, SWT.NONE);
        composite_2.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
        composite_2.setLayout(new GridLayout(1, false));

        toolkit.createLabel(composite_2, "", SWT.NONE);

        btnNewSymbol = toolkit.createButton(composite_2, "Neues Symbol", SWT.NONE);
        btnNewSymbol.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnNewSymbol.setBounds(0, 0, 88, 29);

        btnEditSymbol = toolkit.createButton(composite_2, "Ändern", SWT.NONE);
        btnEditSymbol.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnEditSymbol.setBounds(0, 0, 88, 29);

        btnDeleteSymbol = toolkit.createButton(composite_2, "Löschen", SWT.NONE);
        btnDeleteSymbol.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnDeleteSymbol.setBounds(0, 0, 88, 29);

        btnImportSymbols = toolkit.createButton(composite_2, "Symbole importieren", SWT.NONE);
        btnImportSymbols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnImportSymbols.setBounds(0, 0, 88, 29);

        btnCleanSymbols = new Button(composite_2, SWT.NONE);
        btnCleanSymbols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        managedForm.getToolkit().adapt(btnCleanSymbols, true, true);
        btnCleanSymbols.setText("Symbole aufräumen");

        Label label_2 = toolkit.createLabel(composite_2, "", SWT.NONE);
        getController().bind();
    }

    public Text getTxtSymbolFilter() {
        return txtSymbolFilter;
    }

    public Table getTblSymbols() {
        return tblSymbols;
    }

    public Button getBtnEditSymbol() {
        return btnEditSymbol;
    }

    public Button getBtnNewSymbol() {
        return btnNewSymbol;
    }

    public Button getBtnDeleteSymbol() {
        return btnDeleteSymbol;
    }

    public TableColumn getTcType() {
        return tcType;
    }

    public TableColumn getTcSymbolName() {
        return tcSymbolName;
    }

    public TableColumn getTcSymbolDataType() {
        return tcSymbolDataType;
    }

    public TableColumn getTcSymbolValue() {
        return tcSymbolValue;
    }

    public TableColumn getTcSymbolReferenceRow() {
        return tcSymbolReferenceRow;
    }

    public TableColumn getTcSymbolReferenceColumn() {
        return tcSymbolReferenceColumn;
    }

    public Table getTblSymbolUsage() {
        return tblSymbolUsage;
    }

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public Button getBtnImportSymbols() {
        return btnImportSymbols;
    }

    public TableColumn getTcRefSymbolName() {
        return tcRefSymbolName;
    }

    public TableColumn getTcRefPageName() {
        return tcRefPageName;
    }

    public TableColumn getTcRefTaskName() {
        return tcRefTaskName;
    }

    public Button getBtnResetFilter() {
        return btnResetFilter;
    }

    public TableColumn getTcSymbolDescription() {
        return tcSymbolDescription;
    }

    public Button getBtnCleanSymbols() {
        return btnCleanSymbols;
    }
}
