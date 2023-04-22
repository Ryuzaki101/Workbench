package de.wisag.automation.micas.export.mic.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.SignalSpecification;

import com.google.common.base.Optional;

import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.export.mic.IRtSymbolTranslator;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.util.ModuleUtil;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtSymbol;

/**
 * The purpos of this class is to provide a possibility to translate Symbols of
 * a diagram to a RtSymbol. This is done on the fly
 *
 * @author mkr
 */
public class RtSymbolTranslatorImpl implements IRtSymbolTranslator {

    private static Optional<RtSymbol> findSymbolByName(RtModule rtModule, String name) {
        Assert.isNotNull(name, "'name' must not be null");
        Assert.isNotNull(rtModule, "'module' must not be null");
        RtSymbol frtSymbol = null;
        EList<RtSymbol> symbols = rtModule.getSymbols();
        for (RtSymbol rtSymbol : symbols) {
            if (name.equals(rtSymbol.getName())) {
                frtSymbol = rtSymbol;
                break;
            }
        }
        return Optional.fromNullable(frtSymbol);
    }

    @Override
    public RtSymbol translate(IProgressMonitor monitor, EObject semanticObject) {
        String name = getSymbolName(semanticObject);
        IFile diagramFile = ResourceUtils.toIFile(semanticObject.eResource());
        // try to get the current RtModule from
        RtModule rtModule = ResourceUtils.getSessionObject(ResourceUtils.CURRENT_RT_MODEL, diagramFile, RtModule.class);
        // check if the rtModule is available and in sync
        if (rtModule == null || diagramFile.getModificationStamp() != rtModule.getSourceModificationStamp()) {
            DiagramModuleCompiler compiler = new DiagramModuleCompiler(diagramFile);
            IStatus compileStatus = compiler.compileAndWait(monitor);
            if (compileStatus.isOK()) {
                rtModule = ResourceUtils.getSessionObject(ResourceUtils.CURRENT_RT_MODEL, diagramFile, RtModule.class);
            } else {
                Policy.log(compileStatus);
            }
        }
        return rtModule != null && name != null ? findSymbolByName(rtModule, name).orNull() : null;
    }

    @Override
    public boolean supportsTranslationFor(EObject eobject) {
        if (eobject == null) {
            return false;
        }
        int cls = eobject.eClass().getClassifierID();

        boolean supports = false;
        switch (cls) {
        case ModulePackage.CONSTANT:
        case ModulePackage.REFERENCE:
        case ModulePackage.INCOMING_OFFPAGE_CONNECTOR:
        case ModulePackage.ATTRIBUTE_SPECIFICATION:
        case ModulePackage.OUTGOING_OFFPAGE_CONNECTOR:
            return ModulePackage.eINSTANCE == eobject.eClass().getEPackage();
        case DMLPackage.CONNECTION:
            return DMLPackage.eINSTANCE == eobject.eClass().getEPackage();
        default:
            supports = false;
            break;
        }
        return supports;
    }

    private static String getSymbolName(EObject semanticObject) {
        String name = null;
        if (semanticObject instanceof Reference) {
            Component component = (Component) semanticObject;
            SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                Attribute attribute2 = ((AttributeSpecification) signalSpecification).getAttribute();
                if (attribute2 instanceof ReferenceAttribute) {
                    ReferenceAttribute constantAttribute = (ReferenceAttribute) attribute2;
                    name = constantAttribute.getName();
                } else {
                    throw new IllegalArgumentException("Unhandled Semantic Object " + semanticObject);
                }
            }
        } else if (semanticObject instanceof Constant) {
            Constant component = (Constant) semanticObject;
            if (component != null) {
                SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
                if (signalSpecification instanceof AttributeSpecification) {
                    Attribute attribute = ((AttributeSpecification) signalSpecification).getAttribute();
                    if (attribute instanceof ConstantAttribute) {
                        ConstantAttribute constantAttribute = (ConstantAttribute) attribute;
                        name = constantAttribute.getName();
                    }
                }
            }
        } else if (semanticObject instanceof Connection) {
            Connection connection = (Connection) semanticObject;
            OutputPort outputPort = (OutputPort) connection.getSource();
            if (outputPort != null) {
                Component component = outputPort.getComponent();
                SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
                if (signalSpecification instanceof AttributeSpecification) {
                    Attribute attribute = ((AttributeSpecification) signalSpecification).getAttribute();
                    if (attribute instanceof VariableAttribute) {
                        VariableAttribute variableAttribute = (VariableAttribute) attribute;
                        name = variableAttribute.getName();
                    } else if (attribute instanceof ConstantAttribute) {
                        ConstantAttribute constantAttribute = (ConstantAttribute) attribute;
                        name = constantAttribute.getName();
                    } else if (attribute instanceof ReferenceAttribute) {
                        ReferenceAttribute referenceAttribute = (ReferenceAttribute) attribute;
                        name = referenceAttribute.getName();
                    }
                }
            }

        } else if (semanticObject instanceof IncomingOffpageConnector) {
            Component component = (Component) semanticObject;
            if (component != null) {
                SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
                if (signalSpecification instanceof AttributeSpecification) {
                    AttributeSpecification attributeSpecification = (AttributeSpecification) signalSpecification;
                    if (attributeSpecification.getAttribute() != null
                            && attributeSpecification.getAttribute().getName() != null) {
                        name = attributeSpecification.getAttribute().getName();
                    }
                }
            }
        } else if (semanticObject instanceof OutgoingOffpageConnector) {
            Component component = (Component) semanticObject;
            if (component != null) {
                Optional<Connection> connection = ModuleUtil.getFirstIncommingConnection(component);
                Optional<AttributeSpecification> attributeSpecification = ModuleUtil.getSourceSignal(connection);
                Optional<Attribute> attribute = ModuleUtil.getAttribute(attributeSpecification);
                if (attribute.isPresent()) {
                    name = attribute.get().getName();
                }
            }
        } else if (semanticObject instanceof AttributeSpecification) {
            AttributeSpecification attributeSpecification = (AttributeSpecification) semanticObject;
            if (attributeSpecification != null && attributeSpecification.getAttribute() != null) {
                name = attributeSpecification.getAttribute().getName();
            }
        } else {

            throw new IllegalArgumentException("Unhandled Semantic Object " + semanticObject);
        }
        return name;
    }

}
