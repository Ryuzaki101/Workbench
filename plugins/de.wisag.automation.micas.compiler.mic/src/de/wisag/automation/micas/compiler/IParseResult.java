package de.wisag.automation.micas.compiler;

import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.mIC.Module;

public interface IParseResult {
    public abstract IStatus getStatus();

    public abstract Module getModule();

}