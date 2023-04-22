/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getModuleName
 * <em>Module Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getVersion
 * <em>Version</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getSerial
 * <em>Serial</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getMacAddress
 * <em>Mac Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Address
 * <em>Ip V4 Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Netmask
 * <em>Ip V4 Netmask</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareType
 * <em>Hardware Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getProcessImageAddress
 * <em>Process Image Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getFieldBus
 * <em>Field Bus</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getSlaves
 * <em>Slaves</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getRawText <em>Raw
 * Text</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareAlias
 * <em>Hardware Alias</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo()
 * @model
 * @generated
 */
public interface DeviceInfo extends EObject {
    /**
     * Returns the value of the '<em><b>Module Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Module Name</em>' attribute.
     * @see #setModuleName(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_ModuleName()
     * @model
     * @generated
     */
    String getModuleName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getModuleName
     * <em>Module Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Module Name</em>' attribute.
     * @see #getModuleName()
     * @generated
     */
    void setModuleName(String value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_Version()
     * @model
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getVersion
     * <em>Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Serial</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Serial</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Serial</em>' attribute.
     * @see #setSerial(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_Serial()
     * @model
     * @generated
     */
    String getSerial();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getSerial
     * <em>Serial</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Serial</em>' attribute.
     * @see #getSerial()
     * @generated
     */
    void setSerial(String value);

    /**
     * Returns the value of the '<em><b>Mac Address</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mac Address</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mac Address</em>' attribute.
     * @see #setMacAddress(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_MacAddress()
     * @model
     * @generated
     */
    String getMacAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getMacAddress
     * <em>Mac Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Mac Address</em>' attribute.
     * @see #getMacAddress()
     * @generated
     */
    void setMacAddress(String value);

    /**
     * Returns the value of the '<em><b>Ip V4 Address</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ip V4 Address</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ip V4 Address</em>' attribute.
     * @see #setIpV4Address(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_IpV4Address()
     * @model
     * @generated
     */
    String getIpV4Address();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Address
     * <em>Ip V4 Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Ip V4 Address</em>' attribute.
     * @see #getIpV4Address()
     * @generated
     */
    void setIpV4Address(String value);

    /**
     * Returns the value of the '<em><b>Ip V4 Netmask</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ip V4 Netmask</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Ip V4 Netmask</em>' attribute.
     * @see #setIpV4Netmask(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_IpV4Netmask()
     * @model
     * @generated
     */
    String getIpV4Netmask();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getIpV4Netmask
     * <em>Ip V4 Netmask</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Ip V4 Netmask</em>' attribute.
     * @see #getIpV4Netmask()
     * @generated
     */
    void setIpV4Netmask(String value);

    /**
     * Returns the value of the '<em><b>Hardware Type</b></em>' attribute. The
     * default value is <code>"ACXX"</code>. The literals are from the
     * enumeration {@link de.wisag.automation.micas.hwmodules.HardwareType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hardware Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Hardware Type</em>' attribute.
     * @see de.wisag.automation.micas.hwmodules.HardwareType
     * @see #setHardwareType(HardwareType)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_HardwareType()
     * @model default="ACXX"
     * @generated
     */
    HardwareType getHardwareType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareType
     * <em>Hardware Type</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Hardware Type</em>' attribute.
     * @see de.wisag.automation.micas.hwmodules.HardwareType
     * @see #getHardwareType()
     * @generated
     */
    void setHardwareType(HardwareType value);

    /**
     * Returns the value of the '<em><b>Process Image Address</b></em>'
     * containment reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process Image Address</em>' containment
     * reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Process Image Address</em>' containment
     *         reference.
     * @see #setProcessImageAddress(Address)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_ProcessImageAddress()
     * @model containment="true"
     * @generated
     */
    Address getProcessImageAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getProcessImageAddress
     * <em>Process Image Address</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Process Image Address</em>'
     *            containment reference.
     * @see #getProcessImageAddress()
     * @generated
     */
    void setProcessImageAddress(Address value);

    /**
     * Returns the value of the '<em><b>Field Bus</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field Bus</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Field Bus</em>' attribute.
     * @see #setFieldBus(int)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_FieldBus()
     * @model
     * @generated
     */
    int getFieldBus();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getFieldBus
     * <em>Field Bus</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Field Bus</em>' attribute.
     * @see #getFieldBus()
     * @generated
     */
    void setFieldBus(int value);

    /**
     * Returns the value of the '<em><b>Slaves</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.olt.device.DeviceInfo}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Slaves</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Slaves</em>' containment reference list.
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_Slaves()
     * @model containment="true"
     * @generated
     */
    EList<DeviceInfo> getSlaves();

    /**
     * Returns the value of the '<em><b>Raw Text</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Raw Text</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Raw Text</em>' attribute.
     * @see #setRawText(String)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_RawText()
     * @model
     * @generated
     */
    String getRawText();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getRawText
     * <em>Raw Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Raw Text</em>' attribute.
     * @see #getRawText()
     * @generated
     */
    void setRawText(String value);

    /**
     * Returns the value of the '<em><b>Hardware Alias</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hardware Alias</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Hardware Alias</em>' reference.
     * @see #setHardwareAlias(HardwareAlias)
     * @see de.wisag.automation.micas.olt.device.DevicePackage#getDeviceInfo_HardwareAlias()
     * @model
     * @generated
     */
    HardwareAlias getHardwareAlias();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo#getHardwareAlias
     * <em>Hardware Alias</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Hardware Alias</em>' reference.
     * @see #getHardwareAlias()
     * @generated
     */
    void setHardwareAlias(HardwareAlias value);

} // DeviceInfo
