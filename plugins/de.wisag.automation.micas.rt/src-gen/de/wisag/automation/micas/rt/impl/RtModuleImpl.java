/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtHeadModule;
import de.wisag.automation.micas.rt.RtHwType;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getSymbols
 * <em>Symbols</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getDataSegmentAddress
 * <em>Data Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getTasks
 * <em>Tasks</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getStartSegmentAddress
 * <em>Start Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getFirstTaskSegmentAddress
 * <em>First Task Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getHeadModuleSegmentAddress
 * <em>Head Module Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getDataSegmentCheckSum
 * <em>Data Segment Check Sum</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getTasksCheckSum
 * <em>Tasks Check Sum</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getWordConstOffset
 * <em>Word Const Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getFloatConstOffset
 * <em>Float Const Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getWordVarOffset
 * <em>Word Var Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getFloatVarOffset
 * <em>Float Var Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getEndOfFloatVars
 * <em>End Of Float Vars</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getDataSegment
 * <em>Data Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getHwType <em>Hw
 * Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getFieldBus
 * <em>Field Bus</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getPastValuesOffset
 * <em>Past Values Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getPastValuesLastOffset
 * <em>Past Values Last Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getHeadModul
 * <em>Head Modul</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getHeadModuleSegment
 * <em>Head Module Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getSourceModificationStamp
 * <em>Source Modification Stamp</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getSourceName
 * <em>Source Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getSourceChecksum
 * <em>Source Checksum</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getComments
 * <em>Comments</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleImpl#getStartSegment
 * <em>Start Segment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtModuleImpl extends EObjectImpl implements RtModule {
    /**
     * The cached value of the '{@link #getSymbols() <em>Symbols</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSymbols()
     * @generated
     * @ordered
     */
    protected EList<RtSymbol> symbols;

    /**
     * The default value of the '{@link #getDataSegmentAddress() <em>Data
     * Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDataSegmentAddress()
     * @generated
     * @ordered
     */
    protected static final int DATA_SEGMENT_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDataSegmentAddress() <em>Data Segment
     * Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDataSegmentAddress()
     * @generated
     * @ordered
     */
    protected int dataSegmentAddress = DATA_SEGMENT_ADDRESS_EDEFAULT;

    /**
     * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTasks()
     * @generated
     * @ordered
     */
    protected EList<RtTask> tasks;

    /**
     * The default value of the '{@link #getStartSegmentAddress() <em>Start
     * Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getStartSegmentAddress()
     * @generated
     * @ordered
     */
    protected static final int START_SEGMENT_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStartSegmentAddress() <em>Start
     * Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getStartSegmentAddress()
     * @generated
     * @ordered
     */
    protected int startSegmentAddress = START_SEGMENT_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getFirstTaskSegmentAddress() <em>First
     * Task Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getFirstTaskSegmentAddress()
     * @generated
     * @ordered
     */
    protected static final int FIRST_TASK_SEGMENT_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getFirstTaskSegmentAddress() <em>First
     * Task Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getFirstTaskSegmentAddress()
     * @generated
     * @ordered
     */
    protected int firstTaskSegmentAddress = FIRST_TASK_SEGMENT_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getHeadModuleSegmentAddress() <em>Head
     * Module Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getHeadModuleSegmentAddress()
     * @generated
     * @ordered
     */
    protected static final int HEAD_MODULE_SEGMENT_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getHeadModuleSegmentAddress() <em>Head
     * Module Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getHeadModuleSegmentAddress()
     * @generated
     * @ordered
     */
    protected int headModuleSegmentAddress = HEAD_MODULE_SEGMENT_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getDataSegmentCheckSum() <em>Data
     * Segment Check Sum</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDataSegmentCheckSum()
     * @generated
     * @ordered
     */
    protected static final int DATA_SEGMENT_CHECK_SUM_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getDataSegmentCheckSum() <em>Data
     * Segment Check Sum</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDataSegmentCheckSum()
     * @generated
     * @ordered
     */
    protected int dataSegmentCheckSum = DATA_SEGMENT_CHECK_SUM_EDEFAULT;

    /**
     * The default value of the '{@link #getTasksCheckSum() <em>Tasks Check
     * Sum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTasksCheckSum()
     * @generated
     * @ordered
     */
    protected static final int TASKS_CHECK_SUM_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getTasksCheckSum() <em>Tasks Check
     * Sum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTasksCheckSum()
     * @generated
     * @ordered
     */
    protected int tasksCheckSum = TASKS_CHECK_SUM_EDEFAULT;

    /**
     * The default value of the '{@link #getWordConstOffset() <em>Word Const
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getWordConstOffset()
     * @generated
     * @ordered
     */
    protected static final int WORD_CONST_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getWordConstOffset() <em>Word Const
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getWordConstOffset()
     * @generated
     * @ordered
     */
    protected int wordConstOffset = WORD_CONST_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getFloatConstOffset() <em>Float Const
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFloatConstOffset()
     * @generated
     * @ordered
     */
    protected static final int FLOAT_CONST_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getFloatConstOffset() <em>Float Const
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFloatConstOffset()
     * @generated
     * @ordered
     */
    protected int floatConstOffset = FLOAT_CONST_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getWordVarOffset() <em>Word Var
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getWordVarOffset()
     * @generated
     * @ordered
     */
    protected static final int WORD_VAR_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getWordVarOffset() <em>Word Var
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getWordVarOffset()
     * @generated
     * @ordered
     */
    protected int wordVarOffset = WORD_VAR_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getFloatVarOffset() <em>Float Var
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFloatVarOffset()
     * @generated
     * @ordered
     */
    protected static final int FLOAT_VAR_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getFloatVarOffset() <em>Float Var
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFloatVarOffset()
     * @generated
     * @ordered
     */
    protected int floatVarOffset = FLOAT_VAR_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getEndOfFloatVars() <em>End Of Float
     * Vars</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getEndOfFloatVars()
     * @generated
     * @ordered
     */
    protected static final int END_OF_FLOAT_VARS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getEndOfFloatVars() <em>End Of Float
     * Vars</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getEndOfFloatVars()
     * @generated
     * @ordered
     */
    protected int endOfFloatVars = END_OF_FLOAT_VARS_EDEFAULT;

    /**
     * The default value of the '{@link #getDataSegment() <em>Data
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDataSegment()
     * @generated
     * @ordered
     */
    protected static final byte[] DATA_SEGMENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDataSegment() <em>Data Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDataSegment()
     * @generated
     * @ordered
     */
    protected byte[] dataSegment = DATA_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getHwType() <em>Hw Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHwType()
     * @generated
     * @ordered
     */
    protected static final RtHwType HW_TYPE_EDEFAULT = RtHwType.AC40;

    /**
     * The cached value of the '{@link #getHwType() <em>Hw Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHwType()
     * @generated
     * @ordered
     */
    protected RtHwType hwType = HW_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getFieldBus() <em>Field Bus</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFieldBus()
     * @generated
     * @ordered
     */
    protected static final int FIELD_BUS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getFieldBus() <em>Field Bus</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFieldBus()
     * @generated
     * @ordered
     */
    protected int fieldBus = FIELD_BUS_EDEFAULT;

    /**
     * The default value of the '{@link #getPastValuesOffset() <em>Past Values
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesOffset()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUES_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPastValuesOffset() <em>Past Values
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesOffset()
     * @generated
     * @ordered
     */
    protected int pastValuesOffset = PAST_VALUES_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getPastValuesLastOffset() <em>Past
     * Values Last Offset</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getPastValuesLastOffset()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUES_LAST_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPastValuesLastOffset() <em>Past
     * Values Last Offset</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getPastValuesLastOffset()
     * @generated
     * @ordered
     */
    protected int pastValuesLastOffset = PAST_VALUES_LAST_OFFSET_EDEFAULT;

    /**
     * The cached value of the '{@link #getHeadModul() <em>Head Modul</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHeadModul()
     * @generated
     * @ordered
     */
    protected RtHeadModule headModul;

    /**
     * The default value of the '{@link #getHeadModuleSegment() <em>Head Module
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHeadModuleSegment()
     * @generated
     * @ordered
     */
    protected static final byte[] HEAD_MODULE_SEGMENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHeadModuleSegment() <em>Head Module
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getHeadModuleSegment()
     * @generated
     * @ordered
     */
    protected byte[] headModuleSegment = HEAD_MODULE_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getSourceModificationStamp() <em>Source
     * Modification Stamp</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getSourceModificationStamp()
     * @generated
     * @ordered
     */
    protected static final long SOURCE_MODIFICATION_STAMP_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getSourceModificationStamp() <em>Source
     * Modification Stamp</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getSourceModificationStamp()
     * @generated
     * @ordered
     */
    protected long sourceModificationStamp = SOURCE_MODIFICATION_STAMP_EDEFAULT;

    /**
     * The default value of the '{@link #getSourceName() <em>Source Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSourceName()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceName() <em>Source Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSourceName()
     * @generated
     * @ordered
     */
    protected String sourceName = SOURCE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getSourceChecksum() <em>Source
     * Checksum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSourceChecksum()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_CHECKSUM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceChecksum() <em>Source
     * Checksum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSourceChecksum()
     * @generated
     * @ordered
     */
    protected String sourceChecksum = SOURCE_CHECKSUM_EDEFAULT;

    /**
     * The cached value of the '{@link #getComments() <em>Comments</em>}'
     * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComments()
     * @generated
     * @ordered
     */
    protected EList<String> comments;

    /**
     * The default value of the '{@link #getStartSegment() <em>Start
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStartSegment()
     * @generated
     * @ordered
     */
    protected static final byte[] START_SEGMENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStartSegment() <em>Start
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStartSegment()
     * @generated
     * @ordered
     */
    protected byte[] startSegment = START_SEGMENT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtModuleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_MODULE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtSymbol> getSymbols() {
        if (symbols == null) {
            symbols = new EObjectContainmentWithInverseEList<>(RtSymbol.class, this, RtPackage.RT_MODULE__SYMBOLS,
                    RtPackage.RT_SYMBOL__MODULE);
        }
        return symbols;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getDataSegmentAddress() {
        return dataSegmentAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSegmentAddress(int newDataSegmentAddress) {
        int oldDataSegmentAddress = dataSegmentAddress;
        dataSegmentAddress = newDataSegmentAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__DATA_SEGMENT_ADDRESS,
                    oldDataSegmentAddress, dataSegmentAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtTask> getTasks() {
        if (tasks == null) {
            tasks = new EObjectContainmentWithInverseEList<>(RtTask.class, this, RtPackage.RT_MODULE__TASKS,
                    RtPackage.RT_TASK__MODULE);
        }
        return tasks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getStartSegmentAddress() {
        return startSegmentAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStartSegmentAddress(int newStartSegmentAddress) {
        int oldStartSegmentAddress = startSegmentAddress;
        startSegmentAddress = newStartSegmentAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__START_SEGMENT_ADDRESS,
                    oldStartSegmentAddress, startSegmentAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getFirstTaskSegmentAddress() {
        return firstTaskSegmentAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFirstTaskSegmentAddress(int newFirstTaskSegmentAddress) {
        int oldFirstTaskSegmentAddress = firstTaskSegmentAddress;
        firstTaskSegmentAddress = newFirstTaskSegmentAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS,
                    oldFirstTaskSegmentAddress, firstTaskSegmentAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getHeadModuleSegmentAddress() {
        return headModuleSegmentAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setHeadModuleSegmentAddress(int newHeadModuleSegmentAddress) {
        int oldHeadModuleSegmentAddress = headModuleSegmentAddress;
        headModuleSegmentAddress = newHeadModuleSegmentAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS,
                    oldHeadModuleSegmentAddress, headModuleSegmentAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getDataSegmentCheckSum() {
        return dataSegmentCheckSum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSegmentCheckSum(int newDataSegmentCheckSum) {
        int oldDataSegmentCheckSum = dataSegmentCheckSum;
        dataSegmentCheckSum = newDataSegmentCheckSum;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__DATA_SEGMENT_CHECK_SUM,
                    oldDataSegmentCheckSum, dataSegmentCheckSum));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getWordConstOffset() {
        return wordConstOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setWordConstOffset(int newWordConstOffset) {
        int oldWordConstOffset = wordConstOffset;
        wordConstOffset = newWordConstOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__WORD_CONST_OFFSET,
                    oldWordConstOffset, wordConstOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getFloatConstOffset() {
        return floatConstOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFloatConstOffset(int newFloatConstOffset) {
        int oldFloatConstOffset = floatConstOffset;
        floatConstOffset = newFloatConstOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__FLOAT_CONST_OFFSET,
                    oldFloatConstOffset, floatConstOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getWordVarOffset() {
        return wordVarOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setWordVarOffset(int newWordVarOffset) {
        int oldWordVarOffset = wordVarOffset;
        wordVarOffset = newWordVarOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__WORD_VAR_OFFSET,
                    oldWordVarOffset, wordVarOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getFloatVarOffset() {
        return floatVarOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFloatVarOffset(int newFloatVarOffset) {
        int oldFloatVarOffset = floatVarOffset;
        floatVarOffset = newFloatVarOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__FLOAT_VAR_OFFSET,
                    oldFloatVarOffset, floatVarOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getEndOfFloatVars() {
        return endOfFloatVars;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEndOfFloatVars(int newEndOfFloatVars) {
        int oldEndOfFloatVars = endOfFloatVars;
        endOfFloatVars = newEndOfFloatVars;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__END_OF_FLOAT_VARS,
                    oldEndOfFloatVars, endOfFloatVars));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public byte[] getDataSegment() {
        return dataSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataSegment(byte[] newDataSegment) {
        byte[] oldDataSegment = dataSegment;
        dataSegment = newDataSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__DATA_SEGMENT, oldDataSegment,
                    dataSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtHwType getHwType() {
        return hwType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setHwType(RtHwType newHwType) {
        RtHwType oldHwType = hwType;
        hwType = newHwType == null ? HW_TYPE_EDEFAULT : newHwType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__HW_TYPE, oldHwType, hwType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getFieldBus() {
        return fieldBus;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFieldBus(int newFieldBus) {
        int oldFieldBus = fieldBus;
        fieldBus = newFieldBus;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__FIELD_BUS, oldFieldBus,
                    fieldBus));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getPastValuesOffset() {
        return pastValuesOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPastValuesOffset(int newPastValuesOffset) {
        int oldPastValuesOffset = pastValuesOffset;
        pastValuesOffset = newPastValuesOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__PAST_VALUES_OFFSET,
                    oldPastValuesOffset, pastValuesOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getPastValuesLastOffset() {
        return pastValuesLastOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPastValuesLastOffset(int newPastValuesLastOffset) {
        int oldPastValuesLastOffset = pastValuesLastOffset;
        pastValuesLastOffset = newPastValuesLastOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__PAST_VALUES_LAST_OFFSET,
                    oldPastValuesLastOffset, pastValuesLastOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getTasksCheckSum() {
        return tasksCheckSum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTasksCheckSum(int newTasksCheckSum) {
        int oldTasksCheckSum = tasksCheckSum;
        tasksCheckSum = newTasksCheckSum;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__TASKS_CHECK_SUM,
                    oldTasksCheckSum, tasksCheckSum));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtHeadModule getHeadModul() {
        return headModul;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetHeadModul(RtHeadModule newHeadModul, NotificationChain msgs) {
        RtHeadModule oldHeadModul = headModul;
        headModul = newHeadModul;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RtPackage.RT_MODULE__HEAD_MODUL, oldHeadModul, newHeadModul);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setHeadModul(RtHeadModule newHeadModul) {
        if (newHeadModul != headModul) {
            NotificationChain msgs = null;
            if (headModul != null) {
                msgs = ((InternalEObject) headModul).eInverseRemove(this, RtPackage.RT_HEAD_MODULE__MODULE,
                        RtHeadModule.class, msgs);
            }
            if (newHeadModul != null) {
                msgs = ((InternalEObject) newHeadModul).eInverseAdd(this, RtPackage.RT_HEAD_MODULE__MODULE,
                        RtHeadModule.class, msgs);
            }
            msgs = basicSetHeadModul(newHeadModul, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__HEAD_MODUL, newHeadModul,
                    newHeadModul));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public byte[] getHeadModuleSegment() {
        return headModuleSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setHeadModuleSegment(byte[] newHeadModuleSegment) {
        byte[] oldHeadModuleSegment = headModuleSegment;
        headModuleSegment = newHeadModuleSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT,
                    oldHeadModuleSegment, headModuleSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public long getSourceModificationStamp() {
        return sourceModificationStamp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSourceModificationStamp(long newSourceModificationStamp) {
        long oldSourceModificationStamp = sourceModificationStamp;
        sourceModificationStamp = newSourceModificationStamp;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__SOURCE_MODIFICATION_STAMP,
                    oldSourceModificationStamp, sourceModificationStamp));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getSourceName() {
        return sourceName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSourceName(String newSourceName) {
        String oldSourceName = sourceName;
        sourceName = newSourceName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__SOURCE_NAME, oldSourceName,
                    sourceName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getSourceChecksum() {
        return sourceChecksum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSourceChecksum(String newSourceChecksum) {
        String oldSourceChecksum = sourceChecksum;
        sourceChecksum = newSourceChecksum;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__SOURCE_CHECKSUM,
                    oldSourceChecksum, sourceChecksum));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<String> getComments() {
        if (comments == null) {
            comments = new EDataTypeUniqueEList<>(String.class, this, RtPackage.RT_MODULE__COMMENTS);
        }
        return comments;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public byte[] getStartSegment() {
        return startSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStartSegment(byte[] newStartSegment) {
        byte[] oldStartSegment = startSegment;
        startSegment = newStartSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE__START_SEGMENT, oldStartSegment,
                    startSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtWordConstant> getWordConstants() {
        return RtModuleUtils.getWordConstants(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtWordVariable> getWordVariables() {
        return RtModuleUtils.getWordVariables(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtFloatConstant> getFloatConstants() {
        return RtModuleUtils.getFloatConstants(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtFloatVariable> getFloatVariables() {
        return RtModuleUtils.getFloatVariables(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtReferenceConstant> getReferences() {
        return RtModuleUtils.getReferences(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void addSymbol(final RtSymbol symbol) {
        RtModuleUtils.addSymbol(this, symbol);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtSymbol getSymbol(final int id) {
        return RtModuleUtils.getSymbol(this, id);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean haveSymbol(final int id) {
        return RtModuleUtils.haveSymbol(this, id);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getModuleChecksum() {
        return RtModuleUtils.getModuleChecksum(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int calculateProgramSize() {
        return RtModuleUtils.calculateProgramSize(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RtPackage.RT_MODULE__SYMBOLS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getSymbols()).basicAdd(otherEnd, msgs);
        case RtPackage.RT_MODULE__TASKS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getTasks()).basicAdd(otherEnd, msgs);
        case RtPackage.RT_MODULE__HEAD_MODUL:
            if (headModul != null) {
                msgs = ((InternalEObject) headModul).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - RtPackage.RT_MODULE__HEAD_MODUL, null, msgs);
            }
            return basicSetHeadModul((RtHeadModule) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RtPackage.RT_MODULE__SYMBOLS:
            return ((InternalEList<?>) getSymbols()).basicRemove(otherEnd, msgs);
        case RtPackage.RT_MODULE__TASKS:
            return ((InternalEList<?>) getTasks()).basicRemove(otherEnd, msgs);
        case RtPackage.RT_MODULE__HEAD_MODUL:
            return basicSetHeadModul(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RtPackage.RT_MODULE__SYMBOLS:
            return getSymbols();
        case RtPackage.RT_MODULE__DATA_SEGMENT_ADDRESS:
            return getDataSegmentAddress();
        case RtPackage.RT_MODULE__TASKS:
            return getTasks();
        case RtPackage.RT_MODULE__START_SEGMENT_ADDRESS:
            return getStartSegmentAddress();
        case RtPackage.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS:
            return getFirstTaskSegmentAddress();
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS:
            return getHeadModuleSegmentAddress();
        case RtPackage.RT_MODULE__DATA_SEGMENT_CHECK_SUM:
            return getDataSegmentCheckSum();
        case RtPackage.RT_MODULE__TASKS_CHECK_SUM:
            return getTasksCheckSum();
        case RtPackage.RT_MODULE__WORD_CONST_OFFSET:
            return getWordConstOffset();
        case RtPackage.RT_MODULE__FLOAT_CONST_OFFSET:
            return getFloatConstOffset();
        case RtPackage.RT_MODULE__WORD_VAR_OFFSET:
            return getWordVarOffset();
        case RtPackage.RT_MODULE__FLOAT_VAR_OFFSET:
            return getFloatVarOffset();
        case RtPackage.RT_MODULE__END_OF_FLOAT_VARS:
            return getEndOfFloatVars();
        case RtPackage.RT_MODULE__DATA_SEGMENT:
            return getDataSegment();
        case RtPackage.RT_MODULE__HW_TYPE:
            return getHwType();
        case RtPackage.RT_MODULE__FIELD_BUS:
            return getFieldBus();
        case RtPackage.RT_MODULE__PAST_VALUES_OFFSET:
            return getPastValuesOffset();
        case RtPackage.RT_MODULE__PAST_VALUES_LAST_OFFSET:
            return getPastValuesLastOffset();
        case RtPackage.RT_MODULE__HEAD_MODUL:
            return getHeadModul();
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT:
            return getHeadModuleSegment();
        case RtPackage.RT_MODULE__SOURCE_MODIFICATION_STAMP:
            return getSourceModificationStamp();
        case RtPackage.RT_MODULE__SOURCE_NAME:
            return getSourceName();
        case RtPackage.RT_MODULE__SOURCE_CHECKSUM:
            return getSourceChecksum();
        case RtPackage.RT_MODULE__COMMENTS:
            return getComments();
        case RtPackage.RT_MODULE__START_SEGMENT:
            return getStartSegment();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case RtPackage.RT_MODULE__SYMBOLS:
            getSymbols().clear();
            getSymbols().addAll((Collection<? extends RtSymbol>) newValue);
            return;
        case RtPackage.RT_MODULE__DATA_SEGMENT_ADDRESS:
            setDataSegmentAddress((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__TASKS:
            getTasks().clear();
            getTasks().addAll((Collection<? extends RtTask>) newValue);
            return;
        case RtPackage.RT_MODULE__START_SEGMENT_ADDRESS:
            setStartSegmentAddress((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS:
            setFirstTaskSegmentAddress((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS:
            setHeadModuleSegmentAddress((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__DATA_SEGMENT_CHECK_SUM:
            setDataSegmentCheckSum((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__TASKS_CHECK_SUM:
            setTasksCheckSum((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__WORD_CONST_OFFSET:
            setWordConstOffset((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__FLOAT_CONST_OFFSET:
            setFloatConstOffset((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__WORD_VAR_OFFSET:
            setWordVarOffset((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__FLOAT_VAR_OFFSET:
            setFloatVarOffset((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__END_OF_FLOAT_VARS:
            setEndOfFloatVars((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__DATA_SEGMENT:
            setDataSegment((byte[]) newValue);
            return;
        case RtPackage.RT_MODULE__HW_TYPE:
            setHwType((RtHwType) newValue);
            return;
        case RtPackage.RT_MODULE__FIELD_BUS:
            setFieldBus((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__PAST_VALUES_OFFSET:
            setPastValuesOffset((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__PAST_VALUES_LAST_OFFSET:
            setPastValuesLastOffset((Integer) newValue);
            return;
        case RtPackage.RT_MODULE__HEAD_MODUL:
            setHeadModul((RtHeadModule) newValue);
            return;
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT:
            setHeadModuleSegment((byte[]) newValue);
            return;
        case RtPackage.RT_MODULE__SOURCE_MODIFICATION_STAMP:
            setSourceModificationStamp((Long) newValue);
            return;
        case RtPackage.RT_MODULE__SOURCE_NAME:
            setSourceName((String) newValue);
            return;
        case RtPackage.RT_MODULE__SOURCE_CHECKSUM:
            setSourceChecksum((String) newValue);
            return;
        case RtPackage.RT_MODULE__COMMENTS:
            getComments().clear();
            getComments().addAll((Collection<? extends String>) newValue);
            return;
        case RtPackage.RT_MODULE__START_SEGMENT:
            setStartSegment((byte[]) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case RtPackage.RT_MODULE__SYMBOLS:
            getSymbols().clear();
            return;
        case RtPackage.RT_MODULE__DATA_SEGMENT_ADDRESS:
            setDataSegmentAddress(DATA_SEGMENT_ADDRESS_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__TASKS:
            getTasks().clear();
            return;
        case RtPackage.RT_MODULE__START_SEGMENT_ADDRESS:
            setStartSegmentAddress(START_SEGMENT_ADDRESS_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS:
            setFirstTaskSegmentAddress(FIRST_TASK_SEGMENT_ADDRESS_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS:
            setHeadModuleSegmentAddress(HEAD_MODULE_SEGMENT_ADDRESS_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__DATA_SEGMENT_CHECK_SUM:
            setDataSegmentCheckSum(DATA_SEGMENT_CHECK_SUM_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__TASKS_CHECK_SUM:
            setTasksCheckSum(TASKS_CHECK_SUM_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__WORD_CONST_OFFSET:
            setWordConstOffset(WORD_CONST_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__FLOAT_CONST_OFFSET:
            setFloatConstOffset(FLOAT_CONST_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__WORD_VAR_OFFSET:
            setWordVarOffset(WORD_VAR_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__FLOAT_VAR_OFFSET:
            setFloatVarOffset(FLOAT_VAR_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__END_OF_FLOAT_VARS:
            setEndOfFloatVars(END_OF_FLOAT_VARS_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__DATA_SEGMENT:
            setDataSegment(DATA_SEGMENT_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__HW_TYPE:
            setHwType(HW_TYPE_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__FIELD_BUS:
            setFieldBus(FIELD_BUS_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__PAST_VALUES_OFFSET:
            setPastValuesOffset(PAST_VALUES_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__PAST_VALUES_LAST_OFFSET:
            setPastValuesLastOffset(PAST_VALUES_LAST_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__HEAD_MODUL:
            setHeadModul((RtHeadModule) null);
            return;
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT:
            setHeadModuleSegment(HEAD_MODULE_SEGMENT_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__SOURCE_MODIFICATION_STAMP:
            setSourceModificationStamp(SOURCE_MODIFICATION_STAMP_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__SOURCE_NAME:
            setSourceName(SOURCE_NAME_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__SOURCE_CHECKSUM:
            setSourceChecksum(SOURCE_CHECKSUM_EDEFAULT);
            return;
        case RtPackage.RT_MODULE__COMMENTS:
            getComments().clear();
            return;
        case RtPackage.RT_MODULE__START_SEGMENT:
            setStartSegment(START_SEGMENT_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case RtPackage.RT_MODULE__SYMBOLS:
            return symbols != null && !symbols.isEmpty();
        case RtPackage.RT_MODULE__DATA_SEGMENT_ADDRESS:
            return dataSegmentAddress != DATA_SEGMENT_ADDRESS_EDEFAULT;
        case RtPackage.RT_MODULE__TASKS:
            return tasks != null && !tasks.isEmpty();
        case RtPackage.RT_MODULE__START_SEGMENT_ADDRESS:
            return startSegmentAddress != START_SEGMENT_ADDRESS_EDEFAULT;
        case RtPackage.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS:
            return firstTaskSegmentAddress != FIRST_TASK_SEGMENT_ADDRESS_EDEFAULT;
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS:
            return headModuleSegmentAddress != HEAD_MODULE_SEGMENT_ADDRESS_EDEFAULT;
        case RtPackage.RT_MODULE__DATA_SEGMENT_CHECK_SUM:
            return dataSegmentCheckSum != DATA_SEGMENT_CHECK_SUM_EDEFAULT;
        case RtPackage.RT_MODULE__TASKS_CHECK_SUM:
            return tasksCheckSum != TASKS_CHECK_SUM_EDEFAULT;
        case RtPackage.RT_MODULE__WORD_CONST_OFFSET:
            return wordConstOffset != WORD_CONST_OFFSET_EDEFAULT;
        case RtPackage.RT_MODULE__FLOAT_CONST_OFFSET:
            return floatConstOffset != FLOAT_CONST_OFFSET_EDEFAULT;
        case RtPackage.RT_MODULE__WORD_VAR_OFFSET:
            return wordVarOffset != WORD_VAR_OFFSET_EDEFAULT;
        case RtPackage.RT_MODULE__FLOAT_VAR_OFFSET:
            return floatVarOffset != FLOAT_VAR_OFFSET_EDEFAULT;
        case RtPackage.RT_MODULE__END_OF_FLOAT_VARS:
            return endOfFloatVars != END_OF_FLOAT_VARS_EDEFAULT;
        case RtPackage.RT_MODULE__DATA_SEGMENT:
            return DATA_SEGMENT_EDEFAULT == null ? dataSegment != null : !DATA_SEGMENT_EDEFAULT.equals(dataSegment);
        case RtPackage.RT_MODULE__HW_TYPE:
            return hwType != HW_TYPE_EDEFAULT;
        case RtPackage.RT_MODULE__FIELD_BUS:
            return fieldBus != FIELD_BUS_EDEFAULT;
        case RtPackage.RT_MODULE__PAST_VALUES_OFFSET:
            return pastValuesOffset != PAST_VALUES_OFFSET_EDEFAULT;
        case RtPackage.RT_MODULE__PAST_VALUES_LAST_OFFSET:
            return pastValuesLastOffset != PAST_VALUES_LAST_OFFSET_EDEFAULT;
        case RtPackage.RT_MODULE__HEAD_MODUL:
            return headModul != null;
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT:
            return HEAD_MODULE_SEGMENT_EDEFAULT == null ? headModuleSegment != null
                    : !HEAD_MODULE_SEGMENT_EDEFAULT.equals(headModuleSegment);
        case RtPackage.RT_MODULE__SOURCE_MODIFICATION_STAMP:
            return sourceModificationStamp != SOURCE_MODIFICATION_STAMP_EDEFAULT;
        case RtPackage.RT_MODULE__SOURCE_NAME:
            return SOURCE_NAME_EDEFAULT == null ? sourceName != null : !SOURCE_NAME_EDEFAULT.equals(sourceName);
        case RtPackage.RT_MODULE__SOURCE_CHECKSUM:
            return SOURCE_CHECKSUM_EDEFAULT == null ? sourceChecksum != null
                    : !SOURCE_CHECKSUM_EDEFAULT.equals(sourceChecksum);
        case RtPackage.RT_MODULE__COMMENTS:
            return comments != null && !comments.isEmpty();
        case RtPackage.RT_MODULE__START_SEGMENT:
            return START_SEGMENT_EDEFAULT == null ? startSegment != null : !START_SEGMENT_EDEFAULT.equals(startSegment);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (dataSegmentAddress: ");
        result.append(dataSegmentAddress);
        result.append(", startSegmentAddress: ");
        result.append(startSegmentAddress);
        result.append(", firstTaskSegmentAddress: ");
        result.append(firstTaskSegmentAddress);
        result.append(", headModuleSegmentAddress: ");
        result.append(headModuleSegmentAddress);
        result.append(", dataSegmentCheckSum: ");
        result.append(dataSegmentCheckSum);
        result.append(", tasksCheckSum: ");
        result.append(tasksCheckSum);
        result.append(", wordConstOffset: ");
        result.append(wordConstOffset);
        result.append(", floatConstOffset: ");
        result.append(floatConstOffset);
        result.append(", wordVarOffset: ");
        result.append(wordVarOffset);
        result.append(", floatVarOffset: ");
        result.append(floatVarOffset);
        result.append(", endOfFloatVars: ");
        result.append(endOfFloatVars);
        result.append(", dataSegment: ");
        result.append(dataSegment);
        result.append(", hwType: ");
        result.append(hwType);
        result.append(", fieldBus: ");
        result.append(fieldBus);
        result.append(", pastValuesOffset: ");
        result.append(pastValuesOffset);
        result.append(", pastValuesLastOffset: ");
        result.append(pastValuesLastOffset);
        result.append(", headModuleSegment: ");
        result.append(headModuleSegment);
        result.append(", sourceModificationStamp: ");
        result.append(sourceModificationStamp);
        result.append(", sourceName: ");
        result.append(sourceName);
        result.append(", sourceChecksum: ");
        result.append(sourceChecksum);
        result.append(", comments: ");
        result.append(comments);
        result.append(", startSegment: ");
        result.append(startSegment);
        result.append(')');
        return result.toString();
    }

} // RtModuleImpl
