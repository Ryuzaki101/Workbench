package de.wisag.automation.micas.export.mic.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtSymbol;

/**
 * Does cleanups on Diagram files
 *
 * @author mkr
 */
public class RtModuleCleaner {

    /**
     * @param ret
     *            current rt module
     */
    public static void clean(RtModule ret) {
        removeUnused(ret.getSymbols());
    }

    private static void removeUnused(EList<? extends RtSymbol> wconstants) {
        List<RtSymbol> unusedSymbols = new ArrayList<>();
        for (RtSymbol rtSymbol : wconstants) {
            if (rtSymbol.getAccessors().isEmpty()) {
                unusedSymbols.add(rtSymbol);
            }
        }
        wconstants.removeAll(unusedSymbols);

    }

}
