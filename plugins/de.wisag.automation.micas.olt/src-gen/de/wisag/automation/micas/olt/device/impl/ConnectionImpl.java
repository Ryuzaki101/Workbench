/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.wisag.automation.micas.olt.device.Connection;
import de.wisag.automation.micas.olt.device.ConnectionInfo;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.device.DevicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Connection</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl#getConnectionInfo
 * <em>Connection Info</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl#getLogin
 * <em>Login</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl#getPassword
 * <em>Password</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl#getConnectedSince
 * <em>Connected Since</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl#getDeviceInfo
 * <em>Device Info</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends EObjectImpl implements Connection {
    /**
     * The cached value of the '{@link #getConnectionInfo() <em>Connection
     * Info</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getConnectionInfo()
     * @generated
     * @ordered
     */
    protected ConnectionInfo connectionInfo;

    /**
     * The default value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected static final String LOGIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLogin() <em>Login</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLogin()
     * @generated
     * @ordered
     */
    protected String login = LOGIN_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected String password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getConnectedSince() <em>Connected
     * Since</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getConnectedSince()
     * @generated
     * @ordered
     */
    protected static final Date CONNECTED_SINCE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConnectedSince() <em>Connected
     * Since</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getConnectedSince()
     * @generated
     * @ordered
     */
    protected Date connectedSince = CONNECTED_SINCE_EDEFAULT;

    /**
     * The cached value of the '{@link #getDeviceInfo() <em>Device Info</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDeviceInfo()
     * @generated
     * @ordered
     */
    protected DeviceInfo deviceInfo;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConnectionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DevicePackage.Literals.CONNECTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConnectionInfo getConnectionInfo() {
        if (connectionInfo != null && connectionInfo.eIsProxy()) {
            InternalEObject oldConnectionInfo = (InternalEObject) connectionInfo;
            connectionInfo = (ConnectionInfo) eResolveProxy(oldConnectionInfo);
            if (connectionInfo != oldConnectionInfo) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DevicePackage.CONNECTION__CONNECTION_INFO,
                            oldConnectionInfo, connectionInfo));
                }
            }
        }
        return connectionInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ConnectionInfo basicGetConnectionInfo() {
        return connectionInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setConnectionInfo(ConnectionInfo newConnectionInfo) {
        ConnectionInfo oldConnectionInfo = connectionInfo;
        connectionInfo = newConnectionInfo;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.CONNECTION__CONNECTION_INFO,
                    oldConnectionInfo, connectionInfo));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getLogin() {
        return login;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLogin(String newLogin) {
        String oldLogin = login;
        login = newLogin;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.CONNECTION__LOGIN, oldLogin, login));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPassword(String newPassword) {
        String oldPassword = password;
        password = newPassword;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.CONNECTION__PASSWORD, oldPassword,
                    password));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Date getConnectedSince() {
        return connectedSince;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setConnectedSince(Date newConnectedSince) {
        Date oldConnectedSince = connectedSince;
        connectedSince = newConnectedSince;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.CONNECTION__CONNECTED_SINCE,
                    oldConnectedSince, connectedSince));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeviceInfo getDeviceInfo() {
        if (deviceInfo != null && deviceInfo.eIsProxy()) {
            InternalEObject oldDeviceInfo = (InternalEObject) deviceInfo;
            deviceInfo = (DeviceInfo) eResolveProxy(oldDeviceInfo);
            if (deviceInfo != oldDeviceInfo) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DevicePackage.CONNECTION__DEVICE_INFO,
                            oldDeviceInfo, deviceInfo));
                }
            }
        }
        return deviceInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DeviceInfo basicGetDeviceInfo() {
        return deviceInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDeviceInfo(DeviceInfo newDeviceInfo) {
        DeviceInfo oldDeviceInfo = deviceInfo;
        deviceInfo = newDeviceInfo;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.CONNECTION__DEVICE_INFO, oldDeviceInfo,
                    deviceInfo));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case DevicePackage.CONNECTION__CONNECTION_INFO:
            if (resolve) {
                return getConnectionInfo();
            }
            return basicGetConnectionInfo();
        case DevicePackage.CONNECTION__LOGIN:
            return getLogin();
        case DevicePackage.CONNECTION__PASSWORD:
            return getPassword();
        case DevicePackage.CONNECTION__CONNECTED_SINCE:
            return getConnectedSince();
        case DevicePackage.CONNECTION__DEVICE_INFO:
            if (resolve) {
                return getDeviceInfo();
            }
            return basicGetDeviceInfo();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case DevicePackage.CONNECTION__CONNECTION_INFO:
            setConnectionInfo((ConnectionInfo) newValue);
            return;
        case DevicePackage.CONNECTION__LOGIN:
            setLogin((String) newValue);
            return;
        case DevicePackage.CONNECTION__PASSWORD:
            setPassword((String) newValue);
            return;
        case DevicePackage.CONNECTION__CONNECTED_SINCE:
            setConnectedSince((Date) newValue);
            return;
        case DevicePackage.CONNECTION__DEVICE_INFO:
            setDeviceInfo((DeviceInfo) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case DevicePackage.CONNECTION__CONNECTION_INFO:
            setConnectionInfo((ConnectionInfo) null);
            return;
        case DevicePackage.CONNECTION__LOGIN:
            setLogin(LOGIN_EDEFAULT);
            return;
        case DevicePackage.CONNECTION__PASSWORD:
            setPassword(PASSWORD_EDEFAULT);
            return;
        case DevicePackage.CONNECTION__CONNECTED_SINCE:
            setConnectedSince(CONNECTED_SINCE_EDEFAULT);
            return;
        case DevicePackage.CONNECTION__DEVICE_INFO:
            setDeviceInfo((DeviceInfo) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case DevicePackage.CONNECTION__CONNECTION_INFO:
            return connectionInfo != null;
        case DevicePackage.CONNECTION__LOGIN:
            return LOGIN_EDEFAULT == null ? login != null : !LOGIN_EDEFAULT.equals(login);
        case DevicePackage.CONNECTION__PASSWORD:
            return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
        case DevicePackage.CONNECTION__CONNECTED_SINCE:
            return CONNECTED_SINCE_EDEFAULT == null ? connectedSince != null
                    : !CONNECTED_SINCE_EDEFAULT.equals(connectedSince);
        case DevicePackage.CONNECTION__DEVICE_INFO:
            return deviceInfo != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (login: ");
        result.append(login);
        result.append(", password: ");
        result.append(password);
        result.append(", connectedSince: ");
        result.append(connectedSince);
        result.append(')');
        return result.toString();
    }

} // ConnectionImpl
