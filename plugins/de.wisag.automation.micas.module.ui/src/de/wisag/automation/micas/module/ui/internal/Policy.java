package de.wisag.automation.micas.module.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

public class Policy {

    public static IStatus errorStatus(Throwable e) {
        String message = e.getMessage();
        return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message != null ? message : "unknown error", e);
    }

    public static IStatus errorStatus(String message, Throwable e) {
        return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, e);
    }

    public static IStatus logError(Throwable e) {
        IStatus errorStatus = errorStatus(e);
        getLog().log(errorStatus);
        return errorStatus;
    }

    public static IStatus logError(String message, Throwable e) {
        IStatus errorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                message != null ? message : "unknown error", e);
        getLog().log(errorStatus);
        return errorStatus;
    }

    public static void logError(CoreException e) {
        getLog().log(e.getStatus());
    }

    public static void log(IStatus status) {
        getLog().log(status);
    }

    public static void logWarning(String message) {
        IStatus errorStatus = new Status(IStatus.WARNING, Activator.PLUGIN_ID,
                message != null ? message : "unknown error");
        getLog().log(errorStatus);
    }

    private static ILog getLog() {
        Activator activator = Activator.getDefault();
        if (activator != null) {
            return activator.getLog();
        }
        return new ILog() {

            @Override
            public void removeLogListener(ILogListener listener) {
            }

            @Override
            public void log(IStatus status) {
                System.out.println(status);

            }

            @Override
            public Bundle getBundle() {
                return null;
            }

            @Override
            public void addLogListener(ILogListener listener) {
            }
        };
    }

    public static void newLoggedCoreException(String message, Throwable e) throws CoreException {
        throw new CoreException(Policy.logError(message, e));
    }

    public static void newLoggedCoreException(Throwable e) throws CoreException {
        throw new CoreException(Policy.logError(e.getMessage(), e));
    }

}