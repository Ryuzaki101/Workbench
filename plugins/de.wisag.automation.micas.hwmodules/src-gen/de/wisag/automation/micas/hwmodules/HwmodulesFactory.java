/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage
 * @generated
 */
public interface HwmodulesFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    HwmodulesFactory eINSTANCE = de.wisag.automation.micas.hwmodules.impl.HwmodulesFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Module Definition</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Module Definition</em>'.
     * @generated
     */
    ModuleDefinition createModuleDefinition();

    /**
     * Returns a new object of class '<em>Port</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Port</em>'.
     * @generated
     */
    Port createPort();

    /**
     * Returns a new object of class '<em>Port Group</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Port Group</em>'.
     * @generated
     */
    PortGroup createPortGroup();

    /**
     * Returns a new object of class '<em>Micas Modules</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Micas Modules</em>'.
     * @generated
     */
    MicasModules createMicasModules();

    /**
     * Returns a new object of class '<em>Parameter</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Parameter</em>'.
     * @generated
     */
    Parameter createParameter();

    /**
     * Returns a new object of class '<em>Hardware Type Definition</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Hardware Type Definition</em>'.
     * @generated
     */
    HardwareTypeDefinition createHardwareTypeDefinition();

    /**
     * Returns a new object of class '<em>Hardware Alias</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Hardware Alias</em>'.
     * @generated
     */
    HardwareAlias createHardwareAlias();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    HwmodulesPackage getHwmodulesPackage();

} // HwmodulesFactory
