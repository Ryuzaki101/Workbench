/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Micas
 * Modules</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl#getModulesById
 * <em>Modules By Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl#getModulesByName
 * <em>Modules By Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl#getModules
 * <em>Modules</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.MicasModulesImpl#getTypes
 * <em>Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MicasModulesImpl extends EObjectImpl implements MicasModules {
    /**
     * The cached value of the '{@link #getModulesById() <em>Modules By
     * Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModulesById()
     * @generated
     * @ordered
     */
    protected Map<Integer, ModuleDefinition> modulesById;

    /**
     * The cached value of the '{@link #getModulesByName() <em>Modules By
     * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModulesByName()
     * @generated
     * @ordered
     */
    protected Map<String, ModuleDefinition> modulesByName;

    /**
     * The cached value of the '{@link #getModules() <em>Modules</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getModules()
     * @generated
     * @ordered
     */
    protected EList<ModuleDefinition> modules;

    /**
     * The cached value of the '{@link #getTypes() <em>Types</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTypes()
     * @generated
     * @ordered
     */
    protected EList<HardwareTypeDefinition> types;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MicasModulesImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HwmodulesPackage.Literals.MICAS_MODULES;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Map<Integer, ModuleDefinition> getModulesById() {
        return modulesById;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setModulesById(Map<Integer, ModuleDefinition> newModulesById) {
        Map<Integer, ModuleDefinition> oldModulesById = modulesById;
        modulesById = newModulesById;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MICAS_MODULES__MODULES_BY_ID,
                    oldModulesById, modulesById));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Map<String, ModuleDefinition> getModulesByName() {
        return modulesByName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setModulesByName(Map<String, ModuleDefinition> newModulesByName) {
        Map<String, ModuleDefinition> oldModulesByName = modulesByName;
        modulesByName = newModulesByName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MICAS_MODULES__MODULES_BY_NAME,
                    oldModulesByName, modulesByName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ModuleDefinition> getModules() {
        if (modules == null) {
            modules = new EObjectContainmentEList<>(ModuleDefinition.class, this,
                    HwmodulesPackage.MICAS_MODULES__MODULES);
        }
        return modules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<HardwareTypeDefinition> getTypes() {
        if (types == null) {
            types = new EObjectContainmentEList<>(HardwareTypeDefinition.class, this,
                    HwmodulesPackage.MICAS_MODULES__TYPES);
        }
        return types;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ModuleDefinition findModuleById(final int id) {
        return ModuleUtils.findModuleById(this, id);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ModuleDefinition findModuleByName(final String name) {
        return ModuleUtils.findModuleByName(this, name);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case HwmodulesPackage.MICAS_MODULES__MODULES:
            return ((InternalEList<?>) getModules()).basicRemove(otherEnd, msgs);
        case HwmodulesPackage.MICAS_MODULES__TYPES:
            return ((InternalEList<?>) getTypes()).basicRemove(otherEnd, msgs);
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
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_ID:
            return getModulesById();
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_NAME:
            return getModulesByName();
        case HwmodulesPackage.MICAS_MODULES__MODULES:
            return getModules();
        case HwmodulesPackage.MICAS_MODULES__TYPES:
            return getTypes();
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
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_ID:
            setModulesById((Map<Integer, ModuleDefinition>) newValue);
            return;
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_NAME:
            setModulesByName((Map<String, ModuleDefinition>) newValue);
            return;
        case HwmodulesPackage.MICAS_MODULES__MODULES:
            getModules().clear();
            getModules().addAll((Collection<? extends ModuleDefinition>) newValue);
            return;
        case HwmodulesPackage.MICAS_MODULES__TYPES:
            getTypes().clear();
            getTypes().addAll((Collection<? extends HardwareTypeDefinition>) newValue);
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
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_ID:
            setModulesById((Map<Integer, ModuleDefinition>) null);
            return;
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_NAME:
            setModulesByName((Map<String, ModuleDefinition>) null);
            return;
        case HwmodulesPackage.MICAS_MODULES__MODULES:
            getModules().clear();
            return;
        case HwmodulesPackage.MICAS_MODULES__TYPES:
            getTypes().clear();
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
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_ID:
            return modulesById != null;
        case HwmodulesPackage.MICAS_MODULES__MODULES_BY_NAME:
            return modulesByName != null;
        case HwmodulesPackage.MICAS_MODULES__MODULES:
            return modules != null && !modules.isEmpty();
        case HwmodulesPackage.MICAS_MODULES__TYPES:
            return types != null && !types.isEmpty();
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
        result.append(" (modulesById: ");
        result.append(modulesById);
        result.append(", modulesByName: ");
        result.append(modulesByName);
        result.append(')');
        return result.toString();
    }

} // MicasModulesImpl
