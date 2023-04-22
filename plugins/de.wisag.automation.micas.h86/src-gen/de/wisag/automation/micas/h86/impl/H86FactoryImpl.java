/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.wisag.automation.micas.h86.AddressRecord;
import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.EOFRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Factory;
import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.h86.RecordType;
import de.wisag.automation.micas.h86.SegmentAddressRecord;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class H86FactoryImpl extends EFactoryImpl implements H86Factory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static H86Factory init() {
        try {
            H86Factory theH86Factory = (H86Factory) EPackage.Registry.INSTANCE.getEFactory(H86Package.eNS_URI);
            if (theH86Factory != null) {
                return theH86Factory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new H86FactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public H86FactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case H86Package.ADDRESS_RECORD:
            return createAddressRecord();
        case H86Package.DATA_RECORD:
            return createDataRecord();
        case H86Package.SEGMENT_ADDRESS_RECORD:
            return createSegmentAddressRecord();
        case H86Package.EXTENDED_SEGMENT_ADDRESS_RECORD:
            return createExtendedSegmentAddressRecord();
        case H86Package.EOF_RECORD:
            return createEOFRecord();
        case H86Package.H86_CONTENT:
            return createH86Content();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case H86Package.RECORD_TYPE:
            return createRecordTypeFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case H86Package.RECORD_TYPE:
            return convertRecordTypeToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AddressRecord createAddressRecord() {
        AddressRecordImpl addressRecord = new AddressRecordImpl();
        return addressRecord;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataRecord createDataRecord() {
        DataRecordImpl dataRecord = new DataRecordImpl();
        return dataRecord;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SegmentAddressRecord createSegmentAddressRecord() {
        SegmentAddressRecordImpl segmentAddressRecord = new SegmentAddressRecordImpl();
        return segmentAddressRecord;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ExtendedSegmentAddressRecord createExtendedSegmentAddressRecord() {
        ExtendedSegmentAddressRecordImpl extendedSegmentAddressRecord = new ExtendedSegmentAddressRecordImpl();
        return extendedSegmentAddressRecord;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOFRecord createEOFRecord() {
        EOFRecordImpl eofRecord = new EOFRecordImpl();
        return eofRecord;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public H86Content createH86Content() {
        H86ContentImpl h86Content = new H86ContentImpl();
        return h86Content;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RecordType createRecordTypeFromString(EDataType eDataType, String initialValue) {
        RecordType result = RecordType.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException(
                    "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public String convertRecordTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public H86Package getH86Package() {
        return (H86Package) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static H86Package getPackage() {
        return H86Package.eINSTANCE;
    }

} // H86FactoryImpl
