/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.rt.RtHwType;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Monitored Value Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getTimestamp
 * <em>Timestamp</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getValues
 * <em>Values</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getHwType
 * <em>Hw Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValueSet()
 * @model
 * @generated
 */
public interface MonitoredValueSet extends EObject {
    /**
     * Returns the value of the '<em><b>Timestamp</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timestamp</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Timestamp</em>' attribute.
     * @see #setTimestamp(long)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValueSet_Timestamp()
     * @model
     * @generated
     */
    long getTimestamp();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getTimestamp
     * <em>Timestamp</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Timestamp</em>' attribute.
     * @see #getTimestamp()
     * @generated
     */
    void setTimestamp(long value);

    /**
     * Returns the value of the '<em><b>Values</b></em>' reference list. The
     * list contents are of type
     * {@link de.wisag.automation.micas.olt.monitor.MonitoredValue}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Values</em>' reference list.
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValueSet_Values()
     * @model
     * @generated
     */
    EList<MonitoredValue> getValues();

    /**
     * Returns the value of the '<em><b>Hw Type</b></em>' attribute. The
     * literals are from the enumeration
     * {@link de.wisag.automation.micas.rt.RtHwType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hw Type</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Hw Type</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtHwType
     * @see #setHwType(RtHwType)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValueSet_HwType()
     * @model
     * @generated
     */
    RtHwType getHwType();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getHwType
     * <em>Hw Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Hw Type</em>' attribute.
     * @see de.wisag.automation.micas.rt.RtHwType
     * @see #getHwType()
     * @generated
     */
    void setHwType(RtHwType value);

} // MonitoredValueSet
