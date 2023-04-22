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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.edit.provider.SystemItemProvider;

import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.Page;

/**
 * This is the item provider adapter for a
 * {@link de.wisag.automation.micas.module.Page} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PageItemProvider extends SystemItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PageItemProvider(AdapterFactory adapterFactory) {
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

        }
        return itemPropertyDescriptors;
    }

    /**
     * This returns Page.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Page"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Page) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_Page_type")
                : getString("_UI_Page_type") + " " + label;
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

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__COMPONENTS,
                ModuleFactory.eINSTANCE.createIncomingOffpageConnector()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__COMPONENTS,
                ModuleFactory.eINSTANCE.createOutgoingOffpageConnector()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__COMPONENTS,
                ModuleFactory.eINSTANCE.createConstant()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__COMPONENTS,
                ModuleFactory.eINSTANCE.createReference()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS,
                ModuleFactory.eINSTANCE.createIncomingOffpageConnector()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS,
                ModuleFactory.eINSTANCE.createOutgoingOffpageConnector()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS,
                ModuleFactory.eINSTANCE.createConstant()));

        newChildDescriptors.add(createChildParameter(DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS,
                ModuleFactory.eINSTANCE.createReference()));
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

        boolean qualify = childFeature == DMLPackage.Literals.FRAGMENT__COMPONENTS
                || childFeature == DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS
                || childFeature == DMLPackage.Literals.FRAGMENT__CONNECTIONS;

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
        return ModuleEditPlugin.INSTANCE;
    }

}
