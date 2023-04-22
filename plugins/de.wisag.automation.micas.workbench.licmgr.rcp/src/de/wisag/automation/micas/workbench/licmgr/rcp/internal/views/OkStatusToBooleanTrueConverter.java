package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.runtime.IStatus;

final class OkStatusToBooleanTrueConverter implements IConverter {
    @Override
    public Object getToType() {

        return Boolean.TRUE;
    }

    @Override
    public Object getFromType() {

        return IStatus.class;
    }

    @Override
    public Object convert(Object fromObject) {
        IStatus status = (IStatus) fromObject;
        return Boolean.valueOf(status.isOK());
    }
}