/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Page</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.Page#getTask <em>Task</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getPage()
 * @model
 * @generated
 */
public interface Page extends org.eclipselabs.damos.dml.System {
    /**
     * Returns the value of the '<em><b>Task</b></em>' container reference. It
     * is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.module.Task#getPages <em>Pages</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Task</em>' container reference.
     * @see #setTask(Task)
     * @see de.wisag.automation.micas.module.ModulePackage#getPage_Task()
     * @see de.wisag.automation.micas.module.Task#getPages
     * @model opposite="pages" required="true" transient="false"
     * @generated
     */
    Task getTask();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Page#getTask <em>Task</em>}'
     * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Task</em>' container reference.
     * @see #getTask()
     * @generated
     */
    void setTask(Task value);

} // Page
