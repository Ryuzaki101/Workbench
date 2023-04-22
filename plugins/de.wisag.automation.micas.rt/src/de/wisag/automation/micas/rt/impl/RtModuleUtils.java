package de.wisag.automation.micas.rt.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class RtModuleUtils {

    private static final int[] ABSTRGVS = new int[] { 0x01, //
            0x02, //
            0x03, //
            0x04, //
            0x81, //
            0x82, //
            0x83, //
            0x84 //
    };
    private static final String[] ABSTRGS = new String[] { "CYCL", //
            "EVNT", //
            "BACK", //
            "INIT", //
            "CYCLS", //
            "EVNTS", //
            "BACKS", "INITS" };

    public static String findTaskStrategy(int encodedTaskStrategy) {
        String strategy = null;
        for (int k = 0; k < ABSTRGVS.length; k++) {
            if (ABSTRGVS[k] == encodedTaskStrategy) {
                strategy = ABSTRGS[k];
                break;
            }
        }
        return strategy;
    }

    public static String getDisplayName(RtSymbol symbol) {
        if (symbol.getName() != null) {
            return symbol.getName();
        }
        String prefix = "";
        if (symbol instanceof RtWordConstant) {
            prefix = "wc_";
        } else if (symbol instanceof RtFloatConstant) {
            prefix = "fc_";
        } else if (symbol instanceof RtWordVariable) {
            prefix = "wv_";
        } else if (symbol instanceof RtFloatVariable) {
            prefix = "fv_";
        } else if (symbol instanceof RtReferenceConstant) {
            RtReferenceConstant reference = (RtReferenceConstant) symbol;
            switch (reference.getType()) {
            case FGA_ANALOG_VALUE:
                prefix = "&av_";
                break;
            case FGA_MEASURED_VALUE:
                prefix = "&mv_";
                break;
            case FGA_MESSAGE_CONST:
                prefix = "&mc_";
                break;
            case FGA_VALUE:
                prefix = "&tv_";
                break;

            default:
                break;
            }
            return prefix + "_" + symbol.getAddress() + "_" + reference.getRow()
                    + (reference.getType() == PortDataType.FGA_MESSAGE_CONST ? "_" + reference.getCol() : "");
        }

        return prefix + symbol.getAddress();
    }

    public static EList<RtWordConstant> getWordConstants(RtModule module) {
        Collection<RtWordConstant> objects = EcoreUtil.getObjectsByType(module.getSymbols(),
                RtPackage.eINSTANCE.getRtWordConstant());
        return new BasicEList<>(objects);
    }

    public static EList<RtWordVariable> getWordVariables(RtModule module) {
        Collection<RtWordVariable> objects = EcoreUtil.getObjectsByType(module.getSymbols(),
                RtPackage.eINSTANCE.getRtWordVariable());
        return new BasicEList<>(objects);
    }

    public static EList<RtFloatConstant> getFloatConstants(RtModule module) {
        Collection<RtFloatConstant> objects = EcoreUtil.getObjectsByType(module.getSymbols(),
                RtPackage.eINSTANCE.getRtFloatConstant());
        return new BasicEList<>(objects);
    }

    public static EList<RtFloatVariable> getFloatVariables(RtModule module) {
        Collection<RtFloatVariable> objects = EcoreUtil.getObjectsByType(module.getSymbols(),
                RtPackage.eINSTANCE.getRtFloatVariable());
        return new BasicEList<>(objects);
    }

    public static EList<RtReferenceConstant> getReferences(RtModule module) {
        Collection<RtReferenceConstant> objects = EcoreUtil.getObjectsByType(module.getSymbols(),
                RtPackage.eINSTANCE.getRtReferenceConstant());
        return new BasicEList<>(objects);
    }

    public static void addSymbol(RtModule module, RtSymbol symbol) {
        if (!haveSymbol(module, symbol.getAddress())) {
            module.getSymbols().add(symbol);
        }
    }

    public static RtSymbol getSymbol(RtModule module, int address) {
        EList<RtSymbol> symbols = module.getSymbols();
        for (RtSymbol rtSymbol : symbols) {
            if (address == rtSymbol.getAddress()) {
                return rtSymbol;
            }
        }
        return null;
    }

    public static boolean haveSymbol(RtModule module, int address) {
        EList<RtSymbol> symbols = module.getSymbols();
        for (RtSymbol rtSymbol : symbols) {
            if (address == rtSymbol.getAddress()) {
                return true;
            }
        }
        return false;
    }

    public static RtSymbol getOrCreateSymbol(RtModule module, int address, EClass eClass) {
        RtSymbol symbol = null;
        if (haveSymbol(module, address)) {
            symbol = getSymbol(module, address);
        } else {
            symbol = (RtSymbol) RtFactory.eINSTANCE.create(eClass);
            symbol.setAddress(address);
            module.getSymbols().add(symbol);

        }
        return symbol;
    }

    public static int getModuleChecksum(RtModule rtModule) {
        int taskc = (rtModule.getTasksCheckSum() << 16) & 0xffff0000;
        return taskc & (rtModule.getDataSegmentCheckSum() & 0xffff);
    }

    public static int calculateProgramSize(RtModule rtModule) {
        int pgmSize = 0;
        EList<RtTask> tasks = rtModule.getTasks();
        for (RtTask rtTask : tasks) {
            byte[] data = rtTask.getData();
            pgmSize += data != null ? data.length : 0;
        }
        if (rtModule.getDataSegment() != null) {
            pgmSize += rtModule.getDataSegment().length;
        }
        if (rtModule.getStartSegment() != null) {
            pgmSize += rtModule.getStartSegment().length;
        }
        if (rtModule.getHeadModuleSegment() != null) {
            pgmSize += rtModule.getHeadModuleSegment().length;
        }
        return pgmSize;
    }
}
