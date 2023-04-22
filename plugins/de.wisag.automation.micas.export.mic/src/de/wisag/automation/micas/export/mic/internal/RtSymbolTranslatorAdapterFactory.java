package de.wisag.automation.micas.export.mic.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;

import de.wisag.automation.micas.export.mic.IRtSymbolTranslator;

public class RtSymbolTranslatorAdapterFactory implements IAdapterFactory {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof IFile && IRtSymbolTranslator.class.equals(adapterType)) {
            return new RtSymbolTranslatorImpl();
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Class[] getAdapterList() {
        return new Class[] { IRtSymbolTranslator.class };
    }

}
