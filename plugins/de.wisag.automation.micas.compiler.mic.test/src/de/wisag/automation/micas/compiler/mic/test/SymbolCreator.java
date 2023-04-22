package de.wisag.automation.micas.compiler.mic.test;

import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class SymbolCreator {
    private int row = 0;
    private int symbolCount;
    private RtFactory rtFactory;

    public SymbolCreator() {
        this.rtFactory = RtFactory.eINSTANCE;
        this.row = 0;
        this.symbolCount = 0;
    }

    public RtSymbol nextSymbol(Port port, boolean outputSide) {
        PortDataType dataType = port.getAllowedPortDataTypes().iterator().next();
        RtSymbol symbol = null;
        switch (dataType) {
        case DIRECT_VALUE:
            RtDirectValue directValue = rtFactory.createRtDirectValue();
            directValue.setValue(1);
            symbol = directValue;
            break;
        case FGA_ANALOG_VALUE:
        case FGA_MEASURED_VALUE:
        case FGA_MESSAGE_CONST:
        case FGA_VALUE:
            RtReferenceConstant ref = rtFactory.createRtReferenceConstant();
            ref.setName(String.format("&ref_%04x", symbolCount++));
            ref.setType(dataType);
            ref.setCol(0);
            ref.setRow(row++);
            if (dataType == PortDataType.FGA_MESSAGE_CONST) {
                ref.setCol(11);
            }
            symbol = ref;
            break;
        case FLOAT_CONST:
            RtFloatConstant floatConstant = rtFactory.createRtFloatConstant();
            floatConstant.setValue(42.1f);
            floatConstant.setName(String.format("fc_%04x", symbolCount++));
            symbol = floatConstant;
            break;
        case FLOAT_VAR:
            RtFloatVariable floatVariable = rtFactory.createRtFloatVariable();
            floatVariable.setName(String.format("fv_%04x", symbolCount++));
            symbol = floatVariable;
            break;
        case WORD_CONST:
            RtWordConstant wordConstant = rtFactory.createRtWordConstant();
            wordConstant.setValue(42);
            wordConstant.setName(String.format("wc_%04x", symbolCount++));
            symbol = wordConstant;
            break;
        case WORD_VAR:
            RtWordVariable wordVariable = rtFactory.createRtWordVariable();
            wordVariable.setName(String.format("wv_%04x", symbolCount++));
            symbol = wordVariable;
            break;
        default:
            break;
        }
        return symbol;
    }

    public String nextDvName() {
        return String.format("wv_%04x", symbolCount++);
    }
}