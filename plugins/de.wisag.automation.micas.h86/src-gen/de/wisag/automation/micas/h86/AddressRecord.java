/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Address
 * Record</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.AddressRecord#getAddress
 * <em>Address</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.h86.H86Package#getAddressRecord()
 * @model
 * @generated
 */
public interface AddressRecord extends Record {
    /**
     * Returns the value of the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Address</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Address</em>' attribute.
     * @see #setAddress(int)
     * @see de.wisag.automation.micas.h86.H86Package#getAddressRecord_Address()
     * @model
     * @generated
     */
    int getAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.h86.AddressRecord#getAddress
     * <em>Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Address</em>' attribute.
     * @see #getAddress()
     * @generated
     */
    void setAddress(int value);

} // AddressRecord
