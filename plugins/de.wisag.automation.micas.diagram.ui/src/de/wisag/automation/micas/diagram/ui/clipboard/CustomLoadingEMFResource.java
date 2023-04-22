package de.wisag.automation.micas.diagram.ui.clipboard;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.LoadingEMFResource;

@SuppressWarnings("restriction")
public class CustomLoadingEMFResource extends LoadingEMFResource {

    @SuppressWarnings("rawtypes")
    public CustomLoadingEMFResource(ResourceSet rset, String encoding, Map defaultLoadOptions,
            IClipboardSupport clipboardOperationHelper) {
        super(rset, encoding, defaultLoadOptions, clipboardOperationHelper);
    }

    @Override
    protected void doUnload() {
        cleanResource();
        super.doUnload();
    }

    private void cleanResource() {
        for (EObject eObject : getContents().toArray(new EObject[getContents().size()])) {
            ((InternalEList<?>) getContents()).basicRemove(eObject, null);
        }
    }

}
