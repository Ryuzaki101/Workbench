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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtTask;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Module
 * Invocation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getArguments
 * <em>Arguments</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getTask
 * <em>Task</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getOpcode
 * <em>Opcode</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getPastValuesCount
 * <em>Past Values Count</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtModuleInvocationImpl#getRuntime
 * <em>Runtime</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtModuleInvocationImpl extends EObjectImpl implements RtModuleInvocation {
    /**
     * The cached value of the '{@link #getArguments() <em>Arguments</em>}'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getArguments()
     * @generated
     * @ordered
     */
    protected EList<RtSymbolAccess> arguments;

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
     * The default value of the '{@link #getOpcode() <em>Opcode</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOpcode()
     * @generated
     * @ordered
     */
    protected static final int OPCODE_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getOpcode() <em>Opcode</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOpcode()
     * @generated
     * @ordered
     */
    protected int opcode = OPCODE_EDEFAULT;

    /**
     * The default value of the '{@link #getPastValuesCount() <em>Past Values
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesCount()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUES_COUNT_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getPastValuesCount() <em>Past Values
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesCount()
     * @generated
     * @ordered
     */
    protected int pastValuesCount = PAST_VALUES_COUNT_EDEFAULT;

    /**
     * The default value of the '{@link #getRuntime() <em>Runtime</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRuntime()
     * @generated
     * @ordered
     */
    protected static final int RUNTIME_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRuntime() <em>Runtime</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRuntime()
     * @generated
     * @ordered
     */
    protected int runtime = RUNTIME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtModuleInvocationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_MODULE_INVOCATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtSymbolAccess> getArguments() {
        if (arguments == null) {
            arguments = new EObjectWithInverseResolvingEList<>(RtSymbolAccess.class, this,
                    RtPackage.RT_MODULE_INVOCATION__ARGUMENTS, RtPackage.RT_SYMBOL_ACCESS__MODULE_INVOCATION);
        }
        return arguments;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtTask getTask() {
        if (eContainerFeatureID() != RtPackage.RT_MODULE_INVOCATION__TASK) {
            return null;
        }
        return (RtTask) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetTask(RtTask newTask, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newTask, RtPackage.RT_MODULE_INVOCATION__TASK, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTask(RtTask newTask) {
        if (newTask != eInternalContainer()
                || (eContainerFeatureID() != RtPackage.RT_MODULE_INVOCATION__TASK && newTask != null)) {
            if (EcoreUtil.isAncestor(this, newTask)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newTask != null) {
                msgs = ((InternalEObject) newTask).eInverseAdd(this, RtPackage.RT_TASK__MODULE_INVOCATIONS,
                        RtTask.class, msgs);
            }
            msgs = basicSetTask(newTask, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE_INVOCATION__TASK, newTask,
                    newTask));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE_INVOCATION__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE_INVOCATION__INDEX, oldIndex,
                    index));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getOpcode() {
        return opcode;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOpcode(int newOpcode) {
        int oldOpcode = opcode;
        opcode = newOpcode;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE_INVOCATION__OPCODE, oldOpcode,
                    opcode));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getPastValuesCount() {
        return pastValuesCount;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPastValuesCount(int newPastValuesCount) {
        int oldPastValuesCount = pastValuesCount;
        pastValuesCount = newPastValuesCount;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE_INVOCATION__PAST_VALUES_COUNT,
                    oldPastValuesCount, pastValuesCount));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getRuntime() {
        return runtime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRuntime(int newRuntime) {
        int oldRuntime = runtime;
        runtime = newRuntime;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_MODULE_INVOCATION__RUNTIME, oldRuntime,
                    runtime));
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
        case RtPackage.RT_MODULE_INVOCATION__ARGUMENTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getArguments()).basicAdd(otherEnd, msgs);
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetTask((RtTask) otherEnd, msgs);
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
        case RtPackage.RT_MODULE_INVOCATION__ARGUMENTS:
            return ((InternalEList<?>) getArguments()).basicRemove(otherEnd, msgs);
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            return basicSetTask(null, msgs);
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
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            return eInternalContainer().eInverseRemove(this, RtPackage.RT_TASK__MODULE_INVOCATIONS, RtTask.class, msgs);
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
        case RtPackage.RT_MODULE_INVOCATION__ARGUMENTS:
            return getArguments();
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            return getTask();
        case RtPackage.RT_MODULE_INVOCATION__NAME:
            return getName();
        case RtPackage.RT_MODULE_INVOCATION__INDEX:
            return getIndex();
        case RtPackage.RT_MODULE_INVOCATION__OPCODE:
            return getOpcode();
        case RtPackage.RT_MODULE_INVOCATION__PAST_VALUES_COUNT:
            return getPastValuesCount();
        case RtPackage.RT_MODULE_INVOCATION__RUNTIME:
            return getRuntime();
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
        case RtPackage.RT_MODULE_INVOCATION__ARGUMENTS:
            getArguments().clear();
            getArguments().addAll((Collection<? extends RtSymbolAccess>) newValue);
            return;
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            setTask((RtTask) newValue);
            return;
        case RtPackage.RT_MODULE_INVOCATION__NAME:
            setName((String) newValue);
            return;
        case RtPackage.RT_MODULE_INVOCATION__INDEX:
            setIndex((Integer) newValue);
            return;
        case RtPackage.RT_MODULE_INVOCATION__OPCODE:
            setOpcode((Integer) newValue);
            return;
        case RtPackage.RT_MODULE_INVOCATION__PAST_VALUES_COUNT:
            setPastValuesCount((Integer) newValue);
            return;
        case RtPackage.RT_MODULE_INVOCATION__RUNTIME:
            setRuntime((Integer) newValue);
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
        case RtPackage.RT_MODULE_INVOCATION__ARGUMENTS:
            getArguments().clear();
            return;
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            setTask((RtTask) null);
            return;
        case RtPackage.RT_MODULE_INVOCATION__NAME:
            setName(NAME_EDEFAULT);
            return;
        case RtPackage.RT_MODULE_INVOCATION__INDEX:
            setIndex(INDEX_EDEFAULT);
            return;
        case RtPackage.RT_MODULE_INVOCATION__OPCODE:
            setOpcode(OPCODE_EDEFAULT);
            return;
        case RtPackage.RT_MODULE_INVOCATION__PAST_VALUES_COUNT:
            setPastValuesCount(PAST_VALUES_COUNT_EDEFAULT);
            return;
        case RtPackage.RT_MODULE_INVOCATION__RUNTIME:
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
        case RtPackage.RT_MODULE_INVOCATION__ARGUMENTS:
            return arguments != null && !arguments.isEmpty();
        case RtPackage.RT_MODULE_INVOCATION__TASK:
            return getTask() != null;
        case RtPackage.RT_MODULE_INVOCATION__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case RtPackage.RT_MODULE_INVOCATION__INDEX:
            return index != INDEX_EDEFAULT;
        case RtPackage.RT_MODULE_INVOCATION__OPCODE:
            return opcode != OPCODE_EDEFAULT;
        case RtPackage.RT_MODULE_INVOCATION__PAST_VALUES_COUNT:
            return pastValuesCount != PAST_VALUES_COUNT_EDEFAULT;
        case RtPackage.RT_MODULE_INVOCATION__RUNTIME:
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
        result.append(" (name: ");
        result.append(name);
        result.append(", index: ");
        result.append(index);
        result.append(", opcode: ");
        result.append(opcode);
        result.append(", pastValuesCount: ");
        result.append(pastValuesCount);
        result.append(", runtime: ");
        result.append(runtime);
        result.append(')');
        return result.toString();
    }

} // RtModuleInvocationImpl
