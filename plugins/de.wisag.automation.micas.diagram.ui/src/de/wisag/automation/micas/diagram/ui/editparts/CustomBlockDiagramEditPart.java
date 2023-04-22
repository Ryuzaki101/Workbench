package de.wisag.automation.micas.diagram.ui.editparts;

import java.util.Collection;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.PageBreakEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipselabs.damos.diagram.ui.editparts.BlockDiagramEditPart;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import de.wisag.automation.micas.diagram.ui.editpolicies.CustomContainerEditPolicy;
import de.wisag.automation.micas.diagram.ui.editpolicies.MapItemSemanticEditPolicy;
import de.wisag.automation.micas.diagram.ui.figures.TemplateFigure;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.PageFormat;
import de.wisag.automation.micas.module.PageOrientation;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;

@SuppressWarnings("restriction")
public class CustomBlockDiagramEditPart extends BlockDiagramEditPart {

    private static final int MARGIN_BORDER = 500;

    private static final String A4_WIDTH = "8.267716535433072";
    private static final String A4_HEIGHT = "11.692913385826772";

    private static final String A3_WIDTH = "11.692913385826772";
    private static final String A3_HEIGHT = "16.535433070866144";

    private IFigure contentPane;
    private final Multimap<String, ConnectionEditPart> registeredParts = ArrayListMultimap.create();

    public CustomBlockDiagramEditPart(View diagramView) {
        super(diagramView);
    }

    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MapItemSemanticEditPolicy());
        removeEditPolicy(EditPolicy.CONTAINER_ROLE);
        installEditPolicy(EditPolicy.CONTAINER_ROLE, new CustomContainerEditPolicy());
    }

    @Override
    protected IFigure createFigure() {
        Page page = (Page) ((Diagram) getModel()).getElement();
        Module module = page.getTask().getModule();
        PageFormat pageFormat = module.getPageFormat();
        PageOrientation pageOrientation = module.getPageOrientation();

        this.contentPane = new FreeformLayer(); // init with some dummy layer,
                                                // otherwise the
        // changes to the prefStore results in a NPE
        IPreferenceStore store = (IPreferenceStore) ((IDiagramPreferenceSupport) getViewer().getRootEditPart())
                .getPreferencesHint().getPreferenceStore();
        apply(store, WorkspaceViewerProperties.PREF_USE_PORTRAIT, pageOrientation == PageOrientation.PORTRAIT);
        apply(store, WorkspaceViewerProperties.PREF_USE_LANDSCAPE, pageOrientation == PageOrientation.LANDSCAPE);
        apply(store, WorkspaceViewerProperties.PREF_PAGE_SIZE, pageFormat.getName());
        apply(store, WorkspaceViewerProperties.PREF_PAGE_HEIGHT, pageFormat == PageFormat.A4 ? A4_HEIGHT : A3_HEIGHT);
        apply(store, WorkspaceViewerProperties.PREF_PAGE_WIDTH, pageFormat == PageFormat.A4 ? A4_WIDTH : A3_WIDTH);
        // WorkspaceViewerProperties.VIEWRULERS;

        PageBreakEditPart pageBreakeEditPart = ((DiagramRootEditPart) getRoot()).getPageBreakEditPart();
        final Point pageSize = pageBreakeEditPart.getPageSize();
        FreeformLayer pane = new FreeformLayer() {

            @Override
            public Rectangle getFreeformExtent() {
                return new Rectangle(-MARGIN_BORDER, -MARGIN_BORDER, pageSize.x + MARGIN_BORDER,
                        pageSize.y + MARGIN_BORDER); // adjust the height of the
                                                     // content
                                                     // pane
            }

        };
        IFigure templateFigure = new TemplateFigure(new Rectangle(0, 0, pageSize.x, pageSize.y), getMapMode(), page);
        pane.add(this.contentPane = templateFigure);
        return pane;
    }

    private static void apply(IPreferenceStore store, String key, String value) {
        if (!store.contains(key)) {
            store.setDefault(key, value);
        } else {
            store.setValue(key, value);
        }
    }

    private static void apply(IPreferenceStore store, String key, boolean value) {
        if (!store.contains(key)) {
            store.setDefault(key, value);
        } else {
            store.setValue(key, value);
        }
    }

    @Override
    public IFigure getContentPane() {
        return this.contentPane;
    }

    public void registerConnectionEditPartByName(String name, ConnectionEditPart connectionEditPart) {
        // connections can appear multiple times on a drawing, therefore we use
        // a multimap
        if (!this.registeredParts.containsValue(connectionEditPart)) {
            this.registeredParts.put(name, connectionEditPart);
        }
    }

    public void beginDebugSession(MonitorModel monitorModel) {
        for (MonitoredItem item : monitorModel.getItems()) {
            if (item.getRtSymbol() == null) {
                continue;
            }
            if (item.getRtSymbol().getName() == null) {
                continue;
            }
            if (!registeredParts.containsKey(item.getRtSymbol().getName())) {
                continue;
            }
            for (ConnectionEditPart part : this.registeredParts.get(item.getRtSymbol().getName())) {
                part.getConnectionLabel().setText("0");
                part.getConnectionLabel().setVisible(true);
                part.getConnectionLabel().setOpaque(true);
                part.getConnectionLabel().revalidate();
            }
        }
    }

    public void endDebugSession(MonitorModel monitorModel) {
        for (MonitoredItem item : monitorModel.getItems()) {
            if (item.getRtSymbol() == null) {
                continue;
            }
            if (item.getRtSymbol().getName() == null) {
                continue;
            }
            if (!registeredParts.containsKey(item.getRtSymbol().getName())) {
                continue;
            }
            for (ConnectionEditPart part : this.registeredParts.get(item.getRtSymbol().getName())) {
                part.getConnectionLabel().setText("0");
                part.getConnectionLabel().setVisible(false);
                part.refreshConnectionType();
            }
        }
    }

    public void updateDebugSession(MonitoredValueSet set) {
        for (MonitoredValue value : set.getValues()) {
            if (this.registeredParts.containsKey(value.getName())) {
                Collection<ConnectionEditPart> parts = this.registeredParts.get(value.getName());
                for (ConnectionEditPart part : parts) {
                    part.showValue(value);
                }
            }
        }
    }

}
