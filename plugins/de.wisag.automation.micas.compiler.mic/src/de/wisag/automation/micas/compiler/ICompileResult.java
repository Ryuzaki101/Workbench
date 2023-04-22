package de.wisag.automation.micas.compiler;

import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.rt.RtModule;

public interface ICompileResult {

    public IStatus getStatus();

    public IParseResult getParseResult();

    public String getH86Data();

    public RtModule getRtModule();

    public String getReport();

    public boolean isOk();

}