package de.wisag.automation.micas.module.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class NewMicasProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

    /*
     * Use the WizardNewProjectCreationPage, which is provided by the Eclipse
     * framework.
     */
    private WizardNewProjectCreationPage wizardPage;
    private IConfigurationElement config;
    private IWorkbench workbench;
    private IProject project;

    /**
     * Constructor
     */
    public NewMicasProjectWizard() {
        super();
    }

    @Override
    public void addPages() {
        /*
         * Unlike the custom new wizard, we just add the pre-defined one and
         * don't necessarily define our own.
         */
        wizardPage = new WizardNewProjectCreationPage("NewMicasProject");
        wizardPage.setDescription("Create a new MICAS Project.");
        wizardPage.setTitle("New MICAS Project");
        addPage(wizardPage);
    }

    @Override
    public boolean performFinish() {

        if (project != null) {
            return true;
        }

        final IProject projectHandle = wizardPage.getProjectHandle();

        URI projectURI = (!wizardPage.useDefaults()) ? wizardPage.getLocationURI() : null;

        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        final IProjectDescription desc = workspace
                .newProjectDescription(projectHandle != null ? projectHandle.getName() : "unnamed");
        desc.setLocationURI(projectURI);
        desc.setNatureIds(
                new String[] { "de.wisag.automation.micas.nature", "org.eclipse.xtext.ui.shared.xtextNature" });
        ICommand[] newCommands = new ICommand[2];

        ICommand command = desc.newCommand();
        command.setBuilderName("de.wisag.automation.micas.builder");
        newCommands[0] = command;
        command = desc.newCommand();
        command.setBuilderName("org.eclipse.xtext.ui.shared.xtextBuilder");
        newCommands[1] = command;
        desc.setBuildSpec(newCommands);

        /*
         * Just like the ExampleWizard, but this time with an operation object
         * that modifies workspaces.
         */
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor monitor) throws CoreException {
                createProject(desc, projectHandle, monitor);
            }
        };

        /*
         * This isn't as robust as the code in the BasicNewProjectResourceWizard
         * class. Consider beefing this up to improve error handling.
         */
        try {
            getContainer().run(true, true, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), "Error", realException.getMessage());
            return false;
        }

        project = projectHandle;

        if (project == null) {
            return false;
        }

        BasicNewProjectResourceWizard.updatePerspective(config);
        BasicNewResourceWizard.selectAndReveal(project, workbench.getActiveWorkbenchWindow());

        return true;
    }

    /**
     * This creates the project in the workspace.
     *
     * @param description
     * @param projectHandle
     * @param monitor
     * @throws CoreException
     * @throws OperationCanceledException
     */
    /**
     * This creates the project in the workspace.
     *
     * @param description
     * @param projectHandle
     * @param monitor
     * @throws CoreException
     * @throws OperationCanceledException
     */
    void createProject(IProjectDescription description, IProject proj, IProgressMonitor monitor)
            throws CoreException, OperationCanceledException {
        try {

            monitor.beginTask("", 2000);

            proj.create(description, new SubProgressMonitor(monitor, 1000));

            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }

            proj.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 1000));

        } finally {
            monitor.done();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
    }

    /**
     * Sets the initialization data for the wizard.
     */
    @Override
    public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
            throws CoreException {
        this.config = config;
    }
}