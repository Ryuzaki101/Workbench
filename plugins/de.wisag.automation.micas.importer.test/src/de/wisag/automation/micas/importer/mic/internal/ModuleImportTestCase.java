package de.wisag.automation.micas.importer.mic.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;

import de.wisag.automation.micas.MICStandaloneSetup;
import de.wisag.automation.micas.compiler.MicasModuleToRtModelTransformer;
import de.wisag.automation.micas.mIC.Module;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.rt.RtModule;

public class ModuleImportTestCase {
    static IProject testProject;
    public static final String TEST_BUNDLE = "de.wisag.automation.micas.importer.test";

    @BeforeClass
    public static void beforeClass() throws Exception {
        testProject = createMicasProject(null, ModuleImportTestCase.class.getSimpleName());
    }

    @Test
    public void testBasicTransform() throws Exception {
        String testPath = "/testdata/simple/29AC4005.mic";
        IFile file = copyResourceToProject(testPath);
        RtModule rtModule = getRtModule(file);
        RtModuleToDiagramModuleTransformer tr = new RtModuleToDiagramModuleTransformer(URI.createURI("bla.module"));
        de.wisag.automation.micas.module.Module module = tr.transform(rtModule);

        // test tasks
        assertEquals(rtModule.getTasks().size(), module.getTasks().size());

        // test variables
        Collection<VariableAttribute> vars = EcoreUtil.getObjectsByType(module.getAttributes(),
                ModulePackage.eINSTANCE.getVariableAttribute());

        assertEquals(rtModule.getWordVariables().size() + rtModule.getFloatVariables().size(), vars.size());
        // test references
        Collection<ReferenceAttribute> refs = EcoreUtil.getObjectsByType(module.getAttributes(),
                ModulePackage.eINSTANCE.getReferenceAttribute());
        assertEquals(rtModule.getReferences().size(), refs.size());
        // test constants
        Collection<ConstantAttribute> consts = EcoreUtil.getObjectsByType(module.getAttributes(),
                ModulePackage.eINSTANCE.getConstantAttribute());
        assertEquals(rtModule.getWordConstants().size() + rtModule.getFloatConstants().size(), consts.size());

    }

    private RtModule getRtModule(IFile file) throws CoreException {
        new MICStandaloneSetup().createInjectorAndDoEMFRegistration();
        URI uri = URI.createFileURI("no.mic");// it can be nonexistent
        ResourceSet set = new ResourceSetImpl();
        Resource resource = set.createResource(uri);
        try {
            resource.load(file.getContents(), Collections.EMPTY_MAP);
        } catch (IOException e) {
            // return new ParseResult(new Status(IStatus.ERROR,
            // Activator.PLUGIN_ID, e.getMessage(), e), null, null);
        }
        EList<Diagnostic> errors = resource.getErrors();
        if (!errors.isEmpty()) {
            List<IStatus> stati = new ArrayList<>();
            for (Iterator<?> iterator = errors.iterator(); iterator.hasNext();) {
                Diagnostic diagnostic = (Diagnostic) iterator.next();
                IStatus status = new Status(IStatus.ERROR, "micas.compiler",
                        String.format("Syntax error line:%d : %s", diagnostic.getLine(), diagnostic.getMessage()));
                stati.add(status);
            }
        }

        Module module = (Module) resource.getContents().get(0);
        RtModule rtModule = new MicasModuleToRtModelTransformer().transform(module);
        return rtModule;
    }

    static IFile copyResourceToProject(String testPath) throws IOException, CoreException {
        Bundle bundle = Platform.getBundle(TEST_BUNDLE);
        URL url = bundle.getEntry(testPath);
        assertNotNull("Testcase not found " + testPath, url);
        InputStream is = url.openStream();
        assertNotNull(is);
        Path path = new Path(testPath);
        String name = path.lastSegment();
        IFile testFile = testProject.getFile(name);
        if (testFile.exists()) {
            testFile.setContents(is, IResource.FORCE, null);
            testFile.setCharset("UTF-8", null);
        } else {
            testFile.create(is, IResource.FORCE, null);
        }
        assertTrue("Testfile '" + testFile.getLocation().toPortableString() + "' not found", testFile.exists());
        return testFile;
    }

    static IProject createMicasProject(IProgressMonitor monitor, String name) throws CoreException {
        IProgressMonitor pm = monitor != null ? monitor : new NullProgressMonitor();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        if (project.exists()) {
            return project;
        }
        project.create(pm);
        project.open(pm);
        return project;
    }

    // @AfterClass
    // public static void afterClass() throws Exception {
    // testProject.delete(true, true, null);
    // }
}
