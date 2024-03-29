/**
 * generated by Xtext 2.12.0
 */
package de.wisag.automation.micas.mIC.impl;

import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.mIC.ModuleInvokation;
import de.wisag.automation.micas.mIC.SymbolAccessor;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Invokation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.wisag.automation.micas.mIC.impl.ModuleInvokationImpl#getModuleName <em>Module Name</em>}</li>
 *   <li>{@link de.wisag.automation.micas.mIC.impl.ModuleInvokationImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleInvokationImpl extends InstructionImpl implements ModuleInvokation
{
  /**
   * The default value of the '{@link #getModuleName() <em>Module Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModuleName()
   * @generated
   * @ordered
   */
  protected static final String MODULE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModuleName() <em>Module Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModuleName()
   * @generated
   * @ordered
   */
  protected String moduleName = MODULE_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected EList<SymbolAccessor> arguments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModuleInvokationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MICPackage.Literals.MODULE_INVOKATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModuleName()
  {
    return moduleName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModuleName(String newModuleName)
  {
    String oldModuleName = moduleName;
    moduleName = newModuleName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MICPackage.MODULE_INVOKATION__MODULE_NAME, oldModuleName, moduleName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SymbolAccessor> getArguments()
  {
    if (arguments == null)
    {
      arguments = new EObjectContainmentEList<SymbolAccessor>(SymbolAccessor.class, this, MICPackage.MODULE_INVOKATION__ARGUMENTS);
    }
    return arguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MICPackage.MODULE_INVOKATION__ARGUMENTS:
        return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MICPackage.MODULE_INVOKATION__MODULE_NAME:
        return getModuleName();
      case MICPackage.MODULE_INVOKATION__ARGUMENTS:
        return getArguments();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MICPackage.MODULE_INVOKATION__MODULE_NAME:
        setModuleName((String)newValue);
        return;
      case MICPackage.MODULE_INVOKATION__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends SymbolAccessor>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MICPackage.MODULE_INVOKATION__MODULE_NAME:
        setModuleName(MODULE_NAME_EDEFAULT);
        return;
      case MICPackage.MODULE_INVOKATION__ARGUMENTS:
        getArguments().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MICPackage.MODULE_INVOKATION__MODULE_NAME:
        return MODULE_NAME_EDEFAULT == null ? moduleName != null : !MODULE_NAME_EDEFAULT.equals(moduleName);
      case MICPackage.MODULE_INVOKATION__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (moduleName: ");
    result.append(moduleName);
    result.append(')');
    return result.toString();
  }

} //ModuleInvokationImpl
