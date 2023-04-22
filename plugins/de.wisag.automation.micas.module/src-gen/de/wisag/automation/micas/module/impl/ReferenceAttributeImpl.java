/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Reference Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.impl.ReferenceAttributeImpl#getRow
 * <em>Row</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ReferenceAttributeImpl#getColumn
 * <em>Column</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ReferenceAttributeImpl#getReferenceType
 * <em>Reference Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceAttributeImpl extends AttributeImpl implements ReferenceAttribute {
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
     * The default value of the '{@link #getColumn() <em>Column</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getColumn()
     * @generated
     * @ordered
     */
    protected static final int COLUMN_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getColumn()
     * @generated
     * @ordered
     */
    protected int column = COLUMN_EDEFAULT;

    /**
     * This is true if the Column attribute has been set. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected boolean columnESet;

    /**
     * The default value of the '{@link #getReferenceType() <em>Reference
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getReferenceType()
     * @generated
     * @ordered
     */
    protected static final ReferenceType REFERENCE_TYPE_EDEFAULT = ReferenceType.FGA_VALUE;

    /**
     * The cached value of the '{@link #getReferenceType() <em>Reference
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getReferenceType()
     * @generated
     * @ordered
     */
    protected ReferenceType referenceType = REFERENCE_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ReferenceAttributeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModulePackage.Literals.REFERENCE_ATTRIBUTE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.REFERENCE_ATTRIBUTE__ROW, oldRow, row));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setColumn(int newColumn) {
        int oldColumn = column;
        column = newColumn;
        boolean oldColumnESet = columnESet;
        columnESet = true;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.REFERENCE_ATTRIBUTE__COLUMN, oldColumn,
                    column, !oldColumnESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void unsetColumn() {
        int oldColumn = column;
        boolean oldColumnESet = columnESet;
        column = COLUMN_EDEFAULT;
        columnESet = false;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.UNSET, ModulePackage.REFERENCE_ATTRIBUTE__COLUMN,
                    oldColumn, COLUMN_EDEFAULT, oldColumnESet));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isSetColumn() {
        return columnESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ReferenceType getReferenceType() {
        return referenceType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setReferenceType(ReferenceType newReferenceType) {
        ReferenceType oldReferenceType = referenceType;
        referenceType = newReferenceType == null ? REFERENCE_TYPE_EDEFAULT : newReferenceType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.REFERENCE_ATTRIBUTE__REFERENCE_TYPE,
                    oldReferenceType, referenceType));
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
        case ModulePackage.REFERENCE_ATTRIBUTE__ROW:
            return getRow();
        case ModulePackage.REFERENCE_ATTRIBUTE__COLUMN:
            return getColumn();
        case ModulePackage.REFERENCE_ATTRIBUTE__REFERENCE_TYPE:
            return getReferenceType();
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
        case ModulePackage.REFERENCE_ATTRIBUTE__ROW:
            setRow((Integer) newValue);
            return;
        case ModulePackage.REFERENCE_ATTRIBUTE__COLUMN:
            setColumn((Integer) newValue);
            return;
        case ModulePackage.REFERENCE_ATTRIBUTE__REFERENCE_TYPE:
            setReferenceType((ReferenceType) newValue);
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
        case ModulePackage.REFERENCE_ATTRIBUTE__ROW:
            setRow(ROW_EDEFAULT);
            return;
        case ModulePackage.REFERENCE_ATTRIBUTE__COLUMN:
            unsetColumn();
            return;
        case ModulePackage.REFERENCE_ATTRIBUTE__REFERENCE_TYPE:
            setReferenceType(REFERENCE_TYPE_EDEFAULT);
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
        case ModulePackage.REFERENCE_ATTRIBUTE__ROW:
            return row != ROW_EDEFAULT;
        case ModulePackage.REFERENCE_ATTRIBUTE__COLUMN:
            return isSetColumn();
        case ModulePackage.REFERENCE_ATTRIBUTE__REFERENCE_TYPE:
            return referenceType != REFERENCE_TYPE_EDEFAULT;
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
        result.append(" (row: ");
        result.append(row);
        result.append(", column: ");
        if (columnESet) {
            result.append(column);
        } else {
            result.append("<unset>");
        }
        result.append(", referenceType: ");
        result.append(referenceType);
        result.append(')');
        return result.toString();
    }

} // ReferenceAttributeImpl
