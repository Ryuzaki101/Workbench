package de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;
import de.wisag.automation.micas.olt.ui.internal.Activator;
import de.wisag.automation.micas.olt.ui.internal.views.ISymbolMonitorManagerProvider;

public class RemoveSymbolAction extends AbstractSymbolViewerAction {
    public RemoveSymbolAction(ISymbolMonitorManagerProvider symbolMonitorManager,
            ISymbolMonitorStatusControl statusControl, TableViewer monitorTableViewer) {
        super("Entfernen",
                AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/delete_element.gif"),
                symbolMonitorManager, statusControl, monitorTableViewer);
    }

    @Override
    public boolean isEnabled() {
        MonitoredItem item = SelectionUtils.singleSelection(MonitoredItem.class,
                getMonitorTableViewer().getSelection());
        return item != null && getStatusControl().isRunning() && !getStatusControl().isPaused();
    }

    @Override
    public void run() {
        MonitoredItem item = SelectionUtils.singleSelection(MonitoredItem.class,
                getMonitorTableViewer().getSelection());
        item.getMonitorModel().getItems().remove(item);

    }

}