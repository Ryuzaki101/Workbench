package de.wisag.automation.micas.module.ui.internal.printing;

import static com.google.common.base.Strings.isNullOrEmpty;

import org.apache.batik.dom.GenericText;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SvgPlaceholderInserter {
    public interface PlaceholderCallback {
        String resolvePlaceholders(String name);
    }

    public void process(Document template, PlaceholderCallback callback) {
        visit(template, 0, callback);
    }

    // This method visits all the nodes in a DOM tree
    void visit(Node node, int level, PlaceholderCallback callback) {
        // Process node
        if ("tspan".equalsIgnoreCase(node.getLocalName()) && node.getChildNodes().getLength() > 0) {
            Node child = node.getChildNodes().item(0);
            GenericText gText = (child instanceof GenericText) ? (GenericText) child : null;
            String text = gText != null ? gText.getNodeValue() : null;
            if (!isNullOrEmpty(text) && text.indexOf(PlaceholderResolver.START_TOKEN) > -1) {
                String newValue = callback.resolvePlaceholders(text);
                if (newValue != null) {
                    gText.setNodeValue(newValue);
                }
            }
        }
        // If there are any children, visit each one
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            // Get child node
            Node childNode = list.item(i);
            // Visit child node
            visit(childNode, level + 1, callback);
        }
    }

}
