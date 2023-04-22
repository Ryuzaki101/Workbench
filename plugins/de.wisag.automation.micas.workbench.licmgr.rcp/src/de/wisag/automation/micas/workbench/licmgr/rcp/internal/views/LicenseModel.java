package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import de.wisag.automation.micas.common.model.AbstractModelObject;
import de.wisag.automation.micas.workbench.licmgr.rcp.internal.Activator;
import de.wisag.automation.micas.workbench.licmgr.rcp.internal.Policy;

public class LicenseModel extends AbstractModelObject {

    public static final String PROP_PUBLIC_KEY_URL = "publicKeyUrl";
    public static final String PROP_AVAILABLE_VERSIONS = "availableVersions";
    public static final String PROP_AVAILABLE_PRODUCTS = "availableProducts";
    public static final String PROP_HARDWARE_ID = "hardwareId";
    public static final String PROP_LICENSE_NUMBER = "licenseNumber";
    public static final String PROP_VALID_FOR_PRODUCT = "validForProduct";
    public static final String PROP_VALID_FOR_VERSION = "validForVersion";
    public static final String PROP_DATE_VALID_UNTIL = "dateValidUntil";
    public static final String PROP_DATE_CREATED = "dateCreated";
    public static final String PROP_EMAIL = "email";
    public static final String PROP_COMPANY = "company";
    public static final String PROP_NAME = "name";
    public static final String PROP_LICENSE_RESPONSE = "licenseResponse";
    public static final String PROP_LICENSE_REQUEST = "licenseRequest";
    public static final String PROP_KEYSTORE_PASSWORD = "keystorePassword";
    public static final String PROP_KEYSTORE_STATUS = "keystoreStatus";
    public static final String PROP_PRIVATE_KEY_URL = "privateKeyUrl";

    private URL privateKeyUrl;
    private URL publicKeyUrl;
    private KeyStoreStatus keystoreStatus = KeyStoreStatus.NOT_AUTHENTICATED;
    private String keystorePassword = "";
    private String keyId;
    private String licenseRequest;
    private String licenseResponse;

    private String name;
    private String company;
    private String email;
    private Date dateCreated;
    private Date dateValidUntil;
    private String validForVersion;
    private String validForProduct;
    private String licenseNumber;
    private String hardwareId;
    private List<String> availableProducts;
    private List<String> availableVersions;

    public LicenseModel() {
        try {
            this.privateKeyUrl = new URL(String.format("platform:/plugin/%s/privatekey.asc", Activator.PLUGIN_ID));
            this.publicKeyUrl = new URL(
                    String.format("platform:/plugin/%s/publickey.asc", "de.wisag.automation.micas.workbench.licmgr"));

        } catch (MalformedURLException e) {
            Policy.logError(e);
            this.privateKeyUrl = null;
            this.publicKeyUrl = null;
        }
    }

    public URL getPrivateKeyUrl() {
        return privateKeyUrl;
    }

    public void setPrivateKeyUrl(URL privateKeyUrl) {
        firePropertyChange(PROP_PRIVATE_KEY_URL, this.privateKeyUrl, this.privateKeyUrl = privateKeyUrl);
    }

    public KeyStoreStatus getKeystoreStatus() {
        return keystoreStatus;
    }

    public void setKeystoreStatus(KeyStoreStatus keystoreStatus) {
        firePropertyChange(PROP_KEYSTORE_STATUS, this.keystoreStatus, this.keystoreStatus = keystoreStatus);
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        firePropertyChange(PROP_KEYSTORE_PASSWORD, this.keystorePassword, this.keystorePassword = keystorePassword);
    }

    public String getLicenseRequest() {
        return licenseRequest;
    }

    public void setLicenseRequest(String licenseRequest) {
        firePropertyChange(PROP_LICENSE_REQUEST, this.licenseRequest, this.licenseRequest = licenseRequest);
    }

    public String getLicenseResponse() {
        return licenseResponse;
    }

    public void setLicenseResponse(String licenseResponse) {
        firePropertyChange(PROP_LICENSE_RESPONSE, this.licenseResponse, this.licenseResponse = licenseResponse);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        firePropertyChange(PROP_NAME, this.name, this.name = name);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        firePropertyChange(PROP_COMPANY, this.company, this.company = company);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        firePropertyChange(PROP_EMAIL, this.email, this.email = email);
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        firePropertyChange(PROP_DATE_CREATED, this.dateCreated, this.dateCreated = dateCreated);
    }

    public Date getDateValidUntil() {
        return dateValidUntil;
    }

    public void setDateValidUntil(Date dateValidUntil) {
        firePropertyChange(PROP_DATE_VALID_UNTIL, this.dateValidUntil, this.dateValidUntil = dateValidUntil);
    }

    public String getValidForVersion() {
        return validForVersion;
    }

    public void setValidForVersion(String dateValidForVersion) {
        firePropertyChange(PROP_VALID_FOR_VERSION, this.validForVersion, this.validForVersion = dateValidForVersion);
    }

    public String getValidForProduct() {
        return validForProduct;
    }

    public void setValidForProduct(String dateValidForProduct) {
        firePropertyChange(PROP_VALID_FOR_PRODUCT, this.validForProduct, this.validForProduct = dateValidForProduct);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        firePropertyChange(PROP_LICENSE_NUMBER, this.licenseNumber, this.licenseNumber = licenseNumber);
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        firePropertyChange(PROP_HARDWARE_ID, this.hardwareId, this.hardwareId = hardwareId);
    }

    public List<String> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<String> availableProducts) {
        firePropertyChange(PROP_AVAILABLE_PRODUCTS, this.availableProducts, this.availableProducts = availableProducts);
    }

    public List<String> getAvailableVersions() {
        return availableVersions;
    }

    public void setAvailableVersions(List<String> availableVersions) {
        firePropertyChange(PROP_AVAILABLE_VERSIONS, this.availableVersions, this.availableVersions = availableVersions);
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        firePropertyChange("keyId", this.keyId, this.keyId = keyId);
    }

    public URL getPublicKeyUrl() {
        return publicKeyUrl;
    }

    public void setPublicKeyUrl(URL publicKeyUrl) {
        firePropertyChange(PROP_PUBLIC_KEY_URL, this.publicKeyUrl, this.publicKeyUrl = publicKeyUrl);
    }

}
