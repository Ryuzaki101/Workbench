/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Task
 * Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtTaskInfo#getTask
 * <em>Task</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtTaskInfo#getConvertedStrategy
 * <em>Converted Strategy</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtTaskInfo()
 * @model
 * @generated
 */
public interface RtTaskInfo extends EObject {
    /**
     * Returns the value of the '<em><b>Task</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Task</em>' reference.
     * @see #setTask(RtTask)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTaskInfo_Task()
     * @model
     * @generated
     */
    RtTask getTask();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTaskInfo#getTask <em>Task</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Task</em>' reference.
     * @see #getTask()
     * @generated
     */
    void setTask(RtTask value);

    /**
     * Returns the value of the '<em><b>Converted Strategy</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Converted Strategy</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Converted Strategy</em>' attribute.
     * @see #setConvertedStrategy(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtTaskInfo_ConvertedStrategy()
     * @model
     * @generated
     */
    int getConvertedStrategy();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtTaskInfo#getConvertedStrategy
     * <em>Converted Strategy</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Converted Strategy</em>' attribute.
     * @see #getConvertedStrategy()
     * @generated
     */
    void setConvertedStrategy(int value);

} // RtTaskInfo
