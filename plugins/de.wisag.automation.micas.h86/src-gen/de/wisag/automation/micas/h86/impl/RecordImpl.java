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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.h86.Record;
import de.wisag.automation.micas.h86.RecordType;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Record</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.impl.RecordImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.h86.impl.RecordImpl#getNumberOfBytes
 * <em>Number Of Bytes</em>}</li>
 * <li>{@link de.wisag.automation.micas.h86.impl.RecordImpl#getChecksum
 * <em>Checksum</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RecordImpl extends EObjectImpl implements Record {
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final RecordType TYPE_EDEFAULT = RecordType.DATA;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected RecordType type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getNumberOfBytes() <em>Number Of
     * Bytes</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfBytes()
     * @generated
     * @ordered
     */
    protected static final int NUMBER_OF_BYTES_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNumberOfBytes() <em>Number Of
     * Bytes</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfBytes()
     * @generated
     * @ordered
     */
    protected int numberOfBytes = NUMBER_OF_BYTES_EDEFAULT;

    /**
     * The default value of the '{@link #getChecksum() <em>Checksum</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChecksum()
     * @generated
     * @ordered
     */
    protected static final int CHECKSUM_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getChecksum() <em>Checksum</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChecksum()
     * @generated
     * @ordered
     */
    protected int checksum = CHECKSUM_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RecordImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return H86Package.Literals.RECORD;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RecordType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setType(RecordType newType) {
        RecordType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, H86Package.RECORD__TYPE, oldType, type));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getNumberOfBytes() {
        return numberOfBytes;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNumberOfBytes(int newNumberOfBytes) {
        int oldNumberOfBytes = numberOfBytes;
        numberOfBytes = newNumberOfBytes;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, H86Package.RECORD__NUMBER_OF_BYTES, oldNumberOfBytes,
                    numberOfBytes));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getChecksum() {
        return checksum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setChecksum(int newChecksum) {
        int oldChecksum = checksum;
        checksum = newChecksum;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, H86Package.RECORD__CHECKSUM, oldChecksum, checksum));
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
        case H86Package.RECORD__TYPE:
            return getType();
        case H86Package.RECORD__NUMBER_OF_BYTES:
            return getNumberOfBytes();
        case H86Package.RECORD__CHECKSUM:
            return getChecksum();
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
        case H86Package.RECORD__TYPE:
            setType((RecordType) newValue);
            return;
        case H86Package.RECORD__NUMBER_OF_BYTES:
            setNumberOfBytes((Integer) newValue);
            return;
        case H86Package.RECORD__CHECKSUM:
            setChecksum((Integer) newValue);
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
        case H86Package.RECORD__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case H86Package.RECORD__NUMBER_OF_BYTES:
            setNumberOfBytes(NUMBER_OF_BYTES_EDEFAULT);
            return;
        case H86Package.RECORD__CHECKSUM:
            setChecksum(CHECKSUM_EDEFAULT);
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
        case H86Package.RECORD__TYPE:
            return type != TYPE_EDEFAULT;
        case H86Package.RECORD__NUMBER_OF_BYTES:
            return numberOfBytes != NUMBER_OF_BYTES_EDEFAULT;
        case H86Package.RECORD__CHECKSUM:
            return checksum != CHECKSUM_EDEFAULT;
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
        result.append(", numberOfBytes: ");
        result.append(numberOfBytes);
        result.append(", checksum: ");
        result.append(checksum);
        result.append(')');
        return result.toString();
    }

} // RecordImpl
