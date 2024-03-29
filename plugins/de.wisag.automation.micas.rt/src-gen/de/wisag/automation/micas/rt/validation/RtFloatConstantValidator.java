/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.validation;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.rt.RtFloatConstant}. This doesn't really do
 * anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RtFloatConstantValidator {
    boolean validate();

    boolean validateValue(double value);

    boolean validateValue(float value);
}
