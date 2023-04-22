package de.wisag.automation.micas.common.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class Policy {

    public static IStatus errorStatus(Throwable e) {
        Bundle bundle = FrameworkUtil.getBundle(Policy.class);
        return new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage(), e);
    }

    public static void logError(Throwable e) {
        getLog().log(errorStatus(e));
    }

    public static void log(IStatus error) {
        getLog().log(error);
    }

    private static ILog getLog() {
        return Activator.getILog();
    }

    public static void logError(CoreException e) {
        getLog().log(e.getStatus());
    }

    public static void logError(String message) {
        getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
    }

}
