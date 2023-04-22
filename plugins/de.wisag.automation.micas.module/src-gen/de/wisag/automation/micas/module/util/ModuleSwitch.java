/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.SignalSpecification;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.OffpageConnector;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.Value;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 *
 * @see de.wisag.automation.micas.module.ModulePackage
 * @generated
 */
public class ModuleSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ModulePackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ModuleSwitch() {
        if (modelPackage == null) {
            modelPackage = ModulePackage.eINSTANCE;
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
        case ModulePackage.MODULE: {
            Module module = (Module) theEObject;
            T result = caseModule(module);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.ATTRIBUTE: {
            Attribute attribute = (Attribute) theEObject;
            T result = caseAttribute(attribute);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.TASK: {
            Task task = (Task) theEObject;
            T result = caseTask(task);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.VARIABLE_ATTRIBUTE: {
            VariableAttribute variableAttribute = (VariableAttribute) theEObject;
            T result = caseVariableAttribute(variableAttribute);
            if (result == null) {
                result = caseAttribute(variableAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.CONSTANT_ATTRIBUTE: {
            ConstantAttribute constantAttribute = (ConstantAttribute) theEObject;
            T result = caseConstantAttribute(constantAttribute);
            if (result == null) {
                result = caseAttribute(constantAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.REFERENCE_ATTRIBUTE: {
            ReferenceAttribute referenceAttribute = (ReferenceAttribute) theEObject;
            T result = caseReferenceAttribute(referenceAttribute);
            if (result == null) {
                result = caseAttribute(referenceAttribute);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.VALUE: {
            Value value = (Value) theEObject;
            T result = caseValue(value);
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.FLOAT_VALUE: {
            FloatValue floatValue = (FloatValue) theEObject;
            T result = caseFloatValue(floatValue);
            if (result == null) {
                result = caseValue(floatValue);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.WORD_VALUE: {
            WordValue wordValue = (WordValue) theEObject;
            T result = caseWordValue(wordValue);
            if (result == null) {
                result = caseValue(wordValue);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.ATTRIBUTE_SPECIFICATION: {
            AttributeSpecification attributeSpecification = (AttributeSpecification) theEObject;
            T result = caseAttributeSpecification(attributeSpecification);
            if (result == null) {
                result = caseSignalSpecification(attributeSpecification);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.MICAS_DATA_TYPE_SPECIFICATION: {
            MicasDataTypeSpecification micasDataTypeSpecification = (MicasDataTypeSpecification) theEObject;
            T result = caseMicasDataTypeSpecification(micasDataTypeSpecification);
            if (result == null) {
                result = caseDataTypeSpecification(micasDataTypeSpecification);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.PAGE: {
            Page page = (Page) theEObject;
            T result = casePage(page);
            if (result == null) {
                result = caseSystem(page);
            }
            if (result == null) {
                result = caseFragment(page);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.OFFPAGE_CONNECTOR: {
            OffpageConnector offpageConnector = (OffpageConnector) theEObject;
            T result = caseOffpageConnector(offpageConnector);
            if (result == null) {
                result = caseComponent(offpageConnector);
            }
            if (result == null) {
                result = caseFragmentElement(offpageConnector);
            }
            if (result == null) {
                result = caseCompoundMember(offpageConnector);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.INCOMING_OFFPAGE_CONNECTOR: {
            IncomingOffpageConnector incomingOffpageConnector = (IncomingOffpageConnector) theEObject;
            T result = caseIncomingOffpageConnector(incomingOffpageConnector);
            if (result == null) {
                result = caseOffpageConnector(incomingOffpageConnector);
            }
            if (result == null) {
                result = caseComponent(incomingOffpageConnector);
            }
            if (result == null) {
                result = caseFragmentElement(incomingOffpageConnector);
            }
            if (result == null) {
                result = caseCompoundMember(incomingOffpageConnector);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.OUTGOING_OFFPAGE_CONNECTOR: {
            OutgoingOffpageConnector outgoingOffpageConnector = (OutgoingOffpageConnector) theEObject;
            T result = caseOutgoingOffpageConnector(outgoingOffpageConnector);
            if (result == null) {
                result = caseOffpageConnector(outgoingOffpageConnector);
            }
            if (result == null) {
                result = caseComponent(outgoingOffpageConnector);
            }
            if (result == null) {
                result = caseFragmentElement(outgoingOffpageConnector);
            }
            if (result == null) {
                result = caseCompoundMember(outgoingOffpageConnector);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.CONSTANT: {
            Constant constant = (Constant) theEObject;
            T result = caseConstant(constant);
            if (result == null) {
                result = caseComponent(constant);
            }
            if (result == null) {
                result = caseFragmentElement(constant);
            }
            if (result == null) {
                result = caseCompoundMember(constant);
            }
            if (result == null) {
                result = defaultCase(theEObject);
            }
            return result;
        }
        case ModulePackage.REFERENCE: {
            Reference reference = (Reference) theEObject;
            T result = caseReference(reference);
            if (result == null) {
                result = caseComponent(reference);
            }
            if (result == null) {
                result = caseFragmentElement(reference);
            }
            if (result == null) {
                result = caseCompoundMember(reference);
            }
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
    public T caseModule(Module object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Attribute</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttribute(Attribute object) {
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
    public T caseTask(Task object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Variable Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Variable Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariableAttribute(VariableAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Constant Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Constant Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConstantAttribute(ConstantAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Reference Attribute</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Reference Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReferenceAttribute(ReferenceAttribute object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Value</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValue(Value object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Float Value</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Float Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFloatValue(FloatValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Word
     * Value</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Word
     *         Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWordValue(WordValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Attribute Specification</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Attribute Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributeSpecification(AttributeSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Micas Data Type Specification</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Micas Data Type Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMicasDataTypeSpecification(MicasDataTypeSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Page</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Page</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePage(Page object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Offpage Connector</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Offpage Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOffpageConnector(OffpageConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Incoming Offpage Connector</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Incoming Offpage Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIncomingOffpageConnector(IncomingOffpageConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Outgoing Offpage Connector</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Outgoing Offpage Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOutgoingOffpageConnector(OutgoingOffpageConnector object) {
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
    public T caseConstant(Constant object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReference(Reference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Signal Specification</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate
     * the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Signal Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSignalSpecification(SignalSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data
     * Type Specification</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data
     *         Type Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataTypeSpecification(DataTypeSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Fragment</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Fragment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFragment(Fragment object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>System</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>System</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystem(org.eclipselabs.damos.dml.System object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Fragment Element</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Fragment Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFragmentElement(FragmentElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Compound Member</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Compound Member</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompoundMember(CompoundMember object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Component</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponent(Component object) {
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

} // ModuleSwitch
