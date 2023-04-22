/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.rt.RtSymbol;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Monitored Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl#getValue
 * <em>Value</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl#getRtSymbol
 * <em>Rt Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitoredValueImpl extends EObjectImpl implements MonitoredValue {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = "\"\"";

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getRtSymbol() <em>Rt Symbol</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRtSymbol()
     * @generated
     * @ordered
     */
    protected RtSymbol rtSymbol;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MonitoredValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MonitorPackage.Literals.MONITORED_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_VALUE__NAME, oldName, name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_VALUE__VALUE, oldValue,
                    value));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RtSymbol getRtSymbol() {
        if (rtSymbol != null && rtSymbol.eIsProxy()) {
            InternalEObject oldRtSymbol = (InternalEObject) rtSymbol;
            rtSymbol = (RtSymbol) eResolveProxy(oldRtSymbol);
            if (rtSymbol != oldRtSymbol) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitorPackage.MONITORED_VALUE__RT_SYMBOL,
                            oldRtSymbol, rtSymbol));
                }
            }
        }
        return rtSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RtSymbol basicGetRtSymbol() {
        return rtSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRtSymbol(RtSymbol newRtSymbol) {
        RtSymbol oldRtSymbol = rtSymbol;
        rtSymbol = newRtSymbol;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_VALUE__RT_SYMBOL,
                    oldRtSymbol, rtSymbol));
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
        case MonitorPackage.MONITORED_VALUE__NAME:
            return getName();
        case MonitorPackage.MONITORED_VALUE__VALUE:
            return getValue();
        case MonitorPackage.MONITORED_VALUE__RT_SYMBOL:
            if (resolve) {
                return getRtSymbol();
            }
            return basicGetRtSymbol();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case MonitorPackage.MONITORED_VALUE__NAME:
            setName((String) newValue);
            return;
        case MonitorPackage.MONITORED_VALUE__VALUE:
            setValue((String) newValue);
            return;
        case MonitorPackage.MONITORED_VALUE__RT_SYMBOL:
            setRtSymbol((RtSymbol) newValue);
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
        case MonitorPackage.MONITORED_VALUE__NAME:
            setName(NAME_EDEFAULT);
            return;
        case MonitorPackage.MONITORED_VALUE__VALUE:
            setValue(VALUE_EDEFAULT);
            return;
        case MonitorPackage.MONITORED_VALUE__RT_SYMBOL:
            setRtSymbol((RtSymbol) null);
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
        case MonitorPackage.MONITORED_VALUE__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case MonitorPackage.MONITORED_VALUE__VALUE:
            return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
        case MonitorPackage.MONITORED_VALUE__RT_SYMBOL:
            return rtSymbol != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} // MonitoredValueImpl
