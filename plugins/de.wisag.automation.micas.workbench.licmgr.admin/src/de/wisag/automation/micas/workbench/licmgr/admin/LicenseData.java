package de.wisag.automation.micas.workbench.licmgr.admin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "license-data", propOrder = { "productId", "productName", "licenseId", "companyName", "name", "email",
        "abandoned", "history" })
@XmlRootElement(name = "license-data")
public class LicenseData {
    @XmlElement(name = "product-id")
    private String productId;
    @XmlElement(name = "product-name")
    private String productName;

    @XmlElement(name = "license-id")
    private String licenseId;

    @XmlElement(name = "company-name")
    private String companyName;
    private String name;
    private String email;
    private boolean abandoned;
    @XmlElement(name = "history-item")
    private List<LicenseHistoryItem> history;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public List<LicenseHistoryItem> getHistory() {
        return history;
    }

    public void setHistory(List<LicenseHistoryItem> history) {
        this.history = history;
    }

    public boolean isAbandoned() {
        return abandoned;
    }

    public void setAbandoned(boolean abandoned) {
        this.abandoned = abandoned;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void addHistoryItem(LicenseHistoryItem item) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        this.history.add(item);

    }
}
