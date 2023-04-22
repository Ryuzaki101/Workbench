package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.ui.editor.IModelProvider;

class TaskModelProvider implements IModelProvider<Task> {

    public TaskModelProvider(EditingDomain editingDomain, DataBindingContext dataBindingContext, Task task) {
        super();
        this.editingDomain = editingDomain;
        this.dataBindingContext = dataBindingContext;
        this.task = task;
    }

    private Task task;
    private EditingDomain editingDomain;
    private DataBindingContext dataBindingContext;

    @Override
    public Task getModel() {
        return this.task;
    }

    @Override
    public EditingDomain getEditingDomain() {
        return this.editingDomain;
    }

    @Override
    public DataBindingContext getDataBindingContext() {
        return this.dataBindingContext;
    }

    public static IModelProvider<Task> create(IModelProvider<? extends EObject> modelProvider, Task task) {
        return new TaskModelProvider(modelProvider.getEditingDomain(), modelProvider.getDataBindingContext(), task);
    }

}