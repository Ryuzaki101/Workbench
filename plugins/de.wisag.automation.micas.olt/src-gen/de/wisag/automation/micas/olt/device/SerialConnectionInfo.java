/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Serial
 * Connection Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getPort
 * <em>Port</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getBaudRate
 * <em>Baud Rate</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getStopBits
 * <em>Stop Bits</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getDataBits
 * <em>Data Bits</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.olt.device.DevicePackage#getSerialConnectionInfo()
 * @model
 * @generated
 */
public interface SerialConnectionInfo extends ConnectionInfo {
    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getSerialConnectionInfo_Port()
     * @model
     * @generated
     */
    String getPort();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getPort
     * <em>Port</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort(String value);

    /**
     * Returns the value of the '<em><b>Baud Rate</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Baud Rate</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Baud Rate</em>' attribute.
     * @see #setBaudRate(int)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getSerialConnectionInfo_BaudRate()
     * @model
     * @generated
     */
    int getBaudRate();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getBaudRate
     * <em>Baud Rate</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Baud Rate</em>' attribute.
     * @see #getBaudRate()
     * @generated
     */
    void setBaudRate(int value);

    /**
     * Returns the value of the '<em><b>Stop Bits</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stop Bits</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Stop Bits</em>' attribute.
     * @see #setStopBits(int)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getSerialConnectionInfo_StopBits()
     * @model
     * @generated
     */
    int getStopBits();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getStopBits
     * <em>Stop Bits</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Stop Bits</em>' attribute.
     * @see #getStopBits()
     * @generated
     */
    void setStopBits(int value);

    /**
     * Returns the value of the '<em><b>Data Bits</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Bits</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Data Bits</em>' attribute.
     * @see #setDataBits(int)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getSerialConnectionInfo_DataBits()
     * @model
     * @generated
     */
    int getDataBits();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getDataBits
     * <em>Data Bits</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Data Bits</em>' attribute.
     * @see #getDataBits()
     * @generated
     */
    void setDataBits(int value);

} // SerialConnectionInfo
