package de.wisag.automation.micas.olt.ui.internal.views;

import org.eclipse.core.databinding.observable.map.IObservableMap;

import de.wisag.automation.micas.common.ui.databinding.MapCellLabelProvider;
import de.wisag.automation.micas.rt.RtConstant;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtVariable;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

final class SymbolTypeLabelProvider extends MapCellLabelProvider {
    SymbolTypeLabelProvider(IObservableMap<?, ?>... attributeMaps) {
        super(attributeMaps);
    }

    @Override
    protected String format(Object... values) {
        String text = "";
        RtSymbol symbol = (RtSymbol) values[0];
        if (symbol instanceof RtReferenceConstant) {
            RtReferenceConstant rc = (RtReferenceConstant) symbol;
            text = rc.getType().getLiteral();
            switch (rc.getType()) {
            case FGA_ANALOG_VALUE:
                text = "Analogwert";
                break;
            case FGA_MEASURED_VALUE:
                text = "Messwert";
                break;
            case FGA_MESSAGE_CONST:
                text = "Meldung/Befehl";
                break;
            case FGA_VALUE:
                text = "Zaehlwert";
                break;
            default:
                break;
            }
        } else if (symbol instanceof RtConstant) {
            RtConstant constant = (RtConstant) symbol;
            if (constant instanceof RtWordConstant) {
                text = "Word Konstante";
            } else if (constant instanceof RtFloatConstant) {
                text = "Float Konstante";
            }
        } else if (symbol instanceof RtVariable) {
            RtVariable variable = (RtVariable) symbol;
            if (variable instanceof RtFloatVariable) {
                text = "Float Variable";
            } else if (variable instanceof RtWordVariable) {
                text = "Word Variable";
            }
        }
        return text;
    }
}