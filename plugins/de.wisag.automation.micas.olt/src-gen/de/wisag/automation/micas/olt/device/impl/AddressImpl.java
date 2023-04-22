/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.DevicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Address</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.AddressImpl#getSegment
 * <em>Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.AddressImpl#getOffset
 * <em>Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddressImpl extends EObjectImpl implements Address {
    /**
     * The default value of the '{@link #getSegment() <em>Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSegment()
     * @generated
     * @ordered
     */
    protected static final int SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSegment() <em>Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSegment()
     * @generated
     * @ordered
     */
    protected int segment = SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getOffset() <em>Offset</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOffset()
     * @generated
     * @ordered
     */
    protected static final int OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOffset()
     * @generated
     * @ordered
     */
    protected int offset = OFFSET_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AddressImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DevicePackage.Literals.ADDRESS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSegment() {
        return segment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSegment(int newSegment) {
        int oldSegment = segment;
        segment = newSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.ADDRESS__SEGMENT, oldSegment, segment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getOffset() {
        return offset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOffset(int newOffset) {
        int oldOffset = offset;
        offset = newOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.ADDRESS__OFFSET, oldOffset, offset));
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
        case DevicePackage.ADDRESS__SEGMENT:
            return getSegment();
        case DevicePackage.ADDRESS__OFFSET:
            return getOffset();
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
        case DevicePackage.ADDRESS__SEGMENT:
            setSegment((Integer) newValue);
            return;
        case DevicePackage.ADDRESS__OFFSET:
            setOffset((Integer) newValue);
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
        case DevicePackage.ADDRESS__SEGMENT:
            setSegment(SEGMENT_EDEFAULT);
            return;
        case DevicePackage.ADDRESS__OFFSET:
            setOffset(OFFSET_EDEFAULT);
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
        case DevicePackage.ADDRESS__SEGMENT:
            return segment != SEGMENT_EDEFAULT;
        case DevicePackage.ADDRESS__OFFSET:
            return offset != OFFSET_EDEFAULT;
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
        result.append(" (segment: ");
        result.append(segment);
        result.append(", offset: ");
        result.append(offset);
        result.append(')');
        return result.toString();
    }

} // AddressImpl
