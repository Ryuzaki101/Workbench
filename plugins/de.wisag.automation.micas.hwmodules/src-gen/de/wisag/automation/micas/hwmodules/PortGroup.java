/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Port
 * Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.PortGroup#getRuntime
 * <em>Runtime</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPortGroup()
 * @model
 * @generated
 */
public interface PortGroup extends Port {
    /**
     * Returns the value of the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Runtime</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Runtime</em>' attribute.
     * @see #setRuntime(long)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPortGroup_Runtime()
     * @model
     * @generated
     */
    long getRuntime();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.PortGroup#getRuntime
     * <em>Runtime</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Runtime</em>' attribute.
     * @see #getRuntime()
     * @generated
     */
    void setRuntime(long value);

} // PortGroup
