package de.wisag.automation.micas.hwmodules;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ModulesPersistentHelper {

    // #define BanzMax (sizeof(BS)/sizeof(BstDef))
    public static void saveModules(MicasModules modules, OutputStream os) {
        // Register the XMI resource factory for the .website extension
        // Resource.Factory.Registry reg =
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        // Map<String, Object> m = reg.getExtensionToFactoryMap();
        // m.put("person", new MyXMIFactoryImpl())
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("mods", new XMIResourceFactoryImpl());
        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // Create a resource
        Resource resource = resSet.createResource(URI.createURI("micasmodules.mods"));
        resource.getContents().add(modules);

        // Now save the content.
        try {
            resource.save(os, Collections.EMPTY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MicasModules load(InputStream is) throws IOException {

        // Initialize the model
        HwmodulesPackage.eINSTANCE.eClass();

        // Register the XMI resource factory for the .website extension

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("mods", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // Get the resource
        Resource resource = resSet.createResource(URI.createURI("micasmodules.mods"));
        resource.load(is, Collections.emptyMap());
        // Get the first model element and cast it to the right type, in my
        // example everything is hierarchical included in this first node
        MicasModules micasModules = (MicasModules) resource.getContents().get(0);

        return (MicasModules) EcoreUtil.resolve(micasModules, resource);

    }

}
