/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.device.DevicePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getModuleName
 * <em>Module Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getVersion
 * <em>Version</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getSerial
 * <em>Serial</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getMacAddress
 * <em>Mac Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getIpV4Address
 * <em>Ip V4 Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getIpV4Netmask
 * <em>Ip V4 Netmask</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getHardwareType
 * <em>Hardware Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getProcessImageAddress
 * <em>Process Image Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getFieldBus
 * <em>Field Bus</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getSlaves
 * <em>Slaves</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getRawText
 * <em>Raw Text</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.impl.DeviceInfoImpl#getHardwareAlias
 * <em>Hardware Alias</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeviceInfoImpl extends EObjectImpl implements DeviceInfo {
    /**
     * The default value of the '{@link #getModuleName() <em>Module Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModuleName()
     * @generated
     * @ordered
     */
    protected static final String MODULE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getModuleName() <em>Module Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModuleName()
     * @generated
     * @ordered
     */
    protected String moduleName = MODULE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getSerial() <em>Serial</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSerial()
     * @generated
     * @ordered
     */
    protected static final String SERIAL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSerial() <em>Serial</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSerial()
     * @generated
     * @ordered
     */
    protected String serial = SERIAL_EDEFAULT;

    /**
     * The default value of the '{@link #getMacAddress() <em>Mac Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMacAddress()
     * @generated
     * @ordered
     */
    protected static final String MAC_ADDRESS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMacAddress() <em>Mac Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMacAddress()
     * @generated
     * @ordered
     */
    protected String macAddress = MAC_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getIpV4Address() <em>Ip V4
     * Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIpV4Address()
     * @generated
     * @ordered
     */
    protected static final String IP_V4_ADDRESS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIpV4Address() <em>Ip V4
     * Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIpV4Address()
     * @generated
     * @ordered
     */
    protected String ipV4Address = IP_V4_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getIpV4Netmask() <em>Ip V4
     * Netmask</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIpV4Netmask()
     * @generated
     * @ordered
     */
    protected static final String IP_V4_NETMASK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIpV4Netmask() <em>Ip V4
     * Netmask</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIpV4Netmask()
     * @generated
     * @ordered
     */
    protected String ipV4Netmask = IP_V4_NETMASK_EDEFAULT;

    /**
     * The default value of the '{@link #getHardwareType() <em>Hardware
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHardwareType()
     * @generated
     * @ordered
     */
    protected static final HardwareType HARDWARE_TYPE_EDEFAULT = HardwareType.ACXX;

    /**
     * The cached value of the '{@link #getHardwareType() <em>Hardware
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHardwareType()
     * @generated
     * @ordered
     */
    protected HardwareType hardwareType = HARDWARE_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getProcessImageAddress() <em>Process
     * Image Address</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProcessImageAddress()
     * @generated
     * @ordered
     */
    protected Address processImageAddress;

    /**
     * The default value of the '{@link #getFieldBus() <em>Field Bus</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFieldBus()
     * @generated
     * @ordered
     */
    protected static final int FIELD_BUS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getFieldBus() <em>Field Bus</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFieldBus()
     * @generated
     * @ordered
     */
    protected int fieldBus = FIELD_BUS_EDEFAULT;

    /**
     * The cached value of the '{@link #getSlaves() <em>Slaves</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSlaves()
     * @generated
     * @ordered
     */
    protected EList<DeviceInfo> slaves;

    /**
     * The default value of the '{@link #getRawText() <em>Raw Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRawText()
     * @generated
     * @ordered
     */
    protected static final String RAW_TEXT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRawText() <em>Raw Text</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRawText()
     * @generated
     * @ordered
     */
    protected String rawText = RAW_TEXT_EDEFAULT;

    /**
     * The cached value of the '{@link #getHardwareAlias() <em>Hardware
     * Alias</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHardwareAlias()
     * @generated
     * @ordered
     */
    protected HardwareAlias hardwareAlias;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DeviceInfoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DevicePackage.Literals.DEVICE_INFO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getModuleName() {
        return moduleName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setModuleName(String newModuleName) {
        String oldModuleName = moduleName;
        moduleName = newModuleName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__MODULE_NAME, oldModuleName,
                    moduleName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVersion(String newVersion) {
        String oldVersion = version;
        version = newVersion;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__VERSION, oldVersion,
                    version));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getSerial() {
        return serial;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSerial(String newSerial) {
        String oldSerial = serial;
        serial = newSerial;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__SERIAL, oldSerial,
                    serial));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMacAddress(String newMacAddress) {
        String oldMacAddress = macAddress;
        macAddress = newMacAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__MAC_ADDRESS, oldMacAddress,
                    macAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getIpV4Address() {
        return ipV4Address;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIpV4Address(String newIpV4Address) {
        String oldIpV4Address = ipV4Address;
        ipV4Address = newIpV4Address;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__IP_V4_ADDRESS,
                    oldIpV4Address, ipV4Address));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getIpV4Netmask() {
        return ipV4Netmask;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIpV4Netmask(String newIpV4Netmask) {
        String oldIpV4Netmask = ipV4Netmask;
        ipV4Netmask = newIpV4Netmask;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__IP_V4_NETMASK,
                    oldIpV4Netmask, ipV4Netmask));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HardwareType getHardwareType() {
        return hardwareType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHardwareType(HardwareType newHardwareType) {
        HardwareType oldHardwareType = hardwareType;
        hardwareType = newHardwareType == null ? HARDWARE_TYPE_EDEFAULT : newHardwareType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__HARDWARE_TYPE,
                    oldHardwareType, hardwareType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Address getProcessImageAddress() {
        return processImageAddress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProcessImageAddress(Address newProcessImageAddress, NotificationChain msgs) {
        Address oldProcessImageAddress = processImageAddress;
        processImageAddress = newProcessImageAddress;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS, oldProcessImageAddress, newProcessImageAddress);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setProcessImageAddress(Address newProcessImageAddress) {
        if (newProcessImageAddress != processImageAddress) {
            NotificationChain msgs = null;
            if (processImageAddress != null) {
                msgs = ((InternalEObject) processImageAddress).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS, null, msgs);
            }
            if (newProcessImageAddress != null) {
                msgs = ((InternalEObject) newProcessImageAddress).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS, null, msgs);
            }
            msgs = basicSetProcessImageAddress(newProcessImageAddress, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS,
                    newProcessImageAddress, newProcessImageAddress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getFieldBus() {
        return fieldBus;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFieldBus(int newFieldBus) {
        int oldFieldBus = fieldBus;
        fieldBus = newFieldBus;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__FIELD_BUS, oldFieldBus,
                    fieldBus));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<DeviceInfo> getSlaves() {
        if (slaves == null) {
            slaves = new EObjectContainmentEList<>(DeviceInfo.class, this, DevicePackage.DEVICE_INFO__SLAVES);
        }
        return slaves;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getRawText() {
        return rawText;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRawText(String newRawText) {
        String oldRawText = rawText;
        rawText = newRawText;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__RAW_TEXT, oldRawText,
                    rawText));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HardwareAlias getHardwareAlias() {
        if (hardwareAlias != null && hardwareAlias.eIsProxy()) {
            InternalEObject oldHardwareAlias = (InternalEObject) hardwareAlias;
            hardwareAlias = (HardwareAlias) eResolveProxy(oldHardwareAlias);
            if (hardwareAlias != oldHardwareAlias) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DevicePackage.DEVICE_INFO__HARDWARE_ALIAS,
                            oldHardwareAlias, hardwareAlias));
                }
            }
        }
        return hardwareAlias;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public HardwareAlias basicGetHardwareAlias() {
        return hardwareAlias;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHardwareAlias(HardwareAlias newHardwareAlias) {
        HardwareAlias oldHardwareAlias = hardwareAlias;
        hardwareAlias = newHardwareAlias;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, DevicePackage.DEVICE_INFO__HARDWARE_ALIAS,
                    oldHardwareAlias, hardwareAlias));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS:
            return basicSetProcessImageAddress(null, msgs);
        case DevicePackage.DEVICE_INFO__SLAVES:
            return ((InternalEList<?>) getSlaves()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case DevicePackage.DEVICE_INFO__MODULE_NAME:
            return getModuleName();
        case DevicePackage.DEVICE_INFO__VERSION:
            return getVersion();
        case DevicePackage.DEVICE_INFO__SERIAL:
            return getSerial();
        case DevicePackage.DEVICE_INFO__MAC_ADDRESS:
            return getMacAddress();
        case DevicePackage.DEVICE_INFO__IP_V4_ADDRESS:
            return getIpV4Address();
        case DevicePackage.DEVICE_INFO__IP_V4_NETMASK:
            return getIpV4Netmask();
        case DevicePackage.DEVICE_INFO__HARDWARE_TYPE:
            return getHardwareType();
        case DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS:
            return getProcessImageAddress();
        case DevicePackage.DEVICE_INFO__FIELD_BUS:
            return getFieldBus();
        case DevicePackage.DEVICE_INFO__SLAVES:
            return getSlaves();
        case DevicePackage.DEVICE_INFO__RAW_TEXT:
            return getRawText();
        case DevicePackage.DEVICE_INFO__HARDWARE_ALIAS:
            if (resolve) {
                return getHardwareAlias();
            }
            return basicGetHardwareAlias();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case DevicePackage.DEVICE_INFO__MODULE_NAME:
            setModuleName((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__VERSION:
            setVersion((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__SERIAL:
            setSerial((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__MAC_ADDRESS:
            setMacAddress((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__IP_V4_ADDRESS:
            setIpV4Address((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__IP_V4_NETMASK:
            setIpV4Netmask((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__HARDWARE_TYPE:
            setHardwareType((HardwareType) newValue);
            return;
        case DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS:
            setProcessImageAddress((Address) newValue);
            return;
        case DevicePackage.DEVICE_INFO__FIELD_BUS:
            setFieldBus((Integer) newValue);
            return;
        case DevicePackage.DEVICE_INFO__SLAVES:
            getSlaves().clear();
            getSlaves().addAll((Collection<? extends DeviceInfo>) newValue);
            return;
        case DevicePackage.DEVICE_INFO__RAW_TEXT:
            setRawText((String) newValue);
            return;
        case DevicePackage.DEVICE_INFO__HARDWARE_ALIAS:
            setHardwareAlias((HardwareAlias) newValue);
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
        case DevicePackage.DEVICE_INFO__MODULE_NAME:
            setModuleName(MODULE_NAME_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__VERSION:
            setVersion(VERSION_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__SERIAL:
            setSerial(SERIAL_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__MAC_ADDRESS:
            setMacAddress(MAC_ADDRESS_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__IP_V4_ADDRESS:
            setIpV4Address(IP_V4_ADDRESS_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__IP_V4_NETMASK:
            setIpV4Netmask(IP_V4_NETMASK_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__HARDWARE_TYPE:
            setHardwareType(HARDWARE_TYPE_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS:
            setProcessImageAddress((Address) null);
            return;
        case DevicePackage.DEVICE_INFO__FIELD_BUS:
            setFieldBus(FIELD_BUS_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__SLAVES:
            getSlaves().clear();
            return;
        case DevicePackage.DEVICE_INFO__RAW_TEXT:
            setRawText(RAW_TEXT_EDEFAULT);
            return;
        case DevicePackage.DEVICE_INFO__HARDWARE_ALIAS:
            setHardwareAlias((HardwareAlias) null);
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
        case DevicePackage.DEVICE_INFO__MODULE_NAME:
            return MODULE_NAME_EDEFAULT == null ? moduleName != null : !MODULE_NAME_EDEFAULT.equals(moduleName);
        case DevicePackage.DEVICE_INFO__VERSION:
            return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
        case DevicePackage.DEVICE_INFO__SERIAL:
            return SERIAL_EDEFAULT == null ? serial != null : !SERIAL_EDEFAULT.equals(serial);
        case DevicePackage.DEVICE_INFO__MAC_ADDRESS:
            return MAC_ADDRESS_EDEFAULT == null ? macAddress != null : !MAC_ADDRESS_EDEFAULT.equals(macAddress);
        case DevicePackage.DEVICE_INFO__IP_V4_ADDRESS:
            return IP_V4_ADDRESS_EDEFAULT == null ? ipV4Address != null : !IP_V4_ADDRESS_EDEFAULT.equals(ipV4Address);
        case DevicePackage.DEVICE_INFO__IP_V4_NETMASK:
            return IP_V4_NETMASK_EDEFAULT == null ? ipV4Netmask != null : !IP_V4_NETMASK_EDEFAULT.equals(ipV4Netmask);
        case DevicePackage.DEVICE_INFO__HARDWARE_TYPE:
            return hardwareType != HARDWARE_TYPE_EDEFAULT;
        case DevicePackage.DEVICE_INFO__PROCESS_IMAGE_ADDRESS:
            return processImageAddress != null;
        case DevicePackage.DEVICE_INFO__FIELD_BUS:
            return fieldBus != FIELD_BUS_EDEFAULT;
        case DevicePackage.DEVICE_INFO__SLAVES:
            return slaves != null && !slaves.isEmpty();
        case DevicePackage.DEVICE_INFO__RAW_TEXT:
            return RAW_TEXT_EDEFAULT == null ? rawText != null : !RAW_TEXT_EDEFAULT.equals(rawText);
        case DevicePackage.DEVICE_INFO__HARDWARE_ALIAS:
            return hardwareAlias != null;
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
        result.append(" (moduleName: ");
        result.append(moduleName);
        result.append(", version: ");
        result.append(version);
        result.append(", serial: ");
        result.append(serial);
        result.append(", macAddress: ");
        result.append(macAddress);
        result.append(", ipV4Address: ");
        result.append(ipV4Address);
        result.append(", ipV4Netmask: ");
        result.append(ipV4Netmask);
        result.append(", hardwareType: ");
        result.append(hardwareType);
        result.append(", fieldBus: ");
        result.append(fieldBus);
        result.append(", rawText: ");
        result.append(rawText);
        result.append(')');
        return result.toString();
    }

} // DeviceInfoImpl
