/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.rt.validation;

import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtTaskInfo;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.rt.RtHeadModule}. This doesn't really do
 * anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RtHeadModuleValidator {
    boolean validate();

    boolean validateModule(RtModule value);

    boolean validateTaskInfos(EList<RtTaskInfo> value);

    boolean validateMagic0(int value);

    boolean validateMagic1(int value);

    boolean validateTaskCount(int value);
}