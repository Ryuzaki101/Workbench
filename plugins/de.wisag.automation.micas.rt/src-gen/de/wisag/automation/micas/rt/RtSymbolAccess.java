/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Symbol
 * Access</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbolAccess#getSymbol
 * <em>Symbol</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbolAccess#getModuleInvocation
 * <em>Module Invocation</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbolAccess#getType
 * <em>Type</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbolAccess()
 * @model
 * @generated
 */
public interface RtSymbolAccess extends EObject {
    /**
     * Returns the value of the '<em><b>Symbol</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getAccessors
     * <em>Accessors</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Symbol</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Symbol</em>' container reference.
     * @see #setSymbol(RtSymbol)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbolAccess_Symbol()
     * @see de.wisag.automation.micas.rt.RtSymbol#getAccessors
     * @model opposite="accessors" transient="false"
     * @generated
     */
    RtSymbol getSymbol();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getSymbol
     * <em>Symbol</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Symbol</em>' container reference.
     * @see #getSymbol()
     * @generated
     */
    void setSymbol(RtSymbol value);

    /**
     * Returns the value of the '<em><b>Module Invocation</b></em>' reference.
     * It is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getArguments
     * <em>Arguments</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module Invocation</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Module Invocation</em>' reference.
     * @see #setModuleInvocation(RtModuleInvocation)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbolAccess_ModuleInvocation()
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getArguments
     * @model opposite="arguments"
     * @generated
     */
    RtModuleInvocation getModuleInvocation();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getModuleInvocation
     * <em>Module Invocation</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Module Invocation</em>' reference.
     * @see #getModuleInvocation()
     * @generated
     */
    void setModuleInvocation(RtModuleInvocation value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals
     * are from the enumeration
     * {@link de.wisag.automation.micas.rt.RtSymbolAccessType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtSymbolAccessType
     * @see #setType(RtSymbolAccessType)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbolAccess_Type()
     * @model
     * @generated
     */
    RtSymbolAccessType getType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getType
     * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtSymbolAccessType
     * @see #getType()
     * @generated
     */
    void setType(RtSymbolAccessType value);

} // RtSymbolAccess
