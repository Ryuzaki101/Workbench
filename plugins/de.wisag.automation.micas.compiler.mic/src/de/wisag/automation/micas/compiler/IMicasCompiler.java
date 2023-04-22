package de.wisag.automation.micas.compiler;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import de.wisag.automation.micas.mIC.Module;

public interface IMicasCompiler {
    void setCompilerMessageListener(ICompilerMessageListener messageListener);

    ICompileResult compile(IProgressMonitor monitor, Module module, IFile micFile);

    ICompileResult compile(IProgressMonitor monitor, InputStream micFile, String encoding);
}
