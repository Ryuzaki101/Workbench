/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor;

import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.rt.RtSymbol;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Monitored Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getValue
 * <em>Value</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getRtSymbol
 * <em>Rt Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValue()
 * @model
 * @generated
 */
public interface MonitoredValue extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValue_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute. The default
     * value is <code>"\"\""</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValue_Value()
     * @model default="\"\""
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getValue
     * <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Rt Symbol</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rt Symbol</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Rt Symbol</em>' reference.
     * @see #setRtSymbol(RtSymbol)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredValue_RtSymbol()
     * @model
     * @generated
     */
    RtSymbol getRtSymbol();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getRtSymbol
     * <em>Rt Symbol</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Rt Symbol</em>' reference.
     * @see #getRtSymbol()
     * @generated
     */
    void setRtSymbol(RtSymbol value);

} // MonitoredValue
