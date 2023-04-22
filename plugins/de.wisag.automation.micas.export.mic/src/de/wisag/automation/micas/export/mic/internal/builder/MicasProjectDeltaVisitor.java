package de.wisag.automation.micas.export.mic.internal.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.export.mic.internal.DiagramModuleCompiler;

/**
 * @author mkr
 */
class MicasProjectDeltaVisitor implements IResourceDeltaVisitor {

    /*
     * (non-Javadoc)
     *
     * @see
     * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.
     * resources.IResourceDelta)
     */
    @Override
    public boolean visit(IResourceDelta delta) throws CoreException {
        IResource resource = delta.getResource();
        if (resource.getType() == IResource.FILE) {
            switch (delta.getKind()) {
            case IResourceDelta.ADDED:
                if (HardcodedValues.DIAGRAM_MODULE_SUFFIX.equals(resource.getFileExtension())) {
                    DiagramModuleCompiler compile = new DiagramModuleCompiler((IFile) resource);
                    compile.compile();
                }
                break;
            case IResourceDelta.REMOVED:
                if (HardcodedValues.DIAGRAM_MODULE_SUFFIX.equals(resource.getFileExtension())) {
                    DiagramModuleCompiler compile = new DiagramModuleCompiler((IFile) resource);
                    compile.clean();
                }
                break;
            case IResourceDelta.CHANGED:
                if (HardcodedValues.DIAGRAM_MODULE_SUFFIX.equals(resource.getFileExtension())) {
                    DiagramModuleCompiler compile = new DiagramModuleCompiler((IFile) resource);
                    compile.compile();
                }
                break;
            }
            return false;
        }
        // return true to continue visiting children.
        return true;
    }
}