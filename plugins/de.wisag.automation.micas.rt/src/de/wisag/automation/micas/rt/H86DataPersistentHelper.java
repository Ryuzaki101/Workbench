package de.wisag.automation.micas.rt;

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

import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.hwmodules.MicasModules;

public class H86DataPersistentHelper {

    private static final String BIN_EXT = "bin";
    private static final String DUMMY_FILENAME = "data." + BIN_EXT;

    public static void saveModules(H86Content data, OutputStream os) {
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put(BIN_EXT, new XMIResourceFactoryImpl());
        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // Create a resource
        Resource resource = resSet.createResource(URI.createURI(DUMMY_FILENAME));
        resource.getContents().add(data);

        // Now save the content.
        try {
            resource.save(os, Collections.EMPTY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static H86Content load(InputStream is) throws IOException {

        // Initialize the model
        H86Package.eINSTANCE.eClass();

        // Register the XMI resource factory for the .website extension

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put(BIN_EXT, new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // Get the resource
        Resource resource = resSet.createResource(URI.createURI(DUMMY_FILENAME));
        resource.load(is, Collections.emptyMap());
        // Get the first model element and cast it to the right type, in my
        // example everything is hierarchical included in this first node
        MicasModules micasModules = (MicasModules) resource.getContents().get(0);

        return (H86Content) EcoreUtil.resolve(micasModules, resource);

    }

}
