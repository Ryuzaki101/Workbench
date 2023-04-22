package de.wisag.automation.micas.h86.ui.handlers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.h86.ui.internal.Policy;
import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.rt.Decompiler;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class H86DecompilerHandler extends AbstractHandler {
    private static final String FILE_SUFFIX = "mic";
    private static final String FILENAME_SUFFIX = "-gen";
    private static final String DEFAULT_ENCODING = "CP850";

    /**
     * The constructor.
     */
    public H86DecompilerHandler() {
    }

    /**
     * the command has been executed, so extract extract the needed information
     * from the application context.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
        final IFile file = (IFile) selection.getFirstElement();
        WorkspaceJob job = new WorkspaceJob("Decompiling mic " + file.getName()) {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                return decompileMic(monitor, file);
            }
        };
        job.schedule();
        return null;
    }

    private IStatus decompileMic(IProgressMonitor monitor, IFile file) {
        String micText = null;
        InputStream is = null;
        try {
            is = file.getContents();
            micText = generateMic(file, is);
        } catch (CoreException e1) {
            return Policy.errorStatus(e1);
        } catch (IOException e) {
            return Policy.errorStatus(e);
        } finally {
            IOUtils.closeQuietly(is);
        }
        String basename = FilenameUtils.getBaseName(file.getName());
        IContainer parent = file.getParent();
        IFile generatedFile = parent.getFile(new Path(basename + FILENAME_SUFFIX).addFileExtension(FILE_SUFFIX));
        try {
            if (!generatedFile.exists()) {
                generatedFile.create(new ByteArrayInputStream(micText.getBytes(DEFAULT_ENCODING)), true, monitor);
                generatedFile.setCharset(DEFAULT_ENCODING, new NullProgressMonitor());
            } else {
                generatedFile.setContents(new ByteArrayInputStream(micText.getBytes(DEFAULT_ENCODING)), true, true,
                        monitor);
            }
        } catch (UnsupportedEncodingException e) {
            return Policy.errorStatus(e);
        } catch (CoreException e) {
            return Policy.errorStatus(e);
        }
        return Status.OK_STATUS;
    }

    private String generateMic(IFile file, InputStream contents) throws IOException {
        Decompiler decompiler = new Decompiler();
        Pattern pattern = Pattern.compile("^29([A-Z][A-Z]\\d\\d)(\\d\\d)$", Pattern.CASE_INSENSITIVE);
        String baseName = FilenameUtils.getBaseName(file.getName());
        String type = null;
        int fieldBusNumber = 2;
        HardwareTypeDefinition hardwareTypeDefinition = null;
        Matcher m = null;
        if ((m = pattern.matcher(baseName)).matches()) {
            type = m.group(1);
            fieldBusNumber = Integer.parseInt(m.group(2));
        }
        if (type != null) {
            hardwareTypeDefinition = IHwModulesProvider.INSTANCE.findHardwareTypeDefinition(type);
            EList<HardwareAlias> aliases = hardwareTypeDefinition.getAliases();
            for (HardwareAlias hardwareAlias : aliases) {
                if (StringUtils.equalsIgnoreCase(hardwareAlias.getName(), type)) {
                    decompiler.setHardwareAlias(hardwareAlias);
                    break;
                }
            }
        }
        decompiler.setFieldBusNumber(fieldBusNumber);
        return decompiler.decompile(contents);
    }
}
