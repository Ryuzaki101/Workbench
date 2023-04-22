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
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtTask;

/**
 * This is the item provider adapter for a
 * {@link de.wisag.automation.micas.rt.RtTask} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RtTaskItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RtTaskItemProvider(AdapterFactory adapterFactory) {
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
            addCyclTimePropertyDescriptor(object);
            addSegmentPropertyDescriptor(object);
            addPastValuesOffsetPropertyDescriptor(object);
            addStrategyPropertyDescriptor(object);
            addDataPropertyDescriptor(object);
            addRuntimePropertyDescriptor(object);
            addPastValuesCountPropertyDescriptor(object);
            addCommentPropertyDescriptor(object);
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
                        getResourceLocator(), getString("_UI_RtTask_id_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_id_feature", "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__ID, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                        null, null));
    }

    /**
     * This adds a property descriptor for the Cycl Time feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addCyclTimePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtTask_cyclTime_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_cyclTime_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__CYCL_TIME, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Segment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSegmentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtTask_segment_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_segment_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__SEGMENT, true, false, false,
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
                        getResourceLocator(), getString("_UI_RtTask_pastValuesOffset_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_pastValuesOffset_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__PAST_VALUES_OFFSET, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Strategy feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStrategyPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtTask_strategy_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_strategy_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__STRATEGY, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Data feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDataPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtTask_data_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_data_feature", "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__DATA, true, false, false,
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
                        getResourceLocator(), getString("_UI_RtTask_runtime_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_runtime_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__RUNTIME, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Past Values Count feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPastValuesCountPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtTask_pastValuesCount_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_pastValuesCount_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__PAST_VALUES_COUNT, true, false, false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Comment feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addCommentPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_RtTask_comment_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_RtTask_comment_feature",
                                "_UI_RtTask_type"),
                        RtPackage.Literals.RT_TASK__COMMENT, true, false, false,
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
            childrenFeatures.add(RtPackage.Literals.RT_TASK__MODULE_INVOCATIONS);
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
     * This returns RtTask.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/RtTask"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        RtTask rtTask = (RtTask) object;
        return getString("_UI_RtTask_type") + " " + rtTask.getId();
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

        switch (notification.getFeatureID(RtTask.class)) {
        case RtPackage.RT_TASK__ID:
        case RtPackage.RT_TASK__CYCL_TIME:
        case RtPackage.RT_TASK__SEGMENT:
        case RtPackage.RT_TASK__PAST_VALUES_OFFSET:
        case RtPackage.RT_TASK__STRATEGY:
        case RtPackage.RT_TASK__DATA:
        case RtPackage.RT_TASK__RUNTIME:
        case RtPackage.RT_TASK__PAST_VALUES_COUNT:
        case RtPackage.RT_TASK__COMMENT:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case RtPackage.RT_TASK__MODULE_INVOCATIONS:
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

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_TASK__MODULE_INVOCATIONS,
                RtFactory.eINSTANCE.createRtModuleInvocation()));

        newChildDescriptors.add(createChildParameter(RtPackage.Literals.RT_TASK__MODULE_INVOCATIONS,
                RtFactory.eINSTANCE.createRtCommentModuleInvocation()));
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
