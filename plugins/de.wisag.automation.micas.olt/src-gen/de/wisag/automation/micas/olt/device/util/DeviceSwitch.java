/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.Connection;
import de.wisag.automation.micas.olt.device.ConnectionInfo;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.device.DevicePackage;
import de.wisag.automation.micas.olt.device.NetworkConnectionInfo;
import de.wisag.automation.micas.olt.device.SerialConnectionInfo;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.device.DevicePackage
 * @generated
 */
public class DeviceSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static DevicePackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public DeviceSwitch() {
        if (modelPackage == null) {
            modelPackage = DevicePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case DevicePackage.DEVICE_INFO: {
            DeviceInfo deviceInfo = (DeviceInfo) theEObject;
            T result = caseDeviceInfo(deviceInfo);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case DevicePackage.CONNECTION_INFO: {
            ConnectionInfo connectionInfo = (ConnectionInfo) theEObject;
            T result = caseConnectionInfo(connectionInfo);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case DevicePackage.NETWORK_CONNECTION_INFO: {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) theEObject;
            T result = caseNetworkConnectionInfo(networkConnectionInfo);
            if (result == null) {
                result = caseConnectionInfo(networkConnectionInfo);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case DevicePackage.SERIAL_CONNECTION_INFO: {
            SerialConnectionInfo serialConnectionInfo = (SerialConnectionInfo) theEObject;
            T result = caseSerialConnectionInfo(serialConnectionInfo);
            if (result == null) {
                result = caseConnectionInfo(serialConnectionInfo);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case DevicePackage.CONNECTION: {
            Connection connection = (Connection) theEObject;
            T result = caseConnection(connection);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case DevicePackage.ADDRESS: {
            Address address = (Address) theEObject;
            T result = caseAddress(address);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case DevicePackage.DATA_RANGE: {
            DataRange dataRange = (DataRange) theEObject;
            T result = caseDataRange(dataRange);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Info</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDeviceInfo(DeviceInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Connection Info</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Connection Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnectionInfo(ConnectionInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Network Connection Info</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Network Connection Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNetworkConnectionInfo(NetworkConnectionInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Serial Connection Info</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Serial Connection Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSerialConnectionInfo(SerialConnectionInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Connection</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnection(Connection object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Address</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Address</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAddress(Address object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data
     * Range</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data
     *         Range</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataRange(DataRange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch, but this is
     * the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // DeviceSwitch
