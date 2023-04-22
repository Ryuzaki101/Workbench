/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Symbol</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbol#getAddress
 * <em>Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbol#getName <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbol#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbol#getAccessors
 * <em>Accessors</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtSymbol#getIndex
 * <em>Index</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbol()
 * @model
 * @generated
 */
public interface RtSymbol extends EObject {
    /**
     * Returns the value of the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Address</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Address</em>' attribute.
     * @see #setAddress(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbol_Address()
     * @model id="true"
     * @generated
     */
    int getAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getAddress
     * <em>Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Address</em>' attribute.
     * @see #getAddress()
     * @generated
     */
    void setAddress(int value);

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
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbol_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Module</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtModule#getSymbols
     * <em>Symbols</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Module</em>' container reference.
     * @see #setModule(RtModule)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbol_Module()
     * @see de.wisag.automation.micas.rt.RtModule#getSymbols
     * @model opposite="symbols" transient="false"
     * @generated
     */
    RtModule getModule();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getModule <em>Module</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Module</em>' container reference.
     * @see #getModule()
     * @generated
     */
    void setModule(RtModule value);

    /**
     * Returns the value of the '<em><b>Accessors</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.wisag.automation.micas.rt.RtSymbolAccess}. It is bidirectional
     * and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getSymbol
     * <em>Symbol</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Accessors</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Accessors</em>' containment reference list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbol_Accessors()
     * @see de.wisag.automation.micas.rt.RtSymbolAccess#getSymbol
     * @model opposite="symbol" containment="true"
     * @generated
     */
    EList<RtSymbolAccess> getAccessors();

    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute. The default
     * value is <code>"-1"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtSymbol_Index()
     * @model default="-1"
     * @generated
     */
    int getIndex();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtSymbol#getIndex <em>Index</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
    void setIndex(int value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getDisplayName(this);'"
     * @generated
     */
    String getDisplayName();

} // RtSymbol
