package de.wisag.automation.micas.common.resource;

import static java.util.Objects.requireNonNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.internal.Activator;
import de.wisag.automation.micas.common.internal.Policy;

public class ResourceUtils {

    private static final QualifiedName KEY = new QualifiedName("de.wisag.automation.micas", "generated");

    public static IStatus createOrUpdateFile(IProgressMonitor monitor, IFile targetFile, String content,
            String fileEncoding) {
        ByteArrayInputStream source = null;
        try {
            source = new ByteArrayInputStream(content.getBytes(fileEncoding));
        } catch (UnsupportedEncodingException e1) {
            throw new RuntimeException(e1);
        }
        if (!targetFile.exists()) {
            try {
                targetFile.create(source, true, monitor);
            } catch (CoreException e) {
                return e.getStatus();
                // return new CompileResult(e.getStatus(), null, h86, rtModule);
            } finally {
                // monitor.done();
            }
        } else {
            try {
                targetFile.setContents(source, IResource.FORCE | IResource.KEEP_HISTORY, monitor);
            } catch (CoreException e) {
                return e.getStatus();
                // return new CompileResult(e.getStatus(), null, h86, rtModule);
            } finally {
                // monitor.done();
            }
        }
        return Status.OK_STATUS;
    }

    public static void updateContent(String content, IFile micFile, IProgressMonitor monitor) throws CoreException {

        try (InputStream micData = new ByteArrayInputStream(
                content.getBytes(HardcodedValues.MIC_DEFAULT_ENCODING_CP850))) {
            if (micFile.exists()) {
                micFile.setContents(micData, IResource.FORCE, monitor);
            } else {
                if (micFile.isReadOnly()) {
                    ResourceUtils.setReadOnly(micFile, false);
                }
                micFile.create(micData, true, monitor);
                micFile.setCharset(HardcodedValues.MIC_DEFAULT_ENCODING_CP850, monitor);
            }
        } catch (UnsupportedEncodingException e1) {
            Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format("Encoding Error"), e1);
            Policy.log(status);
            /**/
        } catch (IOException e) {
            IStatus error = Policy.errorStatus(e);
            Policy.log(error);
        }
    }

    /**
     * Marks a file as derived from another
     *
     * @param generatedFile
     *            - file which should be tagged
     * @param generationSource
     *            - file which is the source
     */
    public static void tagAsGeneratedFrom(IFile generatedFile, IFile generationSource) {
        // first check
        String sourceKey = generationSource.getProjectRelativePath().toPortableString();
        if (sourceKey.equals(getGeneratedFrom(generatedFile))) {
            return;
        }

        try {
            generatedFile.setPersistentProperty(KEY, sourceKey);
        } catch (CoreException e) {
            // ignore
        }
    }

    public static String getGeneratedFrom(IFile file) {
        requireNonNull(file, "'file'");
        String tag = null;
        try {
            tag = file.getPersistentProperty(KEY);
        } catch (CoreException e) {
            // ignore
        }
        return tag;
    }

    public static IFile toIFile(Resource resource) {
        requireNonNull(resource, "'resource'");
        URI uri = resource.getResourceSet().getURIConverter().normalize(resource.getURI());
        return toIFile(uri);
    }

    public static IFile toIFile(URI uri) {
        requireNonNull(uri, "'uri'");
        IFile iFile = null;
        String scheme = uri.scheme();
        if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) {
            StringBuffer platformResourcePath = new StringBuffer();
            for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
                platformResourcePath.append('/');
                platformResourcePath.append(uri.segment(j));
            }
            iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
        }
        return iFile;
    }

    public static void setReadOnly(IResource resource, boolean readonly) {
        ResourceAttributes attributes = resource.getResourceAttributes();
        if (attributes == null) {
            return;
        }
        attributes.setReadOnly(readonly);
        try {
            resource.setResourceAttributes(attributes);
        } catch (CoreException e) {
            // failure is not an option
        }
    }

    public static final QualifiedName CURRENT_RT_MODEL = new QualifiedName("de.wisag.automation.micas", "rtModel");

    public static <T> T getSessionObject(QualifiedName key, IResource resource, Class<T> type) {
        Object sessionProperty;
        try {
            sessionProperty = resource.getSessionProperty(key);
        } catch (CoreException e) {
            e.printStackTrace();
            return null;
        }
        if (type.isInstance(sessionProperty)) {
            return type.cast(sessionProperty);
        }
        return null;
    }

    public static void setSessionObject(QualifiedName key, IResource resource, Object object) {
        try {
            resource.setSessionProperty(key, object);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    public static URI toEmfURI(IFile file) {
        return URI.createURI(file.getFullPath().toString());
    }

    public static List<IFile> getFilesToClean(IContainer parent) {
        final List<IFile> filestodelete = new ArrayList<>();
        try {
            parent.accept(new IResourceVisitor() {
                @Override
                public boolean visit(IResource resource) throws CoreException {
                    if (resource.getType() == IResource.FOLDER || resource.getType() == IResource.PROJECT) {
                        return true;
                    }
                    if (resource.getType() == IResource.FILE) {
                        IFile file = (IFile) resource;
                        if (getGeneratedFrom(file) != null) {
                            filestodelete.add(file);
                        }
                    }
                    return false;

                }
            });
        } catch (CoreException e) {
        }
        return filestodelete;
    }

    public static List<IFile> getGeneratedFilesFor(final IFile file) {
        final List<IFile> filestodelete = new ArrayList<>();
        try {
            file.getParent().accept(new IResourceVisitor() {

                @Override
                public boolean visit(IResource resource) throws CoreException {
                    if (resource.getType() == IResource.FOLDER || resource.getType() == IResource.PROJECT) {
                        return true;
                    }
                    if (resource.getType() == IResource.FILE) {
                        IFile currentFile = (IFile) resource;
                        if (file.getProjectRelativePath().toPortableString().equals(getGeneratedFrom(currentFile))) {
                            filestodelete.add(currentFile);
                        }
                    }
                    return false;

                }
            });
        } catch (CoreException e) {
        }
        return filestodelete;
    }

    public static void deleteAll(IProgressMonitor monitor, final Collection<IFile> files) throws CoreException {
        for (IFile file : files) {
            file.delete(true, monitor);
        }
    }

    public static IStatus updateAndTagGeneratedFile(IProgressMonitor monitor, IFile derivedFromFile, String content,
            String suffix, boolean readOnly) {
        IFile targetFile = deriveFilename(derivedFromFile, suffix);
        try {
            if (readOnly && targetFile.exists() && targetFile.isReadOnly()) {
                ResourceUtils.setReadOnly(targetFile, false);
            }
            updateContent(content, targetFile, monitor);
            tagAsGeneratedFrom(targetFile, derivedFromFile);
            if (readOnly) {

                ResourceUtils.setReadOnly(targetFile, true);
            }

        } catch (CoreException e) {
            ILog log = Activator.getDefault().getLog();
            Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("Update of file %s failed", targetFile.getFullPath()), e);
            log.log(status);
            return status;
        }
        return Status.OK_STATUS;
    }

    public static IFile deriveFilename(IFile derivedFromFile, String suffix) {
        return derivedFromFile.getParent()
                .getFile(new Path(FilenameUtils.getBaseName(derivedFromFile.getName()) + suffix));
    }

    public static void deleteDerivedFiles(IProgressMonitor monitor, IFile file) throws CoreException {
        deleteAll(monitor, getGeneratedFilesFor(file));
    }
}
