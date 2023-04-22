/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Reference Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.ReferenceAttribute#getRow
 * <em>Row</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.ReferenceAttribute#getColumn
 * <em>Column</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.ReferenceAttribute#getReferenceType
 * <em>Reference Type</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getReferenceAttribute()
 * @model
 * @generated
 */
public interface ReferenceAttribute extends Attribute {
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
     * @see de.wisag.automation.micas.module.ModulePackage#getReferenceAttribute_Row()
     * @model required="true" ordered="false"
     * @generated
     */
    int getRow();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getRow
     * <em>Row</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Row</em>' attribute.
     * @see #getRow()
     * @generated
     */
    void setRow(int value);

    /**
     * Returns the value of the '<em><b>Column</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Column</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Column</em>' attribute.
     * @see #isSetColumn()
     * @see #unsetColumn()
     * @see #setColumn(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getReferenceAttribute_Column()
     * @model unsettable="true" ordered="false"
     * @generated
     */
    int getColumn();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getColumn
     * <em>Column</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Column</em>' attribute.
     * @see #isSetColumn()
     * @see #unsetColumn()
     * @see #getColumn()
     * @generated
     */
    void setColumn(int value);

    /**
     * Unsets the value of the
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getColumn
     * <em>Column</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #isSetColumn()
     * @see #getColumn()
     * @see #setColumn(int)
     * @generated
     */
    void unsetColumn();

    /**
     * Returns whether the value of the
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getColumn
     * <em>Column</em>}' attribute is set. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return whether the value of the '<em>Column</em>' attribute is set.
     * @see #unsetColumn()
     * @see #getColumn()
     * @see #setColumn(int)
     * @generated
     */
    boolean isSetColumn();

    /**
     * Returns the value of the '<em><b>Reference Type</b></em>' attribute. The
     * literals are from the enumeration
     * {@link de.wisag.automation.micas.module.ReferenceType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Reference Type</em>' attribute.
     * @see de.wisag.automation.micas.module.ReferenceType
     * @see #setReferenceType(ReferenceType)
     * @see de.wisag.automation.micas.module.ModulePackage#getReferenceAttribute_ReferenceType()
     * @model
     * @generated
     */
    ReferenceType getReferenceType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute#getReferenceType
     * <em>Reference Type</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Reference Type</em>' attribute.
     * @see de.wisag.automation.micas.module.ReferenceType
     * @see #getReferenceType()
     * @generated
     */
    void setReferenceType(ReferenceType value);

} // ReferenceAttribute
