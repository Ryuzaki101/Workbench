package de.wisag.automation.micas.export.mic.internal.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;

class MicasProjectVisitor implements IResourceVisitor {
    private final int kind;

    public MicasProjectVisitor(int kind) {
        super();
        this.kind = kind;
    }

    @Override
    public boolean visit(IResource resource) {
        if (resource.getName().startsWith(".")) {
            return false;
        }
        if (resource.getType() == IResource.FILE) {
            work(kind, (IFile) resource);
        }
        return true;
    }

    private void work(int kind, IFile file) {
        // String extension = file.getFileExtension();
        switch (kind) {
        case IncrementalProjectBuilder.CLEAN_BUILD:
            break;
        case IncrementalProjectBuilder.FULL_BUILD:
            break;
        case IncrementalProjectBuilder.AUTO_BUILD:
            break;

        }
    }
}