/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModuleKind;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.PageFormat;
import de.wisag.automation.micas.module.PageOrientation;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ModuleFactoryImpl extends EFactoryImpl implements ModuleFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static ModuleFactory init() {
        try {
            ModuleFactory theModuleFactory = (ModuleFactory) EPackage.Registry.INSTANCE
                    .getEFactory(ModulePackage.eNS_URI);
            if (theModuleFactory != null) {
                return theModuleFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ModuleFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ModuleFactoryImpl() {
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
        case ModulePackage.MODULE:
            return createModule();
        case ModulePackage.TASK:
            return createTask();
        case ModulePackage.VARIABLE_ATTRIBUTE:
            return createVariableAttribute();
        case ModulePackage.CONSTANT_ATTRIBUTE:
            return createConstantAttribute();
        case ModulePackage.REFERENCE_ATTRIBUTE:
            return createReferenceAttribute();
        case ModulePackage.FLOAT_VALUE:
            return createFloatValue();
        case ModulePackage.WORD_VALUE:
            return createWordValue();
        case ModulePackage.ATTRIBUTE_SPECIFICATION:
            return createAttributeSpecification();
        case ModulePackage.MICAS_DATA_TYPE_SPECIFICATION:
            return createMicasDataTypeSpecification();
        case ModulePackage.PAGE:
            return createPage();
        case ModulePackage.INCOMING_OFFPAGE_CONNECTOR:
            return createIncomingOffpageConnector();
        case ModulePackage.OUTGOING_OFFPAGE_CONNECTOR:
            return createOutgoingOffpageConnector();
        case ModulePackage.CONSTANT:
            return createConstant();
        case ModulePackage.REFERENCE:
            return createReference();
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
        case ModulePackage.MODULE_KIND:
            return createModuleKindFromString(eDataType, initialValue);
        case ModulePackage.DATA_TYPE:
            return createDataTypeFromString(eDataType, initialValue);
        case ModulePackage.REFERENCE_TYPE:
            return createReferenceTypeFromString(eDataType, initialValue);
        case ModulePackage.TASK_KIND:
            return createTaskKindFromString(eDataType, initialValue);
        case ModulePackage.PAGE_FORMAT:
            return createPageFormatFromString(eDataType, initialValue);
        case ModulePackage.PAGE_ORIENTATION:
            return createPageOrientationFromString(eDataType, initialValue);
        case ModulePackage.FLOAT:
            return createFloatFromString(eDataType, initialValue);
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
        case ModulePackage.MODULE_KIND:
            return convertModuleKindToString(eDataType, instanceValue);
        case ModulePackage.DATA_TYPE:
            return convertDataTypeToString(eDataType, instanceValue);
        case ModulePackage.REFERENCE_TYPE:
            return convertReferenceTypeToString(eDataType, instanceValue);
        case ModulePackage.TASK_KIND:
            return convertTaskKindToString(eDataType, instanceValue);
        case ModulePackage.PAGE_FORMAT:
            return convertPageFormatToString(eDataType, instanceValue);
        case ModulePackage.PAGE_ORIENTATION:
            return convertPageOrientationToString(eDataType, instanceValue);
        case ModulePackage.FLOAT:
            return convertFloatToString(eDataType, instanceValue);
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
    public Module createModule() {
        ModuleImpl module = new ModuleImpl();
        return module;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Task createTask() {
        TaskImpl task = new TaskImpl();
        return task;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public VariableAttribute createVariableAttribute() {
        VariableAttributeImpl variableAttribute = new VariableAttributeImpl();
        return variableAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ConstantAttribute createConstantAttribute() {
        ConstantAttributeImpl constantAttribute = new ConstantAttributeImpl();
        return constantAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ReferenceAttribute createReferenceAttribute() {
        ReferenceAttributeImpl referenceAttribute = new ReferenceAttributeImpl();
        return referenceAttribute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public FloatValue createFloatValue() {
        FloatValueImpl floatValue = new FloatValueImpl();
        return floatValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public WordValue createWordValue() {
        WordValueImpl wordValue = new WordValueImpl();
        return wordValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AttributeSpecification createAttributeSpecification() {
        AttributeSpecificationImpl attributeSpecification = new AttributeSpecificationImpl();
        return attributeSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public MicasDataTypeSpecification createMicasDataTypeSpecification() {
        MicasDataTypeSpecificationImpl micasDataTypeSpecification = new MicasDataTypeSpecificationImpl();
        return micasDataTypeSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Page createPage() {
        PageImpl page = new PageImpl();
        return page;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public IncomingOffpageConnector createIncomingOffpageConnector() {
        IncomingOffpageConnectorImpl incomingOffpageConnector = new IncomingOffpageConnectorImpl();
        return incomingOffpageConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OutgoingOffpageConnector createOutgoingOffpageConnector() {
        OutgoingOffpageConnectorImpl outgoingOffpageConnector = new OutgoingOffpageConnectorImpl();
        return outgoingOffpageConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Constant createConstant() {
        ConstantImpl constant = new ConstantImpl();
        return constant;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Reference createReference() {
        ReferenceImpl reference = new ReferenceImpl();
        return reference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ModuleKind createModuleKindFromString(EDataType eDataType, String initialValue) {
        ModuleKind result = ModuleKind.get(initialValue);
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
    public String convertModuleKindToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
        DataType result = DataType.get(initialValue);
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
    public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ReferenceType createReferenceTypeFromString(EDataType eDataType, String initialValue) {
        ReferenceType result = ReferenceType.get(initialValue);
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
    public String convertReferenceTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public TaskKind createTaskKindFromString(EDataType eDataType, String initialValue) {
        TaskKind result = TaskKind.get(initialValue);
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
    public String convertTaskKindToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PageFormat createPageFormatFromString(EDataType eDataType, String initialValue) {
        PageFormat result = PageFormat.get(initialValue);
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
    public String convertPageFormatToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PageOrientation createPageOrientationFromString(EDataType eDataType, String initialValue) {
        PageOrientation result = PageOrientation.get(initialValue);
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
    public String convertPageOrientationToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Double createFloatFromString(EDataType eDataType, String initialValue) {
        return (Double) super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public String convertFloatToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ModulePackage getModulePackage() {
        return (ModulePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ModulePackage getPackage() {
        return ModulePackage.eINSTANCE;
    }

} // ModuleFactoryImpl
