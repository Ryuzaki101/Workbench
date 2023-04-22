package de.wisag.automation.micas.workbench.licmgr.admin;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "license-history-item", propOrder = { "created", "requestData", "responseData" })
@XmlRootElement(name = "license-history-item")
public class LicenseHistoryItem {

    private Date created;

    @XmlElement(name = "request-data")
    private String requestData;

    @XmlElement(name = "response-data")
    private String responseData;

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((requestData == null) ? 0 : requestData.hashCode());
        result = prime * result + ((responseData == null) ? 0 : responseData.hashCode());
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
        LicenseHistoryItem other = (LicenseHistoryItem) obj;
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
            return false;
        }
        if (requestData == null) {
            if (other.requestData != null) {
                return false;
            }
        } else if (!requestData.equals(other.requestData)) {
            return false;
        }
        if (responseData == null) {
            if (other.responseData != null) {
                return false;
            }
        } else if (!responseData.equals(other.responseData)) {
            return false;
        }
        return true;
    }
}
