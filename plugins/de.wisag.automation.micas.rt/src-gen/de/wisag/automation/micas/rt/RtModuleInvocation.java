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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Module
 * Invocation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getArguments
 * <em>Arguments</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getTask
 * <em>Task</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getOpcode
 * <em>Opcode</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getPastValuesCount
 * <em>Past Values Count</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtModuleInvocation#getRuntime
 * <em>Runtime</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation()
 * @model
 * @generated
 */
public interface RtModuleInvocation extends EObject {
    /**
     * Returns the value of the '<em><b>Arguments</b></em>' reference list. The
     * list contents are of type
     * {@link de.wisag.automation.micas.rt.RtSymbolAccess}. It is bidirectional
     * and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess#getModuleInvocation
     * <em>Module Invocation</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Arguments</em>' reference list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_Arguments()
     * @see de.wisag.automation.micas.rt.RtSymbolAccess#getModuleInvocation
     * @model opposite="moduleInvocation"
     * @generated
     */
    EList<RtSymbolAccess> getArguments();

    /**
     * Returns the value of the '<em><b>Task</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtTask#getModuleInvocations
     * <em>Module Invocations</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Task</em>' container reference.
     * @see #setTask(RtTask)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_Task()
     * @see de.wisag.automation.micas.rt.RtTask#getModuleInvocations
     * @model opposite="moduleInvocations" transient="false"
     * @generated
     */
    RtTask getTask();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getTask
     * <em>Task</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Task</em>' container reference.
     * @see #getTask()
     * @generated
     */
    void setTask(RtTask value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_Index()
     * @model
     * @generated
     */
    int getIndex();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getIndex
     * <em>Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
    void setIndex(int value);

    /**
     * Returns the value of the '<em><b>Opcode</b></em>' attribute. The default
     * value is <code>"-1"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Opcode</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Opcode</em>' attribute.
     * @see #setOpcode(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_Opcode()
     * @model default="-1"
     * @generated
     */
    int getOpcode();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getOpcode
     * <em>Opcode</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Opcode</em>' attribute.
     * @see #getOpcode()
     * @generated
     */
    void setOpcode(int value);

    /**
     * Returns the value of the '<em><b>Past Values Count</b></em>' attribute.
     * The default value is <code>"-1"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Past Values Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Past Values Count</em>' attribute.
     * @see #setPastValuesCount(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_PastValuesCount()
     * @model default="-1"
     * @generated
     */
    int getPastValuesCount();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getPastValuesCount
     * <em>Past Values Count</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Past Values Count</em>' attribute.
     * @see #getPastValuesCount()
     * @generated
     */
    void setPastValuesCount(int value);

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
     * @see de.wisag.automation.micas.rt.RtPackage#getRtModuleInvocation_Runtime()
     * @model default="0"
     * @generated
     */
    int getRuntime();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation#getRuntime
     * <em>Runtime</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Runtime</em>' attribute.
     * @see #getRuntime()
     * @generated
     */
    void setRuntime(int value);

} // RtModuleInvocation
