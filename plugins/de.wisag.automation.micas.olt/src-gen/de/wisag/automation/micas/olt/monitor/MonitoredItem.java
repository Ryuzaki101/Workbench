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
 * '<em><b>Monitored Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getRtSymbol
 * <em>Rt Symbol</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getTextValue
 * <em>Text Value</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getMonitorModel
 * <em>Monitor Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredItem()
 * @model
 * @generated
 */
public interface MonitoredItem extends EObject {
    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredItem_Index()
     * @model
     * @generated
     */
    int getIndex();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getIndex
     * <em>Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
    void setIndex(int value);

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
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredItem_RtSymbol()
     * @model
     * @generated
     */
    RtSymbol getRtSymbol();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getRtSymbol
     * <em>Rt Symbol</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Rt Symbol</em>' reference.
     * @see #getRtSymbol()
     * @generated
     */
    void setRtSymbol(RtSymbol value);

    /**
     * Returns the value of the '<em><b>Text Value</b></em>' attribute. The
     * default value is <code>"\"\""</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Value</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Text Value</em>' attribute.
     * @see #setTextValue(String)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredItem_TextValue()
     * @model default="\"\""
     * @generated
     */
    String getTextValue();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getTextValue
     * <em>Text Value</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Text Value</em>' attribute.
     * @see #getTextValue()
     * @generated
     */
    void setTextValue(String value);

    /**
     * Returns the value of the '<em><b>Monitor Model</b></em>' container
     * reference. It is bidirectional and its opposite is
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getItems
     * <em>Items</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Monitor Model</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Monitor Model</em>' container reference.
     * @see #setMonitorModel(MonitorModel)
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#getMonitoredItem_MonitorModel()
     * @see de.wisag.automation.micas.olt.monitor.MonitorModel#getItems
     * @model opposite="items" transient="false"
     * @generated
     */
    MonitorModel getMonitorModel();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getMonitorModel
     * <em>Monitor Model</em>}' container reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Monitor Model</em>' container
     *            reference.
     * @see #getMonitorModel()
     * @generated
     */
    void setMonitorModel(MonitorModel value);

} // MonitoredItem
