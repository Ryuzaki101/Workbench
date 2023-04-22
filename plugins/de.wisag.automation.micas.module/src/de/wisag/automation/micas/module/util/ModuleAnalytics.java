package de.wisag.automation.micas.module.util;

import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Sets;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Module;

public abstract class ModuleAnalytics {

    public static Set<Attribute> getUnusedAttributes(Module module) {
        final Set<Attribute> unused = Sets.newHashSet();
        unused.addAll(module.getAttributes());
        TreeIterator<EObject> allContent = EcoreUtil.getAllContents(module.eResource(), true);
        final ModuleSwitch<Object> modelSwitch = new ModuleSwitch<Object>() {
            @Override
            public Object caseAttributeSpecification(AttributeSpecification spec) {
                if (spec.getAttribute() != null) {
                    unused.remove(spec.getAttribute());
                }
                return null;
            }
        };
        while (allContent.hasNext()) {
            modelSwitch.doSwitch(allContent.next());
        }
        return unused;
    }

}
