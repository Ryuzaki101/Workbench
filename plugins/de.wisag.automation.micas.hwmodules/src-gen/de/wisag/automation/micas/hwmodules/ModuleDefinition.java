/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Module
 * Definition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getId
 * <em>Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getInputs
 * <em>Inputs</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getOutputs
 * <em>Outputs</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getRuntime
 * <em>Runtime</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getPastValueCount
 * <em>Past Value Count</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getDisplayName
 * <em>Display Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getDescription
 * <em>Description</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getSupportedByHardware
 * <em>Supported By Hardware</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getCategory
 * <em>Category</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getParameters
 * <em>Parameters</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getGroupId
 * <em>Group Id</em>}</li>
 * <li>{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getRequireMicasVersion
 * <em>Require Micas Version</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition()
 * @model
 * @generated
 */
public interface ModuleDefinition extends EObject {
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Id()
     * @model
     * @generated
     */
    int getId();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getId
     * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.Port}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Inputs()
     * @model containment="true"
     * @generated
     */
    EList<Port> getInputs();

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.Port}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputs</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Outputs</em>' containment reference list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Outputs()
     * @model containment="true"
     * @generated
     */
    EList<Port> getOutputs();

    /**
     * Returns the value of the '<em><b>Runtime</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Runtime</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Runtime</em>' attribute.
     * @see #setRuntime(long)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Runtime()
     * @model
     * @generated
     */
    long getRuntime();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getRuntime
     * <em>Runtime</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Runtime</em>' attribute.
     * @see #getRuntime()
     * @generated
     */
    void setRuntime(long value);

    /**
     * Returns the value of the '<em><b>Past Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Past Value Count</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Past Value Count</em>' attribute.
     * @see #setPastValueCount(int)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_PastValueCount()
     * @model
     * @generated
     */
    int getPastValueCount();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getPastValueCount
     * <em>Past Value Count</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Past Value Count</em>' attribute.
     * @see #getPastValueCount()
     * @generated
     */
    void setPastValueCount(int value);

    /**
     * Returns the value of the '<em><b>Display Name</b></em>' attribute. The
     * default value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Display Name</em>' attribute.
     * @see #setDisplayName(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_DisplayName()
     * @model default="n/a"
     * @generated
     */
    String getDisplayName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getDisplayName
     * <em>Display Name</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Display Name</em>' attribute.
     * @see #getDisplayName()
     * @generated
     */
    void setDisplayName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. The
     * default value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Description()
     * @model default="n/a"
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getDescription
     * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Supported By Hardware</b></em>'
     * reference list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.HardwareAlias}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Supported By Hardware</em>' reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Supported By Hardware</em>' reference list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_SupportedByHardware()
     * @model
     * @generated
     */
    EList<HardwareAlias> getSupportedByHardware();

    /**
     * Returns the value of the '<em><b>Category</b></em>' attribute. The
     * default value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Category</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Category</em>' attribute.
     * @see #setCategory(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Category()
     * @model default="n/a"
     * @generated
     */
    String getCategory();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getCategory
     * <em>Category</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Category</em>' attribute.
     * @see #getCategory()
     * @generated
     */
    void setCategory(String value);

    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.wisag.automation.micas.hwmodules.Parameter}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Parameters</em>' containment reference
     *         list.
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_Parameters()
     * @model containment="true"
     * @generated
     */
    EList<Parameter> getParameters();

    /**
     * Returns the value of the '<em><b>Group Id</b></em>' attribute. The
     * default value is <code>"n/a"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Group Id</em>' attribute.
     * @see #setGroupId(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_GroupId()
     * @model default="n/a"
     * @generated
     */
    String getGroupId();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getGroupId
     * <em>Group Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Group Id</em>' attribute.
     * @see #getGroupId()
     * @generated
     */
    void setGroupId(String value);

    /**
     * Returns the value of the '<em><b>Require Micas Version</b></em>'
     * attribute. The default value is <code>"n/a"</code>. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Require Micas Version</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Require Micas Version</em>' attribute.
     * @see #setRequireMicasVersion(String)
     * @see de.wisag.automation.micas.hwmodules.HwmodulesPackage#getModuleDefinition_RequireMicasVersion()
     * @model default="n/a"
     * @generated
     */
    String getRequireMicasVersion();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.hwmodules.ModuleDefinition#getRequireMicasVersion
     * <em>Require Micas Version</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Require Micas Version</em>'
     *            attribute.
     * @see #getRequireMicasVersion()
     * @generated
     */
    void setRequireMicasVersion(String value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        ModuleUtils.getPortGroupsCount(this);'"
     * @generated
     */
    int getPortGroupsCount();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return
     *        ModuleUtils.getPortsCount(this);'"
     * @generated
     */
    int getPortsCount();

} // ModuleDefinition
