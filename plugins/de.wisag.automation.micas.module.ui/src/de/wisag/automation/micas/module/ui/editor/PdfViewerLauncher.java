package de.wisag.automation.micas.module.ui.editor;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IEditorLauncher;

import de.wisag.automation.micas.module.ui.internal.Policy;

public class PdfViewerLauncher implements IEditorLauncher {
    @Override
    public void open(IPath iFile) {
        File file = iFile.toFile();

        try {
            java.awt.Desktop.getDesktop().open(file);
        } catch (IOException e) {
            IStatus status = Policy.errorStatus("Start pdfviewer failed", e);
            Policy.log(status);
        }
    }
}
