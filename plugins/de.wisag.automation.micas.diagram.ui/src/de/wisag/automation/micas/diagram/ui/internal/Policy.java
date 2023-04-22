package de.wisag.automation.micas.diagram.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.wisag.automation.micas.diagram.ui.Activator;

public class Policy {
    private static ILog getLog() {
        return Activator.getDefault().getLog();
    }

    public static void logError(CoreException e) {
        getLog().log(e.getStatus());
    }

    public static IStatus errorStatus(Throwable e) {
        Bundle bundle = FrameworkUtil.getBundle(Policy.class);
        return new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage(), e);
    }

    public static void logError(Throwable e) {
        getLog().log(errorStatus(e));
    }

    public static void logStatus(Status status) {
        getLog().log(status);

    }

}