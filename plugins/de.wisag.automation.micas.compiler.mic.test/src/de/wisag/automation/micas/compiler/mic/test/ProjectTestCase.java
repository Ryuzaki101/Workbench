package de.wisag.automation.micas.compiler.mic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.junit.AfterClass;
import org.osgi.framework.Bundle;

import de.wisag.automation.micas.common.resource.FileUtils;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.MicFileUtils;
import de.wisag.automation.micas.compiler.mic.internal.bbc1988.BBCMicasCompiler;
import de.wisag.automation.micas.compiler.mic.internal.modern.MicasCompiler;

public abstract class ProjectTestCase {

    static int COUNTER = 0;

    public IProject getProject() throws Exception {
        String projectName = "micas.project-" + COUNTER++;
        return ProjectUtils.newProject(null, projectName);
    }

    protected void check(String hwName, int fieldBus) throws Exception {
        if (skipHardware(hwName)) {
            return;
        }
        String baseName = StringUtils.upperCase(hwName) + "_" + FilenameUtils.getBaseName(getTestPath());
        String fileName = baseName + ".mic";
        String symbolicName = "de.wisag.automation.micas.compiler.mic.test";
        Bundle bundle = Platform.getBundle(symbolicName);
        URL url = bundle.getEntry(getTestPath());
        assertNotNull("Testcase not found " + getTestPath(), url);

        InputStream is = url.openStream();
        assertNotNull(is);
        IFile micFile = ProjectUtils.generateTemplate(fieldBus, hwName, is, getEncoding(), fileName, getProject());
        assertTrue("mic file not exists", micFile.exists());
        ICompileResult result1 = new MicasCompiler().compile(new NullProgressMonitor(), micFile.getContents(),
                micFile.getCharset());
        if (result1.isOk()) {
            ResourceUtils.createOrUpdateFile(new NullProgressMonitor(), getProject().getFile(baseName + "_.log"),
                    result1.getReport(), "ISO-8859-1");
        }
        IStatus status2 = result1.getStatus();
        micFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        assertTrue(String.format("new compiler compilation failed for '%s'  ", getTestPath()) + status2.getMessage(),
                status2.isOK());
        IStatus status = new BBCMicasCompiler().doCompile(new NullProgressMonitor(), hwName, fieldBus, micFile);
        assertTrue("fmicon compiled ok", status.isOK());
        IFile historicH86 = getProject().getFile(MicFileUtils.getLegacyOutputBaseName(micFile) + ".h86");
        assertTrue(String.format("fmicon h86 file not exists %s at %s", historicH86.getFullPath().toOSString(),
                historicH86.getLocation().toOSString()), historicH86.exists());
        IFile modernH86 = getProject().getFile(baseName + "_.h86");
        modernH86.create(new ByteArrayInputStream(result1.getH86Data().getBytes()), true, new NullProgressMonitor());
        assertTrue("ng h86 file not exists", modernH86.exists());

        String modernChecksum = FileUtils.getMD5Checksum(modernH86);
        String historicChecksum = FileUtils.getMD5Checksum(historicH86);
        assertEquals(String.format("%s differ from %s", modernH86.getProjectRelativePath().toOSString(),
                historicH86.getProjectRelativePath().toOSString()), historicChecksum, modernChecksum);

    }

    protected abstract boolean skipHardware(String hwName);

    @AfterClass
    public static void tearDown() throws Exception {
        // project.delete(true, true, new NullProgressMonitor());
    }

    public abstract String getTestPath();

    public abstract String getEncoding();
}
