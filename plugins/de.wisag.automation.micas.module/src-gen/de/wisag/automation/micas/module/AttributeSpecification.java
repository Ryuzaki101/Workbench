/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import org.eclipselabs.damos.dml.SignalSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Attribute Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.AttributeSpecification#getAttribute
 * <em>Attribute</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getAttributeSpecification()
 * @model
 * @generated
 */
public interface AttributeSpecification extends SignalSpecification {
    /**
     * Returns the value of the '<em><b>Attribute</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Attribute</em>' reference.
     * @see #setAttribute(Attribute)
     * @see de.wisag.automation.micas.module.ModulePackage#getAttributeSpecification_Attribute()
     * @model required="true"
     * @generated
     */
    Attribute getAttribute();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.AttributeSpecification#getAttribute
     * <em>Attribute</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Attribute</em>' reference.
     * @see #getAttribute()
     * @generated
     */
    void setAttribute(Attribute value);

} // AttributeSpecification
