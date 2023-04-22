package de.wisag.automation.micas.module.ui.editor;

import static de.wisag.automation.micas.common.HardcodedValues.ANONYMOUS_VAR_PREFIX;
import static de.wisag.automation.micas.module.ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE;
import static de.wisag.automation.micas.module.ModulePackage.Literals.MODULE__ATTRIBUTES;
import static de.wisag.automation.micas.module.util.AttributeUtils.createVariableAttribute;

import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileEditorInputProxy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipselabs.damos.dml.Connection;

import de.wisag.automation.micas.common.ui.IDocumentSaveOperation;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.ui.forms.OverviewPage;
import de.wisag.automation.micas.module.ui.forms.OverviewPageController;
import de.wisag.automation.micas.module.ui.forms.SymbolsPage;
import de.wisag.automation.micas.module.ui.forms.SymbolsPageController;
import de.wisag.automation.micas.module.ui.internal.Policy;
import de.wisag.automation.micas.module.util.BlockUtils;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class ModulesFormEditor extends FormEditor
        implements IModelProvider<Module>, IDocumentSaveOperation, IResourceChangeListener {

    private final class MakeEditorDirtyListener implements CommandStackListener {
        private final ModulesFormEditor formEditor;

        public ModulesFormEditor getFormEditor() {
            return formEditor;
        }

        public MakeEditorDirtyListener(ModulesFormEditor formEditor) {
            super();
            this.formEditor = formEditor;
        }

        @Override
        public void commandStackChanged(final EventObject event) {
            getFormEditor().getContainer().getDisplay().syncExec(new Runnable() {
                @Override
                public void run() {
                    ModulesFormEditor.this.dirty = true;
                    firePropertyChange(IEditorPart.PROP_DIRTY);
                }
            });
        }
    }

    private Module model;
    private TransactionalEditingDomain editingDomain;
    private DataBindingContext dataBindingContext;
    private boolean dirty = false;
    private MakeEditorDirtyListener commandStackListener;

    public ModulesFormEditor() {
        editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
    }

    @Override
    protected void addPages() {
        try {
            OverviewPage overviewPage = new OverviewPage(this, "de.wisag.automation.micas.module.ui.editor.overview",
                    "Übersicht");
            OverviewPageController opc = new OverviewPageController(overviewPage);
            opc.setModelProvider(this);
            overviewPage.setController(opc);
            addPage(overviewPage);

            dataBindingContext = new EMFDataBindingContext(DisplayRealm.getRealm(getSite().getShell().getDisplay()));

            SymbolsPage symbolesPage = new SymbolsPage(this, "de.wisag.automation.micas.module.ui.editor.symbols",
                    "Variablen/Konstanten/Referenzen");
            SymbolsPageController spc = new SymbolsPageController(symbolesPage);
            symbolesPage.setController(spc);
            spc.setModelProvider(this);
            addPage(symbolesPage);
        } catch (PartInitException e) {
            Policy.logError(e);
        }

    }

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (input instanceof IFileEditorInput) {
            IFileEditorInput fileEditorInput = (IFileEditorInput) input;
            FileEditorInputProxy editorInputProxy = new FileEditorInputProxy(fileEditorInput, editingDomain);
            Resource rootResource = editingDomain.loadResource(
                    URI.createPlatformResourceURI(fileEditorInput.getFile().getFullPath().toString(), true).toString());
            if (rootResource != null) {
                model = (Module) rootResource.getContents().get(0);
            }
            super.init(site, new DiagramEditorInputProxy(editorInputProxy, model));
            commandStackListener = new MakeEditorDirtyListener(this);
            editingDomain.getCommandStack().addCommandStackListener(commandStackListener);

            setPartName("MICAS Module editor " + fileEditorInput.getFile().getName());

        }
        // listen for project close events krm: 05/2014
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.PRE_CLOSE);
    }

    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        saveConnectedEditors(progressMonitor);
        saveDocument(progressMonitor);
    }

    @Override
    public void saveDocument(IProgressMonitor monitor) {
        final Map<Object, Object> saveOptions = new HashMap<>();
        saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

        // Do the work within an operation because this is a long running
        // activity that modifies the workbench.
        //
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
            // This is the method that gets invoked when the operation runs.
            //
            @Override
            public void execute(IProgressMonitor monitor) {

                // Save the resources to the file system.
                //

                for (Resource resource : editingDomain.getResourceSet().getResources()) {
                    if ((!resource.getContents().isEmpty() || isPersisted(resource))
                            && !editingDomain.isReadOnly(resource)) {
                        try {
                            repairConnections(monitor, resource);
                            resource.save(saveOptions);
                        } catch (IOException exception) {
                            handleError(exception);
                        }
                    }
                }
            }

            private void handleError(IOException e) {
                Policy.logError(e);
            }
        };

        try {
            // This runs the options, and shows progress.
            //
            new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

            // Refresh the necessary state.
            //
            ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
            this.dirty = false;
            firePropertyChange(IEditorPart.PROP_DIRTY);
        } catch (Exception e) {
            Policy.logError(e);
        }
    }

    protected void repairConnections(IProgressMonitor monitor, Resource resource) {

        EList<EObject> contents = resource.getContents();
        if (contents.isEmpty()) {
            return;
        }
        Module module = (Module) contents.get(0);
        for (Connection connection : ModuleUtil.getAllConnections(module)) {
            if (!BlockUtils.isInterBlockConnection(connection)) {
                // ignore incoming and outgoing connections
                continue;
            }
            AttributeSpecification attributeSpecification = ModuleUtil.getAttributeSpecification(connection);
            if (attributeSpecification == null) {
                continue;
            }
            Attribute attribute = attributeSpecification.getAttribute();
            if (attribute == null) {
                String name = BlockUtils.getAnonymousIdentifier(connection, ANONYMOUS_VAR_PREFIX);
                DataType sourceDataType = ModuleUtil.getDataType(connection);

                TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(connection);
                VariableAttribute newVariableAttribute = createVariableAttribute(name, sourceDataType);

                CompoundCommand compoundCommand = new CompoundCommand();
                Command set = SetCommand.create(domain, attributeSpecification, ATTRIBUTE_SPECIFICATION__ATTRIBUTE,
                        newVariableAttribute);
                compoundCommand.append(set);
                domain.getCommandStack().execute(set);
                Command addAttribute = AddCommand.create(editingDomain, module, MODULE__ATTRIBUTES,
                        newVariableAttribute);
                compoundCommand.append(addAttribute);

                editingDomain.getCommandStack().execute(compoundCommand);
            }
        }
    }

    private void saveConnectedEditors(IProgressMonitor progressMonitor) {
        IWorkbenchPage page = getEditorSite().getPage();
        IEditorReference[] editors = page.getEditorReferences();
        for (int i = 0; i < editors.length; i++) {
            IEditorReference editorReference = editors[i];
            try {
                IEditorInput editorInput = editorReference.getEditorInput();
                if (editorInput instanceof DiagramEditorInput) {
                    DiagramEditorInput input = (DiagramEditorInput) editorInput;
                    Diagram diagram = input.getDiagram();
                    // does this diagram editor holds one of out diagrams ?
                    boolean found = getModel().eResource().getContents().contains(diagram);
                    if (found) {
                        DiagramEditor editor = (DiagramEditor) editorReference.getEditor(true);
                        if (editor != null && editor.getAdapter(IDocumentSaveOperation.class) != null) {
                            IDocumentSaveOperation op = (IDocumentSaveOperation) editor
                                    .getAdapter(IDocumentSaveOperation.class);
                            op.saveDocument(progressMonitor);
                        }
                    }
                }
            } catch (PartInitException e1) {
                Policy.logError(e1);
            }
        }
    }

    protected boolean isPersisted(Resource resource) {
        boolean result = false;
        try {
            InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
            if (stream != null) {
                result = true;
                stream.close();
            }
        } catch (IOException e) {
            // Ignore
        }
        return result;
    }

    @Override
    public void doSaveAs() {
        // nothing for now
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public Module getModel() {
        return this.model;
    }

    @Override
    public EditingDomain getEditingDomain() {
        return this.editingDomain;
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }

    @Override
    public DataBindingContext getDataBindingContext() {
        return dataBindingContext;
    }

    public void setDataBindingContext(DataBindingContext dataBindingContext) {
        this.dataBindingContext = dataBindingContext;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if (IDocumentSaveOperation.class.equals(adapter)) {
            return this;
        }
        return super.getAdapter(adapter);
    }

    @Override
    public void dispose() {
        // cleanup out dirty listener
        getEditingDomain().getCommandStack().removeCommandStackListener(commandStackListener);
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);

        // super.dispose();
    }

    @Override
    public void resourceChanged(final IResourceChangeEvent event) {
        final IEditorInput input = getEditorInput();
        if (!(input instanceof IFileEditorInput)) {
            return;
        }
        final IFile moduleFile = ((IFileEditorInput) input).getFile();
        /*
         * Closes all editors with this editor input on project close.
         */
        if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    if (getSite() == null) {
                        return;
                    }
                    if (getSite().getWorkbenchWindow() == null) {
                        return;
                    }

                    IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
                    for (int i = 0; i < pages.length; i++) {
                        if (moduleFile.getProject().equals(event.getResource())) {
                            IEditorPart editorPart = pages[i].findEditor(input);
                            pages[i].closeEditor(editorPart, true);
                        }
                    }
                }
            });
        }

    }
}
