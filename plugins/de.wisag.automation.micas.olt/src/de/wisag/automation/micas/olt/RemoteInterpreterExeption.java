package de.wisag.automation.micas.olt;

public class RemoteInterpreterExeption extends Exception {

    private int code = -1;

    public int getCode() {
        return code;
    }

    public RemoteInterpreterExeption(String message) {
        super(message);
    }

    public RemoteInterpreterExeption(String message, Throwable cause) {
        super(message, cause);

    }

    public RemoteInterpreterExeption(String message, int code) {
        super(message);
        this.code = code;
    }

    /**
     *
     */
    private static final long serialVersionUID = 7878087364091345977L;

}
