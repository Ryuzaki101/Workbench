package de.wisag.automation.micas.diagram.ui.clipboard;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;

public class CustomClipboardSupportFactory implements IClipboardSupportFactory {

    private final IClipboardSupport clipHelper = new CustomNotationClipboardOperationHelper();

    public CustomClipboardSupportFactory() {
        super();
    }

    /*
     * (non-Javadoc) Implements the interface method.
     */
    @Override
    public IClipboardSupport newClipboardSupport(EPackage ePackage) {
        return clipHelper;
    }

}
