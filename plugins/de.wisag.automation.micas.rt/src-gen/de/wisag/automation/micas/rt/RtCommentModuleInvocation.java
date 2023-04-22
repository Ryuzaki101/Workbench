/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Comment
 * Module Invocation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.RtCommentModuleInvocation#getText
 * <em>Text</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.rt.RtPackage#getRtCommentModuleInvocation()
 * @model
 * @generated
 */
public interface RtCommentModuleInvocation extends RtModuleInvocation {
    /**
     * Returns the value of the '<em><b>Text</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Text</em>' attribute.
     * @see #setText(String)
     * @see de.wisag.automation.micas.rt.RtPackage#getRtCommentModuleInvocation_Text()
     * @model
     * @generated
     */
    String getText();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.rt.RtCommentModuleInvocation#getText
     * <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Text</em>' attribute.
     * @see #getText()
     * @generated
     */
    void setText(String value);

} // RtCommentModuleInvocation
