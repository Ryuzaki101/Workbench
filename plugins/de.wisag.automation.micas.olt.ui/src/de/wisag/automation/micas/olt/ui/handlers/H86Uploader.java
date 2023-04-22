package de.wisag.automation.micas.olt.ui.handlers;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.ui.internal.Activator;

public class H86Uploader {

    public static IStatus h86Upload(IProgressMonitor monitor, IFile file, IMicasDeviceManager mgr, int deviceNumber) {
        String h86Data = null;
        try (InputStream is = file.getContents()) {
            h86Data = IOUtils.toString(is, file.getCharset());
        } catch (IOException e) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("read of h86 file '%s' failed", file.getProjectRelativePath()), e);
        } catch (CoreException e) {
            return e.getStatus();
        }
        if (StringUtils.isEmpty(h86Data)) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("h86 file '%s' contains no data", file.getProjectRelativePath()));
        }
        return mgr.sendMicasProgram(monitor, h86Data, deviceNumber, true);
    }

}
