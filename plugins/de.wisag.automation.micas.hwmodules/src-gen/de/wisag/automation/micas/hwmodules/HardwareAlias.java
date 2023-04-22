/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hardware
 * Alias</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareAlias#getName
 * <em>Name</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareAlias()
 * @model
 * @generated
 */
public interface HardwareAlias extends EObject {
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
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareAlias_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareAlias#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // HardwareAlias
