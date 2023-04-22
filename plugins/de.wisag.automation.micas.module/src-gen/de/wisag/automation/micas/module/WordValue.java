/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Word
 * Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.WordValue#getValue
 * <em>Value</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getWordValue()
 * @model
 * @generated
 */
public interface WordValue extends Value {
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getWordValue_Value()
     * @model required="true" ordered="false"
     * @generated
     */
    int getValue();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.WordValue#getValue
     * <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(int value);

} // WordValue
