package de.wisag.automation.micas.diagram.ui.part;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipselabs.damos.diagram.ui.part.BlockDiagramEditor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.common.ui.IDocumentSaveOperation;
import de.wisag.automation.micas.diagram.ui.Activator;
import de.wisag.automation.micas.diagram.ui.editparts.CustomBlockDiagramEditPart;
import de.wisag.automation.micas.diagram.ui.internal.Policy;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.olt.ISymbolMonitorMessages;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;

public class DiagramEditor extends BlockDiagramEditor
        implements EventHandler, IDocumentSaveOperation, IResourceChangeListener {
    public static final String EDITOR_ID = "de.wisag.automation.micas.diagram.ui.blockDiagramEditor";
    private ServiceRegistration<EventHandler> sreg;
    private String extraTooltip;

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);

        BundleContext bc = Activator.getDefault().getBundle().getBundleContext();
        // register for osgi events for onlinemonitor
        final Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(EventConstants.EVENT_TOPIC, ISymbolMonitorMessages.SYM_MONITOR_ALL_TOPICS);
        // this.sreg = bc.registerService(EventHandler.class.getName(), this,
        // properties);
        this.sreg = bc.registerService(EventHandler.class, this, properties);
        Page page = getDiagramPage();
        IFile ifile = page != null && page.eResource() != null ? ResourceUtils.toIFile(page.eResource()) : null;

        if (ifile != null && page != null && page.getTask() != null && page.getTask().getModule() != null) {
            extraTooltip = String.format("%s : %s : %s : %s : %s ", ifile.getProject().getName(),
                    ifile.getProjectRelativePath().toPortableString(), page.getTask().getModule().getName(),
                    page.getTask().getName(), page.getName());
        }
        // listen for project close events krm: 05/2014
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.PRE_CLOSE);
    }

    private Page getDiagramPage() {
        DiagramEditorInput diagramEditorInput = (DiagramEditorInput) getEditorInput();
        Diagram diagram = diagramEditorInput.getDiagram();
        Page page = (Page) diagram.getElement();
        return page;
    }

    @Override
    public String getTitleToolTip() {
        return extraTooltip != null ? extraTooltip : super.getTitleToolTip();
    }

    @Override
    public void dispose() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
        if (this.sreg != null) {
            this.sreg.unregister();
        }
        super.dispose();
    }

    @Override
    public void handleEvent(Event event) {
        String topic = event.getTopic();
        CustomBlockDiagramEditPart diagEditPart = (CustomBlockDiagramEditPart) getDiagramEditPart();
        if (ISymbolMonitorMessages.SYM_MONITOR_BEGIN_TOPIC.equals(topic)) {
            MonitorModel monitorModel = (MonitorModel) event.getProperty(ISymbolMonitorMessages.PROP_MONITOR_MODEL);
            diagEditPart.beginDebugSession(monitorModel);
        } else if (ISymbolMonitorMessages.SYM_MONITOR_END_TOPIC.equals(topic)) {
            MonitorModel monitorModel = (MonitorModel) event.getProperty(ISymbolMonitorMessages.PROP_MONITOR_MODEL);
            diagEditPart.endDebugSession(monitorModel);
        } else if (ISymbolMonitorMessages.SYM_MONITOR_UPDATE_TOPIC.equals(topic)) {
            MonitoredValueSet valueSet = (MonitoredValueSet) event
                    .getProperty(ISymbolMonitorMessages.PROP_MONITORED_VALUE_SET);
            diagEditPart.updateDebugSession(valueSet);
        }
    }

    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        saveDocument(progressMonitor);
        // if an modeleditor is also open, it must be saved too
        saveConnected(progressMonitor);

    }

    @Override
    public void saveDocument(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
    }

    private void saveConnected(IProgressMonitor progressMonitor) {
        IWorkbenchPage page = getEditorSite().getPage();
        IEditorReference[] editors = page.getEditorReferences();
        DiagramEditorInput input = (DiagramEditorInput) getEditorInput();
        EList<EObject> eResourceContents = input.getDiagram().eResource().getContents();
        for (int i = 0; i < editors.length; i++) {
            IEditorReference editorReference = editors[i];
            try {
                boolean shouldSave = false;
                IEditorInput editorInput = editorReference.getEditorInput();
                if (isModuleEditorWithSameModule(eResourceContents, editorReference)) {
                    shouldSave = true;
                } else if (editorInput instanceof DiagramEditorInput
                        && !(ObjectUtils.equals(getEditorInput(), editorInput))) {

                    DiagramEditorInput otherDiagInput = (DiagramEditorInput) editorInput;
                    Diagram diagram = otherDiagInput.getDiagram();
                    if (eResourceContents.contains(diagram)) {
                        shouldSave = true;
                    }
                }
                if (shouldSave) {
                    IEditorPart editor = editorReference.getEditor(true);
                    if (editor != null && !editor.equals(this)
                            && editor.getAdapter(IDocumentSaveOperation.class) != null) {
                        IDocumentSaveOperation op = editor.getAdapter(IDocumentSaveOperation.class);
                        op.saveDocument(progressMonitor);
                    }
                }

            } catch (PartInitException e) {
                Policy.logError(e);
            }
        }
    }

    private boolean isModuleEditorWithSameModule(EList<EObject> eResourceContents, IEditorReference editorReference)
            throws PartInitException {
        boolean shouldSave = false;
        if ("de.wisag.automation.micas.module.ui.ModuleEditor".equals(editorReference.getId())) {
            IEditorInput otherInput = editorReference.getEditorInput();
            if (otherInput != null && otherInput.getAdapter(Module.class) != null) {
                if (eResourceContents.contains(otherInput.getAdapter(Module.class))) {
                    shouldSave = true;
                }
            }
        }
        return shouldSave;
    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if (IDocumentSaveOperation.class.equals(adapter)) {
            return this;
        }
        return super.getAdapter(adapter);
    }

    @Override
    public void resourceChanged(final IResourceChangeEvent event) {
        final IEditorInput input = getEditorInput();

        Page page = getDiagramPage();
        final IFile moduleFile = ResourceUtils.toIFile(page.eResource());
        /*
         * Closes all editors with this editor input on project close.
         */
        if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
            // TODO: Problem wenn save was canceled !!! Evtl. auf POST_Save
            // umstellen ?
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
