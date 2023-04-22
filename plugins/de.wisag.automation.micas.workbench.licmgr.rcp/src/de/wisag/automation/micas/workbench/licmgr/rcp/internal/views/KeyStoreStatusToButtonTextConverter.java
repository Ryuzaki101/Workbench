package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.eclipse.core.databinding.conversion.IConverter;

final class KeyStoreStatusToButtonTextConverter implements IConverter {
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
        KeyStoreStatus status = (KeyStoreStatus) fromObject;
        return KeyStoreStatus.AUTHENTICATED.equals(status) ? "Sperre Schlüssel" : "Entsperre Schlüssel";
    }
}