/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.provider;

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

import de.wisag.automation.micas.hwmodules.HwmodulesFactory;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;

/**
 * This is the item provider adapter for a
 * {@link de.wisag.automation.micas.hwmodules.ModuleDefinition} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ModuleDefinitionItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ModuleDefinitionItemProvider(AdapterFactory adapterFactory) {
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

            addIdPropertyDescriptor(object);
            addNamePropertyDescriptor(object);
            addRuntimePropertyDescriptor(object);
            addPastValueCountPropertyDescriptor(object);
            addDisplayNamePropertyDescriptor(object);
            addDescriptionPropertyDescriptor(object);
            addSupportedByHardwarePropertyDescriptor(object);
            addCategoryPropertyDescriptor(object);
            addGroupIdPropertyDescriptor(object);
            addRequireMicasVersionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Id feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_id_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_id_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__ID, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
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
                        getResourceLocator(), getString("_UI_ModuleDefinition_name_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_name_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__NAME, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Runtime feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addRuntimePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_runtime_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_runtime_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__RUNTIME, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Past Value Count feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPastValueCountPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_ModuleDefinition_pastValueCount_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_pastValueCount_feature",
                        "_UI_ModuleDefinition_type"),
                HwmodulesPackage.Literals.MODULE_DEFINITION__PAST_VALUE_COUNT, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Display Name feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDisplayNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_displayName_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_displayName_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__DISPLAY_NAME, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Description feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_description_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_description_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__DESCRIPTION, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Supported By Hardware feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSupportedByHardwarePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_supportedByHardware_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_ModuleDefinition_supportedByHardware_feature", "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__SUPPORTED_BY_HARDWARE, true, false, true, null,
                        null, null));
    }

    /**
     * This adds a property descriptor for the Category feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addCategoryPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_category_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_category_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__CATEGORY, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Group Id feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addGroupIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_groupId_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_ModuleDefinition_groupId_feature",
                                "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__GROUP_ID, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Require Micas Version feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addRequireMicasVersionPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_ModuleDefinition_requireMicasVersion_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_ModuleDefinition_requireMicasVersion_feature", "_UI_ModuleDefinition_type"),
                        HwmodulesPackage.Literals.MODULE_DEFINITION__REQUIRE_MICAS_VERSION, true, false, false,
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
            childrenFeatures.add(HwmodulesPackage.Literals.MODULE_DEFINITION__INPUTS);
            childrenFeatures.add(HwmodulesPackage.Literals.MODULE_DEFINITION__OUTPUTS);
            childrenFeatures.add(HwmodulesPackage.Literals.MODULE_DEFINITION__PARAMETERS);
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
     * This returns ModuleDefinition.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ModuleDefinition"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((ModuleDefinition) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_ModuleDefinition_type")
                : getString("_UI_ModuleDefinition_type") + " " + label;
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

        switch (notification.getFeatureID(ModuleDefinition.class)) {
        case HwmodulesPackage.MODULE_DEFINITION__ID:
        case HwmodulesPackage.MODULE_DEFINITION__NAME:
        case HwmodulesPackage.MODULE_DEFINITION__RUNTIME:
        case HwmodulesPackage.MODULE_DEFINITION__PAST_VALUE_COUNT:
        case HwmodulesPackage.MODULE_DEFINITION__DISPLAY_NAME:
        case HwmodulesPackage.MODULE_DEFINITION__DESCRIPTION:
        case HwmodulesPackage.MODULE_DEFINITION__CATEGORY:
        case HwmodulesPackage.MODULE_DEFINITION__GROUP_ID:
        case HwmodulesPackage.MODULE_DEFINITION__REQUIRE_MICAS_VERSION:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case HwmodulesPackage.MODULE_DEFINITION__INPUTS:
        case HwmodulesPackage.MODULE_DEFINITION__OUTPUTS:
        case HwmodulesPackage.MODULE_DEFINITION__PARAMETERS:
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

        newChildDescriptors.add(createChildParameter(HwmodulesPackage.Literals.MODULE_DEFINITION__INPUTS,
                HwmodulesFactory.eINSTANCE.createPort()));

        newChildDescriptors.add(createChildParameter(HwmodulesPackage.Literals.MODULE_DEFINITION__INPUTS,
                HwmodulesFactory.eINSTANCE.createPortGroup()));

        newChildDescriptors.add(createChildParameter(HwmodulesPackage.Literals.MODULE_DEFINITION__OUTPUTS,
                HwmodulesFactory.eINSTANCE.createPort()));

        newChildDescriptors.add(createChildParameter(HwmodulesPackage.Literals.MODULE_DEFINITION__OUTPUTS,
                HwmodulesFactory.eINSTANCE.createPortGroup()));

        newChildDescriptors.add(createChildParameter(HwmodulesPackage.Literals.MODULE_DEFINITION__PARAMETERS,
                HwmodulesFactory.eINSTANCE.createParameter()));
    }

    /**
     * This returns the label text for
     * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify = childFeature == HwmodulesPackage.Literals.MODULE_DEFINITION__INPUTS
                || childFeature == HwmodulesPackage.Literals.MODULE_DEFINITION__OUTPUTS;

        if (qualify) {
            return getString("_UI_CreateChild_text2",
                    new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
        }
        return super.getCreateChildText(owner, feature, child, selection);
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return HwmodulesEditPlugin.INSTANCE;
    }

}
