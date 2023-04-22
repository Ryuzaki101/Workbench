package de.wisag.automation.micas.ui.syntaxcoloring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.services.MICGrammarAccess;

public class MICSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

    @Inject
    MICGrammarAccess grammar;

    @Override
    protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
            CancelIndicator cancelIndicator) {

        if (object.eClass().getClassifierID() == MICPackage.MODULE_INVOKATION) {
            highlightFeature(acceptor, object, MICPackage.Literals.MODULE_INVOKATION__MODULE_NAME,
                    HighlightingStyles.KEYWORD_ID);
            return true;
        }
        return false;
    }
}
