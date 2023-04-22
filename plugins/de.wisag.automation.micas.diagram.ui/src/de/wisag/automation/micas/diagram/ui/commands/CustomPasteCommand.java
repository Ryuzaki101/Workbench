package de.wisag.automation.micas.diagram.ui.commands;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.util.ICustomData;
import org.eclipse.gmf.runtime.diagram.ui.commands.PasteCommand;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.View;

public class CustomPasteCommand extends PasteCommand {
    private static final Pattern OWNING_FRAGMENT_PATTERN = Pattern.compile("<owningFragment.*/>");

    public CustomPasteCommand(TransactionalEditingDomain editingDomain, String label, View viewContext,
            ICustomData[] data, IMapMode mm) {
        super(editingDomain, label, viewContext, data, mm);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected List pasteFromString(View view, String clipboard) {
        StringBuffer myStringBuffer = new StringBuffer();

        Matcher matcher = OWNING_FRAGMENT_PATTERN.matcher(clipboard);
        while (matcher.find()) {
            matcher.appendReplacement(myStringBuffer,
                    computeReplacement(clipboard.substring(matcher.start(), matcher.end())));
        }
        matcher.appendTail(myStringBuffer);
        return super.pasteFromString(view, myStringBuffer.toString());
    }

    private String computeReplacement(String substring) {
        return "<!--" + substring.substring(4, substring.length() - 3) + "-->";
    }

}
