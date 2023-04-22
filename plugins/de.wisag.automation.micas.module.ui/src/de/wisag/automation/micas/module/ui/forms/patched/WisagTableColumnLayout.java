package de.wisag.automation.micas.module.ui.forms.patched;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Widget;

/**
 * This class fixes some bugs in TableColumnLayout see
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=215997 The TableColumnLayout is
 * the {@link Layout} used to maintain {@link TableColumn} sizes in a
 * {@link Table}.
 * <p>
 * <b>You can only add the {@link Layout} to a container whose <i>only</i> child
 * is the {@link Table} control you want the {@link Layout} applied to. Don't
 * assign the layout directly the {@link Table}</b>
 * </p>
 *
 * @since 3.3
 */
public class WisagTableColumnLayout extends AbstractColumnLayout {

    /**
     * {@inheritDoc}
     *
     * @since 3.5
     */
    @Override
    protected int getColumnCount(Scrollable tableTree) {
        return ((Table) tableTree).getColumnCount();
    }

    /**
     * {@inheritDoc}
     *
     * @since 3.5
     */
    @Override
    protected void setColumnWidths(Scrollable tableTree, int[] widths) {
        TableColumn[] columns = ((Table) tableTree).getColumns();
        for (int i = 0; i < widths.length; i++) {
            columns[i].setWidth(widths[i]);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @since 3.5
     */
    @Override
    protected ColumnLayoutData getLayoutData(Scrollable tableTree, int columnIndex) {
        TableColumn column = ((Table) tableTree).getColumn(columnIndex);
        return (ColumnLayoutData) column.getData(LAYOUT_DATA);
    }

    Composite getComposite(Widget column) {
        return ((TableColumn) column).getParent().getParent();
    }

    /**
     * @since 3.5
     */
    @Override
    protected void updateColumnData(Widget column) {
        TableColumn tColumn = (TableColumn) column;
        Table t = tColumn.getParent();

        if (!IS_GTK || t.getColumn(t.getColumnCount() - 1) != tColumn) {
            tColumn.setData(LAYOUT_DATA, new ColumnPixelData(tColumn.getWidth()));
            layout(t.getParent(), true);
        }
    }
}
