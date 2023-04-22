/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.module.ModulePackage
 * @generated
 */
public interface ModuleFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    ModuleFactory eINSTANCE = de.wisag.automation.micas.module.impl.ModuleFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Module</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Module</em>'.
     * @generated
     */
    Module createModule();

    /**
     * Returns a new object of class '<em>Task</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Task</em>'.
     * @generated
     */
    Task createTask();

    /**
     * Returns a new object of class '<em>Variable Attribute</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Variable Attribute</em>'.
     * @generated
     */
    VariableAttribute createVariableAttribute();

    /**
     * Returns a new object of class '<em>Constant Attribute</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Constant Attribute</em>'.
     * @generated
     */
    ConstantAttribute createConstantAttribute();

    /**
     * Returns a new object of class '<em>Reference Attribute</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Reference Attribute</em>'.
     * @generated
     */
    ReferenceAttribute createReferenceAttribute();

    /**
     * Returns a new object of class '<em>Float Value</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Float Value</em>'.
     * @generated
     */
    FloatValue createFloatValue();

    /**
     * Returns a new object of class '<em>Word Value</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Word Value</em>'.
     * @generated
     */
    WordValue createWordValue();

    /**
     * Returns a new object of class '<em>Attribute Specification</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Attribute Specification</em>'.
     * @generated
     */
    AttributeSpecification createAttributeSpecification();

    /**
     * Returns a new object of class '<em>Micas Data Type Specification</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Micas Data Type Specification</em>'.
     * @generated
     */
    MicasDataTypeSpecification createMicasDataTypeSpecification();

    /**
     * Returns a new object of class '<em>Page</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Page</em>'.
     * @generated
     */
    Page createPage();

    /**
     * Returns a new object of class '<em>Incoming Offpage Connector</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Incoming Offpage Connector</em>'.
     * @generated
     */
    IncomingOffpageConnector createIncomingOffpageConnector();

    /**
     * Returns a new object of class '<em>Outgoing Offpage Connector</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Outgoing Offpage Connector</em>'.
     * @generated
     */
    OutgoingOffpageConnector createOutgoingOffpageConnector();

    /**
     * Returns a new object of class '<em>Constant</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Constant</em>'.
     * @generated
     */
    Constant createConstant();

    /**
     * Returns a new object of class '<em>Reference</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Reference</em>'.
     * @generated
     */
    Reference createReference();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    ModulePackage getModulePackage();

} // ModuleFactory
