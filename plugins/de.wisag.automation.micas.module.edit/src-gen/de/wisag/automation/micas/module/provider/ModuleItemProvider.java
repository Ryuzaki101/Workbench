/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;

/**
 * This is the item provider adapter for a
 * {@link de.wisag.automation.micas.module.Module} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ModuleItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ModuleItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addKindPropertyDescriptor(object);
            addProcessorPropertyDescriptor(object);
            addExaminerPropertyDescriptor(object);
            addCreatedDatePropertyDescriptor(object);
            addLastModifiedDatePropertyDescriptor(object);
            addLastInstallDatePropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            addQualifierPropertyDescriptor(object);
            addLineNumberPropertyDescriptor(object);
            addStationNumberPropertyDescriptor(object);
            addFieldBusNumberPropertyDescriptor(object);
            addPageFormatPropertyDescriptor(object);
            addPageOrientationPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Kind feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addKindPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_kind_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_kind_feature", "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__KIND, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Processor feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addProcessorPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_processor_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_processor_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__PROCESSOR, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Examiner feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addExaminerPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_examiner_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_examiner_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__EXAMINER, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Created Date feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addCreatedDatePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_createdDate_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_createdDate_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__CREATED_DATE, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Last Modified Date feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addLastModifiedDatePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_lastModifiedDate_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_lastModifiedDate_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__LAST_MODIFIED_DATE, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Last Install Date feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addLastInstallDatePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_lastInstallDate_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_lastInstallDate_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__LAST_INSTALL_DATE, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_name_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_name_feature", "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__NAME, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Qualifier feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addQualifierPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_qualifier_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_qualifier_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__QUALIFIER, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Line Number feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addLineNumberPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_lineNumber_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_lineNumber_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__LINE_NUMBER, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Station Number feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStationNumberPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_stationNumber_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_stationNumber_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__STATION_NUMBER, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Field Bus Number feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFieldBusNumberPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_fieldBusNumber_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_fieldBusNumber_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__FIELD_BUS_NUMBER, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Page Format feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPageFormatPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_pageFormat_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_pageFormat_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__PAGE_FORMAT, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Page Orientation feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPageOrientationPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_Module_pageOrientation_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_Module_pageOrientation_feature",
                                "_UI_Module_type"),
                        ModulePackage.Literals.MODULE__PAGE_ORIENTATION, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in
     * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(ModulePackage.Literals.MODULE__ATTRIBUTES);
            childrenFeatures.add(ModulePackage.Literals.MODULE__TASKS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper
        // feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns Module.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Module"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Module) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_Module_type")
                : getString("_UI_Module_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached children and by creating a viewer notification, which
     * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(Module.class)) {
        case ModulePackage.MODULE__KIND:
        case ModulePackage.MODULE__PROCESSOR:
        case ModulePackage.MODULE__EXAMINER:
        case ModulePackage.MODULE__CREATED_DATE:
        case ModulePackage.MODULE__LAST_MODIFIED_DATE:
        case ModulePackage.MODULE__LAST_INSTALL_DATE:
        case ModulePackage.MODULE__NAME:
        case ModulePackage.MODULE__QUALIFIER:
        case ModulePackage.MODULE__LINE_NUMBER:
        case ModulePackage.MODULE__STATION_NUMBER:
        case ModulePackage.MODULE__FIELD_BUS_NUMBER:
        case ModulePackage.MODULE__PAGE_FORMAT:
        case ModulePackage.MODULE__PAGE_ORIENTATION:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case ModulePackage.MODULE__ATTRIBUTES:
        case ModulePackage.MODULE__TASKS:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children that can be created under this object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(createChildParameter(ModulePackage.Literals.MODULE__ATTRIBUTES,
                ModuleFactory.eINSTANCE.createVariableAttribute()));

        newChildDescriptors.add(createChildParameter(ModulePackage.Literals.MODULE__ATTRIBUTES,
                ModuleFactory.eINSTANCE.createConstantAttribute()));

        newChildDescriptors.add(createChildParameter(ModulePackage.Literals.MODULE__ATTRIBUTES,
                ModuleFactory.eINSTANCE.createReferenceAttribute()));

        newChildDescriptors
                .add(createChildParameter(ModulePackage.Literals.MODULE__TASKS, ModuleFactory.eINSTANCE.createTask()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ModuleEditPlugin.INSTANCE;
    }

}
