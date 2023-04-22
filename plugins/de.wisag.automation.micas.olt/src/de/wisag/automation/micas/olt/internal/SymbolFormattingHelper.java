package de.wisag.automation.micas.olt.internal;

import org.apache.commons.lang.StringUtils;

import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public abstract class SymbolFormattingHelper {

    public static String getFormattedValue(RtSymbol rtSymbol, String rawText) {
        String text = "";
        if (rtSymbol instanceof RtReferenceConstant) {
            RtReferenceConstant reference = (RtReferenceConstant) rtSymbol;
            int col = reference.getCol();
            switch (reference.getType()) {
            case FGA_MESSAGE_CONST:
                int value;
                try {
                    value = Integer.parseInt(rawText, 16);
                } catch (NumberFormatException e) {
                    value = 0;
                }
                String bitString = SymbolFormattingHelper.toBitString(value, 16);
                text += col < bitString.length() ? bitString.charAt(col) : "n/a";
                break;
    
            case FGA_ANALOG_VALUE:
            case FGA_MEASURED_VALUE:
            case FGA_VALUE:
                text = rawText;
                break;
            default:
                break;
            }
    
        } else if (rtSymbol instanceof RtFloatConstant) {
            // RtFloatConstant floatConst = (RtFloatConstant) rtSymbol;
            text = rawText;
        } else if (rtSymbol instanceof RtWordConstant) {
            // RtWordConstant wordConst = (RtWordConstant) rtSymbol;
            text = rawText;
        } else if (rtSymbol instanceof RtWordVariable) {
            // RtWordVariable wordVar = (RtWordVariable) rtSymbol;
            text = rawText;
        } else if (rtSymbol instanceof RtFloatVariable) {
            // RtFloatVariable floatVar = (RtFloatVariable) rtSymbol;
            text = rawText;
        }
        return text;
    }

    public static String toBitString(int value, int bitCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitCount; i++) {
            int s = 1 << i;
            boolean bit = (value & s) == s;
            sb.append(bit ? "1" : "0");
    
        }
        return StringUtils.reverse(sb.toString());
    }

}
