package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.FragmentSelectionManager;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.ConnectionEvent;
import org.eclipselabs.damos.dml.util.ConnectionEventBroker;
import org.eclipselabs.damos.dml.util.IConnectionListener;
import org.eclipselabs.damos.dml.util.ISignalListener;
import org.eclipselabs.damos.dml.util.SignalEvent;
import org.eclipselabs.damos.dml.util.SignalEventBroker;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class OutgoingOffpageConnectorEditPart extends OffpageConnectorEditPart implements IAttributeHolder {

    private InputPort cachedInputPort;
    private Listener listener = new Listener();

    public OutgoingOffpageConnectorEditPart(View view) {
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
    public void activate() {
        super.activate();
        OutgoingOffpageConnector offpageConnector = getOutgoingOffpageConnector();
        if (offpageConnector != null) {
            cachedInputPort = offpageConnector.getFirstInputPort();
            if (cachedInputPort != null) {
                ConnectionEventBroker.addListener(cachedInputPort, listener);
                SignalEventBroker.addListener(cachedInputPort, listener);
            }
        }
    }

    private OutgoingOffpageConnector getOutgoingOffpageConnector() {
        EObject semanticElement = resolveSemanticElement();
        if (semanticElement instanceof OutgoingOffpageConnector) {
            return (OutgoingOffpageConnector) semanticElement;
        } else {
            return null;
        }
    }

    @Override
    public void deactivate() {
        if (cachedInputPort != null) {
            ConnectionEventBroker.removeListener(cachedInputPort, listener);
            SignalEventBroker.removeListener(cachedInputPort, listener);
        }
        super.deactivate();
    }

    @Override
    protected String getContentText() {
        Attribute attribute = getAttribute();
        return attribute != null ? attribute.getName() : NOT_SET_TEXT;
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

    private class Listener implements IConnectionListener, ISignalListener {

        @Override
        public void connectionChanged(ConnectionEvent event) {
            refreshContent();
        }

        @Override
        public void signalChanged(SignalEvent event) {
            refreshContent();
        }

    }

    @Override
    public Attribute getAttribute() {
        Attribute attribute = null;
        Component component = getComponent();
        if (component != null && getRoot() != null && getRoot().getContents() != null) {
            FragmentSelectionManager fragmentSelectionManager = getRoot().getContents()
                    .getAdapter(FragmentSelectionManager.class);
            if (fragmentSelectionManager != null) {
                Connection connection = component.getFirstInputPort()
                        .getFirstConnection(fragmentSelectionManager.getSelectedFragment());
                AttributeSpecification attributeSpecification = ModuleUtil.getAttributeSpecification(connection);
                if (attributeSpecification != null && attributeSpecification.getAttribute() != null) {
                    attribute = attributeSpecification.getAttribute();
                }
            }
        }
        return attribute;
    }

    @Override
    public void setNewAttribute(Attribute attribute) {
        Component component = getComponent();
        FragmentSelectionManager fragmentSelectionManager = getRoot().getContents()
                .getAdapter(FragmentSelectionManager.class);
        if (fragmentSelectionManager != null) {
            Connection connection = component.getFirstInputPort()
                    .getFirstConnection(fragmentSelectionManager.getSelectedFragment());
            OutputPort sourcePort = ModuleUtil.getSourcePort(connection);
            if (sourcePort != null) {
                if (sourcePort.getSignal() != null) {
                    ModuleUtil.removeAttributeIfUnused((AttributeSpecification) sourcePort.getSignal());
                    sourcePort.setSignal(null);
                }
                AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
                attributeSpecification.setAttribute(attribute);
                sourcePort.setSignal(attributeSpecification);
            }
        }
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

    // listeners
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
    protected void addSemanticListeners() {
        super.addSemanticListeners();
        Component component = getComponent();
        if (component != null) {
            FragmentSelectionManager fragmentSelectionManager = getRoot().getContents()
                    .getAdapter(FragmentSelectionManager.class);
            if (fragmentSelectionManager != null) {
                Connection connection = component.getFirstInputPort()
                        .getFirstConnection(fragmentSelectionManager.getSelectedFragment());
                AttributeSpecification attributeSpecification = ModuleUtil.getAttributeSpecification(connection);
                if (attributeSpecification != null) {
                    addListenerFilter(AttributeSpecification.class.getCanonicalName(), this, attributeSpecification);
                    Attribute attribute = attributeSpecification.getAttribute();
                    if (attribute != null) {
                        addListenerFilter(Attribute.class.getCanonicalName(), this, attribute);
                    }
                }
            }
        }

    }

    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter(AttributeSpecification.class.getCanonicalName());
        removeListenerFilter(Attribute.class.getCanonicalName());
        super.removeSemanticListeners();
    }
}
