package de.wisag.automation.micas.olt.internal;

import java.util.concurrent.atomic.AtomicReference;

import org.osgi.service.component.ComponentContext;

import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.IMonitorMessageBroadcaster;

public abstract class SymbolMonitorManagerComponentBase {
    private AtomicReference<IMicasDeviceManager> deviceManagerRef = new AtomicReference<>(null);

    private AtomicReference<IMonitorMessageBroadcaster> monitorMessageBroadcasterRef = new AtomicReference<>(null);

    abstract void activate(ComponentContext context) throws Exception;

    abstract void deactivate(ComponentContext context) throws Exception;

    public void bindMonitorMessageBroadcaster(IMonitorMessageBroadcaster broadcaster) {
        this.monitorMessageBroadcasterRef.compareAndSet(null, broadcaster);
    }

    public void unbindMonitorMessageBroadcaster(IMonitorMessageBroadcaster broadcaster) {
        this.monitorMessageBroadcasterRef.compareAndSet(broadcaster, null);
    }

    public IMonitorMessageBroadcaster getMonitorMessageBroadcaster() {
        return monitorMessageBroadcasterRef.get();
    }

    public void bindDeviceManager(IMicasDeviceManager deviceManager) {
        this.deviceManagerRef.compareAndSet(null, deviceManager);
    }

    public void unbindDeviceManager(IMicasDeviceManager deviceManager) {
        this.deviceManagerRef.compareAndSet(deviceManager, null);
    }

    public IMicasDeviceManager getMicasDeviceManager() {
        return deviceManagerRef.get();
    }

}
