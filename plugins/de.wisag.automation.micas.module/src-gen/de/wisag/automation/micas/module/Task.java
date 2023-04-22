/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Task</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.Task#getKind <em>Kind</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Task#getCycleTime <em>Cycle
 * Time</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Task#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Task#getPages
 * <em>Pages</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Task#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Task#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject {
    /**
     * Returns the value of the '<em><b>Kind</b></em>' attribute. The literals
     * are from the enumeration
     * {@link de.wisag.automation.micas.module.TaskKind}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Kind</em>' attribute.
     * @see de.wisag.automation.micas.module.TaskKind
     * @see #setKind(TaskKind)
     * @see de.wisag.automation.micas.module.ModulePackage#getTask_Kind()
     * @model required="true" ordered="false"
     * @generated
     */
    TaskKind getKind();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Task#getKind <em>Kind</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Kind</em>' attribute.
     * @see de.wisag.automation.micas.module.TaskKind
     * @see #getKind()
     * @generated
     */
    void setKind(TaskKind value);

    /**
     * Returns the value of the '<em><b>Cycle Time</b></em>' attribute. The
     * default value is <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cycle Time</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Cycle Time</em>' attribute.
     * @see #setCycleTime(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getTask_CycleTime()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    int getCycleTime();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Task#getCycleTime <em>Cycle
     * Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Cycle Time</em>' attribute.
     * @see #getCycleTime()
     * @generated
     */
    void setCycleTime(int value);

    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute. The default
     * value is <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getTask_Index()
     * @model default="0" required="true" ordered="false"
     * @generated
     */
    int getIndex();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Task#getIndex <em>Index</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
    void setIndex(int value);

    /**
     * Returns the value of the '<em><b>Pages</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.module.Page}. It is bidirectional and
     * its opposite is '{@link de.wisag.automation.micas.module.Page#getTask
     * <em>Task</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pages</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Pages</em>' containment reference list.
     * @see de.wisag.automation.micas.module.ModulePackage#getTask_Pages()
     * @see de.wisag.automation.micas.module.Page#getTask
     * @model opposite="task" containment="true"
     * @generated
     */
    EList<Page> getPages();

    /**
     * Returns the value of the '<em><b>Module</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.module.Module#getTasks
     * <em>Tasks</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Module</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Module</em>' container reference.
     * @see #setModule(Module)
     * @see de.wisag.automation.micas.module.ModulePackage#getTask_Module()
     * @see de.wisag.automation.micas.module.Module#getTasks
     * @model opposite="tasks" required="true" transient="false"
     * @generated
     */
    Module getModule();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Task#getModule <em>Module</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Module</em>' container reference.
     * @see #getModule()
     * @generated
     */
    void setModule(Module value);

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
     * @see de.wisag.automation.micas.module.ModulePackage#getTask_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Task#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Task
