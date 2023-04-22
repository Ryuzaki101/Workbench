package de.wisag.automation.micas.olt.ui.internal.views;

import static java.util.Objects.requireNonNull;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;

import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.device.DeviceInfo;

public class DeviceTreeNode extends TreeNode implements IAdaptable {

    private final IMicasDeviceManager deviceManager;
    private final TreeViewer viewer;

    public DeviceTreeNode(TreeViewer viewer, IMicasDeviceManager deviceManager, DeviceInfo deviceInfo) {
        super(requireNonNull(deviceInfo, "'deviceInfo'"));
        this.deviceManager = requireNonNull(deviceManager);
        this.viewer = requireNonNull(viewer);
    }

    IMicasDeviceManager getDeviceManager() {
        return this.deviceManager;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (IMicasDeviceManager.class.equals(adapter)) {
            return adapter.cast(getDeviceManager());
        }
        if (TreeViewer.class.equals(adapter)) {
            return adapter.cast(viewer);
        }
        return null;
    }

    public DeviceInfo getDeviceInfo() {
        return (DeviceInfo) getValue();
    }

}
