package de.wisag.automation.micas.importer.mic.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInoutput;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Port;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.util.BlockUtils;
import de.wisag.automation.micas.module.util.PageUtils;
import de.wisag.automation.micas.module.util.PortDescriptor;
import de.wisag.automation.micas.rt.RtCommentModuleInvocation;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class RtModuleToDiagramModuleTransformer {

    private Map<String, Attribute> attributesByName;
    private static final String FKG_SERIES_EXPRESSION_PARAMETER_URI = "http://www.wisag.de/automation/micas/library/1.0.0/binaryanalog/FKG.blocktype.dml#_R_feYMx5Ed-YOdIee15nVA";
    private static final String UREG_NUMBER_EXPRESSION_PARAMETER_URI = "http://www.wisag.de/automation/micas/library/1.0.0/controller/UREG.blocktype.dml#_OmHaUDxwEeCPNba6MpBfNw";
    private static final String REGLER_NUMBER_EXPRESSION_PARAMETER_URI = "http://www.wisag.de/automation/micas/library/1.0.0/controller/REGLER.blocktype.dml#_we45scxxEd-FQYFS-dSuLA";
    private static final String SOLKEN_NUMBER_EXPRESSION_URI = "http://www.wisag.de/automation/micas/library/1.0.0/controller/SOLKEN.blocktype.dml#_Ivv1gMxyEd-FQYFS-dSuLA";

    private Map<String, Integer> blockCounter = new HashMap<>();
    private URI uri;

    public RtModuleToDiagramModuleTransformer(URI uri) {
        this.uri = uri;
    }

    public Module transform(RtModule rtModule) {
        Module module = ModuleFactory.eINSTANCE.createModule();
        module.setName(rtModule.getSourceName());
        module.setFieldBusNumber(rtModule.getFieldBus());
        module.setKind(TransformUtils.transform(rtModule.getHwType()));
        ResourceConfigurator.configureResource(module, uri);
        module.setExaminer(System.getProperty("user.name"));

        EList<RtSymbol> symbols = rtModule.getSymbols();

        attributesByName = new HashMap<>();
        for (RtSymbol symbol : symbols) {
            registerSymbol(module, symbol);
        }

        EList<RtTask> tasks = rtModule.getTasks();
        for (RtTask rtTask : tasks) {
            EList<RtModuleInvocation> invocations = rtTask.getModuleInvocations();
            if (invocations != null && invocations.size() == 1
                    && invocations.get(0).getName() == WellknownSpecialBlocks.ENDE) {
                // ignore 'empty tasks
                continue;
            } else if (invocations != null && invocations.isEmpty()) {
                continue;
            }
            Task task = TransformUtils.transform(rtTask);
            System.out.println("[IMPORTER] : addTask");
            module.getTasks().add(task);
            System.out.println("[IMPORTER] : processModuleInvocations");
            processModuleInvocations(attributesByName, invocations, task);

        }
        // having a big micfile, xour system will explode!
        // System.out.println(ModelInspection.modelToString(module));
        return module;
    }

    private void registerSymbol(Module module, RtSymbol symbol) {
        Assert.isNotNull(symbol, "symbol");
        Assert.isNotNull(symbol.getName(), "symbol.name");
        Attribute attribute = TransformUtils.transform(symbol);
        if (attribute != null) {
            attributesByName.put(attribute.getName(), attribute);
            module.getAttributes().add(attribute);
        } else {
            // ignore only direct values
            Assert.isLegal(symbol instanceof RtDirectValue);
        }
    }

    private void processModuleInvocations(Map<String, Attribute> attributesByName,
            EList<RtModuleInvocation> invocations, Task task) {
        Page page = PageUtils.createPage(String.format("Diagram%d", task.getPages().size()), task);
        int blockOnPageIndex = 1;
        Assert.isNotNull(page.getTask());
        Assert.isNotNull(task.getModule());
        List<PortDescriptor> portDescriptors = new ArrayList<>();
        for (RtModuleInvocation rti : invocations) {
            if (rti instanceof RtCommentModuleInvocation) {
                System.out.println(String.format("[IMPORTER] : wire connections"));
                createConnections(page, portDescriptors); // create the
                                                          // connections of the
                                                          // previous page
                // port descriptors have page scope
                portDescriptors.clear();
                System.out.println(String.format("[IMPORTER] : new page"));
                page = PageUtils.createPage(((RtCommentModuleInvocation) rti).getText(), task);
                // reset priorities
                blockOnPageIndex = 1;
                continue;
            } else if (WellknownSpecialBlocks.ENDE.equals(rti.getName())) {
                // ignore 'ENDE' Blocks
                continue;
            }
            System.out.println(String.format("[IMPORTER] : transform block %s", rti.getName()));
            final Block block = transform(page, rti, blockOnPageIndex++);
            preprocessSpecialBlocks(task, rti, block);
            final Iterator<RtSymbolAccess> arguments = rti.getArguments().iterator();
            final ArrayList<InoutputDefinition> inoutputDefs = new ArrayList<>();
            inoutputDefs.addAll(block.getType().getInputDefinitions());
            inoutputDefs.addAll(block.getType().getOutputDefinitions());
            // handle blockInputs
            // System.out.println("create input ports for " + block.getName());
            System.out.println(String.format("[IMPORTER] : transform connectors"));
            for (Iterator<?> it = inoutputDefs.iterator(); it.hasNext();) {
                InoutputDefinition inoutputDefinition = (InoutputDefinition) it.next();
                boolean groupPort = inoutputDefinition.getMaximumPortCount() == -1;
                if (groupPort) {
                    // next
                    RtSymbol sym = arguments.next().getSymbol();
                    processPortGroup(attributesByName, page, block, arguments, inoutputDefinition,
                            ((RtDirectValue) sym).getValue(), portDescriptors);
                } else {
                    RtSymbol symbol = arguments.next().getSymbol();
                    Attribute attribute = attributesByName.get(symbol.getName());
                    processPort(attribute, block, null, inoutputDefinition, symbol, portDescriptors);
                }

            }
            Assert.isNotNull(block.getType());
        }
        createConnections(page, portDescriptors);
    }

    private void preprocessSpecialBlocks(Task task, RtModuleInvocation rti, Block block) {
        if (WellknownSpecialBlocks.BEFAUS.equals(rti.getName())) {
            // in case of BEFAUS, direct value has thrown away
            rti.getArguments().remove(0);
        } else if (WellknownSpecialBlocks.REGLER.equals(rti.getName())) {
            // in case of REGLER, the number is stored in an expression
            RtDirectValue dv = removeArgumentAndInterpretAsDirectValue(rti, 0);
            BlockUtils.addBlockArgumentValue(null, block, REGLER_NUMBER_EXPRESSION_PARAMETER_URI,
                    Integer.toString(dv.getValue()));

        } else if (WellknownSpecialBlocks.UREG.equals(rti.getName())) {
            RtDirectValue dv = removeArgumentAndInterpretAsDirectValue(rti, 0);
            BlockUtils.addBlockArgumentValue(null, block, UREG_NUMBER_EXPRESSION_PARAMETER_URI,
                    Integer.toString(dv.getValue()));
        } else if (WellknownSpecialBlocks.SOLKEN.equals(rti.getName())) {
            RtDirectValue dv = removeArgumentAndInterpretAsDirectValue(rti, 0);
            BlockUtils.addBlockArgumentValue(null, block, SOLKEN_NUMBER_EXPRESSION_URI,
                    Integer.toString(dv.getValue()));
        } else if (WellknownSpecialBlocks.FKG.equals(rti.getName())) {
            RtDirectValue dv = removeArgumentAndInterpretAsDirectValue(rti, 1);
            int seriesSize = dv.getValue();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < seriesSize / 2; i++) {
                if (i > 0) {
                    sb.append(';');
                }
                // x-value
                RtSymbolAccess rtSymbolAccess = rti.getArguments().remove(1);
                sb.append(Double.toString(toDouble(rtSymbolAccess.getSymbol())));
                sb.append('#');
                // y-value
                rtSymbolAccess = rti.getArguments().remove(1);
                sb.append(Double.toString(toDouble(rtSymbolAccess.getSymbol())));
            }
            BlockUtils.addBlockArgumentValue(null, block, FKG_SERIES_EXPRESSION_PARAMETER_URI, sb.toString());
        }
    }

    private RtDirectValue removeArgumentAndInterpretAsDirectValue(RtModuleInvocation rti, int argumentIndex) {
        RtSymbolAccess rtSymbolAccess = rti.getArguments().remove(argumentIndex);
        RtSymbol symbol = rtSymbolAccess.getSymbol();
        Assert.isLegal(symbol instanceof RtDirectValue,
                String.format("expected RtDirect value as Type of invocation at index %d for invocation %s",
                        argumentIndex, rti.getName()));
        RtDirectValue dv = (RtDirectValue) symbol;
        return dv;
    }

    private double toDouble(RtSymbol symbol) {
        double xValue = -1;
        if (symbol instanceof RtFloatVariable) {
            RtFloatVariable new_name = (RtFloatVariable) symbol;
            xValue = new_name.getValue();
        } else if (symbol instanceof RtFloatConstant) {
            RtFloatConstant new_name = (RtFloatConstant) symbol;
            xValue = new_name.getValue();
        } else if (symbol instanceof RtWordConstant) {
            RtWordConstant new_name = (RtWordConstant) symbol;
            xValue = new_name.getValue();
        } else if (symbol instanceof RtWordVariable) {
            RtWordVariable new_name = (RtWordVariable) symbol;
            xValue = new_name.getValue();
        }
        return xValue;
    }

    private void processPortGroup(Map<String, Attribute> attributesByName, Page page, Block block,
            Iterator<RtSymbolAccess> arguments, InoutputDefinition inoutDefinition, int groupsize,
            List<PortDescriptor> portDescriptors) {
        BlockInoutput blockInoutput = null;
        if (inoutDefinition instanceof InputDefinition) {
            blockInoutput = BlockUtils.createEmptyBlockInput(block, (InputDefinition) inoutDefinition);
        } else if (inoutDefinition instanceof OutputDefinition) {
            blockInoutput = BlockUtils.createEmptyBlockOutput(block, (OutputDefinition) inoutDefinition);
        }
        for (int i = 0; i < groupsize; i++) {
            RtSymbol symbol = arguments.next().getSymbol();
            Attribute attribute = attributesByName.get(symbol.getName());
            processPort(attribute, block, blockInoutput, inoutDefinition, symbol, portDescriptors);
            Assert.isNotNull(attribute);
        }
    }

    private void processPort(Attribute attribute, Block block, BlockInoutput blockInoutput,
            InoutputDefinition inoutDefinition, RtSymbol symbol, List<PortDescriptor> portDescriptors) {
        if (symbol.getName() != null) {
            if (inoutDefinition instanceof InputDefinition) {
                Port port = BlockUtils.createBlockInputPort(block, (BlockInput) blockInoutput,
                        (InputDefinition) inoutDefinition);
                portDescriptors.add(new PortDescriptor(port, symbol.getName()));
            } else if (inoutDefinition instanceof OutputDefinition) {
                BlockOutput blockOutput = (BlockOutput) blockInoutput;
                OutputDefinition definition = (OutputDefinition) inoutDefinition;
                BlockOutputPort port = BlockUtils.addBlockOutputPort(attribute, block, blockOutput, definition);
                if (StringUtils.equalsIgnoreCase(definition.getName(), "error")) {
                    boolean haveErrorReaders = false;
                    EList<RtSymbolAccess> accessors = symbol.getAccessors();
                    for (RtSymbolAccess rtSymbolAccess : accessors) {
                        if (rtSymbolAccess.getType() == RtSymbolAccessType.READ) {
                            haveErrorReaders = true;
                            break;
                        }
                    }
                    // if we have no error readers, dont connect it
                    if (!haveErrorReaders) {
                        // reset the signal
                        AttributeSpecification attributeSignal = (AttributeSpecification) port.getSignal();
                        attributeSignal.setAttribute(null);
                        port.setSignal(null);
                        return;
                    }
                    // do not cache
                }
                portDescriptors.add(new PortDescriptor(port, symbol.getName()));
            }
            Assert.isNotNull(attribute);
        } else {
            System.out.println("attribute name is null for symbol: " + symbol);
        }

    }

    // TODO rytina: use diagram instead of page
    private void createConnections(Page page, List<PortDescriptor> portDescriptors) {
        for (Map.Entry<String, Attribute> entry : attributesByName.entrySet()) {
            String attributeName = entry.getKey();
            Attribute attribute = entry.getValue();
            HashMap<String, Reference> references = new HashMap<>();
            HashMap<String, Constant> constants = new HashMap<>();
            List<BlockOutputPort> oPorts = BlockUtils.filterOutputPortsBy(portDescriptors, attributeName);
            List<BlockInputPort> iPorts = BlockUtils.filterInputPortsBy(portDescriptors, attributeName);
            if (oPorts.size() == 0 && iPorts.size() > 0) { // the input ports
                                                           // are connected with
                                                           // an page input
                for (BlockInputPort blockInputPort : iPorts) {
                    if (attribute instanceof ConstantAttribute) {
                        Constant constant = null;
                        if (constants.get(attributeName) != null) {
                            constant = constants.get(attributeName);
                        } else {
                            constant = PageUtils.createConstant(page, (ConstantAttribute) attribute);
                            constants.put(attributeName, constant);
                        }
                        PageUtils.createConnection(page, constant.getFirstOutputPort(), blockInputPort);

                    } else if (attribute instanceof ReferenceAttribute) {
                        Reference reference;
                        if (references.get(attributeName) != null) {
                            reference = references.get(attributeName);
                        } else {
                            reference = PageUtils.createReference(page, (ReferenceAttribute) attribute);
                            references.put(attributeName, reference);
                        }
                        PageUtils.createConnection(page, reference.getFirstOutputPort(), blockInputPort);
                    } else if (attribute instanceof VariableAttribute) {
                        VariableAttribute var = (VariableAttribute) attribute;
                        PageUtils.createConnection(page, PageUtils.createPageInput(page, var).getFirstOutputPort(),
                                blockInputPort);
                    }
                }
            } else if (oPorts.size() > 0 && iPorts.size() == 0) { // the output
                                                                  // ports are
                                                                  // connected
                                                                  // with an
                                                                  // page output
                for (BlockOutputPort o : oPorts) {
                    if (attribute instanceof ConstantAttribute) {
                        // written constants, evil thing!
                        Constant constant = null;
                        if (constants.get(attributeName) != null) {
                            constant = constants.get(attributeName);
                        } else {
                            constant = PageUtils.createConstant(page, (ConstantAttribute) attribute);
                            constants.put(attributeName, constant);
                        }

                        if (constant.getFirstInputPort() == null) {
                            BlockUtils.addInputPort(constant);
                        }
                        PageUtils.createConnection(page, o, constant.getFirstInputPort());
                    } else if (attribute instanceof ReferenceAttribute) {
                        ReferenceAttribute ref = (ReferenceAttribute) attribute;
                        if (references.get(attributeName) != null) {
                            // reference = references.get(attribute);
                        } else {
                            ;
                            // reference = BlockUtils.createPageOutput(page,
                            // (ReferenceAttribute)
                            // attributesByName.get(attribute));
                            // references.put(attribute, reference);
                        }
                        if (!(ref.getName() != null && ref.getName().startsWith("$out-")
                                && ref.getName().endsWith("-error"))) {
                            PageUtils.createConnection(page, o, PageUtils.createPageOutput(page).getFirstInputPort());
                        }
                    } else if (attribute instanceof VariableAttribute) {

                        PageUtils.createConnection(page, o, PageUtils.createPageOutput(page).getFirstInputPort());
                    }
                }
            } else if (oPorts.size() > 0 && iPorts.size() > 0) { // the the
                                                                 // output ports
                                                                 // are
                                                                 // connected
                                                                 // with the
                                                                 // other block
                                                                 // inputs
                for (BlockOutputPort o : oPorts) {
                    for (BlockInputPort i : iPorts) {
                        PageUtils.createConnection(page, o, i);
                    }
                }
            }
        }
    }

    private Block transform(Page parentPage, RtModuleInvocation rmi, int blockOnPageIndex) {
        String name = rmi.getName();
        Integer index = Integer.valueOf(1);
        if ((!WellknownSpecialBlocks.ENDE.equals(name)) && blockCounter.containsKey(name)) {
            index = blockCounter.get(name) + 1;

        }
        blockCounter.put(name, Integer.valueOf(index));
        Resource resource = parentPage.eResource();

        Block block = BlockUtils.createBlock(resource, name, index, blockOnPageIndex);
        block.setOwningFragment(parentPage);
        return block;
    }
}
