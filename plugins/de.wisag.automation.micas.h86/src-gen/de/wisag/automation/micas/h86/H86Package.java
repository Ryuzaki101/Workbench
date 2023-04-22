/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.wisag.automation.micas.h86.H86Factory
 * @model kind="package"
 * @generated
 */
public interface H86Package extends EPackage {
    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNAME = "h86";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String eNS_URI = "http://www.wisag.de/automation/schema/h86";

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
    H86Package eINSTANCE = de.wisag.automation.micas.h86.impl.H86PackageImpl.init();

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.RecordImpl <em>Record</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.RecordImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getRecord()
     * @generated
     */
    int RECORD = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RECORD__TYPE = 0;

    /**
     * The feature id for the '<em><b>Number Of Bytes</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RECORD__NUMBER_OF_BYTES = 1;

    /**
     * The feature id for the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RECORD__CHECKSUM = 2;

    /**
     * The number of structural features of the '<em>Record</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int RECORD_FEATURE_COUNT = 3;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.AddressRecordImpl <em>Address
     * Record</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.AddressRecordImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getAddressRecord()
     * @generated
     */
    int ADDRESS_RECORD = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADDRESS_RECORD__TYPE = RECORD__TYPE;

    /**
     * The feature id for the '<em><b>Number Of Bytes</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADDRESS_RECORD__NUMBER_OF_BYTES = RECORD__NUMBER_OF_BYTES;

    /**
     * The feature id for the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADDRESS_RECORD__CHECKSUM = RECORD__CHECKSUM;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADDRESS_RECORD__ADDRESS = RECORD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Address Record</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int ADDRESS_RECORD_FEATURE_COUNT = RECORD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.DataRecordImpl <em>Data
     * Record</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.DataRecordImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getDataRecord()
     * @generated
     */
    int DATA_RECORD = 2;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_RECORD__TYPE = ADDRESS_RECORD__TYPE;

    /**
     * The feature id for the '<em><b>Number Of Bytes</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_RECORD__NUMBER_OF_BYTES = ADDRESS_RECORD__NUMBER_OF_BYTES;

    /**
     * The feature id for the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_RECORD__CHECKSUM = ADDRESS_RECORD__CHECKSUM;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_RECORD__ADDRESS = ADDRESS_RECORD__ADDRESS;

    /**
     * The feature id for the '<em><b>Data</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_RECORD__DATA = ADDRESS_RECORD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Data Record</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int DATA_RECORD_FEATURE_COUNT = ADDRESS_RECORD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.SegmentAddressRecordImpl
     * <em>Segment Address Record</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.SegmentAddressRecordImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getSegmentAddressRecord()
     * @generated
     */
    int SEGMENT_ADDRESS_RECORD = 3;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SEGMENT_ADDRESS_RECORD__TYPE = ADDRESS_RECORD__TYPE;

    /**
     * The feature id for the '<em><b>Number Of Bytes</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SEGMENT_ADDRESS_RECORD__NUMBER_OF_BYTES = ADDRESS_RECORD__NUMBER_OF_BYTES;

    /**
     * The feature id for the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SEGMENT_ADDRESS_RECORD__CHECKSUM = ADDRESS_RECORD__CHECKSUM;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SEGMENT_ADDRESS_RECORD__ADDRESS = ADDRESS_RECORD__ADDRESS;

    /**
     * The number of structural features of the '<em>Segment Address
     * Record</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int SEGMENT_ADDRESS_RECORD_FEATURE_COUNT = ADDRESS_RECORD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.ExtendedSegmentAddressRecordImpl
     * <em>Extended Segment Address Record</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.ExtendedSegmentAddressRecordImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getExtendedSegmentAddressRecord()
     * @generated
     */
    int EXTENDED_SEGMENT_ADDRESS_RECORD = 4;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTENDED_SEGMENT_ADDRESS_RECORD__TYPE = ADDRESS_RECORD__TYPE;

    /**
     * The feature id for the '<em><b>Number Of Bytes</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTENDED_SEGMENT_ADDRESS_RECORD__NUMBER_OF_BYTES = ADDRESS_RECORD__NUMBER_OF_BYTES;

    /**
     * The feature id for the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTENDED_SEGMENT_ADDRESS_RECORD__CHECKSUM = ADDRESS_RECORD__CHECKSUM;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTENDED_SEGMENT_ADDRESS_RECORD__ADDRESS = ADDRESS_RECORD__ADDRESS;

    /**
     * The number of structural features of the '<em>Extended Segment Address
     * Record</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EXTENDED_SEGMENT_ADDRESS_RECORD_FEATURE_COUNT = ADDRESS_RECORD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.EOFRecordImpl <em>EOF
     * Record</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.EOFRecordImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getEOFRecord()
     * @generated
     */
    int EOF_RECORD = 5;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EOF_RECORD__TYPE = RECORD__TYPE;

    /**
     * The feature id for the '<em><b>Number Of Bytes</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EOF_RECORD__NUMBER_OF_BYTES = RECORD__NUMBER_OF_BYTES;

    /**
     * The feature id for the '<em><b>Checksum</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EOF_RECORD__CHECKSUM = RECORD__CHECKSUM;

    /**
     * The number of structural features of the '<em>EOF Record</em>' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int EOF_RECORD_FEATURE_COUNT = RECORD_FEATURE_COUNT + 0;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.impl.H86ContentImpl
     * <em>Content</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.impl.H86ContentImpl
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getH86Content()
     * @generated
     */
    int H86_CONTENT = 6;

    /**
     * The feature id for the '<em><b>Records</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int H86_CONTENT__RECORDS = 0;

    /**
     * The number of structural features of the '<em>Content</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     */
    int H86_CONTENT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the
     * '{@link de.wisag.automation.micas.h86.RecordType <em>Record Type</em>}'
     * enum. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see de.wisag.automation.micas.h86.RecordType
     * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getRecordType()
     * @generated
     */
    int RECORD_TYPE = 7;

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.Record <em>Record</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Record</em>'.
     * @see de.wisag.automation.micas.h86.Record
     * @generated
     */
    EClass getRecord();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.h86.Record#getType <em>Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see de.wisag.automation.micas.h86.Record#getType()
     * @see #getRecord()
     * @generated
     */
    EAttribute getRecord_Type();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.h86.Record#getNumberOfBytes <em>Number
     * Of Bytes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Number Of Bytes</em>'.
     * @see de.wisag.automation.micas.h86.Record#getNumberOfBytes()
     * @see #getRecord()
     * @generated
     */
    EAttribute getRecord_NumberOfBytes();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.h86.Record#getChecksum
     * <em>Checksum</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Checksum</em>'.
     * @see de.wisag.automation.micas.h86.Record#getChecksum()
     * @see #getRecord()
     * @generated
     */
    EAttribute getRecord_Checksum();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.AddressRecord <em>Address
     * Record</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Address Record</em>'.
     * @see de.wisag.automation.micas.h86.AddressRecord
     * @generated
     */
    EClass getAddressRecord();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.h86.AddressRecord#getAddress
     * <em>Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Address</em>'.
     * @see de.wisag.automation.micas.h86.AddressRecord#getAddress()
     * @see #getAddressRecord()
     * @generated
     */
    EAttribute getAddressRecord_Address();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.DataRecord <em>Data Record</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Data Record</em>'.
     * @see de.wisag.automation.micas.h86.DataRecord
     * @generated
     */
    EClass getDataRecord();

    /**
     * Returns the meta object for the attribute
     * '{@link de.wisag.automation.micas.h86.DataRecord#getData <em>Data</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the attribute '<em>Data</em>'.
     * @see de.wisag.automation.micas.h86.DataRecord#getData()
     * @see #getDataRecord()
     * @generated
     */
    EAttribute getDataRecord_Data();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.SegmentAddressRecord <em>Segment
     * Address Record</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Segment Address Record</em>'.
     * @see de.wisag.automation.micas.h86.SegmentAddressRecord
     * @generated
     */
    EClass getSegmentAddressRecord();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord
     * <em>Extended Segment Address Record</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the meta object for class '<em>Extended Segment Address
     *         Record</em>'.
     * @see de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord
     * @generated
     */
    EClass getExtendedSegmentAddressRecord();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.EOFRecord <em>EOF Record</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>EOF Record</em>'.
     * @see de.wisag.automation.micas.h86.EOFRecord
     * @generated
     */
    EClass getEOFRecord();

    /**
     * Returns the meta object for class
     * '{@link de.wisag.automation.micas.h86.H86Content <em>Content</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for class '<em>Content</em>'.
     * @see de.wisag.automation.micas.h86.H86Content
     * @generated
     */
    EClass getH86Content();

    /**
     * Returns the meta object for the containment reference list
     * '{@link de.wisag.automation.micas.h86.H86Content#getRecords
     * <em>Records</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for the containment reference list
     *         '<em>Records</em>'.
     * @see de.wisag.automation.micas.h86.H86Content#getRecords()
     * @see #getH86Content()
     * @generated
     */
    EReference getH86Content_Records();

    /**
     * Returns the meta object for enum
     * '{@link de.wisag.automation.micas.h86.RecordType <em>Record Type</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the meta object for enum '<em>Record Type</em>'.
     * @see de.wisag.automation.micas.h86.RecordType
     * @generated
     */
    EEnum getRecordType();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the factory that creates the instances of the model.
     * @generated
     */
    H86Factory getH86Factory();

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
         * '{@link de.wisag.automation.micas.h86.impl.RecordImpl
         * <em>Record</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.h86.impl.RecordImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getRecord()
         * @generated
         */
        EClass RECORD = eINSTANCE.getRecord();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RECORD__TYPE = eINSTANCE.getRecord_Type();

        /**
         * The meta object literal for the '<em><b>Number Of Bytes</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RECORD__NUMBER_OF_BYTES = eINSTANCE.getRecord_NumberOfBytes();

        /**
         * The meta object literal for the '<em><b>Checksum</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute RECORD__CHECKSUM = eINSTANCE.getRecord_Checksum();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.impl.AddressRecordImpl
         * <em>Address Record</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.h86.impl.AddressRecordImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getAddressRecord()
         * @generated
         */
        EClass ADDRESS_RECORD = eINSTANCE.getAddressRecord();

        /**
         * The meta object literal for the '<em><b>Address</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute ADDRESS_RECORD__ADDRESS = eINSTANCE.getAddressRecord_Address();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.impl.DataRecordImpl <em>Data
         * Record</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.h86.impl.DataRecordImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getDataRecord()
         * @generated
         */
        EClass DATA_RECORD = eINSTANCE.getDataRecord();

        /**
         * The meta object literal for the '<em><b>Data</b></em>' attribute
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EAttribute DATA_RECORD__DATA = eINSTANCE.getDataRecord_Data();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.impl.SegmentAddressRecordImpl
         * <em>Segment Address Record</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         *
         * @see de.wisag.automation.micas.h86.impl.SegmentAddressRecordImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getSegmentAddressRecord()
         * @generated
         */
        EClass SEGMENT_ADDRESS_RECORD = eINSTANCE.getSegmentAddressRecord();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.impl.ExtendedSegmentAddressRecordImpl
         * <em>Extended Segment Address Record</em>}' class. <!-- begin-user-doc
         * --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.h86.impl.ExtendedSegmentAddressRecordImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getExtendedSegmentAddressRecord()
         * @generated
         */
        EClass EXTENDED_SEGMENT_ADDRESS_RECORD = eINSTANCE.getExtendedSegmentAddressRecord();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.impl.EOFRecordImpl <em>EOF
         * Record</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.h86.impl.EOFRecordImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getEOFRecord()
         * @generated
         */
        EClass EOF_RECORD = eINSTANCE.getEOFRecord();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.impl.H86ContentImpl
         * <em>Content</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
         * -->
         *
         * @see de.wisag.automation.micas.h86.impl.H86ContentImpl
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getH86Content()
         * @generated
         */
        EClass H86_CONTENT = eINSTANCE.getH86Content();

        /**
         * The meta object literal for the '<em><b>Records</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @generated
         */
        EReference H86_CONTENT__RECORDS = eINSTANCE.getH86Content_Records();

        /**
         * The meta object literal for the
         * '{@link de.wisag.automation.micas.h86.RecordType <em>Record
         * Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
         *
         * @see de.wisag.automation.micas.h86.RecordType
         * @see de.wisag.automation.micas.h86.impl.H86PackageImpl#getRecordType()
         * @generated
         */
        EEnum RECORD_TYPE = eINSTANCE.getRecordType();

    }

} // H86Package
