/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hardware
 * Type Definition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getType
 * <em>Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAliases
 * <em>Aliases</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseSegment
 * <em>Database Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseChecksumAddress
 * <em>Database Checksum Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAddressConversionListAddress
 * <em>Address Conversion List Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getHeadSegment
 * <em>Head Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getEndModuleOpcode
 * <em>End Module Opcode</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDataSegment
 * <em>Data Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getStackSegment
 * <em>Stack Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getProgramSegment
 * <em>Program Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxProgramSize
 * <em>Max Program Size</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getPastValuesOffsetFirstTask
 * <em>Past Values Offset First Task</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxTaskCount
 * <em>Max Task Count</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition()
 * @model
 * @generated
 */
public interface HardwareTypeDefinition extends EObject {
    /**
     * Returns the value of the '<em><b>Aliases</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.HardwareAlias}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aliases</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Aliases</em>' containment reference list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_Aliases()
     * @model containment="true"
     * @generated
     */
    EList<HardwareAlias> getAliases();

    /**
     * Returns the value of the '<em><b>Database Segment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Segment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Database Segment</em>' attribute.
     * @see #setDatabaseSegment(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_DatabaseSegment()
     * @model
     * @generated
     */
    int getDatabaseSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseSegment
     * <em>Database Segment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Database Segment</em>' attribute.
     * @see #getDatabaseSegment()
     * @generated
     */
    void setDatabaseSegment(int value);

    /**
     * Returns the value of the '<em><b>Database Checksum Address</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Checksum Address</em>' attribute
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Database Checksum Address</em>' attribute.
     * @see #setDatabaseChecksumAddress(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_DatabaseChecksumAddress()
     * @model
     * @generated
     */
    int getDatabaseChecksumAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDatabaseChecksumAddress
     * <em>Database Checksum Address</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Database Checksum Address</em>'
     *            attribute.
     * @see #getDatabaseChecksumAddress()
     * @generated
     */
    void setDatabaseChecksumAddress(int value);

    /**
     * Returns the value of the '<em><b>Address Conversion List
     * Address</b></em>' attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Address Conversion List Address</em>'
     * attribute isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Address Conversion List Address</em>'
     *         attribute.
     * @see #setAddressConversionListAddress(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_AddressConversionListAddress()
     * @model
     * @generated
     */
    int getAddressConversionListAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getAddressConversionListAddress
     * <em>Address Conversion List Address</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Address Conversion List
     *            Address</em>' attribute.
     * @see #getAddressConversionListAddress()
     * @generated
     */
    void setAddressConversionListAddress(int value);

    /**
     * Returns the value of the '<em><b>Head Segment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Head Segment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Head Segment</em>' attribute.
     * @see #setHeadSegment(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_HeadSegment()
     * @model
     * @generated
     */
    int getHeadSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getHeadSegment
     * <em>Head Segment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Head Segment</em>' attribute.
     * @see #getHeadSegment()
     * @generated
     */
    void setHeadSegment(int value);

    /**
     * Returns the value of the '<em><b>End Module Opcode</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Module Opcode</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>End Module Opcode</em>' attribute.
     * @see #setEndModuleOpcode(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_EndModuleOpcode()
     * @model
     * @generated
     */
    int getEndModuleOpcode();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getEndModuleOpcode
     * <em>End Module Opcode</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>End Module Opcode</em>' attribute.
     * @see #getEndModuleOpcode()
     * @generated
     */
    void setEndModuleOpcode(int value);

    /**
     * Returns the value of the '<em><b>Data Segment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Segment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Segment</em>' attribute.
     * @see #setDataSegment(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_DataSegment()
     * @model
     * @generated
     */
    int getDataSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getDataSegment
     * <em>Data Segment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Data Segment</em>' attribute.
     * @see #getDataSegment()
     * @generated
     */
    void setDataSegment(int value);

    /**
     * Returns the value of the '<em><b>Stack Segment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stack Segment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Stack Segment</em>' attribute.
     * @see #setStackSegment(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_StackSegment()
     * @model
     * @generated
     */
    int getStackSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getStackSegment
     * <em>Stack Segment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Stack Segment</em>' attribute.
     * @see #getStackSegment()
     * @generated
     */
    void setStackSegment(int value);

    /**
     * Returns the value of the '<em><b>Program Segment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Program Segment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Program Segment</em>' attribute.
     * @see #setProgramSegment(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_ProgramSegment()
     * @model
     * @generated
     */
    int getProgramSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getProgramSegment
     * <em>Program Segment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Program Segment</em>' attribute.
     * @see #getProgramSegment()
     * @generated
     */
    void setProgramSegment(int value);

    /**
     * Returns the value of the '<em><b>Max Program Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Program Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Max Program Size</em>' attribute.
     * @see #setMaxProgramSize(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_MaxProgramSize()
     * @model
     * @generated
     */
    int getMaxProgramSize();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxProgramSize
     * <em>Max Program Size</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Max Program Size</em>' attribute.
     * @see #getMaxProgramSize()
     * @generated
     */
    void setMaxProgramSize(int value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The default
     * value is <code>"UNKNOWN"</code>. The literals are from the enumeration
     * {@link de.wisag.automation.micas.hwmodules.HardwareType}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.hwmodules.HardwareType
     * @see #setType(HardwareType)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_Type()
     * @model default="UNKNOWN" id="true" required="true"
     * @generated
     */
    HardwareType getType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getType
     * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see de.wisag.automation.micas.hwmodules.HardwareType
     * @see #getType()
     * @generated
     */
    void setType(HardwareType value);

    /**
     * Returns the value of the '<em><b>Past Values Offset First Task</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Past Values Offset First Task</em>' attribute
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Past Values Offset First Task</em>'
     *         attribute.
     * @see #setPastValuesOffsetFirstTask(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_PastValuesOffsetFirstTask()
     * @model
     * @generated
     */
    int getPastValuesOffsetFirstTask();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getPastValuesOffsetFirstTask
     * <em>Past Values Offset First Task</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Past Values Offset First Task</em>'
     *            attribute.
     * @see #getPastValuesOffsetFirstTask()
     * @generated
     */
    void setPastValuesOffsetFirstTask(int value);

    /**
     * Returns the value of the '<em><b>Max Task Count</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Task Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Max Task Count</em>' attribute.
     * @see #setMaxTaskCount(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getHardwareTypeDefinition_MaxTaskCount()
     * @model
     * @generated
     */
    int getMaxTaskCount();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition#getMaxTaskCount
     * <em>Max Task Count</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Max Task Count</em>' attribute.
     * @see #getMaxTaskCount()
     * @generated
     */
    void setMaxTaskCount(int value);

} // HardwareTypeDefinition
