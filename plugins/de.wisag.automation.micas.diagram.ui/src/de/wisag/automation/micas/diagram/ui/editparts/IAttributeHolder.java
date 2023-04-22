package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.emf.ecore.EClass;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.Module;

public interface IAttributeHolder {
    void setNewAttribute(Attribute attribute);

    Attribute getAttribute();

    EClass getAttributeType();

    Module getModule();
}
