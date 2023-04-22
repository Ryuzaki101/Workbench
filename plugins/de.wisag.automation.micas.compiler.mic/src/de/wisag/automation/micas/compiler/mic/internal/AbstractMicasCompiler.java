package de.wisag.automation.micas.compiler.mic.internal;

import de.wisag.automation.micas.compiler.ICompilerMessageListener;

/**
 * Abstract class which represents the compile invocation
 *
 * @author mkr
 */
public class AbstractMicasCompiler {

    private ICompilerMessageListener messageListener;

    protected void logToConsole(String message) {
        if (this.messageListener != null) {
            this.messageListener.onMessage(message);
        }
    }

    public void setCompilerMessageListener(ICompilerMessageListener messageListener) {
        this.messageListener = messageListener;

    }

}
