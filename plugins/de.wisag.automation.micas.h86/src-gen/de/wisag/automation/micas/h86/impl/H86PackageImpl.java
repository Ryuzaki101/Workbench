/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.wisag.automation.micas.h86.AddressRecord;
import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.EOFRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Factory;
import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.h86.Record;
import de.wisag.automation.micas.h86.RecordType;
import de.wisag.automation.micas.h86.SegmentAddressRecord;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class H86PackageImpl extends EPackageImpl implements H86Package {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass recordEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass addressRecordEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataRecordEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass segmentAddressRecordEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass extendedSegmentAddressRecordEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass eofRecordEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass h86ContentEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum recordTypeEEnum = null;

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
     * @see de.wisag.automation.micas.h86.H86Package#eNS_URI
     * @see #init()
     * @generated
     */
    private H86PackageImpl() {
        super(eNS_URI, H86Factory.eINSTANCE);
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
     * This method is used to initialize {@link H86Package#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they
     * should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static H86Package init() {
        if (isInited) {
            return (H86Package) EPackage.Registry.INSTANCE.getEPackage(H86Package.eNS_URI);
        }

        // Obtain or create and register package
        H86PackageImpl theH86Package = (H86PackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof H86PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new H86PackageImpl());

        isInited = true;

        // Create package meta-data objects
        theH86Package.createPackageContents();

        // Initialize created meta-data
        theH86Package.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theH86Package.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(H86Package.eNS_URI, theH86Package);
        return theH86Package;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRecord() {
        return recordEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRecord_Type() {
        return (EAttribute) recordEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRecord_NumberOfBytes() {
        return (EAttribute) recordEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRecord_Checksum() {
        return (EAttribute) recordEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAddressRecord() {
        return addressRecordEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAddressRecord_Address() {
        return (EAttribute) addressRecordEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataRecord() {
        return dataRecordEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getDataRecord_Data() {
        return (EAttribute) dataRecordEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSegmentAddressRecord() {
        return segmentAddressRecordEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getExtendedSegmentAddressRecord() {
        return extendedSegmentAddressRecordEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getEOFRecord() {
        return eofRecordEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getH86Content() {
        return h86ContentEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getH86Content_Records() {
        return (EReference) h86ContentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getRecordType() {
        return recordTypeEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public H86Factory getH86Factory() {
        return (H86Factory) getEFactoryInstance();
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
        recordEClass = createEClass(RECORD);
        createEAttribute(recordEClass, RECORD__TYPE);
        createEAttribute(recordEClass, RECORD__NUMBER_OF_BYTES);
        createEAttribute(recordEClass, RECORD__CHECKSUM);

        addressRecordEClass = createEClass(ADDRESS_RECORD);
        createEAttribute(addressRecordEClass, ADDRESS_RECORD__ADDRESS);

        dataRecordEClass = createEClass(DATA_RECORD);
        createEAttribute(dataRecordEClass, DATA_RECORD__DATA);

        segmentAddressRecordEClass = createEClass(SEGMENT_ADDRESS_RECORD);

        extendedSegmentAddressRecordEClass = createEClass(EXTENDED_SEGMENT_ADDRESS_RECORD);

        eofRecordEClass = createEClass(EOF_RECORD);

        h86ContentEClass = createEClass(H86_CONTENT);
        createEReference(h86ContentEClass, H86_CONTENT__RECORDS);

        // Create enums
        recordTypeEEnum = createEEnum(RECORD_TYPE);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        addressRecordEClass.getESuperTypes().add(this.getRecord());
        dataRecordEClass.getESuperTypes().add(this.getAddressRecord());
        segmentAddressRecordEClass.getESuperTypes().add(this.getAddressRecord());
        extendedSegmentAddressRecordEClass.getESuperTypes().add(this.getAddressRecord());
        eofRecordEClass.getESuperTypes().add(this.getRecord());

        // Initialize classes and features; add operations and parameters
        initEClass(recordEClass, Record.class, "Record", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRecord_Type(), this.getRecordType(), "type", null, 0, 1, Record.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRecord_NumberOfBytes(), ecorePackage.getEInt(), "numberOfBytes", null, 0, 1, Record.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRecord_Checksum(), ecorePackage.getEInt(), "checksum", null, 0, 1, Record.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(addressRecordEClass, AddressRecord.class, "AddressRecord", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAddressRecord_Address(), ecorePackage.getEInt(), "address", null, 0, 1, AddressRecord.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataRecordEClass, DataRecord.class, "DataRecord", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDataRecord_Data(), ecorePackage.getEByteArray(), "data", null, 0, 1, DataRecord.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(segmentAddressRecordEClass, SegmentAddressRecord.class, "SegmentAddressRecord", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(extendedSegmentAddressRecordEClass, ExtendedSegmentAddressRecord.class,
                "ExtendedSegmentAddressRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(eofRecordEClass, EOFRecord.class, "EOFRecord", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        initEClass(h86ContentEClass, H86Content.class, "H86Content", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getH86Content_Records(), this.getRecord(), null, "records", null, 0, -1, H86Content.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(recordTypeEEnum, RecordType.class, "RecordType");
        addEEnumLiteral(recordTypeEEnum, RecordType.DATA);
        addEEnumLiteral(recordTypeEEnum, RecordType.EOF);
        addEEnumLiteral(recordTypeEEnum, RecordType.EXTENDED_SEGMENT_ADDRESS);
        addEEnumLiteral(recordTypeEEnum, RecordType.START_SEGMENT_ADDRESS);
        addEEnumLiteral(recordTypeEEnum, RecordType.EXTENDED_LINEAR_ADDRESS);
        addEEnumLiteral(recordTypeEEnum, RecordType.START_LINEAR_ADDRESS);

        // Create resource
        createResource(eNS_URI);
    }

} // H86PackageImpl
