package de.wisag.automation.micas.common.licensing;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

public class LicenseInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4875354320618294803L;
    /*
     *
     */
    public static final String FILE_KEY_NAME = "name";
    public static final String FILE_KEY_COMPANY = "company";
    public static final String FILE_KEY_EMAIL = "email";

    public static final String FILE_KEY_HW_ID = "hwId";
    public static final String FILE_KEY_VALID_FOR_PRODUCT = "validForProduct";
    public static final String FILE_KEY_VALID_FOR_VERSION = "validForVersion";
    public static final String FILE_KEY_VALID_UNTIL = "validUntil";
    public static final String FILE_KEY_LICENSE_NUMBER = "licenseNumber";
    public static final String FILE_KEY_DATE_CREATED = "dateCreated";

    public static final String PROP_HW_ID = FILE_KEY_HW_ID;
    public static final String PROP_VALID_UNTIL = FILE_KEY_VALID_UNTIL;
    public static final String PROP_DATE_CREATED = FILE_KEY_DATE_CREATED;
    public static final String PROP_VALID_FOR_PRODUCT = FILE_KEY_VALID_FOR_PRODUCT;
    public static final String PROP_LICENSE_NUMBER = FILE_KEY_LICENSE_NUMBER;
    public static final String PROP_VALID_FOR_VERSION = "validForVersion";
    public static final String PROP_EMAIL = FILE_KEY_EMAIL;
    public static final String PROP_COMPANY = FILE_KEY_COMPANY;
    public static final String PROP_NAME = FILE_KEY_NAME;
    public static final String PROP_SIGNATURE = "signature";

    public static final String PROP_INFO = "info";
    public static final String PROP_LICENSE_STATUS = "licenseStatus";
    public static final String PROP_LICENSE_DIR = "licenseDir";
    public static final String PROP_LICENSE_DATA = "licenseData";

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private LicenseStatus licenseStatus = LicenseStatus.NOT_AVAILABLE;
    private String name;
    private String company;
    private String email;
    private Date dateCreated;
    private Date validUntil;
    private String validForVersion;
    private String licenseNumber;
    private String validForProduct;
    private String hwId;
    private String info;
    private String licenseDir;
    private String licenseData;
    private String signature;
    public static final String DATA_CHECKSUM = "dataChecksum";

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

    public String getValidForVersion() {
        return validForVersion;
    }

    public void setValidForVersion(String validForVersion) {
        firePropertyChange(PROP_VALID_FOR_VERSION, this.validForVersion, this.validForVersion = validForVersion);

    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        firePropertyChange(PROP_LICENSE_NUMBER, this.licenseNumber, this.licenseNumber = licenseNumber);
    }

    public String getValidForProduct() {
        return validForProduct;
    }

    public void setValidForProduct(String validForProduct) {
        // this.validForProduct = validForProduct;
        firePropertyChange(PROP_VALID_FOR_PRODUCT, this.validForProduct, this.validForProduct = validForProduct);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(propertyName, listener);
    }

    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        pcs.firePropertyChange(propertyName, oldValue, newValue);
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        firePropertyChange(PROP_DATE_CREATED, this.dateCreated, this.dateCreated = dateCreated);
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        firePropertyChange(PROP_VALID_UNTIL, this.validUntil, this.validUntil = validUntil);
    }

    public String getHwId() {
        return hwId;
    }

    public void setHwId(String hwId) {
        firePropertyChange(PROP_HW_ID, this.hwId, this.hwId = hwId);
    }

    public LicenseStatus getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(LicenseStatus licenseStatus) {
        firePropertyChange(PROP_LICENSE_STATUS, this.licenseStatus, this.licenseStatus = licenseStatus);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        firePropertyChange(PROP_INFO, this.info, this.info = info);
    }

    public String getLicenseDir() {
        return licenseDir;
    }

    public void setLicenseDir(String licenseDir) {
        firePropertyChange(PROP_LICENSE_DIR, this.licenseDir, this.licenseDir = licenseDir);
    }

    public String getLicenseData() {
        return licenseData;
    }

    public void setLicenseData(String licenseData) {
        firePropertyChange(PROP_LICENSE_DATA, this.licenseData, this.licenseData = licenseData);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((hwId == null) ? 0 : hwId.hashCode());
        result = prime * result + ((info == null) ? 0 : info.hashCode());
        result = prime * result + ((licenseData == null) ? 0 : licenseData.hashCode());
        result = prime * result + ((licenseDir == null) ? 0 : licenseDir.hashCode());
        result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
        result = prime * result + ((licenseStatus == null) ? 0 : licenseStatus.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((validForProduct == null) ? 0 : validForProduct.hashCode());
        result = prime * result + ((validForVersion == null) ? 0 : validForVersion.hashCode());
        result = prime * result + ((validUntil == null) ? 0 : validUntil.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LicenseInfo other = (LicenseInfo) obj;
        if (company == null) {
            if (other.company != null) {
                return false;
            }
        } else if (!company.equals(other.company)) {
            return false;
        }
        if (dateCreated == null) {
            if (other.dateCreated != null) {
                return false;
            }
        } else if (!dateCreated.equals(other.dateCreated)) {
            return false;
        }
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (hwId == null) {
            if (other.hwId != null) {
                return false;
            }
        } else if (!hwId.equals(other.hwId)) {
            return false;
        }
        if (info == null) {
            if (other.info != null) {
                return false;
            }
        } else if (!info.equals(other.info)) {
            return false;
        }
        if (licenseData == null) {
            if (other.licenseData != null) {
                return false;
            }
        } else if (!licenseData.equals(other.licenseData)) {
            return false;
        }
        if (licenseDir == null) {
            if (other.licenseDir != null) {
                return false;
            }
        } else if (!licenseDir.equals(other.licenseDir)) {
            return false;
        }
        if (licenseNumber == null) {
            if (other.licenseNumber != null) {
                return false;
            }
        } else if (!licenseNumber.equals(other.licenseNumber)) {
            return false;
        }
        if (licenseStatus != other.licenseStatus) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (validForProduct == null) {
            if (other.validForProduct != null) {
                return false;
            }
        } else if (!validForProduct.equals(other.validForProduct)) {
            return false;
        }
        if (validForVersion == null) {
            if (other.validForVersion != null) {
                return false;
            }
        } else if (!validForVersion.equals(other.validForVersion)) {
            return false;
        }
        if (validUntil == null) {
            if (other.validUntil != null) {
                return false;
            }
        } else if (!validUntil.equals(other.validUntil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LicenseInfo [licenseStatus=" + licenseStatus + ", name=" + name + ", company=" + company + ", email="
                + email + ", dateCreated=" + dateCreated + ", validUntil=" + validUntil + ", validForVersion="
                + validForVersion + ", licenseNumber=" + licenseNumber + ", validForProduct=" + validForProduct
                + ", hwId=" + hwId + ", info=" + info + ", licenseDir=" + licenseDir + ", licenseData=" + licenseData
                + "]";
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        firePropertyChange(PROP_SIGNATURE, this.signature, this.signature = signature);
    }

}
