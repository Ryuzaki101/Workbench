/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitorPackage;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.rt.RtSymbol;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Monitored Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl#getRtSymbol
 * <em>Rt Symbol</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl#getTextValue
 * <em>Text Value</em>}</li>
 * <li>{@link de.wisag.automation.micas.olt.monitor.impl.MonitoredItemImpl#getMonitorModel
 * <em>Monitor Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitoredItemImpl extends EObjectImpl implements MonitoredItem {
    /**
     * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected static final int INDEX_EDEFAULT = 0;

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
     * The cached value of the '{@link #getRtSymbol() <em>Rt Symbol</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRtSymbol()
     * @generated
     * @ordered
     */
    protected RtSymbol rtSymbol;

    /**
     * The default value of the '{@link #getTextValue() <em>Text Value</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTextValue()
     * @generated
     * @ordered
     */
    protected static final String TEXT_VALUE_EDEFAULT = "\"\"";

    /**
     * The cached value of the '{@link #getTextValue() <em>Text Value</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTextValue()
     * @generated
     * @ordered
     */
    protected String textValue = TEXT_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MonitoredItemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MonitorPackage.Literals.MONITORED_ITEM;
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
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_ITEM__INDEX, oldIndex,
                    index));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RtSymbol getRtSymbol() {
        if (rtSymbol != null && rtSymbol.eIsProxy()) {
            InternalEObject oldRtSymbol = (InternalEObject) rtSymbol;
            rtSymbol = (RtSymbol) eResolveProxy(oldRtSymbol);
            if (rtSymbol != oldRtSymbol) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MonitorPackage.MONITORED_ITEM__RT_SYMBOL,
                            oldRtSymbol, rtSymbol));
                }
            }
        }
        return rtSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RtSymbol basicGetRtSymbol() {
        return rtSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRtSymbol(RtSymbol newRtSymbol) {
        RtSymbol oldRtSymbol = rtSymbol;
        rtSymbol = newRtSymbol;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_ITEM__RT_SYMBOL, oldRtSymbol,
                    rtSymbol));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getTextValue() {
        return textValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTextValue(String newTextValue) {
        String oldTextValue = textValue;
        textValue = newTextValue;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_ITEM__TEXT_VALUE,
                    oldTextValue, textValue));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MonitorModel getMonitorModel() {
        if (eContainerFeatureID() != MonitorPackage.MONITORED_ITEM__MONITOR_MODEL) {
            return null;
        }
        return (MonitorModel) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMonitorModel(MonitorModel newMonitorModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newMonitorModel, MonitorPackage.MONITORED_ITEM__MONITOR_MODEL,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMonitorModel(MonitorModel newMonitorModel) {
        if (newMonitorModel != eInternalContainer()
                || (eContainerFeatureID() != MonitorPackage.MONITORED_ITEM__MONITOR_MODEL && newMonitorModel != null)) {
            if (EcoreUtil.isAncestor(this, newMonitorModel)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newMonitorModel != null) {
                msgs = ((InternalEObject) newMonitorModel).eInverseAdd(this, MonitorPackage.MONITOR_MODEL__ITEMS,
                        MonitorModel.class, msgs);
            }
            msgs = basicSetMonitorModel(newMonitorModel, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, MonitorPackage.MONITORED_ITEM__MONITOR_MODEL,
                    newMonitorModel, newMonitorModel));
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
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetMonitorModel((MonitorModel) otherEnd, msgs);
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
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            return basicSetMonitorModel(null, msgs);
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
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            return eInternalContainer().eInverseRemove(this, MonitorPackage.MONITOR_MODEL__ITEMS, MonitorModel.class,
                    msgs);
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
        case MonitorPackage.MONITORED_ITEM__INDEX:
            return getIndex();
        case MonitorPackage.MONITORED_ITEM__RT_SYMBOL:
            if (resolve) {
                return getRtSymbol();
            }
            return basicGetRtSymbol();
        case MonitorPackage.MONITORED_ITEM__TEXT_VALUE:
            return getTextValue();
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            return getMonitorModel();
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
        case MonitorPackage.MONITORED_ITEM__INDEX:
            setIndex((Integer) newValue);
            return;
        case MonitorPackage.MONITORED_ITEM__RT_SYMBOL:
            setRtSymbol((RtSymbol) newValue);
            return;
        case MonitorPackage.MONITORED_ITEM__TEXT_VALUE:
            setTextValue((String) newValue);
            return;
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            setMonitorModel((MonitorModel) newValue);
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
        case MonitorPackage.MONITORED_ITEM__INDEX:
            setIndex(INDEX_EDEFAULT);
            return;
        case MonitorPackage.MONITORED_ITEM__RT_SYMBOL:
            setRtSymbol((RtSymbol) null);
            return;
        case MonitorPackage.MONITORED_ITEM__TEXT_VALUE:
            setTextValue(TEXT_VALUE_EDEFAULT);
            return;
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            setMonitorModel((MonitorModel) null);
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
        case MonitorPackage.MONITORED_ITEM__INDEX:
            return index != INDEX_EDEFAULT;
        case MonitorPackage.MONITORED_ITEM__RT_SYMBOL:
            return rtSymbol != null;
        case MonitorPackage.MONITORED_ITEM__TEXT_VALUE:
            return TEXT_VALUE_EDEFAULT == null ? textValue != null : !TEXT_VALUE_EDEFAULT.equals(textValue);
        case MonitorPackage.MONITORED_ITEM__MONITOR_MODEL:
            return getMonitorModel() != null;
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
        result.append(" (index: ");
        result.append(index);
        result.append(", textValue: ");
        result.append(textValue);
        result.append(')');
        return result.toString();
    }

} // MonitoredItemImpl
