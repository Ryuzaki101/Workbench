/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.wisag.automation.micas.olt.device.validation;

import java.util.Date;

import de.wisag.automation.micas.olt.device.ConnectionInfo;
import de.wisag.automation.micas.olt.device.DeviceInfo;

/**
 * A sample validator interface for
 * {@link de.wisag.automation.micas.olt.device.Connection}. This doesn't really
 * do anything, and it's not a real EMF artifact. It was generated by the
 * org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's
 * code generator can be extended. This can be disabled with -vmargs
 * -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ConnectionValidator {
    boolean validate();

    boolean validateConnectionInfo(ConnectionInfo value);

    boolean validateLogin(String value);

    boolean validatePassword(String value);

    boolean validateConnectedSince(Date value);

    boolean validateDeviceInfo(DeviceInfo value);
}
