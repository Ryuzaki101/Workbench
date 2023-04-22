package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.EditableContentComponentEditPart;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.diagram.ui.figures.ConstantFigure;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Value;
import de.wisag.automation.micas.module.WordValue;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class ConstantEditPart extends EditableContentComponentEditPart implements IAttributeHolder {

    public ConstantEditPart(View view) {
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
                return SymbolFilter.createFilter(ModulePackage.Literals.CONSTANT_ATTRIBUTE);
            }
        });
    }

    @Override
    protected NodeFigure createMainFigure() {
        return new ConstantFigure();
    }

    @Override
    protected void addSemanticListeners() {
        super.addSemanticListeners();
        Component component = getComponent();
        if (component != null) {
            OutputPort firstOutputPort = component.getFirstOutputPort();
            addListenerFilter(Port.class.getCanonicalName(), this, firstOutputPort);
            AttributeSpecification signal = (AttributeSpecification) firstOutputPort.getSignal();
            if (signal != null && signal.getAttribute() != null) {
                addListenerFilter(AttributeSpecification.class.getCanonicalName(), this, signal);
                addListenerFilter(Attribute.class.getCanonicalName(), this, signal.getAttribute());
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
        removeListenerFilter(Attribute.class.getCanonicalName());
        removeListenerFilter(AttributeSpecification.class.getCanonicalName());
        super.removeSemanticListeners();
    }

    @Override
    protected ICommand createParseCommand(IAdaptable element, String newString, int flags) {
        return new SetValueCommand(new SetRequest(TransactionUtil.getEditingDomain(getAttribute()), getAttribute(),
                ModulePackage.Literals.ATTRIBUTE__NAME, newString));

    }

    @Override
    protected void refreshContent() {
        ILabelDelegate label = getContentLabel();
        if (label != null) {
            label.setText(getLabelText());
        }
    }

    @Override
    protected String getContentText() {
        String text = "????";
        Attribute constantAttribute = getAttribute();
        return constantAttribute != null ? constantAttribute.getName() : text;
    }

    protected String getLabelText() {
        String text = "????:?";
        ConstantAttribute constantAttribute = (ConstantAttribute) getAttribute();
        if (constantAttribute != null) {

            Value value = constantAttribute.getValue();
            String valueString = null;
            if (value instanceof FloatValue) {
                valueString = Double.toString(((FloatValue) value).getValue());
            } else if (value instanceof WordValue) {
                valueString = Integer.toString(((WordValue) value).getValue());
            }
            if (valueString != null) {
                text = constantAttribute.getName() + ":" + valueString;
            }
        }

        return text;
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {
        if (notification.getFeature() == DMLPackage.Literals.OUTPUT_PORT__SIGNAL
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE__NAME
                || notification.getFeature() == ModulePackage.Literals.CONSTANT_ATTRIBUTE__VALUE) {
            refreshContent();
        }
        super.handleNotificationEvent(notification);

    }

    @Override
    public Attribute getAttribute() {
        return ModuleUtil.getConstantAttribute(getComponent());
    }

    @Override
    public void setNewAttribute(Attribute attribute) {
        Component component = getComponent();
        OutputPort firstOutputPort = component.getFirstOutputPort();
        if (firstOutputPort.getSignal() != null) {
            ModuleUtil.removeAttributeIfUnused((AttributeSpecification) firstOutputPort.getSignal());
            firstOutputPort.setSignal(null);
        }
        AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSpecification.setAttribute(attribute);
        firstOutputPort.setSignal(attributeSpecification);
    }

    @Override
    public EClass getAttributeType() {
        return ModulePackage.eINSTANCE.getConstantAttribute();
    }

    @Override
    public Module getModule() {
        FragmentElement component = getComponent();
        Page page = (Page) component.getEnclosingFragment();
        return page.getTask().getModule();
    }

}
