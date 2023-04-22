/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesFactory;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Parameter;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class HwmodulesFactoryImpl extends EFactoryImpl implements HwmodulesFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static HwmodulesFactory init() {
        try {
            HwmodulesFactory theHwmodulesFactory = (HwmodulesFactory) EPackage.Registry.INSTANCE
                    .getEFactory(HwmodulesPackage.eNS_URI);
            if (theHwmodulesFactory != null) {
                return theHwmodulesFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new HwmodulesFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public HwmodulesFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION:
            return createHardwareTypeDefinition();
        case HwmodulesPackage.HARDWARE_ALIAS:
            return createHardwareAlias();
        case HwmodulesPackage.MODULE_DEFINITION:
            return createModuleDefinition();
        case HwmodulesPackage.PORT:
            return createPort();
        case HwmodulesPackage.PORT_GROUP:
            return createPortGroup();
        case HwmodulesPackage.MICAS_MODULES:
            return createMicasModules();
        case HwmodulesPackage.PARAMETER:
            return createParameter();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case HwmodulesPackage.HARDWARE_TYPE:
            return createHardwareTypeFromString(eDataType, initialValue);
        case HwmodulesPackage.PORT_DATA_TYPE:
            return createPortDataTypeFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case HwmodulesPackage.HARDWARE_TYPE:
            return convertHardwareTypeToString(eDataType, instanceValue);
        case HwmodulesPackage.PORT_DATA_TYPE:
            return convertPortDataTypeToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ModuleDefinition createModuleDefinition() {
        ModuleDefinitionImpl moduleDefinition = new ModuleDefinitionImpl();
        return moduleDefinition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Port createPort() {
        PortImpl port = new PortImpl();
        return port;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PortGroup createPortGroup() {
        PortGroupImpl portGroup = new PortGroupImpl();
        return portGroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MicasModules createMicasModules() {
        MicasModulesImpl micasModules = new MicasModulesImpl();
        return micasModules;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HardwareTypeDefinition createHardwareTypeDefinition() {
        HardwareTypeDefinitionImpl hardwareTypeDefinition = new HardwareTypeDefinitionImpl();
        return hardwareTypeDefinition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HardwareAlias createHardwareAlias() {
        HardwareAliasImpl hardwareAlias = new HardwareAliasImpl();
        return hardwareAlias;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PortDataType createPortDataTypeFromString(EDataType eDataType, String initialValue) {
        PortDataType result = PortDataType.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException(
                    "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertPortDataTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public HardwareType createHardwareTypeFromString(EDataType eDataType, String initialValue) {
        HardwareType result = HardwareType.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException(
                    "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertHardwareTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HwmodulesPackage getHwmodulesPackage() {
        return (HwmodulesPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static HwmodulesPackage getPackage() {
        return HwmodulesPackage.eINSTANCE;
    }

} // HwmodulesFactoryImpl
