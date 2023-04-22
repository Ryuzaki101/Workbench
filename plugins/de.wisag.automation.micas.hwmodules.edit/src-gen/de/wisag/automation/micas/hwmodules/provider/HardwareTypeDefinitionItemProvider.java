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

import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwmodulesFactory;
import de.wisag.automation.micas.hwmodules.HwmodulesPackage;

/**
 * This is the item provider adapter for a
 * {@link de.wisag.automation.micas.hwmodules.HardwareTypeDefinition} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class HardwareTypeDefinitionItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public HardwareTypeDefinitionItemProvider(AdapterFactory adapterFactory) {
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

            addTypePropertyDescriptor(object);
            addDatabaseSegmentPropertyDescriptor(object);
            addDatabaseChecksumAddressPropertyDescriptor(object);
            addAddressConversionListAddressPropertyDescriptor(object);
            addHeadSegmentPropertyDescriptor(object);
            addEndModuleOpcodePropertyDescriptor(object);
            addDataSegmentPropertyDescriptor(object);
            addStackSegmentPropertyDescriptor(object);
            addProgramSegmentPropertyDescriptor(object);
            addMaxProgramSizePropertyDescriptor(object);
            addPastValuesOffsetFirstTaskPropertyDescriptor(object);
            addMaxTaskCountPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Type feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_HardwareTypeDefinition_type_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_HardwareTypeDefinition_type_feature",
                        "_UI_HardwareTypeDefinition_type"),
                HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__TYPE, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Database Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDatabaseSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_HardwareTypeDefinition_databaseSegment_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_HardwareTypeDefinition_databaseSegment_feature",
                        "_UI_HardwareTypeDefinition_type"),
                HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Database Checksum Address
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDatabaseChecksumAddressPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_databaseChecksumAddress_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_databaseChecksumAddress_feature",
                                "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS, true, false,
                        false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Address Conversion List Address
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAddressConversionListAddressPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_HardwareTypeDefinition_addressConversionListAddress_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_HardwareTypeDefinition_addressConversionListAddress_feature",
                        "_UI_HardwareTypeDefinition_type"),
                HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Head Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addHeadSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_headSegment_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_headSegment_feature", "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the End Module Opcode feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addEndModuleOpcodePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_HardwareTypeDefinition_endModuleOpcode_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_HardwareTypeDefinition_endModuleOpcode_feature",
                        "_UI_HardwareTypeDefinition_type"),
                HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE, true, false, false,
                ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Data Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_dataSegment_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_dataSegment_feature", "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Stack Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStackSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_stackSegment_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_stackSegment_feature", "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Program Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addProgramSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_programSegment_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_programSegment_feature", "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Max Program Size feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMaxProgramSizePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_maxProgramSize_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_maxProgramSize_feature", "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Past Values Offset First Task
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPastValuesOffsetFirstTaskPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_pastValuesOffsetFirstTask_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_pastValuesOffsetFirstTask_feature",
                                "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK, true, false,
                        false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Max Task Count feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMaxTaskCountPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_HardwareTypeDefinition_maxTaskCount_feature"),
                        getString("_UI_PropertyDescriptor_description",
                                "_UI_HardwareTypeDefinition_maxTaskCount_feature", "_UI_HardwareTypeDefinition_type"),
                        HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
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
            childrenFeatures.add(HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__ALIASES);
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
     * This returns HardwareTypeDefinition.gif. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/HardwareTypeDefinition"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText(Object object) {
        HardwareType labelValue = ((HardwareTypeDefinition) object).getType();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ? getString("_UI_HardwareTypeDefinition_type")
                : getString("_UI_HardwareTypeDefinition_type") + " " + label;
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

        switch (notification.getFeatureID(HardwareTypeDefinition.class)) {
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__TYPE:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_SEGMENT:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATABASE_CHECKSUM_ADDRESS:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ADDRESS_CONVERSION_LIST_ADDRESS:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__HEAD_SEGMENT:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__END_MODULE_OPCODE:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__DATA_SEGMENT:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__STACK_SEGMENT:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PROGRAM_SEGMENT:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_PROGRAM_SIZE:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__PAST_VALUES_OFFSET_FIRST_TASK:
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__MAX_TASK_COUNT:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case HwmodulesPackage.HARDWARE_TYPE_DEFINITION__ALIASES:
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

        newChildDescriptors.add(createChildParameter(HwmodulesPackage.Literals.HARDWARE_TYPE_DEFINITION__ALIASES,
                HwmodulesFactory.eINSTANCE.createHardwareAlias()));
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
