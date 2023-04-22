/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.h86.H86Package
 * @generated
 */
public interface H86Factory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    H86Factory eINSTANCE = de.wisag.automation.micas.h86.impl.H86FactoryImpl.init();

    /**
     * Returns a new object of class '<em>Address Record</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Address Record</em>'.
     * @generated
     */
    AddressRecord createAddressRecord();

    /**
     * Returns a new object of class '<em>Data Record</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Data Record</em>'.
     * @generated
     */
    DataRecord createDataRecord();

    /**
     * Returns a new object of class '<em>Segment Address Record</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Segment Address Record</em>'.
     * @generated
     */
    SegmentAddressRecord createSegmentAddressRecord();

    /**
     * Returns a new object of class '<em>Extended Segment Address Record</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Extended Segment Address Record</em>'.
     * @generated
     */
    ExtendedSegmentAddressRecord createExtendedSegmentAddressRecord();

    /**
     * Returns a new object of class '<em>EOF Record</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>EOF Record</em>'.
     * @generated
     */
    EOFRecord createEOFRecord();

    /**
     * Returns a new object of class '<em>Content</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Content</em>'.
     * @generated
     */
    H86Content createH86Content();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    H86Package getH86Package();

} // H86Factory
