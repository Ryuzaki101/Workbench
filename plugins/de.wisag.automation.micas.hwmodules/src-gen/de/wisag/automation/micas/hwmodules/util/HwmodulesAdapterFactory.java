/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Parameter;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortGroup;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage
 * @generated
 */
public class HwmodulesAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static HwmodulesPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public HwmodulesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = HwmodulesPackage.eINSTANCE;
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
    protected HwmodulesSwitch<Adapter> modelSwitch = new HwmodulesSwitch<Adapter>() {
        @Override
        public Adapter caseHardwareTypeDefinition(HardwareTypeDefinition object) {
            return createHardwareTypeDefinitionAdapter();
        }

        @Override
        public Adapter caseHardwareAlias(HardwareAlias object) {
            return createHardwareAliasAdapter();
        }

        @Override
        public Adapter caseModuleDefinition(ModuleDefinition object) {
            return createModuleDefinitionAdapter();
        }

        @Override
        public Adapter casePort(Port object) {
            return createPortAdapter();
        }

        @Override
        public Adapter casePortGroup(PortGroup object) {
            return createPortGroupAdapter();
        }

        @Override
        public Adapter caseMicasModules(MicasModules object) {
            return createMicasModulesAdapter();
        }

        @Override
        public Adapter caseParameter(Parameter object) {
            return createParameterAdapter();
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
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition <em>Module
     * Definition</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.ModuleDefinition
     * @generated
     */
    public Adapter createModuleDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.hwmodules.Port <em>Port</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance
     * will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.Port
     * @generated
     */
    public Adapter createPortAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.hwmodules.PortGroup <em>Port
     * Group</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.PortGroup
     * @generated
     */
    public Adapter createPortGroupAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules <em>Micas
     * Modules</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.MicasModules
     * @generated
     */
    public Adapter createMicasModulesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.hwmodules.Parameter
     * <em>Parameter</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a
     * case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.Parameter
     * @generated
     */
    public Adapter createParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition
     * <em>Hardware Type Definition</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.HardwareTypeDefinition
     * @generated
     */
    public Adapter createHardwareTypeDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.wisag.automation.micas.hwmodules.HardwareAlias <em>Hardware
     * Alias</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.wisag.automation.micas.hwmodules.HardwareAlias
     * @generated
     */
    public Adapter createHardwareAliasAdapter() {
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

} // HwmodulesAdapterFactory
