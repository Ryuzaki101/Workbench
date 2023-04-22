/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class DevicePackageImpl extends EPackageImpl implements DevicePackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass deviceInfoEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass connectionInfoEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass networkConnectionInfoEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass serialConnectionInfoEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass addressEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataRangeEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum serialParityEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.wisag.automation.micas.olt.device.DevicePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DevicePackageImpl() {
        super(eNS_URI, DeviceFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link DevicePackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DevicePackage init() {
        if (isInited) {
            return (DevicePackage) EPackage.Registry.INSTANCE.getEPackage(DevicePackage.eNS_URI);
        }

        // Obtain or create and register package
        DevicePackageImpl theDevicePackage = (DevicePackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof DevicePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new DevicePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        HwmodulesPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theDevicePackage.createPackageContents();

        // Initialize created meta-data
        theDevicePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theDevicePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(DevicePackage.eNS_URI, theDevicePackage);
        return theDevicePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDeviceInfo() {
        return deviceInfoEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_ModuleName() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_Version() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_Serial() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_MacAddress() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_IpV4Address() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_IpV4Netmask() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_HardwareType() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDeviceInfo_ProcessImageAddress() {
        return (EReference) deviceInfoEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_FieldBus() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDeviceInfo_Slaves() {
        return (EReference) deviceInfoEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDeviceInfo_RawText() {
        return (EAttribute) deviceInfoEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDeviceInfo_HardwareAlias() {
        return (EReference) deviceInfoEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConnectionInfo() {
        return connectionInfoEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnectionInfo_Name() {
        return (EAttribute) connectionInfoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnectionInfo_Description() {
        return (EAttribute) connectionInfoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNetworkConnectionInfo() {
        return networkConnectionInfoEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNetworkConnectionInfo_Ipv4Address() {
        return (EAttribute) networkConnectionInfoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNetworkConnectionInfo_Hostname() {
        return (EAttribute) networkConnectionInfoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSerialConnectionInfo() {
        return serialConnectionInfoEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialConnectionInfo_Port() {
        return (EAttribute) serialConnectionInfoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialConnectionInfo_BaudRate() {
        return (EAttribute) serialConnectionInfoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialConnectionInfo_StopBits() {
        return (EAttribute) serialConnectionInfoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialConnectionInfo_DataBits() {
        return (EAttribute) serialConnectionInfoEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConnection() {
        return connectionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConnection_ConnectionInfo() {
        return (EReference) connectionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnection_Login() {
        return (EAttribute) connectionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnection_Password() {
        return (EAttribute) connectionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnection_ConnectedSince() {
        return (EAttribute) connectionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConnection_DeviceInfo() {
        return (EReference) connectionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAddress() {
        return addressEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAddress_Segment() {
        return (EAttribute) addressEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAddress_Offset() {
        return (EAttribute) addressEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataRange() {
        return dataRangeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataRange_StartAddress() {
        return (EReference) dataRangeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDataRange_Values() {
        return (EAttribute) dataRangeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getSerialParity() {
        return serialParityEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeviceFactory getDeviceFactory() {
        return (DeviceFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        deviceInfoEClass = createEClass(DEVICE_INFO);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__MODULE_NAME);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__VERSION);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__SERIAL);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__MAC_ADDRESS);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__IP_V4_ADDRESS);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__IP_V4_NETMASK);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__HARDWARE_TYPE);
        createEReference(deviceInfoEClass, DEVICE_INFO__PROCESS_IMAGE_ADDRESS);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__FIELD_BUS);
        createEReference(deviceInfoEClass, DEVICE_INFO__SLAVES);
        createEAttribute(deviceInfoEClass, DEVICE_INFO__RAW_TEXT);
        createEReference(deviceInfoEClass, DEVICE_INFO__HARDWARE_ALIAS);

        connectionInfoEClass = createEClass(CONNECTION_INFO);
        createEAttribute(connectionInfoEClass, CONNECTION_INFO__NAME);
        createEAttribute(connectionInfoEClass, CONNECTION_INFO__DESCRIPTION);

        networkConnectionInfoEClass = createEClass(NETWORK_CONNECTION_INFO);
        createEAttribute(networkConnectionInfoEClass, NETWORK_CONNECTION_INFO__IPV4_ADDRESS);
        createEAttribute(networkConnectionInfoEClass, NETWORK_CONNECTION_INFO__HOSTNAME);

        serialConnectionInfoEClass = createEClass(SERIAL_CONNECTION_INFO);
        createEAttribute(serialConnectionInfoEClass, SERIAL_CONNECTION_INFO__PORT);
        createEAttribute(serialConnectionInfoEClass, SERIAL_CONNECTION_INFO__BAUD_RATE);
        createEAttribute(serialConnectionInfoEClass, SERIAL_CONNECTION_INFO__STOP_BITS);
        createEAttribute(serialConnectionInfoEClass, SERIAL_CONNECTION_INFO__DATA_BITS);

        connectionEClass = createEClass(CONNECTION);
        createEReference(connectionEClass, CONNECTION__CONNECTION_INFO);
        createEAttribute(connectionEClass, CONNECTION__LOGIN);
        createEAttribute(connectionEClass, CONNECTION__PASSWORD);
        createEAttribute(connectionEClass, CONNECTION__CONNECTED_SINCE);
        createEReference(connectionEClass, CONNECTION__DEVICE_INFO);

        addressEClass = createEClass(ADDRESS);
        createEAttribute(addressEClass, ADDRESS__SEGMENT);
        createEAttribute(addressEClass, ADDRESS__OFFSET);

        dataRangeEClass = createEClass(DATA_RANGE);
        createEReference(dataRangeEClass, DATA_RANGE__START_ADDRESS);
        createEAttribute(dataRangeEClass, DATA_RANGE__VALUES);

        // Create enums
        serialParityEEnum = createEEnum(SERIAL_PARITY);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        HwmodulesPackage theHwmodulesPackage = (HwmodulesPackage) EPackage.Registry.INSTANCE
                .getEPackage(HwmodulesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        networkConnectionInfoEClass.getESuperTypes().add(this.getConnectionInfo());
        serialConnectionInfoEClass.getESuperTypes().add(this.getConnectionInfo());

        // Initialize classes and features; add operations and parameters
        initEClass(deviceInfoEClass, DeviceInfo.class, "DeviceInfo", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDeviceInfo_ModuleName(), ecorePackage.getEString(), "moduleName", null, 0, 1,
                DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_Version(), ecorePackage.getEString(), "version", null, 0, 1, DeviceInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_Serial(), ecorePackage.getEString(), "serial", null, 0, 1, DeviceInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_MacAddress(), ecorePackage.getEString(), "macAddress", null, 0, 1,
                DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_IpV4Address(), ecorePackage.getEString(), "ipV4Address", null, 0, 1,
                DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_IpV4Netmask(), ecorePackage.getEString(), "ipV4Netmask", null, 0, 1,
                DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_HardwareType(), theHwmodulesPackage.getHardwareType(), "hardwareType", "ACXX", 0,
                1, DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getDeviceInfo_ProcessImageAddress(), this.getAddress(), null, "processImageAddress", null, 0, 1,
                DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_FieldBus(), ecorePackage.getEInt(), "fieldBus", null, 0, 1, DeviceInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDeviceInfo_Slaves(), this.getDeviceInfo(), null, "slaves", null, 0, -1, DeviceInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDeviceInfo_RawText(), ecorePackage.getEString(), "rawText", null, 0, 1, DeviceInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDeviceInfo_HardwareAlias(), theHwmodulesPackage.getHardwareAlias(), null, "hardwareAlias",
                null, 0, 1, DeviceInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(connectionInfoEClass, ConnectionInfo.class, "ConnectionInfo", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConnectionInfo_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConnectionInfo.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConnectionInfo_Description(), ecorePackage.getEString(), "description", null, 0, 1,
                ConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(networkConnectionInfoEClass, NetworkConnectionInfo.class, "NetworkConnectionInfo", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNetworkConnectionInfo_Ipv4Address(), ecorePackage.getEString(), "ipv4Address", null, 0, 1,
                NetworkConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getNetworkConnectionInfo_Hostname(), ecorePackage.getEString(), "hostname", null, 0, 1,
                NetworkConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(serialConnectionInfoEClass, SerialConnectionInfo.class, "SerialConnectionInfo", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSerialConnectionInfo_Port(), ecorePackage.getEString(), "port", null, 0, 1,
                SerialConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSerialConnectionInfo_BaudRate(), ecorePackage.getEInt(), "baudRate", null, 0, 1,
                SerialConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSerialConnectionInfo_StopBits(), ecorePackage.getEInt(), "stopBits", null, 0, 1,
                SerialConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSerialConnectionInfo_DataBits(), ecorePackage.getEInt(), "dataBits", null, 0, 1,
                SerialConnectionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConnection_ConnectionInfo(), this.getConnectionInfo(), null, "connectionInfo", null, 0, 1,
                Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConnection_Login(), ecorePackage.getEString(), "login", null, 0, 1, Connection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConnection_Password(), ecorePackage.getEString(), "password", null, 0, 1, Connection.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConnection_ConnectedSince(), ecorePackage.getEDate(), "connectedSince", null, 0, 1,
                Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getConnection_DeviceInfo(), this.getDeviceInfo(), null, "deviceInfo", null, 0, 1,
                Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAddress_Segment(), ecorePackage.getEInt(), "segment", null, 0, 1, Address.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAddress_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, Address.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataRangeEClass, DataRange.class, "DataRange", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataRange_StartAddress(), this.getAddress(), null, "startAddress", null, 0, 1,
                DataRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDataRange_Values(), ecorePackage.getEInt(), "values", null, 0, -1, DataRange.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(serialParityEEnum, SerialParity.class, "SerialParity");
        addEEnumLiteral(serialParityEEnum, SerialParity.EVEN);
        addEEnumLiteral(serialParityEEnum, SerialParity.ODD);
        addEEnumLiteral(serialParityEEnum, SerialParity.NONE);

        // Create resource
        createResource(eNS_URI);
    }

} // DevicePackageImpl
