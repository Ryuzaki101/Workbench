/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.Connection;
import de.wisag.automation.micas.olt.device.ConnectionInfo;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.device.DevicePackage;
import de.wisag.automation.micas.olt.device.NetworkConnectionInfo;
import de.wisag.automation.micas.olt.device.SerialConnectionInfo;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.device.DevicePackage
 * @generated
 */
public class DeviceAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static DevicePackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public DeviceAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = DevicePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DeviceSwitch<Adapter> modelSwitch = new DeviceSwitch<Adapter>() {
        @Override
        public Adapter caseDeviceInfo(DeviceInfo object) {
            return createDeviceInfoAdapter();
        }

        @Override
        public Adapter caseConnectionInfo(ConnectionInfo object) {
            return createConnectionInfoAdapter();
        }

        @Override
        public Adapter caseNetworkConnectionInfo(NetworkConnectionInfo object) {
            return createNetworkConnectionInfoAdapter();
        }

        @Override
        public Adapter caseSerialConnectionInfo(SerialConnectionInfo object) {
            return createSerialConnectionInfoAdapter();
        }

        @Override
        public Adapter caseConnection(Connection object) {
            return createConnectionAdapter();
        }

        @Override
        public Adapter caseAddress(Address object) {
            return createAddressAdapter();
        }

        @Override
        public Adapter caseDataRange(DataRange object) {
            return createDataRangeAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.DeviceInfo <em>Info</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.DeviceInfo
     * @generated
     */
    public Adapter createDeviceInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.ConnectionInfo
     * <em>Connection Info</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.ConnectionInfo
     * @generated
     */
    public Adapter createConnectionInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.NetworkConnectionInfo
     * <em>Network Connection Info</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.NetworkConnectionInfo
     * @generated
     */
    public Adapter createNetworkConnectionInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.SerialConnectionInfo
     * <em>Serial Connection Info</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.SerialConnectionInfo
     * @generated
     */
    public Adapter createSerialConnectionInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.Connection
     * <em>Connection</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.Connection
     * @generated
     */
    public Adapter createConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.Address <em>Address</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.Address
     * @generated
     */
    public Adapter createAddressAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.olt.device.DataRange <em>Data
     * Range</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.olt.device.DataRange
     * @generated
     */
    public Adapter createDataRangeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // DeviceAdapterFactory
