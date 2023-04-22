/**
 * generated by Xtext 2.12.0
 */
package de.wisag.automation.micas.mIC;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.wisag.automation.micas.mIC.Module#getModuleProlog <em>Module Prolog</em>}</li>
 *   <li>{@link de.wisag.automation.micas.mIC.Module#getType <em>Type</em>}</li>
 *   <li>{@link de.wisag.automation.micas.mIC.Module#getValue <em>Value</em>}</li>
 *   <li>{@link de.wisag.automation.micas.mIC.Module#getDecalarations <em>Decalarations</em>}</li>
 *   <li>{@link de.wisag.automation.micas.mIC.Module#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.mIC.MICPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends Model
{
  /**
   * Returns the value of the '<em><b>Module Prolog</b></em>' containment reference list.
   * The list contents are of type {@link de.wisag.automation.micas.mIC.MetaData}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module Prolog</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module Prolog</em>' containment reference list.
   * @see de.wisag.automation.micas.mIC.MICPackage#getModule_ModuleProlog()
   * @model containment="true"
   * @generated
   */
  EList<MetaData> getModuleProlog();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.wisag.automation.micas.mIC.MICPackage#getModule_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.wisag.automation.micas.mIC.Module#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see de.wisag.automation.micas.mIC.MICPackage#getModule_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link de.wisag.automation.micas.mIC.Module#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

  /**
   * Returns the value of the '<em><b>Decalarations</b></em>' containment reference list.
   * The list contents are of type {@link de.wisag.automation.micas.mIC.Symbol}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decalarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decalarations</em>' containment reference list.
   * @see de.wisag.automation.micas.mIC.MICPackage#getModule_Decalarations()
   * @model containment="true"
   * @generated
   */
  EList<Symbol> getDecalarations();

  /**
   * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
   * The list contents are of type {@link de.wisag.automation.micas.mIC.Task}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tasks</em>' containment reference list.
   * @see de.wisag.automation.micas.mIC.MICPackage#getModule_Tasks()
   * @model containment="true"
   * @generated
   */
  EList<Task> getTasks();

} // Module