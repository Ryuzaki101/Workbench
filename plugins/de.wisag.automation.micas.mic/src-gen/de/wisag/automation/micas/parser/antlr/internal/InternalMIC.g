/*
 * generated by Xtext 2.12.0
 */
grammar InternalMIC;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package de.wisag.automation.micas.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package de.wisag.automation.micas.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.wisag.automation.micas.services.MICGrammarAccess;

}

@parser::members {

 	private MICGrammarAccess grammarAccess;

    public InternalMICParser(TokenStream input, MICGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected MICGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	{
		newCompositeNode(grammarAccess.getModelAccess().getModuleParserRuleCall());
	}
	this_Module_0=ruleModule
	{
		$current = $this_Module_0.current;
		afterParserOrEnumRuleCall();
	}
;

// Entry rule entryRuleModule
entryRuleModule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModuleRule()); }
	iv_ruleModule=ruleModule
	{ $current=$iv_ruleModule.current; }
	EOF;

// Rule Module
ruleModule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getModuleAccess().getModulePrologMetaDataParserRuleCall_0_0());
				}
				lv_moduleProlog_0_0=ruleMetaData
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModuleRule());
					}
					add(
						$current,
						"moduleProlog",
						lv_moduleProlog_0_0,
						"de.wisag.automation.micas.MIC.MetaData");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='MODUL'
		{
			newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getMODULKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_type_3_0=RULE_ID
				{
					newLeafNode(lv_type_3_0, grammarAccess.getModuleAccess().getTypeIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModuleRule());
					}
					setWithLastConsumed(
						$current,
						"type",
						lv_type_3_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_4=','
		{
			newLeafNode(otherlv_4, grammarAccess.getModuleAccess().getCommaKeyword_4());
		}
		(
			(
				lv_value_5_0=RULE_INT
				{
					newLeafNode(lv_value_5_0, grammarAccess.getModuleAccess().getValueINTTerminalRuleCall_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModuleRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_5_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getModuleAccess().getRightParenthesisKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModuleAccess().getDecalarationsSymbolParserRuleCall_7_0());
				}
				lv_decalarations_7_0=ruleSymbol
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModuleRule());
					}
					add(
						$current,
						"decalarations",
						lv_decalarations_7_0,
						"de.wisag.automation.micas.MIC.Symbol");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getModuleAccess().getTasksTaskParserRuleCall_8_0());
				}
				lv_tasks_8_0=ruleTask
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModuleRule());
					}
					add(
						$current,
						"tasks",
						lv_tasks_8_0,
						"de.wisag.automation.micas.MIC.Task");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_9='ENDMODUL'
		{
			newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getENDMODULKeyword_9());
		}
	)
;

// Entry rule entryRuleSymbol
entryRuleSymbol returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSymbolRule()); }
	iv_ruleSymbol=ruleSymbol
	{ $current=$iv_ruleSymbol.current; }
	EOF;

// Rule Symbol
ruleSymbol returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSymbolAccess().getWordValueParserRuleCall_0());
		}
		this_WordValue_0=ruleWordValue
		{
			$current = $this_WordValue_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSymbolAccess().getFloatValueParserRuleCall_1());
		}
		this_FloatValue_1=ruleFloatValue
		{
			$current = $this_FloatValue_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSymbolAccess().getReferenceParserRuleCall_2());
		}
		this_Reference_2=ruleReference
		{
			$current = $this_Reference_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getSymbolAccess().getMetaDataParserRuleCall_3());
		}
		this_MetaData_3=ruleMetaData
		{
			$current = $this_MetaData_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleMetaData
entryRuleMetaData returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMetaDataRule()); }
	iv_ruleMetaData=ruleMetaData
	{ $current=$iv_ruleMetaData.current; }
	EOF;

// Rule MetaData
ruleMetaData returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0='\u00B0nothing'
				{
					newLeafNode(lv_name_0_0, grammarAccess.getMetaDataAccess().getNameNothingKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMetaDataRule());
					}
					setWithLastConsumed($current, "name", lv_name_0_0, "\u00B0nothing");
				}
			)
		)?
		(
			(
				lv_value_1_0=RULE_RAW_METADATE
				{
					newLeafNode(lv_value_1_0, grammarAccess.getMetaDataAccess().getValueRAW_METADATETerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMetaDataRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_1_0,
						"de.wisag.automation.micas.MIC.RAW_METADATE");
				}
			)
		)
	)
;

// Entry rule entryRuleWordValue
entryRuleWordValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWordValueRule()); }
	iv_ruleWordValue=ruleWordValue
	{ $current=$iv_ruleWordValue.current; }
	EOF;

// Rule WordValue
ruleWordValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getWordValueAccess().getWordVarParserRuleCall_0());
		}
		this_WordVar_0=ruleWordVar
		{
			$current = $this_WordVar_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getWordValueAccess().getWordConstParserRuleCall_1());
		}
		this_WordConst_1=ruleWordConst
		{
			$current = $this_WordConst_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleWordVar
entryRuleWordVar returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWordVarRule()); }
	iv_ruleWordVar=ruleWordVar
	{ $current=$iv_ruleWordVar.current; }
	EOF;

// Rule WordVar
ruleWordVar returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='WordV'
		{
			newLeafNode(otherlv_0, grammarAccess.getWordVarAccess().getWordVKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getWordVarAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getWordVarRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleWordConst
entryRuleWordConst returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWordConstRule()); }
	iv_ruleWordConst=ruleWordConst
	{ $current=$iv_ruleWordConst.current; }
	EOF;

// Rule WordConst
ruleWordConst returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='WordK'
		{
			newLeafNode(otherlv_0, grammarAccess.getWordConstAccess().getWordKKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getWordConstAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getWordConstRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getWordConstAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_value_3_0=RULE_INT
				{
					newLeafNode(lv_value_3_0, grammarAccess.getWordConstAccess().getValueINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getWordConstRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_3_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getWordConstAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleFloatValue
entryRuleFloatValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFloatValueRule()); }
	iv_ruleFloatValue=ruleFloatValue
	{ $current=$iv_ruleFloatValue.current; }
	EOF;

// Rule FloatValue
ruleFloatValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getFloatValueAccess().getFloatVarParserRuleCall_0());
		}
		this_FloatVar_0=ruleFloatVar
		{
			$current = $this_FloatVar_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getFloatValueAccess().getFloatConstParserRuleCall_1());
		}
		this_FloatConst_1=ruleFloatConst
		{
			$current = $this_FloatConst_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleFloatVar
entryRuleFloatVar returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFloatVarRule()); }
	iv_ruleFloatVar=ruleFloatVar
	{ $current=$iv_ruleFloatVar.current; }
	EOF;

// Rule FloatVar
ruleFloatVar returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='FloatV'
		{
			newLeafNode(otherlv_0, grammarAccess.getFloatVarAccess().getFloatVKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFloatVarAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFloatVarRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleFloatConst
entryRuleFloatConst returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFloatConstRule()); }
	iv_ruleFloatConst=ruleFloatConst
	{ $current=$iv_ruleFloatConst.current; }
	EOF;

// Rule FloatConst
ruleFloatConst returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='FloatK'
		{
			newLeafNode(otherlv_0, grammarAccess.getFloatConstAccess().getFloatKKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFloatConstAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFloatConstRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getFloatConstAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFloatConstAccess().getValueFloatParserRuleCall_3_0());
				}
				lv_value_3_0=ruleFloat
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFloatConstRule());
					}
					set(
						$current,
						"value",
						lv_value_3_0,
						"de.wisag.automation.micas.MIC.Float");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getFloatConstAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleDirectValue
entryRuleDirectValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDirectValueRule()); }
	iv_ruleDirectValue=ruleDirectValue
	{ $current=$iv_ruleDirectValue.current; }
	EOF;

// Rule DirectValue
ruleDirectValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_INT
			{
				newLeafNode(lv_value_0_0, grammarAccess.getDirectValueAccess().getValueINTTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getDirectValueRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"de.wisag.automation.micas.MIC.INT");
			}
		)
	)
;

// Entry rule entryRuleReference
entryRuleReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReferenceRule()); }
	iv_ruleReference=ruleReference
	{ $current=$iv_ruleReference.current; }
	EOF;

// Rule Reference
ruleReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getReferenceAccess().getFGAMessageConstantReferenceParserRuleCall_0());
		}
		this_FGAMessageConstantReference_0=ruleFGAMessageConstantReference
		{
			$current = $this_FGAMessageConstantReference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getReferenceAccess().getFGAAnalogValueReferenceParserRuleCall_1());
		}
		this_FGAAnalogValueReference_1=ruleFGAAnalogValueReference
		{
			$current = $this_FGAAnalogValueReference_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getReferenceAccess().getFGAValueReferenceParserRuleCall_2());
		}
		this_FGAValueReference_2=ruleFGAValueReference
		{
			$current = $this_FGAValueReference_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getReferenceAccess().getFGAMeasuredValueReferenceParserRuleCall_3());
		}
		this_FGAMeasuredValueReference_3=ruleFGAMeasuredValueReference
		{
			$current = $this_FGAMeasuredValueReference_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleFGAMessageConstantReference
entryRuleFGAMessageConstantReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFGAMessageConstantReferenceRule()); }
	iv_ruleFGAMessageConstantReference=ruleFGAMessageConstantReference
	{ $current=$iv_ruleFGAMessageConstantReference.current; }
	EOF;

// Rule FGAMessageConstantReference
ruleFGAMessageConstantReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='IPAMB'
		{
			newLeafNode(otherlv_0, grammarAccess.getFGAMessageConstantReferenceAccess().getIPAMBKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFGAMessageConstantReferenceAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAMessageConstantReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getFGAMessageConstantReferenceAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_row_3_0=RULE_INT
				{
					newLeafNode(lv_row_3_0, grammarAccess.getFGAMessageConstantReferenceAccess().getRowINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAMessageConstantReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"row",
						lv_row_3_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_4=','
		{
			newLeafNode(otherlv_4, grammarAccess.getFGAMessageConstantReferenceAccess().getCommaKeyword_4());
		}
		(
			(
				lv_column_5_0=RULE_INT
				{
					newLeafNode(lv_column_5_0, grammarAccess.getFGAMessageConstantReferenceAccess().getColumnINTTerminalRuleCall_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAMessageConstantReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"column",
						lv_column_5_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getFGAMessageConstantReferenceAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleFGAAnalogValueReference
entryRuleFGAAnalogValueReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFGAAnalogValueReferenceRule()); }
	iv_ruleFGAAnalogValueReference=ruleFGAAnalogValueReference
	{ $current=$iv_ruleFGAAnalogValueReference.current; }
	EOF;

// Rule FGAAnalogValueReference
ruleFGAAnalogValueReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='IPAAW'
		{
			newLeafNode(otherlv_0, grammarAccess.getFGAAnalogValueReferenceAccess().getIPAAWKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFGAAnalogValueReferenceAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAAnalogValueReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getFGAAnalogValueReferenceAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_row_3_0=RULE_INT
				{
					newLeafNode(lv_row_3_0, grammarAccess.getFGAAnalogValueReferenceAccess().getRowINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAAnalogValueReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"row",
						lv_row_3_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getFGAAnalogValueReferenceAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleFGAValueReference
entryRuleFGAValueReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFGAValueReferenceRule()); }
	iv_ruleFGAValueReference=ruleFGAValueReference
	{ $current=$iv_ruleFGAValueReference.current; }
	EOF;

// Rule FGAValueReference
ruleFGAValueReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='IPAZW'
		{
			newLeafNode(otherlv_0, grammarAccess.getFGAValueReferenceAccess().getIPAZWKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFGAValueReferenceAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAValueReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getFGAValueReferenceAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_row_3_0=RULE_INT
				{
					newLeafNode(lv_row_3_0, grammarAccess.getFGAValueReferenceAccess().getRowINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAValueReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"row",
						lv_row_3_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getFGAValueReferenceAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleFGAMeasuredValueReference
entryRuleFGAMeasuredValueReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFGAMeasuredValueReferenceRule()); }
	iv_ruleFGAMeasuredValueReference=ruleFGAMeasuredValueReference
	{ $current=$iv_ruleFGAMeasuredValueReference.current; }
	EOF;

// Rule FGAMeasuredValueReference
ruleFGAMeasuredValueReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='IPAMW'
		{
			newLeafNode(otherlv_0, grammarAccess.getFGAMeasuredValueReferenceAccess().getIPAMWKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFGAMeasuredValueReferenceAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAMeasuredValueReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getFGAMeasuredValueReferenceAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_row_3_0=RULE_INT
				{
					newLeafNode(lv_row_3_0, grammarAccess.getFGAMeasuredValueReferenceAccess().getRowINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFGAMeasuredValueReferenceRule());
					}
					setWithLastConsumed(
						$current,
						"row",
						lv_row_3_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getFGAMeasuredValueReferenceAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleTask
entryRuleTask returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTaskRule()); }
	iv_ruleTask=ruleTask
	{ $current=$iv_ruleTask.current; }
	EOF;

// Rule Task
ruleTask returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTaskAccess().getTaskPrologMetaDataParserRuleCall_0_0());
				}
				lv_taskProlog_0_0=ruleMetaData
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTaskRule());
					}
					add(
						$current,
						"taskProlog",
						lv_taskProlog_0_0,
						"de.wisag.automation.micas.MIC.MetaData");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_1='TASK'
		{
			newLeafNode(otherlv_1, grammarAccess.getTaskAccess().getTASKKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getTaskAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				lv_index_3_0=RULE_INT
				{
					newLeafNode(lv_index_3_0, grammarAccess.getTaskAccess().getIndexINTTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTaskRule());
					}
					setWithLastConsumed(
						$current,
						"index",
						lv_index_3_0,
						"de.wisag.automation.micas.MIC.INT");
				}
			)
		)
		otherlv_4=','
		{
			newLeafNode(otherlv_4, grammarAccess.getTaskAccess().getCommaKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTaskAccess().getTypeTaskStrategyParserRuleCall_5_0());
				}
				lv_type_5_0=ruleTaskStrategy
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTaskRule());
					}
					set(
						$current,
						"type",
						lv_type_5_0,
						"de.wisag.automation.micas.MIC.TaskStrategy");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_6=','
			{
				newLeafNode(otherlv_6, grammarAccess.getTaskAccess().getCommaKeyword_6_0());
			}
			(
				(
					lv_cycleTime_7_0=RULE_INT
					{
						newLeafNode(lv_cycleTime_7_0, grammarAccess.getTaskAccess().getCycleTimeINTTerminalRuleCall_6_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTaskRule());
						}
						setWithLastConsumed(
							$current,
							"cycleTime",
							lv_cycleTime_7_0,
							"de.wisag.automation.micas.MIC.INT");
					}
				)
			)
		)?
		otherlv_8=')'
		{
			newLeafNode(otherlv_8, grammarAccess.getTaskAccess().getRightParenthesisKeyword_7());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTaskAccess().getInstructionsInstructionParserRuleCall_8_0());
				}
				lv_instructions_9_0=ruleInstruction
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTaskRule());
					}
					add(
						$current,
						"instructions",
						lv_instructions_9_0,
						"de.wisag.automation.micas.MIC.Instruction");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_10='ENDE'
		{
			newLeafNode(otherlv_10, grammarAccess.getTaskAccess().getENDEKeyword_9());
		}
	)
;

// Entry rule entryRuleInstruction
entryRuleInstruction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getInstructionRule()); }
	iv_ruleInstruction=ruleInstruction
	{ $current=$iv_ruleInstruction.current; }
	EOF;

// Rule Instruction
ruleInstruction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getModuleInvokationParserRuleCall_0());
		}
		this_ModuleInvokation_0=ruleModuleInvokation
		{
			$current = $this_ModuleInvokation_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getInstructionAccess().getMetaDataParserRuleCall_1());
		}
		this_MetaData_1=ruleMetaData
		{
			$current = $this_MetaData_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleModuleInvokation
entryRuleModuleInvokation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModuleInvokationRule()); }
	iv_ruleModuleInvokation=ruleModuleInvokation
	{ $current=$iv_ruleModuleInvokation.current; }
	EOF;

// Rule ModuleInvokation
ruleModuleInvokation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_moduleName_0_0=RULE_ID
				{
					newLeafNode(lv_moduleName_0_0, grammarAccess.getModuleInvokationAccess().getModuleNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModuleInvokationRule());
					}
					setWithLastConsumed(
						$current,
						"moduleName",
						lv_moduleName_0_0,
						"de.wisag.automation.micas.MIC.ID");
				}
			)
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getModuleInvokationAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_0_0());
					}
					lv_arguments_2_0=ruleSymbolAccessor
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getModuleInvokationRule());
						}
						add(
							$current,
							"arguments",
							lv_arguments_2_0,
							"de.wisag.automation.micas.MIC.SymbolAccessor");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getModuleInvokationAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_1_1_0());
						}
						lv_arguments_4_0=ruleSymbolAccessor
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getModuleInvokationRule());
							}
							add(
								$current,
								"arguments",
								lv_arguments_4_0,
								"de.wisag.automation.micas.MIC.SymbolAccessor");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getModuleInvokationAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleSymbolAccessor
entryRuleSymbolAccessor returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSymbolAccessorRule()); }
	iv_ruleSymbolAccessor=ruleSymbolAccessor
	{ $current=$iv_ruleSymbolAccessor.current; }
	EOF;

// Rule SymbolAccessor
ruleSymbolAccessor returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				otherlv_0='writeaccess='
				{
					newLeafNode(otherlv_0, grammarAccess.getSymbolAccessorAccess().getWriteaccessKeyword_0_0_0());
				}
				(
					(
						lv_writing_1_0='true'
						{
							newLeafNode(lv_writing_1_0, grammarAccess.getSymbolAccessorAccess().getWritingTrueKeyword_0_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getSymbolAccessorRule());
							}
							setWithLastConsumed($current, "writing", true, "true");
						}
					)
				)
			)?
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSymbolAccessorRule());
						}
					}
					otherlv_2=RULE_ID
					{
						newLeafNode(otherlv_2, grammarAccess.getSymbolAccessorAccess().getSymbolSymbolCrossReference_0_1_0());
					}
				)
			)
		)
		    |
		{
			newCompositeNode(grammarAccess.getSymbolAccessorAccess().getDirectValueParserRuleCall_1());
		}
		this_DirectValue_3=ruleDirectValue
		{
			$current = $this_DirectValue_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleFloat
entryRuleFloat returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFloatRule()); }
	iv_ruleFloat=ruleFloat
	{ $current=$iv_ruleFloat.current.getText(); }
	EOF;

// Rule Float
ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_XFLOAT_0=RULE_XFLOAT
	{
		$current.merge(this_XFLOAT_0);
	}
	{
		newLeafNode(this_XFLOAT_0, grammarAccess.getFloatAccess().getXFLOATTerminalRuleCall());
	}
;

// Entry rule entryRuleTaskStrategy
entryRuleTaskStrategy returns [String current=null]:
	{ newCompositeNode(grammarAccess.getTaskStrategyRule()); }
	iv_ruleTaskStrategy=ruleTaskStrategy
	{ $current=$iv_ruleTaskStrategy.current.getText(); }
	EOF;

// Rule TaskStrategy
ruleTaskStrategy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='cycl'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCyclKeyword_0());
		}
		    |
		kw='back'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBackKeyword_1());
		}
		    |
		kw='init'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getInitKeyword_2());
		}
		    |
		kw='cycls'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCyclsKeyword_3());
		}
		    |
		kw='evnts'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getEvntsKeyword_4());
		}
		    |
		kw='backs'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBacksKeyword_5());
		}
		    |
		kw='inits'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getInitsKeyword_6());
		}
		    |
		kw='CYCL'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCYCLKeyword_7());
		}
		    |
		kw='BACK'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBACKKeyword_8());
		}
		    |
		kw='INIT'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getINITKeyword_9());
		}
		    |
		kw='CYCLS'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCYCLSKeyword_10());
		}
		    |
		kw='EVNTS'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getEVNTSKeyword_11());
		}
		    |
		kw='BACKS'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBACKSKeyword_12());
		}
		    |
		kw='INITS'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getINITSKeyword_13());
		}
	)
;

RULE_RAW_METADATE : ';' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_XFLOAT : ('-'|'+')? ('0'..'9')+ '.' ('0'..'9')+;

RULE_INT : '-'? ('0'..'9')+;

RULE_ID : ('$'|'&'|'A'..'Z'|'a'..'z'|'_'|'/'|'0'..'9'|'\\') ('&'|'A'..'Z'|'a'..'z'|'0'..'9'|'@'|'\u00C4'|'\u00DC'|'\u00D6'|'\u00E4'|'\u00FC'|'\u00F6'|'\u00DF'|'<'|'>'|'.'|'_'|'/'|'+'|'-'|'~'|'='|'?')+;

RULE_SPACE : (' '|'\t');

RULE_EOL : ('\r'|'\n')+;