package de.wisag.automation.micas.module.ui.dialogs;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;
import de.wisag.automation.micas.module.ui.editor.IModelProvider;

public class TaskEditorDialog extends MicasDomainEditorDialog<TaskEditorDialogPage, Task> {
    public TaskEditorDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected void bind(DataBindingContext dbc, TaskEditorDialogPage page) {
        Text txtTaskName = page.getTxtTaskName();
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(txtTaskName),
                EMFEditProperties.value(getEditingDomain(), ModulePackage.Literals.TASK__NAME).observe(getModel()),
                new EMFUpdateValueStrategy().setAfterGetValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        String name = (String) value;
                        if (StringUtils.isEmpty(name)) {
                            return ValidationStatus.error("Der Taskname darf nicht leer sein");
                        }
                        return ValidationStatus.ok();
                    }
                })//
                , new EMFUpdateValueStrategy());

        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtTaskIndex()),
                EMFEditProperties.value(getEditingDomain(), ModulePackage.Literals.TASK__INDEX).observe(getModel()),
                new EMFUpdateValueStrategy().setAfterConvertValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        Integer i = (Integer) value;
                        boolean unique = true;
                        EList<Task> tasks = getModel().getModule().getTasks();
                        for (Task task : tasks) {
                            if (task.getIndex() == i.intValue() && !task.equals(getModel())) {
                                unique = false;
                                break;
                            }
                        }
                        if (!unique) {
                            return ValidationStatus.error("Wert für Task-Index '" + i + "' existiert schon");
                        }
                        if (i > 0 && i <= 254) {
                            return ValidationStatus.ok();
                        }
                        if (i > 254) {
                            return ValidationStatus.error("Wert für Taskindex zu groß");
                        }

                        return ValidationStatus.error("Wert für Taskindex muss > 0 sein");
                    }
                }), new EMFUpdateValueStrategy());

        dbc.bindValue(
                WidgetProperties.text(SWT.Modify).observe(page.getTxtTxtcycletime()), EMFEditProperties
                        .value(getEditingDomain(), ModulePackage.Literals.TASK__CYCLE_TIME).observe(getModel()),
                new EMFUpdateValueStrategy().setAfterConvertValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        Integer i = (Integer) value;
                        if (i > 0 && (i % 50 == 0)) {
                            return ValidationStatus.ok();
                        }
                        if ((i % 50 != 0)) {
                            return ValidationStatus.error("Zykluszeit muss ein vielfaches von 50 sein");
                        }
                        return ValidationStatus.error("Zykluszeit muss grösser als 0 sein");
                    }
                }), new EMFUpdateValueStrategy());
        ComboViewer comboViewer = new ComboViewer(page.getCmbTaskType());
        comboViewer.setContentProvider(new ArrayContentProvider());
        comboViewer.setInput(TaskKind.VALUES);
        comboViewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return ((TaskKind) element).getName();
            }
        });

        IViewerObservableValue comboSelection = ViewerProperties.singleSelection().observe(comboViewer);
        dbc.bindValue(comboSelection, WidgetProperties.enabled().observe(page.getTxtTxtcycletime()),
                new UpdateValueStrategy().setConverter(new IConverter() {
                    @Override
                    public Object getToType() {
                        return Boolean.class;
                    }

                    @Override
                    public Object getFromType() {
                        return TaskKind.class;
                    }

                    @Override
                    public Object convert(Object fromObject) {
                        TaskKind kind = (TaskKind) fromObject;
                        return kind == TaskKind.CYCLIC;
                    }
                }), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));

        dbc.bindValue(comboSelection, //
                EMFEditProperties.value(getEditingDomain(), ModulePackage.Literals.TASK__KIND).observe(getModel())//
        );

        if (getEditMode() == EditMode.NEW) {
            txtTaskName.setFocus();
            txtTaskName.selectAll();
        }
    }

    public static void editTask(Task task, Shell shell, IModelProvider<Module> modelProvider, EditMode editMode) {
        TaskEditorDialog dlg = new TaskEditorDialog(shell);
        dlg.setEditingDomain(modelProvider.getEditingDomain());
        dlg.setDataBindingContext(modelProvider.getDataBindingContext());
        dlg.setDialogTitle("Task");
        dlg.setModel(task);
        dlg.setEditMode(editMode);

        if (IDialogConstants.OK_ID == dlg.open()) {

            EditingDomain editingDomain = modelProvider.getEditingDomain();
            Module model = modelProvider.getModel();

            Command create = AddCommand.create(editingDomain, model, ModulePackage.Literals.MODULE__TASKS, task);
            editingDomain.getCommandStack().execute(create);
        } else {

        }
    }

    @Override
    protected TaskEditorDialogPage doCreateDialogPage(Composite parent) {
        return new TaskEditorDialogPage(parent, SWT.NONE);
    }

}
