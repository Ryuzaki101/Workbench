package de.wisag.automation.micas.importer.mic.ui.internal.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.importer.mic.MicImporter;

public class MicImportHandler extends ModuleImportImportHandler {

    @Override
    IStatus runImport(IProgressMonitor monitor, IFile sourceFile, IFile targetFile) {

        return new MicImporter().run(monitor, sourceFile, targetFile);
    }

}
