package de.wisag.automation.micas.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import de.wisag.automation.micas.compiler.mic.internal.bbc1988.BBCMicasCompiler;
import de.wisag.automation.micas.compiler.mic.internal.modern.MicasCompiler;
import de.wisag.automation.micas.mIC.Module;

public class MicasCompilerJob extends Job {
    private final IFile micFile;
    private final Module module;
    CompilerFlavour flavour;

    public MicasCompilerJob(IFile micFile, Module module, CompilerFlavour flavour) {
        super("Micas Compiler : " + micFile.getName());
        this.micFile = micFile;
        this.module = module;
        this.flavour = flavour;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {
        if (flavour == CompilerFlavour.WISAG) {
            return new MicasCompiler().compile(monitor, this.module, this.micFile).getStatus();
        } else {
            return new BBCMicasCompiler().compile(monitor, module, micFile).getStatus();
        }
    }

    public IFile getMicFile() {
        return micFile;
    }

}
