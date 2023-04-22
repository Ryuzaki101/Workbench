package de.wisag.automation.micas.common.licensing;

public enum LicenseStatus {
    /** license status is invalid **/
    INVALID,
    /** license not available **/
    NOT_AVAILABLE,
    /** license is valid **/
    VALID,
    /** license is valid **/
    EXPIRED,
    /** license is a request **/
    REQUEST,
    /** license is a response **/
    RESPONSE
}
