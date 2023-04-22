/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Data
 * Range</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.DataRange#getStartAddress
 * <em>Start Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DataRange#getValues
 * <em>Values</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.olt.device.DevicePackage#getDataRange()
 * @model
 * @generated
 */
public interface DataRange extends EObject {
    /**
     * Returns the value of the '<em><b>Start Address</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Address</em>' containment reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Start Address</em>' containment reference.
     * @see #setStartAddress(Address)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDataRange_StartAddress()
     * @model containment="true"
     * @generated
     */
    Address getStartAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DataRange#getStartAddress
     * <em>Start Address</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Start Address</em>' containment
     *            reference.
     * @see #getStartAddress()
     * @generated
     */
    void setStartAddress(Address value);

    /**
     * Returns the value of the '<em><b>Values</b></em>' attribute list. The
     * list contents are of type {@link java.lang.Integer}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Values</em>' attribute list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Values</em>' attribute list.
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDataRange_Values()
     * @model
     * @generated
     */
    EList<Integer> getValues();

} // DataRange
