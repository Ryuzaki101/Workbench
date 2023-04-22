/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.device.DeviceFactory
 * @model kind="package"
 * @generated
 */
public interface DevicePackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "device";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.wisag.de/automation/schema/device";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    DevicePackage eINSTANCE = de.wisag.automation.micas.olt.device.impl.DevicePackageImpl.init();

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl
     * <em>Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getDeviceInfo()
     * @generated
     */
    int DEVICE_INFO = 0;

    /**
     * The feature id for the '<em><b>Module Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__MODULE_NAME = 0;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__VERSION = 1;

    /**
     * The feature id for the '<em><b>Serial</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__SERIAL = 2;

    /**
     * The feature id for the '<em><b>Mac Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__MAC_ADDRESS = 3;

    /**
     * The feature id for the '<em><b>Ip V4 Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__IP_V4_ADDRESS = 4;

    /**
     * The feature id for the '<em><b>Ip V4 Netmask</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__IP_V4_NETMASK = 5;

    /**
     * The feature id for the '<em><b>Hardware Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__HARDWARE_TYPE = 6;

    /**
     * The feature id for the '<em><b>Process Image Address</b></em>'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__PROCESS_IMAGE_ADDRESS = 7;

    /**
     * The feature id for the '<em><b>Field Bus</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__FIELD_BUS = 8;

    /**
     * The feature id for the '<em><b>Slaves</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__SLAVES = 9;

    /**
     * The feature id for the '<em><b>Raw Text</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__RAW_TEXT = 10;

    /**
     * The feature id for the '<em><b>Hardware Alias</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO__HARDWARE_ALIAS = 11;

    /**
     * The number of structural features of the '<em>Info</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DEVICE_INFO_FEATURE_COUNT = 12;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.ConnectionInfoImpl
     * <em>Connection Info</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.ConnectionInfoImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getConnectionInfo()
     * @generated
     */
    int CONNECTION_INFO = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION_INFO__NAME = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION_INFO__DESCRIPTION = 1;

    /**
     * The number of structural features of the '<em>Connection Info</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION_INFO_FEATURE_COUNT = 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.NetworkConnectionInfoImpl
     * <em>Network Connection Info</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.NetworkConnectionInfoImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getNetworkConnectionInfo()
     * @generated
     */
    int NETWORK_CONNECTION_INFO = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_CONNECTION_INFO__NAME = CONNECTION_INFO__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_CONNECTION_INFO__DESCRIPTION = CONNECTION_INFO__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Ipv4 Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_CONNECTION_INFO__IPV4_ADDRESS = CONNECTION_INFO_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Hostname</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_CONNECTION_INFO__HOSTNAME = CONNECTION_INFO_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Network Connection
     * Info</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int NETWORK_CONNECTION_INFO_FEATURE_COUNT = CONNECTION_INFO_FEATURE_COUNT + 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl
     * <em>Serial Connection Info</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getSerialConnectionInfo()
     * @generated
     */
    int SERIAL_CONNECTION_INFO = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO__NAME = CONNECTION_INFO__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO__DESCRIPTION = CONNECTION_INFO__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO__PORT = CONNECTION_INFO_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Baud Rate</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO__BAUD_RATE = CONNECTION_INFO_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Stop Bits</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO__STOP_BITS = CONNECTION_INFO_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Data Bits</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO__DATA_BITS = CONNECTION_INFO_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Serial Connection
     * Info</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int SERIAL_CONNECTION_INFO_FEATURE_COUNT = CONNECTION_INFO_FEATURE_COUNT + 4;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl
     * <em>Connection</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.ConnectionImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getConnection()
     * @generated
     */
    int CONNECTION = 4;

    /**
     * The feature id for the '<em><b>Connection Info</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION__CONNECTION_INFO = 0;

    /**
     * The feature id for the '<em><b>Login</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION__LOGIN = 1;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION__PASSWORD = 2;

    /**
     * The feature id for the '<em><b>Connected Since</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION__CONNECTED_SINCE = 3;

    /**
     * The feature id for the '<em><b>Device Info</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION__DEVICE_INFO = 4;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int CONNECTION_FEATURE_COUNT = 5;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.AddressImpl
     * <em>Address</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.AddressImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getAddress()
     * @generated
     */
    int ADDRESS = 5;

    /**
     * The feature id for the '<em><b>Segment</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADDRESS__SEGMENT = 0;

    /**
     * The feature id for the '<em><b>Offset</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADDRESS__OFFSET = 1;

    /**
     * The number of structural features of the '<em>Address</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ADDRESS_FEATURE_COUNT = 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.impl.DataRangeImpl <em>Data
     * Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.impl.DataRangeImpl
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getDataRange()
     * @generated
     */
    int DATA_RANGE = 6;

    /**
     * The feature id for the '<em><b>Start Address</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_RANGE__START_ADDRESS = 0;

    /**
     * The feature id for the '<em><b>Values</b></em>' attribute list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_RANGE__VALUES = 1;

    /**
     * The number of structural features of the '<em>Data Range</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DATA_RANGE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.device.SerialParity <em>Serial
     * Parity</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.device.SerialParity
     * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getSerialParity()
     * @generated
     */
    int SERIAL_PARITY = 7;

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo <em>Info</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Info</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo
     * @generated
     */
    EClass getDeviceInfo();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getModuleName
     * <em>Module Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Module Name</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getModuleName()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_ModuleName();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getVersion
     * <em>Version</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getVersion()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_Version();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getSerial
     * <em>Serial</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Serial</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getSerial()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_Serial();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getMacAddress
     * <em>Mac Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Mac Address</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getMacAddress()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_MacAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Address
     * <em>Ip V4 Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Ip V4 Address</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Address()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_IpV4Address();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Netmask
     * <em>Ip V4 Netmask</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Ip V4 Netmask</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Netmask()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_IpV4Netmask();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareType
     * <em>Hardware Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Hardware Type</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareType()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_HardwareType();

    /**
     * Returns the meta object for the containment reference
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getProcessImageAddress
     * <em>Process Image Address</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Process Image
     *         Address</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getProcessImageAddress()
     * @see #getDeviceInfo()
     * @generated
     */
    EReference getDeviceInfo_ProcessImageAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getFieldBus
     * <em>Field Bus</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Field Bus</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getFieldBus()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_FieldBus();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getSlaves
     * <em>Slaves</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Slaves</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getSlaves()
     * @see #getDeviceInfo()
     * @generated
     */
    EReference getDeviceInfo_Slaves();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getRawText
     * <em>Raw Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Raw Text</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getRawText()
     * @see #getDeviceInfo()
     * @generated
     */
    EAttribute getDeviceInfo_RawText();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareAlias
     * <em>Hardware Alias</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Hardware Alias</em>'.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareAlias()
     * @see #getDeviceInfo()
     * @generated
     */
    EReference getDeviceInfo_HardwareAlias();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.ConnectionInfo
     * <em>Connection Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Connection Info</em>'.
     * @see de.wisag.automation.micas.olt.device.ConnectionInfo
     * @generated
     */
    EClass getConnectionInfo();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.ConnectionInfo#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.olt.device.ConnectionInfo#getName()
     * @see #getConnectionInfo()
     * @generated
     */
    EAttribute getConnectionInfo_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.ConnectionInfo#getDescription
     * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see de.wisag.automation.micas.olt.device.ConnectionInfo#getDescription()
     * @see #getConnectionInfo()
     * @generated
     */
    EAttribute getConnectionInfo_Description();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo
     * <em>Network Connection Info</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Network Connection Info</em>'.
     * @see de.wisag.automation.micas.olt.device.NetworkConnectionInfo
     * @generated
     */
    EClass getNetworkConnectionInfo();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getIpv4Address
     * <em>Ipv4 Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Ipv4 Address</em>'.
     * @see de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getIpv4Address()
     * @see #getNetworkConnectionInfo()
     * @generated
     */
    EAttribute getNetworkConnectionInfo_Ipv4Address();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getHostname
     * <em>Hostname</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Hostname</em>'.
     * @see de.wisag.automation.micas.olt.device.NetworkConnectionInfo#getHostname()
     * @see #getNetworkConnectionInfo()
     * @generated
     */
    EAttribute getNetworkConnectionInfo_Hostname();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo
     * <em>Serial Connection Info</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Serial Connection Info</em>'.
     * @see de.wisag.automation.micas.olt.device.SerialConnectionInfo
     * @generated
     */
    EClass getSerialConnectionInfo();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getPort
     * <em>Port</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see de.wisag.automation.micas.olt.device.SerialConnectionInfo#getPort()
     * @see #getSerialConnectionInfo()
     * @generated
     */
    EAttribute getSerialConnectionInfo_Port();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getBaudRate
     * <em>Baud Rate</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Baud Rate</em>'.
     * @see de.wisag.automation.micas.olt.device.SerialConnectionInfo#getBaudRate()
     * @see #getSerialConnectionInfo()
     * @generated
     */
    EAttribute getSerialConnectionInfo_BaudRate();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getStopBits
     * <em>Stop Bits</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Stop Bits</em>'.
     * @see de.wisag.automation.micas.olt.device.SerialConnectionInfo#getStopBits()
     * @see #getSerialConnectionInfo()
     * @generated
     */
    EAttribute getSerialConnectionInfo_StopBits();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo#getDataBits
     * <em>Data Bits</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Data Bits</em>'.
     * @see de.wisag.automation.micas.olt.device.SerialConnectionInfo#getDataBits()
     * @see #getSerialConnectionInfo()
     * @generated
     */
    EAttribute getSerialConnectionInfo_DataBits();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.Connection
     * <em>Connection</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Connection</em>'.
     * @see de.wisag.automation.micas.olt.device.Connection
     * @generated
     */
    EClass getConnection();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.olt.device.Connection#getConnectionInfo
     * <em>Connection Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Connection Info</em>'.
     * @see de.wisag.automation.micas.olt.device.Connection#getConnectionInfo()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_ConnectionInfo();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.Connection#getLogin
     * <em>Login</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Login</em>'.
     * @see de.wisag.automation.micas.olt.device.Connection#getLogin()
     * @see #getConnection()
     * @generated
     */
    EAttribute getConnection_Login();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.Connection#getPassword
     * <em>Password</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see de.wisag.automation.micas.olt.device.Connection#getPassword()
     * @see #getConnection()
     * @generated
     */
    EAttribute getConnection_Password();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.Connection#getConnectedSince
     * <em>Connected Since</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Connected Since</em>'.
     * @see de.wisag.automation.micas.olt.device.Connection#getConnectedSince()
     * @see #getConnection()
     * @generated
     */
    EAttribute getConnection_ConnectedSince();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.olt.device.Connection#getDeviceInfo
     * <em>Device Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Device Info</em>'.
     * @see de.wisag.automation.micas.olt.device.Connection#getDeviceInfo()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_DeviceInfo();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.Address <em>Address</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Address</em>'.
     * @see de.wisag.automation.micas.olt.device.Address
     * @generated
     */
    EClass getAddress();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.Address#getSegment
     * <em>Segment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Segment</em>'.
     * @see de.wisag.automation.micas.olt.device.Address#getSegment()
     * @see #getAddress()
     * @generated
     */
    EAttribute getAddress_Segment();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.device.Address#getOffset
     * <em>Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Offset</em>'.
     * @see de.wisag.automation.micas.olt.device.Address#getOffset()
     * @see #getAddress()
     * @generated
     */
    EAttribute getAddress_Offset();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.device.DataRange <em>Data
     * Range</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Data Range</em>'.
     * @see de.wisag.automation.micas.olt.device.DataRange
     * @generated
     */
    EClass getDataRange();

    /**
     * Returns the meta object for the containment reference
     * '{@link de.wisag.automation.micas.olt.device.DataRange#getStartAddress
     * <em>Start Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Start
     *         Address</em>'.
     * @see de.wisag.automation.micas.olt.device.DataRange#getStartAddress()
     * @see #getDataRange()
     * @generated
     */
    EReference getDataRange_StartAddress();

    /**
     * Returns the meta object for the attribute list
     * '{@link de.wisag.automation.micas.olt.device.DataRange#getValues
     * <em>Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Values</em>'.
     * @see de.wisag.automation.micas.olt.device.DataRange#getValues()
     * @see #getDataRange()
     * @generated
     */
    EAttribute getDataRange_Values();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.olt.device.SerialParity <em>Serial
     * Parity</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Serial Parity</em>'.
     * @see de.wisag.automation.micas.olt.device.SerialParity
     * @generated
     */
    EEnum getSerialParity();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DeviceFactory getDeviceFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl
         * <em>Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getDeviceInfo()
         * @generated
         */
        EClass DEVICE_INFO = eINSTANCE.getDeviceInfo();

        /**
         * The meta object literal for the '<em><b>Module Name</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__MODULE_NAME = eINSTANCE.getDeviceInfo_ModuleName();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__VERSION = eINSTANCE.getDeviceInfo_Version();

        /**
         * The meta object literal for the '<em><b>Serial</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__SERIAL = eINSTANCE.getDeviceInfo_Serial();

        /**
         * The meta object literal for the '<em><b>Mac Address</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__MAC_ADDRESS = eINSTANCE.getDeviceInfo_MacAddress();

        /**
         * The meta object literal for the '<em><b>Ip V4 Address</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__IP_V4_ADDRESS = eINSTANCE.getDeviceInfo_IpV4Address();

        /**
         * The meta object literal for the '<em><b>Ip V4 Netmask</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__IP_V4_NETMASK = eINSTANCE.getDeviceInfo_IpV4Netmask();

        /**
         * The meta object literal for the '<em><b>Hardware Type</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__HARDWARE_TYPE = eINSTANCE.getDeviceInfo_HardwareType();

        /**
         * The meta object literal for the '<em><b>Process Image
         * Address</b></em>' containment reference feature. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DEVICE_INFO__PROCESS_IMAGE_ADDRESS = eINSTANCE.getDeviceInfo_ProcessImageAddress();

        /**
         * The meta object literal for the '<em><b>Field Bus</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__FIELD_BUS = eINSTANCE.getDeviceInfo_FieldBus();

        /**
         * The meta object literal for the '<em><b>Slaves</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DEVICE_INFO__SLAVES = eINSTANCE.getDeviceInfo_Slaves();

        /**
         * The meta object literal for the '<em><b>Raw Text</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DEVICE_INFO__RAW_TEXT = eINSTANCE.getDeviceInfo_RawText();

        /**
         * The meta object literal for the '<em><b>Hardware Alias</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DEVICE_INFO__HARDWARE_ALIAS = eINSTANCE.getDeviceInfo_HardwareAlias();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.ConnectionInfoImpl
         * <em>Connection Info</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.ConnectionInfoImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getConnectionInfo()
         * @generated
         */
        EClass CONNECTION_INFO = eINSTANCE.getConnectionInfo();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONNECTION_INFO__NAME = eINSTANCE.getConnectionInfo_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONNECTION_INFO__DESCRIPTION = eINSTANCE.getConnectionInfo_Description();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.NetworkConnectionInfoImpl
         * <em>Network Connection Info</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.NetworkConnectionInfoImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getNetworkConnectionInfo()
         * @generated
         */
        EClass NETWORK_CONNECTION_INFO = eINSTANCE.getNetworkConnectionInfo();

        /**
         * The meta object literal for the '<em><b>Ipv4 Address</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NETWORK_CONNECTION_INFO__IPV4_ADDRESS = eINSTANCE.getNetworkConnectionInfo_Ipv4Address();

        /**
         * The meta object literal for the '<em><b>Hostname</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute NETWORK_CONNECTION_INFO__HOSTNAME = eINSTANCE.getNetworkConnectionInfo_Hostname();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl
         * <em>Serial Connection Info</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.SerialConnectionInfoImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getSerialConnectionInfo()
         * @generated
         */
        EClass SERIAL_CONNECTION_INFO = eINSTANCE.getSerialConnectionInfo();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SERIAL_CONNECTION_INFO__PORT = eINSTANCE.getSerialConnectionInfo_Port();

        /**
         * The meta object literal for the '<em><b>Baud Rate</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SERIAL_CONNECTION_INFO__BAUD_RATE = eINSTANCE.getSerialConnectionInfo_BaudRate();

        /**
         * The meta object literal for the '<em><b>Stop Bits</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SERIAL_CONNECTION_INFO__STOP_BITS = eINSTANCE.getSerialConnectionInfo_StopBits();

        /**
         * The meta object literal for the '<em><b>Data Bits</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute SERIAL_CONNECTION_INFO__DATA_BITS = eINSTANCE.getSerialConnectionInfo_DataBits();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.ConnectionImpl
         * <em>Connection</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.ConnectionImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getConnection()
         * @generated
         */
        EClass CONNECTION = eINSTANCE.getConnection();

        /**
         * The meta object literal for the '<em><b>Connection Info</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONNECTION__CONNECTION_INFO = eINSTANCE.getConnection_ConnectionInfo();

        /**
         * The meta object literal for the '<em><b>Login</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONNECTION__LOGIN = eINSTANCE.getConnection_Login();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONNECTION__PASSWORD = eINSTANCE.getConnection_Password();

        /**
         * The meta object literal for the '<em><b>Connected Since</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute CONNECTION__CONNECTED_SINCE = eINSTANCE.getConnection_ConnectedSince();

        /**
         * The meta object literal for the '<em><b>Device Info</b></em>'
         * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference CONNECTION__DEVICE_INFO = eINSTANCE.getConnection_DeviceInfo();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.AddressImpl
         * <em>Address</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.AddressImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getAddress()
         * @generated
         */
        EClass ADDRESS = eINSTANCE.getAddress();

        /**
         * The meta object literal for the '<em><b>Segment</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ADDRESS__SEGMENT = eINSTANCE.getAddress_Segment();

        /**
         * The meta object literal for the '<em><b>Offset</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ADDRESS__OFFSET = eINSTANCE.getAddress_Offset();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.impl.DataRangeImpl
         * <em>Data Range</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.impl.DataRangeImpl
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getDataRange()
         * @generated
         */
        EClass DATA_RANGE = eINSTANCE.getDataRange();

        /**
         * The meta object literal for the '<em><b>Start Address</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference DATA_RANGE__START_ADDRESS = eINSTANCE.getDataRange_StartAddress();

        /**
         * The meta object literal for the '<em><b>Values</b></em>' attribute
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DATA_RANGE__VALUES = eINSTANCE.getDataRange_Values();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.device.SerialParity <em>Serial
         * Parity</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.device.SerialParity
         * @see de.wisag.automation.micas.olt.device.impl.DevicePackageImpl#getSerialParity()
         * @generated
         */
        EEnum SERIAL_PARITY = eINSTANCE.getSerialParity();

    }

} // DevicePackage
