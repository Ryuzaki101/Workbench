/**
 * generated by Xtext 2.12.0
 */
package de.wisag.automation.micas.mIC.impl;

import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.mIC.Symbol;
import de.wisag.automation.micas.mIC.SymbolAccessor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol Accessor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.wisag.automation.micas.mIC.impl.SymbolAccessorImpl#isWriting <em>Writing</em>}</li>
 *   <li>{@link de.wisag.automation.micas.mIC.impl.SymbolAccessorImpl#getSymbol <em>Symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbolAccessorImpl extends MinimalEObjectImpl.Container implements SymbolAccessor
{
  /**
   * The default value of the '{@link #isWriting() <em>Writing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWriting()
   * @generated
   * @ordered
   */
  protected static final boolean WRITING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWriting() <em>Writing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWriting()
   * @generated
   * @ordered
   */
  protected boolean writing = WRITING_EDEFAULT;

  /**
   * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbol()
   * @generated
   * @ordered
   */
  protected Symbol symbol;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SymbolAccessorImpl()
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
    return MICPackage.Literals.SYMBOL_ACCESSOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWriting()
  {
    return writing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWriting(boolean newWriting)
  {
    boolean oldWriting = writing;
    writing = newWriting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MICPackage.SYMBOL_ACCESSOR__WRITING, oldWriting, writing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol getSymbol()
  {
    if (symbol != null && symbol.eIsProxy())
    {
      InternalEObject oldSymbol = (InternalEObject)symbol;
      symbol = (Symbol)eResolveProxy(oldSymbol);
      if (symbol != oldSymbol)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MICPackage.SYMBOL_ACCESSOR__SYMBOL, oldSymbol, symbol));
      }
    }
    return symbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Symbol basicGetSymbol()
  {
    return symbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSymbol(Symbol newSymbol)
  {
    Symbol oldSymbol = symbol;
    symbol = newSymbol;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MICPackage.SYMBOL_ACCESSOR__SYMBOL, oldSymbol, symbol));
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
      case MICPackage.SYMBOL_ACCESSOR__WRITING:
        return isWriting();
      case MICPackage.SYMBOL_ACCESSOR__SYMBOL:
        if (resolve) return getSymbol();
        return basicGetSymbol();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MICPackage.SYMBOL_ACCESSOR__WRITING:
        setWriting((Boolean)newValue);
        return;
      case MICPackage.SYMBOL_ACCESSOR__SYMBOL:
        setSymbol((Symbol)newValue);
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
      case MICPackage.SYMBOL_ACCESSOR__WRITING:
        setWriting(WRITING_EDEFAULT);
        return;
      case MICPackage.SYMBOL_ACCESSOR__SYMBOL:
        setSymbol((Symbol)null);
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
      case MICPackage.SYMBOL_ACCESSOR__WRITING:
        return writing != WRITING_EDEFAULT;
      case MICPackage.SYMBOL_ACCESSOR__SYMBOL:
        return symbol != null;
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
    result.append(" (writing: ");
    result.append(writing);
    result.append(')');
    return result.toString();
  }

} //SymbolAccessorImpl
