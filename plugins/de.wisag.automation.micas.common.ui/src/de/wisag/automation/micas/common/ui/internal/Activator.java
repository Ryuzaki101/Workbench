package de.wisag.automation.micas.common.ui.internal;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
    public static final String PLUGIN_ID = "de.wisag.automation.micas.common.ui";
    private static Activator _instance = null;

    @Override
    public void start(BundleContext bc) throws Exception {
        _instance = this;

    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        _instance = null;
    }

    public static ILog getILog() {
        return _instance.getLog();
    }

    public static Activator getDefault() {
        return _instance;
    }
}
