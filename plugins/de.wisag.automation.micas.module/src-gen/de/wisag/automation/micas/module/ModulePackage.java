/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.damos.dml.DMLPackage;

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
 * @see de.wisag.automation.micas.module.ModuleFactory
 * @model kind="package"
 * @generated
 */
public interface ModulePackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "module";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.wisag.de/Automation/Micas/Module";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_PREFIX = "module";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    ModulePackage eINSTANCE = de.wisag.automation.micas.module.impl.ModulePackageImpl.init();

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.ModuleImpl
     * <em>Module</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ModuleImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getModule()
     * @generated
     */
    int MODULE = 0;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__KIND = 0;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__ATTRIBUTES = 1;

    /**
     * The feature id for the '<em><b>Tasks</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__TASKS = 2;

    /**
     * The feature id for the '<em><b>Processor</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__PROCESSOR = 3;

    /**
     * The feature id for the '<em><b>Examiner</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__EXAMINER = 4;

    /**
     * The feature id for the '<em><b>Created Date</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__CREATED_DATE = 5;

    /**
     * The feature id for the '<em><b>Last Modified Date</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__LAST_MODIFIED_DATE = 6;

    /**
     * The feature id for the '<em><b>Last Install Date</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__LAST_INSTALL_DATE = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__NAME = 8;

    /**
     * The feature id for the '<em><b>Qualifier</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__QUALIFIER = 9;

    /**
     * The feature id for the '<em><b>Line Number</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__LINE_NUMBER = 10;

    /**
     * The feature id for the '<em><b>Station Number</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__STATION_NUMBER = 11;

    /**
     * The feature id for the '<em><b>Field Bus Number</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__FIELD_BUS_NUMBER = 12;

    /**
     * The feature id for the '<em><b>Page Format</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__PAGE_FORMAT = 13;

    /**
     * The feature id for the '<em><b>Page Orientation</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE__PAGE_ORIENTATION = 14;

    /**
     * The number of structural features of the '<em>Module</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MODULE_FEATURE_COUNT = 15;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.AttributeImpl
     * <em>Attribute</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.AttributeImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getAttribute()
     * @generated
     */
    int ATTRIBUTE = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ATTRIBUTE__NAME = 0;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ATTRIBUTE__DATA_TYPE = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ATTRIBUTE__DESCRIPTION = 2;

    /**
     * The number of structural features of the '<em>Attribute</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ATTRIBUTE_FEATURE_COUNT = 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.TaskImpl <em>Task</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.TaskImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getTask()
     * @generated
     */
    int TASK = 2;

    /**
     * The feature id for the '<em><b>Kind</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK__KIND = 0;

    /**
     * The feature id for the '<em><b>Cycle Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK__CYCLE_TIME = 1;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK__INDEX = 2;

    /**
     * The feature id for the '<em><b>Pages</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK__PAGES = 3;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK__MODULE = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK__NAME = 5;

    /**
     * The number of structural features of the '<em>Task</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int TASK_FEATURE_COUNT = 6;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.VariableAttributeImpl
     * <em>Variable Attribute</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.VariableAttributeImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getVariableAttribute()
     * @generated
     */
    int VARIABLE_ATTRIBUTE = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VARIABLE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VARIABLE_ATTRIBUTE__DATA_TYPE = ATTRIBUTE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VARIABLE_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The number of structural features of the '<em>Variable Attribute</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VARIABLE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.ConstantAttributeImpl
     * <em>Constant Attribute</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ConstantAttributeImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getConstantAttribute()
     * @generated
     */
    int CONSTANT_ATTRIBUTE = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT_ATTRIBUTE__DATA_TYPE = ATTRIBUTE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Constant Attribute</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.ReferenceAttributeImpl
     * <em>Reference Attribute</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ReferenceAttributeImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getReferenceAttribute()
     * @generated
     */
    int REFERENCE_ATTRIBUTE = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE__DATA_TYPE = ATTRIBUTE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Row</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE__ROW = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Column</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE__COLUMN = ATTRIBUTE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Reference Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE__REFERENCE_TYPE = ATTRIBUTE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Reference Attribute</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.ValueImpl <em>Value</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ValueImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getValue()
     * @generated
     */
    int VALUE = 6;

    /**
     * The number of structural features of the '<em>Value</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int VALUE_FEATURE_COUNT = 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.FloatValueImpl <em>Float
     * Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.FloatValueImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getFloatValue()
     * @generated
     */
    int FLOAT_VALUE = 7;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FLOAT_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Float Value</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int FLOAT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.WordValueImpl <em>Word
     * Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.WordValueImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getWordValue()
     * @generated
     */
    int WORD_VALUE = 8;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int WORD_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Word Value</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int WORD_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.AttributeSpecificationImpl
     * <em>Attribute Specification</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.AttributeSpecificationImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getAttributeSpecification()
     * @generated
     */
    int ATTRIBUTE_SPECIFICATION = 9;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ATTRIBUTE_SPECIFICATION__ATTRIBUTE = DMLPackage.SIGNAL_SPECIFICATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute
     * Specification</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ATTRIBUTE_SPECIFICATION_FEATURE_COUNT = DMLPackage.SIGNAL_SPECIFICATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.MicasDataTypeSpecificationImpl
     * <em>Micas Data Type Specification</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.MicasDataTypeSpecificationImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getMicasDataTypeSpecification()
     * @generated
     */
    int MICAS_DATA_TYPE_SPECIFICATION = 10;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MICAS_DATA_TYPE_SPECIFICATION__DATA_TYPE = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Micas Data Type
     * Specification</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int MICAS_DATA_TYPE_SPECIFICATION_FEATURE_COUNT = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.PageImpl <em>Page</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.PageImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getPage()
     * @generated
     */
    int PAGE = 11;

    /**
     * The feature id for the '<em><b>Components</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE__COMPONENTS = DMLPackage.SYSTEM__COMPONENTS;

    /**
     * The feature id for the '<em><b>Fragment Elements</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE__FRAGMENT_ELEMENTS = DMLPackage.SYSTEM__FRAGMENT_ELEMENTS;

    /**
     * The feature id for the '<em><b>Connections</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE__CONNECTIONS = DMLPackage.SYSTEM__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE__PARENT = DMLPackage.SYSTEM__PARENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE__NAME = DMLPackage.SYSTEM__NAME;

    /**
     * The feature id for the '<em><b>Task</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE__TASK = DMLPackage.SYSTEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Page</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int PAGE_FEATURE_COUNT = DMLPackage.SYSTEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.OffpageConnectorImpl
     * <em>Offpage Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.OffpageConnectorImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getOffpageConnector()
     * @generated
     */
    int OFFPAGE_CONNECTOR = 12;

    /**
     * The feature id for the '<em><b>Owning Fragment</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OFFPAGE_CONNECTOR__OWNING_FRAGMENT = DMLPackage.COMPONENT__OWNING_FRAGMENT;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OFFPAGE_CONNECTOR__INPUTS = DMLPackage.COMPONENT__INPUTS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OFFPAGE_CONNECTOR__OUTPUTS = DMLPackage.COMPONENT__OUTPUTS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OFFPAGE_CONNECTOR__NAME = DMLPackage.COMPONENT__NAME;

    /**
     * The number of structural features of the '<em>Offpage Connector</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OFFPAGE_CONNECTOR_FEATURE_COUNT = DMLPackage.COMPONENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.IncomingOffpageConnectorImpl
     * <em>Incoming Offpage Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.IncomingOffpageConnectorImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getIncomingOffpageConnector()
     * @generated
     */
    int INCOMING_OFFPAGE_CONNECTOR = 13;

    /**
     * The feature id for the '<em><b>Owning Fragment</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INCOMING_OFFPAGE_CONNECTOR__OWNING_FRAGMENT = OFFPAGE_CONNECTOR__OWNING_FRAGMENT;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INCOMING_OFFPAGE_CONNECTOR__INPUTS = OFFPAGE_CONNECTOR__INPUTS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INCOMING_OFFPAGE_CONNECTOR__OUTPUTS = OFFPAGE_CONNECTOR__OUTPUTS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INCOMING_OFFPAGE_CONNECTOR__NAME = OFFPAGE_CONNECTOR__NAME;

    /**
     * The number of structural features of the '<em>Incoming Offpage
     * Connector</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int INCOMING_OFFPAGE_CONNECTOR_FEATURE_COUNT = OFFPAGE_CONNECTOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.OutgoingOffpageConnectorImpl
     * <em>Outgoing Offpage Connector</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.OutgoingOffpageConnectorImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getOutgoingOffpageConnector()
     * @generated
     */
    int OUTGOING_OFFPAGE_CONNECTOR = 14;

    /**
     * The feature id for the '<em><b>Owning Fragment</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OUTGOING_OFFPAGE_CONNECTOR__OWNING_FRAGMENT = OFFPAGE_CONNECTOR__OWNING_FRAGMENT;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OUTGOING_OFFPAGE_CONNECTOR__INPUTS = OFFPAGE_CONNECTOR__INPUTS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OUTGOING_OFFPAGE_CONNECTOR__OUTPUTS = OFFPAGE_CONNECTOR__OUTPUTS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OUTGOING_OFFPAGE_CONNECTOR__NAME = OFFPAGE_CONNECTOR__NAME;

    /**
     * The number of structural features of the '<em>Outgoing Offpage
     * Connector</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int OUTGOING_OFFPAGE_CONNECTOR_FEATURE_COUNT = OFFPAGE_CONNECTOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.ConstantImpl
     * <em>Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ConstantImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getConstant()
     * @generated
     */
    int CONSTANT = 15;

    /**
     * The feature id for the '<em><b>Owning Fragment</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT__OWNING_FRAGMENT = DMLPackage.COMPONENT__OWNING_FRAGMENT;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT__INPUTS = DMLPackage.COMPONENT__INPUTS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT__OUTPUTS = DMLPackage.COMPONENT__OUTPUTS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT__NAME = DMLPackage.COMPONENT__NAME;

    /**
     * The number of structural features of the '<em>Constant</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int CONSTANT_FEATURE_COUNT = DMLPackage.COMPONENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.impl.ReferenceImpl
     * <em>Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ReferenceImpl
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getReference()
     * @generated
     */
    int REFERENCE = 16;

    /**
     * The feature id for the '<em><b>Owning Fragment</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE__OWNING_FRAGMENT = DMLPackage.COMPONENT__OWNING_FRAGMENT;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE__INPUTS = DMLPackage.COMPONENT__INPUTS;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE__OUTPUTS = DMLPackage.COMPONENT__OUTPUTS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE__NAME = DMLPackage.COMPONENT__NAME;

    /**
     * The number of structural features of the '<em>Reference</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int REFERENCE_FEATURE_COUNT = DMLPackage.COMPONENT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.ModuleKind <em>Kind</em>}' enum.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.ModuleKind
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getModuleKind()
     * @generated
     */
    int MODULE_KIND = 17;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.DataType <em>Data Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.DataType
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getDataType()
     * @generated
     */
    int DATA_TYPE = 18;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.ReferenceType <em>Reference
     * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.ReferenceType
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getReferenceType()
     * @generated
     */
    int REFERENCE_TYPE = 19;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.TaskKind <em>Task Kind</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.TaskKind
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getTaskKind()
     * @generated
     */
    int TASK_KIND = 20;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.PageFormat <em>Page
     * Format</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.PageFormat
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getPageFormat()
     * @generated
     */
    int PAGE_FORMAT = 21;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.module.PageOrientation <em>Page
     * Orientation</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.PageOrientation
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getPageOrientation()
     * @generated
     */
    int PAGE_ORIENTATION = 22;

    /**
     * The meta object id for the '<em>Float</em>' data type. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getFloat()
     * @generated
     */
    int FLOAT = 23;

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Module <em>Module</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Module</em>'.
     * @see de.wisag.automation.micas.module.Module
     * @generated
     */
    EClass getModule();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see de.wisag.automation.micas.module.Module#getKind()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_Kind();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.module.Module#getAttributes
     * <em>Attributes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Attributes</em>'.
     * @see de.wisag.automation.micas.module.Module#getAttributes()
     * @see #getModule()
     * @generated
     */
    EReference getModule_Attributes();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.module.Module#getTasks
     * <em>Tasks</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Tasks</em>'.
     * @see de.wisag.automation.micas.module.Module#getTasks()
     * @see #getModule()
     * @generated
     */
    EReference getModule_Tasks();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getProcessor
     * <em>Processor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Processor</em>'.
     * @see de.wisag.automation.micas.module.Module#getProcessor()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_Processor();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getExaminer
     * <em>Examiner</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Examiner</em>'.
     * @see de.wisag.automation.micas.module.Module#getExaminer()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_Examiner();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getCreatedDate
     * <em>Created Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Created Date</em>'.
     * @see de.wisag.automation.micas.module.Module#getCreatedDate()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_CreatedDate();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getLastModifiedDate
     * <em>Last Modified Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Last Modified Date</em>'.
     * @see de.wisag.automation.micas.module.Module#getLastModifiedDate()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_LastModifiedDate();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getLastInstallDate
     * <em>Last Install Date</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Last Install Date</em>'.
     * @see de.wisag.automation.micas.module.Module#getLastInstallDate()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_LastInstallDate();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.module.Module#getName()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getQualifier
     * <em>Qualifier</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Qualifier</em>'.
     * @see de.wisag.automation.micas.module.Module#getQualifier()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_Qualifier();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getLineNumber <em>Line
     * Number</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Line Number</em>'.
     * @see de.wisag.automation.micas.module.Module#getLineNumber()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_LineNumber();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getStationNumber
     * <em>Station Number</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Station Number</em>'.
     * @see de.wisag.automation.micas.module.Module#getStationNumber()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_StationNumber();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getFieldBusNumber
     * <em>Field Bus Number</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Field Bus Number</em>'.
     * @see de.wisag.automation.micas.module.Module#getFieldBusNumber()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_FieldBusNumber();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getPageFormat <em>Page
     * Format</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Page Format</em>'.
     * @see de.wisag.automation.micas.module.Module#getPageFormat()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_PageFormat();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Module#getPageOrientation
     * <em>Page Orientation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Page Orientation</em>'.
     * @see de.wisag.automation.micas.module.Module#getPageOrientation()
     * @see #getModule()
     * @generated
     */
    EAttribute getModule_PageOrientation();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Attribute</em>'.
     * @see de.wisag.automation.micas.module.Attribute
     * @generated
     */
    EClass getAttribute();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Attribute#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.module.Attribute#getName()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Attribute#getDataType <em>Data
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data Type</em>'.
     * @see de.wisag.automation.micas.module.Attribute#getDataType()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_DataType();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Attribute#getDescription
     * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see de.wisag.automation.micas.module.Attribute#getDescription()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Description();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Task <em>Task</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Task</em>'.
     * @see de.wisag.automation.micas.module.Task
     * @generated
     */
    EClass getTask();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Task#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see de.wisag.automation.micas.module.Task#getKind()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Kind();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Task#getCycleTime <em>Cycle
     * Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Cycle Time</em>'.
     * @see de.wisag.automation.micas.module.Task#getCycleTime()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_CycleTime();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Task#getIndex <em>Index</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Index</em>'.
     * @see de.wisag.automation.micas.module.Task#getIndex()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Index();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.module.Task#getPages <em>Pages</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Pages</em>'.
     * @see de.wisag.automation.micas.module.Task#getPages()
     * @see #getTask()
     * @generated
     */
    EReference getTask_Pages();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.module.Task#getModule
     * <em>Module</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Module</em>'.
     * @see de.wisag.automation.micas.module.Task#getModule()
     * @see #getTask()
     * @generated
     */
    EReference getTask_Module();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.Task#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.module.Task#getName()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Name();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.VariableAttribute <em>Variable
     * Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Variable Attribute</em>'.
     * @see de.wisag.automation.micas.module.VariableAttribute
     * @generated
     */
    EClass getVariableAttribute();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.ConstantAttribute <em>Constant
     * Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Constant Attribute</em>'.
     * @see de.wisag.automation.micas.module.ConstantAttribute
     * @generated
     */
    EClass getConstantAttribute();

    /**
     * Returns the meta object for the containment reference
     * '{@link de.wisag.automation.micas.module.ConstantAttribute#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see de.wisag.automation.micas.module.ConstantAttribute#getValue()
     * @see #getConstantAttribute()
     * @generated
     */
    EReference getConstantAttribute_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute <em>Reference
     * Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Reference Attribute</em>'.
     * @see de.wisag.automation.micas.module.ReferenceAttribute
     * @generated
     */
    EClass getReferenceAttribute();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getRow
     * <em>Row</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Row</em>'.
     * @see de.wisag.automation.micas.module.ReferenceAttribute#getRow()
     * @see #getReferenceAttribute()
     * @generated
     */
    EAttribute getReferenceAttribute_Row();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getColumn
     * <em>Column</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Column</em>'.
     * @see de.wisag.automation.micas.module.ReferenceAttribute#getColumn()
     * @see #getReferenceAttribute()
     * @generated
     */
    EAttribute getReferenceAttribute_Column();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getReferenceType
     * <em>Reference Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Reference Type</em>'.
     * @see de.wisag.automation.micas.module.ReferenceAttribute#getReferenceType()
     * @see #getReferenceAttribute()
     * @generated
     */
    EAttribute getReferenceAttribute_ReferenceType();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Value <em>Value</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Value</em>'.
     * @see de.wisag.automation.micas.module.Value
     * @generated
     */
    EClass getValue();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.FloatValue <em>Float
     * Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Float Value</em>'.
     * @see de.wisag.automation.micas.module.FloatValue
     * @generated
     */
    EClass getFloatValue();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.FloatValue#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.module.FloatValue#getValue()
     * @see #getFloatValue()
     * @generated
     */
    EAttribute getFloatValue_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.WordValue <em>Word Value</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Word Value</em>'.
     * @see de.wisag.automation.micas.module.WordValue
     * @generated
     */
    EClass getWordValue();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.WordValue#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.module.WordValue#getValue()
     * @see #getWordValue()
     * @generated
     */
    EAttribute getWordValue_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.AttributeSpecification
     * <em>Attribute Specification</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Attribute Specification</em>'.
     * @see de.wisag.automation.micas.module.AttributeSpecification
     * @generated
     */
    EClass getAttributeSpecification();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.module.AttributeSpecification#getAttribute
     * <em>Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Attribute</em>'.
     * @see de.wisag.automation.micas.module.AttributeSpecification#getAttribute()
     * @see #getAttributeSpecification()
     * @generated
     */
    EReference getAttributeSpecification_Attribute();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.MicasDataTypeSpecification
     * <em>Micas Data Type Specification</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Micas Data Type
     *         Specification</em>'.
     * @see de.wisag.automation.micas.module.MicasDataTypeSpecification
     * @generated
     */
    EClass getMicasDataTypeSpecification();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.module.MicasDataTypeSpecification#getDataType
     * <em>Data Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data Type</em>'.
     * @see de.wisag.automation.micas.module.MicasDataTypeSpecification#getDataType()
     * @see #getMicasDataTypeSpecification()
     * @generated
     */
    EAttribute getMicasDataTypeSpecification_DataType();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Page <em>Page</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Page</em>'.
     * @see de.wisag.automation.micas.module.Page
     * @generated
     */
    EClass getPage();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.module.Page#getTask <em>Task</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Task</em>'.
     * @see de.wisag.automation.micas.module.Page#getTask()
     * @see #getPage()
     * @generated
     */
    EReference getPage_Task();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.OffpageConnector <em>Offpage
     * Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Offpage Connector</em>'.
     * @see de.wisag.automation.micas.module.OffpageConnector
     * @generated
     */
    EClass getOffpageConnector();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.IncomingOffpageConnector
     * <em>Incoming Offpage Connector</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Incoming Offpage Connector</em>'.
     * @see de.wisag.automation.micas.module.IncomingOffpageConnector
     * @generated
     */
    EClass getIncomingOffpageConnector();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.OutgoingOffpageConnector
     * <em>Outgoing Offpage Connector</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Outgoing Offpage Connector</em>'.
     * @see de.wisag.automation.micas.module.OutgoingOffpageConnector
     * @generated
     */
    EClass getOutgoingOffpageConnector();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Constant <em>Constant</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Constant</em>'.
     * @see de.wisag.automation.micas.module.Constant
     * @generated
     */
    EClass getConstant();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.module.Reference <em>Reference</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Reference</em>'.
     * @see de.wisag.automation.micas.module.Reference
     * @generated
     */
    EClass getReference();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.module.ModuleKind <em>Kind</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Kind</em>'.
     * @see de.wisag.automation.micas.module.ModuleKind
     * @generated
     */
    EEnum getModuleKind();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.module.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Data Type</em>'.
     * @see de.wisag.automation.micas.module.DataType
     * @generated
     */
    EEnum getDataType();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.module.ReferenceType <em>Reference
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Reference Type</em>'.
     * @see de.wisag.automation.micas.module.ReferenceType
     * @generated
     */
    EEnum getReferenceType();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.module.TaskKind <em>Task Kind</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Task Kind</em>'.
     * @see de.wisag.automation.micas.module.TaskKind
     * @generated
     */
    EEnum getTaskKind();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.module.PageFormat <em>Page
     * Format</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Page Format</em>'.
     * @see de.wisag.automation.micas.module.PageFormat
     * @generated
     */
    EEnum getPageFormat();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.module.PageOrientation <em>Page
     * Orientation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Page Orientation</em>'.
     * @see de.wisag.automation.micas.module.PageOrientation
     * @generated
     */
    EEnum getPageOrientation();

    /**
     * Returns the meta object for data type '<em>Float</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for data type '<em>Float</em>'.
     * @model instanceClass="double"
     * @generated
     */
    EDataType getFloat();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModuleFactory getModuleFactory();

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
         * '{@link de.wisag.automation.micas.module.impl.ModuleImpl
         * <em>Module</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.module.impl.ModuleImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getModule()
         * @generated
         */
        EClass MODULE = eINSTANCE.getModule();

        /**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__KIND = eINSTANCE.getModule_Kind();

        /**
         * The meta object literal for the '<em><b>Attributes</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference MODULE__ATTRIBUTES = eINSTANCE.getModule_Attributes();

        /**
         * The meta object literal for the '<em><b>Tasks</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference MODULE__TASKS = eINSTANCE.getModule_Tasks();

        /**
         * The meta object literal for the '<em><b>Processor</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__PROCESSOR = eINSTANCE.getModule_Processor();

        /**
         * The meta object literal for the '<em><b>Examiner</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__EXAMINER = eINSTANCE.getModule_Examiner();

        /**
         * The meta object literal for the '<em><b>Created Date</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__CREATED_DATE = eINSTANCE.getModule_CreatedDate();

        /**
         * The meta object literal for the '<em><b>Last Modified Date</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__LAST_MODIFIED_DATE = eINSTANCE.getModule_LastModifiedDate();

        /**
         * The meta object literal for the '<em><b>Last Install Date</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__LAST_INSTALL_DATE = eINSTANCE.getModule_LastInstallDate();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

        /**
         * The meta object literal for the '<em><b>Qualifier</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__QUALIFIER = eINSTANCE.getModule_Qualifier();

        /**
         * The meta object literal for the '<em><b>Line Number</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__LINE_NUMBER = eINSTANCE.getModule_LineNumber();

        /**
         * The meta object literal for the '<em><b>Station Number</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__STATION_NUMBER = eINSTANCE.getModule_StationNumber();

        /**
         * The meta object literal for the '<em><b>Field Bus Number</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__FIELD_BUS_NUMBER = eINSTANCE.getModule_FieldBusNumber();

        /**
         * The meta object literal for the '<em><b>Page Format</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__PAGE_FORMAT = eINSTANCE.getModule_PageFormat();

        /**
         * The meta object literal for the '<em><b>Page Orientation</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MODULE__PAGE_ORIENTATION = eINSTANCE.getModule_PageOrientation();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.AttributeImpl
         * <em>Attribute</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.module.impl.AttributeImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getAttribute()
         * @generated
         */
        EClass ATTRIBUTE = eINSTANCE.getAttribute();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ATTRIBUTE__DATA_TYPE = eINSTANCE.getAttribute_DataType();

        /**
         * The meta object literal for the '<em><b>Description</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ATTRIBUTE__DESCRIPTION = eINSTANCE.getAttribute_Description();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.TaskImpl
         * <em>Task</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.TaskImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getTask()
         * @generated
         */
        EClass TASK = eINSTANCE.getTask();

        /**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TASK__KIND = eINSTANCE.getTask_Kind();

        /**
         * The meta object literal for the '<em><b>Cycle Time</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TASK__CYCLE_TIME = eINSTANCE.getTask_CycleTime();

        /**
         * The meta object literal for the '<em><b>Index</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TASK__INDEX = eINSTANCE.getTask_Index();

        /**
         * The meta object literal for the '<em><b>Pages</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TASK__PAGES = eINSTANCE.getTask_Pages();

        /**
         * The meta object literal for the '<em><b>Module</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference TASK__MODULE = eINSTANCE.getTask_Module();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute TASK__NAME = eINSTANCE.getTask_Name();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.VariableAttributeImpl
         * <em>Variable Attribute</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.VariableAttributeImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getVariableAttribute()
         * @generated
         */
        EClass VARIABLE_ATTRIBUTE = eINSTANCE.getVariableAttribute();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.ConstantAttributeImpl
         * <em>Constant Attribute</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.ConstantAttributeImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getConstantAttribute()
         * @generated
         */
        EClass CONSTANT_ATTRIBUTE = eINSTANCE.getConstantAttribute();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' containment
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference CONSTANT_ATTRIBUTE__VALUE = eINSTANCE.getConstantAttribute_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.ReferenceAttributeImpl
         * <em>Reference Attribute</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.ReferenceAttributeImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getReferenceAttribute()
         * @generated
         */
        EClass REFERENCE_ATTRIBUTE = eINSTANCE.getReferenceAttribute();

        /**
         * The meta object literal for the '<em><b>Row</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute REFERENCE_ATTRIBUTE__ROW = eINSTANCE.getReferenceAttribute_Row();

        /**
         * The meta object literal for the '<em><b>Column</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute REFERENCE_ATTRIBUTE__COLUMN = eINSTANCE.getReferenceAttribute_Column();

        /**
         * The meta object literal for the '<em><b>Reference Type</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute REFERENCE_ATTRIBUTE__REFERENCE_TYPE = eINSTANCE.getReferenceAttribute_ReferenceType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.ValueImpl
         * <em>Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.ValueImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getValue()
         * @generated
         */
        EClass VALUE = eINSTANCE.getValue();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.FloatValueImpl
         * <em>Float Value</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.FloatValueImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getFloatValue()
         * @generated
         */
        EClass FLOAT_VALUE = eINSTANCE.getFloatValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute FLOAT_VALUE__VALUE = eINSTANCE.getFloatValue_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.WordValueImpl <em>Word
         * Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.WordValueImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getWordValue()
         * @generated
         */
        EClass WORD_VALUE = eINSTANCE.getWordValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute WORD_VALUE__VALUE = eINSTANCE.getWordValue_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.AttributeSpecificationImpl
         * <em>Attribute Specification</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.AttributeSpecificationImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getAttributeSpecification()
         * @generated
         */
        EClass ATTRIBUTE_SPECIFICATION = eINSTANCE.getAttributeSpecification();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference ATTRIBUTE_SPECIFICATION__ATTRIBUTE = eINSTANCE.getAttributeSpecification_Attribute();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.MicasDataTypeSpecificationImpl
         * <em>Micas Data Type Specification</em>}' class. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.MicasDataTypeSpecificationImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getMicasDataTypeSpecification()
         * @generated
         */
        EClass MICAS_DATA_TYPE_SPECIFICATION = eINSTANCE.getMicasDataTypeSpecification();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute MICAS_DATA_TYPE_SPECIFICATION__DATA_TYPE = eINSTANCE.getMicasDataTypeSpecification_DataType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.PageImpl
         * <em>Page</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.PageImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getPage()
         * @generated
         */
        EClass PAGE = eINSTANCE.getPage();

        /**
         * The meta object literal for the '<em><b>Task</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference PAGE__TASK = eINSTANCE.getPage_Task();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.OffpageConnectorImpl
         * <em>Offpage Connector</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.OffpageConnectorImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getOffpageConnector()
         * @generated
         */
        EClass OFFPAGE_CONNECTOR = eINSTANCE.getOffpageConnector();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.IncomingOffpageConnectorImpl
         * <em>Incoming Offpage Connector</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.IncomingOffpageConnectorImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getIncomingOffpageConnector()
         * @generated
         */
        EClass INCOMING_OFFPAGE_CONNECTOR = eINSTANCE.getIncomingOffpageConnector();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.OutgoingOffpageConnectorImpl
         * <em>Outgoing Offpage Connector</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.OutgoingOffpageConnectorImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getOutgoingOffpageConnector()
         * @generated
         */
        EClass OUTGOING_OFFPAGE_CONNECTOR = eINSTANCE.getOutgoingOffpageConnector();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.ConstantImpl
         * <em>Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.module.impl.ConstantImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getConstant()
         * @generated
         */
        EClass CONSTANT = eINSTANCE.getConstant();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.impl.ReferenceImpl
         * <em>Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.module.impl.ReferenceImpl
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getReference()
         * @generated
         */
        EClass REFERENCE = eINSTANCE.getReference();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.ModuleKind <em>Kind</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.ModuleKind
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getModuleKind()
         * @generated
         */
        EEnum MODULE_KIND = eINSTANCE.getModuleKind();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.DataType <em>Data
         * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.DataType
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getDataType()
         * @generated
         */
        EEnum DATA_TYPE = eINSTANCE.getDataType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.ReferenceType <em>Reference
         * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.ReferenceType
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getReferenceType()
         * @generated
         */
        EEnum REFERENCE_TYPE = eINSTANCE.getReferenceType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.TaskKind <em>Task
         * Kind</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.TaskKind
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getTaskKind()
         * @generated
         */
        EEnum TASK_KIND = eINSTANCE.getTaskKind();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.PageFormat <em>Page
         * Format</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.PageFormat
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getPageFormat()
         * @generated
         */
        EEnum PAGE_FORMAT = eINSTANCE.getPageFormat();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.module.PageOrientation <em>Page
         * Orientation</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.module.PageOrientation
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getPageOrientation()
         * @generated
         */
        EEnum PAGE_ORIENTATION = eINSTANCE.getPageOrientation();

        /**
         * The meta object literal for the '<em>Float</em>' data type. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.module.impl.ModulePackageImpl#getFloat()
         * @generated
         */
        EDataType FLOAT = eINSTANCE.getFloat();

    }

} // ModulePackage
