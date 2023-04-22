package de.wisag.automation.micas.olt.ui.internal.views;

import org.eclipse.core.runtime.IAdapterFactory;

import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;

public class SymbolMonitorViewAdapterFactory implements IAdapterFactory {
    @Override
    public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
        if (adaptableObject instanceof SymbolMonitorView) {
            SymbolMonitorView v = (SymbolMonitorView) adaptableObject;
            return v.getAdapter(adapterType);
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList() {
        return new Class<?>[] { ISymbolMonitorStatusControl.class, IMicasDeviceManager.class, SymbolMonitorView.class };
    }

}
