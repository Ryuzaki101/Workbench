/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.PortGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Port
 * Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortGroupImpl#getRuntime
 * <em>Runtime</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortGroupImpl extends PortImpl implements PortGroup {
    /**
     * The default value of the '{@link #getRuntime() <em>Runtime</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRuntime()
     * @generated
     * @ordered
     */
    protected static final long RUNTIME_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getRuntime() <em>Runtime</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRuntime()
     * @generated
     * @ordered
     */
    protected long runtime = RUNTIME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PortGroupImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HwmodulesPackage.Literals.PORT_GROUP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public long getRuntime() {
        return runtime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRuntime(long newRuntime) {
        long oldRuntime = runtime;
        runtime = newRuntime;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.PORT_GROUP__RUNTIME, oldRuntime,
                    runtime));
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
        case HwmodulesPackage.PORT_GROUP__RUNTIME:
            return getRuntime();
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
        case HwmodulesPackage.PORT_GROUP__RUNTIME:
            setRuntime((Long) newValue);
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
        case HwmodulesPackage.PORT_GROUP__RUNTIME:
            setRuntime(RUNTIME_EDEFAULT);
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
        case HwmodulesPackage.PORT_GROUP__RUNTIME:
            return runtime != RUNTIME_EDEFAULT;
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
        result.append(" (runtime: ");
        result.append(runtime);
        result.append(')');
        return result.toString();
    }

} // PortGroupImpl
