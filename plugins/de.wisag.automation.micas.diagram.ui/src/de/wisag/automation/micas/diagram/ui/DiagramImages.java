package de.wisag.automation.micas.diagram.ui;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import de.wisag.automation.micas.common.osgi.BundleUtils;

public class DiagramImages {
    private static ImageRegistry imageRegistry;

    private static void initializeImageRegistry() {
        imageRegistry = new ImageRegistry();
        declareImages();
    }

    private static void declareImages() {
        declareImage(ISharedImages.VARIABLE, "icons/obj16/variable_obj.gif"); //$NON-NLS-1$
        declareImage(ISharedImages.CONSTANT_OVR, "icons/obj16/variable_obj.gif"); //$NON-NLS-1$
        declareImage(ISharedImages.READ_OVR, "icons/ovr16/read.gif"); //$NON-NLS-1$
        declareImage(ISharedImages.READWRITE_OVR, "icons/ovr16/readwrite.gif"); //$NON-NLS-1$
    }

    public static void dispose() {
        if (imageRegistry != null) {
            imageRegistry.dispose();
            imageRegistry = null;
        }
    }

    public static ImageRegistry getImageRegistry() {
        if (imageRegistry == null) {
            initializeImageRegistry();
        }
        return imageRegistry;
    }

    public static Image getImage(String key) {
        return getImageRegistry().get(key);
    }

    private final static void declareImage(String key, String path) {
        URL url = BundleUtils.find(Activator.PLUGIN_ID, path);
        ImageDescriptor desc = ImageDescriptor.createFromURL(url);
        declareImage(key, desc);
    }

    public static void declareImage(String symbolicName, ImageDescriptor descriptor) {
        getImageRegistry().put(symbolicName, descriptor);
    }
}
