package de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions;

import static de.wisag.automation.micas.common.ui.SelectionUtils.singleSelection;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TableViewer;

import de.wisag.automation.micas.olt.ISymbolMonitorManager;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;
import de.wisag.automation.micas.olt.ui.internal.views.ISymbolMonitorManagerProvider;

public class AbstractSymbolViewerAction extends Action {

    private final ISymbolMonitorStatusControl statusControl;

    public ISymbolMonitorStatusControl getStatusControl() {
        return statusControl;
    }

    private final ISymbolMonitorManagerProvider symbolMonitorManagerProvider;
    private final TableViewer monitorTableViewer;

    public AbstractSymbolViewerAction(String text, ImageDescriptor image,
            ISymbolMonitorManagerProvider symbolMonitorManager, ISymbolMonitorStatusControl statusControl,
            TableViewer monitorTableViewer) {
        super(text, image);
        this.symbolMonitorManagerProvider = Objects.requireNonNull(symbolMonitorManager);
        this.monitorTableViewer = Objects.requireNonNull(monitorTableViewer);
        this.statusControl = statusControl;

    }

    protected MonitoredItem getCurrentItem() {
        return singleSelection(MonitoredItem.class, getMonitorTableViewer().getSelection());
    }

    public Optional<ISymbolMonitorManager> getSymbolMonitorManager() {
        return symbolMonitorManagerProvider.getSymbolMonitorManager();
    }

    public TableViewer getMonitorTableViewer() {
        return monitorTableViewer;
    }

}
