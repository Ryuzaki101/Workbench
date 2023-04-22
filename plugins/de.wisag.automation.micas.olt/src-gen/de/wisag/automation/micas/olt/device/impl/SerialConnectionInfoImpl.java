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
import de.wisag.automation.micas.olt.device.SerialConnectionInfo;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Serial
 * Connection Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl#getPort
 * <em>Port</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl#getBaudRate
 * <em>Baud Rate</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl#getStopBits
 * <em>Stop Bits</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl#getDataBits
 * <em>Data Bits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SerialConnectionInfoImpl extends ConnectionInfoImpl implements SerialConnectionInfo {
    /**
     * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected static final String PORT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected String port = PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getBaudRate() <em>Baud Rate</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBaudRate()
     * @generated
     * @ordered
     */
    protected static final int BAUD_RATE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getBaudRate() <em>Baud Rate</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBaudRate()
     * @generated
     * @ordered
     */
    protected int baudRate = BAUD_RATE_EDEFAULT;

    /**
     * The default value of the '{@link #getStopBits() <em>Stop Bits</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStopBits()
     * @generated
     * @ordered
     */
    protected static final int STOP_BITS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStopBits() <em>Stop Bits</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStopBits()
     * @generated
     * @ordered
     */
    protected int stopBits = STOP_BITS_EDEFAULT;

    /**
     * The default value of the '{@link #getDataBits() <em>Data Bits</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDataBits()
     * @generated
     * @ordered
     */
    protected static final int DATA_BITS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDataBits() <em>Data Bits</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDataBits()
     * @generated
     * @ordered
     */
    protected int dataBits = DATA_BITS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SerialConnectionInfoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DevicePackage.Literals.SERIAL_CONNECTION_INFO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPort() {
        return port;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPort(String newPort) {
        String oldPort = port;
        port = newPort;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.SERIAL_CONNECTION_INFO__PORT, oldPort,
                    port));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getBaudRate() {
        return baudRate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBaudRate(int newBaudRate) {
        int oldBaudRate = baudRate;
        baudRate = newBaudRate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.SERIAL_CONNECTION_INFO__BAUD_RATE,
                    oldBaudRate, baudRate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getStopBits() {
        return stopBits;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStopBits(int newStopBits) {
        int oldStopBits = stopBits;
        stopBits = newStopBits;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.SERIAL_CONNECTION_INFO__STOP_BITS,
                    oldStopBits, stopBits));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getDataBits() {
        return dataBits;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDataBits(int newDataBits) {
        int oldDataBits = dataBits;
        dataBits = newDataBits;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.SERIAL_CONNECTION_INFO__DATA_BITS,
                    oldDataBits, dataBits));
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
        case DevicePackage.SERIAL_CONNECTION_INFO__PORT:
            return getPort();
        case DevicePackage.SERIAL_CONNECTION_INFO__BAUD_RATE:
            return getBaudRate();
        case DevicePackage.SERIAL_CONNECTION_INFO__STOP_BITS:
            return getStopBits();
        case DevicePackage.SERIAL_CONNECTION_INFO__DATA_BITS:
            return getDataBits();
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
        case DevicePackage.SERIAL_CONNECTION_INFO__PORT:
            setPort((String) newValue);
            return;
        case DevicePackage.SERIAL_CONNECTION_INFO__BAUD_RATE:
            setBaudRate((Integer) newValue);
            return;
        case DevicePackage.SERIAL_CONNECTION_INFO__STOP_BITS:
            setStopBits((Integer) newValue);
            return;
        case DevicePackage.SERIAL_CONNECTION_INFO__DATA_BITS:
            setDataBits((Integer) newValue);
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
        case DevicePackage.SERIAL_CONNECTION_INFO__PORT:
            setPort(PORT_EDEFAULT);
            return;
        case DevicePackage.SERIAL_CONNECTION_INFO__BAUD_RATE:
            setBaudRate(BAUD_RATE_EDEFAULT);
            return;
        case DevicePackage.SERIAL_CONNECTION_INFO__STOP_BITS:
            setStopBits(STOP_BITS_EDEFAULT);
            return;
        case DevicePackage.SERIAL_CONNECTION_INFO__DATA_BITS:
            setDataBits(DATA_BITS_EDEFAULT);
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
        case DevicePackage.SERIAL_CONNECTION_INFO__PORT:
            return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
        case DevicePackage.SERIAL_CONNECTION_INFO__BAUD_RATE:
            return baudRate != BAUD_RATE_EDEFAULT;
        case DevicePackage.SERIAL_CONNECTION_INFO__STOP_BITS:
            return stopBits != STOP_BITS_EDEFAULT;
        case DevicePackage.SERIAL_CONNECTION_INFO__DATA_BITS:
            return dataBits != DATA_BITS_EDEFAULT;
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
        result.append(" (port: ");
        result.append(port);
        result.append(", baudRate: ");
        result.append(baudRate);
        result.append(", stopBits: ");
        result.append(stopBits);
        result.append(", dataBits: ");
        result.append(dataBits);
        result.append(')');
        return result.toString();
    }

} // SerialConnectionInfoImpl
