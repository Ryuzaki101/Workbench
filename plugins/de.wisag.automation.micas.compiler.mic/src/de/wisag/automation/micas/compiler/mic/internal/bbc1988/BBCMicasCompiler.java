package de.wisag.automation.micas.compiler.mic.internal.bbc1988;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.ICompilerMessageListener;
import de.wisag.automation.micas.compiler.IMicasCompiler;
import de.wisag.automation.micas.compiler.MicFileUtils;
import de.wisag.automation.micas.compiler.ModuleInfo;
import de.wisag.automation.micas.compiler.mic.internal.AbstractMicasCompiler;
import de.wisag.automation.micas.compiler.mic.internal.Activator;
import de.wisag.automation.micas.compiler.mic.internal.CompileResult;
import de.wisag.automation.micas.mIC.Module;

/**
 * @author mkr
 */
public class BBCMicasCompiler extends AbstractMicasCompiler implements IMicasCompiler {
    @Override
    public ICompileResult compile(IProgressMonitor monitor, Module module, IFile micFile) {
        IStatus status = doCompile(monitor, module.getType(), module.getValue(), micFile);
        return new CompileResult(status, null, null, null, null);
    }

    @Override
    public ICompileResult compile(IProgressMonitor monitor, InputStream micinput, String encoding) {
        return new CompileResult(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Operation not supported"), null, null,
                null, null);
    }

    public IStatus doCompile(IProgressMonitor monitor, String moduleType, int fieldBusNumber, IFile workspaceMicFile) {
        if (!isSupportedPlattform()) {
            // silently ignore
            return Status.OK_STATUS;
        }
        monitor.beginTask(
                String.format("Compiling '%s' with mic.exe", workspaceMicFile.getFullPath().toPortableString()), 8);
        final String legacyBaseName = MicFileUtils.getLegacyOutputBaseName(workspaceMicFile);
        final StringBuilder sb = new StringBuilder();
        setCompilerMessageListener(new ICompilerMessageListener() {
            @Override
            public void onMessage(String message) {
                sb.append(message).append("\r\n");

            }
        });

        IStatus status = Status.OK_STATUS;
        String qualifier = HardcodedValues.DEFAULT_OUTPUT_PREFIX;
        String baseName = getNormalizedFilename(workspaceMicFile);
        monitor.setTaskName("Setup workdir");
        File workDir = setupWorkdir();
        ModuleInfo info = ModuleInfo.extractModuleInfo(workspaceMicFile);
        File outputDir = new File(workDir, qualifier + moduleType + "0" + info.fieldBusNumber);
        outputDir.mkdirs();
        File micasExe = null;
        try {
            micasExe = copyMicExeToWorkdir(workDir);
        } catch (CoreException e) {
            return e.getStatus();
        }
        File micFile = null;
        try {
            micFile = copyMicFileToWorkdir(baseName, workspaceMicFile, workDir);
        } catch (CoreException e1) {
            return e1.getStatus();
        }
        monitor.worked(2);
        monitor.setTaskName("Calling mic.exe");

        status = invokeMic(configureCommandline(workDir, micasExe, micFile, info.useVersionFlag()));
        monitor.worked(2);

        monitor.setTaskName("Copy files back from workdir");
        status = copyBackFromWorkdir(monitor, outputDir, legacyBaseName, workspaceMicFile);
        monitor.worked(2);
        try {
            workspaceMicFile.getParent().refreshLocal(IResource.DEPTH_ZERO, monitor);
        } catch (CoreException e1) {
            return e1.getStatus();
        }
        monitor.setTaskName("Delete workdir");
        try {
            FileUtils.forceDelete(workDir);
        } catch (IOException e) {
            return new Status(IStatus.WARNING, Activator.PLUGIN_ID,
                    String.format("Deletion of workdir '%s' failed", workDir), e);
        }
        monitor.worked(2);

        if (sb.length() > 0) {
            IFile logFile = workspaceMicFile.getParent().getFile(new Path(legacyBaseName).addFileExtension("log"));
            ResourceUtils.createOrUpdateFile(monitor, logFile, sb.toString(),
                    HardcodedValues.MIC_DEFAULT_ENCODING_CP850);
            ResourceUtils.tagAsGeneratedFrom(logFile, workspaceMicFile);
        }
        if (!status.isOK()) {
            logToConsole(status.getMessage());
            StringWriter sw = new StringWriter();
            status.getException().printStackTrace(new PrintWriter(sw));
            logToConsole(sw.toString());
            IOUtils.closeQuietly(sw);
        }
        return status;
    }

    private File copyMicExeToWorkdir(File workDir) throws CoreException {
        File micasExe = new File(workDir, "MIC.EXE");
        copyResource(workDir, "mic.bin", "MIC.EXE");
        copyResource(workDir, "FMICENG.TXB", "FMICENG.TXB");
        copyResource(workDir, "FMICGER.TXB", "FMICGER.TXB");
        Assert.isTrue(micasExe.exists());
        return micasExe;
    }

    private void copyResource(File workDir, String resourceName, String fileName) throws CoreException {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(new File(workDir, fileName));
            IOUtils.copy(getClass().getResourceAsStream(resourceName), output);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Copy of resource failed", e));
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

    private File copyMicFileToWorkdir(String baseName, IFile workspaceMicFile, File workDir) throws CoreException {
        File micFile = new File(workDir, baseName + ".MIC");
        FileOutputStream output = null;
        InputStream input = null;
        try {
            output = new FileOutputStream(micFile);
            input = workspaceMicFile.getContents();
            IOUtils.copy(input, output);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Copy of workspacefile failed", e));
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(input);
        }
        return micFile;
    }

    private String getNormalizedFilename(IFile workspaceMicFile) {
        String baseName = FilenameUtils.getBaseName(workspaceMicFile.getName());
        if (baseName.length() > 8) {
            baseName = "TOCOMP";
        }
        return baseName;
    }

    private File setupWorkdir() {
        String tempdir = System.getProperty("java.io.tmpdir");
        IPath workPath = new Path(tempdir).append(UUID.randomUUID().toString().replace("-", ""));
        File workDir = workPath.toFile();
        workDir.mkdir();
        return workDir;
    }

    private List<String> configureCommandline(File workDir, File micasExe, File micFile,
            boolean callMicWithVersionFlag) {
        // launch mic.exe using cmd.exe!
        List<String> args = null;
        // on linux use doemu
        if (Platform.getOS().equalsIgnoreCase("linux")) {
            args = Arrays.asList(new String[] { "/usr/bin/dosemu", "-quiet", "-dumb", micasExe.getAbsolutePath(),
                    micFile.getName(), "--", callMicWithVersionFlag ? "-V5" : "", "-lis", "-od" });

        } else {
            // on windows use magic to control the mic.exe
            args = Arrays.asList(new String[] { "cmd", "/c", "start", "/D", workDir.getAbsolutePath(), "/B",
                    "/SEPARATE", "/WAIT", micasExe.getName(), micFile.getName(), callMicWithVersionFlag ? "-V5" : "",
                    "-lis", "-od" });
        }
        return args;
    }

    private boolean isSupportedPlattform() {
        boolean supported = true;
        if (Platform.ARCH_X86_64.equals(Platform.getOSArch()) && Platform.OS_WIN32.equals(Platform.getOS())) {
            supported = false;
        }
        return supported;
    }

    private IStatus invokeMic(List<String> args) {
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.redirectErrorStream(true);
        int retVal = -1;
        Process process = null;
        try {
            process = pb.start();
        } catch (IOException e1) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    "Launch of mic.exe failed (cannot read from process output", e1);
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), HardcodedValues.MIC_DEFAULT_ENCODING_CP850));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line == null || line.trim().length() == 0) {
                    continue;
                }
                logToConsole(line);
            }
        } catch (IOException e) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    "Launch of mic.exe failed (cannot read from process output)", e);
        } finally {
            IOUtils.closeQuietly(br);
        }

        try {
            retVal = process.waitFor();
        } catch (InterruptedException e) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Launch of mic.exe failed (wait for process)", e);
        }

        if (retVal != 0) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Launch of mic.exe failed");
        }
        return Status.OK_STATUS;
    }

    private IStatus copyBackFromWorkdir(IProgressMonitor monitor, File outputDir, String workspaceFileBaseName,
            IFile workspaceMicFile) {
        Collection<?> generatedFiles = FileUtils.listFiles(outputDir, null, false);
        for (Iterator<?> it = generatedFiles.iterator(); it.hasNext();) {
            File fileFromWorkdir = (File) it.next();
            String ext = FilenameUtils.getExtension(fileFromWorkdir.getName());
            if (StringUtils.endsWith(fileFromWorkdir.getName(), HardcodedValues.MIC_SUFFIX)) {
                // do not copy micfiles back!
                continue;
            }
            IFile target = workspaceMicFile.getParent()
                    .getFile(new Path(workspaceFileBaseName + "." + StringUtils.lowerCase(ext)));

            FileInputStream source = null;
            try {
                source = new FileInputStream(fileFromWorkdir);
                if (!target.exists()) {
                    target.create(source, true, monitor);
                    try {
                        target.setCharset(HardcodedValues.MIC_DEFAULT_ENCODING_CP850, monitor);
                    } catch (CoreException e) {
                        // project is out of sync
                        target.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
                        // try again
                        target.setCharset(HardcodedValues.MIC_DEFAULT_ENCODING_CP850, monitor);
                    }
                } else {
                    target.setContents(source, IResource.FORCE | IResource.KEEP_HISTORY, monitor);
                }
            } catch (IOException e) {
                return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                        "Launch of mic.exe failed (cannot read from process output)", e);
            } catch (CoreException e) {
                return e.getStatus();
            } finally {
                IOUtils.closeQuietly(source);
            }
            // tag as an generated fole
            // TODO: Optimize
            ResourceUtils.tagAsGeneratedFrom(target, workspaceMicFile);

        }
        return Status.OK_STATUS;
    }
}
