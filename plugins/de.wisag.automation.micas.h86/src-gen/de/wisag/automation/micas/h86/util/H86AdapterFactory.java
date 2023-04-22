/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.h86.AddressRecord;
import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.EOFRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.h86.Record;
import de.wisag.automation.micas.h86.SegmentAddressRecord;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 *
 * @see de.wisag.automation.micas.h86.H86Package
 * @generated
 */
public class H86AdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static H86Package modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public H86AdapterFactory() {
        if (modelPackage == null) {
            modelPackage = H86Package.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected H86Switch<Adapter> modelSwitch = new H86Switch<Adapter>() {
        @Override
        public Adapter caseRecord(Record object) {
            return createRecordAdapter();
        }

        @Override
        public Adapter caseAddressRecord(AddressRecord object) {
            return createAddressRecordAdapter();
        }

        @Override
        public Adapter caseDataRecord(DataRecord object) {
            return createDataRecordAdapter();
        }

        @Override
        public Adapter caseSegmentAddressRecord(SegmentAddressRecord object) {
            return createSegmentAddressRecordAdapter();
        }

        @Override
        public Adapter caseExtendedSegmentAddressRecord(ExtendedSegmentAddressRecord object) {
            return createExtendedSegmentAddressRecordAdapter();
        }

        @Override
        public Adapter caseEOFRecord(EOFRecord object) {
            return createEOFRecordAdapter();
        }

        @Override
        public Adapter caseH86Content(H86Content object) {
            return createH86ContentAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.Record <em>Record</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.Record
     * @generated
     */
    public Adapter createRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.AddressRecord <em>Address
     * Record</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.AddressRecord
     * @generated
     */
    public Adapter createAddressRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.DataRecord <em>Data Record</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.DataRecord
     * @generated
     */
    public Adapter createDataRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.SegmentAddressRecord <em>Segment
     * Address Record</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.SegmentAddressRecord
     * @generated
     */
    public Adapter createSegmentAddressRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord
     * <em>Extended Segment Address Record</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord
     * @generated
     */
    public Adapter createExtendedSegmentAddressRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.EOFRecord <em>EOF Record</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.EOFRecord
     * @generated
     */
    public Adapter createEOFRecordAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.h86.H86Content <em>Content</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.h86.H86Content
     * @generated
     */
    public Adapter createH86ContentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // H86AdapterFactory
