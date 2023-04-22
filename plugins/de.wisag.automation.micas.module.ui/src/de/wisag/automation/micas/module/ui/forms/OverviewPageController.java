package de.wisag.automation.micas.module.ui.forms;

import java.lang.reflect.InvocationTargetException;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipselabs.damos.dml.DMLPackage;

import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.common.ui.databinding.NotEmptyValidator;
import de.wisag.automation.micas.common.ui.databinding.NullToCurrentDateTimeConverter;
import de.wisag.automation.micas.common.ui.databinding.NumberValidator;
import de.wisag.automation.micas.common.ui.databinding.SelectionToBooleanConverter;
import de.wisag.automation.micas.diagram.ui.util.EditorUtil;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModuleKind;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.PageFormat;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;
import de.wisag.automation.micas.module.ui.dialogs.DiagrammEditorDialog;
import de.wisag.automation.micas.module.ui.dialogs.EditMode;
import de.wisag.automation.micas.module.ui.dialogs.TaskEditorDialog;
import de.wisag.automation.micas.module.ui.editor.StatusHelper;
import de.wisag.automation.micas.module.ui.forms.actions.PageAction;
import de.wisag.automation.micas.module.ui.forms.actions.TaskAction;
import de.wisag.automation.micas.module.ui.forms.patched.WisagTableColumnLayout;
import de.wisag.automation.micas.module.ui.internal.Activator;
import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.ui.internal.printing.ModulePdfExporter;

public class OverviewPageController extends PageController<Module> implements IController {

    private final OverviewPage overviewPage;
    private WritableValue<Task> selectedTask;
    private WritableValue<Page> selectedDiagramPage;
    private TableViewer taskviewer;

    public OverviewPageController(OverviewPage overviewPage) {
        this.overviewPage = overviewPage;
    }

    @Override
    public void bind() {
        selectedTask = new WritableValue<>(getDataBindingContext().getValidationRealm(), null, Task.class);
        selectedDiagramPage = new WritableValue<>(getDataBindingContext().getValidationRealm(), null, Page.class);
        Module module = getModelProvider().getModel();
        Text txtModuleName = getOverviewPage().getwTxtModuleName();

        IEMFEditValueProperty value = EMFEditProperties.value(getModelProvider().getEditingDomain(),
                ModulePackage.Literals.MODULE__NAME);
        getDataBindingContext().bindValue(
                //
                WidgetProperties.text(SWT.Modify).observe(txtModuleName), //
                value.observe(module)//
                , new EMFUpdateValueStrategy().setAfterConvertValidator(new NotEmptyValidator()), null);

        ComboViewer modulesKindViewer = new ComboViewer(getOverviewPage().getwCmbTypes());
        modulesKindViewer.setContentProvider(new ArrayContentProvider());
        modulesKindViewer.setInput(ModuleKind.VALUES);
        modulesKindViewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return ((ModuleKind) element).getName();
            }
        });
        modulesKindViewer.setComparator(new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                ModuleKind k1 = (ModuleKind) e1;
                ModuleKind k2 = (ModuleKind) e2;
                return String.CASE_INSENSITIVE_ORDER.compare(k1.getName(), k2.getName());
            }
        });
        getDataBindingContext().bindValue(
                //
                ViewerProperties.singleSelection().observe(modulesKindViewer), //
                EMFEditProperties.value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__KIND)
                        .observe(module));

        /** */
        ComboViewer comboViewer2 = new ComboViewer(getOverviewPage().getwCmbPageSizes());
        comboViewer2.setContentProvider(new ArrayContentProvider());
        comboViewer2.setInput(PageFormat.VALUES);
        comboViewer2.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return ((PageFormat) element).getName();
            }
        });
        getDataBindingContext().bindValue(
                //
                ViewerProperties.singleSelection().observe(comboViewer2), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__PAGE_FORMAT)
                        .observe(module));

        /** */
        Text txtFieldBusNumber = getOverviewPage().getwTxtFieldBusNumber();
        getDataBindingContext().bindValue(
                //
                WidgetProperties.text(SWT.Modify).observe(txtFieldBusNumber), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__FIELD_BUS_NUMBER)
                        .observe(module),
                new EMFUpdateValueStrategy().setAfterGetValidator(new NumberValidator("Feldbusnummer"))
                        .setAfterConvertValidator(new IValidator() {

                            @Override
                            public IStatus validate(Object value) {
                                Integer number = (Integer) value;
                                if (number < 2 || number > 31) {
                                    return ValidationStatus.error("Feldbusnummer muss zwischen 2 und 31 liegen");
                                }

                                return ValidationStatus.ok();
                            }
                        }),
                null
        //
        );

        Text txtLineNumber = getOverviewPage().getwTxtLineNumber();

        getDataBindingContext().bindValue(
                //
                WidgetProperties.text(SWT.Modify).observeDelayed(400, txtLineNumber), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__LINE_NUMBER)
                        .observe(module)//
                , new EMFUpdateValueStrategy().setAfterGetValidator(new NumberValidator("Liniennummer")), null//
        );
        Text txtStationNumber = getOverviewPage().getwTxtStationNumber();

        getDataBindingContext().bindValue(
                //
                WidgetProperties.text(SWT.Modify).observeDelayed(400, txtStationNumber), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__STATION_NUMBER)
                        .observe(module),
                new EMFUpdateValueStrategy().setAfterGetValidator(new NumberValidator("Stationsnummer")), null//
        );

        Text txtEditor = getOverviewPage().getwTxtEditor();
        txtEditor.setText("");
        getDataBindingContext().bindValue(
                //
                WidgetProperties.text(SWT.Modify).observe(txtEditor), //
                EMFEditProperties.value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__PROCESSOR)
                        .observe(module)//
                , null, null);

        Text txtInspector = getOverviewPage().getwTxtInspector();
        txtInspector.setText("");
        getDataBindingContext().bindValue(
                //
                WidgetProperties.text(SWT.Modify).observe(txtInspector), //
                EMFEditProperties.value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__EXAMINER)
                        .observe(module)//
        );
        DateTime dtCreated = getOverviewPage().getDtCreated();

        getDataBindingContext().bindValue(
                //
                WidgetProperties.selection().observe(dtCreated), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__CREATED_DATE)
                        .observe(module)//
                , null, new EMFUpdateValueStrategy().setConverter(new NullToCurrentDateTimeConverter()));
        DateTime dtEdited = getOverviewPage().getDtEdited();
        getDataBindingContext().bindValue(
                //
                WidgetProperties.selection().observe(dtEdited), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__LAST_MODIFIED_DATE)
                        .observe(module)//
                , null, new EMFUpdateValueStrategy().setConverter(new NullToCurrentDateTimeConverter()));

        DateTime dtlastInstalled = getOverviewPage().getDtLastInstalled();
        getDataBindingContext().bindValue(
                //
                WidgetProperties.selection().observe(dtlastInstalled), //
                EMFEditProperties
                        .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.MODULE__LAST_INSTALL_DATE)
                        .observe(module)//
                , null, new EMFUpdateValueStrategy().setConverter(new NullToCurrentDateTimeConverter()));

        taskviewer = new TableViewer(getOverviewPage().getwTblTasks());
        ColumnViewerSorter defaultSorter = null;
        {
            TableViewerColumn column = new TableViewerColumn(taskviewer, SWT.NONE);
            column.getColumn().setText("Index");
            column.getColumn().setWidth(75);
            defaultSorter = new ColumnViewerSorter(taskviewer, column) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Task task1 = (Task) e1;
                    Task task2 = (Task) e2;
                    return Integer.valueOf(task1.getIndex()).compareTo(Integer.valueOf(task2.getIndex()));
                }
            };
        }
        {
            TableViewerColumn column = new TableViewerColumn(taskviewer, SWT.NONE);
            column.getColumn().setText("Name");
            column.getColumn().setWidth(103);
            new ColumnViewerSorter(taskviewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Task task1 = (Task) e1;
                    Task task2 = (Task) e2;
                    String name1 = StringUtils.trimToEmpty(task1.getName());
                    String name2 = StringUtils.trimToEmpty(task2.getName());
                    return String.CASE_INSENSITIVE_ORDER.compare(name1, name2);
                }
            };
        }
        {
            TableViewerColumn column = new TableViewerColumn(taskviewer, SWT.NONE);
            column.getColumn().setText("Type");
            column.getColumn().setWidth(75);
            new ColumnViewerSorter(taskviewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Task task1 = (Task) e1;
                    Task task2 = (Task) e2;
                    TaskKind kind1 = task1.getKind();
                    TaskKind kind2 = task2.getKind();
                    if (kind1 == null || kind2 == null) {
                        return Integer.MIN_VALUE;
                    }
                    return kind1.compareTo(kind2);
                }
            };
        }

        {
            TableViewerColumn column = new TableViewerColumn(taskviewer, SWT.NONE);
            column.getColumn().setText("Zykluszeit");
            column.getColumn().setWidth(83);
            new ColumnViewerSorter(taskviewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Task task1 = (Task) e1;
                    Task task2 = (Task) e2;
                    return Integer.valueOf(task1.getCycleTime()).compareTo(Integer.valueOf(task2.getCycleTime()));
                }
            };
        }
        defaultSorter.setSorter(defaultSorter, ColumnViewerSorter.NONE);
        taskviewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                Task task = SelectionUtils.singleSelection(Task.class, event.getSelection());
                TaskEditorDialog.editTask(task, event.getViewer().getControl().getShell(), getModelProvider(),
                        EditMode.MODIFY);
            }
        });
        // observer selected task and bind it to selected task
        getDataBindingContext().bindValue(this.selectedTask, ViewerProperties.singleSelection().observe(taskviewer));
        IEMFEditListProperty tasks = EMFEditProperties.list(getModelProvider().getEditingDomain(),
                ModulePackage.Literals.MODULE__TASKS);
        IEMFEditValueProperty[] labelProperties = EMFEditProperties.values(getModelProvider().getEditingDomain(),
                ModulePackage.Literals.TASK__INDEX, ModulePackage.Literals.TASK__NAME,
                ModulePackage.Literals.TASK__KIND, ModulePackage.Literals.TASK__CYCLE_TIME);

        ViewerSupport.bind(taskviewer, tasks.observe(module), labelProperties);

        createTaskViewerActions(taskviewer);

        getDataBindingContext().bindValue(WidgetProperties.enabled().observe(getOverviewPage().getwBtnDeleteTask()),
                this.selectedTask, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new SelectionToBooleanConverter()));

        bindEnablenessToSelection(getOverviewPage().getwBtnEditTask(), this.selectedTask);

        IViewerObservableValue selectedTask = ViewerProperties.singlePostSelection().observe(taskviewer);
        // krm: 05/2014 One column 100% width
        // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=215997
        WisagTableColumnLayout tableColumnLayout = new WisagTableColumnLayout();
        /** pagesviewer */
        final TableViewer diagrammPagesViewer = new TableViewer(getOverviewPage().getwTblDiagrammPages());
        {
            // Column Layout is not working
            final TableViewerColumn column = new TableViewerColumn(diagrammPagesViewer, SWT.NONE);
            // column.getColumn().setWidth(100);

            tableColumnLayout.setColumnData(column.getColumn(), new ColumnWeightData(95));
        }

        getOverviewPage().getwTblDiagrammPagesParent().setLayout(tableColumnLayout);

        diagrammPagesViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                EditorUtil.openPageEditor((Page) selection.getFirstElement());
            }
        });

        IEMFEditListProperty pages = EMFEditProperties.list(getModelProvider().getEditingDomain(),
                ModulePackage.Literals.TASK__PAGES);
        IEMFEditValueProperty pagesProperties = EMFEditProperties.value(getModelProvider().getEditingDomain(),
                DMLPackage.Literals.FRAGMENT__NAME);
        ViewerSupport.bind(diagrammPagesViewer, pages.observeDetail(selectedTask), pagesProperties);
        getDataBindingContext().bindValue(this.selectedDiagramPage,
                ViewerProperties.singleSelection().observe(diagrammPagesViewer));

        createPageViewerActions(diagrammPagesViewer);
        bindTaskButtons();
        bindDiagrammButtons();

        // now update the textfields from model
        StatusHelper.addStatusSupport(getDataBindingContext(), overviewPage.getManagedForm().getForm().getForm());
        getDataBindingContext().updateTargets();
        overviewPage.getManagedForm().getForm().getToolBarManager().add(new Action() {
            @Override
            public void run() {
                ProgressMonitorDialog pmd = new ProgressMonitorDialog(overviewPage.getSite().getShell());
                try {
                    pmd.run(false, true, new IRunnableWithProgress() {

                        @Override
                        public void run(IProgressMonitor monitor)
                                throws InvocationTargetException, InterruptedException {
                            ModulePdfExporter exporter = new ModulePdfExporter();
                            IStatus status;
                            try {
                                status = exporter.exportAllPdf(monitor, getModelProvider().getModel());
                            } catch (Exception e) {
                                Policy.logError(e);
                                throw new InvocationTargetException(e);
                            }
                            if (!status.isOK()) {
                                Policy.log(status);
                                throw new InvocationTargetException(new CoreException(status));
                            }

                        }
                    });
                } catch (InvocationTargetException e) {
                    IStatus status = null;
                    if (e.getTargetException() instanceof CoreException) {
                        CoreException c = (CoreException) e.getTargetException();
                        status = c.getStatus();
                    } else {
                        status = Policy.logError("PDF generation failed", e.getTargetException());
                    }
                    ErrorDialog.openError(overviewPage.getSite().getShell(), "PDF Export failed", status.getMessage(),
                            status);
                } catch (InterruptedException e) {
                    // nix
                }
            }

            @Override
            public ImageDescriptor getImageDescriptor() {
                return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/export_pdf.gif");
            }
        });
        overviewPage.getManagedForm().getForm().getToolBarManager().update(true);

    }

    private <T> void bindEnablenessToSelection(Button button, WritableValue<T> selection) {
        getDataBindingContext().bindValue(WidgetProperties.enabled().observe(button), selection,
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new SelectionToBooleanConverter()));
    }

    private void bindDiagrammButtons() {
        // bind the Diagram Buttons
        Button btnNewDiagrammPage = getOverviewPage().getwBtnNewDiagrammPage();
        btnNewDiagrammPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Task task = selectedTask.getValue();
                if (task == null) {
                    return;
                }
                Shell shell = ((Control) e.widget).getShell();
                createAndOpenDiagram(task, shell);
            }
        });

        Button btnDeleteDiagrammPage = getOverviewPage().getwBtnDeleteDiagrammPage();
        bindEnablenessToSelection(btnDeleteDiagrammPage, selectedDiagramPage);
        btnDeleteDiagrammPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Page page = OverviewPageController.this.selectedDiagramPage.getValue();
                if (page != null) {
                    EditorUtil.removeDiagram(page);
                    Command command = DeleteCommand.create(getModelProvider().getEditingDomain(), page);
                    getModelProvider().getEditingDomain().getCommandStack().execute(command);
                }
            }
        });
        Button btnOpenDiagrammPage = getOverviewPage().getwBtnOpenDiagrammPage();
        bindEnablenessToSelection(btnOpenDiagrammPage, selectedDiagramPage);
        btnOpenDiagrammPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Page diagram = selectedDiagramPage.getValue();
                if (diagram != null) {
                    EditorUtil.openPageEditor(diagram);
                }
            }
        });

        Button btnRenameDiagramPage = getOverviewPage().getwBtnRenameDiagramPage();
        bindEnablenessToSelection(btnRenameDiagramPage, selectedDiagramPage);
        btnRenameDiagramPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Page diagram = selectedDiagramPage.getValue();
                DiagrammEditorDialog.editDiagramm(((Control) e.widget).getShell(),
                        TaskModelProvider.create(getModelProvider(), diagram.getTask()), diagram, EditMode.MODIFY);
            }
        });

        Button btnCopyDiagramPage = getOverviewPage().getWBtnCopyDiagramm();
        bindEnablenessToSelection(btnCopyDiagramPage, selectedDiagramPage);
        btnCopyDiagramPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Page diagram = selectedDiagramPage.getValue();
                Resource resource = diagram.eResource();
                EList<EObject> contents = resource.getContents();
                for (EObject eObject : contents) {
                    if (eObject instanceof Diagram) {
                        Diagram egmfDiagram = (Diagram) eObject;
                        if (diagram.equals(egmfDiagram.getElement())) {
                            String data = diagramToXmi(diagram, egmfDiagram);
                            Clipboard clipboard = new Clipboard(getOverviewPage().getLblCreated().getDisplay());
                            try {
                                clipboard.setContents(new Object[] { data },
                                        new Transfer[] { ModuleDiagramTransferType.getInstance() });
                            } finally {
                                clipboard.dispose();
                            }
                            break;
                        }

                    }
                }

            }
        });
        Button btnPasteDiagramPage = getOverviewPage().getWBtnPasteDiagramm();
        btnPasteDiagramPage.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Task task = selectedTask.getValue();
                EditingDomain editingDomain = getModelProvider().getEditingDomain();
                int number = task.getPages().size();
                String name = String.format("Diagramm%d", number);
                while (!DiagramNameHelper.isUniqueName(task, name)) {
                    name = String.format("Diagramm%d", ++number);
                }
                Clipboard clipboard = new Clipboard(getOverviewPage().getLblCreated().getDisplay());
                Object data = clipboard.getContents(ModuleDiagramTransferType.getInstance());

                if (data != null) {
                    String diagramData = (String) data;
                    PasteFromStringDataCommand cmd = new PasteFromStringDataCommand(
                            (TransactionalEditingDomain) editingDomain, task, diagramData, name);
                    editingDomain.getCommandStack().execute(cmd);

                }
            }
        });

    }

    private void bindTaskButtons() {
        // bind the Task Buttons
        getOverviewPage().getwBtnNewTask().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Shell shell = ((Control) e.widget).getShell();
                doNewTask(shell);
            }
        });
        getOverviewPage().getwBtnEditTask().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Task task = OverviewPageController.this.selectedTask.getValue();
                if (task != null) {
                    TaskEditorDialog.editTask(task, ((Control) e.widget).getShell(), getModelProvider(),
                            EditMode.MODIFY);
                }
            }
        });

        //
        getOverviewPage().getwBtnDeleteTask().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Task task = OverviewPageController.this.selectedTask.getValue();
                if (task != null) {
                    doDeleteTask(task);
                }
            }
        });
    }

    private void createTaskViewerActions(final TableViewer taskviewer) {
        final Shell shell = taskviewer.getControl().getShell();
        MenuManager mm = new MenuManager();
        mm.setRemoveAllWhenShown(true);
        mm.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                manager.add(new TaskAction("Neues Diagramm", selectedTask, shell) {
                    @Override
                    public void run() {
                        createAndOpenDiagram(getValue(), shell);
                    }
                });
                manager.add(new Separator());
                manager.add(new TaskAction("Umbenenne", selectedTask, shell) {
                    @Override
                    public void run() {
                        TaskEditorDialog.editTask(getValue(), shell, getModelProvider(), EditMode.MODIFY);
                    }
                });
                manager.add(new TaskAction("Löschen", selectedTask, shell) {

                    @Override
                    public void run() {
                        doDeleteTask(getValue());
                    }
                });
            }
        });
        taskviewer.getTable().setMenu(mm.createContextMenu(taskviewer.getControl()));

    }

    private void createPageViewerActions(final TableViewer taskviewer) {

        MenuManager mm = new MenuManager();
        mm.setRemoveAllWhenShown(true);
        mm.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                final Shell shell = taskviewer.getControl().getShell();
                manager.add(new PageAction("Umbenenne", selectedDiagramPage, shell) {
                    @Override
                    public void run() {
                        DiagrammEditorDialog.editDiagramm(getShell(),
                                TaskModelProvider.create(getModelProvider(), getValue().getTask()), getValue(),
                                EditMode.MODIFY);
                    }
                });
                manager.add(new PageAction("Löschen", selectedDiagramPage, shell) {
                    @Override
                    public void run() {
                        Command command = DeleteCommand.create(getModelProvider().getEditingDomain(), getValue());
                        getModelProvider().getEditingDomain().getCommandStack().execute(command);
                    }

                });

                manager.add(new Separator());
                manager.add(new PageAction("Nach oben", selectedDiagramPage, shell) {
                    @Override
                    public void run() {
                        final int index = getPageIndex();
                        Page page = getValue();
                        Task task = page.getTask();
                        final EList<Page> pages = task.getPages();

                        EditingDomain domain = getModelProvider().getEditingDomain();
                        domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
                            @Override
                            protected void doExecute() {
                                pages.move(index - 1, index);
                            }
                        });

                    }

                    private int getPageIndex() {
                        return getValue().getTask().getPages().indexOf(getValue());
                    }

                    @Override
                    public boolean isEnabled() {
                        return super.isEnabled() && getPageIndex() > 0;
                    }

                });
                manager.add(new PageAction("Nach unten", selectedDiagramPage, shell) {
                    @Override
                    public void run() {
                        final int index = getPageIndex();
                        final EList<Page> pages = getPages();
                        EditingDomain domain = getModelProvider().getEditingDomain();
                        domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
                            @Override
                            protected void doExecute() {
                                pages.move(index + 1, index);
                            }
                        });

                    }

                    private EList<Page> getPages() {
                        return getValue().getTask().getPages();
                    }

                    private int getPageIndex() {
                        Page page = getValue();
                        Task task = page.getTask();
                        int index = task.getPages().indexOf(page);
                        return index;
                    }

                    @Override
                    public boolean isEnabled() {
                        boolean enabled = super.isEnabled();
                        return enabled && getPageIndex() < getPages().size() - 1;
                    }

                });
            }
        });
        taskviewer.getTable().setMenu(mm.createContextMenu(taskviewer.getControl()));

    }

    public OverviewPage getOverviewPage() {
        return overviewPage;
    }

    private void doNewTask(Shell shell) {
        final Task newTask = ModuleFactory.eINSTANCE.createTask();
        final Module module = getModelProvider().getModel();
        EList<Task> tasks = module.getTasks();
        int maxIndex = 0;
        for (Task task : tasks) {
            maxIndex = Math.max(maxIndex, task.getIndex());
        }
        final int newIndex = maxIndex + 1;
        EditingDomain domain = getModelProvider().getEditingDomain();
        domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
            @Override
            protected void doExecute() {
                int taskCount = module.getTasks().size();
                newTask.setModule(module);
                newTask.setIndex(newIndex);
                newTask.setCycleTime(1000);
                if (taskCount == 0) {
                    newTask.setKind(TaskKind.INIT);
                    newTask.setName("Task_init");
                } else {
                    newTask.setKind(TaskKind.CYCLIC);
                    newTask.setName("Task_run_" + (newIndex - 1));
                }
            }
        });

        TaskEditorDialog.editTask(newTask, shell, getModelProvider(), EditMode.NEW);
    }

    private void createAndOpenDiagram(final Task task, Shell shell) {
        Assert.isNotNull(task, "task");
        final Page page = ModuleFactory.eINSTANCE.createPage();
        if (IDialogConstants.OK_ID == DiagrammEditorDialog.editDiagramm(shell,
                TaskModelProvider.create(getModelProvider(), task), page, EditMode.NEW)) {
            EditorUtil.openPageEditor(page);
        }
    }

    private void doDeleteTask(Task task) {
        EList<Page> taskPages = task.getPages();
        for (Page page : taskPages) {
            Command command = DeleteCommand.create(getModelProvider().getEditingDomain(), page);
            getModelProvider().getEditingDomain().getCommandStack().execute(command);
        }
        Command command = DeleteCommand.create(getModelProvider().getEditingDomain(), task);
        getModelProvider().getEditingDomain().getCommandStack().execute(command);
        if (getModelProvider().getModel().getTasks().size() > 0) {
            Task lastTask = getModelProvider().getModel().getTasks()
                    .get(getModelProvider().getModel().getTasks().size() - 1);
            taskviewer.setSelection(new StructuredSelection(lastTask), true);

        }
    }

    private String diagramToXmi(Page page, Diagram egmfDiagram) {
        EcoreUtil.Copier diagramCopy = new EcoreUtil.Copier();
        Diagram copiedDiagram = (Diagram) diagramCopy.copy(egmfDiagram);
        diagramCopy.copyReferences();
        EcoreUtil.resolveAll(copiedDiagram);
        EcoreUtil.delete(copiedDiagram);
        EcoreUtil.Copier pageCopy = new EcoreUtil.Copier();
        Page copiedPage = (Page) pageCopy.copy(page);
        pageCopy.copyReferences();
        Set<Entry<EObject, EObject>> entries = diagramCopy.entrySet();
        for (Entry<EObject, EObject> entry : entries) {
            EObject copy = entry.getValue();
            if (copy instanceof View) {
                View view = (View) copy;
                EObject modelObject = view.getElement();
                EObject copiedModelObject = pageCopy.get(modelObject);
                view.setElement(copiedModelObject);
            }
        }
        EcoreUtil.resolveAll(copiedPage);
        EcoreUtil.delete(copiedPage);
        String data = EmfXmlConverter.convertToXml2(copiedDiagram, copiedPage);
        return data;
    }

}
