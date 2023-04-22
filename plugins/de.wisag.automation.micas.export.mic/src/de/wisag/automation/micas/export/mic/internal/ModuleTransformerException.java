package de.wisag.automation.micas.export.mic.internal;

public class ModuleTransformerException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int code = 0;

    public ModuleTransformerException(int code, String message, Throwable exception) {
        super(message, exception);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
