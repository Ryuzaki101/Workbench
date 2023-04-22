package de.wisag.automation.micas.olt.ui.internal.views.actions;

import static de.wisag.automation.micas.olt.ui.internal.Activator.PLUGIN_ID;
import static java.util.Objects.requireNonNull;
import static org.eclipse.ui.plugin.AbstractUIPlugin.imageDescriptorFromPlugin;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.texteditor.IUpdate;

import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;

public class StartSymbolmonitorAction extends Action implements IUpdate {
    private final ISymbolMonitorStatusControl statusControl;

    public StartSymbolmonitorAction(ISymbolMonitorStatusControl statusControl) {
        super("Start Symbolmonitor for Module");
        this.statusControl = requireNonNull(statusControl, "'statusControl'");
        setImageDescriptor(imageDescriptorFromPlugin(PLUGIN_ID, "icons/elcl16/resume_co.gif"));
        setDisabledImageDescriptor(imageDescriptorFromPlugin(PLUGIN_ID, "icons/dlcl16/resume_co.gif"));
    }

    @Override
    public void run() {
        statusControl.start(new NullProgressMonitor());
    }

    @Override
    public void update() {
        setEnabled(statusControl.canStart());
    }
}
