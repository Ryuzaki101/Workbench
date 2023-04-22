package de.wisag.automation.micas.workbench.licmgr.admin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
class ObjectFactory {

    private final static QName _LicenseData_QNAME = new QName("de.wisag.automation.micas.workbench.licmgr.admin",
            "license-data");
    private final static QName _LicenseHistoryItem_QNAME = new QName("de.wisag.automation.micas.workbench.licmgr.admin",
            "license-history-item");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: de.tutorials
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LicenseData }
     */
    public LicenseData createLicenseData() {
        return new LicenseData();
    }

    /**
     * Create an instance of {@link LicenseHistoryItem }
     */
    public LicenseHistoryItem createLicenseHistoryItem() {
        return new LicenseHistoryItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Course
     * }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "LicenseData")
    public JAXBElement<LicenseData> createLicenseData(LicenseData value) {
        return new JAXBElement<>(_LicenseData_QNAME, LicenseData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Course
     * }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "LicenseHistoryItem")
    public JAXBElement<LicenseHistoryItem> createLicenseHistoryItem(LicenseHistoryItem value) {
        return new JAXBElement<>(_LicenseHistoryItem_QNAME, LicenseHistoryItem.class, null, value);
    }

}