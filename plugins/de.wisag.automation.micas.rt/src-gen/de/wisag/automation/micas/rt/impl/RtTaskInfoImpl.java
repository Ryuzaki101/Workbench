/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskInfo;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Task
 * Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskInfoImpl#getTask
 * <em>Task</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskInfoImpl#getConvertedStrategy
 * <em>Converted Strategy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtTaskInfoImpl extends EObjectImpl implements RtTaskInfo {
    /**
     * The cached value of the '{@link #getTask() <em>Task</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTask()
     * @generated
     * @ordered
     */
    protected RtTask task;

    /**
     * The default value of the '{@link #getConvertedStrategy() <em>Converted
     * Strategy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getConvertedStrategy()
     * @generated
     * @ordered
     */
    protected static final int CONVERTED_STRATEGY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getConvertedStrategy() <em>Converted
     * Strategy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getConvertedStrategy()
     * @generated
     * @ordered
     */
    protected int convertedStrategy = CONVERTED_STRATEGY_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtTaskInfoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_TASK_INFO;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtTask getTask() {
        if (task != null && task.eIsProxy()) {
            InternalEObject oldTask = (InternalEObject) task;
            task = (RtTask) eResolveProxy(oldTask);
            if (task != oldTask) {
                if (eNotificationRequired()) {
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RtPackage.RT_TASK_INFO__TASK, oldTask,
                            task));
                }
            }
        }
        return task;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtTask basicGetTask() {
        return task;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTask(RtTask newTask) {
        RtTask oldTask = task;
        task = newTask;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK_INFO__TASK, oldTask, task));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getConvertedStrategy() {
        return convertedStrategy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setConvertedStrategy(int newConvertedStrategy) {
        int oldConvertedStrategy = convertedStrategy;
        convertedStrategy = newConvertedStrategy;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK_INFO__CONVERTED_STRATEGY,
                    oldConvertedStrategy, convertedStrategy));
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
        case RtPackage.RT_TASK_INFO__TASK:
            if (resolve) {
                return getTask();
            }
            return basicGetTask();
        case RtPackage.RT_TASK_INFO__CONVERTED_STRATEGY:
            return getConvertedStrategy();
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
        case RtPackage.RT_TASK_INFO__TASK:
            setTask((RtTask) newValue);
            return;
        case RtPackage.RT_TASK_INFO__CONVERTED_STRATEGY:
            setConvertedStrategy((Integer) newValue);
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
        case RtPackage.RT_TASK_INFO__TASK:
            setTask((RtTask) null);
            return;
        case RtPackage.RT_TASK_INFO__CONVERTED_STRATEGY:
            setConvertedStrategy(CONVERTED_STRATEGY_EDEFAULT);
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
        case RtPackage.RT_TASK_INFO__TASK:
            return task != null;
        case RtPackage.RT_TASK_INFO__CONVERTED_STRATEGY:
            return convertedStrategy != CONVERTED_STRATEGY_EDEFAULT;
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
        result.append(" (convertedStrategy: ");
        result.append(convertedStrategy);
        result.append(')');
        return result.toString();
    }

} // RtTaskInfoImpl
