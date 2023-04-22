package de.wisag.automation.micas.common.resource;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.internal.Activator;

public class FileUtils {

    public static byte[] createChecksum(IFile filename) throws Exception {
        requireNonNull(filename, "'filename'");
        MessageDigest complete;
        try (InputStream fis = filename.getContents()) {

            byte[] buffer = new byte[1024];
            complete = MessageDigest.getInstance("MD5");
            int numRead;
            do {
                numRead = fis.read(buffer);
                if (numRead > 0) {
                    complete.update(buffer, 0, numRead);
                }
            } while (numRead != -1);
        }
        return complete.digest();
    }

    // see this How-to for a faster way to convert
    // a byte array to a HEX string
    public static String getMD5Checksum(IFile filename) throws Exception {
        requireNonNull(filename, "'filename'");
        byte[] b = createChecksum(filename);
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    public static String contentToString(IFile file) throws CoreException {
        requireNonNull(file, "'file'");
        String charset = file.getCharset();
        String data = null;
        try (InputStream contents = file.getContents()) {
            data = IOUtils.toString(contents, charset);

        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
        }
        return data;
    }

}
