/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Port</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortImpl#getIndex
 * <em>Index</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortImpl#getAllowedPortDataTypes
 * <em>Allowed Port Data Types</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortImpl#isInputPort
 * <em>Input Port</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortImpl#getDisplayName
 * <em>Display Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.impl.PortImpl#getDescription
 * <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortImpl extends EObjectImpl implements Port {
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
     * The cached value of the '{@link #getAllowedPortDataTypes() <em>Allowed
     * Port Data Types</em>}' attribute list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAllowedPortDataTypes()
     * @generated
     * @ordered
     */
    protected EList<PortDataType> allowedPortDataTypes;

    /**
     * The default value of the '{@link #isInputPort() <em>Input Port</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isInputPort()
     * @generated
     * @ordered
     */
    protected static final boolean INPUT_PORT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isInputPort() <em>Input Port</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isInputPort()
     * @generated
     * @ordered
     */
    protected boolean inputPort = INPUT_PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "n/a";

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PortImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HwmodulesPackage.Literals.PORT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.PORT__INDEX, oldIndex, index));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<PortDataType> getAllowedPortDataTypes() {
        if (allowedPortDataTypes == null) {
            allowedPortDataTypes = new EDataTypeUniqueEList<>(PortDataType.class, this,
                    HwmodulesPackage.PORT__ALLOWED_PORT_DATA_TYPES);
        }
        return allowedPortDataTypes;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isInputPort() {
        return inputPort;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInputPort(boolean newInputPort) {
        boolean oldInputPort = inputPort;
        inputPort = newInputPort;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.PORT__INPUT_PORT, oldInputPort,
                    inputPort));
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.PORT__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.PORT__DISPLAY_NAME, oldDisplayName,
                    displayName));
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
            eNotify(new ENotificationImpl(this, Notification.SET, HwmodulesPackage.PORT__DESCRIPTION, oldDescription,
                    description));
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
        case HwmodulesPackage.PORT__INDEX:
            return getIndex();
        case HwmodulesPackage.PORT__ALLOWED_PORT_DATA_TYPES:
            return getAllowedPortDataTypes();
        case HwmodulesPackage.PORT__INPUT_PORT:
            return isInputPort();
        case HwmodulesPackage.PORT__NAME:
            return getName();
        case HwmodulesPackage.PORT__DISPLAY_NAME:
            return getDisplayName();
        case HwmodulesPackage.PORT__DESCRIPTION:
            return getDescription();
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
        case HwmodulesPackage.PORT__INDEX:
            setIndex((Integer) newValue);
            return;
        case HwmodulesPackage.PORT__ALLOWED_PORT_DATA_TYPES:
            getAllowedPortDataTypes().clear();
            getAllowedPortDataTypes().addAll((Collection<? extends PortDataType>) newValue);
            return;
        case HwmodulesPackage.PORT__INPUT_PORT:
            setInputPort((Boolean) newValue);
            return;
        case HwmodulesPackage.PORT__NAME:
            setName((String) newValue);
            return;
        case HwmodulesPackage.PORT__DISPLAY_NAME:
            setDisplayName((String) newValue);
            return;
        case HwmodulesPackage.PORT__DESCRIPTION:
            setDescription((String) newValue);
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
        case HwmodulesPackage.PORT__INDEX:
            setIndex(INDEX_EDEFAULT);
            return;
        case HwmodulesPackage.PORT__ALLOWED_PORT_DATA_TYPES:
            getAllowedPortDataTypes().clear();
            return;
        case HwmodulesPackage.PORT__INPUT_PORT:
            setInputPort(INPUT_PORT_EDEFAULT);
            return;
        case HwmodulesPackage.PORT__NAME:
            setName(NAME_EDEFAULT);
            return;
        case HwmodulesPackage.PORT__DISPLAY_NAME:
            setDisplayName(DISPLAY_NAME_EDEFAULT);
            return;
        case HwmodulesPackage.PORT__DESCRIPTION:
            setDescription(DESCRIPTION_EDEFAULT);
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
        case HwmodulesPackage.PORT__INDEX:
            return index != INDEX_EDEFAULT;
        case HwmodulesPackage.PORT__ALLOWED_PORT_DATA_TYPES:
            return allowedPortDataTypes != null && !allowedPortDataTypes.isEmpty();
        case HwmodulesPackage.PORT__INPUT_PORT:
            return inputPort != INPUT_PORT_EDEFAULT;
        case HwmodulesPackage.PORT__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case HwmodulesPackage.PORT__DISPLAY_NAME:
            return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
        case HwmodulesPackage.PORT__DESCRIPTION:
            return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
        result.append(", allowedPortDataTypes: ");
        result.append(allowedPortDataTypes);
        result.append(", inputPort: ");
        result.append(inputPort);
        result.append(", name: ");
        result.append(name);
        result.append(", displayName: ");
        result.append(displayName);
        result.append(", description: ");
        result.append(description);
        result.append(')');
        return result.toString();
    }

} // PortImpl
