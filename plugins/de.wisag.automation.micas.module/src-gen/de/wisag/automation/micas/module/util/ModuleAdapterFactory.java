/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 *
 * @see de.wisag.automation.micas.module.ModulePackage
 * @generated
 */
public class ModuleAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ModulePackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ModuleAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ModulePackage.eINSTANCE;
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
    protected ModuleSwitch<Adapter> modelSwitch = new ModuleSwitch<Adapter>() {
        @Override
        public Adapter caseModule(Module object) {
            return createModuleAdapter();
        }

        @Override
        public Adapter caseAttribute(Attribute object) {
            return createAttributeAdapter();
        }

        @Override
        public Adapter caseTask(Task object) {
            return createTaskAdapter();
        }

        @Override
        public Adapter caseVariableAttribute(VariableAttribute object) {
            return createVariableAttributeAdapter();
        }

        @Override
        public Adapter caseConstantAttribute(ConstantAttribute object) {
            return createConstantAttributeAdapter();
        }

        @Override
        public Adapter caseReferenceAttribute(ReferenceAttribute object) {
            return createReferenceAttributeAdapter();
        }

        @Override
        public Adapter caseValue(Value object) {
            return createValueAdapter();
        }

        @Override
        public Adapter caseFloatValue(FloatValue object) {
            return createFloatValueAdapter();
        }

        @Override
        public Adapter caseWordValue(WordValue object) {
            return createWordValueAdapter();
        }

        @Override
        public Adapter caseAttributeSpecification(AttributeSpecification object) {
            return createAttributeSpecificationAdapter();
        }

        @Override
        public Adapter caseMicasDataTypeSpecification(MicasDataTypeSpecification object) {
            return createMicasDataTypeSpecificationAdapter();
        }

        @Override
        public Adapter casePage(Page object) {
            return createPageAdapter();
        }

        @Override
        public Adapter caseOffpageConnector(OffpageConnector object) {
            return createOffpageConnectorAdapter();
        }

        @Override
        public Adapter caseIncomingOffpageConnector(IncomingOffpageConnector object) {
            return createIncomingOffpageConnectorAdapter();
        }

        @Override
        public Adapter caseOutgoingOffpageConnector(OutgoingOffpageConnector object) {
            return createOutgoingOffpageConnectorAdapter();
        }

        @Override
        public Adapter caseConstant(Constant object) {
            return createConstantAdapter();
        }

        @Override
        public Adapter caseReference(Reference object) {
            return createReferenceAdapter();
        }

        @Override
        public Adapter caseSignalSpecification(SignalSpecification object) {
            return createSignalSpecificationAdapter();
        }

        @Override
        public Adapter caseDataTypeSpecification(DataTypeSpecification object) {
            return createDataTypeSpecificationAdapter();
        }

        @Override
        public Adapter caseFragment(Fragment object) {
            return createFragmentAdapter();
        }

        @Override
        public Adapter caseSystem(org.eclipselabs.damos.dml.System object) {
            return createSystemAdapter();
        }

        @Override
        public Adapter caseFragmentElement(FragmentElement object) {
            return createFragmentElementAdapter();
        }

        @Override
        public Adapter caseCompoundMember(CompoundMember object) {
            return createCompoundMemberAdapter();
        }

        @Override
        public Adapter caseComponent(Component object) {
            return createComponentAdapter();
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
     * '{@link de.wisag.automation.micas.module.Module <em>Module</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Module
     * @generated
     */
    public Adapter createModuleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Attribute
     * @generated
     */
    public Adapter createAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.Task <em>Task</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.VariableAttribute <em>Variable
     * Attribute</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.VariableAttribute
     * @generated
     */
    public Adapter createVariableAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.ConstantAttribute <em>Constant
     * Attribute</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.ConstantAttribute
     * @generated
     */
    public Adapter createConstantAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.ReferenceAttribute <em>Reference
     * Attribute</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.ReferenceAttribute
     * @generated
     */
    public Adapter createReferenceAttributeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.Value <em>Value</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Value
     * @generated
     */
    public Adapter createValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.FloatValue <em>Float
     * Value</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.FloatValue
     * @generated
     */
    public Adapter createFloatValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.WordValue <em>Word Value</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.WordValue
     * @generated
     */
    public Adapter createWordValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.AttributeSpecification
     * <em>Attribute Specification</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.AttributeSpecification
     * @generated
     */
    public Adapter createAttributeSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.MicasDataTypeSpecification
     * <em>Micas Data Type Specification</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.MicasDataTypeSpecification
     * @generated
     */
    public Adapter createMicasDataTypeSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.Page <em>Page</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Page
     * @generated
     */
    public Adapter createPageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.OffpageConnector <em>Offpage
     * Connector</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.OffpageConnector
     * @generated
     */
    public Adapter createOffpageConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.IncomingOffpageConnector
     * <em>Incoming Offpage Connector</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.IncomingOffpageConnector
     * @generated
     */
    public Adapter createIncomingOffpageConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.OutgoingOffpageConnector
     * <em>Outgoing Offpage Connector</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.OutgoingOffpageConnector
     * @generated
     */
    public Adapter createOutgoingOffpageConnectorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.Constant <em>Constant</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Constant
     * @generated
     */
    public Adapter createConstantAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.module.Reference <em>Reference</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.module.Reference
     * @generated
     */
    public Adapter createReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.SignalSpecification <em>Signal
     * Specification</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.SignalSpecification
     * @generated
     */
    public Adapter createSignalSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.DataTypeSpecification <em>Data Type
     * Specification</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.DataTypeSpecification
     * @generated
     */
    public Adapter createDataTypeSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.Fragment <em>Fragment</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.Fragment
     * @generated
     */
    public Adapter createFragmentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.System <em>System</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.System
     * @generated
     */
    public Adapter createSystemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.FragmentElement <em>Fragment
     * Element</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.FragmentElement
     * @generated
     */
    public Adapter createFragmentElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.CompoundMember <em>Compound
     * Member</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.CompoundMember
     * @generated
     */
    public Adapter createCompoundMemberAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link org.eclipselabs.damos.dml.Component <em>Component</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.eclipselabs.damos.dml.Component
     * @generated
     */
    public Adapter createComponentAdapter() {
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

} // ModuleAdapterFactory
