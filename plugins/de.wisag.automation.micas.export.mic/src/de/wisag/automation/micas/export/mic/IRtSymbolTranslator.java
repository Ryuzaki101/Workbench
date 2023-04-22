package de.wisag.automation.micas.export.mic;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.rt.RtSymbol;

@FunctionalInterface
public interface IRtSymbolTranslator {
    /**
     * This method translates a given
     *
     * @param monitor
     * @param attribute
     * @return
     */
    default RtSymbol translate(IProgressMonitor monitor, EObject attribute) {
        return null;
    }

    /**
     * checks, if a symbol can be translated
     *
     * @param eobject
     * @return
     */

    public boolean supportsTranslationFor(EObject eobject);
}
