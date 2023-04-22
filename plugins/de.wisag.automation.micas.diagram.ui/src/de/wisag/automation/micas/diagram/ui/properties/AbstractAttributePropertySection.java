package de.wisag.automation.micas.diagram.ui.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.SignalSpecification;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.Page;

public abstract class AbstractAttributePropertySection extends AbstractComboPropertySection {

    protected abstract boolean considerAttribute(Attribute attribute);

    protected abstract OutputPort getOutputPort();

    protected abstract Attribute handleMissingAttribute(String name);

    @Override
    protected List<String> getPropertyValueStrings() {
        OutputPort outputPort = getOutputPort();
        if (outputPort != null) {
            Fragment fragment = outputPort.getComponent().getOwningFragment();
            if (fragment instanceof Page) {
                Page page = (Page) fragment;
                List<String> attributeNames = new ArrayList<>();
                for (Attribute attribute : page.getTask().getModule().getAttributes()) {
                    if (considerAttribute(attribute)) {
                        attributeNames.add(attribute.getName());
                    }
                }
                return attributeNames;
            }
        }
        return Collections.emptyList();
    }

    @Override
    protected int getPropertyValueIndex() {
        OutputPort outputPort = getOutputPort();
        if (outputPort != null) {
            SignalSpecification signalSpecification = outputPort.getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                Fragment fragment = outputPort.getComponent().getOwningFragment();
                if (fragment instanceof Page) {
                    Page page = (Page) fragment;
                    List<Attribute> attributes = new ArrayList<>();
                    for (Attribute attribute : page.getTask().getModule().getAttributes()) {
                        if (considerAttribute(attribute)) {
                            attributes.add(attribute);
                        }
                    }
                    AttributeSpecification attributeSpecification = (AttributeSpecification) signalSpecification;
                    return attributes.indexOf(attributeSpecification.getAttribute());
                }
            }
        }
        return -1;
    }

    @Override
    protected void setPropertyValue(EObject object, Object value) {
        OutputPort outputPort = getOutputPort();
        if (outputPort != null) {
            Fragment fragment = outputPort.getComponent().getOwningFragment();
            if (fragment instanceof Page) {
                Page page = (Page) fragment;
                Attribute attribute = null;
                for (Attribute a : page.getTask().getModule().getAttributes()) {
                    if (considerAttribute(a) && value.equals(a.getName())) {
                        attribute = a;
                        break;
                    }
                }
                if (attribute == null) {
                    attribute = handleMissingAttribute((String) value);
                }
                if (attribute != null) {
                    page.getTask().getModule().getAttributes().add(attribute);
                    AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE
                            .createAttributeSpecification();
                    attributeSpecification.setAttribute(attribute);
                    outputPort.setSignal(attributeSpecification);
                }
            }
        }
    }

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        // TODO Auto-generated method stub
        super.createControls(parent, aTabbedPropertySheetPage);
        getControl().setEditable(false);
    }

    @Override
    protected boolean propertyValueStringsChanged() {
        return true;
    }

}
