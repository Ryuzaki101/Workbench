/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.monitor.MonitorPackage
 * @generated
 */
public interface MonitorFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    MonitorFactory eINSTANCE = de.wisag.automation.micas.olt.monitor.impl.MonitorFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Model</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
    MonitorModel createMonitorModel();

    /**
     * Returns a new object of class '<em>Monitored Item</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Monitored Item</em>'.
     * @generated
     */
    MonitoredItem createMonitoredItem();

    /**
     * Returns a new object of class '<em>Monitored Value Set</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Monitored Value Set</em>'.
     * @generated
     */
    MonitoredValueSet createMonitoredValueSet();

    /**
     * Returns a new object of class '<em>Monitored Value</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Monitored Value</em>'.
     * @generated
     */
    MonitoredValue createMonitoredValue();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    MonitorPackage getMonitorPackage();

} // MonitorFactory
