package de.wisag.automation.micas.module.ui.internal;

import java.util.Hashtable;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.wisag.automation.micas.common.ui.dialogs.ISymbolFilterDialogProvider;
import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ui.dialogs.FindSymbolDialog;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements ISymbolFilterDialogProvider {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.wisag.automation.micas.module.ui";

    // The shared instance
    private static Activator plugin;

    private ServiceRegistration<ISymbolFilterDialogProvider> providerReg;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
     * BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        providerReg = context.registerService(ISymbolFilterDialogProvider.class, this, new Hashtable<String, Object>());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
     * BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        if (providerReg != null) {
            providerReg.unregister();
        }
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    @Override
    public SelectionStatusDialog createDialog(Shell activeShell, Object... args) {
        return new FindSymbolDialog(activeShell, (Module) args[0], (SymbolFilter) args[1]);
    }

}
