package de.wisag.automation.micas.module.ui.forms;

import com.google.common.collect.Multimap;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;

public interface IAttributeSpecificationProvider {
    Multimap<Attribute, AttributeSpecification> getAllAttributeSpecificationsByAttributes();
}
