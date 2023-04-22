/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Address</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.Address#getSegment
 * <em>Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.Address#getOffset
 * <em>Offset</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.olt.device.DevicePackage#getAddress()
 * @model
 * @generated
 */
public interface Address extends EObject {
    /**
     * Returns the value of the '<em><b>Segment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Segment</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Segment</em>' attribute.
     * @see #setSegment(int)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getAddress_Segment()
     * @model
     * @generated
     */
    int getSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Address#getSegment
     * <em>Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Segment</em>' attribute.
     * @see #getSegment()
     * @generated
     */
    void setSegment(int value);

    /**
     * Returns the value of the '<em><b>Offset</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offset</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Offset</em>' attribute.
     * @see #setOffset(int)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getAddress_Offset()
     * @model
     * @generated
     */
    int getOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Address#getOffset
     * <em>Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Offset</em>' attribute.
     * @see #getOffset()
     * @generated
     */
    void setOffset(int value);

} // Address
