package de.wisag.automation.micas.importer.mic.ui.internal.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.FrameworkUtil;

public class H86ImportHandler extends ModuleImportImportHandler {

    @Override
    IStatus runImport(IProgressMonitor monitor, IFile sourceFile, IFile targetFile) {
        return new Status(IStatus.ERROR, FrameworkUtil.getBundle(getClass()).getSymbolicName(),
                String.format("Operation not supported in %s", getClass().getName()));
    }

}
