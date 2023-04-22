package de.wisag.automation.micas.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import de.wisag.automation.micas.common.HardcodedValues;

/**
 * @author mkr
 */
public class ModuleInfo {
    public String qualifier = "29";
    public String type = null;
    public String fieldBusNumber = null;
    public static Pattern MODUL_PATTERN = Pattern.compile("^\\s*MODUL\\s*\\(\\s*(\\S+)\\s*,\\s*(\\d)+\\s*\\).*$");

    public boolean useVersionFlag() {
        return HardcodedValues.MIC_EXE_WITH_VERSION_FLAG_AR20.equalsIgnoreCase(type)
                || HardcodedValues.MIC_EXE_WITH_VERSION_FLAG_SP20.equalsIgnoreCase(type);
    }

    public static ModuleInfo extractModuleInfo(IFile workspaceMicFile) {
        ModuleInfo info = new ModuleInfo();
        BufferedReader br2 = null;
        InputStream is = null;
        try {
            is = workspaceMicFile.getContents();
            br2 = new BufferedReader(new InputStreamReader(is, HardcodedValues.MIC_DEFAULT_ENCODING_CP850));
            String line2;
            while ((line2 = br2.readLine()) != null) {
                line2 = StringUtils.trimToEmpty(line2);
                Matcher m = null;
                if ((m = MODUL_PATTERN.matcher(line2)).matches()) {
                    info.type = m.group(1);
                    info.fieldBusNumber = m.group(2);
                    break;
                }
            }
        } catch (CoreException e) {
            // Policy.handleException(e);
        } catch (IOException e) {

        } finally {
            IOUtils.closeQuietly(br2);
            IOUtils.closeQuietly(is);
        }
        return info;
    }
}