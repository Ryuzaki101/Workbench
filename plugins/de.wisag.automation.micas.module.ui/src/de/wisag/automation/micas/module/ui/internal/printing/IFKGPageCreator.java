package de.wisag.automation.micas.module.ui.internal.printing;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

public interface IFKGPageCreator {

    PageData createFkgListing(Collection<FKGDescription> pages, TemplateDrawingArea drawingArea)
            throws IOException, CoreException;

}
