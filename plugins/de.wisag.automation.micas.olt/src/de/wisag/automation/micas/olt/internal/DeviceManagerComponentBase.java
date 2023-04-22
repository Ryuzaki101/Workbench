package de.wisag.automation.micas.olt.internal;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IAdapterManager;

import de.wisag.automation.micas.olt.base.connection.IConnectedDevice;

public class DeviceManagerComponentBase {

    private AtomicReference<IConnectedDevice> connectionDeviceRef = new AtomicReference<>();
    private AtomicReference<IAdapterManager> adapterManagerRef = new AtomicReference<>();

    public void bindConnectedDevice(IConnectedDevice controlProvider) {
        connectionDeviceRef.set(controlProvider);
    }

    public void unbindConnectedDevice(IConnectedDevice controlProvider) {
        connectionDeviceRef.compareAndSet(controlProvider, null);
    }

    protected IConnectedDevice getConnectedDevice() {
        return connectionDeviceRef.get();
    }

    public void bindAdapterManager(IAdapterManager adapterManager) {
        adapterManagerRef.set(adapterManager);
    }

    public void unbindAdapterManager(IAdapterManager adapterManager) {
        adapterManagerRef.compareAndSet(adapterManager, null);
    }

    public IAdapterManager getAdapterManager() {
        return adapterManagerRef.get() != null ? adapterManagerRef.get() : null;
    }

}
