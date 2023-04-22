/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.wisag.automation.micas.rt.RtCommentModuleInvocation;
import de.wisag.automation.micas.rt.RtConstant;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtHeadModule;
import de.wisag.automation.micas.rt.RtHwType;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskInfo;
import de.wisag.automation.micas.rt.RtTaskStrategy;
import de.wisag.automation.micas.rt.RtVariable;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class RtFactoryImpl extends EFactoryImpl implements RtFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static RtFactory init() {
        try {
            RtFactory theRtFactory = (RtFactory) EPackage.Registry.INSTANCE.getEFactory(RtPackage.eNS_URI);
            if (theRtFactory != null) {
                return theRtFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RtFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public RtFactoryImpl() {
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
        case RtPackage.RT_MODULE:
            return createRtModule();
        case RtPackage.RT_TASK:
            return createRtTask();
        case RtPackage.RT_SYMBOL:
            return createRtSymbol();
        case RtPackage.RT_CONSTANT:
            return createRtConstant();
        case RtPackage.RT_VARIABLE:
            return createRtVariable();
        case RtPackage.RT_WORD_CONSTANT:
            return createRtWordConstant();
        case RtPackage.RT_FLOAT_CONSTANT:
            return createRtFloatConstant();
        case RtPackage.RT_DIRECT_VALUE:
            return createRtDirectValue();
        case RtPackage.RT_WORD_VARIABLE:
            return createRtWordVariable();
        case RtPackage.RT_FLOAT_VARIABLE:
            return createRtFloatVariable();
        case RtPackage.RT_MODULE_INVOCATION:
            return createRtModuleInvocation();
        case RtPackage.RT_COMMENT_MODULE_INVOCATION:
            return createRtCommentModuleInvocation();
        case RtPackage.RT_REFERENCE_CONSTANT:
            return createRtReferenceConstant();
        case RtPackage.RT_SYMBOL_ACCESS:
            return createRtSymbolAccess();
        case RtPackage.RT_HEAD_MODULE:
            return createRtHeadModule();
        case RtPackage.RT_TASK_INFO:
            return createRtTaskInfo();
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
        case RtPackage.RT_TASK_STRATEGY:
            return createRtTaskStrategyFromString(eDataType, initialValue);
        case RtPackage.RT_HW_TYPE:
            return createRtHwTypeFromString(eDataType, initialValue);
        case RtPackage.RT_SYMBOL_ACCESS_TYPE:
            return createRtSymbolAccessTypeFromString(eDataType, initialValue);
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
        case RtPackage.RT_TASK_STRATEGY:
            return convertRtTaskStrategyToString(eDataType, instanceValue);
        case RtPackage.RT_HW_TYPE:
            return convertRtHwTypeToString(eDataType, instanceValue);
        case RtPackage.RT_SYMBOL_ACCESS_TYPE:
            return convertRtSymbolAccessTypeToString(eDataType, instanceValue);
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
    public RtModule createRtModule() {
        RtModuleImpl rtModule = new RtModuleImpl();
        return rtModule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtTask createRtTask() {
        RtTaskImpl rtTask = new RtTaskImpl();
        return rtTask;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtSymbol createRtSymbol() {
        RtSymbolImpl rtSymbol = new RtSymbolImpl();
        return rtSymbol;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtConstant createRtConstant() {
        RtConstantImpl rtConstant = new RtConstantImpl();
        return rtConstant;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtVariable createRtVariable() {
        RtVariableImpl rtVariable = new RtVariableImpl();
        return rtVariable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtWordConstant createRtWordConstant() {
        RtWordConstantImpl rtWordConstant = new RtWordConstantImpl();
        return rtWordConstant;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtFloatConstant createRtFloatConstant() {
        RtFloatConstantImpl rtFloatConstant = new RtFloatConstantImpl();
        return rtFloatConstant;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtDirectValue createRtDirectValue() {
        RtDirectValueImpl rtDirectValue = new RtDirectValueImpl();
        return rtDirectValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtWordVariable createRtWordVariable() {
        RtWordVariableImpl rtWordVariable = new RtWordVariableImpl();
        return rtWordVariable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtFloatVariable createRtFloatVariable() {
        RtFloatVariableImpl rtFloatVariable = new RtFloatVariableImpl();
        return rtFloatVariable;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtModuleInvocation createRtModuleInvocation() {
        RtModuleInvocationImpl rtModuleInvocation = new RtModuleInvocationImpl();
        return rtModuleInvocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtCommentModuleInvocation createRtCommentModuleInvocation() {
        RtCommentModuleInvocationImpl rtCommentModuleInvocation = new RtCommentModuleInvocationImpl();
        return rtCommentModuleInvocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtReferenceConstant createRtReferenceConstant() {
        RtReferenceConstantImpl rtReferenceConstant = new RtReferenceConstantImpl();
        return rtReferenceConstant;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtSymbolAccess createRtSymbolAccess() {
        RtSymbolAccessImpl rtSymbolAccess = new RtSymbolAccessImpl();
        return rtSymbolAccess;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtHeadModule createRtHeadModule() {
        RtHeadModuleImpl rtHeadModule = new RtHeadModuleImpl();
        return rtHeadModule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtTaskInfo createRtTaskInfo() {
        RtTaskInfoImpl rtTaskInfo = new RtTaskInfoImpl();
        return rtTaskInfo;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtTaskStrategy createRtTaskStrategyFromString(EDataType eDataType, String initialValue) {
        RtTaskStrategy result = RtTaskStrategy.get(initialValue);
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
    public String convertRtTaskStrategyToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtHwType createRtHwTypeFromString(EDataType eDataType, String initialValue) {
        RtHwType result = RtHwType.get(initialValue);
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
    public String convertRtHwTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtSymbolAccessType createRtSymbolAccessTypeFromString(EDataType eDataType, String initialValue) {
        RtSymbolAccessType result = RtSymbolAccessType.get(initialValue);
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
    public String convertRtSymbolAccessTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RtPackage getRtPackage() {
        return (RtPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RtPackage getPackage() {
        return RtPackage.eINSTANCE;
    }

} // RtFactoryImpl
