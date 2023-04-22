package de.wisag.automation.micas.common.osgi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import de.wisag.automation.micas.common.internal.Policy;

public class BundleUtils {

    public static void copyFromBundle(Bundle bundle, String srcPath, File targetFile) {
        URL micasUrl = bundle.getEntry(srcPath);
        if (micasUrl == null) {
            Policy.logError(String.format("Bundel entry '%s' not found", srcPath));
            return;
        }
        try (InputStream in = micasUrl.openStream()) {
            Files.copy(in, targetFile.toPath());
        } catch (IOException e) {
            Policy.logError(e);
        }

    }

    public static boolean isActive(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getState() == Bundle.ACTIVE;
    }

    public static boolean isActivated(Bundle bundle) {
        return bundle != null && (bundle.getState() & (Bundle.ACTIVE | Bundle.STOPPING)) != 0;
    }

    // TODO: needs a better name
    public static boolean isReady(Bundle bundle) {
        return bundle != null && isReady(bundle.getState());
    }

    public static boolean isReady(int bundleState) {
        return (bundleState & (Bundle.RESOLVED | Bundle.STARTING | Bundle.ACTIVE | Bundle.STOPPING)) != 0;
    }

    public static boolean isActive(String bundleId) {
        return isActive(Platform.getBundle(bundleId));
    }

    public static boolean isActivated(String bundleId) {
        return isActivated(Platform.getBundle(bundleId));
    }

    public static boolean isReady(String bundleId) {
        return isReady(Platform.getBundle(bundleId));
    }

    @SuppressWarnings("deprecation")
    public static URL find(Bundle bundle, String path) {
        if (bundle == null) {
            return null;
        }
        return Platform.find(bundle, new Path(path));
    }

    public static URL find(String bundleId, String path) {
        return find(Platform.getBundle(bundleId), path);
    }

    public static void log(String bundleId, Throwable exception) {
        Bundle bundle = Platform.getBundle(bundleId);
        if (bundle == null) {
            return;
        }
        IStatus status = new Status(IStatus.ERROR, bundleId, IStatus.ERROR,
                exception.getMessage() == null ? "" : exception.getMessage(), //$NON-NLS-1$
                exception);
        Platform.getLog(bundle).log(status);
    }
}
