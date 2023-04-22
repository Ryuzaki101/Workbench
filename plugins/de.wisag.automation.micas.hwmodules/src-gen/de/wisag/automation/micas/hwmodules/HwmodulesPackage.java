/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.hwmodules.HwmodulesFactory
 * @model kind="package"
 * @generated
 */
public interface HwmodulesPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "hwmodules";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.wisag.de/automation/schema/hwmodules";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    HwmodulesPackage eINSTANCE = de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl
     * <em>Module Definition</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getModuleDefinition()
     * @generated
     */
    int MODULE_DEFINITION = 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.PortImpl <em>Port</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.impl.PortImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getPort()
     * @generated
     */
    int PORT = 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.PortGroupImpl <em>Port
     * Group</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.impl.PortGroupImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getPortGroup()
     * @generated
     */
    int PORT_GROUP = 4;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl
     * <em>Micas Modules</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getMicasModules()
     * @generated
     */
    int MICAS_MODULES = 5;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl
     * <em>Hardware Type Definition</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getHardwareTypeDefinition()
     * @generated
     */
    int HARDWARE_TYPE_DEFINITION = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__TYPE = 0;

    /**
     * The feature id for the '<em><b>Aliases</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__ALIASES = 1;

    /**
     * The feature id for the '<em><b>Database Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT = 2;

    /**
     * The feature id for the '<em><b>Database Checksum Address</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS = 3;

    /**
     * The feature id for the '<em><b>Address Conversion List Address</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS = 4;

    /**
     * The feature id for the '<em><b>Head Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT = 5;

    /**
     * The feature id for the '<em><b>End Module Opcode</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE = 6;

    /**
     * The feature id for the '<em><b>Data Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__DATA_SEGMENT = 7;

    /**
     * The feature id for the '<em><b>Stack Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__STACK_SEGMENT = 8;

    /**
     * The feature id for the '<em><b>Program Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT = 9;

    /**
     * The feature id for the '<em><b>Max Program Size</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE = 10;

    /**
     * The feature id for the '<em><b>Past Values Offset First Task</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK = 11;

    /**
     * The feature id for the '<em><b>Max Task Count</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT = 12;

    /**
     * The number of structural features of the '<em>Hardware Type
     * Definition</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_TYPE_DEFINITION_FEATURE_COUNT = 13;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.HardwareAliasImpl
     * <em>Hardware Alias</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.impl.HardwareAliasImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getHardwareAlias()
     * @generated
     */
    int HARDWARE_ALIAS = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int HARDWARE_ALIAS__NAME = 0;

    /**
     * The number of structural features of the '<em>Hardware Alias</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int HARDWARE_ALIAS_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__NAME = 1;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__INPUTS = 2;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__OUTPUTS = 3;

    /**
     * The feature id for the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__RUNTIME = 4;

    /**
     * The feature id for the '<em><b>Past Value Count</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__PAST_VALUE_COUNT = 5;

    /**
     * The feature id for the '<em><b>Display Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__DISPLAY_NAME = 6;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__DESCRIPTION = 7;

    /**
     * The feature id for the '<em><b>Supported By Hardware</b></em>' reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__SUPPORTED_BY_HARDWARE = 8;

    /**
     * The feature id for the '<em><b>Category</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__CATEGORY = 9;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__PARAMETERS = 10;

    /**
     * The feature id for the '<em><b>Group Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__GROUP_ID = 11;

    /**
     * The feature id for the '<em><b>Require Micas Version</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION__REQUIRE_MICAS_VERSION = 12;

    /**
     * The number of structural features of the '<em>Module Definition</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MODULE_DEFINITION_FEATURE_COUNT = 13;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT__INDEX = 0;

    /**
     * The feature id for the '<em><b>Allowed Port Data Types</b></em>'
     * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PORT__ALLOWED_PORT_DATA_TYPES = 1;

    /**
     * The feature id for the '<em><b>Input Port</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT__INPUT_PORT = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT__NAME = 3;

    /**
     * The feature id for the '<em><b>Display Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT__DISPLAY_NAME = 4;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT__DESCRIPTION = 5;

    /**
     * The number of structural features of the '<em>Port</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_FEATURE_COUNT = 6;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_GROUP__INDEX = PORT__INDEX;

    /**
     * The feature id for the '<em><b>Allowed Port Data Types</b></em>'
     * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PORT_GROUP__ALLOWED_PORT_DATA_TYPES = PORT__ALLOWED_PORT_DATA_TYPES;

    /**
     * The feature id for the '<em><b>Input Port</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_GROUP__INPUT_PORT = PORT__INPUT_PORT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_GROUP__NAME = PORT__NAME;

    /**
     * The feature id for the '<em><b>Display Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_GROUP__DISPLAY_NAME = PORT__DISPLAY_NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_GROUP__DESCRIPTION = PORT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PORT_GROUP__RUNTIME = PORT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Port Group</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PORT_GROUP_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Modules By Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MICAS_MODULES__MODULES_BY_ID = 0;

    /**
     * The feature id for the '<em><b>Modules By Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MICAS_MODULES__MODULES_BY_NAME = 1;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MICAS_MODULES__MODULES = 2;

    /**
     * The feature id for the '<em><b>Types</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MICAS_MODULES__TYPES = 3;

    /**
     * The number of structural features of the '<em>Micas Modules</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MICAS_MODULES_FEATURE_COUNT = 4;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.impl.ParameterImpl
     * <em>Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.impl.ParameterImpl
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getParameter()
     * @generated
     */
    int PARAMETER = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER__NAME = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER__VALUE = 1;

    /**
     * The number of structural features of the '<em>Parameter</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PARAMETER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.PortDataType <em>Port Data
     * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.PortDataType
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getPortDataType()
     * @generated
     */
    int PORT_DATA_TYPE = 8;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareType <em>Hardware
     * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.hwmodules.HardwareType
     * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getHardwareType()
     * @generated
     */
    int HARDWARE_TYPE = 7;

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition <em>Module
     * Definition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Module Definition</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition
     * @generated
     */
    EClass getModuleDefinition();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getId
     * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getId()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_Id();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getName()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_Name();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getInputs
     * <em>Inputs</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Inputs</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getInputs()
     * @see #getModuleDefinition()
     * @generated
     */
    EReference getModuleDefinition_Inputs();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getOutputs
     * <em>Outputs</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Outputs</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getOutputs()
     * @see #getModuleDefinition()
     * @generated
     */
    EReference getModuleDefinition_Outputs();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getRuntime
     * <em>Runtime</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Runtime</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getRuntime()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_Runtime();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getPastValueCount
     * <em>Past Value Count</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Past Value Count</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getPastValueCount()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_PastValueCount();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getDisplayName
     * <em>Display Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Display Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getDisplayName()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_DisplayName();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getDescription
     * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getDescription()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_Description();

    /**
     * Returns the meta object for the reference list
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getSupportedByHardware
     * <em>Supported By Hardware</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Supported By
     *         Hardware</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getSupportedByHardware()
     * @see #getModuleDefinition()
     * @generated
     */
    EReference getModuleDefinition_SupportedByHardware();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getCategory
     * <em>Category</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Category</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getCategory()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_Category();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getParameters
     * <em>Parameters</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Parameters</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getParameters()
     * @see #getModuleDefinition()
     * @generated
     */
    EReference getModuleDefinition_Parameters();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getGroupId
     * <em>Group Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Group Id</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getGroupId()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_GroupId();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getRequireMicasVersion
     * <em>Require Micas Version</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Require Micas
     *         Version</em>'.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition#getRequireMicasVersion()
     * @see #getModuleDefinition()
     * @generated
     */
    EAttribute getModuleDefinition_RequireMicasVersion();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.Port <em>Port</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Port</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port
     * @generated
     */
    EClass getPort();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Port#getIndex
     * <em>Index</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Index</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port#getIndex()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_Index();

    /**
     * Returns the meta object for the attribute list
     * '{@link de.wisag.automation.micas.hwmodules.Port#getAllowedPortDataTypes
     * <em>Allowed Port Data Types</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Allowed Port Data
     *         Types</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port#getAllowedPortDataTypes()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_AllowedPortDataTypes();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Port#isInputPort <em>Input
     * Port</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Input Port</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port#isInputPort()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_InputPort();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Port#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port#getName()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Port#getDisplayName
     * <em>Display Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Display Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port#getDisplayName()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_DisplayName();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Port#getDescription
     * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see de.wisag.automation.micas.hwmodules.Port#getDescription()
     * @see #getPort()
     * @generated
     */
    EAttribute getPort_Description();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.PortGroup <em>Port
     * Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Port Group</em>'.
     * @see de.wisag.automation.micas.hwmodules.PortGroup
     * @generated
     */
    EClass getPortGroup();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.PortGroup#getRuntime
     * <em>Runtime</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Runtime</em>'.
     * @see de.wisag.automation.micas.hwmodules.PortGroup#getRuntime()
     * @see #getPortGroup()
     * @generated
     */
    EAttribute getPortGroup_Runtime();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules <em>Micas
     * Modules</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Micas Modules</em>'.
     * @see de.wisag.automation.micas.hwmodules.MicasModules
     * @generated
     */
    EClass getMicasModules();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules#getModulesById
     * <em>Modules By Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Modules By Id</em>'.
     * @see de.wisag.automation.micas.hwmodules.MicasModules#getModulesById()
     * @see #getMicasModules()
     * @generated
     */
    EAttribute getMicasModules_ModulesById();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules#getModulesByName
     * <em>Modules By Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Modules By Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.MicasModules#getModulesByName()
     * @see #getMicasModules()
     * @generated
     */
    EAttribute getMicasModules_ModulesByName();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules#getModules
     * <em>Modules</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Modules</em>'.
     * @see de.wisag.automation.micas.hwmodules.MicasModules#getModules()
     * @see #getMicasModules()
     * @generated
     */
    EReference getMicasModules_Modules();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules#getTypes
     * <em>Types</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Types</em>'.
     * @see de.wisag.automation.micas.hwmodules.MicasModules#getTypes()
     * @see #getMicasModules()
     * @generated
     */
    EReference getMicasModules_Types();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.Parameter
     * <em>Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Parameter</em>'.
     * @see de.wisag.automation.micas.hwmodules.Parameter
     * @generated
     */
    EClass getParameter();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Parameter#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.Parameter#getName()
     * @see #getParameter()
     * @generated
     */
    EAttribute getParameter_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.Parameter#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.hwmodules.Parameter#getValue()
     * @see #getParameter()
     * @generated
     */
    EAttribute getParameter_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition
     * <em>Hardware Type Definition</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Hardware Type Definition</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition
     * @generated
     */
    EClass getHardwareTypeDefinition();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAliases
     * <em>Aliases</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Aliases</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAliases()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EReference getHardwareTypeDefinition_Aliases();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseSegment
     * <em>Database Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Database Segment</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseSegment()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_DatabaseSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseChecksumAddress
     * <em>Database Checksum Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Database Checksum
     *         Address</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseChecksumAddress()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_DatabaseChecksumAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAddressConversionListAddress
     * <em>Address Conversion List Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Address Conversion List
     *         Address</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAddressConversionListAddress()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_AddressConversionListAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getHeadSegment
     * <em>Head Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Head Segment</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getHeadSegment()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_HeadSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getEndModuleOpcode
     * <em>End Module Opcode</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>End Module Opcode</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getEndModuleOpcode()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_EndModuleOpcode();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDataSegment
     * <em>Data Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Data Segment</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDataSegment()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_DataSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getStackSegment
     * <em>Stack Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Stack Segment</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getStackSegment()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_StackSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getProgramSegment
     * <em>Program Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Program Segment</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getProgramSegment()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_ProgramSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxProgramSize
     * <em>Max Program Size</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Max Program Size</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxProgramSize()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_MaxProgramSize();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getType
     * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getType()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_Type();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getPastValuesOffsetFirstTask
     * <em>Past Values Offset First Task</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Past Values Offset First
     *         Task</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getPastValuesOffsetFirstTask()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_PastValuesOffsetFirstTask();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxTaskCount
     * <em>Max Task Count</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Max Task Count</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxTaskCount()
     * @see #getHardwareTypeDefinition()
     * @generated
     */
    EAttribute getHardwareTypeDefinition_MaxTaskCount();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.hwmodules.HardwareAlias <em>Hardware
     * Alias</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Hardware Alias</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareAlias
     * @generated
     */
    EClass getHardwareAlias();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.hwmodules.HardwareAlias#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareAlias#getName()
     * @see #getHardwareAlias()
     * @generated
     */
    EAttribute getHardwareAlias_Name();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.hwmodules.PortDataType <em>Port Data
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Port Data Type</em>'.
     * @see de.wisag.automation.micas.hwmodules.PortDataType
     * @generated
     */
    EEnum getPortDataType();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.hwmodules.HardwareType <em>Hardware
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Hardware Type</em>'.
     * @see de.wisag.automation.micas.hwmodules.HardwareType
     * @generated
     */
    EEnum getHardwareType();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    HwmodulesFactory getHwmodulesFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl
         * <em>Module Definition</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getModuleDefinition()
         * @generated
         */
        EClass MODULE_DEFINITION = eINSTANCE.getModuleDefinition();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__ID = eINSTANCE.getModuleDefinition_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__NAME = eINSTANCE.getModuleDefinition_Name();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MODULE_DEFINITION__INPUTS = eINSTANCE.getModuleDefinition_Inputs();

        /**
         * The meta object literal for the '<em><b>Outputs</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MODULE_DEFINITION__OUTPUTS = eINSTANCE.getModuleDefinition_Outputs();

        /**
         * The meta object literal for the '<em><b>Runtime</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__RUNTIME = eINSTANCE.getModuleDefinition_Runtime();

        /**
         * The meta object literal for the '<em><b>Past Value Count</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__PAST_VALUE_COUNT = eINSTANCE.getModuleDefinition_PastValueCount();

        /**
         * The meta object literal for the '<em><b>Display Name</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__DISPLAY_NAME = eINSTANCE.getModuleDefinition_DisplayName();

        /**
         * The meta object literal for the '<em><b>Description</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__DESCRIPTION = eINSTANCE.getModuleDefinition_Description();

        /**
         * The meta object literal for the '<em><b>Supported By
         * Hardware</b></em>' reference list feature. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MODULE_DEFINITION__SUPPORTED_BY_HARDWARE = eINSTANCE.getModuleDefinition_SupportedByHardware();

        /**
         * The meta object literal for the '<em><b>Category</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__CATEGORY = eINSTANCE.getModuleDefinition_Category();

        /**
         * The meta object literal for the '<em><b>Parameters</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference MODULE_DEFINITION__PARAMETERS = eINSTANCE.getModuleDefinition_Parameters();

        /**
         * The meta object literal for the '<em><b>Group Id</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__GROUP_ID = eINSTANCE.getModuleDefinition_GroupId();

        /**
         * The meta object literal for the '<em><b>Require Micas
         * Version</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute MODULE_DEFINITION__REQUIRE_MICAS_VERSION = eINSTANCE.getModuleDefinition_RequireMicasVersion();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.PortImpl
         * <em>Port</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.impl.PortImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getPort()
         * @generated
         */
        EClass PORT = eINSTANCE.getPort();

        /**
         * The meta object literal for the '<em><b>Index</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT__INDEX = eINSTANCE.getPort_Index();

        /**
         * The meta object literal for the '<em><b>Allowed Port Data
         * Types</b></em>' attribute list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT__ALLOWED_PORT_DATA_TYPES = eINSTANCE.getPort_AllowedPortDataTypes();

        /**
         * The meta object literal for the '<em><b>Input Port</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT__INPUT_PORT = eINSTANCE.getPort_InputPort();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT__NAME = eINSTANCE.getPort_Name();

        /**
         * The meta object literal for the '<em><b>Display Name</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT__DISPLAY_NAME = eINSTANCE.getPort_DisplayName();

        /**
         * The meta object literal for the '<em><b>Description</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT__DESCRIPTION = eINSTANCE.getPort_Description();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.PortGroupImpl
         * <em>Port Group</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.impl.PortGroupImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getPortGroup()
         * @generated
         */
        EClass PORT_GROUP = eINSTANCE.getPortGroup();

        /**
         * The meta object literal for the '<em><b>Runtime</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PORT_GROUP__RUNTIME = eINSTANCE.getPortGroup_Runtime();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl
         * <em>Micas Modules</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getMicasModules()
         * @generated
         */
        EClass MICAS_MODULES = eINSTANCE.getMicasModules();

        /**
         * The meta object literal for the '<em><b>Modules By Id</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MICAS_MODULES__MODULES_BY_ID = eINSTANCE.getMicasModules_ModulesById();

        /**
         * The meta object literal for the '<em><b>Modules By Name</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MICAS_MODULES__MODULES_BY_NAME = eINSTANCE.getMicasModules_ModulesByName();

        /**
         * The meta object literal for the '<em><b>Modules</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MICAS_MODULES__MODULES = eINSTANCE.getMicasModules_Modules();

        /**
         * The meta object literal for the '<em><b>Types</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MICAS_MODULES__TYPES = eINSTANCE.getMicasModules_Types();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.ParameterImpl
         * <em>Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.hwmodules.impl.ParameterImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getParameter()
         * @generated
         */
        EClass PARAMETER = eINSTANCE.getParameter();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl
         * <em>Hardware Type Definition</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getHardwareTypeDefinition()
         * @generated
         */
        EClass HARDWARE_TYPE_DEFINITION = eINSTANCE.getHardwareTypeDefinition();

        /**
         * The meta object literal for the '<em><b>Aliases</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference HARDWARE_TYPE_DEFINITION__ALIASES = eINSTANCE.getHardwareTypeDefinition_Aliases();

        /**
         * The meta object literal for the '<em><b>Database Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT = eINSTANCE.getHardwareTypeDefinition_DatabaseSegment();

        /**
         * The meta object literal for the '<em><b>Database Checksum
         * Address</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS = eINSTANCE
                .getHardwareTypeDefinition_DatabaseChecksumAddress();

        /**
         * The meta object literal for the '<em><b>Address Conversion List
         * Address</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS = eINSTANCE
                .getHardwareTypeDefinition_AddressConversionListAddress();

        /**
         * The meta object literal for the '<em><b>Head Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT = eINSTANCE.getHardwareTypeDefinition_HeadSegment();

        /**
         * The meta object literal for the '<em><b>End Module Opcode</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE = eINSTANCE.getHardwareTypeDefinition_EndModuleOpcode();

        /**
         * The meta object literal for the '<em><b>Data Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__DATA_SEGMENT = eINSTANCE.getHardwareTypeDefinition_DataSegment();

        /**
         * The meta object literal for the '<em><b>Stack Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__STACK_SEGMENT = eINSTANCE.getHardwareTypeDefinition_StackSegment();

        /**
         * The meta object literal for the '<em><b>Program Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT = eINSTANCE.getHardwareTypeDefinition_ProgramSegment();

        /**
         * The meta object literal for the '<em><b>Max Program Size</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE = eINSTANCE.getHardwareTypeDefinition_MaxProgramSize();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__TYPE = eINSTANCE.getHardwareTypeDefinition_Type();

        /**
         * The meta object literal for the '<em><b>Past Values Offset First
         * Task</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK = eINSTANCE
                .getHardwareTypeDefinition_PastValuesOffsetFirstTask();

        /**
         * The meta object literal for the '<em><b>Max Task Count</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT = eINSTANCE.getHardwareTypeDefinition_MaxTaskCount();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.impl.HardwareAliasImpl
         * <em>Hardware Alias</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.impl.HardwareAliasImpl
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getHardwareAlias()
         * @generated
         */
        EClass HARDWARE_ALIAS = eINSTANCE.getHardwareAlias();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute HARDWARE_ALIAS__NAME = eINSTANCE.getHardwareAlias_Name();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.PortDataType <em>Port
         * Data Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.PortDataType
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getPortDataType()
         * @generated
         */
        EEnum PORT_DATA_TYPE = eINSTANCE.getPortDataType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.hwmodules.HardwareType <em>Hardware
         * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.hwmodules.HardwareType
         * @see de.wisag.automation.micas.hwmodules.impl.HwmodulesPackageImpl#getHardwareType()
         * @generated
         */
        EEnum HARDWARE_TYPE = eINSTANCE.getHardwareType();

    }

} // HwmodulesPackage
