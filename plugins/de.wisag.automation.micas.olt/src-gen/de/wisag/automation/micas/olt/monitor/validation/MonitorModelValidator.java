/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.monitor.validation;

import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.rt.RtModule;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.olt.monitor.MonitorModel}. This doesn't
 * really do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MonitorModelValidator {
    boolean validate();

    boolean validateItems(EList<MonitoredItem> value);

    boolean validateLastUpdated(long value);

    boolean validateActive(boolean value);

    boolean validateRtModule(RtModule value);
}
