/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.h86.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Package;
import de.wisag.automation.micas.h86.Record;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Content</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.h86.impl.H86ContentImpl#getRecords
 * <em>Records</em>}</li>
 * </ul>
 *
 * @generated
 */
public class H86ContentImpl extends EObjectImpl implements H86Content {
    /**
     * The cached value of the '{@link #getRecords() <em>Records</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRecords()
     * @generated
     * @ordered
     */
    protected EList<Record> records;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected H86ContentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return H86Package.Literals.H86_CONTENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Record> getRecords() {
        if (records == null) {
            records = new EObjectContainmentEList<>(Record.class, this, H86Package.H86_CONTENT__RECORDS);
        }
        return records;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case H86Package.H86_CONTENT__RECORDS:
            return ((InternalEList<?>) getRecords()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case H86Package.H86_CONTENT__RECORDS:
            return getRecords();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case H86Package.H86_CONTENT__RECORDS:
            getRecords().clear();
            getRecords().addAll((Collection<? extends Record>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case H86Package.H86_CONTENT__RECORDS:
            getRecords().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case H86Package.H86_CONTENT__RECORDS:
            return records != null && !records.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // H86ContentImpl
