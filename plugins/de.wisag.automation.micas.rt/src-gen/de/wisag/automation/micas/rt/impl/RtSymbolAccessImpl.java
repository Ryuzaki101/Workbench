/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Symbol
 * Access</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl#getSymbol
 * <em>Symbol</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl#getModuleInvocation
 * <em>Module Invocation</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolAccessImpl#getType
 * <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtSymbolAccessImpl extends EObjectImpl implements RtSymbolAccess {
    /**
     * The cached value of the '{@link #getModuleInvocation() <em>Module
     * Invocation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getModuleInvocation()
     * @generated
     * @ordered
     */
    protected RtModuleInvocation moduleInvocation;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final RtSymbolAccessType TYPE_EDEFAULT = RtSymbolAccessType.READ;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getType()
     * @generated
     * @ordered
     */
    protected RtSymbolAccessType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtSymbolAccessImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_SYMBOL_ACCESS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtSymbol getSymbol() {
        if (eContainerFeatureID() != RtPackage.RT_SYMBOL_ACCESS__SYMBOL) {
            return null;
        }
        return (RtSymbol) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSymbol(RtSymbol newSymbol, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newSymbol, RtPackage.RT_SYMBOL_ACCESS__SYMBOL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSymbol(RtSymbol newSymbol) {
        if (newSymbol != eInternalContainer()
                || (eContainerFeatureID() != RtPackage.RT_SYMBOL_ACCESS__SYMBOL && newSymbol != null)) {
            if (EcoreUtil.isAncestor(this, newSymbol)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newSymbol != null) {
                msgs = ((InternalEObject) newSymbol).eInverseAdd(this, RtPackage.RT_SYMBOL__ACCESSORS, RtSymbol.class,
                        msgs);
            }
            msgs = basicSetSymbol(newSymbol, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL_ACCESS__SYMBOL, newSymbol,
                    newSymbol));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtModuleInvocation getModuleInvocation() {
        if (moduleInvocation != null && moduleInvocation.eIsProxy()) {
            InternalEObject oldModuleInvocation = (InternalEObject) moduleInvocation;
            moduleInvocation = (RtModuleInvocation) eResolveProxy(oldModuleInvocation);
            if (moduleInvocation != oldModuleInvocation) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION, oldModuleInvocation, moduleInvocation));
                }
            }
        }
        return moduleInvocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtModuleInvocation basicGetModuleInvocation() {
        return moduleInvocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetModuleInvocation(RtModuleInvocation newModuleInvocation, NotificationChain msgs) {
        RtModuleInvocation oldModuleInvocation = moduleInvocation;
        moduleInvocation = newModuleInvocation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION, oldModuleInvocation, newModuleInvocation);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setModuleInvocation(RtModuleInvocation newModuleInvocation) {
        if (newModuleInvocation != moduleInvocation) {
            NotificationChain msgs = null;
            if (moduleInvocation != null) {
                msgs = ((InternalEObject) moduleInvocation).eInverseRemove(this,
                        RtPackage.RT_MODULE_INVOCATION__ARGUMENTS, RtModuleInvocation.class, msgs);
            }
            if (newModuleInvocation != null) {
                msgs = ((InternalEObject) newModuleInvocation).eInverseAdd(this,
                        RtPackage.RT_MODULE_INVOCATION__ARGUMENTS, RtModuleInvocation.class, msgs);
            }
            msgs = basicSetModuleInvocation(newModuleInvocation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION,
                    newModuleInvocation, newModuleInvocation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtSymbolAccessType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setType(RtSymbolAccessType newType) {
        RtSymbolAccessType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL_ACCESS__TYPE, oldType, type));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetSymbol((RtSymbol) otherEnd, msgs);
        case RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION:
            if (moduleInvocation != null) {
                msgs = ((InternalEObject) moduleInvocation).eInverseRemove(this,
                        RtPackage.RT_MODULE_INVOCATION__ARGUMENTS, RtModuleInvocation.class, msgs);
            }
            return basicSetModuleInvocation((RtModuleInvocation) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            return basicSetSymbol(null, msgs);
        case RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION:
            return basicSetModuleInvocation(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            return eInternalContainer().eInverseRemove(this, RtPackage.RT_SYMBOL__ACCESSORS, RtSymbol.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            return getSymbol();
        case RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION:
            if (resolve) {
                return getModuleInvocation();
            }
            return basicGetModuleInvocation();
        case RtPackage.RT_SYMBOL_ACCESS__TYPE:
            return getType();
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
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            setSymbol((RtSymbol) newValue);
            return;
        case RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION:
            setModuleInvocation((RtModuleInvocation) newValue);
            return;
        case RtPackage.RT_SYMBOL_ACCESS__TYPE:
            setType((RtSymbolAccessType) newValue);
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
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            setSymbol((RtSymbol) null);
            return;
        case RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION:
            setModuleInvocation((RtModuleInvocation) null);
            return;
        case RtPackage.RT_SYMBOL_ACCESS__TYPE:
            setType(TYPE_EDEFAULT);
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
        case RtPackage.RT_SYMBOL_ACCESS__SYMBOL:
            return getSymbol() != null;
        case RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION:
            return moduleInvocation != null;
        case RtPackage.RT_SYMBOL_ACCESS__TYPE:
            return type != TYPE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

} // RtSymbolAccessImpl
