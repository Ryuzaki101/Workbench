package de.wisag.automation.micas.olt.ui.internal.views.actions;

import static de.wisag.automation.micas.olt.ui.internal.Activator.PLUGIN_ID;
import static java.util.Objects.requireNonNull;
import static org.eclipse.ui.plugin.AbstractUIPlugin.imageDescriptorFromPlugin;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.texteditor.IUpdate;

import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;

public class PauseSymbolmonitorAction extends Action implements IUpdate {
    private final ISymbolMonitorStatusControl statusControl;

    public PauseSymbolmonitorAction(ISymbolMonitorStatusControl statusControl) {
        super("Pause Symbolmonitor");
        this.statusControl = requireNonNull(statusControl, "'statusControl'");
        setImageDescriptor(imageDescriptorFromPlugin(PLUGIN_ID, "icons/elcl16/suspend_co.gif"));
        setDisabledImageDescriptor(imageDescriptorFromPlugin(PLUGIN_ID, "icons/dlcl16/suspend_co.gif"));
    }

    @Override
    public void run() {
        statusControl.pause(new NullProgressMonitor());
    }

    @Override
    public void update() {
        setEnabled(statusControl.canPause());
    }
}
