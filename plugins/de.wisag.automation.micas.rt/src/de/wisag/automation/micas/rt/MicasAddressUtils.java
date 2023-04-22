package de.wisag.automation.micas.rt;

import java.util.Comparator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class MicasAddressUtils {

    public static final class RtConstantComparator implements Comparator<RtConstant> {
        @Override
        public int compare(RtConstant o1, RtConstant o2) {
            Integer i1 = o1.getIndex();
            Integer i2 = o2.getIndex();
            return i1.compareTo(i2);
        }
    }

    public static EList<RtConstant> getWordConstants(RtModule rtModule) {
        EList<RtConstant> eConstants = new BasicEList<>();
        EList<RtSymbol> symbols = rtModule.getSymbols();
        for (RtSymbol rtSymbol : symbols) {
            if (rtSymbol instanceof RtReferenceConstant || rtSymbol instanceof RtWordConstant) {
                eConstants.add((RtConstant) rtSymbol);
            }
        }
        return eConstants;
    }

    public static int getTaskStrategy(RtTaskStrategy strategy) {
        int stgy = 0;
        switch (strategy) {
        case CYCL:
            stgy = 0x01;
            break;
        case EVNT:
            stgy = 0x02;
            break;
        case BACK:
            stgy = 0x03;
            break;
        case INIT:
            stgy = 0x04;
            break;
        default:
            break;
        }
        return stgy;
    }

    public static int alignOffset(final int offset) {
        return (offset & 0xfff0) + 0x0010;
    }

}
