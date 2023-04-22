/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.Connection;
import de.wisag.automation.micas.olt.device.ConnectionInfo;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DeviceFactory;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.device.DevicePackage;
import de.wisag.automation.micas.olt.device.NetworkConnectionInfo;
import de.wisag.automation.micas.olt.device.SerialConnectionInfo;
import de.wisag.automation.micas.olt.device.SerialParity;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class DeviceFactoryImpl extends EFactoryImpl implements DeviceFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static DeviceFactory init() {
        try {
            DeviceFactory theDeviceFactory = (DeviceFactory) EPackage.Registry.INSTANCE
                    .getEFactory(DevicePackage.eNS_URI);
            if (theDeviceFactory != null) {
                return theDeviceFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DeviceFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public DeviceFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case DevicePackage.DEVICE_INFO:
            return createDeviceInfo();
        case DevicePackage.CONNECTION_INFO:
            return createConnectionInfo();
        case DevicePackage.NETWORK_CONNECTION_INFO:
            return createNetworkConnectionInfo();
        case DevicePackage.SERIAL_CONNECTION_INFO:
            return createSerialConnectionInfo();
        case DevicePackage.CONNECTION:
            return createConnection();
        case DevicePackage.ADDRESS:
            return createAddress();
        case DevicePackage.DATA_RANGE:
            return createDataRange();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case DevicePackage.SERIAL_PARITY:
            return createSerialParityFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case DevicePackage.SERIAL_PARITY:
            return convertSerialParityToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeviceInfo createDeviceInfo() {
        DeviceInfoImpl deviceInfo = new DeviceInfoImpl();
        return deviceInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ConnectionInfo createConnectionInfo() {
        ConnectionInfoImpl connectionInfo = new ConnectionInfoImpl();
        return connectionInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NetworkConnectionInfo createNetworkConnectionInfo() {
        NetworkConnectionInfoImpl networkConnectionInfo = new NetworkConnectionInfoImpl();
        return networkConnectionInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SerialConnectionInfo createSerialConnectionInfo() {
        SerialConnectionInfoImpl serialConnectionInfo = new SerialConnectionInfoImpl();
        return serialConnectionInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Connection createConnection() {
        ConnectionImpl connection = new ConnectionImpl();
        return connection;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Address createAddress() {
        AddressImpl address = new AddressImpl();
        return address;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DataRange createDataRange() {
        DataRangeImpl dataRange = new DataRangeImpl();
        return dataRange;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SerialParity createSerialParityFromString(EDataType eDataType, String initialValue) {
        SerialParity result = SerialParity.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException(
                    "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertSerialParityToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DevicePackage getDevicePackage() {
        return (DevicePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DevicePackage getPackage() {
        return DevicePackage.eINSTANCE;
    }

} // DeviceFactoryImpl
