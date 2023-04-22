package de.wisag.automation.micas.diagram.ui.palette;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.ui.IEditorPart;
import org.eclipselabs.damos.diagram.ui.palette.ElementCreationToolEntry;

import de.wisag.automation.micas.diagram.core.type.ElementTypes;

public class PaletteProvider extends org.eclipselabs.damos.diagram.ui.palette.PaletteProvider {

    @Override
    protected List<PaletteEntry> createBuiltinComponentEntries(IEditorPart editor) {
        List<PaletteEntry> entries = new ArrayList<>();
        PaletteEntry entry;

        entry = new ElementCreationToolEntry(ElementTypes.INCOMING_OFFPAGE_CONNECTOR, null, null);
        entries.add(entry);

        entry = new ElementCreationToolEntry(ElementTypes.OUTGOING_OFFPAGE_CONNECTOR, null, null);
        entries.add(entry);

        entry = new ElementCreationToolEntry(ElementTypes.CONSTANT, null, null);
        entries.add(entry);

        entry = new ElementCreationToolEntry(ElementTypes.REFERENCE, null, null);
        entries.add(entry);

        return entries;
    }

}
