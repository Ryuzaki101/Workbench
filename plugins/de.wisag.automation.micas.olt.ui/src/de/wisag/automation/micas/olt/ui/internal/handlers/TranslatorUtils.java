package de.wisag.automation.micas.olt.ui.internal.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.export.mic.IRtSymbolTranslator;
import de.wisag.automation.micas.olt.ui.internal.views.SymbolMonitorView;
import de.wisag.automation.micas.rt.RtSymbol;

public class TranslatorUtils {

    public static List<RtSymbol> filterTranslatableSymbols(IRtSymbolTranslator translator, Iterator<Object> content) {
        List<RtSymbol> symbols = new ArrayList<>();
        while (content.hasNext()) {
            Object c = content.next();
            if (!(c instanceof EObject)) {
                continue;
            }
            EObject eObject = (EObject) c;
            if (!translator.supportsTranslationFor(eObject)) {
                continue;
            }
            RtSymbol symbol = translator.translate(new NullProgressMonitor(), eObject);
            if (symbol != null) {
                symbols.add(symbol);
            }
        }
        return symbols;
    }

    public static IStatus addAllSymboldToOnlinetest(List<RtSymbol> symbols) {
        if (!symbols.isEmpty()) {
            SymbolMonitorView view = SymbolMonitorView.openAndShow();
            view.monotorAllSymbols(symbols);
        }
        return Status.OK_STATUS;
    }

}
