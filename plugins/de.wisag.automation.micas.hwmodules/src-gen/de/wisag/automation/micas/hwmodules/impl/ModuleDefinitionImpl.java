/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Parameter;
import de.wisag.automation.micas.hwmodules.Port;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Module
 * Definition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getId
 * <em>Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getInputs
 * <em>Inputs</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getOutputs
 * <em>Outputs</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getRuntime
 * <em>Runtime</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getPastValueCount
 * <em>Past Value Count</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getDisplayName
 * <em>Display Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getDescription
 * <em>Description</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getSupportedByHardware
 * <em>Supported By Hardware</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getCategory
 * <em>Category</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getParameters
 * <em>Parameters</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getGroupId
 * <em>Group Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.ModuleDefinitionImpl#getRequireMicasVersion
 * <em>Require Micas Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleDefinitionImpl extends EObjectImpl implements ModuleDefinition {
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
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<Port> inputs;

    /**
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<Port> outputs;

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
     * The default value of the '{@link #getPastValueCount() <em>Past Value
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPastValueCount()
     * @generated
     * @ordered
     */
    protected static final int PAST_VALUE_COUNT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPastValueCount() <em>Past Value
     * Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPastValueCount()
     * @generated
     * @ordered
     */
    protected int pastValueCount = PAST_VALUE_COUNT_EDEFAULT;

    /**
     * The default value of the '{@link #getDisplayName() <em>Display
     * Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDisplayName()
     * @generated
     * @ordered
     */
    protected static final String DISPLAY_NAME_EDEFAULT = "n/a";

    /**
     * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDisplayName()
     * @generated
     * @ordered
     */
    protected String displayName = DISPLAY_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = "n/a";

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getSupportedByHardware() <em>Supported
     * By Hardware</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSupportedByHardware()
     * @generated
     * @ordered
     */
    protected EList<HardwareAlias> supportedByHardware;

    /**
     * The default value of the '{@link #getCategory() <em>Category</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCategory()
     * @generated
     * @ordered
     */
    protected static final String CATEGORY_EDEFAULT = "n/a";

    /**
     * The cached value of the '{@link #getCategory() <em>Category</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCategory()
     * @generated
     * @ordered
     */
    protected String category = CATEGORY_EDEFAULT;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<Parameter> parameters;

    /**
     * The default value of the '{@link #getGroupId() <em>Group Id</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGroupId()
     * @generated
     * @ordered
     */
    protected static final String GROUP_ID_EDEFAULT = "n/a";

    /**
     * The cached value of the '{@link #getGroupId() <em>Group Id</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGroupId()
     * @generated
     * @ordered
     */
    protected String groupId = GROUP_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getRequireMicasVersion() <em>Require
     * Micas Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getRequireMicasVersion()
     * @generated
     * @ordered
     */
    protected static final String REQUIRE_MICAS_VERSION_EDEFAULT = "n/a";

    /**
     * The cached value of the '{@link #getRequireMicasVersion() <em>Require
     * Micas Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getRequireMicasVersion()
     * @generated
     * @ordered
     */
    protected String requireMicasVersion = REQUIRE_MICAS_VERSION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ModuleDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HwmodulesPackage.Literals.MODULE_DEFINITION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__ID, oldId, id));
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__NAME, oldName,
                    name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Port> getInputs() {
        if (inputs == null) {
            inputs = new EObjectContainmentEList<>(Port.class, this, HwmodulesPackage.MODULE_DEFINITION__INPUTS);
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Port> getOutputs() {
        if (outputs == null) {
            outputs = new EObjectContainmentEList<>(Port.class, this, HwmodulesPackage.MODULE_DEFINITION__OUTPUTS);
        }
        return outputs;
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__RUNTIME,
                    oldRuntime, runtime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getPastValueCount() {
        return pastValueCount;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPastValueCount(int newPastValueCount) {
        int oldPastValueCount = pastValueCount;
        pastValueCount = newPastValueCount;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__PAST_VALUE_COUNT,
                    oldPastValueCount, pastValueCount));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDisplayName() {
        return displayName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDisplayName(String newDisplayName) {
        String oldDisplayName = displayName;
        displayName = newDisplayName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__DISPLAY_NAME,
                    oldDisplayName, displayName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__DESCRIPTION,
                    oldDescription, description));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<HardwareAlias> getSupportedByHardware() {
        if (supportedByHardware == null) {
            supportedByHardware = new EObjectResolvingEList<>(HardwareAlias.class, this,
                    HwmodulesPackage.MODULE_DEFINITION__SUPPORTED_BY_HARDWARE);
        }
        return supportedByHardware;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCategory(String newCategory) {
        String oldCategory = category;
        category = newCategory;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__CATEGORY,
                    oldCategory, category));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Parameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentEList<>(Parameter.class, this,
                    HwmodulesPackage.MODULE_DEFINITION__PARAMETERS);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getGroupId() {
        return groupId;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setGroupId(String newGroupId) {
        String oldGroupId = groupId;
        groupId = newGroupId;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.MODULE_DEFINITION__GROUP_ID,
                    oldGroupId, groupId));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getRequireMicasVersion() {
        return requireMicasVersion;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequireMicasVersion(String newRequireMicasVersion) {
        String oldRequireMicasVersion = requireMicasVersion;
        requireMicasVersion = newRequireMicasVersion;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HwmodulesPackage.MODULE_DEFINITION__REQUIRE_MICAS_VERSION, oldRequireMicasVersion,
                    requireMicasVersion));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getPortGroupsCount() {
        return ModuleUtils.getPortGroupsCount(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getPortsCount() {
        return ModuleUtils.getPortsCount(this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case HwmodulesPackage.MODULE_DEFINITION__INPUTS:
            return ((InternalEList<?>) getInputs()).basicRemove(otherEnd, msgs);
        case HwmodulesPackage.MODULE_DEFINITION__OUTPUTS:
            return ((InternalEList<?>) getOutputs()).basicRemove(otherEnd, msgs);
        case HwmodulesPackage.MODULE_DEFINITION__PARAMETERS:
            return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
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
        case HwmodulesPackage.MODULE_DEFINITION__ID:
            return getId();
        case HwmodulesPackage.MODULE_DEFINITION__NAME:
            return getName();
        case HwmodulesPackage.MODULE_DEFINITION__INPUTS:
            return getInputs();
        case HwmodulesPackage.MODULE_DEFINITION__OUTPUTS:
            return getOutputs();
        case HwmodulesPackage.MODULE_DEFINITION__RUNTIME:
            return getRuntime();
        case HwmodulesPackage.MODULE_DEFINITION__PAST_VALUE_COUNT:
            return getPastValueCount();
        case HwmodulesPackage.MODULE_DEFINITION__DISPLAY_NAME:
            return getDisplayName();
        case HwmodulesPackage.MODULE_DEFINITION__DESCRIPTION:
            return getDescription();
        case HwmodulesPackage.MODULE_DEFINITION__SUPPORTED_BY_HARDWARE:
            return getSupportedByHardware();
        case HwmodulesPackage.MODULE_DEFINITION__CATEGORY:
            return getCategory();
        case HwmodulesPackage.MODULE_DEFINITION__PARAMETERS:
            return getParameters();
        case HwmodulesPackage.MODULE_DEFINITION__GROUP_ID:
            return getGroupId();
        case HwmodulesPackage.MODULE_DEFINITION__REQUIRE_MICAS_VERSION:
            return getRequireMicasVersion();
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
        case HwmodulesPackage.MODULE_DEFINITION__ID:
            setId((Integer) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__NAME:
            setName((String) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__INPUTS:
            getInputs().clear();
            getInputs().addAll((Collection<? extends Port>) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__OUTPUTS:
            getOutputs().clear();
            getOutputs().addAll((Collection<? extends Port>) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__RUNTIME:
            setRuntime((Long) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__PAST_VALUE_COUNT:
            setPastValueCount((Integer) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__DISPLAY_NAME:
            setDisplayName((String) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__DESCRIPTION:
            setDescription((String) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__SUPPORTED_BY_HARDWARE:
            getSupportedByHardware().clear();
            getSupportedByHardware().addAll((Collection<? extends HardwareAlias>) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__CATEGORY:
            setCategory((String) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__PARAMETERS:
            getParameters().clear();
            getParameters().addAll((Collection<? extends Parameter>) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__GROUP_ID:
            setGroupId((String) newValue);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__REQUIRE_MICAS_VERSION:
            setRequireMicasVersion((String) newValue);
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
        case HwmodulesPackage.MODULE_DEFINITION__ID:
            setId(ID_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__NAME:
            setName(NAME_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__INPUTS:
            getInputs().clear();
            return;
        case HwmodulesPackage.MODULE_DEFINITION__OUTPUTS:
            getOutputs().clear();
            return;
        case HwmodulesPackage.MODULE_DEFINITION__RUNTIME:
            setRuntime(RUNTIME_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__PAST_VALUE_COUNT:
            setPastValueCount(PAST_VALUE_COUNT_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__DISPLAY_NAME:
            setDisplayName(DISPLAY_NAME_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__DESCRIPTION:
            setDescription(DESCRIPTION_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__SUPPORTED_BY_HARDWARE:
            getSupportedByHardware().clear();
            return;
        case HwmodulesPackage.MODULE_DEFINITION__CATEGORY:
            setCategory(CATEGORY_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__PARAMETERS:
            getParameters().clear();
            return;
        case HwmodulesPackage.MODULE_DEFINITION__GROUP_ID:
            setGroupId(GROUP_ID_EDEFAULT);
            return;
        case HwmodulesPackage.MODULE_DEFINITION__REQUIRE_MICAS_VERSION:
            setRequireMicasVersion(REQUIRE_MICAS_VERSION_EDEFAULT);
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
        case HwmodulesPackage.MODULE_DEFINITION__ID:
            return id != ID_EDEFAULT;
        case HwmodulesPackage.MODULE_DEFINITION__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case HwmodulesPackage.MODULE_DEFINITION__INPUTS:
            return inputs != null && !inputs.isEmpty();
        case HwmodulesPackage.MODULE_DEFINITION__OUTPUTS:
            return outputs != null && !outputs.isEmpty();
        case HwmodulesPackage.MODULE_DEFINITION__RUNTIME:
            return runtime != RUNTIME_EDEFAULT;
        case HwmodulesPackage.MODULE_DEFINITION__PAST_VALUE_COUNT:
            return pastValueCount != PAST_VALUE_COUNT_EDEFAULT;
        case HwmodulesPackage.MODULE_DEFINITION__DISPLAY_NAME:
            return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
        case HwmodulesPackage.MODULE_DEFINITION__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
        case HwmodulesPackage.MODULE_DEFINITION__SUPPORTED_BY_HARDWARE:
            return supportedByHardware != null && !supportedByHardware.isEmpty();
        case HwmodulesPackage.MODULE_DEFINITION__CATEGORY:
            return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
        case HwmodulesPackage.MODULE_DEFINITION__PARAMETERS:
            return parameters != null && !parameters.isEmpty();
        case HwmodulesPackage.MODULE_DEFINITION__GROUP_ID:
            return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
        case HwmodulesPackage.MODULE_DEFINITION__REQUIRE_MICAS_VERSION:
            return REQUIRE_MICAS_VERSION_EDEFAULT == null ? requireMicasVersion != null
                    : !REQUIRE_MICAS_VERSION_EDEFAULT.equals(requireMicasVersion);
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
        result.append(", name: ");
        result.append(name);
        result.append(", runtime: ");
        result.append(runtime);
        result.append(", pastValueCount: ");
        result.append(pastValueCount);
        result.append(", displayName: ");
        result.append(displayName);
        result.append(", description: ");
        result.append(description);
        result.append(", category: ");
        result.append(category);
        result.append(", groupId: ");
        result.append(groupId);
        result.append(", requireMicasVersion: ");
        result.append(requireMicasVersion);
        result.append(')');
        return result.toString();
    }

} // ModuleDefinitionImpl
