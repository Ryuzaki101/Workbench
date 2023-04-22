package de.wisag.automation.micas.module.ui.forms;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.progress.UIJob;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;

final class UsedSymbolsViewerUpdater implements IListChangeListener<Attribute> {
    /**
     *
     */
    private final IAttributeSpecificationProvider attributeSpecificationProvider;
    private final List<Object> usedSymbolsModel;

    public UsedSymbolsViewerUpdater(IAttributeSpecificationProvider attributeSpecificationProvider,
            List<Object> usedSymbolsContent) {
        this.attributeSpecificationProvider = attributeSpecificationProvider;
        this.usedSymbolsModel = usedSymbolsContent;
    }

    @Override
    public void handleListChange(ListChangeEvent<? extends Attribute> event) {
        IObservableList<? extends Attribute> values = event.getObservableList();

        UIJob job = new UIJob("Update References") {
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                usedSymbolsModel.clear();
                if (values.isEmpty() || values.size() > 1) {

                    return Status.OK_STATUS;
                }

                Multimap<Attribute, AttributeSpecification> allSpecs = attributeSpecificationProvider
                        .getAllAttributeSpecificationsByAttributes();
                // handle only one attribute
                Attribute fa = values.iterator().next();
                Collection<AttributeSpecification> references = allSpecs.get(fa);
                List<AttributeSpecificationLocation> symbolReferences = Lists.newArrayList();
                for (AttributeSpecification spec : references) {
                    symbolReferences.add(findAttributeSpecificationLocation(spec));

                }
                usedSymbolsModel.addAll(symbolReferences);
                return Status.OK_STATUS;
            }

            private AttributeSpecificationLocation findAttributeSpecificationLocation(AttributeSpecification spec) {
                Task task = null;
                Page page = null;
                EObject container = spec.eContainer();
                while (container != null && !(container instanceof Module)) {
                    if (task != null && page != null) {
                        break;
                    } else if (container instanceof Task) {
                        task = (Task) container;
                    } else if (container instanceof Page) {
                        page = (Page) container;
                    }
                    container = container.eContainer();
                }
                return new AttributeSpecificationLocation(task, page, spec);
            }
        };
        job.setSystem(true);
        job.schedule();

    }

}