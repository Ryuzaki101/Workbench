package de.wisag.automation.micas.module.ui.internal.printing.pdfbox;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage;
import org.eclipselabs.damos.dml.DMLPackage;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModulePackage;

public class ModuleHelper {

	public static Module loadModule(InputStream is) throws IOException {
		// Initialize the model
		ModulePackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();
		DMLPackage.eINSTANCE.eClass();
		DMLNotationPackage.eINSTANCE.eClass();
		// Register the XMI resource factory for the .website extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("module", new XMIResourceFactoryImpl());
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		// Get the resource
		Resource resource = resSet.createResource(URI.createURI("data.module"));
		resource.load(is, Collections.emptyMap());
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		return (Module) resource.getContents().get(0);
	}

}
