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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Head
 * Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtHeadModule#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtHeadModule#getTaskInfos <em>Task
 * Infos</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtHeadModule#getMagic0
 * <em>Magic0</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtHeadModule#getMagic1
 * <em>Magic1</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.RtHeadModule#getTaskCount <em>Task
 * Count</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtHeadModule()
 * @model
 * @generated
 */
public interface RtHeadModule extends EObject {
    /**
     * Returns the value of the '<em><b>Module</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.rt.RtModule#getHeadModul <em>Head
     * Modul</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Module</em>' container reference.
     * @see #setModule(RtModule)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtHeadModule_Module()
     * @see de.wisag.automation.micas.rt.RtModule#getHeadModul
     * @model opposite="headModul" transient="false"
     * @generated
     */
    RtModule getModule();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getModule
     * <em>Module</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Module</em>' container reference.
     * @see #getModule()
     * @generated
     */
    void setModule(RtModule value);

    /**
     * Returns the value of the '<em><b>Task Infos</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.wisag.automation.micas.rt.RtTaskInfo}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task Infos</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Task Infos</em>' containment reference
     *         list.
     * @see de.wisag.automation.micas.rt.RtPackage#getRtHeadModule_TaskInfos()
     * @model containment="true"
     * @generated
     */
    EList<RtTaskInfo> getTaskInfos();

    /**
     * Returns the value of the '<em><b>Magic0</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Magic0</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Magic0</em>' attribute.
     * @see #setMagic0(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtHeadModule_Magic0()
     * @model
     * @generated
     */
    int getMagic0();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getMagic0
     * <em>Magic0</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Magic0</em>' attribute.
     * @see #getMagic0()
     * @generated
     */
    void setMagic0(int value);

    /**
     * Returns the value of the '<em><b>Magic1</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Magic1</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Magic1</em>' attribute.
     * @see #setMagic1(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtHeadModule_Magic1()
     * @model
     * @generated
     */
    int getMagic1();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getMagic1
     * <em>Magic1</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Magic1</em>' attribute.
     * @see #getMagic1()
     * @generated
     */
    void setMagic1(int value);

    /**
     * Returns the value of the '<em><b>Task Count</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task Count</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Task Count</em>' attribute.
     * @see #setTaskCount(int)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtHeadModule_TaskCount()
     * @model
     * @generated
     */
    int getTaskCount();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtHeadModule#getTaskCount <em>Task
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Task Count</em>' attribute.
     * @see #getTaskCount()
     * @generated
     */
    void setTaskCount(int value);

} // RtHeadModule
