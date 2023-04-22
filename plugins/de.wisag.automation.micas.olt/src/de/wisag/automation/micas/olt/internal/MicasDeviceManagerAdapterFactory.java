package de.wisag.automation.micas.olt.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;

import de.wisag.automation.micas.olt.IMicasDeviceManager;

final class MicasDeviceManagerAdapterFactory implements IAdapterFactory {
    private final IMicasDeviceManager deviceManager;

    public MicasDeviceManagerAdapterFactory(IMicasDeviceManager deviceManager) {
        super();
        this.deviceManager = deviceManager;
    }

    public IMicasDeviceManager getDeviceManager() {
        return deviceManager;
    }

    @Override
    public Class<?>[] getAdapterList() {
        return new Class<?>[] { IMicasDeviceManager.class };
    }

    @Override
    public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
        if (adaptableObject instanceof IFile && IMicasDeviceManager.class.equals(adapterType)) {
            return adapterType.cast(getDeviceManager());
        }
        return null;
    }
}