/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.olt.monitor.MonitorFactory
 * @model kind="package"
 * @generated
 */
public interface MonitorPackage extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "monitor";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.wisag.de/automation/schema/monitor";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    MonitorPackage eINSTANCE = de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl.init();

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl
     * <em>Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitorModel()
     * @generated
     */
    int MONITOR_MODEL = 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITOR_MODEL__ITEMS = 0;

    /**
     * The feature id for the '<em><b>Last Updated</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITOR_MODEL__LAST_UPDATED = 1;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITOR_MODEL__ACTIVE = 2;

    /**
     * The feature id for the '<em><b>Rt Module</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITOR_MODEL__RT_MODULE = 3;

    /**
     * The number of structural features of the '<em>Model</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITOR_MODEL_FEATURE_COUNT = 4;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl
     * <em>Monitored Item</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitoredItem()
     * @generated
     */
    int MONITORED_ITEM = 1;

    /**
     * The feature id for the '<em><b>Index</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_ITEM__INDEX = 0;

    /**
     * The feature id for the '<em><b>Rt Symbol</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_ITEM__RT_SYMBOL = 1;

    /**
     * The feature id for the '<em><b>Text Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_ITEM__TEXT_VALUE = 2;

    /**
     * The feature id for the '<em><b>Monitor Model</b></em>' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_ITEM__MONITOR_MODEL = 3;

    /**
     * The number of structural features of the '<em>Monitored Item</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_ITEM_FEATURE_COUNT = 4;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl
     * <em>Monitored Value Set</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitoredValueSet()
     * @generated
     */
    int MONITORED_VALUE_SET = 2;

    /**
     * The feature id for the '<em><b>Timestamp</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE_SET__TIMESTAMP = 0;

    /**
     * The feature id for the '<em><b>Values</b></em>' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE_SET__VALUES = 1;

    /**
     * The feature id for the '<em><b>Hw Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE_SET__HW_TYPE = 2;

    /**
     * The number of structural features of the '<em>Monitored Value Set</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE_SET_FEATURE_COUNT = 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl
     * <em>Monitored Value</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl
     * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitoredValue()
     * @generated
     */
    int MONITORED_VALUE = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE__NAME = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE__VALUE = 1;

    /**
     * The feature id for the '<em><b>Rt Symbol</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE__RT_SYMBOL = 2;

    /**
     * The number of structural features of the '<em>Monitored Value</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MONITORED_VALUE_FEATURE_COUNT = 3;

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel
     * <em>Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Model</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitorModel
     * @generated
     */
    EClass getMonitorModel();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getItems
     * <em>Items</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list
     *         '<em>Items</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitorModel#getItems()
     * @see #getMonitorModel()
     * @generated
     */
    EReference getMonitorModel_Items();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getLastUpdated
     * <em>Last Updated</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Last Updated</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitorModel#getLastUpdated()
     * @see #getMonitorModel()
     * @generated
     */
    EAttribute getMonitorModel_LastUpdated();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#isActive
     * <em>Active</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitorModel#isActive()
     * @see #getMonitorModel()
     * @generated
     */
    EAttribute getMonitorModel_Active();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.olt.monitor.MonitorModel#getRtModule
     * <em>Rt Module</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Rt Module</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitorModel#getRtModule()
     * @see #getMonitorModel()
     * @generated
     */
    EReference getMonitorModel_RtModule();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem <em>Monitored
     * Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Monitored Item</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredItem
     * @generated
     */
    EClass getMonitoredItem();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getIndex
     * <em>Index</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Index</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredItem#getIndex()
     * @see #getMonitoredItem()
     * @generated
     */
    EAttribute getMonitoredItem_Index();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getRtSymbol
     * <em>Rt Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Rt Symbol</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredItem#getRtSymbol()
     * @see #getMonitoredItem()
     * @generated
     */
    EReference getMonitoredItem_RtSymbol();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getTextValue
     * <em>Text Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Text Value</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredItem#getTextValue()
     * @see #getMonitoredItem()
     * @generated
     */
    EAttribute getMonitoredItem_TextValue();

    /**
     * Returns the meta object for the container reference
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredItem#getMonitorModel
     * <em>Monitor Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Monitor
     *         Model</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredItem#getMonitorModel()
     * @see #getMonitoredItem()
     * @generated
     */
    EReference getMonitoredItem_MonitorModel();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet
     * <em>Monitored Value Set</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Monitored Value Set</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValueSet
     * @generated
     */
    EClass getMonitoredValueSet();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getTimestamp
     * <em>Timestamp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Timestamp</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getTimestamp()
     * @see #getMonitoredValueSet()
     * @generated
     */
    EAttribute getMonitoredValueSet_Timestamp();

    /**
     * Returns the meta object for the reference list
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getValues
     * <em>Values</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Values</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getValues()
     * @see #getMonitoredValueSet()
     * @generated
     */
    EReference getMonitoredValueSet_Values();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getHwType
     * <em>Hw Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Hw Type</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValueSet#getHwType()
     * @see #getMonitoredValueSet()
     * @generated
     */
    EAttribute getMonitoredValueSet_HwType();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue
     * <em>Monitored Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Monitored Value</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValue
     * @generated
     */
    EClass getMonitoredValue();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getName
     * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValue#getName()
     * @see #getMonitoredValue()
     * @generated
     */
    EAttribute getMonitoredValue_Name();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getValue
     * <em>Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValue#getValue()
     * @see #getMonitoredValue()
     * @generated
     */
    EAttribute getMonitoredValue_Value();

    /**
     * Returns the meta object for the reference
     * '{@link de.wisag.automation.micas.olt.monitor.MonitoredValue#getRtSymbol
     * <em>Rt Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Rt Symbol</em>'.
     * @see de.wisag.automation.micas.olt.monitor.MonitoredValue#getRtSymbol()
     * @see #getMonitoredValue()
     * @generated
     */
    EReference getMonitoredValue_RtSymbol();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    MonitorFactory getMonitorFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl
         * <em>Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitorModel()
         * @generated
         */
        EClass MONITOR_MODEL = eINSTANCE.getMonitorModel();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MONITOR_MODEL__ITEMS = eINSTANCE.getMonitorModel_Items();

        /**
         * The meta object literal for the '<em><b>Last Updated</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITOR_MODEL__LAST_UPDATED = eINSTANCE.getMonitorModel_LastUpdated();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITOR_MODEL__ACTIVE = eINSTANCE.getMonitorModel_Active();

        /**
         * The meta object literal for the '<em><b>Rt Module</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MONITOR_MODEL__RT_MODULE = eINSTANCE.getMonitorModel_RtModule();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl
         * <em>Monitored Item</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitoredItem()
         * @generated
         */
        EClass MONITORED_ITEM = eINSTANCE.getMonitoredItem();

        /**
         * The meta object literal for the '<em><b>Index</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITORED_ITEM__INDEX = eINSTANCE.getMonitoredItem_Index();

        /**
         * The meta object literal for the '<em><b>Rt Symbol</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MONITORED_ITEM__RT_SYMBOL = eINSTANCE.getMonitoredItem_RtSymbol();

        /**
         * The meta object literal for the '<em><b>Text Value</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITORED_ITEM__TEXT_VALUE = eINSTANCE.getMonitoredItem_TextValue();

        /**
         * The meta object literal for the '<em><b>Monitor Model</b></em>'
         * container reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference MONITORED_ITEM__MONITOR_MODEL = eINSTANCE.getMonitoredItem_MonitorModel();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl
         * <em>Monitored Value Set</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitoredValueSetImpl
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitoredValueSet()
         * @generated
         */
        EClass MONITORED_VALUE_SET = eINSTANCE.getMonitoredValueSet();

        /**
         * The meta object literal for the '<em><b>Timestamp</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITORED_VALUE_SET__TIMESTAMP = eINSTANCE.getMonitoredValueSet_Timestamp();

        /**
         * The meta object literal for the '<em><b>Values</b></em>' reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MONITORED_VALUE_SET__VALUES = eINSTANCE.getMonitoredValueSet_Values();

        /**
         * The meta object literal for the '<em><b>Hw Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITORED_VALUE_SET__HW_TYPE = eINSTANCE.getMonitoredValueSet_HwType();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl
         * <em>Monitored Value</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitoredValueImpl
         * @see de.wisag.automation.micas.olt.monitor.impl.MonitorPackageImpl#getMonitoredValue()
         * @generated
         */
        EClass MONITORED_VALUE = eINSTANCE.getMonitoredValue();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITORED_VALUE__NAME = eINSTANCE.getMonitoredValue_Name();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MONITORED_VALUE__VALUE = eINSTANCE.getMonitoredValue_Value();

        /**
         * The meta object literal for the '<em><b>Rt Symbol</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MONITORED_VALUE__RT_SYMBOL = eINSTANCE.getMonitoredValue_RtSymbol();

    }

} // MonitorPackage
