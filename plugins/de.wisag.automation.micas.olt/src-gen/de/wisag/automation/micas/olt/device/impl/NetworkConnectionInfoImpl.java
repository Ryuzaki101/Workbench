/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.wisag.automation.micas.olt.device.DevicePackage;
import de.wisag.automation.micas.olt.device.NetworkConnectionInfo;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Network
 * Connection Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.NetworkConnectionInfoImpl#getIpv4Address
 * <em>Ipv4 Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.NetworkConnectionInfoImpl#getHostname
 * <em>Hostname</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NetworkConnectionInfoImpl extends ConnectionInfoImpl implements NetworkConnectionInfo {
    /**
     * The default value of the '{@link #getIpv4Address() <em>Ipv4
     * Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIpv4Address()
     * @generated
     * @ordered
     */
    protected static final String IPV4_ADDRESS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIpv4Address() <em>Ipv4 Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIpv4Address()
     * @generated
     * @ordered
     */
    protected String ipv4Address = IPV4_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getHostname() <em>Hostname</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHostname()
     * @generated
     * @ordered
     */
    protected static final String HOSTNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHostname() <em>Hostname</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHostname()
     * @generated
     * @ordered
     */
    protected String hostname = HOSTNAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected NetworkConnectionInfoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DevicePackage.Literals.NETWORK_CONNECTION_INFO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getIpv4Address() {
        return ipv4Address;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIpv4Address(String newIpv4Address) {
        String oldIpv4Address = ipv4Address;
        ipv4Address = newIpv4Address;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.NETWORK_CONNECTION_INFO__IPV4_ADDRESS,
                    oldIpv4Address, ipv4Address));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getHostname() {
        return hostname;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHostname(String newHostname) {
        String oldHostname = hostname;
        hostname = newHostname;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.NETWORK_CONNECTION_INFO__HOSTNAME,
                    oldHostname, hostname));
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
        case DevicePackage.NETWORK_CONNECTION_INFO__IPV4_ADDRESS:
            return getIpv4Address();
        case DevicePackage.NETWORK_CONNECTION_INFO__HOSTNAME:
            return getHostname();
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
        case DevicePackage.NETWORK_CONNECTION_INFO__IPV4_ADDRESS:
            setIpv4Address((String) newValue);
            return;
        case DevicePackage.NETWORK_CONNECTION_INFO__HOSTNAME:
            setHostname((String) newValue);
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
        case DevicePackage.NETWORK_CONNECTION_INFO__IPV4_ADDRESS:
            setIpv4Address(IPV4_ADDRESS_EDEFAULT);
            return;
        case DevicePackage.NETWORK_CONNECTION_INFO__HOSTNAME:
            setHostname(HOSTNAME_EDEFAULT);
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
        case DevicePackage.NETWORK_CONNECTION_INFO__IPV4_ADDRESS:
            return IPV4_ADDRESS_EDEFAULT == null ? ipv4Address != null : !IPV4_ADDRESS_EDEFAULT.equals(ipv4Address);
        case DevicePackage.NETWORK_CONNECTION_INFO__HOSTNAME:
            return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
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
        result.append(" (ipv4Address: ");
        result.append(ipv4Address);
        result.append(", hostname: ");
        result.append(hostname);
        result.append(')');
        return result.toString();
    }

} // NetworkConnectionInfoImpl
