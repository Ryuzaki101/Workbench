/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.wisag.automation.micas.olt.monitor.MonitorFactory;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;
import de.wisag.automation.micas.rt.RtPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class MonitorPackageImpl extends EPackageImpl implements MonitorPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitorModelEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitoredItemEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitoredValueSetEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitoredValueEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.wisag.automation.micas.olt.monitor.MonitorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MonitorPackageImpl() {
        super(eNS_URI, MonitorFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link MonitorPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MonitorPackage init() {
        if (isInited) {
            return (MonitorPackage) EPackage.Registry.INSTANCE.getEPackage(MonitorPackage.eNS_URI);
        }

        // Obtain or create and register package
        MonitorPackageImpl theMonitorPackage = (MonitorPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof MonitorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new MonitorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        RtPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theMonitorPackage.createPackageContents();

        // Initialize created meta-data
        theMonitorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMonitorPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MonitorPackage.eNS_URI, theMonitorPackage);
        return theMonitorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitorModel() {
        return monitorModelEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitorModel_Items() {
        return (EReference) monitorModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitorModel_LastUpdated() {
        return (EAttribute) monitorModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitorModel_Active() {
        return (EAttribute) monitorModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitorModel_RtModule() {
        return (EReference) monitorModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitoredItem() {
        return monitoredItemEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitoredItem_Index() {
        return (EAttribute) monitoredItemEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitoredItem_RtSymbol() {
        return (EReference) monitoredItemEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitoredItem_TextValue() {
        return (EAttribute) monitoredItemEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitoredItem_MonitorModel() {
        return (EReference) monitoredItemEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitoredValueSet() {
        return monitoredValueSetEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitoredValueSet_Timestamp() {
        return (EAttribute) monitoredValueSetEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitoredValueSet_Values() {
        return (EReference) monitoredValueSetEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitoredValueSet_HwType() {
        return (EAttribute) monitoredValueSetEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitoredValue() {
        return monitoredValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitoredValue_Name() {
        return (EAttribute) monitoredValueEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitoredValue_Value() {
        return (EAttribute) monitoredValueEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitoredValue_RtSymbol() {
        return (EReference) monitoredValueEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitorFactory getMonitorFactory() {
        return (MonitorFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        monitorModelEClass = createEClass(MONITOR_MODEL);
        createEReference(monitorModelEClass, MONITOR_MODEL__ITEMS);
        createEAttribute(monitorModelEClass, MONITOR_MODEL__LAST_UPDATED);
        createEAttribute(monitorModelEClass, MONITOR_MODEL__ACTIVE);
        createEReference(monitorModelEClass, MONITOR_MODEL__RT_MODULE);

        monitoredItemEClass = createEClass(MONITORED_ITEM);
        createEAttribute(monitoredItemEClass, MONITORED_ITEM__INDEX);
        createEReference(monitoredItemEClass, MONITORED_ITEM__RT_SYMBOL);
        createEAttribute(monitoredItemEClass, MONITORED_ITEM__TEXT_VALUE);
        createEReference(monitoredItemEClass, MONITORED_ITEM__MONITOR_MODEL);

        monitoredValueSetEClass = createEClass(MONITORED_VALUE_SET);
        createEAttribute(monitoredValueSetEClass, MONITORED_VALUE_SET__TIMESTAMP);
        createEReference(monitoredValueSetEClass, MONITORED_VALUE_SET__VALUES);
        createEAttribute(monitoredValueSetEClass, MONITORED_VALUE_SET__HW_TYPE);

        monitoredValueEClass = createEClass(MONITORED_VALUE);
        createEAttribute(monitoredValueEClass, MONITORED_VALUE__NAME);
        createEAttribute(monitoredValueEClass, MONITORED_VALUE__VALUE);
        createEReference(monitoredValueEClass, MONITORED_VALUE__RT_SYMBOL);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        RtPackage theRtPackage = (RtPackage) EPackage.Registry.INSTANCE.getEPackage(RtPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(monitorModelEClass, MonitorModel.class, "MonitorModel", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMonitorModel_Items(), this.getMonitoredItem(), this.getMonitoredItem_MonitorModel(), "items",
                null, 0, -1, MonitorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMonitorModel_LastUpdated(), ecorePackage.getELong(), "lastUpdated", null, 0, 1,
                MonitorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMonitorModel_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, MonitorModel.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMonitorModel_RtModule(), theRtPackage.getRtModule(), null, "rtModule", null, 0, 1,
                MonitorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(monitoredItemEClass, MonitoredItem.class, "MonitoredItem", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMonitoredItem_Index(), ecorePackage.getEInt(), "index", null, 0, 1, MonitoredItem.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMonitoredItem_RtSymbol(), theRtPackage.getRtSymbol(), null, "rtSymbol", null, 0, 1,
                MonitoredItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMonitoredItem_TextValue(), ecorePackage.getEString(), "textValue", "\"\"", 0, 1,
                MonitoredItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getMonitoredItem_MonitorModel(), this.getMonitorModel(), this.getMonitorModel_Items(),
                "monitorModel", null, 0, 1, MonitoredItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(monitoredValueSetEClass, MonitoredValueSet.class, "MonitoredValueSet", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMonitoredValueSet_Timestamp(), ecorePackage.getELong(), "timestamp", null, 0, 1,
                MonitoredValueSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getMonitoredValueSet_Values(), this.getMonitoredValue(), null, "values", null, 0, -1,
                MonitoredValueSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMonitoredValueSet_HwType(), theRtPackage.getRtHwType(), "hwType", null, 0, 1,
                MonitoredValueSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(monitoredValueEClass, MonitoredValue.class, "MonitoredValue", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMonitoredValue_Name(), ecorePackage.getEString(), "name", null, 0, 1, MonitoredValue.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMonitoredValue_Value(), ecorePackage.getEString(), "value", "\"\"", 0, 1,
                MonitoredValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getMonitoredValue_RtSymbol(), theRtPackage.getRtSymbol(), null, "rtSymbol", null, 0, 1,
                MonitoredValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // MonitorPackageImpl
