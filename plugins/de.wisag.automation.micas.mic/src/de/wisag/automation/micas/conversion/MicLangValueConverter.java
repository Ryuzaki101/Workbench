package de.wisag.automation.micas.conversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.nodemodel.INode;

public class MicLangValueConverter extends DefaultTerminalConverters {

    @ValueConverter(rule = "Float")
    public IValueConverter<Double> float_() {
        return new AbstractValueConverter<Double>() {
            @Override
            public String toString(Double value) {
                return value != null ? value.toString() : "";
            }

            @Override
            public Double toValue(String sValue, INode node) throws ValueConverterException {
                return sValue != null ? Double.valueOf(sValue) : -1;
            }
        };
    }
}
