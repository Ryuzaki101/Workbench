package de.wisag.automation.micas.common.ui.dialogs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class SymbolFilter {

    public SymbolFilter(EClass symbolClass) {
        super();
        this.symbolClass = symbolClass;
    }

    private final EClass symbolClass;

    public EClass getSymbolClass() {
        return symbolClass;
    }

    public static SymbolFilter createFilter(EClass symbolClass) {
        return new SymbolFilter(symbolClass);
    }

    public boolean match(EObject item) {
        return item.eClass().equals(symbolClass);
    }

}
