package de.wisag.automation.micas.compiler.mic.internal;

import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.compiler.IParseResult;
import de.wisag.automation.micas.mIC.Module;

public class ParseResult implements IParseResult {

    private IStatus status;
    private Module module;

    public ParseResult(IStatus status, Module module) {
        this.status = status;
        this.module = module;
    }

    @Override
    public IStatus getStatus() {
        return status;
    }

    @Override
    public Module getModule() {
        return module;
    }

}
