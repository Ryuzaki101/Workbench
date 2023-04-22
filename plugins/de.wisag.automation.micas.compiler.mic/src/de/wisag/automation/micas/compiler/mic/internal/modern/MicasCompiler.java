package de.wisag.automation.micas.compiler.mic.internal.modern;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import de.wisag.automation.micas.MICStandaloneSetup;
import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.hashing.DigestUtils;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.IMicasCompiler;
import de.wisag.automation.micas.compiler.IParseResult;
import de.wisag.automation.micas.compiler.MicasModuleToRtModelTransformer;
import de.wisag.automation.micas.compiler.mic.internal.AbstractMicasCompiler;
import de.wisag.automation.micas.compiler.mic.internal.Activator;
import de.wisag.automation.micas.compiler.mic.internal.CompileResult;
import de.wisag.automation.micas.compiler.mic.internal.ParseResult;
import de.wisag.automation.micas.compiler.mic.internal.Policy;
import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.MicasH86Marshaller;
import de.wisag.automation.micas.mIC.Module;
import de.wisag.automation.micas.rt.MicReporter;
import de.wisag.automation.micas.rt.MicasH86ContentCreator;
import de.wisag.automation.micas.rt.MicasModuleConfigurator;
import de.wisag.automation.micas.rt.RtManifestGenerator;
import de.wisag.automation.micas.rt.RtModule;

/**
 * Purpose: <br/>
 * Compile a mic file to h86
 *
 * @author mkr
 */
public class MicasCompiler extends AbstractMicasCompiler implements IMicasCompiler {

    @Override
    public ICompileResult compile(IProgressMonitor monitor, InputStream is, String encoding) {
        monitor.beginTask("Compiling mic file", IProgressMonitor.UNKNOWN);
        IParseResult parseResult = parse(is, encoding);
        if (!parseResult.getStatus().isOK()) {
            return new CompileResult(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    "Syntax error: " + parseResult.getStatus().getMessage()), parseResult, null, null, null);
        }
        if (parseResult.getStatus().isMultiStatus() && !parseResult.getStatus().getChildren()[0].isOK()) {
            return new CompileResult(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Syntax error"), parseResult, null,
                    null, null);
        }

        RtModule rtModule = new MicasModuleToRtModelTransformer().transform(parseResult.getModule());
        CompileResult compileResult = link(monitor, parseResult, rtModule);
        monitor.done();
        IOUtils.closeQuietly(is);
        return compileResult;
    }

    private CompileResult link(IProgressMonitor monitor, IParseResult parseResult, RtModule rtModule) {
        MicasModuleConfigurator configurator = new MicasModuleConfigurator();
        configurator.configure(monitor, rtModule);
        H86Content content = new MicasH86ContentCreator().createH86Content(rtModule);
        String h86 = new MicasH86Marshaller().marshall(content);
        String report = new MicReporter().generateReport(rtModule);
        return new CompileResult(Status.OK_STATUS, parseResult, h86, rtModule, report);
    }

    private IParseResult parse(InputStream is, String encoding) {
        Injector injector = new MICStandaloneSetup().createInjectorAndDoEMFRegistration();
        URI uri = URI.createFileURI("no.mic");// it can be nonexistent
        XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, encoding);
        Resource resource = resourceSet.createResource(uri);
        try {
            resource.load(is, resourceSet.getLoadOptions());
        } catch (IOException e) {
            return new ParseResult(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e), null);
        }
        EList<Diagnostic> errors = resource.getErrors();
        if (!errors.isEmpty()) {
            List<IStatus> stati = new ArrayList<>();
            for (Iterator<?> iterator = errors.iterator(); iterator.hasNext();) {
                Diagnostic diagnostic = (Diagnostic) iterator.next();
                IStatus status = new Status(IStatus.ERROR, "micas.compiler",
                        String.format("Syntax error line:%d : %s", diagnostic.getLine(), diagnostic.getMessage()));
                stati.add(status);
            }
            return new ParseResult(new MultiStatus(Activator.PLUGIN_ID, -1, stati.toArray(new IStatus[stati.size()]),
                    "Compilation failed", null), null);
        }
        // MultiStatus ms = new MultiStatus(pluginId, code, newChildren,
        // message, exception)
        return new ParseResult(Status.OK_STATUS, (Module) resource.getContents().get(0));
    }

    @Override
    public ICompileResult compile(IProgressMonitor monitor, Module module, IFile micFile) {
        if (module == null) {
            XtextResourceSet resourceSet = new XtextResourceSet();
            resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
            try {
                resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, micFile.getCharset());
            } catch (CoreException e) {

            }
            Resource resource = resourceSet.createResource(ResourceUtils.toEmfURI(micFile));
            try {
                resource.load(resourceSet.getLoadOptions());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            module = (Module) resource.getContents().get(0);
        }

        if (module.eResource() != null && module.eResource().getErrors() != null
                && !module.eResource().getErrors().isEmpty()) {
            Resource eResource = module.eResource();
            MultiStatus multiStatus = createMultiStatus(eResource.getErrors(), eResource.getURI().toString());
            CompileResult compileResult = new CompileResult(multiStatus, null, null, null, null);
            return compileResult;
        }
        monitor.beginTask("Compiling mic file", 8);
        // build rtModule
        monitor.setTaskName("Creating Runtime module");
        RtModule rtModule = new MicasModuleToRtModelTransformer().transform(module);
        rtModule.setSourceName(micFile.getName());
        rtModule.setSourceModificationStamp(micFile.getModificationStamp());
        try {
            rtModule.setSourceChecksum(DigestUtils.computeMd5AndCloseStream(micFile.getContents()));
        } catch (CoreException e1) {
            Policy.logError(e1);
        }
        monitor.worked(2);
        // link it
        monitor.setTaskName("Linking module");
        CompileResult compileResult = link(monitor, null, rtModule);
        monitor.worked(2);
        // save the h86 file
        monitor.setTaskName("Write h86 file");
        IFile h86File = ResourceUtils.deriveFilename(micFile, HardcodedValues.H86_SUFFIX);
        ResourceUtils.createOrUpdateFile(monitor, h86File, compileResult.getH86Data(),
                HardcodedValues.MIC_DEFAULT_ENCODING_CP850);
        ResourceUtils.tagAsGeneratedFrom(h86File, micFile);
        monitor.worked(2);
        // save the report file file
        monitor.setTaskName("Write report file");
        IFile reportFile = ResourceUtils.deriveFilename(micFile, HardcodedValues.REP_SUFFIX);
        ResourceUtils.createOrUpdateFile(monitor, reportFile, compileResult.getReport(),
                HardcodedValues.MIC_DEFAULT_ENCODING_CP850);
        ResourceUtils.tagAsGeneratedFrom(reportFile, micFile);
        monitor.worked(2);
        monitor.setTaskName("Write manifest");
        try {
            RtManifestGenerator.generateManifest(monitor, micFile, rtModule, HardcodedValues.MANIFEST_SUFFIX);
        } catch (CoreException e) {
            Policy.logError(e);
        }
        return compileResult;
    }

    private MultiStatus createMultiStatus(EList<Diagnostic> errors, String resourceName) {
        MultiStatus multiStatus = null;
        multiStatus = new MultiStatus(Activator.PLUGIN_ID, -1,
                String.format("Compilation of '%s' failed ", resourceName), null);
        for (Iterator<?> iterator = errors.iterator(); iterator.hasNext();) {
            Diagnostic diagnostic = (Diagnostic) iterator.next();
            IStatus status = new Status(IStatus.ERROR, "micas.compiler",
                    String.format("Syntax error line:%d, column:%d %s", diagnostic.getLine(), diagnostic.getColumn(),
                            diagnostic.getMessage()));
            multiStatus.add(status);
        }
        return multiStatus;
    }
}