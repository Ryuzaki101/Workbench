/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.wisag.automation.micas.olt.monitor.MonitorFactory;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class MonitorFactoryImpl extends EFactoryImpl implements MonitorFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static MonitorFactory init() {
        try {
            MonitorFactory theMonitorFactory = (MonitorFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://www.wisag.de/automation/schema/monitor");
            if (theMonitorFactory != null) {
                return theMonitorFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new MonitorFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public MonitorFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case MonitorPackage.MONITOR_MODEL:
            return createMonitorModel();
        case MonitorPackage.MONITORED_ITEM:
            return createMonitoredItem();
        case MonitorPackage.MONITORED_VALUE_SET:
            return createMonitoredValueSet();
        case MonitorPackage.MONITORED_VALUE:
            return createMonitoredValue();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitorModel createMonitorModel() {
        MonitorModelImpl monitorModel = new MonitorModelImpl();
        return monitorModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitoredItem createMonitoredItem() {
        MonitoredItemImpl monitoredItem = new MonitoredItemImpl();
        return monitoredItem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitoredValueSet createMonitoredValueSet() {
        MonitoredValueSetImpl monitoredValueSet = new MonitoredValueSetImpl();
        return monitoredValueSet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitoredValue createMonitoredValue() {
        MonitoredValueImpl monitoredValue = new MonitoredValueImpl();
        return monitoredValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitorPackage getMonitorPackage() {
        return (MonitorPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MonitorPackage getPackage() {
        return MonitorPackage.eINSTANCE;
    }

} // MonitorFactoryImpl
