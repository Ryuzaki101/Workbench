package de.wisag.automation.micas.module.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class ModuleResource extends XMIResourceImpl {

    /**
     *
     */
    public ModuleResource() {
        super();
    }

    public ModuleResource(URI uri) {
        super(uri);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
     */
    @Override
    protected boolean useUUIDs() {
        return true;
    }

}