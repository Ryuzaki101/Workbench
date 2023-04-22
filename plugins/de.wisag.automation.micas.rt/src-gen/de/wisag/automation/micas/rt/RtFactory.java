/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.rt.RtPackage
 * @generated
 */
public interface RtFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    RtFactory eINSTANCE = de.wisag.automation.micas.rt.impl.RtFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Module</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Module</em>'.
     * @generated
     */
    RtModule createRtModule();

    /**
     * Returns a new object of class '<em>Task</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Task</em>'.
     * @generated
     */
    RtTask createRtTask();

    /**
     * Returns a new object of class '<em>Symbol</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Symbol</em>'.
     * @generated
     */
    RtSymbol createRtSymbol();

    /**
     * Returns a new object of class '<em>Constant</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Constant</em>'.
     * @generated
     */
    RtConstant createRtConstant();

    /**
     * Returns a new object of class '<em>Variable</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Variable</em>'.
     * @generated
     */
    RtVariable createRtVariable();

    /**
     * Returns a new object of class '<em>Word Constant</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Word Constant</em>'.
     * @generated
     */
    RtWordConstant createRtWordConstant();

    /**
     * Returns a new object of class '<em>Float Constant</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Float Constant</em>'.
     * @generated
     */
    RtFloatConstant createRtFloatConstant();

    /**
     * Returns a new object of class '<em>Direct Value</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Direct Value</em>'.
     * @generated
     */
    RtDirectValue createRtDirectValue();

    /**
     * Returns a new object of class '<em>Word Variable</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Word Variable</em>'.
     * @generated
     */
    RtWordVariable createRtWordVariable();

    /**
     * Returns a new object of class '<em>Float Variable</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Float Variable</em>'.
     * @generated
     */
    RtFloatVariable createRtFloatVariable();

    /**
     * Returns a new object of class '<em>Module Invocation</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Module Invocation</em>'.
     * @generated
     */
    RtModuleInvocation createRtModuleInvocation();

    /**
     * Returns a new object of class '<em>Comment Module Invocation</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Comment Module Invocation</em>'.
     * @generated
     */
    RtCommentModuleInvocation createRtCommentModuleInvocation();

    /**
     * Returns a new object of class '<em>Reference Constant</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Reference Constant</em>'.
     * @generated
     */
    RtReferenceConstant createRtReferenceConstant();

    /**
     * Returns a new object of class '<em>Symbol Access</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Symbol Access</em>'.
     * @generated
     */
    RtSymbolAccess createRtSymbolAccess();

    /**
     * Returns a new object of class '<em>Head Module</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Head Module</em>'.
     * @generated
     */
    RtHeadModule createRtHeadModule();

    /**
     * Returns a new object of class '<em>Task Info</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Task Info</em>'.
     * @generated
     */
    RtTaskInfo createRtTaskInfo();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    RtPackage getRtPackage();

} // RtFactory
