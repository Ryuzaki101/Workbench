/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.monitor.MonitorPackage
 * @generated
 */
public class MonitorSwitch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static MonitorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public MonitorSwitch() {
        if (modelPackage == null) {
            modelPackage = MonitorPackage.eINSTANCE;
        }
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
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
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
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
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
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case MonitorPackage.MONITOR_MODEL: {
            MonitorModel monitorModel = (MonitorModel) theEObject;
            T result = caseMonitorModel(monitorModel);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case MonitorPackage.MONITORED_ITEM: {
            MonitoredItem monitoredItem = (MonitoredItem) theEObject;
            T result = caseMonitoredItem(monitoredItem);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case MonitorPackage.MONITORED_VALUE_SET: {
            MonitoredValueSet monitoredValueSet = (MonitoredValueSet) theEObject;
            T result = caseMonitoredValueSet(monitoredValueSet);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case MonitorPackage.MONITORED_VALUE: {
            MonitoredValue monitoredValue = (MonitoredValue) theEObject;
            T result = caseMonitoredValue(monitoredValue);
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
     * '<em>Model</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitorModel(MonitorModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Monitored Item</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Monitored Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitoredItem(MonitoredItem object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Monitored Value Set</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Monitored Value Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitoredValueSet(MonitoredValueSet object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Monitored Value</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Monitored Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitoredValue(MonitoredValue object) {
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
    public T defaultCase(EObject object) {
        return null;
    }

} // MonitorSwitch
