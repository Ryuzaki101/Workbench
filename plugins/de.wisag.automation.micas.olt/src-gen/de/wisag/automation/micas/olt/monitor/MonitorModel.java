/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.rt.RtModule;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getItems
 * <em>Items</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getLastUpdated
 * <em>Last Updated</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitorModel#isActive
 * <em>Active</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getRtModule
 * <em>Rt Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitorModel()
 * @model
 * @generated
 */
public interface MonitorModel extends EObject {
    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.olt.monitor.MonitoredItem}. It is
     * bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getMonitorModel
     * <em>Monitor Model</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitorModel_Items()
     * @see de.wisag.automation.micas.olt.monitor.MonitoredItem#getMonitorModel
     * @model opposite="monitorModel" containment="true"
     * @generated
     */
    EList<MonitoredItem> getItems();

    /**
     * Returns the value of the '<em><b>Last Updated</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Updated</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Last Updated</em>' attribute.
     * @see #setLastUpdated(long)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitorModel_LastUpdated()
     * @model
     * @generated
     */
    long getLastUpdated();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getLastUpdated
     * <em>Last Updated</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Last Updated</em>' attribute.
     * @see #getLastUpdated()
     * @generated
     */
    void setLastUpdated(long value);

    /**
     * Returns the value of the '<em><b>Active</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Active</em>' attribute.
     * @see #setActive(boolean)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitorModel_Active()
     * @model
     * @generated
     */
    boolean isActive();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#isActive
     * <em>Active</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Active</em>' attribute.
     * @see #isActive()
     * @generated
     */
    void setActive(boolean value);

    /**
     * Returns the value of the '<em><b>Rt Module</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rt Module</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Rt Module</em>' reference.
     * @see #setRtModule(RtModule)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitorModel_RtModule()
     * @model
     * @generated
     */
    RtModule getRtModule();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getRtModule
     * <em>Rt Module</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Rt Module</em>' reference.
     * @see #getRtModule()
     * @generated
     */
    void setRtModule(RtModule value);

} // MonitorModel
