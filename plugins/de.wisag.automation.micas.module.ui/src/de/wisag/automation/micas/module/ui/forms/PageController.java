package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.module.ui.editor.IModelProvider;

public class PageController<T extends EObject> {

    private IModelProvider<T> modelProvider;

    public IModelProvider<T> getModelProvider() {
        return modelProvider;
    }

    public DataBindingContext getDataBindingContext() {
        return getModelProvider().getDataBindingContext();
    }

    public void setModelProvider(IModelProvider<T> modelProvider) {
        this.modelProvider = modelProvider;
    }

}
