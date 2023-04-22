/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.Attribute#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Attribute#getDataType <em>Data
 * Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Attribute#getDescription
 * <em>Description</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getAttribute()
 * @model abstract="true"
 * @generated
 */
public interface Attribute extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.wisag.automation.micas.module.ModulePackage#getAttribute_Name()
     * @model required="true" ordered="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Attribute#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

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
     * @see de.wisag.automation.micas.module.ModulePackage#getAttribute_DataType()
     * @model required="true" ordered="false"
     * @generated
     */
    DataType getDataType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Attribute#getDataType <em>Data
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data Type</em>' attribute.
     * @see de.wisag.automation.micas.module.DataType
     * @see #getDataType()
     * @generated
     */
    void setDataType(DataType value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. The
     * default value is <code>"\"\""</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see de.wisag.automation.micas.module.ModulePackage#getAttribute_Description()
     * @model default="\"\""
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Attribute#getDescription
     * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

} // Attribute
