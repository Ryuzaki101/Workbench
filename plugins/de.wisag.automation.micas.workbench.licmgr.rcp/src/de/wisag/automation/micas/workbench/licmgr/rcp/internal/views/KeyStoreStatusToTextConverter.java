package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.eclipse.core.databinding.conversion.IConverter;

final class KeyStoreStatusToTextConverter implements IConverter {
    @Override
    public Object getFromType() {
        return KeyStoreStatus.class;
    }

    @Override
    public Object getToType() {
        return String.class;
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return null;
        }
        return ((KeyStoreStatus) fromObject).getStatus();
    }
}