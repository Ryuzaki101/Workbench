/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

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
 * @see de.wisag.automation.micas.rt.RtFactory
 * @model kind="package"
 * @generated
 */
public interface RtPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "rt";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.wisag.de/automation/schema/rt";

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
    RtPackage eINSTANCE = de.wisag.automation.micas.rt.impl.RtPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtModuleImpl <em>Module</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtModuleImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtModule()
     * @generated
     */
    int RT_MODULE = 0;

    /**
     * The feature id for the '<em><b>Symbols</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__SYMBOLS = 0;

    /**
     * The feature id for the '<em><b>Data Segment Address</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__DATA_SEGMENT_ADDRESS = 1;

    /**
     * The feature id for the '<em><b>Tasks</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__TASKS = 2;

    /**
     * The feature id for the '<em><b>Start Segment Address</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__START_SEGMENT_ADDRESS = 3;

    /**
     * The feature id for the '<em><b>First Task Segment Address</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS = 4;

    /**
     * The feature id for the '<em><b>Head Module Segment Address</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS = 5;

    /**
     * The feature id for the '<em><b>Data Segment Check Sum</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__DATA_SEGMENT_CHECK_SUM = 6;

    /**
     * The feature id for the '<em><b>Tasks Check Sum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__TASKS_CHECK_SUM = 7;

    /**
     * The feature id for the '<em><b>Word Const Offset</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__WORD_CONST_OFFSET = 8;

    /**
     * The feature id for the '<em><b>Float Const Offset</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__FLOAT_CONST_OFFSET = 9;

    /**
     * The feature id for the '<em><b>Word Var Offset</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__WORD_VAR_OFFSET = 10;

    /**
     * The feature id for the '<em><b>Float Var Offset</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__FLOAT_VAR_OFFSET = 11;

    /**
     * The feature id for the '<em><b>End Of Float Vars</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__END_OF_FLOAT_VARS = 12;

    /**
     * The feature id for the '<em><b>Data Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__DATA_SEGMENT = 13;

    /**
     * The feature id for the '<em><b>Hw Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__HW_TYPE = 14;

    /**
     * The feature id for the '<em><b>Field Bus</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__FIELD_BUS = 15;

    /**
     * The feature id for the '<em><b>Past Values Offset</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__PAST_VALUES_OFFSET = 16;

    /**
     * The feature id for the '<em><b>Past Values Last Offset</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__PAST_VALUES_LAST_OFFSET = 17;

    /**
     * The feature id for the '<em><b>Head Modul</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__HEAD_MODUL = 18;

    /**
     * The feature id for the '<em><b>Head Module Segment</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__HEAD_MODULE_SEGMENT = 19;

    /**
     * The feature id for the '<em><b>Source Modification Stamp</b></em>'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__SOURCE_MODIFICATION_STAMP = 20;

    /**
     * The feature id for the '<em><b>Source Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__SOURCE_NAME = 21;

    /**
     * The feature id for the '<em><b>Source Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__SOURCE_CHECKSUM = 22;

    /**
     * The feature id for the '<em><b>Comments</b></em>' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__COMMENTS = 23;

    /**
     * The feature id for the '<em><b>Start Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE__START_SEGMENT = 24;

    /**
     * The number of structural features of the '<em>Module</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_FEATURE_COUNT = 25;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtTaskImpl <em>Task</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtTaskImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtTask()
     * @generated
     */
    int RT_TASK = 1;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__MODULE = 0;

    /**
     * The feature id for the '<em><b>Module Invocations</b></em>' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__MODULE_INVOCATIONS = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__ID = 2;

    /**
     * The feature id for the '<em><b>Cycl Time</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__CYCL_TIME = 3;

    /**
     * The feature id for the '<em><b>Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__SEGMENT = 4;

    /**
     * The feature id for the '<em><b>Past Values Offset</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__PAST_VALUES_OFFSET = 5;

    /**
     * The feature id for the '<em><b>Strategy</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__STRATEGY = 6;

    /**
     * The feature id for the '<em><b>Data</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__DATA = 7;

    /**
     * The feature id for the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__RUNTIME = 8;

    /**
     * The feature id for the '<em><b>Past Values Count</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__PAST_VALUES_COUNT = 9;

    /**
     * The feature id for the '<em><b>Comment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK__COMMENT = 10;

    /**
     * The number of structural features of the '<em>Task</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK_FEATURE_COUNT = 11;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl <em>Symbol</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtSymbolImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtSymbol()
     * @generated
     */
    int RT_SYMBOL = 2;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL__ADDRESS = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL__NAME = 1;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL__MODULE = 2;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL__ACCESSORS = 3;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL__INDEX = 4;

    /**
     * The number of structural features of the '<em>Symbol</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL_FEATURE_COUNT = 5;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtConstantImpl
     * <em>Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtConstantImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtConstant()
     * @generated
     */
    int RT_CONSTANT = 3;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_CONSTANT__ADDRESS = RT_SYMBOL__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_CONSTANT__NAME = RT_SYMBOL__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_CONSTANT__MODULE = RT_SYMBOL__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_CONSTANT__ACCESSORS = RT_SYMBOL__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_CONSTANT__INDEX = RT_SYMBOL__INDEX;

    /**
     * The number of structural features of the '<em>Constant</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_CONSTANT_FEATURE_COUNT = RT_SYMBOL_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtVariableImpl
     * <em>Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtVariableImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtVariable()
     * @generated
     */
    int RT_VARIABLE = 4;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_VARIABLE__ADDRESS = RT_SYMBOL__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_VARIABLE__NAME = RT_SYMBOL__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_VARIABLE__MODULE = RT_SYMBOL__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_VARIABLE__ACCESSORS = RT_SYMBOL__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_VARIABLE__INDEX = RT_SYMBOL__INDEX;

    /**
     * The number of structural features of the '<em>Variable</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_VARIABLE_FEATURE_COUNT = RT_SYMBOL_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtWordConstantImpl <em>Word
     * Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtWordConstantImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtWordConstant()
     * @generated
     */
    int RT_WORD_CONSTANT = 5;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT__ADDRESS = RT_CONSTANT__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT__NAME = RT_CONSTANT__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT__MODULE = RT_CONSTANT__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT__ACCESSORS = RT_CONSTANT__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT__INDEX = RT_CONSTANT__INDEX;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT__VALUE = RT_CONSTANT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Word Constant</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_CONSTANT_FEATURE_COUNT = RT_CONSTANT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtFloatConstantImpl <em>Float
     * Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtFloatConstantImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtFloatConstant()
     * @generated
     */
    int RT_FLOAT_CONSTANT = 6;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT__ADDRESS = RT_CONSTANT__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT__NAME = RT_CONSTANT__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT__MODULE = RT_CONSTANT__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT__ACCESSORS = RT_CONSTANT__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT__INDEX = RT_CONSTANT__INDEX;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT__VALUE = RT_CONSTANT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Float Constant</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_CONSTANT_FEATURE_COUNT = RT_CONSTANT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtDirectValueImpl <em>Direct
     * Value</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtDirectValueImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtDirectValue()
     * @generated
     */
    int RT_DIRECT_VALUE = 7;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE__ADDRESS = RT_SYMBOL__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE__NAME = RT_SYMBOL__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE__MODULE = RT_SYMBOL__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE__ACCESSORS = RT_SYMBOL__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE__INDEX = RT_SYMBOL__INDEX;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE__VALUE = RT_SYMBOL_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Direct Value</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_DIRECT_VALUE_FEATURE_COUNT = RT_SYMBOL_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtWordVariableImpl <em>Word
     * Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtWordVariableImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtWordVariable()
     * @generated
     */
    int RT_WORD_VARIABLE = 8;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE__ADDRESS = RT_VARIABLE__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE__NAME = RT_VARIABLE__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE__MODULE = RT_VARIABLE__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE__ACCESSORS = RT_VARIABLE__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE__INDEX = RT_VARIABLE__INDEX;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE__VALUE = RT_VARIABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Word Variable</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_WORD_VARIABLE_FEATURE_COUNT = RT_VARIABLE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtFloatVariableImpl <em>Float
     * Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtFloatVariableImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtFloatVariable()
     * @generated
     */
    int RT_FLOAT_VARIABLE = 9;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE__ADDRESS = RT_VARIABLE__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE__NAME = RT_VARIABLE__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE__MODULE = RT_VARIABLE__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE__ACCESSORS = RT_VARIABLE__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE__INDEX = RT_VARIABLE__INDEX;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE__VALUE = RT_VARIABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Float Variable</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_FLOAT_VARIABLE_FEATURE_COUNT = RT_VARIABLE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl
     * <em>Module Invocation</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtModuleInvocation()
     * @generated
     */
    int RT_MODULE_INVOCATION = 10;

    /**
     * The feature id for the '<em><b>Arguments</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__ARGUMENTS = 0;

    /**
     * The feature id for the '<em><b>Task</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__TASK = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__NAME = 2;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__INDEX = 3;

    /**
     * The feature id for the '<em><b>Opcode</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__OPCODE = 4;

    /**
     * The feature id for the '<em><b>Past Values Count</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__PAST_VALUES_COUNT = 5;

    /**
     * The feature id for the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION__RUNTIME = 6;

    /**
     * The number of structural features of the '<em>Module Invocation</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_MODULE_INVOCATION_FEATURE_COUNT = 7;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtCommentModuleInvocationImpl
     * <em>Comment Module Invocation</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtCommentModuleInvocationImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtCommentModuleInvocation()
     * @generated
     */
    int RT_COMMENT_MODULE_INVOCATION = 11;

    /**
     * The feature id for the '<em><b>Arguments</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__ARGUMENTS = RT_MODULE_INVOCATION__ARGUMENTS;

    /**
     * The feature id for the '<em><b>Task</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__TASK = RT_MODULE_INVOCATION__TASK;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__NAME = RT_MODULE_INVOCATION__NAME;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__INDEX = RT_MODULE_INVOCATION__INDEX;

    /**
     * The feature id for the '<em><b>Opcode</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__OPCODE = RT_MODULE_INVOCATION__OPCODE;

    /**
     * The feature id for the '<em><b>Past Values Count</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__PAST_VALUES_COUNT = RT_MODULE_INVOCATION__PAST_VALUES_COUNT;

    /**
     * The feature id for the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__RUNTIME = RT_MODULE_INVOCATION__RUNTIME;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION__TEXT = RT_MODULE_INVOCATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Comment Module
     * Invocation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_COMMENT_MODULE_INVOCATION_FEATURE_COUNT = RT_MODULE_INVOCATION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl
     * <em>Reference Constant</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtReferenceConstant()
     * @generated
     */
    int RT_REFERENCE_CONSTANT = 12;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__ADDRESS = RT_CONSTANT__ADDRESS;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__NAME = RT_CONSTANT__NAME;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__MODULE = RT_CONSTANT__MODULE;

    /**
     * The feature id for the '<em><b>Accessors</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__ACCESSORS = RT_CONSTANT__ACCESSORS;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__INDEX = RT_CONSTANT__INDEX;

    /**
     * The feature id for the '<em><b>Col</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__COL = RT_CONSTANT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Row</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__ROW = RT_CONSTANT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT__TYPE = RT_CONSTANT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Reference Constant</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_REFERENCE_CONSTANT_FEATURE_COUNT = RT_CONSTANT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl <em>Symbol
     * Access</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtSymbolAccess()
     * @generated
     */
    int RT_SYMBOL_ACCESS = 13;

    /**
     * The feature id for the '<em><b>Symbol</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL_ACCESS__SYMBOL = 0;

    /**
     * The feature id for the '<em><b>Module Invocation</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL_ACCESS__MODULE_INVOCATION = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL_ACCESS__TYPE = 2;

    /**
     * The number of structural features of the '<em>Symbol Access</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_SYMBOL_ACCESS_FEATURE_COUNT = 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl <em>Head
     * Module</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtHeadModuleImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtHeadModule()
     * @generated
     */
    int RT_HEAD_MODULE = 14;

    /**
     * The feature id for the '<em><b>Module</b></em>' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_HEAD_MODULE__MODULE = 0;

    /**
     * The feature id for the '<em><b>Task Infos</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_HEAD_MODULE__TASK_INFOS = 1;

    /**
     * The feature id for the '<em><b>Magic0</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_HEAD_MODULE__MAGIC0 = 2;

    /**
     * The feature id for the '<em><b>Magic1</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_HEAD_MODULE__MAGIC1 = 3;

    /**
     * The feature id for the '<em><b>Task Count</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_HEAD_MODULE__TASK_COUNT = 4;

    /**
     * The number of structural features of the '<em>Head Module</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_HEAD_MODULE_FEATURE_COUNT = 5;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.impl.RtTaskInfoImpl <em>Task
     * Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.impl.RtTaskInfoImpl
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtTaskInfo()
     * @generated
     */
    int RT_TASK_INFO = 15;

    /**
     * The feature id for the '<em><b>Task</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK_INFO__TASK = 0;

    /**
     * The feature id for the '<em><b>Converted Strategy</b></em>' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK_INFO__CONVERTED_STRATEGY = 1;

    /**
     * The number of structural features of the '<em>Task Info</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RT_TASK_INFO_FEATURE_COUNT = 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.RtTaskStrategy <em>Task
     * Strategy</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.RtTaskStrategy
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtTaskStrategy()
     * @generated
     */
    int RT_TASK_STRATEGY = 16;

    /**
     * The meta object id for the '{@link de.wisag.automation.micas.rt.RtHwType
     * <em>Hw Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.RtHwType
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtHwType()
     * @generated
     */
    int RT_HW_TYPE = 17;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccessType <em>Symbol Access
     * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.rt.RtSymbolAccessType
     * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtSymbolAccessType()
     * @generated
     */
    int RT_SYMBOL_ACCESS_TYPE = 18;

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtModule <em>Module</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Module</em>'.
     * @see de.wisag.automation.micas.rt.RtModule
     * @generated
     */
    EClass getRtModule();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.rt.RtModule#getSymbols
     * <em>Symbols</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Symbols</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getSymbols()
     * @see #getRtModule()
     * @generated
     */
    EReference getRtModule_Symbols();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getDataSegmentAddress
     * <em>Data Segment Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data Segment
     *         Address</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getDataSegmentAddress()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_DataSegmentAddress();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.rt.RtModule#getTasks <em>Tasks</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Tasks</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getTasks()
     * @see #getRtModule()
     * @generated
     */
    EReference getRtModule_Tasks();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getStartSegmentAddress
     * <em>Start Segment Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Start Segment
     *         Address</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getStartSegmentAddress()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_StartSegmentAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getFirstTaskSegmentAddress
     * <em>First Task Segment Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>First Task Segment
     *         Address</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getFirstTaskSegmentAddress()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_FirstTaskSegmentAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModuleSegmentAddress
     * <em>Head Module Segment Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Head Module Segment
     *         Address</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getHeadModuleSegmentAddress()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_HeadModuleSegmentAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getDataSegmentCheckSum
     * <em>Data Segment Check Sum</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data Segment Check
     *         Sum</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getDataSegmentCheckSum()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_DataSegmentCheckSum();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getWordConstOffset <em>Word
     * Const Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Word Const Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getWordConstOffset()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_WordConstOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getFloatConstOffset
     * <em>Float Const Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Float Const Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getFloatConstOffset()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_FloatConstOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getWordVarOffset <em>Word
     * Var Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Word Var Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getWordVarOffset()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_WordVarOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getFloatVarOffset <em>Float
     * Var Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Float Var Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getFloatVarOffset()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_FloatVarOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getEndOfFloatVars <em>End
     * Of Float Vars</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>End Of Float Vars</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getEndOfFloatVars()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_EndOfFloatVars();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getDataSegment <em>Data
     * Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data Segment</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getDataSegment()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_DataSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getHwType <em>Hw
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Hw Type</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getHwType()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_HwType();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getFieldBus <em>Field
     * Bus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Field Bus</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getFieldBus()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_FieldBus();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getPastValuesOffset
     * <em>Past Values Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Past Values Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getPastValuesOffset()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_PastValuesOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getPastValuesLastOffset
     * <em>Past Values Last Offset</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Past Values Last
     *         Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getPastValuesLastOffset()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_PastValuesLastOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getTasksCheckSum <em>Tasks
     * Check Sum</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Tasks Check Sum</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getTasksCheckSum()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_TasksCheckSum();

    /**
     * Returns the meta object for the containment reference
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModul <em>Head
     * Modul</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference '<em>Head
     *         Modul</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getHeadModul()
     * @see #getRtModule()
     * @generated
     */
    EReference getRtModule_HeadModul();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModuleSegment
     * <em>Head Module Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Head Module Segment</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getHeadModuleSegment()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_HeadModuleSegment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getSourceModificationStamp
     * <em>Source Modification Stamp</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Source Modification
     *         Stamp</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getSourceModificationStamp()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_SourceModificationStamp();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getSourceName <em>Source
     * Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Source Name</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getSourceName()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_SourceName();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getSourceChecksum
     * <em>Source Checksum</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Source Checksum</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getSourceChecksum()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_SourceChecksum();

    /**
     * Returns the meta object for the attribute list
     * '{@link de.wisag.automation.micas.rt.RtModule#getComments
     * <em>Comments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute list '<em>Comments</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getComments()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_Comments();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModule#getStartSegment <em>Start
     * Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Start Segment</em>'.
     * @see de.wisag.automation.micas.rt.RtModule#getStartSegment()
     * @see #getRtModule()
     * @generated
     */
    EAttribute getRtModule_StartSegment();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtTask <em>Task</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Task</em>'.
     * @see de.wisag.automation.micas.rt.RtTask
     * @generated
     */
    EClass getRtTask();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.rt.RtTask#getModule <em>Module</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Module</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getModule()
     * @see #getRtTask()
     * @generated
     */
    EReference getRtTask_Module();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.rt.RtTask#getModuleInvocations
     * <em>Module Invocations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the containment reference list '<em>Module
     *         Invocations</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getModuleInvocations()
     * @see #getRtTask()
     * @generated
     */
    EReference getRtTask_ModuleInvocations();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getId <em>Id</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getId()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_Id();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getCyclTime <em>Cycl
     * Time</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Cycl Time</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getCyclTime()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_CyclTime();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getSegment
     * <em>Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Segment</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getSegment()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_Segment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getPastValuesOffset <em>Past
     * Values Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Past Values Offset</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getPastValuesOffset()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_PastValuesOffset();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getStrategy
     * <em>Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Strategy</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getStrategy()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_Strategy();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getData <em>Data</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getData()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_Data();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getRuntime
     * <em>Runtime</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Runtime</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getRuntime()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_Runtime();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getPastValuesCount <em>Past
     * Values Count</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Past Values Count</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getPastValuesCount()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_PastValuesCount();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTask#getComment
     * <em>Comment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Comment</em>'.
     * @see de.wisag.automation.micas.rt.RtTask#getComment()
     * @see #getRtTask()
     * @generated
     */
    EAttribute getRtTask_Comment();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtSymbol <em>Symbol</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Symbol</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbol
     * @generated
     */
    EClass getRtSymbol();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getAddress
     * <em>Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Address</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbol#getAddress()
     * @see #getRtSymbol()
     * @generated
     */
    EAttribute getRtSymbol_Address();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getName <em>Name</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbol#getName()
     * @see #getRtSymbol()
     * @generated
     */
    EAttribute getRtSymbol_Name();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getModule
     * <em>Module</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Module</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbol#getModule()
     * @see #getRtSymbol()
     * @generated
     */
    EReference getRtSymbol_Module();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getAccessors
     * <em>Accessors</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Accessors</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbol#getAccessors()
     * @see #getRtSymbol()
     * @generated
     */
    EReference getRtSymbol_Accessors();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getIndex <em>Index</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Index</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbol#getIndex()
     * @see #getRtSymbol()
     * @generated
     */
    EAttribute getRtSymbol_Index();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtConstant <em>Constant</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Constant</em>'.
     * @see de.wisag.automation.micas.rt.RtConstant
     * @generated
     */
    EClass getRtConstant();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtVariable <em>Variable</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Variable</em>'.
     * @see de.wisag.automation.micas.rt.RtVariable
     * @generated
     */
    EClass getRtVariable();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtWordConstant <em>Word
     * Constant</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Word Constant</em>'.
     * @see de.wisag.automation.micas.rt.RtWordConstant
     * @generated
     */
    EClass getRtWordConstant();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtWordConstant#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.rt.RtWordConstant#getValue()
     * @see #getRtWordConstant()
     * @generated
     */
    EAttribute getRtWordConstant_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtFloatConstant <em>Float
     * Constant</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Float Constant</em>'.
     * @see de.wisag.automation.micas.rt.RtFloatConstant
     * @generated
     */
    EClass getRtFloatConstant();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtFloatConstant#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.rt.RtFloatConstant#getValue()
     * @see #getRtFloatConstant()
     * @generated
     */
    EAttribute getRtFloatConstant_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtDirectValue <em>Direct
     * Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Direct Value</em>'.
     * @see de.wisag.automation.micas.rt.RtDirectValue
     * @generated
     */
    EClass getRtDirectValue();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtDirectValue#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.rt.RtDirectValue#getValue()
     * @see #getRtDirectValue()
     * @generated
     */
    EAttribute getRtDirectValue_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtWordVariable <em>Word
     * Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Word Variable</em>'.
     * @see de.wisag.automation.micas.rt.RtWordVariable
     * @generated
     */
    EClass getRtWordVariable();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtWordVariable#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.rt.RtWordVariable#getValue()
     * @see #getRtWordVariable()
     * @generated
     */
    EAttribute getRtWordVariable_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtFloatVariable <em>Float
     * Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Float Variable</em>'.
     * @see de.wisag.automation.micas.rt.RtFloatVariable
     * @generated
     */
    EClass getRtFloatVariable();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtFloatVariable#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.rt.RtFloatVariable#getValue()
     * @see #getRtFloatVariable()
     * @generated
     */
    EAttribute getRtFloatVariable_Value();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation <em>Module
     * Invocation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Module Invocation</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation
     * @generated
     */
    EClass getRtModuleInvocation();

    /**
     * Returns the meta object for the reference list
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getArguments
     * <em>Arguments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference list '<em>Arguments</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getArguments()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EReference getRtModuleInvocation_Arguments();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getTask
     * <em>Task</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Task</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getTask()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EReference getRtModuleInvocation_Task();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getName()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EAttribute getRtModuleInvocation_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getIndex
     * <em>Index</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Index</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getIndex()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EAttribute getRtModuleInvocation_Index();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getOpcode
     * <em>Opcode</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Opcode</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getOpcode()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EAttribute getRtModuleInvocation_Opcode();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getPastValuesCount
     * <em>Past Values Count</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Past Values Count</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getPastValuesCount()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EAttribute getRtModuleInvocation_PastValuesCount();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getRuntime
     * <em>Runtime</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Runtime</em>'.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getRuntime()
     * @see #getRtModuleInvocation()
     * @generated
     */
    EAttribute getRtModuleInvocation_Runtime();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtCommentModuleInvocation
     * <em>Comment Module Invocation</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Comment Module Invocation</em>'.
     * @see de.wisag.automation.micas.rt.RtCommentModuleInvocation
     * @generated
     */
    EClass getRtCommentModuleInvocation();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtCommentModuleInvocation#getText
     * <em>Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see de.wisag.automation.micas.rt.RtCommentModuleInvocation#getText()
     * @see #getRtCommentModuleInvocation()
     * @generated
     */
    EAttribute getRtCommentModuleInvocation_Text();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant <em>Reference
     * Constant</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Reference Constant</em>'.
     * @see de.wisag.automation.micas.rt.RtReferenceConstant
     * @generated
     */
    EClass getRtReferenceConstant();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant#getCol
     * <em>Col</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Col</em>'.
     * @see de.wisag.automation.micas.rt.RtReferenceConstant#getCol()
     * @see #getRtReferenceConstant()
     * @generated
     */
    EAttribute getRtReferenceConstant_Col();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant#getRow
     * <em>Row</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Row</em>'.
     * @see de.wisag.automation.micas.rt.RtReferenceConstant#getRow()
     * @see #getRtReferenceConstant()
     * @generated
     */
    EAttribute getRtReferenceConstant_Row();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant#getType
     * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see de.wisag.automation.micas.rt.RtReferenceConstant#getType()
     * @see #getRtReferenceConstant()
     * @generated
     */
    EAttribute getRtReferenceConstant_Type();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess <em>Symbol
     * Access</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Symbol Access</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbolAccess
     * @generated
     */
    EClass getRtSymbolAccess();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getSymbol
     * <em>Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Symbol</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbolAccess#getSymbol()
     * @see #getRtSymbolAccess()
     * @generated
     */
    EReference getRtSymbolAccess_Symbol();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getModuleInvocation
     * <em>Module Invocation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the reference '<em>Module Invocation</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbolAccess#getModuleInvocation()
     * @see #getRtSymbolAccess()
     * @generated
     */
    EReference getRtSymbolAccess_ModuleInvocation();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getType
     * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbolAccess#getType()
     * @see #getRtSymbolAccess()
     * @generated
     */
    EAttribute getRtSymbolAccess_Type();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtHeadModule <em>Head Module</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Head Module</em>'.
     * @see de.wisag.automation.micas.rt.RtHeadModule
     * @generated
     */
    EClass getRtHeadModule();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getModule
     * <em>Module</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the container reference '<em>Module</em>'.
     * @see de.wisag.automation.micas.rt.RtHeadModule#getModule()
     * @see #getRtHeadModule()
     * @generated
     */
    EReference getRtHeadModule_Module();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getTaskInfos <em>Task
     * Infos</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list '<em>Task
     *         Infos</em>'.
     * @see de.wisag.automation.micas.rt.RtHeadModule#getTaskInfos()
     * @see #getRtHeadModule()
     * @generated
     */
    EReference getRtHeadModule_TaskInfos();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getMagic0
     * <em>Magic0</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Magic0</em>'.
     * @see de.wisag.automation.micas.rt.RtHeadModule#getMagic0()
     * @see #getRtHeadModule()
     * @generated
     */
    EAttribute getRtHeadModule_Magic0();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getMagic1
     * <em>Magic1</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Magic1</em>'.
     * @see de.wisag.automation.micas.rt.RtHeadModule#getMagic1()
     * @see #getRtHeadModule()
     * @generated
     */
    EAttribute getRtHeadModule_Magic1();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getTaskCount <em>Task
     * Count</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Task Count</em>'.
     * @see de.wisag.automation.micas.rt.RtHeadModule#getTaskCount()
     * @see #getRtHeadModule()
     * @generated
     */
    EAttribute getRtHeadModule_TaskCount();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.rt.RtTaskInfo <em>Task Info</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Task Info</em>'.
     * @see de.wisag.automation.micas.rt.RtTaskInfo
     * @generated
     */
    EClass getRtTaskInfo();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.rt.RtTaskInfo#getTask <em>Task</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the reference '<em>Task</em>'.
     * @see de.wisag.automation.micas.rt.RtTaskInfo#getTask()
     * @see #getRtTaskInfo()
     * @generated
     */
    EReference getRtTaskInfo_Task();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.rt.RtTaskInfo#getConvertedStrategy
     * <em>Converted Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the meta object for the attribute '<em>Converted Strategy</em>'.
     * @see de.wisag.automation.micas.rt.RtTaskInfo#getConvertedStrategy()
     * @see #getRtTaskInfo()
     * @generated
     */
    EAttribute getRtTaskInfo_ConvertedStrategy();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.rt.RtTaskStrategy <em>Task
     * Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Task Strategy</em>'.
     * @see de.wisag.automation.micas.rt.RtTaskStrategy
     * @generated
     */
    EEnum getRtTaskStrategy();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.rt.RtHwType <em>Hw Type</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Hw Type</em>'.
     * @see de.wisag.automation.micas.rt.RtHwType
     * @generated
     */
    EEnum getRtHwType();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccessType <em>Symbol Access
     * Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Symbol Access Type</em>'.
     * @see de.wisag.automation.micas.rt.RtSymbolAccessType
     * @generated
     */
    EEnum getRtSymbolAccessType();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RtFactory getRtFactory();

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
         * '{@link de.wisag.automation.micas.rt.impl.RtModuleImpl
         * <em>Module</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtModuleImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtModule()
         * @generated
         */
        EClass RT_MODULE = eINSTANCE.getRtModule();

        /**
         * The meta object literal for the '<em><b>Symbols</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_MODULE__SYMBOLS = eINSTANCE.getRtModule_Symbols();

        /**
         * The meta object literal for the '<em><b>Data Segment
         * Address</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__DATA_SEGMENT_ADDRESS = eINSTANCE.getRtModule_DataSegmentAddress();

        /**
         * The meta object literal for the '<em><b>Tasks</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_MODULE__TASKS = eINSTANCE.getRtModule_Tasks();

        /**
         * The meta object literal for the '<em><b>Start Segment
         * Address</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__START_SEGMENT_ADDRESS = eINSTANCE.getRtModule_StartSegmentAddress();

        /**
         * The meta object literal for the '<em><b>First Task Segment
         * Address</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS = eINSTANCE.getRtModule_FirstTaskSegmentAddress();

        /**
         * The meta object literal for the '<em><b>Head Module Segment
         * Address</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS = eINSTANCE.getRtModule_HeadModuleSegmentAddress();

        /**
         * The meta object literal for the '<em><b>Data Segment Check
         * Sum</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__DATA_SEGMENT_CHECK_SUM = eINSTANCE.getRtModule_DataSegmentCheckSum();

        /**
         * The meta object literal for the '<em><b>Word Const Offset</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__WORD_CONST_OFFSET = eINSTANCE.getRtModule_WordConstOffset();

        /**
         * The meta object literal for the '<em><b>Float Const Offset</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__FLOAT_CONST_OFFSET = eINSTANCE.getRtModule_FloatConstOffset();

        /**
         * The meta object literal for the '<em><b>Word Var Offset</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__WORD_VAR_OFFSET = eINSTANCE.getRtModule_WordVarOffset();

        /**
         * The meta object literal for the '<em><b>Float Var Offset</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__FLOAT_VAR_OFFSET = eINSTANCE.getRtModule_FloatVarOffset();

        /**
         * The meta object literal for the '<em><b>End Of Float Vars</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__END_OF_FLOAT_VARS = eINSTANCE.getRtModule_EndOfFloatVars();

        /**
         * The meta object literal for the '<em><b>Data Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__DATA_SEGMENT = eINSTANCE.getRtModule_DataSegment();

        /**
         * The meta object literal for the '<em><b>Hw Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__HW_TYPE = eINSTANCE.getRtModule_HwType();

        /**
         * The meta object literal for the '<em><b>Field Bus</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__FIELD_BUS = eINSTANCE.getRtModule_FieldBus();

        /**
         * The meta object literal for the '<em><b>Past Values Offset</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__PAST_VALUES_OFFSET = eINSTANCE.getRtModule_PastValuesOffset();

        /**
         * The meta object literal for the '<em><b>Past Values Last
         * Offset</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__PAST_VALUES_LAST_OFFSET = eINSTANCE.getRtModule_PastValuesLastOffset();

        /**
         * The meta object literal for the '<em><b>Tasks Check Sum</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__TASKS_CHECK_SUM = eINSTANCE.getRtModule_TasksCheckSum();

        /**
         * The meta object literal for the '<em><b>Head Modul</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference RT_MODULE__HEAD_MODUL = eINSTANCE.getRtModule_HeadModul();

        /**
         * The meta object literal for the '<em><b>Head Module Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__HEAD_MODULE_SEGMENT = eINSTANCE.getRtModule_HeadModuleSegment();

        /**
         * The meta object literal for the '<em><b>Source Modification
         * Stamp</b></em>' attribute feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__SOURCE_MODIFICATION_STAMP = eINSTANCE.getRtModule_SourceModificationStamp();

        /**
         * The meta object literal for the '<em><b>Source Name</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__SOURCE_NAME = eINSTANCE.getRtModule_SourceName();

        /**
         * The meta object literal for the '<em><b>Source Checksum</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__SOURCE_CHECKSUM = eINSTANCE.getRtModule_SourceChecksum();

        /**
         * The meta object literal for the '<em><b>Comments</b></em>' attribute
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__COMMENTS = eINSTANCE.getRtModule_Comments();

        /**
         * The meta object literal for the '<em><b>Start Segment</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE__START_SEGMENT = eINSTANCE.getRtModule_StartSegment();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtTaskImpl <em>Task</em>}'
         * class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtTaskImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtTask()
         * @generated
         */
        EClass RT_TASK = eINSTANCE.getRtTask();

        /**
         * The meta object literal for the '<em><b>Module</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_TASK__MODULE = eINSTANCE.getRtTask_Module();

        /**
         * The meta object literal for the '<em><b>Module Invocations</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference RT_TASK__MODULE_INVOCATIONS = eINSTANCE.getRtTask_ModuleInvocations();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__ID = eINSTANCE.getRtTask_Id();

        /**
         * The meta object literal for the '<em><b>Cycl Time</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__CYCL_TIME = eINSTANCE.getRtTask_CyclTime();

        /**
         * The meta object literal for the '<em><b>Segment</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__SEGMENT = eINSTANCE.getRtTask_Segment();

        /**
         * The meta object literal for the '<em><b>Past Values Offset</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__PAST_VALUES_OFFSET = eINSTANCE.getRtTask_PastValuesOffset();

        /**
         * The meta object literal for the '<em><b>Strategy</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__STRATEGY = eINSTANCE.getRtTask_Strategy();

        /**
         * The meta object literal for the '<em><b>Data</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__DATA = eINSTANCE.getRtTask_Data();

        /**
         * The meta object literal for the '<em><b>Runtime</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__RUNTIME = eINSTANCE.getRtTask_Runtime();

        /**
         * The meta object literal for the '<em><b>Past Values Count</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__PAST_VALUES_COUNT = eINSTANCE.getRtTask_PastValuesCount();

        /**
         * The meta object literal for the '<em><b>Comment</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK__COMMENT = eINSTANCE.getRtTask_Comment();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl
         * <em>Symbol</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtSymbolImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtSymbol()
         * @generated
         */
        EClass RT_SYMBOL = eINSTANCE.getRtSymbol();

        /**
         * The meta object literal for the '<em><b>Address</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_SYMBOL__ADDRESS = eINSTANCE.getRtSymbol_Address();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_SYMBOL__NAME = eINSTANCE.getRtSymbol_Name();

        /**
         * The meta object literal for the '<em><b>Module</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_SYMBOL__MODULE = eINSTANCE.getRtSymbol_Module();

        /**
         * The meta object literal for the '<em><b>Accessors</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference RT_SYMBOL__ACCESSORS = eINSTANCE.getRtSymbol_Accessors();

        /**
         * The meta object literal for the '<em><b>Index</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_SYMBOL__INDEX = eINSTANCE.getRtSymbol_Index();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtConstantImpl
         * <em>Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtConstantImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtConstant()
         * @generated
         */
        EClass RT_CONSTANT = eINSTANCE.getRtConstant();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtVariableImpl
         * <em>Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtVariableImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtVariable()
         * @generated
         */
        EClass RT_VARIABLE = eINSTANCE.getRtVariable();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtWordConstantImpl <em>Word
         * Constant</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtWordConstantImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtWordConstant()
         * @generated
         */
        EClass RT_WORD_CONSTANT = eINSTANCE.getRtWordConstant();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_WORD_CONSTANT__VALUE = eINSTANCE.getRtWordConstant_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtFloatConstantImpl
         * <em>Float Constant</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtFloatConstantImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtFloatConstant()
         * @generated
         */
        EClass RT_FLOAT_CONSTANT = eINSTANCE.getRtFloatConstant();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_FLOAT_CONSTANT__VALUE = eINSTANCE.getRtFloatConstant_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtDirectValueImpl
         * <em>Direct Value</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtDirectValueImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtDirectValue()
         * @generated
         */
        EClass RT_DIRECT_VALUE = eINSTANCE.getRtDirectValue();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_DIRECT_VALUE__VALUE = eINSTANCE.getRtDirectValue_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtWordVariableImpl <em>Word
         * Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtWordVariableImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtWordVariable()
         * @generated
         */
        EClass RT_WORD_VARIABLE = eINSTANCE.getRtWordVariable();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_WORD_VARIABLE__VALUE = eINSTANCE.getRtWordVariable_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtFloatVariableImpl
         * <em>Float Variable</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtFloatVariableImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtFloatVariable()
         * @generated
         */
        EClass RT_FLOAT_VARIABLE = eINSTANCE.getRtFloatVariable();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_FLOAT_VARIABLE__VALUE = eINSTANCE.getRtFloatVariable_Value();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl
         * <em>Module Invocation</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtModuleInvocation()
         * @generated
         */
        EClass RT_MODULE_INVOCATION = eINSTANCE.getRtModuleInvocation();

        /**
         * The meta object literal for the '<em><b>Arguments</b></em>' reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_MODULE_INVOCATION__ARGUMENTS = eINSTANCE.getRtModuleInvocation_Arguments();

        /**
         * The meta object literal for the '<em><b>Task</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_MODULE_INVOCATION__TASK = eINSTANCE.getRtModuleInvocation_Task();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE_INVOCATION__NAME = eINSTANCE.getRtModuleInvocation_Name();

        /**
         * The meta object literal for the '<em><b>Index</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE_INVOCATION__INDEX = eINSTANCE.getRtModuleInvocation_Index();

        /**
         * The meta object literal for the '<em><b>Opcode</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE_INVOCATION__OPCODE = eINSTANCE.getRtModuleInvocation_Opcode();

        /**
         * The meta object literal for the '<em><b>Past Values Count</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE_INVOCATION__PAST_VALUES_COUNT = eINSTANCE.getRtModuleInvocation_PastValuesCount();

        /**
         * The meta object literal for the '<em><b>Runtime</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_MODULE_INVOCATION__RUNTIME = eINSTANCE.getRtModuleInvocation_Runtime();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtCommentModuleInvocationImpl
         * <em>Comment Module Invocation</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtCommentModuleInvocationImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtCommentModuleInvocation()
         * @generated
         */
        EClass RT_COMMENT_MODULE_INVOCATION = eINSTANCE.getRtCommentModuleInvocation();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_COMMENT_MODULE_INVOCATION__TEXT = eINSTANCE.getRtCommentModuleInvocation_Text();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl
         * <em>Reference Constant</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtReferenceConstant()
         * @generated
         */
        EClass RT_REFERENCE_CONSTANT = eINSTANCE.getRtReferenceConstant();

        /**
         * The meta object literal for the '<em><b>Col</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_REFERENCE_CONSTANT__COL = eINSTANCE.getRtReferenceConstant_Col();

        /**
         * The meta object literal for the '<em><b>Row</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_REFERENCE_CONSTANT__ROW = eINSTANCE.getRtReferenceConstant_Row();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_REFERENCE_CONSTANT__TYPE = eINSTANCE.getRtReferenceConstant_Type();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl
         * <em>Symbol Access</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtSymbolAccess()
         * @generated
         */
        EClass RT_SYMBOL_ACCESS = eINSTANCE.getRtSymbolAccess();

        /**
         * The meta object literal for the '<em><b>Symbol</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_SYMBOL_ACCESS__SYMBOL = eINSTANCE.getRtSymbolAccess_Symbol();

        /**
         * The meta object literal for the '<em><b>Module Invocation</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_SYMBOL_ACCESS__MODULE_INVOCATION = eINSTANCE.getRtSymbolAccess_ModuleInvocation();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_SYMBOL_ACCESS__TYPE = eINSTANCE.getRtSymbolAccess_Type();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl <em>Head
         * Module</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtHeadModuleImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtHeadModule()
         * @generated
         */
        EClass RT_HEAD_MODULE = eINSTANCE.getRtHeadModule();

        /**
         * The meta object literal for the '<em><b>Module</b></em>' container
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_HEAD_MODULE__MODULE = eINSTANCE.getRtHeadModule_Module();

        /**
         * The meta object literal for the '<em><b>Task Infos</b></em>'
         * containment reference list feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @generated
         */
        EReference RT_HEAD_MODULE__TASK_INFOS = eINSTANCE.getRtHeadModule_TaskInfos();

        /**
         * The meta object literal for the '<em><b>Magic0</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_HEAD_MODULE__MAGIC0 = eINSTANCE.getRtHeadModule_Magic0();

        /**
         * The meta object literal for the '<em><b>Magic1</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_HEAD_MODULE__MAGIC1 = eINSTANCE.getRtHeadModule_Magic1();

        /**
         * The meta object literal for the '<em><b>Task Count</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_HEAD_MODULE__TASK_COUNT = eINSTANCE.getRtHeadModule_TaskCount();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.impl.RtTaskInfoImpl <em>Task
         * Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.impl.RtTaskInfoImpl
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtTaskInfo()
         * @generated
         */
        EClass RT_TASK_INFO = eINSTANCE.getRtTaskInfo();

        /**
         * The meta object literal for the '<em><b>Task</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference RT_TASK_INFO__TASK = eINSTANCE.getRtTaskInfo_Task();

        /**
         * The meta object literal for the '<em><b>Converted Strategy</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RT_TASK_INFO__CONVERTED_STRATEGY = eINSTANCE.getRtTaskInfo_ConvertedStrategy();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.RtTaskStrategy <em>Task
         * Strategy</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.RtTaskStrategy
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtTaskStrategy()
         * @generated
         */
        EEnum RT_TASK_STRATEGY = eINSTANCE.getRtTaskStrategy();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.RtHwType <em>Hw Type</em>}'
         * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.rt.RtHwType
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtHwType()
         * @generated
         */
        EEnum RT_HW_TYPE = eINSTANCE.getRtHwType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.rt.RtSymbolAccessType <em>Symbol
         * Access Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.rt.RtSymbolAccessType
         * @see de.wisag.automation.micas.rt.impl.RtPackageImpl#getRtSymbolAccessType()
         * @generated
         */
        EEnum RT_SYMBOL_ACCESS_TYPE = eINSTANCE.getRtSymbolAccessType();

    }

} // RtPackage
