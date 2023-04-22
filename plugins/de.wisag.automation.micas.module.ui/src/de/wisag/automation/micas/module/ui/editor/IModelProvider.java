package de.wisag.automation.micas.module.ui.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

public interface IModelProvider<E extends EObject> {
    E getModel();

    EditingDomain getEditingDomain();

    DataBindingContext getDataBindingContext();
}
