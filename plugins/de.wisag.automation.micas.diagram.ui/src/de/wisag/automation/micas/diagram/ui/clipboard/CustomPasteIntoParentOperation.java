package de.wisag.automation.micas.diagram.ui.clipboard;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.eclipse.gmf.runtime.emf.clipboard.core.PasteTarget;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.LoadingEMFResource;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.PasteIntoParentOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.PasteOperation;

@SuppressWarnings("restriction")
public class CustomPasteIntoParentOperation extends PasteIntoParentOperation {

    public CustomPasteIntoParentOperation(PasteOperation pasteProcess, PasteTarget element,
            @SuppressWarnings("rawtypes") Map hintsMap) throws Exception {
        super(pasteProcess, element, hintsMap);
    }

    @Override
    protected LoadingEMFResource loadEObjects() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                getResourceInfo().data.getBytes(getResourceInfo().encoding));
        LoadingEMFResource resource = new CustomLoadingEMFResource(getParentResource().getResourceSet(),
                getResourceInfo().encoding, getLoadOptionsMap(), getClipboardOperationHelper());
        resource.load(inputStream, null);
        return resource;
    }

}
