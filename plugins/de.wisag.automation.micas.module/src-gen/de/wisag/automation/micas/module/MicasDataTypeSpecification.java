/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import org.eclipselabs.damos.dml.DataTypeSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Micas
 * Data Type Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.MicasDataTypeSpecification#getDataType
 * <em>Data Type</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getMicasDataTypeSpecification()
 * @model
 * @generated
 */
public interface MicasDataTypeSpecification extends DataTypeSpecification {
    /**
     * Returns the value of the '<em><b>Data Type</b></em>' attribute. The
     * literals are from the enumeration
     * {@link de.wisag.automation.micas.module.DataType}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Data Type</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Type</em>' attribute.
     * @see de.wisag.automation.micas.module.DataType
     * @see #setDataType(DataType)
     * @see de.wisag.automation.micas.module.ModulePackage#getMicasDataTypeSpecification_DataType()
     * @model required="true"
     * @generated
     */
    DataType getDataType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.MicasDataTypeSpecification#getDataType
     * <em>Data Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Data Type</em>' attribute.
     * @see de.wisag.automation.micas.module.DataType
     * @see #getDataType()
     * @generated
     */
    void setDataType(DataType value);

} // MicasDataTypeSpecification
