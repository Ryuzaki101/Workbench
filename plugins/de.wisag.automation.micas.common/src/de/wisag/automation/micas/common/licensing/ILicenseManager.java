package de.wisag.automation.micas.common.licensing;

/**
 * This interface provides access to the Licensing facility of the micas
 * workbench. This interface is registered as a OSGI service
 */
public interface ILicenseManager {
    public final long NO_EXPIRATION_INFO_AVAILABLE = -1;

    /**
     * Caller can ask, if the feature <code>feature</code> is covered by the
     * current license
     *
     * @param feature
     * @return true if the feature is licensed, otherwise false
     */

    boolean isLicensed(Feature feature);

    /**
     * @return the current license information
     */
    LicenseInfo getLicenseInfo();

    /**
     * Store the the given license request
     *
     * @param info
     */
    void storeRequest(LicenseInfo info);

    /**
     * Load the last license request if available
     *
     * @return License request
     */
    LicenseInfo loadLastRequest();

    /**
     * @param info
     */
    void applyAndStoreLicense(LicenseInfo info);

    /**
     * @return true if workbench is running in demo mode
     */
    boolean isDemoMode();

    LicenseInfo sweepLicenseData();

    long expiresInDays();

}
