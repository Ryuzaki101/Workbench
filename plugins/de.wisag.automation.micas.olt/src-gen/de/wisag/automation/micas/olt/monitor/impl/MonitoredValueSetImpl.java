/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;
import de.wisag.automation.micas.rt.RtHwType;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Monitored Value Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl#getTimestamp
 * <em>Timestamp</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl#getValues
 * <em>Values</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl#getHwType
 * <em>Hw Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitoredValueSetImpl extends EObjectImpl implements MonitoredValueSet {
    /**
     * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTimestamp()
     * @generated
     * @ordered
     */
    protected static final long TIMESTAMP_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTimestamp()
     * @generated
     * @ordered
     */
    protected long timestamp = TIMESTAMP_EDEFAULT;

    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<MonitoredValue> values;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MonitoredValueSetImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MonitorPackage.Literals.MONITORED_VALUE_SET;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTimestamp(long newTimestamp) {
        long oldTimestamp = timestamp;
        timestamp = newTimestamp;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_VALUE_SET__TIMESTAMP,
                    oldTimestamp, timestamp));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<MonitoredValue> getValues() {
        if (values == null) {
            values = new EObjectResolvingEList<>(MonitoredValue.class, this,
                    MonitorPackage.MONITORED_VALUE_SET__VALUES);
        }
        return values;
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
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_VALUE_SET__HW_TYPE,
                    oldHwType, hwType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case MonitorPackage.MONITORED_VALUE_SET__TIMESTAMP:
            return getTimestamp();
        case MonitorPackage.MONITORED_VALUE_SET__VALUES:
            return getValues();
        case MonitorPackage.MONITORED_VALUE_SET__HW_TYPE:
            return getHwType();
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
        case MonitorPackage.MONITORED_VALUE_SET__TIMESTAMP:
            setTimestamp((Long) newValue);
            return;
        case MonitorPackage.MONITORED_VALUE_SET__VALUES:
            getValues().clear();
            getValues().addAll((Collection<? extends MonitoredValue>) newValue);
            return;
        case MonitorPackage.MONITORED_VALUE_SET__HW_TYPE:
            setHwType((RtHwType) newValue);
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
        case MonitorPackage.MONITORED_VALUE_SET__TIMESTAMP:
            setTimestamp(TIMESTAMP_EDEFAULT);
            return;
        case MonitorPackage.MONITORED_VALUE_SET__VALUES:
            getValues().clear();
            return;
        case MonitorPackage.MONITORED_VALUE_SET__HW_TYPE:
            setHwType(HW_TYPE_EDEFAULT);
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
        case MonitorPackage.MONITORED_VALUE_SET__TIMESTAMP:
            return timestamp != TIMESTAMP_EDEFAULT;
        case MonitorPackage.MONITORED_VALUE_SET__VALUES:
            return values != null && !values.isEmpty();
        case MonitorPackage.MONITORED_VALUE_SET__HW_TYPE:
            return hwType != HW_TYPE_EDEFAULT;
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
        result.append(" (timestamp: ");
        result.append(timestamp);
        result.append(", hwType: ");
        result.append(hwType);
        result.append(')');
        return result.toString();
    }

} // MonitoredValueSetImpl
