package de.wisag.automation.micas.common.ui;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IDocumentSaveOperation {
    void saveDocument(IProgressMonitor monitor);
}
