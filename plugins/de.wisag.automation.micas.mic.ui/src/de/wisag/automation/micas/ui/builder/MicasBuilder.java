package de.wisag.automation.micas.ui.builder;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import de.wisag.automation.micas.common.licensing.Feature;
import de.wisag.automation.micas.common.licensing.LicenseManagerAccess;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.compiler.CompilerFlavour;
import de.wisag.automation.micas.compiler.MicasCompilerJob;
import de.wisag.automation.micas.mIC.Module;
import de.wisag.automation.micas.ui.internal.Policy;

public class MicasBuilder implements IXtextBuilderParticipant {

    @Override
    public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
        for (Delta delta : context.getDeltas()) {
            if (delta.getNew() == null && delta.getOld() != null) {
                // deleted
                final IFile file = ResourceUtils.toIFile(delta.getOld().getURI());
                WorkspaceJob job = new WorkspaceJob(
                        "Delete derived files for " + file.getProjectRelativePath().toPortableString()) {
                    @Override
                    public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                        List<IFile> toDelete = ResourceUtils.getGeneratedFilesFor(file);
                        for (IFile iFile : toDelete) {
                            iFile.delete(true, monitor);
                        }
                        return Status.OK_STATUS;
                    }
                };
                IWorkspace workspace = file.getWorkspace();
                IResourceRuleFactory ruleFactory = workspace.getRuleFactory();
                job.setRule(ruleFactory.buildRule());
                job.schedule();
            } else if (delta.getNew() != null && delta.getOld() != null) {
                // changed
            } else if (delta.getNew() != null && delta.getOld() == null) {
                // new
            }
        }
        if (context.getBuildType() == BuildType.CLEAN) {
            // simple delete all generated filed
            List<IFile> generatedFile = ResourceUtils.getFilesToClean(context.getBuiltProject());
            for (IFile file : generatedFile) {
                file.delete(true, monitor);
            }
            return;
        }
        ResourceSet rs = context.getResourceSet();
        Resource res = rs.getResources().size() > 0 ? rs.getResources().get(0) : null;
        Module rootObject = (Module) (res != null && res.getContents() != null && res.getContents().size() > 0
                ? res.getContents().get(0)
                : null);

        if (rootObject == null) {
            return;
        }
        IWorkspace workspace = context.getBuiltProject().getWorkspace();
        IResourceRuleFactory ruleFactory = workspace.getRuleFactory();
        Module wc = EcoreUtil.copy(rootObject);
        IFile micFile = ResourceUtils.toIFile(res);
        switch (context.getBuildType()) {
        case FULL:
        case INCREMENTAL:
            invokeCompiler(ruleFactory, wc, micFile);
            break;
        case RECOVERY:

            break;
        case CLEAN:
            // TODO: what sould we do here
            break;
        default:
            break;
        }

    }

    private void invokeCompiler(IResourceRuleFactory ruleFactory, Module wc, IFile micFile) {
        // do not generate h86 from rtmodel twice!
        if (ResourceUtils.getGeneratedFrom(micFile) == null) {
            if (LicenseManagerAccess.getLicenseManager().isLicensed(Feature.H86_GENERATION)) {
                MicasCompilerJob job = new MicasCompilerJob(micFile, wc, CompilerFlavour.WISAG);
                job.setRule(ruleFactory.buildRule());
                job.schedule();
            } else {
                Policy.logWarning("Demo Mode: Feature Compiler not available!");
            }
        }

        if (LicenseManagerAccess.getLicenseManager().isLicensed(Feature.OLD_MIC)) {
            MicasCompilerJob job2 = new MicasCompilerJob(micFile, wc, CompilerFlavour.BBC);
            job2.setRule(ruleFactory.buildRule());
            job2.schedule();
        } else {
            Policy.logWarning("Demo Mode: Feature mic.exe not available!");
        }
    }

}
