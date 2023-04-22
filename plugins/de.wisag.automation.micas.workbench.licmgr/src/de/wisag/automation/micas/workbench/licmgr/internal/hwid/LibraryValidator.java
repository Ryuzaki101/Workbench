package de.wisag.automation.micas.workbench.licmgr.internal.hwid;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.wisag.automation.micas.workbench.licmgr.internal.Policy;

/**
 * Checks the native libraries against given checksums
 */
public class LibraryValidator {

    private static Map<String, String> checksums = new HashMap<String, String>() {
        private static final long serialVersionUID = -6793218346608050449L;
        {
            put("win32/x86", "f4dcdbbe6053ba4df08ff649e6e24346e922c04a");
            put("win32/amd64", "68ae0b1f13ab96ae369e2fc95fd69fdea0748ad8");
            // put("linux/x86", "68ae0b1f13ab96ae369e2fc95fd69fdea0748ad8");
            // put("linux/amd64", "68ae0b1f13ab96ae369e2fc95fd69fdea0748ad8");
        }
    };

    /**
     * Calculate the hash of native libraries
     *
     * @return
     */
    public String calculateHash() {
        Bundle bundle = FrameworkUtil.getBundle(getClass());
        if (bundle == null) {
            return null;
        }
        String nativeCode = bundle.getHeaders().get("Bundle-NativeCode");
        if (nativeCode == null) {
            return null;
        }
        String[] entries = StringUtils.split(nativeCode, ',');

        String os = bundle.getBundleContext().getProperty("osgi.os");
        String arch = bundle.getBundleContext().getProperty("osgi.arch");
        for (String entry : entries) {
            String[] elements = StringUtils.split(entry, ';');
            String resource = StringUtils.trimToEmpty(elements[0]);
            String osnameEntry = StringUtils.trimToEmpty(elements[1]);
            String[] osNameKv = StringUtils.split(osnameEntry, '=');
            String osname = null;
            if (osNameKv != null && osNameKv.length > 0) {
                osname = osNameKv[1];
            }
            String processorEntry = StringUtils.trimToEmpty(elements[2]);
            String[] prozessorKv = StringUtils.split(processorEntry, '=');
            String processor = null;
            if (prozessorKv != null && prozessorKv.length > 0) {
                processor = prozessorKv[1];
            }
            if (StringUtils.equals(os, osname) && StringUtils.equals(arch, processor)) {
                URL libEntry = bundle.getEntry(resource);
                if (libEntry == null) {
                    return "!!DLL NOT FOUND-THIS IS NO HEX DIGEST!!";
                }
                try (InputStream is = libEntry.openStream()) {
                    return DigestUtils.sha1Hex(is);
                } catch (IOException e) {
                    Policy.logError(e);
                }

            }

        }
        return null;
    }

    boolean isValidLibrary() {
        Bundle bundle = FrameworkUtil.getBundle(getClass());
        if (bundle == null) {
            return false;
        }
        String os = bundle.getBundleContext().getProperty("osgi.os");
        String arch = bundle.getBundleContext().getProperty("os.arch");
        String currentHash = calculateHash();
        String key = String.format("%s/%s", os, arch);
        if (checksums.containsKey(key)) {
            String checksum = checksums.get(key);
            if (StringUtils.equalsIgnoreCase(checksum, currentHash)) {
                return true;
            }
        }
        return false;
    }

    public IStatus validate() {
        IStatus status = Status.OK_STATUS;
        if (!isValidLibrary()) {
            return Policy.errorStatus("Library checksum mismatch!");
        }
        return status;
    }
}
