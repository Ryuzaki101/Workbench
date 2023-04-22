package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

final class KeyStoreStatusToColorConverter implements IConverter {
    @Override
    public Object getFromType() {
        return KeyStoreStatus.class;
    }

    @Override
    public Object getToType() {
        return Color.class;
    }

    @Override
    public Object convert(Object fromObject) {
        KeyStoreStatus status = (KeyStoreStatus) fromObject;
        Display display = Display.getDefault();
        return KeyStoreStatus.AUTHENTICATED.equals(status) ? display.getSystemColor(SWT.COLOR_GREEN)
                : display.getSystemColor(SWT.COLOR_RED);
    }
}