/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Micas
 * Modules</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.MicasModules#getModulesById
 * <em>Modules By Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.MicasModules#getModulesByName
 * <em>Modules By Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.MicasModules#getModules
 * <em>Modules</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.MicasModules#getTypes
 * <em>Types</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getMicasModules()
 * @model
 * @generated
 */
public interface MicasModules extends EObject {
    /**
     * Returns the value of the '<em><b>Modules By Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modules By Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Modules By Id</em>' attribute.
     * @see #setModulesById(Map)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getMicasModules_ModulesById()
     * @model transient="true"
     * @generated
     */
    Map<Integer, ModuleDefinition> getModulesById();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules#getModulesById
     * <em>Modules By Id</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Modules By Id</em>' attribute.
     * @see #getModulesById()
     * @generated
     */
    void setModulesById(Map<Integer, ModuleDefinition> value);

    /**
     * Returns the value of the '<em><b>Modules By Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modules By Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Modules By Name</em>' attribute.
     * @see #setModulesByName(Map)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getMicasModules_ModulesByName()
     * @model transient="true"
     * @generated
     */
    Map<String, ModuleDefinition> getModulesByName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.MicasModules#getModulesByName
     * <em>Modules By Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Modules By Name</em>' attribute.
     * @see #getModulesByName()
     * @generated
     */
    void setModulesByName(Map<String, ModuleDefinition> value);

    /**
     * Returns the value of the '<em><b>Modules</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.ModuleDefinition}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modules</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Modules</em>' containment reference list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getMicasModules_Modules()
     * @model containment="true"
     * @generated
     */
    EList<ModuleDefinition> getModules();

    /**
     * Returns the value of the '<em><b>Types</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Types</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Types</em>' containment reference list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getMicasModules_Types()
     * @model containment="true"
     * @generated
     */
    EList<HardwareTypeDefinition> getTypes();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        ModuleUtils.findModuleById(this,id);'"
     * @generated
     */
    ModuleDefinition findModuleById(int id);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        ModuleUtils.findModuleByName(this,name);'"
     * @generated
     */
    ModuleDefinition findModuleByName(String name);

} // MicasModules
