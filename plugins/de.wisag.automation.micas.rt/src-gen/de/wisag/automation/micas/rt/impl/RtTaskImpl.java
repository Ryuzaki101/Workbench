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
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskStrategy;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Task</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getModule
 * <em>Module</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getModuleInvocations
 * <em>Module Invocations</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getId
 * <em>Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getCyclTime <em>Cycl
 * Time</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getSegment
 * <em>Segment</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getPastValuesOffset
 * <em>Past Values Offset</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getStrategy
 * <em>Strategy</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getData
 * <em>Data</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getRuntime
 * <em>Runtime</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getPastValuesCount
 * <em>Past Values Count</em>}</li>
 * <li>{@link de.wisag.automation.micas.rt.impl.RtTaskImpl#getComment
 * <em>Comment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RtTaskImpl extends EObjectImpl implements RtTask {
    /**
     * The cached value of the '{@link #getModuleInvocations() <em>Module
     * Invocations</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getModuleInvocations()
     * @generated
     * @ordered
     */
    protected EList<RtModuleInvocation> moduleInvocations;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getId()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getCyclTime() <em>Cycl Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCyclTime()
     * @generated
     * @ordered
     */
    protected static final int CYCL_TIME_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCyclTime() <em>Cycl Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCyclTime()
     * @generated
     * @ordered
     */
    protected int cyclTime = CYCL_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getSegment() <em>Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSegment()
     * @generated
     * @ordered
     */
    protected static final int SEGMENT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSegment() <em>Segment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSegment()
     * @generated
     * @ordered
     */
    protected int segment = SEGMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getPastValuesOffset() <em>Past Values
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesOffset()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUES_OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPastValuesOffset() <em>Past Values
     * Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesOffset()
     * @generated
     * @ordered
     */
    protected int pastValuesOffset = PAST_VALUES_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getStrategy() <em>Strategy</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStrategy()
     * @generated
     * @ordered
     */
    protected static final RtTaskStrategy STRATEGY_EDEFAULT = RtTaskStrategy.CYCL;

    /**
     * The cached value of the '{@link #getStrategy() <em>Strategy</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStrategy()
     * @generated
     * @ordered
     */
    protected RtTaskStrategy strategy = STRATEGY_EDEFAULT;

    /**
     * The default value of the '{@link #getData() <em>Data</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getData()
     * @generated
     * @ordered
     */
    protected static final byte[] DATA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getData()
     * @generated
     * @ordered
     */
    protected byte[] data = DATA_EDEFAULT;

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
     * The default value of the '{@link #getPastValuesCount() <em>Past Values
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPastValuesCount()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUES_COUNT_EDEFAULT = 0;

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
     * The default value of the '{@link #getComment() <em>Comment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComment()
     * @generated
     * @ordered
     */
    protected static final String COMMENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getComment() <em>Comment</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComment()
     * @generated
     * @ordered
     */
    protected String comment = COMMENT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtTaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RtPackage.Literals.RT_TASK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtModule getModule() {
        if (eContainerFeatureID() != RtPackage.RT_TASK__MODULE) {
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
        msgs = eBasicSetContainer((InternalEObject) newModule, RtPackage.RT_TASK__MODULE, msgs);
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
                || (eContainerFeatureID() != RtPackage.RT_TASK__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            }
            NotificationChain msgs = null;
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            if (newModule != null) {
                msgs = ((InternalEObject) newModule).eInverseAdd(this, RtPackage.RT_MODULE__TASKS, RtModule.class,
                        msgs);
            }
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__MODULE, newModule, newModule));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RtModuleInvocation> getModuleInvocations() {
        if (moduleInvocations == null) {
            moduleInvocations = new EObjectContainmentWithInverseEList<>(RtModuleInvocation.class, this,
                    RtPackage.RT_TASK__MODULE_INVOCATIONS, RtPackage.RT_MODULE_INVOCATION__TASK);
        }
        return moduleInvocations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__ID, oldId, id));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getCyclTime() {
        return cyclTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCyclTime(int newCyclTime) {
        int oldCyclTime = cyclTime;
        cyclTime = newCyclTime;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__CYCL_TIME, oldCyclTime, cyclTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getSegment() {
        return segment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSegment(int newSegment) {
        int oldSegment = segment;
        segment = newSegment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__SEGMENT, oldSegment, segment));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getPastValuesOffset() {
        return pastValuesOffset;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPastValuesOffset(int newPastValuesOffset) {
        int oldPastValuesOffset = pastValuesOffset;
        pastValuesOffset = newPastValuesOffset;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__PAST_VALUES_OFFSET,
                    oldPastValuesOffset, pastValuesOffset));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtTaskStrategy getStrategy() {
        return strategy;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStrategy(RtTaskStrategy newStrategy) {
        RtTaskStrategy oldStrategy = strategy;
        strategy = newStrategy == null ? STRATEGY_EDEFAULT : newStrategy;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__STRATEGY, oldStrategy, strategy));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public byte[] getData() {
        return data;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setData(byte[] newData) {
        byte[] oldData = data;
        data = newData;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__DATA, oldData, data));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__RUNTIME, oldRuntime, runtime));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__PAST_VALUES_COUNT,
                    oldPastValuesCount, pastValuesCount));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setComment(String newComment) {
        String oldComment = comment;
        comment = newComment;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, RtPackage.RT_TASK__COMMENT, oldComment, comment));
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
        case RtPackage.RT_TASK__MODULE:
            if (eInternalContainer() != null) {
                msgs = eBasicRemoveFromContainer(msgs);
            }
            return basicSetModule((RtModule) otherEnd, msgs);
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getModuleInvocations()).basicAdd(otherEnd,
                    msgs);
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
        case RtPackage.RT_TASK__MODULE:
            return basicSetModule(null, msgs);
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
            return ((InternalEList<?>) getModuleInvocations()).basicRemove(otherEnd, msgs);
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
        case RtPackage.RT_TASK__MODULE:
            return eInternalContainer().eInverseRemove(this, RtPackage.RT_MODULE__TASKS, RtModule.class, msgs);
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
        case RtPackage.RT_TASK__MODULE:
            return getModule();
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
            return getModuleInvocations();
        case RtPackage.RT_TASK__ID:
            return getId();
        case RtPackage.RT_TASK__CYCL_TIME:
            return getCyclTime();
        case RtPackage.RT_TASK__SEGMENT:
            return getSegment();
        case RtPackage.RT_TASK__PAST_VALUES_OFFSET:
            return getPastValuesOffset();
        case RtPackage.RT_TASK__STRATEGY:
            return getStrategy();
        case RtPackage.RT_TASK__DATA:
            return getData();
        case RtPackage.RT_TASK__RUNTIME:
            return getRuntime();
        case RtPackage.RT_TASK__PAST_VALUES_COUNT:
            return getPastValuesCount();
        case RtPackage.RT_TASK__COMMENT:
            return getComment();
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
        case RtPackage.RT_TASK__MODULE:
            setModule((RtModule) newValue);
            return;
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
            getModuleInvocations().clear();
            getModuleInvocations().addAll((Collection<? extends RtModuleInvocation>) newValue);
            return;
        case RtPackage.RT_TASK__ID:
            setId((Integer) newValue);
            return;
        case RtPackage.RT_TASK__CYCL_TIME:
            setCyclTime((Integer) newValue);
            return;
        case RtPackage.RT_TASK__SEGMENT:
            setSegment((Integer) newValue);
            return;
        case RtPackage.RT_TASK__PAST_VALUES_OFFSET:
            setPastValuesOffset((Integer) newValue);
            return;
        case RtPackage.RT_TASK__STRATEGY:
            setStrategy((RtTaskStrategy) newValue);
            return;
        case RtPackage.RT_TASK__DATA:
            setData((byte[]) newValue);
            return;
        case RtPackage.RT_TASK__RUNTIME:
            setRuntime((Integer) newValue);
            return;
        case RtPackage.RT_TASK__PAST_VALUES_COUNT:
            setPastValuesCount((Integer) newValue);
            return;
        case RtPackage.RT_TASK__COMMENT:
            setComment((String) newValue);
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
        case RtPackage.RT_TASK__MODULE:
            setModule((RtModule) null);
            return;
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
            getModuleInvocations().clear();
            return;
        case RtPackage.RT_TASK__ID:
            setId(ID_EDEFAULT);
            return;
        case RtPackage.RT_TASK__CYCL_TIME:
            setCyclTime(CYCL_TIME_EDEFAULT);
            return;
        case RtPackage.RT_TASK__SEGMENT:
            setSegment(SEGMENT_EDEFAULT);
            return;
        case RtPackage.RT_TASK__PAST_VALUES_OFFSET:
            setPastValuesOffset(PAST_VALUES_OFFSET_EDEFAULT);
            return;
        case RtPackage.RT_TASK__STRATEGY:
            setStrategy(STRATEGY_EDEFAULT);
            return;
        case RtPackage.RT_TASK__DATA:
            setData(DATA_EDEFAULT);
            return;
        case RtPackage.RT_TASK__RUNTIME:
            setRuntime(RUNTIME_EDEFAULT);
            return;
        case RtPackage.RT_TASK__PAST_VALUES_COUNT:
            setPastValuesCount(PAST_VALUES_COUNT_EDEFAULT);
            return;
        case RtPackage.RT_TASK__COMMENT:
            setComment(COMMENT_EDEFAULT);
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
        case RtPackage.RT_TASK__MODULE:
            return getModule() != null;
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
            return moduleInvocations != null && !moduleInvocations.isEmpty();
        case RtPackage.RT_TASK__ID:
            return id != ID_EDEFAULT;
        case RtPackage.RT_TASK__CYCL_TIME:
            return cyclTime != CYCL_TIME_EDEFAULT;
        case RtPackage.RT_TASK__SEGMENT:
            return segment != SEGMENT_EDEFAULT;
        case RtPackage.RT_TASK__PAST_VALUES_OFFSET:
            return pastValuesOffset != PAST_VALUES_OFFSET_EDEFAULT;
        case RtPackage.RT_TASK__STRATEGY:
            return strategy != STRATEGY_EDEFAULT;
        case RtPackage.RT_TASK__DATA:
            return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
        case RtPackage.RT_TASK__RUNTIME:
            return runtime != RUNTIME_EDEFAULT;
        case RtPackage.RT_TASK__PAST_VALUES_COUNT:
            return pastValuesCount != PAST_VALUES_COUNT_EDEFAULT;
        case RtPackage.RT_TASK__COMMENT:
            return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
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
        result.append(" (id: ");
        result.append(id);
        result.append(", cyclTime: ");
        result.append(cyclTime);
        result.append(", segment: ");
        result.append(segment);
        result.append(", pastValuesOffset: ");
        result.append(pastValuesOffset);
        result.append(", strategy: ");
        result.append(strategy);
        result.append(", data: ");
        result.append(data);
        result.append(", runtime: ");
        result.append(runtime);
        result.append(", pastValuesCount: ");
        result.append(pastValuesCount);
        result.append(", comment: ");
        result.append(comment);
        result.append(')');
        return result.toString();
    }

} // RtTaskImpl
