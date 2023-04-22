/**
 * generated by Xtext 2.12.0
 */
package de.wisag.automation.micas.mIC.impl;

import de.wisag.automation.micas.mIC.DirectValue;
import de.wisag.automation.micas.mIC.FGAAnalogValueReference;
import de.wisag.automation.micas.mIC.FGAMeasuredValueReference;
import de.wisag.automation.micas.mIC.FGAMessageConstantReference;
import de.wisag.automation.micas.mIC.FGAValueReference;
import de.wisag.automation.micas.mIC.FloatConst;
import de.wisag.automation.micas.mIC.FloatValue;
import de.wisag.automation.micas.mIC.FloatVar;
import de.wisag.automation.micas.mIC.Instruction;
import de.wisag.automation.micas.mIC.MICFactory;
import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.mIC.MetaData;
import de.wisag.automation.micas.mIC.Model;
import de.wisag.automation.micas.mIC.Module;
import de.wisag.automation.micas.mIC.ModuleInvokation;
import de.wisag.automation.micas.mIC.Reference;
import de.wisag.automation.micas.mIC.Symbol;
import de.wisag.automation.micas.mIC.SymbolAccessor;
import de.wisag.automation.micas.mIC.Task;
import de.wisag.automation.micas.mIC.WordConst;
import de.wisag.automation.micas.mIC.WordValue;
import de.wisag.automation.micas.mIC.WordVar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MICPackageImpl extends EPackageImpl implements MICPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass symbolEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metaDataEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wordValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wordVarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wordConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatVarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fgaMessageConstantReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fgaAnalogValueReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fgaValueReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fgaMeasuredValueReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass taskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instructionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleInvokationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass symbolAccessorEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.wisag.automation.micas.mIC.MICPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MICPackageImpl()
  {
    super(eNS_URI, MICFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MICPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MICPackage init()
  {
    if (isInited) return (MICPackage)EPackage.Registry.INSTANCE.getEPackage(MICPackage.eNS_URI);

    // Obtain or create and register package
    MICPackageImpl theMICPackage = (MICPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MICPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MICPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMICPackage.createPackageContents();

    // Initialize created meta-data
    theMICPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMICPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MICPackage.eNS_URI, theMICPackage);
    return theMICPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_ModuleProlog()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Type()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Value()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Decalarations()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Tasks()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSymbol()
  {
    return symbolEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSymbol_Name()
  {
    return (EAttribute)symbolEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetaData()
  {
    return metaDataEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaData_Value()
  {
    return (EAttribute)metaDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWordValue()
  {
    return wordValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWordVar()
  {
    return wordVarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWordConst()
  {
    return wordConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWordConst_Value()
  {
    return (EAttribute)wordConstEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloatValue()
  {
    return floatValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloatVar()
  {
    return floatVarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloatConst()
  {
    return floatConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFloatConst_Value()
  {
    return (EAttribute)floatConstEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirectValue()
  {
    return directValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDirectValue_Value()
  {
    return (EAttribute)directValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReference()
  {
    return referenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReference_Row()
  {
    return (EAttribute)referenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFGAMessageConstantReference()
  {
    return fgaMessageConstantReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFGAMessageConstantReference_Column()
  {
    return (EAttribute)fgaMessageConstantReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFGAAnalogValueReference()
  {
    return fgaAnalogValueReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFGAValueReference()
  {
    return fgaValueReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFGAMeasuredValueReference()
  {
    return fgaMeasuredValueReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTask()
  {
    return taskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTask_TaskProlog()
  {
    return (EReference)taskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTask_Index()
  {
    return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTask_Type()
  {
    return (EAttribute)taskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTask_CycleTime()
  {
    return (EAttribute)taskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTask_Instructions()
  {
    return (EReference)taskEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstruction()
  {
    return instructionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleInvokation()
  {
    return moduleInvokationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModuleInvokation_ModuleName()
  {
    return (EAttribute)moduleInvokationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModuleInvokation_Arguments()
  {
    return (EReference)moduleInvokationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSymbolAccessor()
  {
    return symbolAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSymbolAccessor_Writing()
  {
    return (EAttribute)symbolAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSymbolAccessor_Symbol()
  {
    return (EReference)symbolAccessorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MICFactory getMICFactory()
  {
    return (MICFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);

    moduleEClass = createEClass(MODULE);
    createEReference(moduleEClass, MODULE__MODULE_PROLOG);
    createEAttribute(moduleEClass, MODULE__TYPE);
    createEAttribute(moduleEClass, MODULE__VALUE);
    createEReference(moduleEClass, MODULE__DECALARATIONS);
    createEReference(moduleEClass, MODULE__TASKS);

    symbolEClass = createEClass(SYMBOL);
    createEAttribute(symbolEClass, SYMBOL__NAME);

    metaDataEClass = createEClass(META_DATA);
    createEAttribute(metaDataEClass, META_DATA__VALUE);

    wordValueEClass = createEClass(WORD_VALUE);

    wordVarEClass = createEClass(WORD_VAR);

    wordConstEClass = createEClass(WORD_CONST);
    createEAttribute(wordConstEClass, WORD_CONST__VALUE);

    floatValueEClass = createEClass(FLOAT_VALUE);

    floatVarEClass = createEClass(FLOAT_VAR);

    floatConstEClass = createEClass(FLOAT_CONST);
    createEAttribute(floatConstEClass, FLOAT_CONST__VALUE);

    directValueEClass = createEClass(DIRECT_VALUE);
    createEAttribute(directValueEClass, DIRECT_VALUE__VALUE);

    referenceEClass = createEClass(REFERENCE);
    createEAttribute(referenceEClass, REFERENCE__ROW);

    fgaMessageConstantReferenceEClass = createEClass(FGA_MESSAGE_CONSTANT_REFERENCE);
    createEAttribute(fgaMessageConstantReferenceEClass, FGA_MESSAGE_CONSTANT_REFERENCE__COLUMN);

    fgaAnalogValueReferenceEClass = createEClass(FGA_ANALOG_VALUE_REFERENCE);

    fgaValueReferenceEClass = createEClass(FGA_VALUE_REFERENCE);

    fgaMeasuredValueReferenceEClass = createEClass(FGA_MEASURED_VALUE_REFERENCE);

    taskEClass = createEClass(TASK);
    createEReference(taskEClass, TASK__TASK_PROLOG);
    createEAttribute(taskEClass, TASK__INDEX);
    createEAttribute(taskEClass, TASK__TYPE);
    createEAttribute(taskEClass, TASK__CYCLE_TIME);
    createEReference(taskEClass, TASK__INSTRUCTIONS);

    instructionEClass = createEClass(INSTRUCTION);

    moduleInvokationEClass = createEClass(MODULE_INVOKATION);
    createEAttribute(moduleInvokationEClass, MODULE_INVOKATION__MODULE_NAME);
    createEReference(moduleInvokationEClass, MODULE_INVOKATION__ARGUMENTS);

    symbolAccessorEClass = createEClass(SYMBOL_ACCESSOR);
    createEAttribute(symbolAccessorEClass, SYMBOL_ACCESSOR__WRITING);
    createEReference(symbolAccessorEClass, SYMBOL_ACCESSOR__SYMBOL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    moduleEClass.getESuperTypes().add(this.getModel());
    metaDataEClass.getESuperTypes().add(this.getSymbol());
    metaDataEClass.getESuperTypes().add(this.getInstruction());
    wordValueEClass.getESuperTypes().add(this.getSymbol());
    wordVarEClass.getESuperTypes().add(this.getWordValue());
    wordConstEClass.getESuperTypes().add(this.getWordValue());
    floatValueEClass.getESuperTypes().add(this.getSymbol());
    floatVarEClass.getESuperTypes().add(this.getFloatValue());
    floatConstEClass.getESuperTypes().add(this.getFloatValue());
    directValueEClass.getESuperTypes().add(this.getSymbolAccessor());
    referenceEClass.getESuperTypes().add(this.getSymbol());
    fgaMessageConstantReferenceEClass.getESuperTypes().add(this.getReference());
    fgaAnalogValueReferenceEClass.getESuperTypes().add(this.getReference());
    fgaValueReferenceEClass.getESuperTypes().add(this.getReference());
    fgaMeasuredValueReferenceEClass.getESuperTypes().add(this.getReference());
    moduleInvokationEClass.getESuperTypes().add(this.getInstruction());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModule_ModuleProlog(), this.getMetaData(), null, "moduleProlog", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_Type(), ecorePackage.getEString(), "type", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_Value(), ecorePackage.getEInt(), "value", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Decalarations(), this.getSymbol(), null, "decalarations", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Tasks(), this.getTask(), null, "tasks", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(symbolEClass, Symbol.class, "Symbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSymbol_Name(), ecorePackage.getEString(), "name", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(metaDataEClass, MetaData.class, "MetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMetaData_Value(), ecorePackage.getEString(), "value", null, 0, 1, MetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(wordValueEClass, WordValue.class, "WordValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(wordVarEClass, WordVar.class, "WordVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(wordConstEClass, WordConst.class, "WordConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWordConst_Value(), ecorePackage.getEInt(), "value", null, 0, 1, WordConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(floatValueEClass, FloatValue.class, "FloatValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(floatVarEClass, FloatVar.class, "FloatVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(floatConstEClass, FloatConst.class, "FloatConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFloatConst_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, FloatConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(directValueEClass, DirectValue.class, "DirectValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDirectValue_Value(), ecorePackage.getEInt(), "value", null, 0, 1, DirectValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReference_Row(), ecorePackage.getEInt(), "row", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fgaMessageConstantReferenceEClass, FGAMessageConstantReference.class, "FGAMessageConstantReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFGAMessageConstantReference_Column(), ecorePackage.getEInt(), "column", null, 0, 1, FGAMessageConstantReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fgaAnalogValueReferenceEClass, FGAAnalogValueReference.class, "FGAAnalogValueReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fgaValueReferenceEClass, FGAValueReference.class, "FGAValueReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fgaMeasuredValueReferenceEClass, FGAMeasuredValueReference.class, "FGAMeasuredValueReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTask_TaskProlog(), this.getMetaData(), null, "taskProlog", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTask_Index(), ecorePackage.getEInt(), "index", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTask_Type(), ecorePackage.getEString(), "type", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTask_CycleTime(), ecorePackage.getEInt(), "cycleTime", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTask_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instructionEClass, Instruction.class, "Instruction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(moduleInvokationEClass, ModuleInvokation.class, "ModuleInvokation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModuleInvokation_ModuleName(), ecorePackage.getEString(), "moduleName", null, 0, 1, ModuleInvokation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModuleInvokation_Arguments(), this.getSymbolAccessor(), null, "arguments", null, 0, -1, ModuleInvokation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(symbolAccessorEClass, SymbolAccessor.class, "SymbolAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSymbolAccessor_Writing(), ecorePackage.getEBoolean(), "writing", null, 0, 1, SymbolAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSymbolAccessor_Symbol(), this.getSymbol(), null, "symbol", null, 0, 1, SymbolAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //MICPackageImpl
