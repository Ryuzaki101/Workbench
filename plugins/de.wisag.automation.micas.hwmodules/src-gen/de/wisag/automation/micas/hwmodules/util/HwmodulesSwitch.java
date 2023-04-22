/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Parameter;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortGroup;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage
 * @generated
 */
public class HwmodulesSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static HwmodulesPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public HwmodulesSwitch() {
        if (modelPackage == null) {
            modelPackage = HwmodulesPackage.eINSTANCE;
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
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION: {
            HardwareTypeDefinition hardwareTypeDefinition = (HardwareTypeDefinition) theEObject;
            T result = caseHardwareTypeDefinition(hardwareTypeDefinition);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case HwmodulesPackage.HARDWARE_ALIAS: {
            HardwareAlias hardwareAlias = (HardwareAlias) theEObject;
            T result = caseHardwareAlias(hardwareAlias);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case HwmodulesPackage.MODULE_DEFINITION: {
            ModuleDefinition moduleDefinition = (ModuleDefinition) theEObject;
            T result = caseModuleDefinition(moduleDefinition);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case HwmodulesPackage.PORT: {
            Port port = (Port) theEObject;
            T result = casePort(port);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case HwmodulesPackage.PORT_GROUP: {
            PortGroup portGroup = (PortGroup) theEObject;
            T result = casePortGroup(portGroup);
            if (result == null) {
                result = casePort(portGroup);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case HwmodulesPackage.MICAS_MODULES: {
            MicasModules micasModules = (MicasModules) theEObject;
            T result = caseMicasModules(micasModules);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case HwmodulesPackage.PARAMETER: {
            Parameter parameter = (Parameter) theEObject;
            T result = caseParameter(parameter);
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
     * '<em>Module Definition</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Module Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModuleDefinition(ModuleDefinition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Port</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Port</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePort(Port object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Port
     * Group</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Port
     *         Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePortGroup(PortGroup object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Micas Modules</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Micas Modules</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMicasModules(MicasModules object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Parameter</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameter(Parameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Hardware Type Definition</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Hardware Type Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHardwareTypeDefinition(HardwareTypeDefinition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Hardware Alias</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Hardware Alias</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHardwareAlias(HardwareAlias object) {
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

} // HwmodulesSwitch
