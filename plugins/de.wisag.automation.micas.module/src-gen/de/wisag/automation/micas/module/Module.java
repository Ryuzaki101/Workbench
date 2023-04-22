/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.Module#getKind
 * <em>Kind</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getAttributes
 * <em>Attributes</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getTasks
 * <em>Tasks</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getProcessor
 * <em>Processor</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getExaminer
 * <em>Examiner</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getCreatedDate <em>Created
 * Date</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getLastModifiedDate
 * <em>Last Modified Date</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getLastInstallDate
 * <em>Last Install Date</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getQualifier
 * <em>Qualifier</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getLineNumber <em>Line
 * Number</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getStationNumber
 * <em>Station Number</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getFieldBusNumber
 * <em>Field Bus Number</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getPageFormat <em>Page
 * Format</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.Module#getPageOrientation
 * <em>Page Orientation</em>}</li>
 * </ul>
 *
 * @see de.wisag.automation.micas.module.ModulePackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject {
    /**
     * Returns the value of the '<em><b>Kind</b></em>' attribute. The literals
     * are from the enumeration
     * {@link de.wisag.automation.micas.module.ModuleKind}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Kind</em>' attribute.
     * @see de.wisag.automation.micas.module.ModuleKind
     * @see #setKind(ModuleKind)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Kind()
     * @model required="true" ordered="false"
     * @generated
     */
    ModuleKind getKind();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getKind <em>Kind</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Kind</em>' attribute.
     * @see de.wisag.automation.micas.module.ModuleKind
     * @see #getKind()
     * @generated
     */
    void setKind(ModuleKind value);

    /**
     * Returns the value of the '<em><b>Attributes</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.wisag.automation.micas.module.Attribute}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Attributes</em>' containment reference
     *         list.
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Attributes()
     * @model containment="true"
     * @generated
     */
    EList<Attribute> getAttributes();

    /**
     * Returns the value of the '<em><b>Tasks</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.wisag.automation.micas.module.Task}. It is bidirectional and
     * its opposite is '{@link de.wisag.automation.micas.module.Task#getModule
     * <em>Module</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tasks</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Tasks</em>' containment reference list.
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Tasks()
     * @see de.wisag.automation.micas.module.Task#getModule
     * @model opposite="module" containment="true"
     * @generated
     */
    EList<Task> getTasks();

    /**
     * Returns the value of the '<em><b>Processor</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Processor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Processor</em>' attribute.
     * @see #setProcessor(String)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Processor()
     * @model
     * @generated
     */
    String getProcessor();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getProcessor
     * <em>Processor</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Processor</em>' attribute.
     * @see #getProcessor()
     * @generated
     */
    void setProcessor(String value);

    /**
     * Returns the value of the '<em><b>Examiner</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Examiner</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Examiner</em>' attribute.
     * @see #setExaminer(String)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Examiner()
     * @model
     * @generated
     */
    String getExaminer();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getExaminer
     * <em>Examiner</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Examiner</em>' attribute.
     * @see #getExaminer()
     * @generated
     */
    void setExaminer(String value);

    /**
     * Returns the value of the '<em><b>Created Date</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Created Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Created Date</em>' attribute.
     * @see #setCreatedDate(Date)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_CreatedDate()
     * @model
     * @generated
     */
    Date getCreatedDate();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getCreatedDate
     * <em>Created Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Created Date</em>' attribute.
     * @see #getCreatedDate()
     * @generated
     */
    void setCreatedDate(Date value);

    /**
     * Returns the value of the '<em><b>Last Modified Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Modified Date</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Last Modified Date</em>' attribute.
     * @see #setLastModifiedDate(Date)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_LastModifiedDate()
     * @model
     * @generated
     */
    Date getLastModifiedDate();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getLastModifiedDate
     * <em>Last Modified Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Last Modified Date</em>' attribute.
     * @see #getLastModifiedDate()
     * @generated
     */
    void setLastModifiedDate(Date value);

    /**
     * Returns the value of the '<em><b>Last Install Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Last Install Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Last Install Date</em>' attribute.
     * @see #setLastInstallDate(Date)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_LastInstallDate()
     * @model
     * @generated
     */
    Date getLastInstallDate();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getLastInstallDate
     * <em>Last Install Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Last Install Date</em>' attribute.
     * @see #getLastInstallDate()
     * @generated
     */
    void setLastInstallDate(Date value);

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
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getName <em>Name</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Qualifier</b></em>' attribute. The
     * default value is <code>"29"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Qualifier</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Qualifier</em>' attribute.
     * @see #setQualifier(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_Qualifier()
     * @model default="29"
     * @generated
     */
    int getQualifier();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getQualifier
     * <em>Qualifier</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @param value
     *            the new value of the '<em>Qualifier</em>' attribute.
     * @see #getQualifier()
     * @generated
     */
    void setQualifier(int value);

    /**
     * Returns the value of the '<em><b>Line Number</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Number</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Line Number</em>' attribute.
     * @see #setLineNumber(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_LineNumber()
     * @model
     * @generated
     */
    int getLineNumber();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getLineNumber <em>Line
     * Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Line Number</em>' attribute.
     * @see #getLineNumber()
     * @generated
     */
    void setLineNumber(int value);

    /**
     * Returns the value of the '<em><b>Station Number</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Station Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Station Number</em>' attribute.
     * @see #setStationNumber(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_StationNumber()
     * @model
     * @generated
     */
    int getStationNumber();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getStationNumber
     * <em>Station Number</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Station Number</em>' attribute.
     * @see #getStationNumber()
     * @generated
     */
    void setStationNumber(int value);

    /**
     * Returns the value of the '<em><b>Field Bus Number</b></em>' attribute.
     * The default value is <code>"2"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field Bus Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Field Bus Number</em>' attribute.
     * @see #setFieldBusNumber(int)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_FieldBusNumber()
     * @model default="2"
     * @generated
     */
    int getFieldBusNumber();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getFieldBusNumber
     * <em>Field Bus Number</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Field Bus Number</em>' attribute.
     * @see #getFieldBusNumber()
     * @generated
     */
    void setFieldBusNumber(int value);

    /**
     * Returns the value of the '<em><b>Page Format</b></em>' attribute. The
     * default value is <code>"A3"</code>. The literals are from the enumeration
     * {@link de.wisag.automation.micas.module.PageFormat}. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Page Format</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Page Format</em>' attribute.
     * @see de.wisag.automation.micas.module.PageFormat
     * @see #setPageFormat(PageFormat)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_PageFormat()
     * @model default="A3"
     * @generated
     */
    PageFormat getPageFormat();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getPageFormat <em>Page
     * Format</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Page Format</em>' attribute.
     * @see de.wisag.automation.micas.module.PageFormat
     * @see #getPageFormat()
     * @generated
     */
    void setPageFormat(PageFormat value);

    /**
     * Returns the value of the '<em><b>Page Orientation</b></em>' attribute.
     * The literals are from the enumeration
     * {@link de.wisag.automation.micas.module.PageOrientation}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Page Orientation</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Page Orientation</em>' attribute.
     * @see de.wisag.automation.micas.module.PageOrientation
     * @see #setPageOrientation(PageOrientation)
     * @see de.wisag.automation.micas.module.ModulePackage#getModule_PageOrientation()
     * @model
     * @generated
     */
    PageOrientation getPageOrientation();

    /**
     * Sets the value of the
     * '{@link de.wisag.automation.micas.module.Module#getPageOrientation
     * <em>Page Orientation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Page Orientation</em>' attribute.
     * @see de.wisag.automation.micas.module.PageOrientation
     * @see #getPageOrientation()
     * @generated
     */
    void setPageOrientation(PageOrientation value);

} // Module
