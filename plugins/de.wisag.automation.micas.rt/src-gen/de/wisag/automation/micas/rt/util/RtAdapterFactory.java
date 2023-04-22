/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.rt.RtCommentModuleInvocation;
import de.wisag.automation.micas.rt.RtConstant;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtHeadModule;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskInfo;
import de.wisag.automation.micas.rt.RtVariable;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 *
 * @see de.wisag.automation.micas.rt.RtPackage
 * @generated
 */
public class RtAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static RtPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public RtAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RtPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RtSwitch<Adapter> modelSwitch = new RtSwitch<Adapter>() {
        @Override
        public Adapter caseRtModule(RtModule object) {
            return createRtModuleAdapter();
        }

        @Override
        public Adapter caseRtTask(RtTask object) {
            return createRtTaskAdapter();
        }

        @Override
        public Adapter caseRtSymbol(RtSymbol object) {
            return createRtSymbolAdapter();
        }

        @Override
        public Adapter caseRtConstant(RtConstant object) {
            return createRtConstantAdapter();
        }

        @Override
        public Adapter caseRtVariable(RtVariable object) {
            return createRtVariableAdapter();
        }

        @Override
        public Adapter caseRtWordConstant(RtWordConstant object) {
            return createRtWordConstantAdapter();
        }

        @Override
        public Adapter caseRtFloatConstant(RtFloatConstant object) {
            return createRtFloatConstantAdapter();
        }

        @Override
        public Adapter caseRtDirectValue(RtDirectValue object) {
            return createRtDirectValueAdapter();
        }

        @Override
        public Adapter caseRtWordVariable(RtWordVariable object) {
            return createRtWordVariableAdapter();
        }

        @Override
        public Adapter caseRtFloatVariable(RtFloatVariable object) {
            return createRtFloatVariableAdapter();
        }

        @Override
        public Adapter caseRtModuleInvocation(RtModuleInvocation object) {
            return createRtModuleInvocationAdapter();
        }

        @Override
        public Adapter caseRtCommentModuleInvocation(RtCommentModuleInvocation object) {
            return createRtCommentModuleInvocationAdapter();
        }

        @Override
        public Adapter caseRtReferenceConstant(RtReferenceConstant object) {
            return createRtReferenceConstantAdapter();
        }

        @Override
        public Adapter caseRtSymbolAccess(RtSymbolAccess object) {
            return createRtSymbolAccessAdapter();
        }

        @Override
        public Adapter caseRtHeadModule(RtHeadModule object) {
            return createRtHeadModuleAdapter();
        }

        @Override
        public Adapter caseRtTaskInfo(RtTaskInfo object) {
            return createRtTaskInfoAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtModule <em>Module</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtModule
     * @generated
     */
    public Adapter createRtModuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtTask <em>Task</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtTask
     * @generated
     */
    public Adapter createRtTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtSymbol <em>Symbol</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtSymbol
     * @generated
     */
    public Adapter createRtSymbolAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtConstant <em>Constant</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtConstant
     * @generated
     */
    public Adapter createRtConstantAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtVariable <em>Variable</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtVariable
     * @generated
     */
    public Adapter createRtVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtWordConstant <em>Word
     * Constant</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtWordConstant
     * @generated
     */
    public Adapter createRtWordConstantAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtFloatConstant <em>Float
     * Constant</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtFloatConstant
     * @generated
     */
    public Adapter createRtFloatConstantAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtDirectValue <em>Direct
     * Value</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtDirectValue
     * @generated
     */
    public Adapter createRtDirectValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtWordVariable <em>Word
     * Variable</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtWordVariable
     * @generated
     */
    public Adapter createRtWordVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtFloatVariable <em>Float
     * Variable</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtFloatVariable
     * @generated
     */
    public Adapter createRtFloatVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtModuleInvocation <em>Module
     * Invocation</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtModuleInvocation
     * @generated
     */
    public Adapter createRtModuleInvocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtCommentModuleInvocation
     * <em>Comment Module Invocation</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtCommentModuleInvocation
     * @generated
     */
    public Adapter createRtCommentModuleInvocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtReferenceConstant <em>Reference
     * Constant</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtReferenceConstant
     * @generated
     */
    public Adapter createRtReferenceConstantAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtSymbolAccess <em>Symbol
     * Access</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtSymbolAccess
     * @generated
     */
    public Adapter createRtSymbolAccessAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtHeadModule <em>Head Module</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtHeadModule
     * @generated
     */
    public Adapter createRtHeadModuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.rt.RtTaskInfo <em>Task Info</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.rt.RtTaskInfo
     * @generated
     */
    public Adapter createRtTaskInfoAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // RtAdapterFactory
