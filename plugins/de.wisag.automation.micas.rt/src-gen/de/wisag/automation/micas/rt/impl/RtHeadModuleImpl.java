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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.rt.RtHeadModule;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtTaskInfo;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Head
 * Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl#getTaskInfos
 * <em>Task Infos</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl#getMagic0
 * <em>Magic0</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl#getMagic1
 * <em>Magic1</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtHeadModuleImpl#getTaskCount
 * <em>Task Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtHeadModuleImpl extends EObjectImpl implements RtHeadModule {
    /**
     * The cached value of the '{@link #getTaskInfos() <em>Task Infos</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTaskInfos()
     * @generated
     * @ordered
     */
    protected EList<RtTaskInfo> taskInfos;

    /**
     * The default value of the '{@link #getMagic0() <em>Magic0</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMagic0()
     * @generated
     * @ordered
     */
    protected static final int MAGIC0_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMagic0() <em>Magic0</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMagic0()
     * @generated
     * @ordered
     */
    protected int magic0 = MAGIC0_EDEFAULT;

    /**
     * The default value of the '{@link #getMagic1() <em>Magic1</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMagic1()
     * @generated
     * @ordered
     */
    protected static final int MAGIC1_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMagic1() <em>Magic1</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMagic1()
     * @generated
     * @ordered
     */
    protected int magic1 = MAGIC1_EDEFAULT;

    /**
     * The default value of the '{@link #getTaskCount() <em>Task Count</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTaskCount()
     * @generated
     * @ordered
     */
    protected static final int TASK_COUNT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTaskCount() <em>Task Count</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTaskCount()
     * @generated
     * @ordered
     */
    protected int taskCount = TASK_COUNT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtHeadModuleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_HEAD_MODULE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtModule getModule() {
        if (eContainerFeatureID() != RtPackage.RT_HEAD_MODULE__MODULE) {
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
        msgs = eBasicSetContainer((InternalEObject) newModule, RtPackage.RT_HEAD_MODULE__MODULE, msgs);
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
                || (eContainerFeatureID() != RtPackage.RT_HEAD_MODULE__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newModule != null) {
                msgs = ((InternalEObject) newModule).eInverseAdd(this, RtPackage.RT_MODULE__HEAD_MODUL, RtModule.class,
                        msgs);
            }
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_HEAD_MODULE__MODULE, newModule,
                    newModule));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtTaskInfo> getTaskInfos() {
        if (taskInfos == null) {
            taskInfos = new EObjectContainmentEList<>(RtTaskInfo.class, this, RtPackage.RT_HEAD_MODULE__TASK_INFOS);
        }
        return taskInfos;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getMagic0() {
        return magic0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMagic0(int newMagic0) {
        int oldMagic0 = magic0;
        magic0 = newMagic0;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_HEAD_MODULE__MAGIC0, oldMagic0, magic0));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getMagic1() {
        return magic1;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMagic1(int newMagic1) {
        int oldMagic1 = magic1;
        magic1 = newMagic1;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_HEAD_MODULE__MAGIC1, oldMagic1, magic1));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getTaskCount() {
        return taskCount;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTaskCount(int newTaskCount) {
        int oldTaskCount = taskCount;
        taskCount = newTaskCount;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_HEAD_MODULE__TASK_COUNT, oldTaskCount,
                    taskCount));
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetModule((RtModule) otherEnd, msgs);
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            return basicSetModule(null, msgs);
        case RtPackage.RT_HEAD_MODULE__TASK_INFOS:
            return ((InternalEList<?>) getTaskInfos()).basicRemove(otherEnd, msgs);
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            return eInternalContainer().eInverseRemove(this, RtPackage.RT_MODULE__HEAD_MODUL, RtModule.class, msgs);
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            return getModule();
        case RtPackage.RT_HEAD_MODULE__TASK_INFOS:
            return getTaskInfos();
        case RtPackage.RT_HEAD_MODULE__MAGIC0:
            return getMagic0();
        case RtPackage.RT_HEAD_MODULE__MAGIC1:
            return getMagic1();
        case RtPackage.RT_HEAD_MODULE__TASK_COUNT:
            return getTaskCount();
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            setModule((RtModule) newValue);
            return;
        case RtPackage.RT_HEAD_MODULE__TASK_INFOS:
            getTaskInfos().clear();
            getTaskInfos().addAll((Collection<? extends RtTaskInfo>) newValue);
            return;
        case RtPackage.RT_HEAD_MODULE__MAGIC0:
            setMagic0((Integer) newValue);
            return;
        case RtPackage.RT_HEAD_MODULE__MAGIC1:
            setMagic1((Integer) newValue);
            return;
        case RtPackage.RT_HEAD_MODULE__TASK_COUNT:
            setTaskCount((Integer) newValue);
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            setModule((RtModule) null);
            return;
        case RtPackage.RT_HEAD_MODULE__TASK_INFOS:
            getTaskInfos().clear();
            return;
        case RtPackage.RT_HEAD_MODULE__MAGIC0:
            setMagic0(MAGIC0_EDEFAULT);
            return;
        case RtPackage.RT_HEAD_MODULE__MAGIC1:
            setMagic1(MAGIC1_EDEFAULT);
            return;
        case RtPackage.RT_HEAD_MODULE__TASK_COUNT:
            setTaskCount(TASK_COUNT_EDEFAULT);
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
        case RtPackage.RT_HEAD_MODULE__MODULE:
            return getModule() != null;
        case RtPackage.RT_HEAD_MODULE__TASK_INFOS:
            return taskInfos != null && !taskInfos.isEmpty();
        case RtPackage.RT_HEAD_MODULE__MAGIC0:
            return magic0 != MAGIC0_EDEFAULT;
        case RtPackage.RT_HEAD_MODULE__MAGIC1:
            return magic1 != MAGIC1_EDEFAULT;
        case RtPackage.RT_HEAD_MODULE__TASK_COUNT:
            return taskCount != TASK_COUNT_EDEFAULT;
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
        result.append(" (magic0: ");
        result.append(magic0);
        result.append(", magic1: ");
        result.append(magic1);
        result.append(", taskCount: ");
        result.append(taskCount);
        result.append(')');
        return result.toString();
    }

} // RtHeadModuleImpl
