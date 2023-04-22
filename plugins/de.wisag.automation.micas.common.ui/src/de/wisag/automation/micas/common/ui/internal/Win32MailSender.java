// package de.wisag.automation.micas.common.ui.internal;
//
//
// import org.eclipse.core.runtime.IStatus;
// import org.eclipse.core.runtime.Status;
// import org.eclipse.swt.SWT;
// import org.eclipse.swt.internal.win32.OS;
// import org.eclipse.swt.internal.win32.TCHAR;
// import org.eclipse.swt.ole.win32.OLE;
// import org.eclipse.swt.ole.win32.OleAutomation;
// import org.eclipse.swt.ole.win32.OleClientSite;
// import org.eclipse.swt.ole.win32.OleFrame;
// import org.eclipse.swt.ole.win32.Variant;
// import org.eclipse.swt.widgets.Display;
// import org.eclipse.swt.widgets.Shell;
//
// import de.wisag.automation.micas.common.ui.IMailSender;
//
// @SuppressWarnings("restriction")
// public class Win32MailSender extends DesktopMailSender implements IMailSender
// {
// private static String MAIL_KEY = "SOFTWARE\\Clients\\Mail";
// private static String OUTLOOK = "Microsoft Outlook";
//
// @Override
// public IStatus sendMail(String to, String subject, String messageBody) {
// IStatus status = Status.OK_STATUS;
// String defaultMailer = geDefaultMailer();
// if (OUTLOOK.equals(defaultMailer)) {
// status = sendOutlookMail(to, subject, messageBody);
// } else {
// status = sendDefaultMail(to, subject, messageBody);
// }
//
//
// return status;
// }
//
// private String geDefaultMailer() {
// String mailer = null;
// mailer = queryMailer(mailer, OS.HKEY_CURRENT_USER);
// if (mailer==null || mailer.length()==0) {
// mailer = queryMailer(mailer, OS.HKEY_LOCAL_MACHINE);
// }
// return mailer;
// }
//
// private String queryMailer(String mailer, int rootKey) {
// TCHAR key = new TCHAR(0, MAIL_KEY, true); //$NON-NLS-1$
// long[] phkResult = new long /* long */[1];
// if (OS.RegOpenKeyEx(rootKey, key, 0, OS.KEY_READ,
// phkResult) == 0) {
// int[] lpcbData = new int[1];
// int result = OS.RegQueryValueEx(phkResult[0], null, 0, null,
// (TCHAR) null, lpcbData);
// if (result == 0) {
// TCHAR lpData = new TCHAR(0, lpcbData[0] / TCHAR.sizeof);
// result = OS.RegQueryValueEx(phkResult[0], null, 0, null,
// lpData, lpcbData);
// if (result == 0) {
// mailer = lpData.toString(0, lpData.strlen());
// }
// }
// }
// OS.RegCloseKey(phkResult[0]);
// return mailer;
// }
//
// private IStatus sendOutlookMail(String to, String subject, String body) {
// Display display = Display.getCurrent();
// Shell shell = new Shell(display);
// OleFrame frame = new OleFrame(shell, SWT.NONE);
// // This should start outlook if it is not running yet
// OleClientSite site = new OleClientSite(frame, SWT.NONE, "OVCtl.OVCtl");
// site.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);
// // Now get the outlook application
// OleClientSite site2 = new OleClientSite(frame, SWT.NONE,
// "Outlook.Application");
// OleAutomation outlook = new OleAutomation(site2);
// //
// OleAutomation mail = invoke(outlook, "CreateItem", 0 /* Mail item */)
// .getAutomation();
// setProperty(mail, "To", to); /*
// * Empty but could also be predefined
// */
// setProperty(mail, "BodyFormat", 1 /* olFormatPlain = 1 */);
// setProperty(mail, "Subject", subject);
// setProperty(mail, "Body", body);
// invoke(mail, "Display" /* or "Send" */);
// return Status.OK_STATUS;
// }
//
// private static boolean setProperty(OleAutomation auto, String name,
// String value) {
// return auto.setProperty(property(auto, name), new Variant(value));
// }
//
// private static boolean setProperty(OleAutomation auto, String name,
// int value) {
// return auto.setProperty(property(auto, name), new Variant(value));
// }
//
// private static Variant invoke(OleAutomation auto, String command) {
// return auto.invoke(property(auto, command));
// }
//
// private static Variant invoke(OleAutomation auto, String command, int value)
// {
// return auto.invoke(property(auto, command),
// new Variant[] { new Variant(value) });
// }
//
// private static int property(OleAutomation auto, String name) {
// return auto.getIDsOfNames(new String[] { name })[0];
// }
//
// public static void main(String[] args) throws Exception {
// Win32MailSender sender = new Win32MailSender();
// sender.sendMail("sag@ich.net", "SUBJECT", "Hello World");
// }
// }
