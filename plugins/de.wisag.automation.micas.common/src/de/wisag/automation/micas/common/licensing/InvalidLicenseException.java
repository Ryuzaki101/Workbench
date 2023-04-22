package de.wisag.automation.micas.common.licensing;

public class InvalidLicenseException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidLicenseException(String message, Throwable cause) {
        super(message, cause);
    }
}
