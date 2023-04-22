package de.wisag.automation.micas.compiler.mic.test;

import static de.wisag.automation.micas.common.resource.FileUtils.contentToString;
import static de.wisag.automation.micas.common.resource.FileUtils.getMD5Checksum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.MicFileUtils;
import de.wisag.automation.micas.compiler.mic.internal.bbc1988.BBCMicasCompiler;
import de.wisag.automation.micas.compiler.mic.internal.modern.MicasCompiler;

public class ProjectUtils {

    public static IProject newProject(IProgressMonitor monitor, String name) throws CoreException {
        IProgressMonitor pm = monitor != null ? monitor : new NullProgressMonitor();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        if (project.exists()) {
            return project;
        }
        project.create(pm);
        project.open(pm);
        return project;
    }

    public static IFile generateTemplate(int fieldBus, String type, InputStream is, String encoding, String fileName,
            IProject project) throws IOException, CoreException {
        LineIterator lines = IOUtils.lineIterator(is, encoding);
        IFile micFile = project.getFile(fileName);
        StringBuilder sb = new StringBuilder();
        for (Iterator<?> it = lines; it.hasNext();) {
            String s = (String) it.next();
            s = StringUtils.replace(StringUtils.replace(s, "@TYPE@", type), "@FILEDBUS@", String.valueOf(fieldBus));
            sb.append(s);
            sb.append("\r\n");
        }
        if (micFile.exists()) {
            micFile.setContents(new ByteArrayInputStream(sb.toString().getBytes()), true, false, null);
        } else {
            micFile.create(new ByteArrayInputStream(sb.toString().getBytes()), true, null);
        }
        // micFile.setCharset("CP850", new NullProgressMonitor());
        return micFile;
    }

    public static void checkAndGenerate(IProject project, String hwName, String encoding, String mName, String src,
            int fieldBus) throws Exception {
        String baseName = StringUtils.upperCase(hwName) + "_" + mName;
        String fileName = baseName + ".mic";
        InputStream is = new ByteArrayInputStream(src.getBytes());

        IFile micFile = ProjectUtils.generateTemplate(fieldBus, hwName, is, encoding, fileName, project);
        assertTrue("mic file not exists : " + micFile.getProjectRelativePath().toPortableString(), micFile.exists());

        ICompileResult result1 = new MicasCompiler().compile(new NullProgressMonitor(), micFile.getContents(),
                micFile.getCharset());
        ResourceUtils.createOrUpdateFile(new NullProgressMonitor(), project.getFile(baseName + "_.log"),
                result1.getReport(), "ISO-8859-1");

        new BBCMicasCompiler().doCompile(new NullProgressMonitor(), hwName, fieldBus, micFile);

        IFile historicH86 = project.getFile(MicFileUtils.getLegacyOutputBaseName(micFile) + ".h86");
        IPath historicPath = micFile.getProjectRelativePath();
        assertTrue("fmicon h86 file not exists " + historicH86.getLocation().toPortableString(), historicH86.exists());

        IFile modernH86 = project.getFile(baseName + "_.h86");
        modernH86.create(new ByteArrayInputStream(result1.getH86Data().getBytes()), true, new NullProgressMonitor());
        IPath modernPath = modernH86.getProjectRelativePath();
        assertTrue("ng h86 file not exists " + modernPath.toPortableString(), modernH86.exists());
        String modernChecksum = getMD5Checksum(modernH86);
        String historicChecksum = getMD5Checksum(historicH86);
        assertEquals(String.format("%s differ from %s", modernPath.toOSString(), historicPath.toOSString()),
                historicChecksum, modernChecksum);
    }

    public static String readFullyAndConvertToUnix(IFile file) throws Exception {
        return StringUtils.replaceChars(contentToString(file), "\r\n", "\n");
    }

}
