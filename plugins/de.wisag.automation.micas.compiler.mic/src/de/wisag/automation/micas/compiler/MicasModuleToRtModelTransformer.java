package de.wisag.automation.micas.compiler;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.compiler.mic.internal.modern.MicasCompiler;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;
import de.wisag.automation.micas.mIC.DirectValue;
import de.wisag.automation.micas.mIC.FGAAnalogValueReference;
import de.wisag.automation.micas.mIC.FGAMeasuredValueReference;
import de.wisag.automation.micas.mIC.FGAMessageConstantReference;
import de.wisag.automation.micas.mIC.FGAValueReference;
import de.wisag.automation.micas.mIC.FloatConst;
import de.wisag.automation.micas.mIC.FloatVar;
import de.wisag.automation.micas.mIC.Instruction;
import de.wisag.automation.micas.mIC.MetaData;
import de.wisag.automation.micas.mIC.Module;
import de.wisag.automation.micas.mIC.ModuleInvokation;
import de.wisag.automation.micas.mIC.Symbol;
import de.wisag.automation.micas.mIC.SymbolAccessor;
import de.wisag.automation.micas.mIC.Task;
import de.wisag.automation.micas.mIC.WordConst;
import de.wisag.automation.micas.mIC.WordVar;
import de.wisag.automation.micas.mIC.util.MICSwitch;
import de.wisag.automation.micas.rt.RtCommentModuleInvocation;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtHwType;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskStrategy;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;
import de.wisag.automation.micas.utils.ParseUtils;

/**
 * Transforms a model, created by Xetxt parser to {@link RtModule}
 */
public class MicasModuleToRtModelTransformer extends MICSwitch<MicasCompiler> {
    private int i = -1000;
    private RtModule rtModule;
    private RtTask rtTask;
    private int symbolIndex = 0;

    @Override
    public MicasCompiler caseModule(Module module) {
        this.rtModule = RtFactory.eINSTANCE.createRtModule();
        this.rtModule.setFieldBus(module.getValue());
        this.rtModule.setHwType(transform(module.getType()));
        return null;
    }

    private RtHwType transform(String type) {
        RtHwType hwType = RtHwType.getByName(type);
        if (hwType == null) {
            throw new RuntimeException("Runtime Model does not support HWModule named : '" + type + "'");
        }
        return hwType;
    }

    @Override
    public MicasCompiler caseFGAAnalogValueReference(FGAAnalogValueReference ref) {
        RtReferenceConstant reference = RtFactory.eINSTANCE.createRtReferenceConstant();
        reference.setType(PortDataType.FGA_ANALOG_VALUE);
        reference.setName(ref.getName());
        reference.setCol(0);
        reference.setRow(ref.getRow());
        reference.setIndex(this.symbolIndex++);
        reference.setAddress(this.i--);
        this.rtModule.addSymbol(reference);
        return null;
    }

    @Override
    public MicasCompiler caseFGAMessageConstantReference(FGAMessageConstantReference ref) {
        RtReferenceConstant reference = RtFactory.eINSTANCE.createRtReferenceConstant();
        reference.setType(PortDataType.FGA_MESSAGE_CONST);
        reference.setName(ref.getName());
        reference.setCol(ref.getColumn());
        reference.setRow(ref.getRow());
        reference.setIndex(this.symbolIndex++);
        reference.setAddress(this.i--);
        this.rtModule.addSymbol(reference);
        return null;
    }

    @Override
    public MicasCompiler caseFGAMeasuredValueReference(FGAMeasuredValueReference ref) {
        RtReferenceConstant reference = RtFactory.eINSTANCE.createRtReferenceConstant();
        reference.setType(PortDataType.FGA_MEASURED_VALUE);
        reference.setName(ref.getName());
        reference.setCol(0);
        reference.setRow(ref.getRow());
        reference.setIndex(this.symbolIndex++);
        reference.setAddress(this.i--);
        this.rtModule.addSymbol(reference);
        return null;
    }

    @Override
    public MicasCompiler caseFGAValueReference(FGAValueReference ref) {
        RtReferenceConstant reference = RtFactory.eINSTANCE.createRtReferenceConstant();
        reference.setType(PortDataType.FGA_VALUE);
        reference.setName(ref.getName());
        reference.setCol(0);
        reference.setRow(ref.getRow());
        reference.setIndex(this.symbolIndex++);
        reference.setAddress(this.i--);
        this.rtModule.addSymbol(reference);
        return null;
    }

    @Override
    public MicasCompiler caseWordConst(WordConst wordConst) {
        RtWordConstant constant = RtFactory.eINSTANCE.createRtWordConstant();
        constant.setName(wordConst.getName());
        constant.setValue(wordConst.getValue());
        constant.setAddress(this.i--);
        constant.setIndex(this.symbolIndex++);
        this.rtModule.addSymbol(constant);
        return null;
    }

    @Override
    public MicasCompiler caseWordVar(WordVar wordVar) {
        RtWordVariable constant = RtFactory.eINSTANCE.createRtWordVariable();
        constant.setName(wordVar.getName());
        constant.setAddress(this.i--);
        constant.setIndex(this.symbolIndex++);
        this.rtModule.addSymbol(constant);
        return null;
    }

    @Override
    public MicasCompiler caseFloatVar(FloatVar floatVar) {
        RtFloatVariable constant = RtFactory.eINSTANCE.createRtFloatVariable();
        constant.setName(floatVar.getName());
        constant.setAddress(this.i--);
        constant.setIndex(this.symbolIndex++);
        this.rtModule.addSymbol(constant);
        return null;
    }

    @Override
    public MicasCompiler caseFloatConst(FloatConst floatConst) {
        RtFloatConstant constant = RtFactory.eINSTANCE.createRtFloatConstant();
        constant.setName(floatConst.getName());
        constant.setValue(floatConst.getValue());
        constant.setIndex(this.symbolIndex++);
        constant.setAddress(this.i--);
        this.rtModule.addSymbol(constant);
        return null;
    }

    @Override
    public MicasCompiler caseTask(Task task) {
        this.rtTask = RtFactory.eINSTANCE.createRtTask();
        this.rtTask.setId(task.getIndex());
        this.rtTask.setData(new byte[16]);
        this.rtTask.setSegment(-1);
        this.rtTask.setCyclTime(task.getCycleTime());
        String type = task.getType();
        Assert.isNotNull(type, "Task type must not be null");
        RtTaskStrategy strategy = RtTaskStrategy.get(type.toUpperCase());
        Assert.isNotNull(strategy, "Task strategy " + type + " not found");
        this.rtTask.setStrategy(strategy);
        int instructionIndex = 0;
        for (Instruction instruction : task.getInstructions()) {
            if (instruction instanceof ModuleInvokation) {
                ModuleInvokation moduleInvokation = (ModuleInvokation) instruction;
                String name = moduleInvokation.getModuleName();
                RtModuleInvocation rtModuleInvocation = createRtModuleInvocation(name);
                rtModuleInvocation.setIndex(instructionIndex++);
                EList<SymbolAccessor> arguments = moduleInvokation.getArguments();

                int argIndex = 0;
                for (SymbolAccessor symbolAccessor : arguments) {
                    RtSymbolAccess symbolAccess = createSymbolAccess(this.rtModule, symbolAccessor, argIndex++);
                    if (symbolAccessor.isWriting()) {
                        symbolAccess.setType(RtSymbolAccessType.WRITE);
                    } else {
                        symbolAccess.setType(RtSymbolAccessType.READ);
                    }
                    symbolAccess.setModuleInvocation(rtModuleInvocation);
                    rtModuleInvocation.getArguments().add(symbolAccess);
                }
                this.rtTask.getModuleInvocations().add(rtModuleInvocation);
            } else if (instruction instanceof MetaData) {
                MetaData metaData = (MetaData) instruction;
                if (metaData.getName() == null) {
                    ParseUtils.prepareMetadata(metaData);
                }
                // in case of
                if (HardcodedValues.PAGE.equals(metaData.getName())) {
                    RtCommentModuleInvocation cmi = RtFactory.eINSTANCE.createRtCommentModuleInvocation();
                    cmi.setText(String.format("%s#%d", HardcodedValues.PAGE, Integer.valueOf(metaData.getValue())));
                    this.rtTask.getModuleInvocations().add(cmi);
                }
            }
        }
        // ENDE is an syntactic element, therefore we have to add a synthetic
        // end module
        RtModuleInvocation rtModuleInvocation = createRtModuleInvocation(WellknownSpecialBlocks.ENDE);
        // seems that the mic.c contains runtime, but the generated code has no
        // such
        rtModuleInvocation.setRuntime(0);
        this.rtTask.getModuleInvocations().add(rtModuleInvocation);
        this.rtModule.getTasks().add(this.rtTask);
        return null;
    }

    private RtSymbolAccess createSymbolAccess(RtModule rtModule, SymbolAccessor symbolAccessor, int j) {
        RtSymbolAccess access = RtFactory.eINSTANCE.createRtSymbolAccess();
        if (symbolAccessor instanceof DirectValue) {
            DirectValue directValue = (DirectValue) symbolAccessor;
            RtDirectValue rtDw = RtFactory.eINSTANCE.createRtDirectValue();
            rtDw.setValue(directValue.getValue());
            access.setSymbol(rtDw);
            access.setType(RtSymbolAccessType.READ);
        } else {
            Symbol symbol = symbolAccessor.getSymbol();
            String name = symbol.getName();
            if (name == null) {
                throw new RuntimeException("Internal Error, symbol has invalid identifier");
                // System.out.println();
            }
            EList<RtSymbol> symbols = rtModule.getSymbols();
            RtSymbol s = null;
            for (RtSymbol rtSymbol : symbols) {
                if (name.equalsIgnoreCase(rtSymbol.getName())) {
                    s = rtSymbol;
                    break;
                }
            }
            // TODO: set symbol access
            access.setSymbol(s);
        }
        return access;
    }

    private RtModuleInvocation createRtModuleInvocation(String name) {
        ModuleDefinition module = IHwModulesProvider.INSTANCE.findModuleByName(name);
        RtModuleInvocation rtModuleInvocation = RtFactory.eINSTANCE.createRtModuleInvocation();
        if (module == null) {
            throw new MicasCompileException(String.format("Internal error: Module not found '%s'", name));
        }
        rtModuleInvocation.setPastValuesCount(module.getPastValueCount());
        rtModuleInvocation.setName(module.getName());
        rtModuleInvocation.setOpcode(module.getId());
        int runtime = (int) module.getRuntime();
        BasicEList<Port> be = new BasicEList<>();
        be.addAll(module.getInputs());
        be.addAll(module.getOutputs());
        // add for each port group the runtime
        for (Port port : be) {
            if (port instanceof PortGroup) {
                PortGroup pg = (PortGroup) port;
                runtime += pg.getRuntime();
            }
        }
        rtModuleInvocation.setRuntime(runtime);
        return rtModuleInvocation;
    }

    public RtModule transform(Module module) {
        this.rtModule = null;
        doSwitch(module);
        TreeIterator<EObject> allContent = module.eAllContents();
        while (allContent.hasNext()) {
            doSwitch(allContent.next());
        }
        try {
            return this.rtModule;
        } finally {
            this.rtModule = null;
        }
    }
}
