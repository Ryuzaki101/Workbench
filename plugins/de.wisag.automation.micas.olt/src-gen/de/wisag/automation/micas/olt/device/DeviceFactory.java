/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.device.DevicePackage
 * @generated
 */
public interface DeviceFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    DeviceFactory eINSTANCE = de.wisag.automation.micas.olt.device.impl.DeviceFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Info</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Info</em>'.
     * @generated
     */
    DeviceInfo createDeviceInfo();

    /**
     * Returns a new object of class '<em>Connection Info</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Connection Info</em>'.
     * @generated
     */
    ConnectionInfo createConnectionInfo();

    /**
     * Returns a new object of class '<em>Network Connection Info</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Network Connection Info</em>'.
     * @generated
     */
    NetworkConnectionInfo createNetworkConnectionInfo();

    /**
     * Returns a new object of class '<em>Serial Connection Info</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Serial Connection Info</em>'.
     * @generated
     */
    SerialConnectionInfo createSerialConnectionInfo();

    /**
     * Returns a new object of class '<em>Connection</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Connection</em>'.
     * @generated
     */
    Connection createConnection();

    /**
     * Returns a new object of class '<em>Address</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Address</em>'.
     * @generated
     */
    Address createAddress();

    /**
     * Returns a new object of class '<em>Data Range</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Data Range</em>'.
     * @generated
     */
    DataRange createDataRange();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    DevicePackage getDevicePackage();

} // DeviceFactory
