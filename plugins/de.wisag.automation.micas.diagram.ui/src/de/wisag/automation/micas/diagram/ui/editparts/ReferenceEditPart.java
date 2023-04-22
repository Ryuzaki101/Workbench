package de.wisag.automation.micas.diagram.ui.editparts;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.EditableContentComponentEditPart;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.SignalSpecification;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.diagram.ui.figures.ReferenceFigure;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class ReferenceEditPart extends EditableContentComponentEditPart implements IAttributeHolder {

    public ReferenceEditPart(View view) {
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
                return SymbolFilter.createFilter(ModulePackage.Literals.REFERENCE_ATTRIBUTE);
            }
        });
    }

    @Override
    protected NodeFigure createMainFigure() {
        return new ReferenceFigure();
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
                Attribute attribute = signal.getAttribute();
                addListenerFilter(Attribute.class.getCanonicalName(), this, attribute);
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
    protected ICommand createParseCommand(IAdaptable element, String newString, int flags) {
        return null;
    }

    @Override
    protected void refreshVisuals() {
        Component component = getComponent();
        if (component != null) {
            SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                Attribute attribute = ((AttributeSpecification) signalSpecification).getAttribute();

                IFigure toolTip = getFigure().getToolTip();
                if (toolTip == null) {
                    if (attribute != null && attribute.getDescription() != null) {
                        getFigure().setToolTip(new Label(String.format("Description : %s", getDescription(attribute))));
                    }
                } else if (toolTip instanceof LabelEx) {
                    Label label = (Label) toolTip;
                    if (attribute != null && attribute.getDescription() != null) {
                        label.setText(String.format("Description : %s", getDescription(attribute)));
                    }
                }
            }
        }
        super.refreshVisuals();
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
        return getReferenceAttribute() != null ? getReferenceAttribute().getName() : text;
    }

    ReferenceAttribute getReferenceAttribute() {
        Component component = getComponent();
        ReferenceAttribute referenceAttribute = null;
        if (component != null) {
            SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                Attribute attribute = ((AttributeSpecification) signalSpecification).getAttribute();
                if (attribute instanceof ReferenceAttribute) {
                    ReferenceAttribute constantAttribute = (ReferenceAttribute) attribute;
                    referenceAttribute = constantAttribute;

                }
            }
        }
        return referenceAttribute;
    }

    public String getLabelText() {
        String text = "????:?,?";
        Component component = getComponent();
        if (component != null) {
            SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                Attribute attribute = ((AttributeSpecification) signalSpecification).getAttribute();
                if (attribute instanceof ReferenceAttribute) {
                    ReferenceAttribute constantAttribute = (ReferenceAttribute) attribute;
                    int row = constantAttribute.getRow();
                    int column = constantAttribute.getColumn();
                    text = constantAttribute.getName() + ":" + Integer.toString(row) + "," + Integer.toString(column);
                }
            }
        }
        return text;
    }

    private String getDescription(Attribute constantAttribute) {
        if (!StringUtils.isEmpty(constantAttribute.getDescription())) {
            return String.format(" (%s)", constantAttribute.getDescription());
        }
        return "";
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {
        if (notification.getFeature() == DMLPackage.Literals.OUTPUT_PORT__SIGNAL
                || notification.getFeature() == ModulePackage.Literals.REFERENCE_ATTRIBUTE__ROW
                || notification.getFeature() == ModulePackage.Literals.REFERENCE_ATTRIBUTE__COLUMN
                || notification.getFeature() == ModulePackage.Literals.REFERENCE_ATTRIBUTE__REFERENCE_TYPE
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE) {
            refreshContent();
        } else {
            super.handleNotificationEvent(notification);
        }
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
    public Attribute getAttribute() {
        return getReferenceAttribute();
    }

    @Override
    public EClass getAttributeType() {
        return ModulePackage.eINSTANCE.getReferenceAttribute();
    }

    @Override
    public Module getModule() {
        FragmentElement component = getComponent();
        Page page = (Page) component.getEnclosingFragment();
        return page.getTask().getModule();
    }

}
