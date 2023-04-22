/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Record</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.Record#getType <em>Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.h86.Record#getNumberOfBytes <em>Number
 * Of Bytes</em>}</li>
 * <li>{@link de.wisag.automation.micas.h86.Record#getChecksum
 * <em>Checksum</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.h86.H86Package#getRecord()
 * @model abstract="true"
 * @generated
 */
public interface Record extends EObject {
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals
     * are from the enumeration
     * {@link de.wisag.automation.micas.h86.RecordType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.h86.RecordType
     * @see #setType(RecordType)
     * @see de.wisag.automation.micas.h86.H86Package#getRecord_Type()
     * @model
     * @generated
     */
    RecordType getType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.h86.Record#getType <em>Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.h86.RecordType
     * @see #getType()
     * @generated
     */
    void setType(RecordType value);

    /**
     * Returns the value of the '<em><b>Number Of Bytes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Number Of Bytes</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Number Of Bytes</em>' attribute.
     * @see #setNumberOfBytes(int)
     * @see de.wisag.automation.micas.h86.H86Package#getRecord_NumberOfBytes()
     * @model
     * @generated
     */
    int getNumberOfBytes();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.h86.Record#getNumberOfBytes <em>Number
     * Of Bytes</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Number Of Bytes</em>' attribute.
     * @see #getNumberOfBytes()
     * @generated
     */
    void setNumberOfBytes(int value);

    /**
     * Returns the value of the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Checksum</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Checksum</em>' attribute.
     * @see #setChecksum(int)
     * @see de.wisag.automation.micas.h86.H86Package#getRecord_Checksum()
     * @model
     * @generated
     */
    int getChecksum();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.h86.Record#getChecksum
     * <em>Checksum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Checksum</em>' attribute.
     * @see #getChecksum()
     * @generated
     */
    void setChecksum(int value);

} // Record
