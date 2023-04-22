package de.wisag.automation.micas.compiler.mic.test;

import org.apache.commons.lang.StringUtils;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortGroup;
import de.wisag.automation.micas.rt.MicSourceGenerator;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;
import de.wisag.automation.micas.rt.RtTask;

public class DummyMicGeneratorGenerator {
    public String createMicSource(ModuleDefinition module, int count) {
        int taskIndex = 1;
        RtFactory rtFactory = RtFactory.eINSTANCE;
        RtModule rtModule = rtFactory.createRtModule();
        rtModule.setFieldBus(42);
        addDummyTask(rtFactory, rtModule, taskIndex++);

        RtTask rtTask = rtFactory.createRtTask();
        rtTask.setId(taskIndex++);
        rtTask.setCyclTime(1000);
        rtTask.setModule(rtModule);
        SymbolCreator symbolCreator = new SymbolCreator();
        for (int i = 0; i < count; i++) {
            generateModule(module, rtFactory, rtTask, symbolCreator);
        }
        RtModuleInvocation rtModuleInvocation = rtFactory.createRtModuleInvocation();
        rtModuleInvocation.setName(WellknownSpecialBlocks.ENDE);
        rtTask.getModuleInvocations().add(rtModuleInvocation);

        addDummyTask(rtFactory, rtModule, taskIndex++);
        MicSourceGenerator sourceGenerator = new MicSourceGenerator(rtModule);
        String micSource = sourceGenerator.generate();
        micSource = StringUtils.replace(micSource, "MODUL (AC40,42)", "MODUL (@TYPE@, @FILEDBUS@)");
        return micSource;

    }

    private void generateModule(ModuleDefinition module, RtFactory rtFactory, RtTask rtTask,
            SymbolCreator symbolCreator) {

        final RtModuleInvocation rmi = rtFactory.createRtModuleInvocation();
        rmi.setIndex(1);
        rmi.setName(module.getName());
        rmi.setTask(rtTask);

        rtTask.getModuleInvocations().add(rmi);

        for (Port port : module.getInputs()) {
            addPort(rtFactory, port, rmi, symbolCreator);
        }
        for (Port port : module.getOutputs()) {
            addPort(rtFactory, port, rmi, symbolCreator);
        }
    }

    private void addPort(RtFactory rtFactory, Port port, final RtModuleInvocation rmi, SymbolCreator symbolCreator) {
        RtModule module = rmi.getTask().getModule();
        if (port instanceof PortGroup) {
            PortGroup portGroup = (PortGroup) port;
            RtDirectValue directValue = rtFactory.createRtDirectValue();
            directValue.setValue(1);
            directValue.setName(symbolCreator.nextDvName());
            directValue.setModule(module);
            RtSymbolAccess symbolAccess = rtFactory.createRtSymbolAccess();
            module.addSymbol(directValue);
            symbolAccess.setSymbol(directValue);
            directValue.getAccessors().add(symbolAccess);

            symbolAccess.setType(RtSymbolAccessType.READ);
            rmi.getArguments().add(symbolAccess);
            symbolAccess.setModuleInvocation(rmi);

            RtSymbolAccess symbolAccess2 = rtFactory.createRtSymbolAccess();
            RtSymbol symbol = symbolCreator.nextSymbol(portGroup, false);
            symbol.setModule(module);
            module.addSymbol(symbol);
            symbolAccess2.setSymbol(symbol);
            symbol.getAccessors().add(symbolAccess2);
            rmi.getArguments().add(symbolAccess2);
            symbolAccess2.setModuleInvocation(rmi);
        } else {
            RtSymbolAccess symbolAccess = rtFactory.createRtSymbolAccess();
            RtSymbol symbol = symbolCreator.nextSymbol(port, false);
            module.addSymbol(symbol);
            symbol.setModule(module);
            symbolAccess.setSymbol(symbol);
            symbol.getAccessors().add(symbolAccess);
            rmi.getArguments().add(symbolAccess);
            symbolAccess.setModuleInvocation(rmi);
        }
    }

    private void addDummyTask(RtFactory rtFactory, RtModule rtModule, int index) {
        RtTask rtTask = rtFactory.createRtTask();
        rtTask.setId(index);
        rtTask.setCyclTime(1000);
        rtTask.setModule(rtModule);

        final RtModuleInvocation rmi = rtFactory.createRtModuleInvocation();
        rmi.setIndex(1);
        rmi.setName(WellknownSpecialBlocks.ENDE);
        rtTask.getModuleInvocations().add(rmi);

    }
}