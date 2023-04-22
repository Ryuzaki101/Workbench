package de.wisag.automation.micas.olt.base.connection;

public class DeviceBusyException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -6058156152618045905L;

    public DeviceBusyException(String message) {
        super(message);
    }

}
