package de.wisag.automation.micas.export.mic;

@SuppressWarnings("serial")
public class DiagramCompilerException extends RuntimeException {
    public enum Code {
        ATTRIBUTE_WITH_NULL_NAME_ON_INPUT_PORT,//
        ;
    }

    private final Code code;

    public DiagramCompilerException(Code code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DiagramCompilerException(Code code, String message) {
        super(message);
        this.code = code;
    }

    public Code code() {
        return code;
    }

}
