/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data
 * Record</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.DataRecord#getData
 * <em>Data</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.h86.H86Package#getDataRecord()
 * @model
 * @generated
 */
public interface DataRecord extends AddressRecord {
    /**
     * Returns the value of the '<em><b>Data</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data</em>' attribute.
     * @see #setData(byte[])
     * @see de.wisag.automation.micas.h86.H86Package#getDataRecord_Data()
     * @model
     * @generated
     */
    byte[] getData();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.h86.DataRecord#getData <em>Data</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data</em>' attribute.
     * @see #getData()
     * @generated
     */
    void setData(byte[] value);

} // DataRecord
