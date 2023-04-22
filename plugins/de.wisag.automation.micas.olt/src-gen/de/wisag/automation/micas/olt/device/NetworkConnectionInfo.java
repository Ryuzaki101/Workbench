/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Network
 * Connection Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getIpv4Address
 * <em>Ipv4 Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getHostname
 * <em>Hostname</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.olt.device.DevicePackage#getNetworkConnectionInfo()
 * @model
 * @generated
 */
public interface NetworkConnectionInfo extends ConnectionInfo {
    /**
     * Returns the value of the '<em><b>Ipv4 Address</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ipv4 Address</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ipv4 Address</em>' attribute.
     * @see #setIpv4Address(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getNetworkConnectionInfo_Ipv4Address()
     * @model
     * @generated
     */
    String getIpv4Address();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getIpv4Address
     * <em>Ipv4 Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Ipv4 Address</em>' attribute.
     * @see #getIpv4Address()
     * @generated
     */
    void setIpv4Address(String value);

    /**
     * Returns the value of the '<em><b>Hostname</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hostname</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Hostname</em>' attribute.
     * @see #setHostname(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getNetworkConnectionInfo_Hostname()
     * @model
     * @generated
     */
    String getHostname();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getHostname
     * <em>Hostname</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Hostname</em>' attribute.
     * @see #getHostname()
     * @generated
     */
    void setHostname(String value);

} // NetworkConnectionInfo
