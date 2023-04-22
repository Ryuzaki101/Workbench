/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.validation;

import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.olt.device.Address;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.olt.device.DataRange}. This doesn't really
 * do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface DataRangeValidator {
    boolean validate();

    boolean validateStartAddress(Address value);

    boolean validateValues(EList<Integer> value);
}
