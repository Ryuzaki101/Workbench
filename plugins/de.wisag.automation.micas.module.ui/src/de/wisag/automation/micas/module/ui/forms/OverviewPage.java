package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class OverviewPage extends FormPage {

    private Text wTxtModuleName;
    private Text wTxtLineNumber;
    private Text wTxtStationNumber;
    private Text wTxtFieldBusNumber;
    private Text wTxtEditor;
    private Text wTxtInspector;
    private Combo wCmbTypes;

    private Button wBtnNewTask;
    private Button wBtnEditTask;
    private Button wBtnNewDiagrammPage;
    private Button wBtnOpenDiagrammPage;
    private Button wBtnRenameDiagramPage;
    private Button wBtnDeleteDiagrammPage;
    private Button wBtnDeleteTask;

    private Table wTblTasks;

    private Table wTblDiagrammPages;

    private Label lblModulname;
    private Label lblTyp;
    private Label lblEditor;
    private Label lblInspector;
    private Label lblCreated;
    private Label lblEdited;
    private Label lblDiagrammPages;
    private Label lblLine;
    private Label lblStation;
    private Label lblModule;
    private IController controller;
    private DateTime dtCreated;
    private DateTime dtEdited;
    private DateTime dtLastInstalled;
    private Label lblSeitenformat;
    private Combo wCmbPageSizes;
    private Button wBtnCopyDiagramm;
    private Button wBtnPasteDiagramm;
    private Composite wTblDiagrammPagesParent;

    /**
     * Create the form page.
     *
     * @param id
     * @param title
     */
    public OverviewPage(String id, String title) {
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
    public OverviewPage(FormEditor editor, String id, String title) {
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
        form.setText("Micas Module Overview");
        Composite body = form.getBody();
        toolkit.decorateFormHeading(form.getForm());
        toolkit.paintBordersFor(body);
        managedForm.getForm().getBody().setLayout(new GridLayout(2, false));

        Section sctnBeschreibung = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
                ExpandableComposite.TITLE_BAR);
        sctnBeschreibung.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        managedForm.getToolkit().paintBordersFor(sctnBeschreibung);
        sctnBeschreibung.setText("Beschreibung");

        Composite composite = managedForm.getToolkit().createComposite(sctnBeschreibung, SWT.NONE);
        sctnBeschreibung.setClient(composite);
        managedForm.getToolkit().paintBordersFor(composite);
        composite.setLayout(new GridLayout(2, false));

        lblModulname = managedForm.getToolkit().createLabel(composite, "Modulname :", SWT.NONE);

        wTxtModuleName = managedForm.getToolkit().createText(composite, "New Text", SWT.NONE);
        wTxtModuleName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblTyp = managedForm.getToolkit().createLabel(composite, "Typ :", SWT.NONE);
        lblTyp.setSize(31, 17);
        wCmbTypes = new Combo(composite, SWT.READ_ONLY);
        wCmbTypes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        managedForm.getToolkit().adapt(wCmbTypes);
        managedForm.getToolkit().paintBordersFor(wCmbTypes);

        lblLine = new Label(composite, SWT.NONE);
        lblLine.setSize(35, 17);
        managedForm.getToolkit().adapt(lblLine, true, true);
        lblLine.setText("Line :");

        wTxtLineNumber = managedForm.getToolkit().createText(composite, "", SWT.NONE);
        wTxtLineNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        wTxtLineNumber.setSize(182, 21);

        lblStation = new Label(composite, SWT.NONE);
        lblStation.setSize(53, 17);
        managedForm.getToolkit().adapt(lblStation, true, true);
        lblStation.setText("Station:");

        wTxtStationNumber = managedForm.getToolkit().createText(composite, "", SWT.NONE);
        wTxtStationNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        wTxtStationNumber.setSize(234, 21);

        lblModule = managedForm.getToolkit().createLabel(composite, "Feldbusnummer :", SWT.NONE);
        lblModule.setSize(58, 17);

        wTxtFieldBusNumber = managedForm.getToolkit().createText(composite, "", SWT.NONE);
        wTxtFieldBusNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        wTxtFieldBusNumber.setSize(257, 21);

        lblEditor = managedForm.getToolkit().createLabel(composite, "Bearbeiter :", SWT.NONE);

        wTxtEditor = managedForm.getToolkit().createText(composite, "", SWT.NONE);
        wTxtEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblInspector = managedForm.getToolkit().createLabel(composite, "Prüfer :", SWT.NONE);

        wTxtInspector = managedForm.getToolkit().createText(composite, "New Text", SWT.NONE);
        wTxtInspector.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblCreated = managedForm.getToolkit().createLabel(composite, "Erstellt :", SWT.NONE);

        dtCreated = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
        dtCreated.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        managedForm.getToolkit().adapt(dtCreated);
        managedForm.getToolkit().paintBordersFor(dtCreated);

        lblEdited = managedForm.getToolkit().createLabel(composite, "Geändert :", SWT.NONE);

        dtEdited = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
        dtEdited.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        managedForm.getToolkit().adapt(dtEdited);
        managedForm.getToolkit().paintBordersFor(dtEdited);

        Label lblZuletzteInstalliert = new Label(composite, SWT.NONE);
        managedForm.getToolkit().adapt(lblZuletzteInstalliert, true, true);
        lblZuletzteInstalliert.setText("Zuletzte installiert :");

        dtLastInstalled = new DateTime(composite, SWT.BORDER | SWT.DROP_DOWN);
        dtLastInstalled.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        managedForm.getToolkit().adapt(dtLastInstalled);
        managedForm.getToolkit().paintBordersFor(dtLastInstalled);

        lblSeitenformat = new Label(composite, SWT.NONE);
        lblSeitenformat.setText("Seitenformat :");
        managedForm.getToolkit().adapt(lblSeitenformat, true, true);

        wCmbPageSizes = new Combo(composite, SWT.READ_ONLY);
        wCmbPageSizes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        managedForm.getToolkit().adapt(wCmbPageSizes);
        managedForm.getToolkit().paintBordersFor(wCmbPageSizes);

        Label spacer1 = managedForm.getToolkit().createLabel(composite, "", SWT.NONE);
        spacer1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, true, 2, 1));

        Section sctnTasks = managedForm.getToolkit().createSection(managedForm.getForm().getBody(),
                ExpandableComposite.TITLE_BAR);
        sctnTasks.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        managedForm.getToolkit().paintBordersFor(sctnTasks);
        sctnTasks.setText("Tasks");

        Composite composite_1 = managedForm.getToolkit().createComposite(sctnTasks, SWT.NONE);
        sctnTasks.setClient(composite_1);
        managedForm.getToolkit().paintBordersFor(composite_1);
        composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

        Composite composite_2 = new Composite(composite_1, SWT.NONE);
        managedForm.getToolkit().adapt(composite_2);
        managedForm.getToolkit().paintBordersFor(composite_2);
        composite_2.setLayout(new GridLayout(2, false));

        Composite composite_3 = managedForm.getToolkit().createComposite(composite_2, SWT.NONE);
        composite_3.setLayout(new GridLayout(1, false));
        composite_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        managedForm.getToolkit().paintBordersFor(composite_3);

        wTblTasks = managedForm.getToolkit().createTable(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
        wTblTasks.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        managedForm.getToolkit().paintBordersFor(wTblTasks);
        wTblTasks.setHeaderVisible(true);
        wTblTasks.setLinesVisible(true);

        Composite composite_4 = managedForm.getToolkit().createComposite(composite_2, SWT.NONE);
        composite_4.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
        managedForm.getToolkit().paintBordersFor(composite_4);
        composite_4.setLayout(new GridLayout(1, false));

        wBtnNewTask = managedForm.getToolkit().createButton(composite_4, "Neuer Task", SWT.NONE);
        wBtnNewTask.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        wBtnNewTask.setSize(88, 29);

        wBtnEditTask = managedForm.getToolkit().createButton(composite_4, "Ändern", SWT.NONE);
        wBtnEditTask.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        wBtnEditTask.setBounds(0, 0, 88, 29);

        wBtnDeleteTask = managedForm.getToolkit().createButton(composite_4, "Löschen", SWT.NONE);
        wBtnDeleteTask.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        wBtnDeleteTask.setBounds(0, 0, 88, 29);

        Label label_1 = managedForm.getToolkit().createLabel(composite_4, "", SWT.NONE);
        label_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

        Composite composite_5 = managedForm.getToolkit().createComposite(composite_2, SWT.NONE);
        composite_5.setLayout(new GridLayout(2, false));
        composite_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
        // managedForm.getToolkit().paintBordersFor(composite_5);

        lblDiagrammPages = managedForm.getToolkit().createLabel(composite_5, "Enthaltene Seiten :", SWT.NONE);
        lblDiagrammPages.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));

        wTblDiagrammPagesParent = managedForm.getToolkit().createComposite(composite_5, SWT.NONE);
        wTblDiagrammPagesParent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        wTblDiagrammPages = managedForm.getToolkit().createTable(wTblDiagrammPagesParent,
                SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);

        Composite composite_6 = managedForm.getToolkit().createComposite(composite_2, SWT.NONE);
        composite_6.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
        managedForm.getToolkit().paintBordersFor(composite_6);
        composite_6.setLayout(new GridLayout(1, false));

        wBtnNewDiagrammPage = managedForm.getToolkit().createButton(composite_6, "Neue Seite", SWT.NONE);
        wBtnNewDiagrammPage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

        wBtnRenameDiagramPage = new Button(composite_6, SWT.NONE);
        wBtnRenameDiagramPage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

        managedForm.getToolkit().adapt(wBtnRenameDiagramPage, true, true);
        wBtnRenameDiagramPage.setText("Umbenennen");
        wBtnDeleteDiagrammPage = managedForm.getToolkit().createButton(composite_6, "Löschen", SWT.NONE);
        wBtnDeleteDiagrammPage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

        wBtnOpenDiagrammPage = managedForm.getToolkit().createButton(composite_6, "Diagramm öffnen", SWT.NONE);
        wBtnOpenDiagrammPage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

        wBtnCopyDiagramm = new Button(composite_6, SWT.NONE);
        wBtnCopyDiagramm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        managedForm.getToolkit().adapt(wBtnCopyDiagramm, true, true);
        wBtnCopyDiagramm.setText("Diagramm kopieren");

        wBtnPasteDiagramm = new Button(composite_6, SWT.NONE);
        wBtnPasteDiagramm.setText("Diagramm einfügen");
        managedForm.getToolkit().adapt(wBtnPasteDiagramm, true, true);
        getController().bind();
    }

    public Composite getwTblDiagrammPagesParent() {
        return wTblDiagrammPagesParent;
    }

    public void setwTblDiagrammPagesParent(Composite wTblDiagrammPagesParent) {
        this.wTblDiagrammPagesParent = wTblDiagrammPagesParent;
    }

    public Text getwTxtModuleName() {
        return wTxtModuleName;
    }

    public Text getwTxtLineNumber() {
        return wTxtLineNumber;
    }

    public Text getwTxtStationNumber() {
        return wTxtStationNumber;
    }

    public Text getwTxtFieldBusNumber() {
        return wTxtFieldBusNumber;
    }

    public Text getwTxtEditor() {
        return wTxtEditor;
    }

    public Text getwTxtInspector() {
        return wTxtInspector;
    }

    public Combo getwCmbTypes() {
        return wCmbTypes;
    }

    public Button getwBtnNewTask() {
        return wBtnNewTask;
    }

    public Button getwBtnEditTask() {
        return wBtnEditTask;
    }

    public Button getwBtnNewDiagrammPage() {
        return wBtnNewDiagrammPage;
    }

    public Button getwBtnOpenDiagrammPage() {
        return wBtnOpenDiagrammPage;
    }

    public Button getwBtnDeleteDiagrammPage() {
        return wBtnDeleteDiagrammPage;
    }

    public Button getwBtnDeleteTask() {
        return wBtnDeleteTask;
    }

    public Table getwTblTasks() {
        return wTblTasks;
    }

    public Table getwTblDiagrammPages() {
        return wTblDiagrammPages;
    }

    public Label getLblModulname() {
        return lblModulname;
    }

    public Label getLblTyp() {
        return lblTyp;
    }

    public Label getLblEditor() {
        return lblEditor;
    }

    public Label getLblInspector() {
        return lblInspector;
    }

    public Label getLblCreated() {
        return lblCreated;
    }

    public Label getLblEdited() {
        return lblEdited;
    }

    public Label getLblDiagrammPages() {
        return lblDiagrammPages;
    }

    public Label getLblLine() {
        return lblLine;
    }

    public Label getLblStation() {
        return lblStation;
    }

    public Label getLblModule() {
        return lblModule;
    }

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    public DateTime getDtCreated() {
        return dtCreated;
    }

    public DateTime getDtEdited() {
        return dtEdited;
    }

    public DateTime getDtLastInstalled() {
        return dtLastInstalled;
    }

    public Button getwBtnRenameDiagramPage() {
        return wBtnRenameDiagramPage;
    }

    public Combo getwCmbPageSizes() {
        return wCmbPageSizes;
    }

    public Button getWBtnCopyDiagramm() {
        return wBtnCopyDiagramm;
    }

    public Button getWBtnPasteDiagramm() {
        return wBtnPasteDiagramm;
    }
}
