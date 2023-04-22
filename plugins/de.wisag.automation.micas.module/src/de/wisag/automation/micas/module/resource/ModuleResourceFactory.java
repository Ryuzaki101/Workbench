package de.wisag.automation.micas.module.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModuleResourceFactory extends XMIResourceFactoryImpl {

    @Override
    public Resource createResource(URI uri) {
        return new ModuleResource(uri);
    }

}
