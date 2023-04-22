package de.wisag.automation.micas.workbench.licmgr.admin.internal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.core.runtime.Path;

import de.wisag.automation.micas.workbench.licmgr.admin.LicenseData;

public class DataManager {

    public void save(LicenseData data, Path path) {
        Marshaller marshaller = null;
        try {
            marshaller = JAXBContext.newInstance("de.wisag.automation.micas.workbench.licmgr.admin").createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        try {
            marshaller.marshal(data, System.out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
