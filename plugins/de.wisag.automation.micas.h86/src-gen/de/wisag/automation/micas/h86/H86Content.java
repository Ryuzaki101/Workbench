/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Content</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.H86Content#getRecords
 * <em>Records</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.h86.H86Package#getH86Content()
 * @model
 * @generated
 */
public interface H86Content extends EObject {
    /**
     * Returns the value of the '<em><b>Records</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.h86.Record}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Records</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Records</em>' containment reference list.
     * @see de.wisag.automation.micas.h86.H86Package#getH86Content_Records()
     * @model containment="true"
     * @generated
     */
    EList<Record> getRecords();

} // H86Content
