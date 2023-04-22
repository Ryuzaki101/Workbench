/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.DMLPackage;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModuleKind;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.OffpageConnector;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.PageFormat;
import de.wisag.automation.micas.module.PageOrientation;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;
import de.wisag.automation.micas.module.Value;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ModulePackageImpl extends EPackageImpl implements ModulePackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass moduleEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass attributeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass taskEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass variableAttributeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass constantAttributeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass referenceAttributeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass valueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass floatValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass wordValueEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass attributeSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass micasDataTypeSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass pageEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass offpageConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass incomingOffpageConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass outgoingOffpageConnectorEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass constantEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass referenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum moduleKindEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum dataTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum referenceTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum taskKindEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum pageFormatEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum pageOrientationEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EDataType floatEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.wisag.automation.micas.module.ModulePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ModulePackageImpl() {
        super(eNS_URI, ModuleFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link ModulePackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModulePackage init() {
        if (isInited) {
            return (ModulePackage) EPackage.Registry.INSTANCE.getEPackage(ModulePackage.eNS_URI);
        }

        // Obtain or create and register package
        ModulePackageImpl theModulePackage = (ModulePackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ModulePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new ModulePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        DMLPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theModulePackage.createPackageContents();

        // Initialize created meta-data
        theModulePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theModulePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ModulePackage.eNS_URI, theModulePackage);
        return theModulePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getModule() {
        return moduleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_Kind() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getModule_Attributes() {
        return (EReference) moduleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getModule_Tasks() {
        return (EReference) moduleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_Processor() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_Examiner() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_CreatedDate() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_LastModifiedDate() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_LastInstallDate() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_Name() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_Qualifier() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_LineNumber() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_StationNumber() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_FieldBusNumber() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_PageFormat() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getModule_PageOrientation() {
        return (EAttribute) moduleEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAttribute() {
        return attributeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAttribute_Name() {
        return (EAttribute) attributeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAttribute_DataType() {
        return (EAttribute) attributeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAttribute_Description() {
        return (EAttribute) attributeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTask() {
        return taskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTask_Kind() {
        return (EAttribute) taskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTask_CycleTime() {
        return (EAttribute) taskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTask_Index() {
        return (EAttribute) taskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTask_Pages() {
        return (EReference) taskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTask_Module() {
        return (EReference) taskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTask_Name() {
        return (EAttribute) taskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getVariableAttribute() {
        return variableAttributeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getConstantAttribute() {
        return constantAttributeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getConstantAttribute_Value() {
        return (EReference) constantAttributeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getReferenceAttribute() {
        return referenceAttributeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getReferenceAttribute_Row() {
        return (EAttribute) referenceAttributeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getReferenceAttribute_Column() {
        return (EAttribute) referenceAttributeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getReferenceAttribute_ReferenceType() {
        return (EAttribute) referenceAttributeEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getValue() {
        return valueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getFloatValue() {
        return floatValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getFloatValue_Value() {
        return (EAttribute) floatValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getWordValue() {
        return wordValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWordValue_Value() {
        return (EAttribute) wordValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAttributeSpecification() {
        return attributeSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAttributeSpecification_Attribute() {
        return (EReference) attributeSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMicasDataTypeSpecification() {
        return micasDataTypeSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getMicasDataTypeSpecification_DataType() {
        return (EAttribute) micasDataTypeSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPage() {
        return pageEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPage_Task() {
        return (EReference) pageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOffpageConnector() {
        return offpageConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getIncomingOffpageConnector() {
        return incomingOffpageConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOutgoingOffpageConnector() {
        return outgoingOffpageConnectorEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getConstant() {
        return constantEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getReference() {
        return referenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getModuleKind() {
        return moduleKindEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getDataType() {
        return dataTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getReferenceType() {
        return referenceTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getTaskKind() {
        return taskKindEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getPageFormat() {
        return pageFormatEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getPageOrientation() {
        return pageOrientationEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EDataType getFloat() {
        return floatEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ModuleFactory getModuleFactory() {
        return (ModuleFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        moduleEClass = createEClass(MODULE);
        createEAttribute(moduleEClass, MODULE__KIND);
        createEReference(moduleEClass, MODULE__ATTRIBUTES);
        createEReference(moduleEClass, MODULE__TASKS);
        createEAttribute(moduleEClass, MODULE__PROCESSOR);
        createEAttribute(moduleEClass, MODULE__EXAMINER);
        createEAttribute(moduleEClass, MODULE__CREATED_DATE);
        createEAttribute(moduleEClass, MODULE__LAST_MODIFIED_DATE);
        createEAttribute(moduleEClass, MODULE__LAST_INSTALL_DATE);
        createEAttribute(moduleEClass, MODULE__NAME);
        createEAttribute(moduleEClass, MODULE__QUALIFIER);
        createEAttribute(moduleEClass, MODULE__LINE_NUMBER);
        createEAttribute(moduleEClass, MODULE__STATION_NUMBER);
        createEAttribute(moduleEClass, MODULE__FIELD_BUS_NUMBER);
        createEAttribute(moduleEClass, MODULE__PAGE_FORMAT);
        createEAttribute(moduleEClass, MODULE__PAGE_ORIENTATION);

        attributeEClass = createEClass(ATTRIBUTE);
        createEAttribute(attributeEClass, ATTRIBUTE__NAME);
        createEAttribute(attributeEClass, ATTRIBUTE__DATA_TYPE);
        createEAttribute(attributeEClass, ATTRIBUTE__DESCRIPTION);

        taskEClass = createEClass(TASK);
        createEAttribute(taskEClass, TASK__KIND);
        createEAttribute(taskEClass, TASK__CYCLE_TIME);
        createEAttribute(taskEClass, TASK__INDEX);
        createEReference(taskEClass, TASK__PAGES);
        createEReference(taskEClass, TASK__MODULE);
        createEAttribute(taskEClass, TASK__NAME);

        variableAttributeEClass = createEClass(VARIABLE_ATTRIBUTE);

        constantAttributeEClass = createEClass(CONSTANT_ATTRIBUTE);
        createEReference(constantAttributeEClass, CONSTANT_ATTRIBUTE__VALUE);

        referenceAttributeEClass = createEClass(REFERENCE_ATTRIBUTE);
        createEAttribute(referenceAttributeEClass, REFERENCE_ATTRIBUTE__ROW);
        createEAttribute(referenceAttributeEClass, REFERENCE_ATTRIBUTE__COLUMN);
        createEAttribute(referenceAttributeEClass, REFERENCE_ATTRIBUTE__REFERENCE_TYPE);

        valueEClass = createEClass(VALUE);

        floatValueEClass = createEClass(FLOAT_VALUE);
        createEAttribute(floatValueEClass, FLOAT_VALUE__VALUE);

        wordValueEClass = createEClass(WORD_VALUE);
        createEAttribute(wordValueEClass, WORD_VALUE__VALUE);

        attributeSpecificationEClass = createEClass(ATTRIBUTE_SPECIFICATION);
        createEReference(attributeSpecificationEClass, ATTRIBUTE_SPECIFICATION__ATTRIBUTE);

        micasDataTypeSpecificationEClass = createEClass(MICAS_DATA_TYPE_SPECIFICATION);
        createEAttribute(micasDataTypeSpecificationEClass, MICAS_DATA_TYPE_SPECIFICATION__DATA_TYPE);

        pageEClass = createEClass(PAGE);
        createEReference(pageEClass, PAGE__TASK);

        offpageConnectorEClass = createEClass(OFFPAGE_CONNECTOR);

        incomingOffpageConnectorEClass = createEClass(INCOMING_OFFPAGE_CONNECTOR);

        outgoingOffpageConnectorEClass = createEClass(OUTGOING_OFFPAGE_CONNECTOR);

        constantEClass = createEClass(CONSTANT);

        referenceEClass = createEClass(REFERENCE);

        // Create enums
        moduleKindEEnum = createEEnum(MODULE_KIND);
        dataTypeEEnum = createEEnum(DATA_TYPE);
        referenceTypeEEnum = createEEnum(REFERENCE_TYPE);
        taskKindEEnum = createEEnum(TASK_KIND);
        pageFormatEEnum = createEEnum(PAGE_FORMAT);
        pageOrientationEEnum = createEEnum(PAGE_ORIENTATION);

        // Create data types
        floatEDataType = createEDataType(FLOAT);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        DMLPackage theDMLPackage = (DMLPackage) EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        variableAttributeEClass.getESuperTypes().add(this.getAttribute());
        constantAttributeEClass.getESuperTypes().add(this.getAttribute());
        referenceAttributeEClass.getESuperTypes().add(this.getAttribute());
        floatValueEClass.getESuperTypes().add(this.getValue());
        wordValueEClass.getESuperTypes().add(this.getValue());
        attributeSpecificationEClass.getESuperTypes().add(theDMLPackage.getSignalSpecification());
        micasDataTypeSpecificationEClass.getESuperTypes().add(theDMLPackage.getDataTypeSpecification());
        pageEClass.getESuperTypes().add(theDMLPackage.getSystem());
        offpageConnectorEClass.getESuperTypes().add(theDMLPackage.getComponent());
        incomingOffpageConnectorEClass.getESuperTypes().add(this.getOffpageConnector());
        outgoingOffpageConnectorEClass.getESuperTypes().add(this.getOffpageConnector());
        constantEClass.getESuperTypes().add(theDMLPackage.getComponent());
        referenceEClass.getESuperTypes().add(theDMLPackage.getComponent());

        // Initialize classes and features; add operations and parameters
        initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getModule_Kind(), this.getModuleKind(), "kind", null, 1, 1, Module.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getModule_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModule_Tasks(), this.getTask(), this.getTask_Module(), "tasks", null, 0, -1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_Processor(), ecorePackage.getEString(), "processor", null, 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_Examiner(), ecorePackage.getEString(), "examiner", null, 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_CreatedDate(), ecorePackage.getEDate(), "createdDate", null, 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_LastModifiedDate(), ecorePackage.getEDate(), "lastModifiedDate", null, 0, 1,
                Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_LastInstallDate(), ecorePackage.getEDate(), "lastInstallDate", null, 0, 1,
                Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_Qualifier(), ecorePackage.getEInt(), "qualifier", "29", 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_StationNumber(), ecorePackage.getEInt(), "stationNumber", null, 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_FieldBusNumber(), ecorePackage.getEInt(), "fieldBusNumber", "2", 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_PageFormat(), this.getPageFormat(), "pageFormat", "A3", 0, 1, Module.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModule_PageOrientation(), this.getPageOrientation(), "pageOrientation", null, 0, 1,
                Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 1, 1, Attribute.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEAttribute(getAttribute_DataType(), this.getDataType(), "dataType", null, 1, 1, Attribute.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEAttribute(getAttribute_Description(), ecorePackage.getEString(), "description", "\"\"", 0, 1,
                Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTask_Kind(), this.getTaskKind(), "kind", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getTask_CycleTime(), ecorePackage.getEInt(), "cycleTime", "0", 1, 1, Task.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getTask_Index(), ecorePackage.getEInt(), "index", "0", 1, 1, Task.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getTask_Pages(), this.getPage(), this.getPage_Task(), "pages", null, 0, -1, Task.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTask_Module(), this.getModule(), this.getModule_Tasks(), "module", null, 1, 1, Task.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTask_Name(), ecorePackage.getEString(), "name", null, 0, 1, Task.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(variableAttributeEClass, VariableAttribute.class, "VariableAttribute", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(constantAttributeEClass, ConstantAttribute.class, "ConstantAttribute", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConstantAttribute_Value(), this.getValue(), null, "value", null, 1, 1,
                ConstantAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(referenceAttributeEClass, ReferenceAttribute.class, "ReferenceAttribute", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getReferenceAttribute_Row(), ecorePackage.getEInt(), "row", null, 1, 1, ReferenceAttribute.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEAttribute(getReferenceAttribute_Column(), ecorePackage.getEInt(), "column", null, 0, 1,
                ReferenceAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getReferenceAttribute_ReferenceType(), this.getReferenceType(), "referenceType", null, 0, 1,
                ReferenceAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(floatValueEClass, FloatValue.class, "FloatValue", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFloatValue_Value(), this.getFloat(), "value", null, 1, 1, FloatValue.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(wordValueEClass, WordValue.class, "WordValue", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWordValue_Value(), ecorePackage.getEInt(), "value", null, 1, 1, WordValue.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);

        initEClass(attributeSpecificationEClass, AttributeSpecification.class, "AttributeSpecification", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAttributeSpecification_Attribute(), this.getAttribute(), null, "attribute", null, 1, 1,
                AttributeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(micasDataTypeSpecificationEClass, MicasDataTypeSpecification.class, "MicasDataTypeSpecification",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMicasDataTypeSpecification_DataType(), this.getDataType(), "dataType", null, 1, 1,
                MicasDataTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(pageEClass, Page.class, "Page", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPage_Task(), this.getTask(), this.getTask_Pages(), "task", null, 1, 1, Page.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(offpageConnectorEClass, OffpageConnector.class, "OffpageConnector", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(incomingOffpageConnectorEClass, IncomingOffpageConnector.class, "IncomingOffpageConnector",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(outgoingOffpageConnectorEClass, OutgoingOffpageConnector.class, "OutgoingOffpageConnector",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(moduleKindEEnum, ModuleKind.class, "ModuleKind");
        addEEnumLiteral(moduleKindEEnum, ModuleKind.AC40);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.AR11);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.AR20);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ER11);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ER12);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.GW12);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.GW13);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.GW14);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.MB11);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.SP11);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.SP20);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZM12);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZM13);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZM14);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZM15);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZP12);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZP13);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.AR10);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZP10);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.ZP20);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.MB10);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.SP10);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.AR12);
        addEEnumLiteral(moduleKindEEnum, ModuleKind.AC60);

        initEEnum(dataTypeEEnum, DataType.class, "DataType");
        addEEnumLiteral(dataTypeEEnum, DataType.FLOAT);
        addEEnumLiteral(dataTypeEEnum, DataType.WORD);
        addEEnumLiteral(dataTypeEEnum, DataType.REFERENCE);

        initEEnum(referenceTypeEEnum, ReferenceType.class, "ReferenceType");
        addEEnumLiteral(referenceTypeEEnum, ReferenceType.FGA_VALUE);
        addEEnumLiteral(referenceTypeEEnum, ReferenceType.FGA_MESSAGE_CONST);
        addEEnumLiteral(referenceTypeEEnum, ReferenceType.FGA_MEASURED_VALUE);
        addEEnumLiteral(referenceTypeEEnum, ReferenceType.FGA_ANALOG_VALUE);

        initEEnum(taskKindEEnum, TaskKind.class, "TaskKind");
        addEEnumLiteral(taskKindEEnum, TaskKind.INIT);
        addEEnumLiteral(taskKindEEnum, TaskKind.CYCLIC);

        initEEnum(pageFormatEEnum, PageFormat.class, "PageFormat");
        addEEnumLiteral(pageFormatEEnum, PageFormat.A4);
        addEEnumLiteral(pageFormatEEnum, PageFormat.A3);

        initEEnum(pageOrientationEEnum, PageOrientation.class, "PageOrientation");
        addEEnumLiteral(pageOrientationEEnum, PageOrientation.LANDSCAPE);
        addEEnumLiteral(pageOrientationEEnum, PageOrientation.PORTRAIT);

        // Initialize data types
        initEDataType(floatEDataType, double.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} // ModulePackageImpl
