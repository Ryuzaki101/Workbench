/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DevicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Data
 * Range</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DataRangeImpl#getStartAddress
 * <em>Start Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DataRangeImpl#getValues
 * <em>Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataRangeImpl extends EObjectImpl implements DataRange {
    /**
     * The cached value of the '{@link #getStartAddress() <em>Start
     * Address</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStartAddress()
     * @generated
     * @ordered
     */
    protected Address startAddress;

    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' attribute
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<Integer> values;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DataRangeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DevicePackage.Literals.DATA_RANGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Address getStartAddress() {
        return startAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetStartAddress(Address newStartAddress, NotificationChain msgs) {
        Address oldStartAddress = startAddress;
        startAddress = newStartAddress;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    DevicePackage.DATA_RANGE__START_ADDRESS, oldStartAddress, newStartAddress);
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
    public void setStartAddress(Address newStartAddress) {
        if (newStartAddress != startAddress) {
            NotificationChain msgs = null;
            if (startAddress != null) {
                msgs = ((InternalEObject) startAddress).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - DevicePackage.DATA_RANGE__START_ADDRESS, null, msgs);
            }
            if (newStartAddress != null) {
                msgs = ((InternalEObject) newStartAddress).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - DevicePackage.DATA_RANGE__START_ADDRESS, null, msgs);
            }
            msgs = basicSetStartAddress(newStartAddress, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DATA_RANGE__START_ADDRESS,
                    newStartAddress, newStartAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Integer> getValues() {
        if (values == null) {
            values = new EDataTypeUniqueEList<>(Integer.class, this, DevicePackage.DATA_RANGE__VALUES);
        }
        return values;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case DevicePackage.DATA_RANGE__START_ADDRESS:
            return basicSetStartAddress(null, msgs);
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
        case DevicePackage.DATA_RANGE__START_ADDRESS:
            return getStartAddress();
        case DevicePackage.DATA_RANGE__VALUES:
            return getValues();
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
        case DevicePackage.DATA_RANGE__START_ADDRESS:
            setStartAddress((Address) newValue);
            return;
        case DevicePackage.DATA_RANGE__VALUES:
            getValues().clear();
            getValues().addAll((Collection<? extends Integer>) newValue);
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
        case DevicePackage.DATA_RANGE__START_ADDRESS:
            setStartAddress((Address) null);
            return;
        case DevicePackage.DATA_RANGE__VALUES:
            getValues().clear();
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
        case DevicePackage.DATA_RANGE__START_ADDRESS:
            return startAddress != null;
        case DevicePackage.DATA_RANGE__VALUES:
            return values != null && !values.isEmpty();
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
        result.append(" (values: ");
        result.append(values);
        result.append(')');
        return result.toString();
    }

} // DataRangeImpl
