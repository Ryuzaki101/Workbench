package de.wisag.automation.micas.olt.ui.internal.views.actions;

import static de.wisag.automation.micas.olt.ui.internal.Activator.PLUGIN_ID;
import static java.util.Objects.requireNonNull;
import static org.eclipse.ui.plugin.AbstractUIPlugin.imageDescriptorFromPlugin;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.texteditor.IUpdate;

import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;

public class StopSymbolmonitorAction extends Action implements IUpdate {
    private final ISymbolMonitorStatusControl statusControl;

    public StopSymbolmonitorAction(ISymbolMonitorStatusControl statusControl) {
        super("Stop Symbolmonitor for Module");
        this.statusControl = requireNonNull(statusControl, "'statusControl'");
        setImageDescriptor(imageDescriptorFromPlugin(PLUGIN_ID, "icons/elcl16/terminate_co.gif"));
        setDisabledImageDescriptor(imageDescriptorFromPlugin(PLUGIN_ID, "icons/dlcl16/terminate_co.gif"));
    }

    @Override
    public void run() {
        statusControl.stop(new NullProgressMonitor());
    }

    @Override
    public void update() {
        setEnabled(statusControl.canStop());
    }

}
