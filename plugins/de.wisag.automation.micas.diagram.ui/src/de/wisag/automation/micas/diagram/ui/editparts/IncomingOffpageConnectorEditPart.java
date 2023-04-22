package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.SignalSpecification;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class IncomingOffpageConnectorEditPart extends OffpageConnectorEditPart implements IAttributeHolder {

    public IncomingOffpageConnectorEditPart(View view) {
        super(view);
    }

    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        DialogOnDoubleclickHelper.installAssignSymbolDialogOnDoubleClick(this, new AbstractSymbolSelectionHelper() {
            @Override
            public void setAttribute(FragmentElement fe, Attribute attribute) {
                setNewAttribute(attribute);
            }

            @Override
            public SymbolFilter getSymbolFilter() {
                return SymbolFilter.createFilter(ModulePackage.Literals.VARIABLE_ATTRIBUTE);
            }
        });

    }

    @Override
    protected void addSemanticListeners() {
        super.addSemanticListeners();
        Component component = getComponent();
        if (component != null) {
            OutputPort firstOutputPort = component.getFirstOutputPort();
            addListenerFilter(Port.class.getCanonicalName(), this, firstOutputPort);
            if (firstOutputPort.getSignal() != null
                    && (firstOutputPort.getSignal() instanceof AttributeSpecification)) {
                AttributeSpecification signal = (AttributeSpecification) firstOutputPort.getSignal();
                addListenerFilter(AttributeSpecification.class.getCanonicalName(), this, signal);
                Attribute attribute = signal.getAttribute();
                if (attribute != null) {
                    addListenerFilter(Attribute.class.getCanonicalName(), this, attribute);
                }

            }
        }
    }

    private Component getComponent() {
        EObject semanticElement = resolveSemanticElement();
        if (semanticElement instanceof Component) {
            Component component = (Component) semanticElement;
            return component;
        } else {
            return null;
        }
    }

    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter(Port.class.getCanonicalName());
        removeListenerFilter(AttributeSpecification.class.getCanonicalName());
        removeListenerFilter(Attribute.class.getCanonicalName());
        super.removeSemanticListeners();
    }

    @Override
    protected String getContentText() {

        Attribute attribute = getAttribute();
        return attribute != null ? attribute.getName() : NOT_SET_TEXT;
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {
        if (notification.getFeature() == DMLPackage.Literals.OUTPUT_PORT__SIGNAL
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE__NAME
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE) {
            refreshContent();
        }
        super.handleNotificationEvent(notification);

    }

    @Override
    public void setNewAttribute(Attribute attribute) {
        Component component = getComponent();
        OutputPort firstOutputPort = component.getFirstOutputPort();
        if (firstOutputPort.getSignal() != null) {
            AttributeSpecification spec = (AttributeSpecification) firstOutputPort.getSignal();
            ModuleUtil.removeAttributeIfUnused(spec);
            firstOutputPort.setSignal(null);
        }
        AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSpecification.setAttribute(attribute);
        firstOutputPort.setSignal(attributeSpecification);
    }

    @Override
    public Attribute getAttribute() {
        Attribute attribute = null;
        Component component = getComponent();
        if (component != null) {
            SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                AttributeSpecification attributeSpecification = (AttributeSpecification) signalSpecification;
                if (attributeSpecification.getAttribute() != null
                        && attributeSpecification.getAttribute().getName() != null) {
                    // text = attributeSpecification.getAttribute().getName();
                    attribute = attributeSpecification.getAttribute();
                }
            }
        }
        return attribute;
    }

    @Override
    public EClass getAttributeType() {
        return ModulePackage.eINSTANCE.getVariableAttribute();
    }

    @Override
    public Module getModule() {
        FragmentElement component = getComponent();
        Page page = (Page) component.getEnclosingFragment();
        return page.getTask().getModule();
    }

}
