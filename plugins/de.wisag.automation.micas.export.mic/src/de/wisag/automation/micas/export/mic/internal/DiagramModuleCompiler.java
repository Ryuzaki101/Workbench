package de.wisag.automation.micas.export.mic.internal;

import java.io.IOException;
import java.util.Collections;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.hashing.DigestUtils;
import de.wisag.automation.micas.common.licensing.Feature;
import de.wisag.automation.micas.common.licensing.LicenseManagerAccess;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.h86.MicasH86Marshaller;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.rt.MicReporter;
import de.wisag.automation.micas.rt.MicSourceGenerator;
import de.wisag.automation.micas.rt.MicasH86ContentCreator;
import de.wisag.automation.micas.rt.MicasModuleConfigurator;
import de.wisag.automation.micas.rt.RtManifestGenerator;
import de.wisag.automation.micas.rt.RtModule;

/**
 * Compiler for ModuleDiagrams Generates the corresponding mic and h86 file
 */
public class DiagramModuleCompiler {
    private final IFile diagramFile;
    private boolean saveRtModule = true;
    private boolean generateH86 = true;
    private boolean saveMic = true;
    private boolean saveRepFile = true;
    private boolean saveManifestFile = true;

    /**
     * @param diagramFile
     *            diagram file
     */
    public DiagramModuleCompiler(IFile diagramFile) {
        super();
        this.diagramFile = diagramFile;
    }

    public void compile() throws CoreException {
        clean();
        if (!LicenseManagerAccess.getLicenseManager().isLicensed(Feature.H86_GENERATION)) {
            Policy.logWarning("Demo mode: Feature Compilation not available!");
            return;
        }
        new WorkspaceJob("Compiling diagram : " + diagramFile.getFullPath().toOSString()) {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                try {
                    compileModule(monitor, diagramFile);
                } catch (Exception ex) {
                    return Policy.errorStatus(ex);
                }
                return Status.OK_STATUS;
            }

        }.schedule();
    }

    public IStatus compileAndWait(IProgressMonitor monitor) {
        IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
            @Override
            public void run(IProgressMonitor monitor) throws CoreException {
                cleanModule(monitor, diagramFile);
                compileModule(monitor, diagramFile);

            }
        };
        IStatus status = Status.OK_STATUS;
        try {
            ResourcesPlugin.getWorkspace().run(runnable, monitor);
        } catch (CoreException e) {
            status = e.getStatus();
        }
        return status;
    }

    /**
     * Delete all artifacts, which are generated from diagramile
     *
     * @throws CoreException
     */
    public void clean() throws CoreException {
        new WorkspaceJob("Cleaning generated artefacts of : " + diagramFile.getFullPath().toOSString()) {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                cleanModule(monitor, diagramFile);
                return Status.OK_STATUS;
            }

        }.schedule();
    }

    void cleanModule(IProgressMonitor monitor, IFile file) throws CoreException {
        ResourceUtils.deleteDerivedFiles(monitor, file);
    }

    void compileModule(IProgressMonitor monitor, IFile modulesDiagramFile) throws CoreException {
        // take diagram
        URI modelUri = ResourceUtils.toEmfURI(modulesDiagramFile);
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource modelRes = resourceSet.getResource(modelUri, true);
        if (modelRes == null || modelRes.getContents().size() == 0) {
            throw new CoreException(
                    new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Das Modell konnte nicht geladen werden"));
        }
        EList<EObject> contents = modelRes.getContents();
        Module module = (Module) contents.iterator().next();
        // first, transform diagram
        RtModule rtModule = new DiagramModuleToRtModuleTransformer().transform(module);
        rtModule.setSourceModificationStamp(modulesDiagramFile.getModificationStamp());
        rtModule.setSourceName(modulesDiagramFile.getName());
        rtModule.setSourceChecksum(DigestUtils.computeMd5AndCloseStream(modulesDiagramFile.getContents()));
        // run the module cleaner
        if (HardcodedValues.ENABLE_RT_MODEL_CLEANER) {
            RtModuleCleaner.clean(rtModule);
        }
        // configure the rt model
        MicasModuleConfigurator configurator = new MicasModuleConfigurator();
        configurator.configure(monitor, rtModule);
        // System.out.println("pgmSize:" + rtModule.calculateProgramSize());
        // set the rtModule as sessionObject to the diagram file, its needed by
        // onlinetests

        ResourceUtils.setSessionObject(ResourceUtils.CURRENT_RT_MODEL, modulesDiagramFile, rtModule);
        if (this.saveRtModule) {
            saveRtModule(monitor, modulesDiagramFile, modulesDiagramFile.getParent(), rtModule,
                    HardcodedValues.RT_SUFFIX);
        }
        if (this.saveRepFile) {
            generateRepFile(monitor, modulesDiagramFile, modulesDiagramFile.getParent(), rtModule,
                    HardcodedValues.REP_SUFFIX);
        }
        if (this.generateH86) {
            generateH86File(monitor, modulesDiagramFile, rtModule, HardcodedValues.H86_SUFFIX);
        }
        if (this.saveMic) {
            generateMic(monitor, modulesDiagramFile, rtModule, HardcodedValues.MIC_SUFFIX);
        }
        if (this.saveManifestFile) {
            RtManifestGenerator.generateManifest(monitor, modulesDiagramFile, rtModule,
                    HardcodedValues.MANIFEST_SUFFIX);
        }
        modelRes.unload();
    }

    private IStatus generateRepFile(IProgressMonitor monitor, IFile file, IContainer parent, RtModule rtModule,
            String suffix) {
        return ResourceUtils.updateAndTagGeneratedFile(monitor, file, new MicReporter().generateReport(rtModule),
                suffix, true);

    }

    static IStatus saveRtModule(IProgressMonitor monitor, IFile diagFile, IContainer parentResource, RtModule rtModule,
            String suffix) {
        XMLResource resource = new XMIResourceImpl(URI.createFileURI(
                diagFile.getProjectRelativePath().removeFileExtension().addFileExtension("rt").lastSegment()));
        resource.getContents().add(rtModule);
        StringBuilder sb = new StringBuilder();
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            resource.save(output, Collections.EMPTY_MAP);
            sb.append(new String(output.toByteArray()));
        } catch (IOException e) {
            new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
        }
        return ResourceUtils.updateAndTagGeneratedFile(monitor, diagFile, sb.toString(), suffix, false);
    }

    static IStatus generateH86File(IProgressMonitor monitor, IFile file, RtModule rtModule, String suffix) {
        String content = new MicasH86Marshaller().marshall(new MicasH86ContentCreator().createH86Content(rtModule));
        return ResourceUtils.updateAndTagGeneratedFile(monitor, file, content, suffix, false);
    }

    static IStatus generateMic(IProgressMonitor monitor, IFile file, RtModule rtModule, String suffix) {
        MicSourceGenerator generator = new MicSourceGenerator(rtModule);
        return ResourceUtils.updateAndTagGeneratedFile(monitor, file, generator.generate(), suffix, true);
    }
}
