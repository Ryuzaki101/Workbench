/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.module.validation;

import de.wisag.automation.micas.module.DataType;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.module.Attribute}. This doesn't really do
 * anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface AttributeValidator {
    boolean validate();

    boolean validateName(String value);

    boolean validateDataType(DataType value);

    boolean validateDescription(String value);
}