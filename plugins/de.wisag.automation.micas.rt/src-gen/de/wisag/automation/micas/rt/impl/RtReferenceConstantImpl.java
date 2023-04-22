/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Reference Constant</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl#getCol
 * <em>Col</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl#getRow
 * <em>Row</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtReferenceConstantImpl#getType
 * <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtReferenceConstantImpl extends RtConstantImpl implements RtReferenceConstant {
    /**
     * The default value of the '{@link #getCol() <em>Col</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCol()
     * @generated
     * @ordered
     */
    protected static final int COL_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCol() <em>Col</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCol()
     * @generated
     * @ordered
     */
    protected int col = COL_EDEFAULT;

    /**
     * The default value of the '{@link #getRow() <em>Row</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRow()
     * @generated
     * @ordered
     */
    protected static final int ROW_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRow() <em>Row</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRow()
     * @generated
     * @ordered
     */
    protected int row = ROW_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final PortDataType TYPE_EDEFAULT = PortDataType.WORD_CONST;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected PortDataType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtReferenceConstantImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_REFERENCE_CONSTANT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getCol() {
        return col;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCol(int newCol) {
        int oldCol = col;
        col = newCol;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_REFERENCE_CONSTANT__COL, oldCol, col));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRow(int newRow) {
        int oldRow = row;
        row = newRow;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_REFERENCE_CONSTANT__ROW, oldRow, row));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PortDataType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setType(PortDataType newType) {
        PortDataType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_REFERENCE_CONSTANT__TYPE, oldType,
                    type));
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
        case RtPackage.RT_REFERENCE_CONSTANT__COL:
            return getCol();
        case RtPackage.RT_REFERENCE_CONSTANT__ROW:
            return getRow();
        case RtPackage.RT_REFERENCE_CONSTANT__TYPE:
            return getType();
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
        case RtPackage.RT_REFERENCE_CONSTANT__COL:
            setCol((Integer) newValue);
            return;
        case RtPackage.RT_REFERENCE_CONSTANT__ROW:
            setRow((Integer) newValue);
            return;
        case RtPackage.RT_REFERENCE_CONSTANT__TYPE:
            setType((PortDataType) newValue);
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
        case RtPackage.RT_REFERENCE_CONSTANT__COL:
            setCol(COL_EDEFAULT);
            return;
        case RtPackage.RT_REFERENCE_CONSTANT__ROW:
            setRow(ROW_EDEFAULT);
            return;
        case RtPackage.RT_REFERENCE_CONSTANT__TYPE:
            setType(TYPE_EDEFAULT);
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
        case RtPackage.RT_REFERENCE_CONSTANT__COL:
            return col != COL_EDEFAULT;
        case RtPackage.RT_REFERENCE_CONSTANT__ROW:
            return row != ROW_EDEFAULT;
        case RtPackage.RT_REFERENCE_CONSTANT__TYPE:
            return type != TYPE_EDEFAULT;
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
        result.append(" (col: ");
        result.append(col);
        result.append(", row: ");
        result.append(row);
        result.append(", type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

} // RtReferenceConstantImpl
