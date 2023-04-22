package de.wisag.automation.micas.compiler.mic.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.IParseResult;
import de.wisag.automation.micas.rt.RtModule;

public class CompileResult implements ICompileResult {
    private final IStatus status;
    private final String h86Data;
    private final IParseResult parseResult;
    private final RtModule rtModule;
    private final String report;

    public CompileResult(IStatus status, IParseResult parseResult, String h86Data, RtModule rtModule, String report) {
        super();
        this.status = status;
        this.parseResult = parseResult;
        this.h86Data = h86Data;
        this.rtModule = rtModule;
        this.report = report;
    }

    @Override
    public IStatus getStatus() {
        return status;
    }

    @Override
    public String getH86Data() {
        return h86Data;
    }

    @Override
    public IParseResult getParseResult() {
        return parseResult;
    }

    @Override
    public RtModule getRtModule() {
        return rtModule;
    }

    @Override
    public String getReport() {
        return this.report;
    }

    @Override
    public boolean isOk() {
        if (status instanceof MultiStatus) {
            // MultiStatus multiStatus = (MultiStatus) status;
        }
        return status.isOK();
    }

}
