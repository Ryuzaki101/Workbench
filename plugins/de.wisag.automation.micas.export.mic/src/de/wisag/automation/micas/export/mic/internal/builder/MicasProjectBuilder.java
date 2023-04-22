package de.wisag.automation.micas.export.mic.internal.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.wisag.automation.micas.export.mic.internal.Policy;

public class MicasProjectBuilder extends IncrementalProjectBuilder {
    public static final String BUILDER_ID = "de.wisag.automation.micas.builder";
    static final String MARKER_TYPE = "de.wisag.automation.micas.export.mic.xmlProblem";

    @Override
    protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
            throws CoreException {
        if (kind == FULL_BUILD) {
            fullBuild(monitor, kind);
        } else {
            IResourceDelta delta = getDelta(getProject());
            if (delta == null) {
                fullBuild(monitor, kind);
            } else {
                incrementalBuild(delta, monitor);
            }
        }
        return null;
    }

    protected void fullBuild(final IProgressMonitor monitor, int kind) throws CoreException {
        try {
            getProject().accept(new MicasProjectVisitor(IncrementalProjectBuilder.FULL_BUILD));
        } catch (CoreException e) {
            Policy.logError(e);
            throw e;
        }
    }

    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
        getProject().accept(new MicasProjectVisitor(CLEAN_BUILD));
    }

    protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
        delta.accept(new MicasProjectDeltaVisitor());
    }

}
