package de.wisag.automation.micas.workbench.licmgr.utils;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.common.hashing.DigestUtils;
import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.common.licensing.LicenseStatus;
import de.wisag.automation.micas.workbench.licmgr.internal.Policy;
import de.wisag.automation.micas.workbench.licmgr.internal.check.LicenseVerifier;
import de.wisag.automation.micas.workbench.licmgr.internal.check.SignatureCheck;

public class LicenseManagerUtils {
    private static final String PUBLICKEY_URL = "platform:/plugin/de.wisag.automation.micas.workbench.licmgr/publickey.asc";

    public static final String REQUEST_MSG_HEADER = "-----BEGIN MICAS LICENSE REQUEST-----";
    public static final String REQUEST_MSG_FOOTER = "-----END MICAS LICENSE REQUEST  -----";

    public static final String RESPONSE_MSG_HEADER = "-----BEGIN MICAS LICENSE-----";
    public static final String RESPONSE_MSG_FOOTER = "-----END MICAS LICENSE-----";

    public static LicenseInfo createFromResponse(String msg) {
        Assert.isNotNull(msg);
        String regex = String.format("^\\s*%1$s(.+)%2$s\\s*$", RESPONSE_MSG_HEADER, RESPONSE_MSG_FOOTER);
        String m2 = StringUtils.remove(msg, '\r');
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = null;
        String data = null;
        if ((m = p.matcher(m2)).matches() && m.groupCount() == 1) {
            data = StringUtils.trimToEmpty(m.group(1));

        }
        if (data == null) {
            throw new LicenseCorruptionException("Could not decode request message : '" + msg);
        }
        LineNumberReader reader = new LineNumberReader(new StringReader(data));
        String line = null;
        LicenseInfo info = new LicenseInfo();
        info.setLicenseStatus(LicenseStatus.RESPONSE);

        StringBuilder sigBuffer = new StringBuilder();

        boolean inSignature = false;
        try {
            while ((line = reader.readLine()) != null) {
                line = StringUtils.trimToEmpty(line);
                if (inSignature) {
                    sigBuffer.append(line).append(SystemUtils.LINE_SEPARATOR);
                    if (line.startsWith("-----END PGP SIGNATURE-----")) {
                        break;
                    }
                    continue;
                }
                if (line.startsWith("-----BEGIN PGP SIGNATURE-----")) {
                    sigBuffer.append(line).append(SystemUtils.LINE_SEPARATOR);
                    inSignature = true;
                    continue;
                }

                String[] elements = StringUtils.split(line, '=');
                String key = null;
                String value = null;
                if (elements != null && elements.length > 0) {
                    key = elements[0];
                }
                if (elements != null && elements.length > 1) {
                    value = StringUtils.trimToEmpty(elements[1]);
                }
                if (LicenseInfo.FILE_KEY_NAME.equals(key)) {
                    info.setName(value);

                } else if (LicenseInfo.FILE_KEY_COMPANY.equals(key)) {
                    info.setCompany(value);

                } else if (LicenseInfo.FILE_KEY_EMAIL.equals(key)) {
                    info.setEmail(value);

                } else if (LicenseInfo.FILE_KEY_DATE_CREATED.equals(key)) {
                    info.setDateCreated(
                            DateUtils.parseDate(value, new String[] { DateFormatUtils.ISO_DATE_FORMAT.getPattern() }));

                } else if (LicenseInfo.FILE_KEY_HW_ID.equals(key)) {
                    info.setHwId(value);

                } else if (LicenseInfo.FILE_KEY_LICENSE_NUMBER.equals(key)) {
                    info.setLicenseNumber(value);

                } else if (LicenseInfo.FILE_KEY_VALID_FOR_PRODUCT.equals(key)) {
                    info.setValidForProduct(value);

                } else if (LicenseInfo.FILE_KEY_VALID_FOR_VERSION.equals(key)) {
                    info.setValidForVersion(value);

                } else if (LicenseInfo.FILE_KEY_VALID_UNTIL.equals(key)) {
                    info.setValidUntil(
                            DateUtils.parseDate(value, new String[] { DateFormatUtils.ISO_DATE_FORMAT.getPattern() }));

                }

            }
        } catch (IOException e) {
            Policy.logError(e);
            return null;
        } catch (ParseException e) {
            Policy.logError(e);
            return null;
        } finally {
            IOUtils.closeQuietly(reader);
        }
        info.setSignature(sigBuffer.toString());
        info.setLicenseData(msg);
        return info;

    }

    /**
     * scramble the given properties <code>properties</code>
     *
     * @param header
     *            a header text
     * @param footer
     *            a footer text
     * @param info
     * @return
     */
    public static String toRequest(LicenseInfo licenseInfo, String header, String footer) {
        StringBuilder sb = new StringBuilder();
        sb.append(header).append(SystemUtils.LINE_SEPARATOR);
        String name = StringUtils.trimToEmpty(licenseInfo.getName());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_NAME, name)).append(SystemUtils.LINE_SEPARATOR);
        String company = StringUtils.trimToEmpty(licenseInfo.getCompany());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_COMPANY, company)).append(SystemUtils.LINE_SEPARATOR);
        String email = StringUtils.trimToEmpty(licenseInfo.getEmail());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_EMAIL, email)).append(SystemUtils.LINE_SEPARATOR);
        String dateCreated = StringUtils
                .trimToEmpty(DateFormatUtils.ISO_DATE_FORMAT.format(licenseInfo.getDateCreated()));
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_DATE_CREATED, dateCreated))
                .append(SystemUtils.LINE_SEPARATOR);
        String hwId = StringUtils.trimToEmpty(licenseInfo.getHwId());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_HW_ID, hwId)).append(SystemUtils.LINE_SEPARATOR);
        String requestChecksum = calculateRequestChecksum(name, company, email, dateCreated, hwId);
        sb.append(String.format("%s=%s", LicenseInfo.DATA_CHECKSUM, requestChecksum))
                .append(SystemUtils.LINE_SEPARATOR);
        sb.append(footer).append(SystemUtils.LINE_SEPARATOR);
        return sb.toString();
    }

    private static String calculateRequestChecksum(String name, String company, String email, String dateCreated,
            String hwId) {
        StringBuffer sb2 = new StringBuffer();
        sb2.append(name);
        sb2.append(company);
        sb2.append(email);
        sb2.append(dateCreated);
        sb2.append(hwId);
        return DigestUtils.calculateSha1Hash(sb2.toString());
    }

    /**
     * This method parses a message and creates an License info object. The
     * fields : <b>name,company,email,hwId,dateCreated </b> are used for
     * checking the integrity of the message
     *
     * @param msg
     * @param header
     * @param footer
     * @return
     */
    public static LicenseInfo createFromRequest(String msg, String header, String footer) {
        Assert.isNotNull(msg);
        String regex = String.format("^\\s*%1$s(.+)%2$s\\s*$", header, footer);
        String m2 = StringUtils.remove(msg, '\r');
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = null;
        String data = null;
        if ((m = p.matcher(m2)).matches() && m.groupCount() == 1) {
            data = StringUtils.trimToEmpty(m.group(1));

        }
        if (data == null) {
            throw new RuntimeException("Could not decode request message : '" + msg);
        }
        LineNumberReader reader = new LineNumberReader(new StringReader(data));
        String line = null;
        LicenseInfo info = new LicenseInfo();
        info.setLicenseStatus(LicenseStatus.REQUEST);
        String name = "";
        String company = "";
        String email = "";
        String hwId = "";
        String dataChecksum = "";
        String sDateCreated = "";

        try {
            while ((line = reader.readLine()) != null) {
                line = StringUtils.trimToEmpty(line);
                String[] elements = StringUtils.split(line, '=');
                String key = null;
                String value = null;
                if (elements != null && elements.length > 0) {
                    key = elements[0];
                }
                if (elements != null && elements.length > 1) {
                    value = StringUtils.trimToEmpty(elements[1]);
                }
                if (LicenseInfo.FILE_KEY_NAME.equals(key)) {
                    name = value;

                } else if (LicenseInfo.FILE_KEY_COMPANY.equals(key)) {
                    company = value;

                } else if (LicenseInfo.FILE_KEY_EMAIL.equals(key)) {
                    email = value;

                } else if (LicenseInfo.FILE_KEY_DATE_CREATED.equals(key)) {
                    sDateCreated = value;

                } else if (LicenseInfo.FILE_KEY_HW_ID.equals(key)) {
                    hwId = value;

                } else if (LicenseInfo.DATA_CHECKSUM.equals(key)) {
                    dataChecksum = value;

                }

            }
        } catch (IOException e) {
            Policy.logError(e);
        }
        IOUtils.closeQuietly(reader);
        info.setName(name);
        info.setCompany(company);
        info.setEmail(email);
        info.setHwId(hwId);
        String checkSum = calculateRequestChecksum(name, company, email, sDateCreated, hwId);
        if (!StringUtils.equalsIgnoreCase(checkSum, dataChecksum)) {
            Policy.logError("Checksum mismatch for message : '" + msg + "'");
            throw new ChecksumMismatchException("Request checksum mismatch");
        }
        try {
            Date date = DateUtils.parseDate(sDateCreated,
                    new String[] { DateFormatUtils.ISO_DATE_FORMAT.getPattern() });
            date = DateUtils.truncate(date, Calendar.DATE);
            info.setDateCreated(date);
        } catch (ParseException e) {
            Policy.logError(e);
        }
        return info;
    }

    public static String encodeLicense(LicenseInfo licenseInfo) {
        StringBuilder sb = new StringBuilder();
        String number = StringUtils.trimToEmpty(licenseInfo.getLicenseNumber());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_LICENSE_NUMBER, number))
                .append(SystemUtils.LINE_SEPARATOR);

        String name = StringUtils.trimToEmpty(licenseInfo.getName());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_NAME, name)).append(SystemUtils.LINE_SEPARATOR);

        String company = StringUtils.trimToEmpty(licenseInfo.getCompany());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_COMPANY, company)).append(SystemUtils.LINE_SEPARATOR);

        String email = StringUtils.trimToEmpty(licenseInfo.getEmail());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_EMAIL, email)).append(SystemUtils.LINE_SEPARATOR);

        String dateCreated = StringUtils
                .trimToEmpty(DateFormatUtils.ISO_DATE_FORMAT.format(licenseInfo.getDateCreated()));
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_DATE_CREATED, dateCreated))
                .append(SystemUtils.LINE_SEPARATOR);

        String hwId = StringUtils.trimToEmpty(licenseInfo.getHwId());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_HW_ID, hwId)).append(SystemUtils.LINE_SEPARATOR);

        String validForProduct = StringUtils.trimToEmpty(licenseInfo.getValidForProduct());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_VALID_FOR_PRODUCT, validForProduct))
                .append(SystemUtils.LINE_SEPARATOR);

        String validForVersion = StringUtils.trimToEmpty(licenseInfo.getValidForVersion());
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_VALID_FOR_VERSION, validForVersion))
                .append(SystemUtils.LINE_SEPARATOR);

        String dateValidUntil = StringUtils
                .trimToEmpty(DateFormatUtils.ISO_DATE_FORMAT.format(licenseInfo.getValidUntil()));
        sb.append(String.format("%s=%s", LicenseInfo.FILE_KEY_VALID_UNTIL, dateValidUntil))
                .append(SystemUtils.LINE_SEPARATOR);
        return sb.toString();
    }

    /**
     * Build a hash over a given license. Only field values are considered. The
     * Values are appended to a string and a sha1 checksum is calculated.
     * Whitespaces are ignored.
     *
     * @param licenseInfo
     * @return
     */
    public static String createLicenseHash(LicenseInfo licenseInfo) {
        StringBuilder sb = new StringBuilder();
        String number = StringUtils.trimToEmpty(licenseInfo.getLicenseNumber());
        sb.append(number);
        String name = StringUtils.trimToEmpty(licenseInfo.getName());
        sb.append(name);
        String company = StringUtils.trimToEmpty(licenseInfo.getCompany());
        sb.append(company);
        String email = StringUtils.trimToEmpty(licenseInfo.getEmail());
        sb.append(email);
        String dateCreated = StringUtils
                .trimToEmpty(DateFormatUtils.ISO_DATE_FORMAT.format(licenseInfo.getDateCreated()));
        sb.append(dateCreated);
        String hwId = StringUtils.trimToEmpty(licenseInfo.getHwId());
        sb.append(hwId);
        String validForProduct = StringUtils.trimToEmpty(licenseInfo.getValidForProduct());
        sb.append(validForProduct);
        String validForVersion = StringUtils.trimToEmpty(licenseInfo.getValidForVersion());
        sb.append(validForVersion);
        String dateValidUntil = StringUtils
                .trimToEmpty(DateFormatUtils.ISO_DATE_FORMAT.format(licenseInfo.getValidUntil()));
        sb.append(dateValidUntil);
        return DigestUtils.calculateSha1Hash(sb.toString());
    }

    /**
     * Sign the given license
     *
     * @param licenseInfo
     * @param privKeyUrl
     * @param password
     * @param keyId
     * @return
     * @throws Exception
     */
    public static String signLicense(LicenseInfo licenseInfo, URL privKeyUrl, URL pkUrl, String password, String keyId)
            throws Exception {
        String msg = encodeLicense(licenseInfo);
        String licenseDataHash = createLicenseHash(licenseInfo);
        String signature = createSignature(privKeyUrl, pkUrl, licenseDataHash, password, keyId);
        StringBuilder sb = new StringBuilder();
        sb.append(RESPONSE_MSG_HEADER);
        sb.append(SystemUtils.LINE_SEPARATOR);
        sb.append(msg);
        sb.append(signature);
        sb.append(RESPONSE_MSG_FOOTER);
        return sb.toString();
    }

    public static String createSignature(URL privateKey, URL publicKey, String message, String password, String keyId2)
            throws Exception {
        PGPSignatureHelper helper = new PGPSignatureHelper();
        return helper.sign(message, privateKey, password.toCharArray());
    }

    public static IStatus checkSignatureAndVerifyLicense(LicenseInfo info) {
        SignatureCheck check = null;
        try {
            check = new SignatureCheck(getPublicKeyUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        IStatus status = check.check(info);
        if (status.isOK()) {
            Policy.logInfo(String.format("Licenseinformation is trusted. Valid until %s",
                    new SimpleDateFormat("dd/MM/yyyy").format(info.getValidUntil())));
        }
        if (!status.isOK()) {
            return status;
        }
        return new LicenseVerifier().verifyLicense(info);
    }

    public static URL getPublicKeyUrl() throws MalformedURLException {
        return new URL(PUBLICKEY_URL);
    }
}
