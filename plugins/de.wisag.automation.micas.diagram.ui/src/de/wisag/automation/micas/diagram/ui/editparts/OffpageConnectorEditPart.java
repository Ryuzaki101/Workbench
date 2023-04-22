package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipselabs.damos.diagram.ui.editparts.EditableContentComponentEditPart;

import de.wisag.automation.micas.diagram.ui.figures.OffpageConnectorFigure;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.ModulePackage;

public abstract class OffpageConnectorEditPart extends EditableContentComponentEditPart {

    protected static final String NOT_SET_TEXT = "????";
    private IParser parser;

    public OffpageConnectorEditPart(View view) {
        super(view);
    }

    @Override
    protected NodeFigure createMainFigure() {
        return new OffpageConnectorFigure();
    }

    @Override
    protected ICommand createParseCommand(IAdaptable element, String newString, int flags) {
        return new SetValueCommand(new SetRequest(TransactionUtil.getEditingDomain(getAttribute()), getAttribute(),
                ModulePackage.Literals.ATTRIBUTE__NAME, newString));

    }

    @Override
    public IParser getParser() {
        if (parser == null) {
            parser = new IParser() {

                @Override
                public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
                    return OffpageConnectorEditPart.this.getCompletionProcessor();
                }

                @Override
                public String getEditString(IAdaptable element, int flags) {
                    return getContentText();
                }

                @Override
                public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
                    return createParseCommand(element, newString, flags);
                }

                @Override
                public String getPrintString(IAdaptable element, int flags) {
                    return getEditString(element, flags);
                }

                @Override
                public boolean isAffectingEvent(Object event, int flags) {
                    return false;
                }

                @Override
                public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
                    return ParserEditStatus.EDITABLE_STATUS;
                }

            };
        }
        return parser;
    }

    public abstract Attribute getAttribute();

}
