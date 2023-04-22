package de.wisag.automation.micas.common.ui.databinding;

import java.text.MessageFormat;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;

/**
 * Implementation of a cell label provider which provides support for formatting
 * using {@link MessageFormat#format(String, Object...)}
 */
public class GenericMapCellLabelProvider extends ObservableMapCellLabelProvider {
    private IObservableMap<?, ?>[] attributeMaps;
    protected String messagePattern;

    /**
     * Create a new label provider
     *
     * @param messagePattern
     *            the message pattern
     * @param attributeMaps
     *            the values to observe
     */
    public GenericMapCellLabelProvider(String messagePattern, IObservableMap<?, ?>... attributeMaps) {
        super(attributeMaps);
        this.messagePattern = messagePattern;
        this.attributeMaps = attributeMaps;
    }

    @Override
    public void update(ViewerCell cell) {
        Object element = cell.getElement();
        Object[] values = new Object[attributeMaps.length];
        int i = 0;
        for (IObservableMap<?, ?> m : attributeMaps) {
            values[i++] = m.get(element);
            if (values[i - 1] == null) {
                cell.setText("");
                return;
            }
        }
        cell.setText(format(values));
    }

    protected String format(Object... values) {
        return MessageFormat.format(messagePattern, values);
    }
}