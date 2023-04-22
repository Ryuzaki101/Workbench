/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Word
 * Constant</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtWordConstant#getValue
 * <em>Value</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtWordConstant()
 * @model
 * @generated
 */
public interface RtWordConstant extends RtConstant {
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
     * @see de.wisag.automation.micas.rt.RtPackage#getRtWordConstant_Value()
     * @model
     * @generated
     */
    int getValue();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtWordConstant#getValue
     * <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(int value);

} // RtWordConstant
