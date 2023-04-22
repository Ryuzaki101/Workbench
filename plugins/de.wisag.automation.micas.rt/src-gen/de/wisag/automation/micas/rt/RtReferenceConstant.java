/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import de.wisag.automation.micas.hwmodules.PortDataType;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Reference Constant</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtReferenceConstant#getCol
 * <em>Col</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtReferenceConstant#getRow
 * <em>Row</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtReferenceConstant#getType
 * <em>Type</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtReferenceConstant()
 * @model
 * @generated
 */
public interface RtReferenceConstant extends RtConstant {
    /**
     * Returns the value of the '<em><b>Col</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Col</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Col</em>' attribute.
     * @see #setCol(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtReferenceConstant_Col()
     * @model
     * @generated
     */
    int getCol();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant#getCol
     * <em>Col</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Col</em>' attribute.
     * @see #getCol()
     * @generated
     */
    void setCol(int value);

    /**
     * Returns the value of the '<em><b>Row</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Row</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Row</em>' attribute.
     * @see #setRow(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtReferenceConstant_Row()
     * @model
     * @generated
     */
    int getRow();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant#getRow
     * <em>Row</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Row</em>' attribute.
     * @see #getRow()
     * @generated
     */
    void setRow(int value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals
     * are from the enumeration
     * {@link de.wisag.automation.micas.hwmodules.PortDataType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.hwmodules.PortDataType
     * @see #setType(PortDataType)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtReferenceConstant_Type()
     * @model
     * @generated
     */
    PortDataType getType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant#getType
     * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.hwmodules.PortDataType
     * @see #getType()
     * @generated
     */
    void setType(PortDataType value);

} // RtReferenceConstant
