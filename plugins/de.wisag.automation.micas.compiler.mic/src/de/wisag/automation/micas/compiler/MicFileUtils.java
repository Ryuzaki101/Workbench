package de.wisag.automation.micas.compiler;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;

public class MicFileUtils {

    public static String getLegacyOutputBaseName(IFile workspaceMicFile) {
        String name = FilenameUtils.getBaseName(workspaceMicFile.getName());

        if (name.endsWith("-rt")) {
            name = StringUtils.replace(name, "-rt", "$MIC");
        } else {
            name = name + "_$MIC_EXE_";
        }

        return name;
    }
}
