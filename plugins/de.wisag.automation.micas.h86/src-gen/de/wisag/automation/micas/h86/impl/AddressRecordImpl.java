/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.wisag.automation.micas.h86.AddressRecord;
import de.wisag.automation.micas.h86.H86Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Address
 * Record</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.impl.AddressRecordImpl#getAddress
 * <em>Address</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddressRecordImpl extends RecordImpl implements AddressRecord {
    /**
     * The default value of the '{@link #getAddress() <em>Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAddress()
     * @generated
     * @ordered
     */
    protected static final int ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getAddress() <em>Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAddress()
     * @generated
     * @ordered
     */
    protected int address = ADDRESS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AddressRecordImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return H86Package.Literals.ADDRESS_RECORD;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getAddress() {
        return address;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAddress(int newAddress) {
        int oldAddress = address;
        address = newAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, H86Package.ADDRESS_RECORD__ADDRESS, oldAddress,
                    address));
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
        case H86Package.ADDRESS_RECORD__ADDRESS:
            return getAddress();
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
        case H86Package.ADDRESS_RECORD__ADDRESS:
            setAddress((Integer) newValue);
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
        case H86Package.ADDRESS_RECORD__ADDRESS:
            setAddress(ADDRESS_EDEFAULT);
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
        case H86Package.ADDRESS_RECORD__ADDRESS:
            return address != ADDRESS_EDEFAULT;
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
        result.append(" (address: ");
        result.append(address);
        result.append(')');
        return result.toString();
    }

} // AddressRecordImpl
