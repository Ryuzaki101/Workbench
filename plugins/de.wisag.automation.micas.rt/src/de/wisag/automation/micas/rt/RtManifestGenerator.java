package de.wisag.automation.micas.rt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.hashing.DigestUtils;
import de.wisag.automation.micas.common.resource.ResourceUtils;

public class RtManifestGenerator {

    public String generate(RtModule rtModule, String h86Name, String h86Checksum) {
        Manifest manifest = new Manifest();
        Attributes mattrs = manifest.getMainAttributes();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_MODULE_FIELD_BUS, String.format("%d", rtModule.getFieldBus()));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_MODULE_STAMP,
                String.format("%d", rtModule.getSourceModificationStamp()));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_MODULE_NAME, String.format("%s", rtModule.getSourceName()));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_MODULE_TYPE,
                String.format("%s", rtModule.getHwType().getName()));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_MODULE_SOURCE_CHECKSUM,
                String.format("%s", rtModule.getSourceChecksum()));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_MODULE_CHECKSUM,
                String.format("0x%08x", rtModule.getModuleChecksum()));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_H86_CHECKSUM, String.format("%s", h86Checksum));
        mattrs.putValue(RtPlatformConstants.MF_ATTRIBUT_H86_NAME, String.format("%s", h86Name));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            manifest.write(bos);
        } catch (IOException e) {
            // ignore
        }
        return new String(bos.toByteArray());
    }

    public static IStatus generateManifest(IProgressMonitor monitor, IFile file, RtModule rtModule, String suffix)
            throws CoreException {
        IFile h86File = ResourceUtils.deriveFilename(file, HardcodedValues.H86_SUFFIX);
        String h86Checksum = DigestUtils.computeMd5AndCloseStream(h86File.getContents());

        return ResourceUtils.updateAndTagGeneratedFile(monitor, file,
                new RtManifestGenerator().generate(rtModule, h86File.getName(), h86Checksum), suffix, true);

    }
}
