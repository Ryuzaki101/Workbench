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
 * '<em><b>Task</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getModuleInvocations
 * <em>Module Invocations</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getId <em>Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getCyclTime <em>Cycl
 * Time</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getSegment
 * <em>Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getPastValuesOffset <em>Past
 * Values Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getStrategy
 * <em>Strategy</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getData <em>Data</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getRuntime
 * <em>Runtime</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getPastValuesCount <em>Past
 * Values Count</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTask#getComment
 * <em>Comment</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtTask()
 * @model
 * @generated
 */
public interface RtTask extends EObject {
    /**
     * Returns the value of the '<em><b>Module</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtModule#getTasks <em>Tasks</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Module</em>' container reference.
     * @see #setModule(RtModule)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Module()
     * @see de.wisag.automation.micas.rt.RtModule#getTasks
     * @model opposite="tasks" transient="false"
     * @generated
     */
    RtModule getModule();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getModule <em>Module</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Module</em>' container reference.
     * @see #getModule()
     * @generated
     */
    void setModule(RtModule value);

    /**
     * Returns the value of the '<em><b>Module Invocations</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.wisag.automation.micas.rt.RtModuleInvocation}. It is
     * bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getTask
     * <em>Task</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module Invocations</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Module Invocations</em>' containment
     *         reference list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_ModuleInvocations()
     * @see de.wisag.automation.micas.rt.RtModuleInvocation#getTask
     * @model opposite="task" containment="true"
     * @generated
     */
    EList<RtModuleInvocation> getModuleInvocations();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Id()
     * @model
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link de.wisag.automation.micas.rt.RtTask#getId
     * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Cycl Time</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cycl Time</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Cycl Time</em>' attribute.
     * @see #setCyclTime(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_CyclTime()
     * @model
     * @generated
     */
    int getCyclTime();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getCyclTime <em>Cycl
     * Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Cycl Time</em>' attribute.
     * @see #getCyclTime()
     * @generated
     */
    void setCyclTime(int value);

    /**
     * Returns the value of the '<em><b>Segment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Segment</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Segment</em>' attribute.
     * @see #setSegment(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Segment()
     * @model
     * @generated
     */
    int getSegment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getSegment <em>Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Segment</em>' attribute.
     * @see #getSegment()
     * @generated
     */
    void setSegment(int value);

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
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_PastValuesOffset()
     * @model
     * @generated
     */
    int getPastValuesOffset();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getPastValuesOffset <em>Past
     * Values Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Past Values Offset</em>' attribute.
     * @see #getPastValuesOffset()
     * @generated
     */
    void setPastValuesOffset(int value);

    /**
     * Returns the value of the '<em><b>Strategy</b></em>' attribute. The
     * literals are from the enumeration
     * {@link de.wisag.automation.micas.rt.RtTaskStrategy}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Strategy</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Strategy</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtTaskStrategy
     * @see #setStrategy(RtTaskStrategy)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Strategy()
     * @model
     * @generated
     */
    RtTaskStrategy getStrategy();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getStrategy
     * <em>Strategy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Strategy</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtTaskStrategy
     * @see #getStrategy()
     * @generated
     */
    void setStrategy(RtTaskStrategy value);

    /**
     * Returns the value of the '<em><b>Data</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Data</em>' attribute.
     * @see #setData(byte[])
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Data()
     * @model transient="true"
     * @generated
     */
    byte[] getData();

    /**
     * Sets the value of the '{@link de.wisag.automation.micas.rt.RtTask#getData
     * <em>Data</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Data</em>' attribute.
     * @see #getData()
     * @generated
     */
    void setData(byte[] value);

    /**
     * Returns the value of the '<em><b>Runtime</b></em>' attribute. The default
     * value is <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Runtime</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Runtime</em>' attribute.
     * @see #setRuntime(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Runtime()
     * @model default="0"
     * @generated
     */
    int getRuntime();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getRuntime <em>Runtime</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Runtime</em>' attribute.
     * @see #getRuntime()
     * @generated
     */
    void setRuntime(int value);

    /**
     * Returns the value of the '<em><b>Past Values Count</b></em>' attribute.
     * The default value is <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Past Values Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Past Values Count</em>' attribute.
     * @see #setPastValuesCount(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_PastValuesCount()
     * @model default="0"
     * @generated
     */
    int getPastValuesCount();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getPastValuesCount <em>Past
     * Values Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Past Values Count</em>' attribute.
     * @see #getPastValuesCount()
     * @generated
     */
    void setPastValuesCount(int value);

    /**
     * Returns the value of the '<em><b>Comment</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comment</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Comment</em>' attribute.
     * @see #setComment(String)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTask_Comment()
     * @model
     * @generated
     */
    String getComment();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTask#getComment <em>Comment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Comment</em>' attribute.
     * @see #getComment()
     * @generated
     */
    void setComment(String value);

} // RtTask
