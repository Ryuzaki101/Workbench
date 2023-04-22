/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.impl.SignalSpecificationImpl;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ModulePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Attribute Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.impl.AttributeSpecificationImpl#getAttribute
 * <em>Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeSpecificationImpl extends SignalSpecificationImpl implements AttributeSpecification {
    /**
     * The cached value of the '{@link #getAttribute() <em>Attribute</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected Attribute attribute;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AttributeSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModulePackage.Literals.ATTRIBUTE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Attribute getAttribute() {
        if (attribute != null && attribute.eIsProxy()) {
            InternalEObject oldAttribute = (InternalEObject) attribute;
            attribute = (Attribute) eResolveProxy(oldAttribute);
            if (attribute != oldAttribute) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ModulePackage.ATTRIBUTE_SPECIFICATION__ATTRIBUTE, oldAttribute, attribute));
                }
            }
        }
        return attribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Attribute basicGetAttribute() {
        return attribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAttribute(Attribute newAttribute) {
        Attribute oldAttribute = attribute;
        attribute = newAttribute;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.ATTRIBUTE_SPECIFICATION__ATTRIBUTE,
                    oldAttribute, attribute));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ModulePackage.ATTRIBUTE_SPECIFICATION__ATTRIBUTE:
            if (resolve) {
                return getAttribute();
            }
            return basicGetAttribute();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ModulePackage.ATTRIBUTE_SPECIFICATION__ATTRIBUTE:
            setAttribute((Attribute) newValue);
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
        case ModulePackage.ATTRIBUTE_SPECIFICATION__ATTRIBUTE:
            setAttribute((Attribute) null);
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
        case ModulePackage.ATTRIBUTE_SPECIFICATION__ATTRIBUTE:
            return attribute != null;
        }
        return super.eIsSet(featureID);
    }

} // AttributeSpecificationImpl
