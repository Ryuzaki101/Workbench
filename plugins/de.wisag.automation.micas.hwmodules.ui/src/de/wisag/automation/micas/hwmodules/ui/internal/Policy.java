package de.wisag.automation.micas.hwmodules.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Policy {

    public static IStatus errorStatus(Throwable e) {
        return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
    }

    public static IStatus genericError(String message) {
        return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, null);
    }

    public static void logError(Throwable e) {
        getLog().log(errorStatus(e));
    }

    public static void log(IStatus status) {
        getLog().log(status);
    }

    private static ILog getLog() {
        return Activator.getDefault().getLog();
    }

    public static void logError(CoreException e) {
        getLog().log(e.getStatus());
    }

    public static void logWarning(String message) {
        Status status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, message);
        getLog().log(status);
    }

}