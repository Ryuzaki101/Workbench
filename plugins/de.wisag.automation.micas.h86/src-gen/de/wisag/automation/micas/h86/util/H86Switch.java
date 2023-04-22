/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.wisag.automation.micas.h86.AddressRecord;
import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.EOFRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.h86.Record;
import de.wisag.automation.micas.h86.SegmentAddressRecord;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.h86.H86Package
 * @generated
 */
public class H86Switch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static H86Package modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public H86Switch() {
        if (modelPackage == null) {
            modelPackage = H86Package.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
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
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case H86Package.RECORD: {
            Record record = (Record) theEObject;
            T result = caseRecord(record);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case H86Package.ADDRESS_RECORD: {
            AddressRecord addressRecord = (AddressRecord) theEObject;
            T result = caseAddressRecord(addressRecord);
            if (result == null) {
                result = caseRecord(addressRecord);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case H86Package.DATA_RECORD: {
            DataRecord dataRecord = (DataRecord) theEObject;
            T result = caseDataRecord(dataRecord);
            if (result == null) {
                result = caseAddressRecord(dataRecord);
            }
            if (result == null) {
                result = caseRecord(dataRecord);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case H86Package.SEGMENT_ADDRESS_RECORD: {
            SegmentAddressRecord segmentAddressRecord = (SegmentAddressRecord) theEObject;
            T result = caseSegmentAddressRecord(segmentAddressRecord);
            if (result == null) {
                result = caseAddressRecord(segmentAddressRecord);
            }
            if (result == null) {
                result = caseRecord(segmentAddressRecord);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case H86Package.EXTENDED_SEGMENT_ADDRESS_RECORD: {
            ExtendedSegmentAddressRecord extendedSegmentAddressRecord = (ExtendedSegmentAddressRecord) theEObject;
            T result = caseExtendedSegmentAddressRecord(extendedSegmentAddressRecord);
            if (result == null) {
                result = caseAddressRecord(extendedSegmentAddressRecord);
            }
            if (result == null) {
                result = caseRecord(extendedSegmentAddressRecord);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case H86Package.EOF_RECORD: {
            EOFRecord eofRecord = (EOFRecord) theEObject;
            T result = caseEOFRecord(eofRecord);
            if (result == null) {
                result = caseRecord(eofRecord);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case H86Package.H86_CONTENT: {
            H86Content h86Content = (H86Content) theEObject;
            T result = caseH86Content(h86Content);
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
     * '<em>Record</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecord(Record object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Address Record</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Address Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAddressRecord(AddressRecord object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data
     * Record</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data
     *         Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataRecord(DataRecord object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Segment Address Record</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Segment Address Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSegmentAddressRecord(SegmentAddressRecord object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Extended Segment Address Record</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Extended Segment Address Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExtendedSegmentAddressRecord(ExtendedSegmentAddressRecord object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EOF
     * Record</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EOF
     *         Record</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEOFRecord(EOFRecord object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Content</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Content</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseH86Content(H86Content object) {
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
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // H86Switch
