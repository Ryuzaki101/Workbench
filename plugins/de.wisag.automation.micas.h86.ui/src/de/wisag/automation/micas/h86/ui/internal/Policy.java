package de.wisag.automation.micas.h86.ui.internal;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Policy {

    public static IStatus errorStatus(Throwable e) {
        return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
    }

    public static void handleException(CoreException e) throws ExecutionException {
        logError(e);
        throw new ExecutionException(e.getMessage(), e);
    }

    public static void logError(Throwable e) {
        Activator.getDefault().getLog().log(errorStatus(e));
    }

    public static void logError(CoreException e) {
        Activator.getDefault().getLog().log(e.getStatus());
    }

    public static void handleException(Exception e) throws ExecutionException {
        Activator.getDefault().getLog().log(Policy.errorStatus(e));
        throw new ExecutionException(e.getMessage(), e);
    }

}
