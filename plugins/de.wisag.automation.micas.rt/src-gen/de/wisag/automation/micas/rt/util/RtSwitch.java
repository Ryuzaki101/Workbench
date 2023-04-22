/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.rt.RtPackage
 * @generated
 */
public class RtSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static RtPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public RtSwitch() {
        if (modelPackage == null) {
            modelPackage = RtPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case RtPackage.RT_MODULE: {
            RtModule rtModule = (RtModule) theEObject;
            T result = caseRtModule(rtModule);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_TASK: {
            RtTask rtTask = (RtTask) theEObject;
            T result = caseRtTask(rtTask);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_SYMBOL: {
            RtSymbol rtSymbol = (RtSymbol) theEObject;
            T result = caseRtSymbol(rtSymbol);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_CONSTANT: {
            RtConstant rtConstant = (RtConstant) theEObject;
            T result = caseRtConstant(rtConstant);
            if (result == null) {
                result = caseRtSymbol(rtConstant);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_VARIABLE: {
            RtVariable rtVariable = (RtVariable) theEObject;
            T result = caseRtVariable(rtVariable);
            if (result == null) {
                result = caseRtSymbol(rtVariable);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_WORD_CONSTANT: {
            RtWordConstant rtWordConstant = (RtWordConstant) theEObject;
            T result = caseRtWordConstant(rtWordConstant);
            if (result == null) {
                result = caseRtConstant(rtWordConstant);
            }
            if (result == null) {
                result = caseRtSymbol(rtWordConstant);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_FLOAT_CONSTANT: {
            RtFloatConstant rtFloatConstant = (RtFloatConstant) theEObject;
            T result = caseRtFloatConstant(rtFloatConstant);
            if (result == null) {
                result = caseRtConstant(rtFloatConstant);
            }
            if (result == null) {
                result = caseRtSymbol(rtFloatConstant);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_DIRECT_VALUE: {
            RtDirectValue rtDirectValue = (RtDirectValue) theEObject;
            T result = caseRtDirectValue(rtDirectValue);
            if (result == null) {
                result = caseRtSymbol(rtDirectValue);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_WORD_VARIABLE: {
            RtWordVariable rtWordVariable = (RtWordVariable) theEObject;
            T result = caseRtWordVariable(rtWordVariable);
            if (result == null) {
                result = caseRtVariable(rtWordVariable);
            }
            if (result == null) {
                result = caseRtSymbol(rtWordVariable);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_FLOAT_VARIABLE: {
            RtFloatVariable rtFloatVariable = (RtFloatVariable) theEObject;
            T result = caseRtFloatVariable(rtFloatVariable);
            if (result == null) {
                result = caseRtVariable(rtFloatVariable);
            }
            if (result == null) {
                result = caseRtSymbol(rtFloatVariable);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_MODULE_INVOCATION: {
            RtModuleInvocation rtModuleInvocation = (RtModuleInvocation) theEObject;
            T result = caseRtModuleInvocation(rtModuleInvocation);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_COMMENT_MODULE_INVOCATION: {
            RtCommentModuleInvocation rtCommentModuleInvocation = (RtCommentModuleInvocation) theEObject;
            T result = caseRtCommentModuleInvocation(rtCommentModuleInvocation);
            if (result == null) {
                result = caseRtModuleInvocation(rtCommentModuleInvocation);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_REFERENCE_CONSTANT: {
            RtReferenceConstant rtReferenceConstant = (RtReferenceConstant) theEObject;
            T result = caseRtReferenceConstant(rtReferenceConstant);
            if (result == null) {
                result = caseRtConstant(rtReferenceConstant);
            }
            if (result == null) {
                result = caseRtSymbol(rtReferenceConstant);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_SYMBOL_ACCESS: {
            RtSymbolAccess rtSymbolAccess = (RtSymbolAccess) theEObject;
            T result = caseRtSymbolAccess(rtSymbolAccess);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_HEAD_MODULE: {
            RtHeadModule rtHeadModule = (RtHeadModule) theEObject;
            T result = caseRtHeadModule(rtHeadModule);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case RtPackage.RT_TASK_INFO: {
            RtTaskInfo rtTaskInfo = (RtTaskInfo) theEObject;
            T result = caseRtTaskInfo(rtTaskInfo);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Module</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtModule(RtModule object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Task</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtTask(RtTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Symbol</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Symbol</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtSymbol(RtSymbol object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Constant</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtConstant(RtConstant object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Variable</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtVariable(RtVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Word
     * Constant</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Word
     *         Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtWordConstant(RtWordConstant object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Float Constant</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Float Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtFloatConstant(RtFloatConstant object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Direct Value</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Direct Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtDirectValue(RtDirectValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Word
     * Variable</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Word
     *         Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtWordVariable(RtWordVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Float Variable</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Float Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtFloatVariable(RtFloatVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Module Invocation</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Module Invocation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtModuleInvocation(RtModuleInvocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Comment Module Invocation</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Comment Module Invocation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtCommentModuleInvocation(RtCommentModuleInvocation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Reference Constant</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Reference Constant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtReferenceConstant(RtReferenceConstant object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Symbol Access</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Symbol Access</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtSymbolAccess(RtSymbolAccess object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Head
     * Module</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Head
     *         Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtHeadModule(RtHeadModule object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task
     * Info</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task
     *         Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRtTaskInfo(RtTaskInfo object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch, but this is
     * the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // RtSwitch
