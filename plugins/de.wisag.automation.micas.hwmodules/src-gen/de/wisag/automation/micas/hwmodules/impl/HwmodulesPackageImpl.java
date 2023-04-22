/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesFactory;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Parameter;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class HwmodulesPackageImpl extends EPackageImpl implements HwmodulesPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass moduleDefinitionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass portEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass portGroupEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass micasModulesEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass parameterEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass hardwareTypeDefinitionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass hardwareAliasEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum portDataTypeEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum hardwareTypeEEnum = null;

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
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private HwmodulesPackageImpl() {
        super(eNS_URI, HwmodulesFactory.eINSTANCE);
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
     * This method is used to initialize {@link HwmodulesPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static HwmodulesPackage init() {
        if (isInited) {
            return (HwmodulesPackage) EPackage.Registry.INSTANCE.getEPackage(HwmodulesPackage.eNS_URI);
        }

        // Obtain or create and register package
        HwmodulesPackageImpl theHwmodulesPackage = (HwmodulesPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof HwmodulesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new HwmodulesPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theHwmodulesPackage.createPackageContents();

        // Initialize created meta-data
        theHwmodulesPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theHwmodulesPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(HwmodulesPackage.eNS_URI, theHwmodulesPackage);
        return theHwmodulesPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModuleDefinition() {
        return moduleDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_Id() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_Name() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModuleDefinition_Inputs() {
        return (EReference) moduleDefinitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModuleDefinition_Outputs() {
        return (EReference) moduleDefinitionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_Runtime() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_PastValueCount() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_DisplayName() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_Description() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModuleDefinition_SupportedByHardware() {
        return (EReference) moduleDefinitionEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_Category() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModuleDefinition_Parameters() {
        return (EReference) moduleDefinitionEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_GroupId() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModuleDefinition_RequireMicasVersion() {
        return (EAttribute) moduleDefinitionEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPort() {
        return portEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPort_Index() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPort_AllowedPortDataTypes() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPort_InputPort() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPort_Name() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPort_DisplayName() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPort_Description() {
        return (EAttribute) portEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPortGroup() {
        return portGroupEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPortGroup_Runtime() {
        return (EAttribute) portGroupEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMicasModules() {
        return micasModulesEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMicasModules_ModulesById() {
        return (EAttribute) micasModulesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMicasModules_ModulesByName() {
        return (EAttribute) micasModulesEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMicasModules_Modules() {
        return (EReference) micasModulesEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMicasModules_Types() {
        return (EReference) micasModulesEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getParameter() {
        return parameterEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getParameter_Name() {
        return (EAttribute) parameterEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getParameter_Value() {
        return (EAttribute) parameterEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getHardwareTypeDefinition() {
        return hardwareTypeDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getHardwareTypeDefinition_Aliases() {
        return (EReference) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_DatabaseSegment() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_DatabaseChecksumAddress() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_AddressConversionListAddress() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_HeadSegment() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_EndModuleOpcode() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_DataSegment() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_StackSegment() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_ProgramSegment() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_MaxProgramSize() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_Type() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_PastValuesOffsetFirstTask() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareTypeDefinition_MaxTaskCount() {
        return (EAttribute) hardwareTypeDefinitionEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getHardwareAlias() {
        return hardwareAliasEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHardwareAlias_Name() {
        return (EAttribute) hardwareAliasEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getPortDataType() {
        return portDataTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getHardwareType() {
        return hardwareTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HwmodulesFactory getHwmodulesFactory() {
        return (HwmodulesFactory) getEFactoryInstance();
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
        hardwareTypeDefinitionEClass = createEClass(HARDWARE_TYPE_DEFINITION);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__TYPE);
        createEReference(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__ALIASES);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__DATA_SEGMENT);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__STACK_SEGMENT);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK);
        createEAttribute(hardwareTypeDefinitionEClass, HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT);

        hardwareAliasEClass = createEClass(HARDWARE_ALIAS);
        createEAttribute(hardwareAliasEClass, HARDWARE_ALIAS__NAME);

        moduleDefinitionEClass = createEClass(MODULE_DEFINITION);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__ID);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__NAME);
        createEReference(moduleDefinitionEClass, MODULE_DEFINITION__INPUTS);
        createEReference(moduleDefinitionEClass, MODULE_DEFINITION__OUTPUTS);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__RUNTIME);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__PAST_VALUE_COUNT);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__DISPLAY_NAME);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__DESCRIPTION);
        createEReference(moduleDefinitionEClass, MODULE_DEFINITION__SUPPORTED_BY_HARDWARE);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__CATEGORY);
        createEReference(moduleDefinitionEClass, MODULE_DEFINITION__PARAMETERS);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__GROUP_ID);
        createEAttribute(moduleDefinitionEClass, MODULE_DEFINITION__REQUIRE_MICAS_VERSION);

        portEClass = createEClass(PORT);
        createEAttribute(portEClass, PORT__INDEX);
        createEAttribute(portEClass, PORT__ALLOWED_PORT_DATA_TYPES);
        createEAttribute(portEClass, PORT__INPUT_PORT);
        createEAttribute(portEClass, PORT__NAME);
        createEAttribute(portEClass, PORT__DISPLAY_NAME);
        createEAttribute(portEClass, PORT__DESCRIPTION);

        portGroupEClass = createEClass(PORT_GROUP);
        createEAttribute(portGroupEClass, PORT_GROUP__RUNTIME);

        micasModulesEClass = createEClass(MICAS_MODULES);
        createEAttribute(micasModulesEClass, MICAS_MODULES__MODULES_BY_ID);
        createEAttribute(micasModulesEClass, MICAS_MODULES__MODULES_BY_NAME);
        createEReference(micasModulesEClass, MICAS_MODULES__MODULES);
        createEReference(micasModulesEClass, MICAS_MODULES__TYPES);

        parameterEClass = createEClass(PARAMETER);
        createEAttribute(parameterEClass, PARAMETER__NAME);
        createEAttribute(parameterEClass, PARAMETER__VALUE);

        // Create enums
        hardwareTypeEEnum = createEEnum(HARDWARE_TYPE);
        portDataTypeEEnum = createEEnum(PORT_DATA_TYPE);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        portGroupEClass.getESuperTypes().add(this.getPort());

        // Initialize classes and features; add operations and parameters
        initEClass(hardwareTypeDefinitionEClass, HardwareTypeDefinition.class, "HardwareTypeDefinition", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHardwareTypeDefinition_Type(), this.getHardwareType(), "type", "UNKNOWN", 1, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHardwareTypeDefinition_Aliases(), this.getHardwareAlias(), null, "aliases", null, 0, -1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_DatabaseSegment(), ecorePackage.getEInt(), "databaseSegment", null, 0,
                1, HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_DatabaseChecksumAddress(), ecorePackage.getEInt(),
                "databaseChecksumAddress", null, 0, 1, HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_AddressConversionListAddress(), ecorePackage.getEInt(),
                "addressConversionListAddress", null, 0, 1, HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_HeadSegment(), ecorePackage.getEInt(), "headSegment", null, 0, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_EndModuleOpcode(), ecorePackage.getEInt(), "endModuleOpcode", null, 0,
                1, HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_DataSegment(), ecorePackage.getEInt(), "dataSegment", null, 0, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_StackSegment(), ecorePackage.getEInt(), "stackSegment", null, 0, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_ProgramSegment(), ecorePackage.getEInt(), "programSegment", null, 0, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_MaxProgramSize(), ecorePackage.getEInt(), "maxProgramSize", null, 0, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_PastValuesOffsetFirstTask(), ecorePackage.getEInt(),
                "pastValuesOffsetFirstTask", null, 0, 1, HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHardwareTypeDefinition_MaxTaskCount(), ecorePackage.getEInt(), "maxTaskCount", null, 0, 1,
                HardwareTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(hardwareAliasEClass, HardwareAlias.class, "HardwareAlias", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHardwareAlias_Name(), ecorePackage.getEString(), "name", null, 0, 1, HardwareAlias.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(moduleDefinitionEClass, ModuleDefinition.class, "ModuleDefinition", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getModuleDefinition_Id(), ecorePackage.getEInt(), "id", null, 0, 1, ModuleDefinition.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getModuleDefinition_Inputs(), this.getPort(), null, "inputs", null, 0, -1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getModuleDefinition_Outputs(), this.getPort(), null, "outputs", null, 0, -1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_Runtime(), ecorePackage.getELong(), "runtime", null, 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_PastValueCount(), ecorePackage.getEInt(), "pastValueCount", null, 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_DisplayName(), ecorePackage.getEString(), "displayName", "n/a", 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_Description(), ecorePackage.getEString(), "description", "n/a", 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getModuleDefinition_SupportedByHardware(), this.getHardwareAlias(), null, "supportedByHardware",
                null, 0, -1, ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_Category(), ecorePackage.getEString(), "category", "n/a", 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getModuleDefinition_Parameters(), this.getParameter(), null, "parameters", null, 0, -1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_GroupId(), ecorePackage.getEString(), "groupId", "n/a", 0, 1,
                ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getModuleDefinition_RequireMicasVersion(), ecorePackage.getEString(), "requireMicasVersion",
                "n/a", 0, 1, ModuleDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(moduleDefinitionEClass, ecorePackage.getEInt(), "getPortGroupsCount", 0, 1, IS_UNIQUE,
                IS_ORDERED);

        addEOperation(moduleDefinitionEClass, ecorePackage.getEInt(), "getPortsCount", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPort_Index(), ecorePackage.getEInt(), "index", null, 0, 1, Port.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPort_AllowedPortDataTypes(), this.getPortDataType(), "allowedPortDataTypes", null, 0, -1,
                Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getPort_InputPort(), ecorePackage.getEBoolean(), "inputPort", null, 0, 1, Port.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPort_Name(), ecorePackage.getEString(), "name", "n/a", 0, 1, Port.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPort_DisplayName(), ecorePackage.getEString(), "displayName", "n/a", 0, 1, Port.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPort_Description(), ecorePackage.getEString(), "description", "n/a", 0, 1, Port.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(portGroupEClass, PortGroup.class, "PortGroup", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPortGroup_Runtime(), ecorePackage.getELong(), "runtime", null, 0, 1, PortGroup.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(micasModulesEClass, MicasModules.class, "MicasModules", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        EGenericType g1 = createEGenericType(ecorePackage.getEMap());
        EGenericType g2 = createEGenericType(ecorePackage.getEIntegerObject());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(this.getModuleDefinition());
        g1.getETypeArguments().add(g2);
        initEAttribute(getMicasModules_ModulesById(), g1, "modulesById", null, 0, 1, MicasModules.class, IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(ecorePackage.getEString());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(this.getModuleDefinition());
        g1.getETypeArguments().add(g2);
        initEAttribute(getMicasModules_ModulesByName(), g1, "modulesByName", null, 0, 1, MicasModules.class,
                IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicasModules_Modules(), this.getModuleDefinition(), null, "modules", null, 0, -1,
                MicasModules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMicasModules_Types(), this.getHardwareTypeDefinition(), null, "types", null, 0, -1,
                MicasModules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(micasModulesEClass, this.getModuleDefinition(), "findModuleById", 0, 1, IS_UNIQUE,
                IS_ORDERED);
        addEParameter(op, ecorePackage.getEInt(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = addEOperation(micasModulesEClass, this.getModuleDefinition(), "findModuleByName", 0, 1, IS_UNIQUE,
                IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParameter_Value(), ecorePackage.getEString(), "value", null, 0, 1, Parameter.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(hardwareTypeEEnum, HardwareType.class, "HardwareType");
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.ACXX);
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.ZPXX);
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.ERXX);
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.MBXX);
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.XX20);
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.WSXX);
        addEEnumLiteral(hardwareTypeEEnum, HardwareType.UNKNOWN);

        initEEnum(portDataTypeEEnum, PortDataType.class, "PortDataType");
        addEEnumLiteral(portDataTypeEEnum, PortDataType.WORD_CONST);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.WORD_VAR);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.FLOAT_CONST);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.FLOAT_VAR);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.FGA_VALUE);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.FGA_MESSAGE_CONST);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.FGA_MEASURED_VALUE);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.FGA_ANALOG_VALUE);
        addEEnumLiteral(portDataTypeEEnum, PortDataType.DIRECT_VALUE);

        // Create resource
        createResource(eNS_URI);
    }

} // HwmodulesPackageImpl
