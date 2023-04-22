/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.provider;

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

import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtPackage;

/**
 * This is the item provider adapter for a
 * {@link de.wisag.automation.micas.rt.RtModule} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RtModuleItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtModuleItemProvider(AdapterFactory adapterFactory) {
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

            addDataSegmentAddressPropertyDescriptor(object);
            addStartSegmentAddressPropertyDescriptor(object);
            addFirstTaskSegmentAddressPropertyDescriptor(object);
            addHeadModuleSegmentAddressPropertyDescriptor(object);
            addDataSegmentCheckSumPropertyDescriptor(object);
            addTasksCheckSumPropertyDescriptor(object);
            addWordConstOffsetPropertyDescriptor(object);
            addFloatConstOffsetPropertyDescriptor(object);
            addWordVarOffsetPropertyDescriptor(object);
            addFloatVarOffsetPropertyDescriptor(object);
            addEndOfFloatVarsPropertyDescriptor(object);
            addDataSegmentPropertyDescriptor(object);
            addHwTypePropertyDescriptor(object);
            addFieldBusPropertyDescriptor(object);
            addPastValuesOffsetPropertyDescriptor(object);
            addPastValuesLastOffsetPropertyDescriptor(object);
            addHeadModuleSegmentPropertyDescriptor(object);
            addSourceModificationStampPropertyDescriptor(object);
            addSourceNamePropertyDescriptor(object);
            addSourceChecksumPropertyDescriptor(object);
            addCommentsPropertyDescriptor(object);
            addStartSegmentPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Data Segment Address feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataSegmentAddressPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_dataSegmentAddress_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_dataSegmentAddress_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__DATA_SEGMENT_ADDRESS, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Start Segment Address feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStartSegmentAddressPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_startSegmentAddress_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_startSegmentAddress_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__START_SEGMENT_ADDRESS, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the First Task Segment Address
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFirstTaskSegmentAddressPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_firstTaskSegmentAddress_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_firstTaskSegmentAddress_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Head Module Segment Address
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addHeadModuleSegmentAddressPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_headModuleSegmentAddress_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_headModuleSegmentAddress_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Data Segment Check Sum feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataSegmentCheckSumPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_dataSegmentCheckSum_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_dataSegmentCheckSum_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__DATA_SEGMENT_CHECK_SUM, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Word Const Offset feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addWordConstOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_wordConstOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_wordConstOffset_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__WORD_CONST_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Float Const Offset feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFloatConstOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_floatConstOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_floatConstOffset_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__FLOAT_CONST_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Word Var Offset feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addWordVarOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_wordVarOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_wordVarOffset_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__WORD_VAR_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Float Var Offset feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFloatVarOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_floatVarOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_floatVarOffset_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__FLOAT_VAR_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the End Of Float Vars feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addEndOfFloatVarsPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_endOfFloatVars_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_endOfFloatVars_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__END_OF_FLOAT_VARS, true, false, false,
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
                        getResourceLocator(), getString("_UI_RtModule_dataSegment_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_dataSegment_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__DATA_SEGMENT, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Hw Type feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addHwTypePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_hwType_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_hwType_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__HW_TYPE, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Field Bus feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFieldBusPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_fieldBus_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_fieldBus_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__FIELD_BUS, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Past Values Offset feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPastValuesOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_pastValuesOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_pastValuesOffset_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__PAST_VALUES_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Past Values Last Offset feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPastValuesLastOffsetPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_pastValuesLastOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_pastValuesLastOffset_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__PAST_VALUES_LAST_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Tasks Check Sum feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addTasksCheckSumPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_tasksCheckSum_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_tasksCheckSum_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__TASKS_CHECK_SUM, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Head Module Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addHeadModuleSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_headModuleSegment_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_headModuleSegment_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__HEAD_MODULE_SEGMENT, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Source Modification Stamp
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSourceModificationStampPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_sourceModificationStamp_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_sourceModificationStamp_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__SOURCE_MODIFICATION_STAMP, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Source Name feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSourceNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_sourceName_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_sourceName_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__SOURCE_NAME, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Source Checksum feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSourceChecksumPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_sourceChecksum_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_sourceChecksum_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__SOURCE_CHECKSUM, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Comments feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addCommentsPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_comments_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_comments_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__COMMENTS, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Start Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStartSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtModule_startSegment_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtModule_startSegment_feature",
                                "_UI_RtModule_type"),
                        RtPackage.Literals.RT_MODULE__START_SEGMENT, true, false, false,
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
            childrenFeatures.add(RtPackage.Literals.RT_MODULE__SYMBOLS);
            childrenFeatures.add(RtPackage.Literals.RT_MODULE__TASKS);
            childrenFeatures.add(RtPackage.Literals.RT_MODULE__HEAD_MODUL);
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
     * This returns RtModule.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/RtModule"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((RtModule) object).getSourceName();
        return label == null || label.length() == 0 ? getString("_UI_RtModule_type")
                : getString("_UI_RtModule_type") + " " + label;
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

        switch (notification.getFeatureID(RtModule.class)) {
        case RtPackage.RT_MODULE__DATA_SEGMENT_ADDRESS:
        case RtPackage.RT_MODULE__START_SEGMENT_ADDRESS:
        case RtPackage.RT_MODULE__FIRST_TASK_SEGMENT_ADDRESS:
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT_ADDRESS:
        case RtPackage.RT_MODULE__DATA_SEGMENT_CHECK_SUM:
        case RtPackage.RT_MODULE__TASKS_CHECK_SUM:
        case RtPackage.RT_MODULE__WORD_CONST_OFFSET:
        case RtPackage.RT_MODULE__FLOAT_CONST_OFFSET:
        case RtPackage.RT_MODULE__WORD_VAR_OFFSET:
        case RtPackage.RT_MODULE__FLOAT_VAR_OFFSET:
        case RtPackage.RT_MODULE__END_OF_FLOAT_VARS:
        case RtPackage.RT_MODULE__DATA_SEGMENT:
        case RtPackage.RT_MODULE__HW_TYPE:
        case RtPackage.RT_MODULE__FIELD_BUS:
        case RtPackage.RT_MODULE__PAST_VALUES_OFFSET:
        case RtPackage.RT_MODULE__PAST_VALUES_LAST_OFFSET:
        case RtPackage.RT_MODULE__HEAD_MODULE_SEGMENT:
        case RtPackage.RT_MODULE__SOURCE_MODIFICATION_STAMP:
        case RtPackage.RT_MODULE__SOURCE_NAME:
        case RtPackage.RT_MODULE__SOURCE_CHECKSUM:
        case RtPackage.RT_MODULE__COMMENTS:
        case RtPackage.RT_MODULE__START_SEGMENT:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case RtPackage.RT_MODULE__SYMBOLS:
        case RtPackage.RT_MODULE__TASKS:
        case RtPackage.RT_MODULE__HEAD_MODUL:
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

        newChildDescriptors
                .add(createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS, RtFactory.eINSTANCE.createRtSymbol()));

        newChildDescriptors.add(
                createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS, RtFactory.eINSTANCE.createRtConstant()));

        newChildDescriptors.add(
                createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS, RtFactory.eINSTANCE.createRtVariable()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS,
                RtFactory.eINSTANCE.createRtWordConstant()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS,
                RtFactory.eINSTANCE.createRtFloatConstant()));

        newChildDescriptors.add(
                createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS, RtFactory.eINSTANCE.createRtDirectValue()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS,
                RtFactory.eINSTANCE.createRtWordVariable()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS,
                RtFactory.eINSTANCE.createRtFloatVariable()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_MODULE__SYMBOLS,
                RtFactory.eINSTANCE.createRtReferenceConstant()));

        newChildDescriptors
                .add(createChildParameter(RtPackage.Literals.RT_MODULE__TASKS, RtFactory.eINSTANCE.createRtTask()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_MODULE__HEAD_MODUL,
                RtFactory.eINSTANCE.createRtHeadModule()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return RtEditPlugin.INSTANCE;
    }

}
