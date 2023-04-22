/**
 * generated by Xtext 2.12.0
 */
package de.wisag.automation.micas.mIC;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.wisag.automation.micas.mIC.MICPackage
 * @generated
 */
public interface MICFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MICFactory eINSTANCE = de.wisag.automation.micas.mIC.impl.MICFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Symbol</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Symbol</em>'.
   * @generated
   */
  Symbol createSymbol();

  /**
   * Returns a new object of class '<em>Meta Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Data</em>'.
   * @generated
   */
  MetaData createMetaData();

  /**
   * Returns a new object of class '<em>Word Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word Value</em>'.
   * @generated
   */
  WordValue createWordValue();

  /**
   * Returns a new object of class '<em>Word Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word Var</em>'.
   * @generated
   */
  WordVar createWordVar();

  /**
   * Returns a new object of class '<em>Word Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word Const</em>'.
   * @generated
   */
  WordConst createWordConst();

  /**
   * Returns a new object of class '<em>Float Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float Value</em>'.
   * @generated
   */
  FloatValue createFloatValue();

  /**
   * Returns a new object of class '<em>Float Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float Var</em>'.
   * @generated
   */
  FloatVar createFloatVar();

  /**
   * Returns a new object of class '<em>Float Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Float Const</em>'.
   * @generated
   */
  FloatConst createFloatConst();

  /**
   * Returns a new object of class '<em>Direct Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Direct Value</em>'.
   * @generated
   */
  DirectValue createDirectValue();

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference();

  /**
   * Returns a new object of class '<em>FGA Message Constant Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FGA Message Constant Reference</em>'.
   * @generated
   */
  FGAMessageConstantReference createFGAMessageConstantReference();

  /**
   * Returns a new object of class '<em>FGA Analog Value Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FGA Analog Value Reference</em>'.
   * @generated
   */
  FGAAnalogValueReference createFGAAnalogValueReference();

  /**
   * Returns a new object of class '<em>FGA Value Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FGA Value Reference</em>'.
   * @generated
   */
  FGAValueReference createFGAValueReference();

  /**
   * Returns a new object of class '<em>FGA Measured Value Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FGA Measured Value Reference</em>'.
   * @generated
   */
  FGAMeasuredValueReference createFGAMeasuredValueReference();

  /**
   * Returns a new object of class '<em>Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Task</em>'.
   * @generated
   */
  Task createTask();

  /**
   * Returns a new object of class '<em>Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instruction</em>'.
   * @generated
   */
  Instruction createInstruction();

  /**
   * Returns a new object of class '<em>Module Invokation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Invokation</em>'.
   * @generated
   */
  ModuleInvokation createModuleInvokation();

  /**
   * Returns a new object of class '<em>Symbol Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Symbol Accessor</em>'.
   * @generated
   */
  SymbolAccessor createSymbolAccessor();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MICPackage getMICPackage();

} //MICFactory