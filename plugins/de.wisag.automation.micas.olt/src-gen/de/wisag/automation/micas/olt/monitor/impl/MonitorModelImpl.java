/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.rt.RtModule;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl#getItems
 * <em>Items</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl#getLastUpdated
 * <em>Last Updated</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl#isActive
 * <em>Active</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitorModelImpl#getRtModule
 * <em>Rt Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitorModelImpl extends EObjectImpl implements MonitorModel {
    /**
     * The cached value of the '{@link #getItems() <em>Items</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList<MonitoredItem> items;

    /**
     * The default value of the '{@link #getLastUpdated() <em>Last
     * Updated</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLastUpdated()
     * @generated
     * @ordered
     */
    protected static final long LAST_UPDATED_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLastUpdated()
     * @generated
     * @ordered
     */
    protected long lastUpdated = LAST_UPDATED_EDEFAULT;

    /**
     * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isActive()
     * @generated
     * @ordered
     */
    protected static final boolean ACTIVE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isActive()
     * @generated
     * @ordered
     */
    protected boolean active = ACTIVE_EDEFAULT;

    /**
     * The cached value of the '{@link #getRtModule() <em>Rt Module</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRtModule()
     * @generated
     * @ordered
     */
    protected RtModule rtModule;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MonitorModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MonitorPackage.Literals.MONITOR_MODEL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<MonitoredItem> getItems() {
        if (items == null) {
            items = new EObjectContainmentWithInverseEList<>(MonitoredItem.class, this,
                    MonitorPackage.MONITOR_MODEL__ITEMS, MonitorPackage.MONITORED_ITEM__MONITOR_MODEL);
        }
        return items;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public long getLastUpdated() {
        return lastUpdated;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLastUpdated(long newLastUpdated) {
        long oldLastUpdated = lastUpdated;
        lastUpdated = newLastUpdated;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITOR_MODEL__LAST_UPDATED,
                    oldLastUpdated, lastUpdated));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setActive(boolean newActive) {
        boolean oldActive = active;
        active = newActive;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITOR_MODEL__ACTIVE, oldActive,
                    active));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RtModule getRtModule() {
        if (rtModule != null && rtModule.eIsProxy()) {
            InternalEObject oldRtModule = (InternalEObject) rtModule;
            rtModule = (RtModule) eResolveProxy(oldRtModule);
            if (rtModule != oldRtModule) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitorPackage.MONITOR_MODEL__RT_MODULE,
                            oldRtModule, rtModule));
                }
            }
        }
        return rtModule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RtModule basicGetRtModule() {
        return rtModule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRtModule(RtModule newRtModule) {
        RtModule oldRtModule = rtModule;
        rtModule = newRtModule;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITOR_MODEL__RT_MODULE, oldRtModule,
                    rtModule));
        }
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
        case MonitorPackage.MONITOR_MODEL__ITEMS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getItems()).basicAdd(otherEnd, msgs);
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
        case MonitorPackage.MONITOR_MODEL__ITEMS:
            return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
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
        case MonitorPackage.MONITOR_MODEL__ITEMS:
            return getItems();
        case MonitorPackage.MONITOR_MODEL__LAST_UPDATED:
            return getLastUpdated();
        case MonitorPackage.MONITOR_MODEL__ACTIVE:
            return isActive();
        case MonitorPackage.MONITOR_MODEL__RT_MODULE:
            if (resolve) {
                return getRtModule();
            }
            return basicGetRtModule();
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
        case MonitorPackage.MONITOR_MODEL__ITEMS:
            getItems().clear();
            getItems().addAll((Collection<? extends MonitoredItem>) newValue);
            return;
        case MonitorPackage.MONITOR_MODEL__LAST_UPDATED:
            setLastUpdated((Long) newValue);
            return;
        case MonitorPackage.MONITOR_MODEL__ACTIVE:
            setActive((Boolean) newValue);
            return;
        case MonitorPackage.MONITOR_MODEL__RT_MODULE:
            setRtModule((RtModule) newValue);
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
        case MonitorPackage.MONITOR_MODEL__ITEMS:
            getItems().clear();
            return;
        case MonitorPackage.MONITOR_MODEL__LAST_UPDATED:
            setLastUpdated(LAST_UPDATED_EDEFAULT);
            return;
        case MonitorPackage.MONITOR_MODEL__ACTIVE:
            setActive(ACTIVE_EDEFAULT);
            return;
        case MonitorPackage.MONITOR_MODEL__RT_MODULE:
            setRtModule((RtModule) null);
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
        case MonitorPackage.MONITOR_MODEL__ITEMS:
            return items != null && !items.isEmpty();
        case MonitorPackage.MONITOR_MODEL__LAST_UPDATED:
            return lastUpdated != LAST_UPDATED_EDEFAULT;
        case MonitorPackage.MONITOR_MODEL__ACTIVE:
            return active != ACTIVE_EDEFAULT;
        case MonitorPackage.MONITOR_MODEL__RT_MODULE:
            return rtModule != null;
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
        result.append(" (lastUpdated: ");
        result.append(lastUpdated);
        result.append(", active: ");
        result.append(active);
        result.append(')');
        return result.toString();
    }

} // MonitorModelImpl
