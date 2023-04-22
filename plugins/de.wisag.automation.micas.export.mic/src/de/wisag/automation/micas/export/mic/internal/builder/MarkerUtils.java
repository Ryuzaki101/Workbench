package de.wisag.automation.micas.export.mic.internal.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import de.wisag.automation.micas.export.mic.internal.Policy;

public class MarkerUtils {

    static void addMarker(IFile file, String message, int lineNumber, int severity) {
        try {
            IMarker marker = file.createMarker(MicasProjectBuilder.MARKER_TYPE);
            marker.setAttribute(IMarker.MESSAGE, message);
            marker.setAttribute(IMarker.SEVERITY, severity);
            if (lineNumber == -1) {
                lineNumber = 1;
            }
            marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
        } catch (CoreException e) {
            Policy.logError(e);
        }
    }

    static void deleteMarkers(IFile file) {
        try {
            file.deleteMarkers(MicasProjectBuilder.MARKER_TYPE, false, IResource.DEPTH_ZERO);
        } catch (CoreException ce) {
            Policy.logError(ce);
        }
    }

}
