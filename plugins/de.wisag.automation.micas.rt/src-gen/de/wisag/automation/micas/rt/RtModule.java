/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getSymbols
 * <em>Symbols</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getDataSegmentAddress
 * <em>Data Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getTasks
 * <em>Tasks</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getStartSegmentAddress
 * <em>Start Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getFirstTaskSegmentAddress
 * <em>First Task Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getHeadModuleSegmentAddress
 * <em>Head Module Segment Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getDataSegmentCheckSum
 * <em>Data Segment Check Sum</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getTasksCheckSum <em>Tasks
 * Check Sum</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getWordConstOffset <em>Word
 * Const Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getFloatConstOffset
 * <em>Float Const Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getWordVarOffset <em>Word
 * Var Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getFloatVarOffset <em>Float
 * Var Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getEndOfFloatVars <em>End Of
 * Float Vars</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getDataSegment <em>Data
 * Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getHwType <em>Hw
 * Type</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getFieldBus <em>Field
 * Bus</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getPastValuesOffset <em>Past
 * Values Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getPastValuesLastOffset
 * <em>Past Values Last Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getHeadModul <em>Head
 * Modul</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getHeadModuleSegment
 * <em>Head Module Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getSourceModificationStamp
 * <em>Source Modification Stamp</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getSourceName <em>Source
 * Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getSourceChecksum <em>Source
 * Checksum</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getComments
 * <em>Comments</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModule#getStartSegment <em>Start
 * Segment</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtModule()
 * @model
 * @generated
 */
public interface RtModule extends EObject {
    /**
     * Returns the value of the '<em><b>Symbols</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.rt.RtSymbol}. It is bidirectional and
     * its opposite is '{@link de.wisag.automation.micas.rt.RtSymbol#getModule
     * <em>Module</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Symbols</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Symbols</em>' containment reference list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_Symbols()
     * @see de.wisag.automation.micas.rt.RtSymbol#getModule
     * @model opposite="module" containment="true" keys="address"
     * @generated
     */
    EList<RtSymbol> getSymbols();

    /**
     * Returns the value of the '<em><b>Data Segment Address</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Segment Address</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Segment Address</em>' attribute.
     * @see #setDataSegmentAddress(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_DataSegmentAddress()
     * @model
     * @generated
     */
    int getDataSegmentAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getDataSegmentAddress
     * <em>Data Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data Segment Address</em>'
     *            attribute.
     * @see #getDataSegmentAddress()
     * @generated
     */
    void setDataSegmentAddress(int value);

    /**
     * Returns the value of the '<em><b>Tasks</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.rt.RtTask}. It is bidirectional and its
     * opposite is '{@link de.wisag.automation.micas.rt.RtTask#getModule
     * <em>Module</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tasks</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Tasks</em>' containment reference list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_Tasks()
     * @see de.wisag.automation.micas.rt.RtTask#getModule
     * @model opposite="module" containment="true"
     * @generated
     */
    EList<RtTask> getTasks();

    /**
     * Returns the value of the '<em><b>Start Segment Address</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Segment Address</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Start Segment Address</em>' attribute.
     * @see #setStartSegmentAddress(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_StartSegmentAddress()
     * @model
     * @generated
     */
    int getStartSegmentAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getStartSegmentAddress
     * <em>Start Segment Address</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Start Segment Address</em>'
     *            attribute.
     * @see #getStartSegmentAddress()
     * @generated
     */
    void setStartSegmentAddress(int value);

    /**
     * Returns the value of the '<em><b>First Task Segment Address</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Task Segment Address</em>' attribute
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>First Task Segment Address</em>' attribute.
     * @see #setFirstTaskSegmentAddress(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_FirstTaskSegmentAddress()
     * @model
     * @generated
     */
    int getFirstTaskSegmentAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getFirstTaskSegmentAddress
     * <em>First Task Segment Address</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>First Task Segment Address</em>'
     *            attribute.
     * @see #getFirstTaskSegmentAddress()
     * @generated
     */
    void setFirstTaskSegmentAddress(int value);

    /**
     * Returns the value of the '<em><b>Head Module Segment Address</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Head Module Segment Address</em>' attribute
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Head Module Segment Address</em>'
     *         attribute.
     * @see #setHeadModuleSegmentAddress(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_HeadModuleSegmentAddress()
     * @model
     * @generated
     */
    int getHeadModuleSegmentAddress();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModuleSegmentAddress
     * <em>Head Module Segment Address</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Head Module Segment Address</em>'
     *            attribute.
     * @see #getHeadModuleSegmentAddress()
     * @generated
     */
    void setHeadModuleSegmentAddress(int value);

    /**
     * Returns the value of the '<em><b>Data Segment Check Sum</b></em>'
     * attribute. The default value is <code>"-1"</code>. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Data Segment Check Sum</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data Segment Check Sum</em>' attribute.
     * @see #setDataSegmentCheckSum(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_DataSegmentCheckSum()
     * @model default="-1"
     * @generated
     */
    int getDataSegmentCheckSum();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getDataSegmentCheckSum
     * <em>Data Segment Check Sum</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data Segment Check Sum</em>'
     *            attribute.
     * @see #getDataSegmentCheckSum()
     * @generated
     */
    void setDataSegmentCheckSum(int value);

    /**
     * Returns the value of the '<em><b>Word Const Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Word Const Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Word Const Offset</em>' attribute.
     * @see #setWordConstOffset(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_WordConstOffset()
     * @model
     * @generated
     */
    int getWordConstOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getWordConstOffset <em>Word
     * Const Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Word Const Offset</em>' attribute.
     * @see #getWordConstOffset()
     * @generated
     */
    void setWordConstOffset(int value);

    /**
     * Returns the value of the '<em><b>Float Const Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Float Const Offset</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Float Const Offset</em>' attribute.
     * @see #setFloatConstOffset(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_FloatConstOffset()
     * @model
     * @generated
     */
    int getFloatConstOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getFloatConstOffset
     * <em>Float Const Offset</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Float Const Offset</em>' attribute.
     * @see #getFloatConstOffset()
     * @generated
     */
    void setFloatConstOffset(int value);

    /**
     * Returns the value of the '<em><b>Word Var Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Word Var Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Word Var Offset</em>' attribute.
     * @see #setWordVarOffset(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_WordVarOffset()
     * @model
     * @generated
     */
    int getWordVarOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getWordVarOffset <em>Word
     * Var Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Word Var Offset</em>' attribute.
     * @see #getWordVarOffset()
     * @generated
     */
    void setWordVarOffset(int value);

    /**
     * Returns the value of the '<em><b>Float Var Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Float Var Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Float Var Offset</em>' attribute.
     * @see #setFloatVarOffset(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_FloatVarOffset()
     * @model
     * @generated
     */
    int getFloatVarOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getFloatVarOffset <em>Float
     * Var Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Float Var Offset</em>' attribute.
     * @see #getFloatVarOffset()
     * @generated
     */
    void setFloatVarOffset(int value);

    /**
     * Returns the value of the '<em><b>End Of Float Vars</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Of Float Vars</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>End Of Float Vars</em>' attribute.
     * @see #setEndOfFloatVars(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_EndOfFloatVars()
     * @model
     * @generated
     */
    int getEndOfFloatVars();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getEndOfFloatVars <em>End
     * Of Float Vars</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>End Of Float Vars</em>' attribute.
     * @see #getEndOfFloatVars()
     * @generated
     */
    void setEndOfFloatVars(int value);

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
     * @see #setDataSegment(byte[])
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_DataSegment()
     * @model transient="true"
     * @generated
     */
    byte[] getDataSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getDataSegment <em>Data
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data Segment</em>' attribute.
     * @see #getDataSegment()
     * @generated
     */
    void setDataSegment(byte[] value);

    /**
     * Returns the value of the '<em><b>Hw Type</b></em>' attribute. The default
     * value is <code>"AC40"</code>. The literals are from the enumeration
     * {@link de.wisag.automation.micas.rt.RtHwType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hw Type</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Hw Type</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtHwType
     * @see #setHwType(RtHwType)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_HwType()
     * @model default="AC40"
     * @generated
     */
    RtHwType getHwType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getHwType <em>Hw
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Hw Type</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtHwType
     * @see #getHwType()
     * @generated
     */
    void setHwType(RtHwType value);

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
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_FieldBus()
     * @model
     * @generated
     */
    int getFieldBus();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getFieldBus <em>Field
     * Bus</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Field Bus</em>' attribute.
     * @see #getFieldBus()
     * @generated
     */
    void setFieldBus(int value);

    /**
     * Returns the value of the '<em><b>Past Values Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Past Values Offset</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Past Values Offset</em>' attribute.
     * @see #setPastValuesOffset(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_PastValuesOffset()
     * @model
     * @generated
     */
    int getPastValuesOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getPastValuesOffset
     * <em>Past Values Offset</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Past Values Offset</em>' attribute.
     * @see #getPastValuesOffset()
     * @generated
     */
    void setPastValuesOffset(int value);

    /**
     * Returns the value of the '<em><b>Past Values Last Offset</b></em>'
     * attribute. The default value is <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Past Values Last Offset</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Past Values Last Offset</em>' attribute.
     * @see #setPastValuesLastOffset(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_PastValuesLastOffset()
     * @model default="0"
     * @generated
     */
    int getPastValuesLastOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getPastValuesLastOffset
     * <em>Past Values Last Offset</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Past Values Last Offset</em>'
     *            attribute.
     * @see #getPastValuesLastOffset()
     * @generated
     */
    void setPastValuesLastOffset(int value);

    /**
     * Returns the value of the '<em><b>Tasks Check Sum</b></em>' attribute. The
     * default value is <code>"-1"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tasks Check Sum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Tasks Check Sum</em>' attribute.
     * @see #setTasksCheckSum(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_TasksCheckSum()
     * @model default="-1"
     * @generated
     */
    int getTasksCheckSum();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getTasksCheckSum <em>Tasks
     * Check Sum</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Tasks Check Sum</em>' attribute.
     * @see #getTasksCheckSum()
     * @generated
     */
    void setTasksCheckSum(int value);

    /**
     * Returns the value of the '<em><b>Head Modul</b></em>' containment
     * reference. It is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getModule
     * <em>Module</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Head Modul</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Head Modul</em>' containment reference.
     * @see #setHeadModul(RtHeadModule)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_HeadModul()
     * @see de.wisag.automation.micas.rt.RtHeadModule#getModule
     * @model opposite="module" containment="true"
     * @generated
     */
    RtHeadModule getHeadModul();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModul <em>Head
     * Modul</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Head Modul</em>' containment
     *            reference.
     * @see #getHeadModul()
     * @generated
     */
    void setHeadModul(RtHeadModule value);

    /**
     * Returns the value of the '<em><b>Head Module Segment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Head Module Segment</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Head Module Segment</em>' attribute.
     * @see #setHeadModuleSegment(byte[])
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_HeadModuleSegment()
     * @model transient="true"
     * @generated
     */
    byte[] getHeadModuleSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModuleSegment
     * <em>Head Module Segment</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Head Module Segment</em>' attribute.
     * @see #getHeadModuleSegment()
     * @generated
     */
    void setHeadModuleSegment(byte[] value);

    /**
     * Returns the value of the '<em><b>Source Modification Stamp</b></em>'
     * attribute. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Modification Stamp</em>' attribute
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Source Modification Stamp</em>' attribute.
     * @see #setSourceModificationStamp(long)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_SourceModificationStamp()
     * @model
     * @generated
     */
    long getSourceModificationStamp();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getSourceModificationStamp
     * <em>Source Modification Stamp</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Source Modification Stamp</em>'
     *            attribute.
     * @see #getSourceModificationStamp()
     * @generated
     */
    void setSourceModificationStamp(long value);

    /**
     * Returns the value of the '<em><b>Source Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Source Name</em>' attribute.
     * @see #setSourceName(String)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_SourceName()
     * @model
     * @generated
     */
    String getSourceName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getSourceName <em>Source
     * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Source Name</em>' attribute.
     * @see #getSourceName()
     * @generated
     */
    void setSourceName(String value);

    /**
     * Returns the value of the '<em><b>Source Checksum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Checksum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Source Checksum</em>' attribute.
     * @see #setSourceChecksum(String)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_SourceChecksum()
     * @model
     * @generated
     */
    String getSourceChecksum();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getSourceChecksum
     * <em>Source Checksum</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Source Checksum</em>' attribute.
     * @see #getSourceChecksum()
     * @generated
     */
    void setSourceChecksum(String value);

    /**
     * Returns the value of the '<em><b>Comments</b></em>' attribute list. The
     * list contents are of type {@link java.lang.String}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Comments</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Comments</em>' attribute list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_Comments()
     * @model
     * @generated
     */
    EList<String> getComments();

    /**
     * Returns the value of the '<em><b>Start Segment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Segment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Start Segment</em>' attribute.
     * @see #setStartSegment(byte[])
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModule_StartSegment()
     * @model transient="true"
     * @generated
     */
    byte[] getStartSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModule#getStartSegment <em>Start
     * Segment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Start Segment</em>' attribute.
     * @see #getStartSegment()
     * @generated
     */
    void setStartSegment(byte[] value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getWordConstants(this);'"
     * @generated
     */
    EList<RtWordConstant> getWordConstants();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getWordVariables(this);'"
     * @generated
     */
    EList<RtWordVariable> getWordVariables();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getFloatConstants(this);'"
     * @generated
     */
    EList<RtFloatConstant> getFloatConstants();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getFloatVariables(this);'"
     * @generated
     */
    EList<RtFloatVariable> getFloatVariables();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getReferences(this);'"
     * @generated
     */
    EList<RtReferenceConstant> getReferences();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel
     *        body='RtModuleUtils.addSymbol(this,symbol);'"
     * @generated
     */
    void addSymbol(RtSymbol symbol);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getSymbol(this,id);'"
     * @generated
     */
    RtSymbol getSymbol(int id);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.haveSymbol(this,id);'"
     * @generated
     */
    boolean haveSymbol(int id);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.getModuleChecksum(this);'"
     * @generated
     */
    int getModuleChecksum();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        RtModuleUtils.calculateProgramSize(this);'"
     * @generated
     */
    int calculateProgramSize();

} // RtModule
