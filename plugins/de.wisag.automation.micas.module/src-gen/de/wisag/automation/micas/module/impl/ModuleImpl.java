/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleKind;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.PageFormat;
import de.wisag.automation.micas.module.PageOrientation;
import de.wisag.automation.micas.module.Task;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Module</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getKind
 * <em>Kind</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getAttributes
 * <em>Attributes</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getTasks
 * <em>Tasks</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getProcessor
 * <em>Processor</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getExaminer
 * <em>Examiner</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getCreatedDate
 * <em>Created Date</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getLastModifiedDate
 * <em>Last Modified Date</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getLastInstallDate
 * <em>Last Install Date</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getQualifier
 * <em>Qualifier</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getLineNumber
 * <em>Line Number</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getStationNumber
 * <em>Station Number</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getFieldBusNumber
 * <em>Field Bus Number</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getPageFormat
 * <em>Page Format</em>}</li>
 * <li>{@link de.wisag.automation.micas.module.impl.ModuleImpl#getPageOrientation
 * <em>Page Orientation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends EObjectImpl implements Module {
    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected static final ModuleKind KIND_EDEFAULT = ModuleKind.AC40;

    /**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected ModuleKind kind = KIND_EDEFAULT;

    /**
     * The cached value of the '{@link #getAttributes() <em>Attributes</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAttributes()
     * @generated
     * @ordered
     */
    protected EList<Attribute> attributes;

    /**
     * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTasks()
     * @generated
     * @ordered
     */
    protected EList<Task> tasks;

    /**
     * The default value of the '{@link #getProcessor() <em>Processor</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProcessor()
     * @generated
     * @ordered
     */
    protected static final String PROCESSOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProcessor() <em>Processor</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProcessor()
     * @generated
     * @ordered
     */
    protected String processor = PROCESSOR_EDEFAULT;

    /**
     * The default value of the '{@link #getExaminer() <em>Examiner</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExaminer()
     * @generated
     * @ordered
     */
    protected static final String EXAMINER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExaminer() <em>Examiner</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getExaminer()
     * @generated
     * @ordered
     */
    protected String examiner = EXAMINER_EDEFAULT;

    /**
     * The default value of the '{@link #getCreatedDate() <em>Created
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCreatedDate()
     * @generated
     * @ordered
     */
    protected static final Date CREATED_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreatedDate() <em>Created Date</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCreatedDate()
     * @generated
     * @ordered
     */
    protected Date createdDate = CREATED_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getLastModifiedDate() <em>Last Modified
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLastModifiedDate()
     * @generated
     * @ordered
     */
    protected static final Date LAST_MODIFIED_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastModifiedDate() <em>Last Modified
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLastModifiedDate()
     * @generated
     * @ordered
     */
    protected Date lastModifiedDate = LAST_MODIFIED_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getLastInstallDate() <em>Last Install
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLastInstallDate()
     * @generated
     * @ordered
     */
    protected static final Date LAST_INSTALL_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLastInstallDate() <em>Last Install
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLastInstallDate()
     * @generated
     * @ordered
     */
    protected Date lastInstallDate = LAST_INSTALL_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getQualifier() <em>Qualifier</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getQualifier()
     * @generated
     * @ordered
     */
    protected static final int QUALIFIER_EDEFAULT = 29;

    /**
     * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getQualifier()
     * @generated
     * @ordered
     */
    protected int qualifier = QUALIFIER_EDEFAULT;

    /**
     * The default value of the '{@link #getLineNumber() <em>Line Number</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLineNumber()
     * @generated
     * @ordered
     */
    protected static final int LINE_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getLineNumber()
     * @generated
     * @ordered
     */
    protected int lineNumber = LINE_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #getStationNumber() <em>Station
     * Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStationNumber()
     * @generated
     * @ordered
     */
    protected static final int STATION_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStationNumber() <em>Station
     * Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getStationNumber()
     * @generated
     * @ordered
     */
    protected int stationNumber = STATION_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #getFieldBusNumber() <em>Field Bus
     * Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFieldBusNumber()
     * @generated
     * @ordered
     */
    protected static final int FIELD_BUS_NUMBER_EDEFAULT = 2;

    /**
     * The cached value of the '{@link #getFieldBusNumber() <em>Field Bus
     * Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFieldBusNumber()
     * @generated
     * @ordered
     */
    protected int fieldBusNumber = FIELD_BUS_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #getPageFormat() <em>Page Format</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPageFormat()
     * @generated
     * @ordered
     */
    protected static final PageFormat PAGE_FORMAT_EDEFAULT = PageFormat.A3;

    /**
     * The cached value of the '{@link #getPageFormat() <em>Page Format</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPageFormat()
     * @generated
     * @ordered
     */
    protected PageFormat pageFormat = PAGE_FORMAT_EDEFAULT;

    /**
     * The default value of the '{@link #getPageOrientation() <em>Page
     * Orientation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getPageOrientation()
     * @generated
     * @ordered
     */
    protected static final PageOrientation PAGE_ORIENTATION_EDEFAULT = PageOrientation.LANDSCAPE;

    /**
     * The cached value of the '{@link #getPageOrientation() <em>Page
     * Orientation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getPageOrientation()
     * @generated
     * @ordered
     */
    protected PageOrientation pageOrientation = PAGE_ORIENTATION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ModuleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModulePackage.Literals.MODULE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ModuleKind getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setKind(ModuleKind newKind) {
        ModuleKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__KIND, oldKind, kind));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Attribute> getAttributes() {
        if (attributes == null) {
            attributes = new EObjectContainmentEList<>(Attribute.class, this, ModulePackage.MODULE__ATTRIBUTES);
        }
        return attributes;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Task> getTasks() {
        if (tasks == null) {
            tasks = new EObjectContainmentWithInverseEList<>(Task.class, this, ModulePackage.MODULE__TASKS,
                    ModulePackage.TASK__MODULE);
        }
        return tasks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getProcessor() {
        return processor;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProcessor(String newProcessor) {
        String oldProcessor = processor;
        processor = newProcessor;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__PROCESSOR, oldProcessor,
                    processor));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getExaminer() {
        return examiner;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setExaminer(String newExaminer) {
        String oldExaminer = examiner;
        examiner = newExaminer;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__EXAMINER, oldExaminer,
                    examiner));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCreatedDate(Date newCreatedDate) {
        Date oldCreatedDate = createdDate;
        createdDate = newCreatedDate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__CREATED_DATE, oldCreatedDate,
                    createdDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLastModifiedDate(Date newLastModifiedDate) {
        Date oldLastModifiedDate = lastModifiedDate;
        lastModifiedDate = newLastModifiedDate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__LAST_MODIFIED_DATE,
                    oldLastModifiedDate, lastModifiedDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Date getLastInstallDate() {
        return lastInstallDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLastInstallDate(Date newLastInstallDate) {
        Date oldLastInstallDate = lastInstallDate;
        lastInstallDate = newLastInstallDate;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__LAST_INSTALL_DATE,
                    oldLastInstallDate, lastInstallDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__NAME, oldName, name));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getQualifier() {
        return qualifier;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setQualifier(int newQualifier) {
        int oldQualifier = qualifier;
        qualifier = newQualifier;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__QUALIFIER, oldQualifier,
                    qualifier));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLineNumber(int newLineNumber) {
        int oldLineNumber = lineNumber;
        lineNumber = newLineNumber;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__LINE_NUMBER, oldLineNumber,
                    lineNumber));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getStationNumber() {
        return stationNumber;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStationNumber(int newStationNumber) {
        int oldStationNumber = stationNumber;
        stationNumber = newStationNumber;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__STATION_NUMBER,
                    oldStationNumber, stationNumber));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getFieldBusNumber() {
        return fieldBusNumber;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFieldBusNumber(int newFieldBusNumber) {
        int oldFieldBusNumber = fieldBusNumber;
        fieldBusNumber = newFieldBusNumber;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__FIELD_BUS_NUMBER,
                    oldFieldBusNumber, fieldBusNumber));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PageFormat getPageFormat() {
        return pageFormat;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPageFormat(PageFormat newPageFormat) {
        PageFormat oldPageFormat = pageFormat;
        pageFormat = newPageFormat == null ? PAGE_FORMAT_EDEFAULT : newPageFormat;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__PAGE_FORMAT, oldPageFormat,
                    pageFormat));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PageOrientation getPageOrientation() {
        return pageOrientation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPageOrientation(PageOrientation newPageOrientation) {
        PageOrientation oldPageOrientation = pageOrientation;
        pageOrientation = newPageOrientation == null ? PAGE_ORIENTATION_EDEFAULT : newPageOrientation;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModulePackage.MODULE__PAGE_ORIENTATION,
                    oldPageOrientation, pageOrientation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ModulePackage.MODULE__TASKS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getTasks()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ModulePackage.MODULE__ATTRIBUTES:
            return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
        case ModulePackage.MODULE__TASKS:
            return ((InternalEList<?>) getTasks()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ModulePackage.MODULE__KIND:
            return getKind();
        case ModulePackage.MODULE__ATTRIBUTES:
            return getAttributes();
        case ModulePackage.MODULE__TASKS:
            return getTasks();
        case ModulePackage.MODULE__PROCESSOR:
            return getProcessor();
        case ModulePackage.MODULE__EXAMINER:
            return getExaminer();
        case ModulePackage.MODULE__CREATED_DATE:
            return getCreatedDate();
        case ModulePackage.MODULE__LAST_MODIFIED_DATE:
            return getLastModifiedDate();
        case ModulePackage.MODULE__LAST_INSTALL_DATE:
            return getLastInstallDate();
        case ModulePackage.MODULE__NAME:
            return getName();
        case ModulePackage.MODULE__QUALIFIER:
            return getQualifier();
        case ModulePackage.MODULE__LINE_NUMBER:
            return getLineNumber();
        case ModulePackage.MODULE__STATION_NUMBER:
            return getStationNumber();
        case ModulePackage.MODULE__FIELD_BUS_NUMBER:
            return getFieldBusNumber();
        case ModulePackage.MODULE__PAGE_FORMAT:
            return getPageFormat();
        case ModulePackage.MODULE__PAGE_ORIENTATION:
            return getPageOrientation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ModulePackage.MODULE__KIND:
            setKind((ModuleKind) newValue);
            return;
        case ModulePackage.MODULE__ATTRIBUTES:
            getAttributes().clear();
            getAttributes().addAll((Collection<? extends Attribute>) newValue);
            return;
        case ModulePackage.MODULE__TASKS:
            getTasks().clear();
            getTasks().addAll((Collection<? extends Task>) newValue);
            return;
        case ModulePackage.MODULE__PROCESSOR:
            setProcessor((String) newValue);
            return;
        case ModulePackage.MODULE__EXAMINER:
            setExaminer((String) newValue);
            return;
        case ModulePackage.MODULE__CREATED_DATE:
            setCreatedDate((Date) newValue);
            return;
        case ModulePackage.MODULE__LAST_MODIFIED_DATE:
            setLastModifiedDate((Date) newValue);
            return;
        case ModulePackage.MODULE__LAST_INSTALL_DATE:
            setLastInstallDate((Date) newValue);
            return;
        case ModulePackage.MODULE__NAME:
            setName((String) newValue);
            return;
        case ModulePackage.MODULE__QUALIFIER:
            setQualifier((Integer) newValue);
            return;
        case ModulePackage.MODULE__LINE_NUMBER:
            setLineNumber((Integer) newValue);
            return;
        case ModulePackage.MODULE__STATION_NUMBER:
            setStationNumber((Integer) newValue);
            return;
        case ModulePackage.MODULE__FIELD_BUS_NUMBER:
            setFieldBusNumber((Integer) newValue);
            return;
        case ModulePackage.MODULE__PAGE_FORMAT:
            setPageFormat((PageFormat) newValue);
            return;
        case ModulePackage.MODULE__PAGE_ORIENTATION:
            setPageOrientation((PageOrientation) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case ModulePackage.MODULE__KIND:
            setKind(KIND_EDEFAULT);
            return;
        case ModulePackage.MODULE__ATTRIBUTES:
            getAttributes().clear();
            return;
        case ModulePackage.MODULE__TASKS:
            getTasks().clear();
            return;
        case ModulePackage.MODULE__PROCESSOR:
            setProcessor(PROCESSOR_EDEFAULT);
            return;
        case ModulePackage.MODULE__EXAMINER:
            setExaminer(EXAMINER_EDEFAULT);
            return;
        case ModulePackage.MODULE__CREATED_DATE:
            setCreatedDate(CREATED_DATE_EDEFAULT);
            return;
        case ModulePackage.MODULE__LAST_MODIFIED_DATE:
            setLastModifiedDate(LAST_MODIFIED_DATE_EDEFAULT);
            return;
        case ModulePackage.MODULE__LAST_INSTALL_DATE:
            setLastInstallDate(LAST_INSTALL_DATE_EDEFAULT);
            return;
        case ModulePackage.MODULE__NAME:
            setName(NAME_EDEFAULT);
            return;
        case ModulePackage.MODULE__QUALIFIER:
            setQualifier(QUALIFIER_EDEFAULT);
            return;
        case ModulePackage.MODULE__LINE_NUMBER:
            setLineNumber(LINE_NUMBER_EDEFAULT);
            return;
        case ModulePackage.MODULE__STATION_NUMBER:
            setStationNumber(STATION_NUMBER_EDEFAULT);
            return;
        case ModulePackage.MODULE__FIELD_BUS_NUMBER:
            setFieldBusNumber(FIELD_BUS_NUMBER_EDEFAULT);
            return;
        case ModulePackage.MODULE__PAGE_FORMAT:
            setPageFormat(PAGE_FORMAT_EDEFAULT);
            return;
        case ModulePackage.MODULE__PAGE_ORIENTATION:
            setPageOrientation(PAGE_ORIENTATION_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ModulePackage.MODULE__KIND:
            return kind != KIND_EDEFAULT;
        case ModulePackage.MODULE__ATTRIBUTES:
            return attributes != null && !attributes.isEmpty();
        case ModulePackage.MODULE__TASKS:
            return tasks != null && !tasks.isEmpty();
        case ModulePackage.MODULE__PROCESSOR:
            return PROCESSOR_EDEFAULT == null ? processor != null : !PROCESSOR_EDEFAULT.equals(processor);
        case ModulePackage.MODULE__EXAMINER:
            return EXAMINER_EDEFAULT == null ? examiner != null : !EXAMINER_EDEFAULT.equals(examiner);
        case ModulePackage.MODULE__CREATED_DATE:
            return CREATED_DATE_EDEFAULT == null ? createdDate != null : !CREATED_DATE_EDEFAULT.equals(createdDate);
        case ModulePackage.MODULE__LAST_MODIFIED_DATE:
            return LAST_MODIFIED_DATE_EDEFAULT == null ? lastModifiedDate != null
                    : !LAST_MODIFIED_DATE_EDEFAULT.equals(lastModifiedDate);
        case ModulePackage.MODULE__LAST_INSTALL_DATE:
            return LAST_INSTALL_DATE_EDEFAULT == null ? lastInstallDate != null
                    : !LAST_INSTALL_DATE_EDEFAULT.equals(lastInstallDate);
        case ModulePackage.MODULE__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case ModulePackage.MODULE__QUALIFIER:
            return qualifier != QUALIFIER_EDEFAULT;
        case ModulePackage.MODULE__LINE_NUMBER:
            return lineNumber != LINE_NUMBER_EDEFAULT;
        case ModulePackage.MODULE__STATION_NUMBER:
            return stationNumber != STATION_NUMBER_EDEFAULT;
        case ModulePackage.MODULE__FIELD_BUS_NUMBER:
            return fieldBusNumber != FIELD_BUS_NUMBER_EDEFAULT;
        case ModulePackage.MODULE__PAGE_FORMAT:
            return pageFormat != PAGE_FORMAT_EDEFAULT;
        case ModulePackage.MODULE__PAGE_ORIENTATION:
            return pageOrientation != PAGE_ORIENTATION_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (kind: ");
        result.append(kind);
        result.append(", processor: ");
        result.append(processor);
        result.append(", examiner: ");
        result.append(examiner);
        result.append(", createdDate: ");
        result.append(createdDate);
        result.append(", lastModifiedDate: ");
        result.append(lastModifiedDate);
        result.append(", lastInstallDate: ");
        result.append(lastInstallDate);
        result.append(", name: ");
        result.append(name);
        result.append(", qualifier: ");
        result.append(qualifier);
        result.append(", lineNumber: ");
        result.append(lineNumber);
        result.append(", stationNumber: ");
        result.append(stationNumber);
        result.append(", fieldBusNumber: ");
        result.append(fieldBusNumber);
        result.append(", pageFormat: ");
        result.append(pageFormat);
        result.append(", pageOrientation: ");
        result.append(pageOrientation);
        result.append(')');
        return result.toString();
    }

} // ModuleImpl
