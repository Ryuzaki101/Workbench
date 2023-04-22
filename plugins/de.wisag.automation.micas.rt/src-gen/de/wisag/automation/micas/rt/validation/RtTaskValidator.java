/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.validation;

import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtTaskStrategy;

/**
 * A sample validator interface for {@link de.wisag.automation.micas.rt.RtTask}.
 * This doesn't really do anything, and it's not a real EMF artifact. It was
 * generated by the org.eclipse.emf.examples.generator.validator plug-in to
 * illustrate how EMF's code generator can be extended. This can be disabled
 * with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RtTaskValidator {
    boolean validate();

    boolean validateModule(RtModule value);

    boolean validateModuleInvocations(EList<RtModuleInvocation> value);

    boolean validateId(int value);

    boolean validateCyclTime(int value);

    boolean validateSegment(int value);

    boolean validatePastValuesOffset(int value);

    boolean validateStrategy(RtTaskStrategy value);

    boolean validateData(byte[] value);

    boolean validateRuntime(int value);

    boolean validatePastValuesCount(int value);

    boolean validateComment(String value);
}
