/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Port</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.Port#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.Port#getAllowedPortDataTypes
 * <em>Allowed Port Data Types</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.Port#isInputPort <em>Input
 * Port</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.Port#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.Port#getDisplayName
 * <em>Display Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.Port#getDescription
 * <em>Description</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends EObject {
    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort_Index()
     * @model
     * @generated
     */
    int getIndex();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.Port#getIndex
     * <em>Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
    void setIndex(int value);

    /**
     * Returns the value of the '<em><b>Allowed Port Data Types</b></em>'
     * attribute list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.PortDataType}. The literals
     * are from the enumeration
     * {@link de.wisag.automation.micas.hwmodules.PortDataType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allowed Port Data Types</em>' attribute list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Allowed Port Data Types</em>' attribute
     *         list.
     * @see de.wisag.automation.micas.hwmodules.PortDataType
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort_AllowedPortDataTypes()
     * @model
     * @generated
     */
    EList<PortDataType> getAllowedPortDataTypes();

    /**
     * Returns the value of the '<em><b>Input Port</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Port</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Input Port</em>' attribute.
     * @see #setInputPort(boolean)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort_InputPort()
     * @model
     * @generated
     */
    boolean isInputPort();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.Port#isInputPort <em>Input
     * Port</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Input Port</em>' attribute.
     * @see #isInputPort()
     * @generated
     */
    void setInputPort(boolean value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. The default
     * value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort_Name()
     * @model default="n/a"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.Port#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Display Name</b></em>' attribute. The
     * default value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Display Name</em>' attribute.
     * @see #setDisplayName(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort_DisplayName()
     * @model default="n/a"
     * @generated
     */
    String getDisplayName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.Port#getDisplayName
     * <em>Display Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Display Name</em>' attribute.
     * @see #getDisplayName()
     * @generated
     */
    void setDisplayName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. The
     * default value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getPort_Description()
     * @model default="n/a"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.Port#getDescription
     * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

} // Port
