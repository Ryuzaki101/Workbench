/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Constant
 * Attribute</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.ConstantAttribute#getValue
 * <em>Value</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getConstantAttribute()
 * @model
 * @generated
 */
public interface ConstantAttribute extends Attribute {
    /**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(Value)
     * @see de.wisag.automation.micas.module.ModulePackage#getConstantAttribute_Value()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Value getValue();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.ConstantAttribute#getValue
     * <em>Value</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
    void setValue(Value value);

} // ConstantAttribute
