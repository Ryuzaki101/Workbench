/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Hardware Type Definition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getAliases
 * <em>Aliases</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getDatabaseSegment
 * <em>Database Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getDatabaseChecksumAddress
 * <em>Database Checksum Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getAddressConversionListAddress
 * <em>Address Conversion List Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getHeadSegment
 * <em>Head Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getEndModuleOpcode
 * <em>End Module Opcode</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getDataSegment
 * <em>Data Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getStackSegment
 * <em>Stack Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getProgramSegment
 * <em>Program Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getMaxProgramSize
 * <em>Max Program Size</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getPastValuesOffsetFirstTask
 * <em>Past Values Offset First Task</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.HardwareTypeDefinitionImpl#getMaxTaskCount
 * <em>Max Task Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HardwareTypeDefinitionImpl extends EObjectImpl implements HardwareTypeDefinition {
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final HardwareType TYPE_EDEFAULT = HardwareType.UNKNOWN;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected HardwareType type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getAliases() <em>Aliases</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAliases()
     * @generated
     * @ordered
     */
    protected EList<HardwareAlias> aliases;

    /**
     * The default value of the '{@link #getDatabaseSegment() <em>Database
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDatabaseSegment()
     * @generated
     * @ordered
     */
    protected static final int DATABASE_SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDatabaseSegment() <em>Database
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDatabaseSegment()
     * @generated
     * @ordered
     */
    protected int databaseSegment = DATABASE_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getDatabaseChecksumAddress()
     * <em>Database Checksum Address</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDatabaseChecksumAddress()
     * @generated
     * @ordered
     */
    protected static final int DATABASE_CHECKSUM_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDatabaseChecksumAddress()
     * <em>Database Checksum Address</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDatabaseChecksumAddress()
     * @generated
     * @ordered
     */
    protected int databaseChecksumAddress = DATABASE_CHECKSUM_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getAddressConversionListAddress()
     * <em>Address Conversion List Address</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getAddressConversionListAddress()
     * @generated
     * @ordered
     */
    protected static final int ADDRESS_CONVERSION_LIST_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getAddressConversionListAddress()
     * <em>Address Conversion List Address</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getAddressConversionListAddress()
     * @generated
     * @ordered
     */
    protected int addressConversionListAddress = ADDRESS_CONVERSION_LIST_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getHeadSegment() <em>Head
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHeadSegment()
     * @generated
     * @ordered
     */
    protected static final int HEAD_SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getHeadSegment() <em>Head Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHeadSegment()
     * @generated
     * @ordered
     */
    protected int headSegment = HEAD_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getEndModuleOpcode() <em>End Module
     * Opcode</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEndModuleOpcode()
     * @generated
     * @ordered
     */
    protected static final int END_MODULE_OPCODE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getEndModuleOpcode() <em>End Module
     * Opcode</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEndModuleOpcode()
     * @generated
     * @ordered
     */
    protected int endModuleOpcode = END_MODULE_OPCODE_EDEFAULT;

    /**
     * The default value of the '{@link #getDataSegment() <em>Data
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDataSegment()
     * @generated
     * @ordered
     */
    protected static final int DATA_SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDataSegment() <em>Data Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDataSegment()
     * @generated
     * @ordered
     */
    protected int dataSegment = DATA_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getStackSegment() <em>Stack
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStackSegment()
     * @generated
     * @ordered
     */
    protected static final int STACK_SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStackSegment() <em>Stack
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStackSegment()
     * @generated
     * @ordered
     */
    protected int stackSegment = STACK_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getProgramSegment() <em>Program
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProgramSegment()
     * @generated
     * @ordered
     */
    protected static final int PROGRAM_SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getProgramSegment() <em>Program
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProgramSegment()
     * @generated
     * @ordered
     */
    protected int programSegment = PROGRAM_SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxProgramSize() <em>Max Program
     * Size</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaxProgramSize()
     * @generated
     * @ordered
     */
    protected static final int MAX_PROGRAM_SIZE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxProgramSize() <em>Max Program
     * Size</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaxProgramSize()
     * @generated
     * @ordered
     */
    protected int maxProgramSize = MAX_PROGRAM_SIZE_EDEFAULT;

    /**
     * The default value of the '{@link #getPastValuesOffsetFirstTask() <em>Past
     * Values Offset First Task</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPastValuesOffsetFirstTask()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUES_OFFSET_FIRST_TASK_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPastValuesOffsetFirstTask() <em>Past
     * Values Offset First Task</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getPastValuesOffsetFirstTask()
     * @generated
     * @ordered
     */
    protected int pastValuesOffsetFirstTask = PAST_VALUES_OFFSET_FIRST_TASK_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxTaskCount() <em>Max Task
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaxTaskCount()
     * @generated
     * @ordered
     */
    protected static final int MAX_TASK_COUNT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxTaskCount() <em>Max Task
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMaxTaskCount()
     * @generated
     * @ordered
     */
    protected int maxTaskCount = MAX_TASK_COUNT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected HardwareTypeDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<HardwareAlias> getAliases() {
        if (aliases == null) {
            aliases = new EObjectContainmentEList<>(HardwareAlias.class, this,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES);
        }
        return aliases;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getDatabaseSegment() {
        return databaseSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDatabaseSegment(int newDatabaseSegment) {
        int oldDatabaseSegment = databaseSegment;
        databaseSegment = newDatabaseSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT, oldDatabaseSegment, databaseSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getDatabaseChecksumAddress() {
        return databaseChecksumAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDatabaseChecksumAddress(int newDatabaseChecksumAddress) {
        int oldDatabaseChecksumAddress = databaseChecksumAddress;
        databaseChecksumAddress = newDatabaseChecksumAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS, oldDatabaseChecksumAddress,
                    databaseChecksumAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getAddressConversionListAddress() {
        return addressConversionListAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAddressConversionListAddress(int newAddressConversionListAddress) {
        int oldAddressConversionListAddress = addressConversionListAddress;
        addressConversionListAddress = newAddressConversionListAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS,
                    oldAddressConversionListAddress, addressConversionListAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getHeadSegment() {
        return headSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHeadSegment(int newHeadSegment) {
        int oldHeadSegment = headSegment;
        headSegment = newHeadSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT, oldHeadSegment, headSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getEndModuleOpcode() {
        return endModuleOpcode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEndModuleOpcode(int newEndModuleOpcode) {
        int oldEndModuleOpcode = endModuleOpcode;
        endModuleOpcode = newEndModuleOpcode;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE, oldEndModuleOpcode, endModuleOpcode));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getDataSegment() {
        return dataSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDataSegment(int newDataSegment) {
        int oldDataSegment = dataSegment;
        dataSegment = newDataSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT, oldDataSegment, dataSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getStackSegment() {
        return stackSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStackSegment(int newStackSegment) {
        int oldStackSegment = stackSegment;
        stackSegment = newStackSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT, oldStackSegment, stackSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getProgramSegment() {
        return programSegment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setProgramSegment(int newProgramSegment) {
        int oldProgramSegment = programSegment;
        programSegment = newProgramSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT, oldProgramSegment, programSegment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getMaxProgramSize() {
        return maxProgramSize;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMaxProgramSize(int newMaxProgramSize) {
        int oldMaxProgramSize = maxProgramSize;
        maxProgramSize = newMaxProgramSize;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE, oldMaxProgramSize, maxProgramSize));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HardwareType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setType(HardwareType newType) {
        HardwareType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.HARDWARE_TYPE_DEFINITION__TYPE,
                    oldType, type));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getPastValuesOffsetFirstTask() {
        return pastValuesOffsetFirstTask;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPastValuesOffsetFirstTask(int newPastValuesOffsetFirstTask) {
        int oldPastValuesOffsetFirstTask = pastValuesOffsetFirstTask;
        pastValuesOffsetFirstTask = newPastValuesOffsetFirstTask;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK,
                    oldPastValuesOffsetFirstTask, pastValuesOffsetFirstTask));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getMaxTaskCount() {
        return maxTaskCount;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMaxTaskCount(int newMaxTaskCount) {
        int oldMaxTaskCount = maxTaskCount;
        maxTaskCount = newMaxTaskCount;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT, oldMaxTaskCount, maxTaskCount));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES:
            return ((InternalEList<?>) getAliases()).basicRemove(otherEnd, msgs);
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
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__TYPE:
            return getType();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES:
            return getAliases();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT:
            return getDatabaseSegment();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS:
            return getDatabaseChecksumAddress();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS:
            return getAddressConversionListAddress();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT:
            return getHeadSegment();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE:
            return getEndModuleOpcode();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT:
            return getDataSegment();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT:
            return getStackSegment();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT:
            return getProgramSegment();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE:
            return getMaxProgramSize();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK:
            return getPastValuesOffsetFirstTask();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT:
            return getMaxTaskCount();
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
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__TYPE:
            setType((HardwareType) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES:
            getAliases().clear();
            getAliases().addAll((Collection<? extends HardwareAlias>) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT:
            setDatabaseSegment((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS:
            setDatabaseChecksumAddress((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS:
            setAddressConversionListAddress((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT:
            setHeadSegment((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE:
            setEndModuleOpcode((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT:
            setDataSegment((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT:
            setStackSegment((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT:
            setProgramSegment((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE:
            setMaxProgramSize((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK:
            setPastValuesOffsetFirstTask((Integer) newValue);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT:
            setMaxTaskCount((Integer) newValue);
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
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES:
            getAliases().clear();
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT:
            setDatabaseSegment(DATABASE_SEGMENT_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS:
            setDatabaseChecksumAddress(DATABASE_CHECKSUM_ADDRESS_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS:
            setAddressConversionListAddress(ADDRESS_CONVERSION_LIST_ADDRESS_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT:
            setHeadSegment(HEAD_SEGMENT_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE:
            setEndModuleOpcode(END_MODULE_OPCODE_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT:
            setDataSegment(DATA_SEGMENT_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT:
            setStackSegment(STACK_SEGMENT_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT:
            setProgramSegment(PROGRAM_SEGMENT_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE:
            setMaxProgramSize(MAX_PROGRAM_SIZE_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK:
            setPastValuesOffsetFirstTask(PAST_VALUES_OFFSET_FIRST_TASK_EDEFAULT);
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT:
            setMaxTaskCount(MAX_TASK_COUNT_EDEFAULT);
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
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__TYPE:
            return type != TYPE_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES:
            return aliases != null && !aliases.isEmpty();
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT:
            return databaseSegment != DATABASE_SEGMENT_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS:
            return databaseChecksumAddress != DATABASE_CHECKSUM_ADDRESS_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS:
            return addressConversionListAddress != ADDRESS_CONVERSION_LIST_ADDRESS_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT:
            return headSegment != HEAD_SEGMENT_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE:
            return endModuleOpcode != END_MODULE_OPCODE_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT:
            return dataSegment != DATA_SEGMENT_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT:
            return stackSegment != STACK_SEGMENT_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT:
            return programSegment != PROGRAM_SEGMENT_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE:
            return maxProgramSize != MAX_PROGRAM_SIZE_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK:
            return pastValuesOffsetFirstTask != PAST_VALUES_OFFSET_FIRST_TASK_EDEFAULT;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT:
            return maxTaskCount != MAX_TASK_COUNT_EDEFAULT;
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
        result.append(" (type: ");
        result.append(type);
        result.append(", databaseSegment: ");
        result.append(databaseSegment);
        result.append(", databaseChecksumAddress: ");
        result.append(databaseChecksumAddress);
        result.append(", addressConversionListAddress: ");
        result.append(addressConversionListAddress);
        result.append(", headSegment: ");
        result.append(headSegment);
        result.append(", endModuleOpcode: ");
        result.append(endModuleOpcode);
        result.append(", dataSegment: ");
        result.append(dataSegment);
        result.append(", stackSegment: ");
        result.append(stackSegment);
        result.append(", programSegment: ");
        result.append(programSegment);
        result.append(", maxProgramSize: ");
        result.append(maxProgramSize);
        result.append(", pastValuesOffsetFirstTask: ");
        result.append(pastValuesOffsetFirstTask);
        result.append(", maxTaskCount: ");
        result.append(maxTaskCount);
        result.append(')');
        return result.toString();
    }

} // HardwareTypeDefinitionImpl
