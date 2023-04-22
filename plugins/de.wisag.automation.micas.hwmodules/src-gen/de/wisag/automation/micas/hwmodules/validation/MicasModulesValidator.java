/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.hwmodules.validation;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.hwmodules.MicasModules}. This doesn't really
 * do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MicasModulesValidator {
    boolean validate();

    boolean validateModulesById(Map<Integer, ModuleDefinition> value);

    boolean validateModulesByName(Map<String, ModuleDefinition> value);

    boolean validateModules(EList<ModuleDefinition> value);

    boolean validateTypes(EList<HardwareTypeDefinition> value);
}
