package de.wisag.automation.micas.workbench.licmgr.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.service.component.ComponentContext;

import de.wisag.automation.micas.common.licensing.Feature;
import de.wisag.automation.micas.common.licensing.ILicenseManager;
import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.common.licensing.LicenseStatus;
import de.wisag.automation.micas.workbench.licmgr.internal.hwid.LibraryValidator;
import de.wisag.automation.micas.workbench.licmgr.utils.LicenseCorruptionException;
import de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils;

public class LicenseManagerComponent implements ILicenseManager {

    private static final String LICENSE_REQ_FILE = "license.req";
    private static final String LICENSE_FILE = "license.lic";
    /** the global license */
    private static final String GL = "81D786A0306441E08A24EDE4C529380F";
    /** the global license property */
    private static final String GLK = "4CA786343D844C1B922A9BD65A8EEDB9";

    private final AtomicReference<Location> locationRef = new AtomicReference<>();
    private LicenseInfo licenseInfo = null;

    @Override
    public boolean isLicensed(Feature feature) {
        return (this.licenseInfo != null && LicenseStatus.VALID.equals(this.licenseInfo.getLicenseStatus())) ? true
                : false;
    }

    public LicenseManagerComponent() {
        licenseInfo = new LicenseInfo();
        licenseInfo.setInfo("Not initialized");

    }

    public void activate(ComponentContext context) {
        if (System.getProperty(GLK, GLK).equals(GL)) {
            // enable a global license key
            /**
             * start with -DGL=GLK for example
             * -D81D786A0306441E08A24EDE4C529380F=4CA786343D844C1B922A9BD65A8EEDB9
             * this will provide you a master license
             */
            this.licenseInfo = new LicenseInfo();
            this.licenseInfo.setCompany("Wisag");
            this.licenseInfo.setEmail("sag@ich.net");
            this.licenseInfo.setHwId("every");
            this.licenseInfo.setInfo("DevelopmentMode, no license checked!");
            this.licenseInfo.setLicenseNumber("0000000");
            this.licenseInfo.setLicenseStatus(LicenseStatus.VALID);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, 100);
            this.licenseInfo.setValidUntil(calendar.getTime());

            return;
        }

        IStatus libraryStatus = new LibraryValidator().validate();
        if (!libraryStatus.isOK()) {
            Policy.log(libraryStatus);
            errorLicense("ERROR Occured! See errorlog for details.");
            return;
        }
        // check the license file
        File licenseFile = getLicenseFile().toFile();
        if (!licenseFile.exists()) {
            Policy.logWarning(String.format("Licensefile '%s' not found!", getLicenseFile().toOSString()));
            errorLicense("ERROR Occured! See errorlog for details.");
            return;
        }

        // read the license file
        String data = null;
        Reader fr = null;
        try {
            fr = new BufferedReader(new FileReader(licenseFile));
            data = IOUtils.toString(fr);
        } catch (IOException e) {
            Policy.logError(e);
            errorLicense("ERROR Occured! See errorlog for details.");
        } finally {
            IOUtils.closeQuietly(fr);
        }

        // decode the license file
        LicenseInfo info = null;
        try {
            info = LicenseManagerUtils.createFromResponse(data);
        } catch (LicenseCorruptionException e) {
            Policy.logError(String.format("Licensefile '%s' is corrupted", licenseFile.getAbsolutePath()));
            errorLicense("ERROR Occured! See errorlog for details.");
            return;
        }
        // check the signature
        IStatus status = LicenseManagerUtils.checkSignatureAndVerifyLicense(info);
        if (!status.isOK()) {
            Policy.log(status);
            errorLicense("ERROR Occured! See errorlog for details.");
            return;
        }

        this.licenseInfo = info;

    }

    private void errorLicense(String info) {
        licenseInfo = new LicenseInfo();
        licenseInfo.setInfo(info);
        licenseInfo.setValidUntil(new Date());
    }

    private IPath getLicenseFile() {
        IPath licenseDir = getLicenseDir();
        IPath licenseFile = licenseDir.append(LICENSE_FILE);
        return licenseFile;
    }

    private IPath getLicenseRequestFile() {
        return getLicenseDir().append(LICENSE_REQ_FILE);
    }

    private IPath getLicenseDir() {
        IPath configLocation = getConfigurationLocation();
        IPath licenseDir = configLocation.append("de.wisag.automation.micas.workbench");
        return licenseDir;
    }

    public IPath getConfigurationLocation() {
        IPath result = null;
        Location location = getLocation();
        if (!location.isReadOnly()) {
            URL url = location.getURL();
            if (url != null) {
                result = new Path(url.getFile());
                if (result.isEmpty()) {
                    result = null;
                }
            }
        }
        return result;
    }

    public void deactivate(ComponentContext context) {

    }

    public void bindLocation(Location location) {
        locationRef.set(location);
    }

    public void unbindLocation(Location location) {
        locationRef.compareAndSet(location, null);
    }

    public Location getLocation() {
        return locationRef.get();
    }

    @Override
    public LicenseInfo getLicenseInfo() {

        return licenseInfo;
    }

    @Override
    public void storeRequest(LicenseInfo info) {
        File requestFile = getLicenseRequestFile().toFile();
        if (!requestFile.getParentFile().exists()) {
            requestFile.getParentFile().mkdirs();
        }

        if (requestFile.exists()) {
            FileUtils.deleteQuietly(requestFile);
        }
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(requestFile));
            stream.writeObject(info);
        } catch (FileNotFoundException e) {
            Policy.logError(e);
        } catch (IOException e) {
            Policy.logError(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    @Override
    public LicenseInfo loadLastRequest() {
        File requestFile = getLicenseRequestFile().toFile();

        if (!requestFile.exists()) {
            return null;
        }

        Object object = null;
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(requestFile));
            object = stream.readObject();
        } catch (FileNotFoundException e) {
            Policy.logError(e);
        } catch (IOException e) {
            Policy.logError(e);
        } catch (ClassNotFoundException e) {
            Policy.logError(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }

        LicenseInfo licenseInfo2 = object != null && object instanceof LicenseInfo ? (LicenseInfo) object : null;

        if (licenseInfo2 != null) {
            // apply the license data if available
            File licenseFile = getLicenseFile().toFile();
            if (licenseFile.exists()) {
                String data = null;
                Reader fr = null;
                try {
                    fr = new BufferedReader(new FileReader(licenseFile));
                    data = IOUtils.toString(fr);
                } catch (IOException e) {
                    // ignore
                } finally {
                    IOUtils.closeQuietly(fr);
                }
                licenseInfo2.setLicenseData(data);
            }
        }
        return licenseInfo2;
    }

    @Override
    public void applyAndStoreLicense(LicenseInfo info) {
        Assert.isNotNull(info, "'info' must not be null");
        Assert.isNotNull(info.getLicenseData(), "'info.licenseData' must not be null");
        String data = info.getLicenseData();

        File licenseFile = getLicenseFile().toFile();
        if (!licenseFile.getParentFile().exists()) {
            licenseFile.getParentFile().mkdirs();
        }

        if (licenseFile.exists()) {
            FileUtils.deleteQuietly(licenseFile);
        }
        FileWriter ow = null;
        try {
            ow = new FileWriter(licenseFile);
            IOUtils.write(data, ow);
        } catch (IOException e) {
            Policy.logError(e);
        } finally {
            IOUtils.closeQuietly(ow);
        }
        this.licenseInfo = info;
    }

    @Override
    public boolean isDemoMode() {
        return !isLicensed(null);
    }

    @Override
    public LicenseInfo sweepLicenseData() {
        FileUtils.deleteQuietly(getLicenseFile().toFile());
        FileUtils.deleteQuietly(getLicenseRequestFile().toFile());
        errorLicense("License Informations cleaned from disk.");
        ;
        return this.licenseInfo;
    }

    @Override
    public long expiresInDays() {
        LicenseInfo currentInfo = getLicenseInfo();
        if (currentInfo == null || currentInfo.getLicenseStatus() != LicenseStatus.VALID) {
            return NO_EXPIRATION_INFO_AVAILABLE;
        }
        long yetValidInMs = currentInfo.getValidUntil().getTime() - System.currentTimeMillis();
        long daysYetValid = TimeUnit.DAYS.convert(yetValidInMs, TimeUnit.MILLISECONDS);
        if (daysYetValid == 0) {
            long hourcsYetValid = TimeUnit.HOURS.convert(yetValidInMs, TimeUnit.MILLISECONDS);
            if (hourcsYetValid > 0) {
                return 1;
            }
        }
        if (daysYetValid > 0) {
            return daysYetValid;
        }
        return 0;
    }
}
