package de.wisag.automation.micas.export.mic.internal;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;

import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.Task;

public class ExtendedDiagramModuleValidator {
    IStatus validate(Module module) {
        for (EObject eObject : findUnresolvedProxies(module.eResource())) {
            System.out.println("Unresolved : " + eObject);

        }
        /**
         * for (EObject eObject : module.eResource().getContents()) { if
         * (eObject instanceof Attribute) { Attribute attribute = (Attribute)
         * eObject; System.out.println(attribute + " container : " +
         * attribute.eContainer()); } }
         */

        return Status.OK_STATUS;
    }

    public void traverse(EList<?> children, int depth) {
        for (Object object : children) {
            Node node = (Node) object;
            System.out.println(StringUtils.repeat(" ", depth) + node.getElement());
            traverse(node.getChildren(), depth + 1);
        }
    }

    public static void xx(Module module) {
        for (EObject eObject : module.eResource().getContents()) {
            if (eObject instanceof Diagram) {
                Diagram diagram = (Diagram) eObject;
                EObject element = diagram.getElement();
                System.out.println(diagram.getName() + " -> " + element);
                if (element == null) {
                    continue;
                }
            }
        }
        EList<Task> tasks = module.getTasks();
        for (Task task : tasks) {
            System.out.println("Task : " + task.getName());
            for (Page page : task.getPages()) {
                System.out.println("  Page : " + page.getName());
                EList<Component> components = page.getComponents();
                for (Component component : components) {
                    if (component instanceof Block) {
                        Block block = (Block) component;
                        System.out.println("    Block : " + block.getName());

                    } else if (component instanceof IncomingOffpageConnector) {
                        IncomingOffpageConnector incoming = (IncomingOffpageConnector) component;
                        System.out.println("    In : " + incoming.getName());

                    } else if (component instanceof Constant) {
                        Constant constant = (Constant) component;
                        System.out.println("    Const : " + constant.getName());
                    } else if (component instanceof Reference) {
                        Reference reference = (Reference) component;

                    } else if (component instanceof OutgoingOffpageConnector) {
                        OutgoingOffpageConnector outgoing = (OutgoingOffpageConnector) component;
                    }

                }
            }
        }

    }

    public static Set<EObject> findUnresolvedProxies(Resource resource) {
        Set<EObject> unresolvedProxies = new LinkedHashSet<>();

        for (Iterator<EObject> elementIt = EcoreUtil.getAllContents(resource, true); elementIt.hasNext();) {
            InternalEObject nextElement = (InternalEObject) elementIt.next();
            if (nextElement.eIsProxy()) {
                unresolvedProxies.add(nextElement);
            }
            for (EObject crElement : nextElement.eCrossReferences()) {
                crElement = EcoreUtil.resolve(crElement, resource);
                if (crElement.eIsProxy()) {
                    unresolvedProxies.add(crElement);
                }
            }
        }
        return unresolvedProxies;
    }
}
