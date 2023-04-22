package de.wisag.automation.micas.diagram.ui.editparts;

import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.ISignalListener;
import org.eclipselabs.damos.dml.util.SignalEvent;
import org.eclipselabs.damos.dml.util.SignalEventBroker;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.diagram.ui.editpolicies.ConnectionSemanticEditPolicy;
import de.wisag.automation.micas.diagram.ui.figures.ConnectionFigure;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.ModuleUtil;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.rt.RtWordVariable;

public class ConnectionEditPart extends org.eclipselabs.damos.diagram.ui.editparts.ConnectionEditPart
        implements IAttributeHolder {

    private static RGB FLOAT_CONNECTION_COLOR = new RGB(0, 239, 0);
    private static RGB WORD_CONNECTION_COLOR = new RGB(0, 0, 215);

    private static int FLOAT_CONNECTION_WIDTH = 3;
    private static int WORD_CONNECTION_WIDTH = 2;

    private Connection cachedConnection;

    private final ISignalListener signalListener = new ISignalListener() {

        @Override
        public void signalChanged(SignalEvent event) {
            refreshConnectionType();
        }

    };

    private Label connectionLabel;

    public ConnectionEditPart(View view) {
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

            @Override
            protected boolean canRun(FragmentElement element) {
                Connection connection = (Connection) element;
                OutputConnector source = connection.getSource();
                InputConnector target = connection.getTarget();
                if (source instanceof BlockOutputPort && target instanceof BlockInputPort) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        });
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConnectionSemanticEditPolicy());

    }

    @Override
    public void activate() {
        super.activate();
        Connection connection = getConnection();
        if (connection != null) {
            this.cachedConnection = connection;
            SignalEventBroker.addListener(this.cachedConnection, this.signalListener);
        }
    }

    private Connection getConnection() {
        EObject semanticElement = resolveSemanticElement();
        if (semanticElement instanceof Connection) {
            Connection connection = (Connection) semanticElement;
            return connection;
        } else {
            return null;
        }
    }

    @Override
    public void deactivate() {
        if (this.cachedConnection != null) {
            SignalEventBroker.removeListener(this.cachedConnection, this.signalListener);
        }
        super.deactivate();
    }

    @Override
    protected void refreshConnectionType() {
        Connection connection = getConnection();
        if (connection == null) {
            return;
        }
        DataType dataType = ModuleUtil.getDataType(connection);
        int width = (dataType == DataType.FLOAT ? 4 : 2) * IFigureConstants.DEFAULT_LINE_WIDTH;
        Color color = ModuleUtil.isValid(connection) ? ColorConstants.black : ColorConstants.red;

        if (dataType == DataType.WORD) {
            setLineWidth(WORD_CONNECTION_WIDTH * IFigureConstants.DEFAULT_LINE_WIDTH);
            setLineColor(ColorRegistry.getInstance().getColor(WORD_CONNECTION_COLOR));
        } else if (dataType == DataType.FLOAT) {
            setLineWidth(width);
            setLineColor(ColorRegistry.getInstance().getColor(FLOAT_CONNECTION_COLOR));
            setLineWidth(FLOAT_CONNECTION_WIDTH * IFigureConstants.DEFAULT_LINE_WIDTH);
        } else {
            setLineWidth(width);
            setLineColor(color);
        }
    }

    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();
        Attribute attribute = getAttribute();
        String attributeName = attribute != null ? attribute.getName() : null;
        IFigure toolTip = getFigure().getToolTip();
        if (toolTip == null) {
            if (attributeName != null) {
                getFigure().setToolTip(new Label(String.format("Symbol : %s", attribute.getName())));
            }
        } else if (toolTip instanceof LabelEx || toolTip instanceof Label) {
            Label label = (Label) toolTip;
            if (attributeName != null) {
                label.setText(String.format("Symbol : %s", attribute.getName()));
            }
        }
        DiagramRootEditPart editPart = (DiagramRootEditPart) getParent();
        CustomBlockDiagramEditPart block = (CustomBlockDiagramEditPart) editPart.getContents();

        if (attributeName != null) {
            block.registerConnectionEditPartByName(attribute.getName(), this);
        }

    }

    @Override
    protected void setLineWidth(int width) {
        ((ConnectionFigure) getFigure()).setLineWidth(width);
    }

    protected void setLineColor(Color color) {
        ((ConnectionFigure) getFigure()).setForegroundColor(color);
    }

    @Override
    protected PolylineConnection createConnectionFigure() {
        if (getModel() == null) {
            return null;
        }

        ConnectionFigure connectionFigure = new ConnectionFigure();
        this.connectionLabel = new LabelEx("");
        this.connectionLabel.setBackgroundColor(ColorConstants.white);
        this.connectionLabel.setForegroundColor(ColorConstants.black);
        this.connectionLabel.setOpaque(true);
        LineBorder border = new LineBorder() {
            @Override
            public Insets getInsets(IFigure figure) {
                return new Insets(10);
            }
        };

        this.connectionLabel.setBorder(border);
        this.connectionLabel.setVisible(false);

        connectionFigure.add(this.connectionLabel, new OnConnectionLocator(connectionFigure, 50));
        return connectionFigure;
    }

    @Override
    protected void addSemanticListeners() {
        super.addSemanticListeners();
        Connection connection = getConnection();

        OutputPort source = ModuleUtil.getConnectionSource(connection);
        if (source != null) {
            addListenerFilter(OutputPort.class.getCanonicalName(), this, source);
        }

        AttributeSpecification attributeSpecification = ModuleUtil.getConnectionAttributeSpecification(connection);
        if (attributeSpecification != null) {
            addListenerFilter(AttributeSpecification.class.getCanonicalName(), this, attributeSpecification);
        }

        Attribute attribute = ModuleUtil.getConnectionAttribute(connection);
        if (attribute != null) {
            addListenerFilter(Attribute.class.getCanonicalName(), this, attribute);
        }
    }

    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter(OutputPort.class.getCanonicalName());
        removeListenerFilter(AttributeSpecification.class.getCanonicalName());
        removeListenerFilter(Attribute.class.getCanonicalName());
        super.removeSemanticListeners();

    }

    public Label getConnectionLabel() {
        return this.connectionLabel;
    }

    @Override
    protected void handleNotificationEvent(Notification notification) {

        if (notification.getFeature() == DMLPackage.Literals.OUTPUT_PORT__SIGNAL
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE__NAME
                || notification.getFeature() == ModulePackage.Literals.ATTRIBUTE__DATA_TYPE) {
            refreshVisuals();
        }
        super.handleNotificationEvent(notification);
    }

    public void showValue(MonitoredValue value) {
        if (value.getRtSymbol() instanceof RtWordVariable) {
            if (0 != NumberUtils.toInt(value.getValue(), 0)) {
                setLineWidth(WORD_CONNECTION_WIDTH * 2 * IFigureConstants.DEFAULT_LINE_WIDTH);
            } else {
                setLineWidth(WORD_CONNECTION_WIDTH * IFigureConstants.DEFAULT_LINE_WIDTH);
            }
        }
        getConnectionLabel().setText(String.format(" %s ", value.getValue()));

    }

    public boolean isInterBlockConnection() {
        Connection connection = getConnection();
        if (connection == null) {
            return false;
        }
        OutputConnector source = connection.getSource();
        InputConnector target = connection.getTarget();
        if (source == null || target == null) {
            return false;
        }
        return source instanceof BlockOutputPort && target instanceof BlockInputPort;
    }

    @Override
    public void setNewAttribute(Attribute attribute) {
        Connection connection = getConnection();
        OutputConnector source = connection.getSource();
        InputConnector target = connection.getTarget();
        if (source instanceof BlockOutputPort && target instanceof BlockInputPort) {
            BlockOutputPort sourcePort = (BlockOutputPort) source;
            if (sourcePort.getSignal() != null) {
                ModuleUtil.removeAttributeIfUnused((AttributeSpecification) sourcePort.getSignal());
            }

            AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
            attributeSpecification.setAttribute(attribute);
            sourcePort.setSignal(attributeSpecification);
        }
    }

    @Override
    public Attribute getAttribute() {
        Connection connection = getConnection();
        Attribute attribute = ModuleUtil.getConnectionAttribute(connection);
        return attribute;
    }

    @Override
    public EClass getAttributeType() {
        return ModulePackage.eINSTANCE.getVariableAttribute();
    }

    @Override
    public Module getModule() {
        FragmentElement component = getConnection();
        Page page = (Page) component.getEnclosingFragment();
        return page.getTask().getModule();
    }
}
