package de.wisag.automation.micas.common.osgi;

public interface IGenericServiceListener<S> {
    public void bindService(S service);

    public void unbindService(S service);
}