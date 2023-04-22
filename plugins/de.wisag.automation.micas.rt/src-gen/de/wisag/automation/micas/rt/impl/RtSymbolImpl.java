/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Symbol</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl#getAddress
 * <em>Address</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl#getAccessors
 * <em>Accessors</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtSymbolImpl#getIndex
 * <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtSymbolImpl extends EObjectImpl implements RtSymbol {
    /**
     * The default value of the '{@link #getAddress() <em>Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAddress()
     * @generated
     * @ordered
     */
    protected static final int ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getAddress() <em>Address</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAddress()
     * @generated
     * @ordered
     */
    protected int address = ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getAccessors() <em>Accessors</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAccessors()
     * @generated
     * @ordered
     */
    protected EList<RtSymbolAccess> accessors;

    /**
     * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected static final int INDEX_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected int index = INDEX_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtSymbolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_SYMBOL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getAddress() {
        return address;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAddress(int newAddress) {
        int oldAddress = address;
        address = newAddress;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL__ADDRESS, oldAddress, address));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL__NAME, oldName, name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtModule getModule() {
        if (eContainerFeatureID() != RtPackage.RT_SYMBOL__MODULE) {
            return null;
        }
        return (RtModule) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetModule(RtModule newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newModule, RtPackage.RT_SYMBOL__MODULE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setModule(RtModule newModule) {
        if (newModule != eInternalContainer()
                || (eContainerFeatureID() != RtPackage.RT_SYMBOL__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newModule != null) {
                msgs = ((InternalEObject) newModule).eInverseAdd(this, RtPackage.RT_MODULE__SYMBOLS, RtModule.class,
                        msgs);
            }
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL__MODULE, newModule, newModule));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtSymbolAccess> getAccessors() {
        if (accessors == null) {
            accessors = new EObjectContainmentWithInverseEList<>(RtSymbolAccess.class, this,
                    RtPackage.RT_SYMBOL__ACCESSORS, RtPackage.RT_SYMBOL_ACCESS__SYMBOL);
        }
        return accessors;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getIndex() {
        return index;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setIndex(int newIndex) {
        int oldIndex = index;
        index = newIndex;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_SYMBOL__INDEX, oldIndex, index));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDisplayName() {
        return RtModuleUtils.getDisplayName(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RtPackage.RT_SYMBOL__MODULE:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetModule((RtModule) otherEnd, msgs);
        case RtPackage.RT_SYMBOL__ACCESSORS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getAccessors()).basicAdd(otherEnd, msgs);
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
        case RtPackage.RT_SYMBOL__MODULE:
            return basicSetModule(null, msgs);
        case RtPackage.RT_SYMBOL__ACCESSORS:
            return ((InternalEList<?>) getAccessors()).basicRemove(otherEnd, msgs);
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
        case RtPackage.RT_SYMBOL__MODULE:
            return eInternalContainer().eInverseRemove(this, RtPackage.RT_MODULE__SYMBOLS, RtModule.class, msgs);
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
        case RtPackage.RT_SYMBOL__ADDRESS:
            return getAddress();
        case RtPackage.RT_SYMBOL__NAME:
            return getName();
        case RtPackage.RT_SYMBOL__MODULE:
            return getModule();
        case RtPackage.RT_SYMBOL__ACCESSORS:
            return getAccessors();
        case RtPackage.RT_SYMBOL__INDEX:
            return getIndex();
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
        case RtPackage.RT_SYMBOL__ADDRESS:
            setAddress((Integer) newValue);
            return;
        case RtPackage.RT_SYMBOL__NAME:
            setName((String) newValue);
            return;
        case RtPackage.RT_SYMBOL__MODULE:
            setModule((RtModule) newValue);
            return;
        case RtPackage.RT_SYMBOL__ACCESSORS:
            getAccessors().clear();
            getAccessors().addAll((Collection<? extends RtSymbolAccess>) newValue);
            return;
        case RtPackage.RT_SYMBOL__INDEX:
            setIndex((Integer) newValue);
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
        case RtPackage.RT_SYMBOL__ADDRESS:
            setAddress(ADDRESS_EDEFAULT);
            return;
        case RtPackage.RT_SYMBOL__NAME:
            setName(NAME_EDEFAULT);
            return;
        case RtPackage.RT_SYMBOL__MODULE:
            setModule((RtModule) null);
            return;
        case RtPackage.RT_SYMBOL__ACCESSORS:
            getAccessors().clear();
            return;
        case RtPackage.RT_SYMBOL__INDEX:
            setIndex(INDEX_EDEFAULT);
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
        case RtPackage.RT_SYMBOL__ADDRESS:
            return address != ADDRESS_EDEFAULT;
        case RtPackage.RT_SYMBOL__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case RtPackage.RT_SYMBOL__MODULE:
            return getModule() != null;
        case RtPackage.RT_SYMBOL__ACCESSORS:
            return accessors != null && !accessors.isEmpty();
        case RtPackage.RT_SYMBOL__INDEX:
            return index != INDEX_EDEFAULT;
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
        result.append(" (address: ");
        result.append(address);
        result.append(", name: ");
        result.append(name);
        result.append(", index: ");
        result.append(index);
        result.append(')');
        return result.toString();
    }

} // RtSymbolImpl
