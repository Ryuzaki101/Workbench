package de.wisag.automation.micas.importer.mic;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;

import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.compiler.CompilerFlavour;
import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.IMicasCompiler;
import de.wisag.automation.micas.compiler.MicasCompilerFactory;
import de.wisag.automation.micas.importer.mic.internal.Activator;
import de.wisag.automation.micas.importer.mic.internal.RtModuleToDiagramModuleTransformer;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.rt.RtModule;

public class MicImporter {

    public IStatus run(IProgressMonitor monitor, IFile sourceFile, IFile targetFile) {
        IMicasCompiler compiler = MicasCompilerFactory.create(CompilerFlavour.WISAG);
        ICompileResult result = compiler.compile(monitor, null, sourceFile);
        if (!result.getStatus().isOK()) {
            return result.getStatus();
        }
        RtModule rtModule = result.getRtModule();
        Module module = new RtModuleToDiagramModuleTransformer(ResourceUtils.toEmfURI(targetFile)).transform(rtModule);
        try {
            module.eResource().save(GMFResourceFactory.getDefaultSaveOptions());
        } catch (IOException e) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
        }
        return Status.OK_STATUS;
    }

}
