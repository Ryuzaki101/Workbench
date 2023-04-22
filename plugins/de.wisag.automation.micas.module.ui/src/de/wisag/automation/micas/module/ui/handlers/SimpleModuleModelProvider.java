package de.wisag.automation.micas.module.ui.handlers;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ui.editor.IModelProvider;

final class SimpleModuleModelProvider implements IModelProvider<Module> {
    private Module module;
    private DataBindingContext context;

    public SimpleModuleModelProvider(Module module, DataBindingContext context) {
        super();
        this.module = module;
        this.context = context;
    }

    @Override
    public Module getModel() {
        return this.module;
    }

    @Override
    public EditingDomain getEditingDomain() {
        return TransactionUtil.getEditingDomain(this.module);
    }

    @Override
    public DataBindingContext getDataBindingContext() {
        return this.context;
    }
}