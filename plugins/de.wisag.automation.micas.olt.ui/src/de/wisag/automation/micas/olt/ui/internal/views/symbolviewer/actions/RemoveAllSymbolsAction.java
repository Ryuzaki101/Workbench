package de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;
import de.wisag.automation.micas.olt.ui.internal.Activator;
import de.wisag.automation.micas.olt.ui.internal.views.ISymbolMonitorManagerProvider;

public class RemoveAllSymbolsAction extends AbstractSymbolViewerAction {
    public RemoveAllSymbolsAction(ISymbolMonitorManagerProvider symbolMonitorManager,
            ISymbolMonitorStatusControl statusControl, TableViewer monitorTableViewer) {
        super("Alle entfernen",
                AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/delete_element.gif"),
                symbolMonitorManager, statusControl, monitorTableViewer);
    }

    @Override
    public boolean isEnabled() {
        if (!getStatusControl().isRunning() && !getStatusControl().isPaused()) {
            return false;
        }
        if (!getSymbolMonitorManager().isPresent()) {
            return false;
        }
        return getSymbolMonitorManager().get().getMonitorModel().getItems().size() > 0;
    }

    @Override
    public void run() {
        getSymbolMonitorManager().ifPresent(m -> {
            m.unmonitorAllSymbols();
        });
    }

}