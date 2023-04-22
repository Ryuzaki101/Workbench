/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Connection</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.Connection#getConnectionInfo
 * <em>Connection Info</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.Connection#getLogin
 * <em>Login</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.Connection#getPassword
 * <em>Password</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.Connection#getConnectedSince
 * <em>Connected Since</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.Connection#getDeviceInfo
 * <em>Device Info</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.olt.device.DevicePackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
    /**
     * Returns the value of the '<em><b>Connection Info</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Info</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Connection Info</em>' reference.
     * @see #setConnectionInfo(ConnectionInfo)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getConnection_ConnectionInfo()
     * @model
     * @generated
     */
    ConnectionInfo getConnectionInfo();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Connection#getConnectionInfo
     * <em>Connection Info</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Connection Info</em>' reference.
     * @see #getConnectionInfo()
     * @generated
     */
    void setConnectionInfo(ConnectionInfo value);

    /**
     * Returns the value of the '<em><b>Login</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Login</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Login</em>' attribute.
     * @see #setLogin(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getConnection_Login()
     * @model
     * @generated
     */
    String getLogin();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Connection#getLogin
     * <em>Login</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Login</em>' attribute.
     * @see #getLogin()
     * @generated
     */
    void setLogin(String value);

    /**
     * Returns the value of the '<em><b>Password</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Password</em>' attribute.
     * @see #setPassword(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getConnection_Password()
     * @model
     * @generated
     */
    String getPassword();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Connection#getPassword
     * <em>Password</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */
    void setPassword(String value);

    /**
     * Returns the value of the '<em><b>Connected Since</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connected Since</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Connected Since</em>' attribute.
     * @see #setConnectedSince(Date)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getConnection_ConnectedSince()
     * @model
     * @generated
     */
    Date getConnectedSince();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Connection#getConnectedSince
     * <em>Connected Since</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Connected Since</em>' attribute.
     * @see #getConnectedSince()
     * @generated
     */
    void setConnectedSince(Date value);

    /**
     * Returns the value of the '<em><b>Device Info</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device Info</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Device Info</em>' reference.
     * @see #setDeviceInfo(DeviceInfo)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getConnection_DeviceInfo()
     * @model
     * @generated
     */
    DeviceInfo getDeviceInfo();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.Connection#getDeviceInfo
     * <em>Device Info</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Device Info</em>' reference.
     * @see #getDeviceInfo()
     * @generated
     */
    void setDeviceInfo(DeviceInfo value);

} // Connection
