/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.impl;

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

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Task</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.impl.TaskImpl#getKind
 * <em>Kind</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.TaskImpl#getCycleTime
 * <em>Cycle Time</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.TaskImpl#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.TaskImpl#getPages
 * <em>Pages</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.TaskImpl#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.TaskImpl#getName
 * <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskImpl extends EObjectImpl implements Task {
    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected static final TaskKind KIND_EDEFAULT = TaskKind.INIT;

    /**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected TaskKind kind = KIND_EDEFAULT;

    /**
     * The default value of the '{@link #getCycleTime() <em>Cycle Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCycleTime()
     * @generated
     * @ordered
     */
    protected static final int CYCLE_TIME_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCycleTime() <em>Cycle Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCycleTime()
     * @generated
     * @ordered
     */
    protected int cycleTime = CYCLE_TIME_EDEFAULT;

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
     * The cached value of the '{@link #getPages() <em>Pages</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPages()
     * @generated
     * @ordered
     */
    protected EList<Page> pages;

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected TaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModulePackage.Literals.TASK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TaskKind getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setKind(TaskKind newKind) {
        TaskKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.TASK__KIND, oldKind, kind));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getCycleTime() {
        return cycleTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCycleTime(int newCycleTime) {
        int oldCycleTime = cycleTime;
        cycleTime = newCycleTime;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.TASK__CYCLE_TIME, oldCycleTime,
                    cycleTime));
        }
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
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.TASK__INDEX, oldIndex, index));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Page> getPages() {
        if (pages == null) {
            pages = new EObjectContainmentWithInverseEList<>(Page.class, this, ModulePackage.TASK__PAGES,
                    ModulePackage.PAGE__TASK);
        }
        return pages;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Module getModule() {
        if (eContainerFeatureID() != ModulePackage.TASK__MODULE) {
            return null;
        }
        return (Module) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newModule, ModulePackage.TASK__MODULE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setModule(Module newModule) {
        if (newModule != eInternalContainer()
                || (eContainerFeatureID() != ModulePackage.TASK__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newModule != null) {
                msgs = ((InternalEObject) newModule).eInverseAdd(this, ModulePackage.MODULE__TASKS, Module.class, msgs);
            }
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.TASK__MODULE, newModule, newModule));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.TASK__NAME, oldName, name));
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
        case ModulePackage.TASK__PAGES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getPages()).basicAdd(otherEnd, msgs);
        case ModulePackage.TASK__MODULE:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetModule((Module) otherEnd, msgs);
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
        case ModulePackage.TASK__PAGES:
            return ((InternalEList<?>) getPages()).basicRemove(otherEnd, msgs);
        case ModulePackage.TASK__MODULE:
            return basicSetModule(null, msgs);
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
        case ModulePackage.TASK__MODULE:
            return eInternalContainer().eInverseRemove(this, ModulePackage.MODULE__TASKS, Module.class, msgs);
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
        case ModulePackage.TASK__KIND:
            return getKind();
        case ModulePackage.TASK__CYCLE_TIME:
            return getCycleTime();
        case ModulePackage.TASK__INDEX:
            return getIndex();
        case ModulePackage.TASK__PAGES:
            return getPages();
        case ModulePackage.TASK__MODULE:
            return getModule();
        case ModulePackage.TASK__NAME:
            return getName();
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
        case ModulePackage.TASK__KIND:
            setKind((TaskKind) newValue);
            return;
        case ModulePackage.TASK__CYCLE_TIME:
            setCycleTime((Integer) newValue);
            return;
        case ModulePackage.TASK__INDEX:
            setIndex((Integer) newValue);
            return;
        case ModulePackage.TASK__PAGES:
            getPages().clear();
            getPages().addAll((Collection<? extends Page>) newValue);
            return;
        case ModulePackage.TASK__MODULE:
            setModule((Module) newValue);
            return;
        case ModulePackage.TASK__NAME:
            setName((String) newValue);
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
        case ModulePackage.TASK__KIND:
            setKind(KIND_EDEFAULT);
            return;
        case ModulePackage.TASK__CYCLE_TIME:
            setCycleTime(CYCLE_TIME_EDEFAULT);
            return;
        case ModulePackage.TASK__INDEX:
            setIndex(INDEX_EDEFAULT);
            return;
        case ModulePackage.TASK__PAGES:
            getPages().clear();
            return;
        case ModulePackage.TASK__MODULE:
            setModule((Module) null);
            return;
        case ModulePackage.TASK__NAME:
            setName(NAME_EDEFAULT);
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
        case ModulePackage.TASK__KIND:
            return kind != KIND_EDEFAULT;
        case ModulePackage.TASK__CYCLE_TIME:
            return cycleTime != CYCLE_TIME_EDEFAULT;
        case ModulePackage.TASK__INDEX:
            return index != INDEX_EDEFAULT;
        case ModulePackage.TASK__PAGES:
            return pages != null && !pages.isEmpty();
        case ModulePackage.TASK__MODULE:
            return getModule() != null;
        case ModulePackage.TASK__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
        result.append(" (kind: ");
        result.append(kind);
        result.append(", cycleTime: ");
        result.append(cycleTime);
        result.append(", index: ");
        result.append(index);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} // TaskImpl
