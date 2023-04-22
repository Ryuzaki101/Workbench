package de.wisag.automation.micas.rt;

import static de.wisag.automation.micas.rt.BinaryUtils.hexfmt;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.rt.util.RtSwitch;

public class MicReporter extends RtSwitch<MicReporter> {

    private PrintWriter pw;

    @Override
    public MicReporter caseRtModule(RtModule module) {
        int hSeg = module.getHeadModuleSegmentAddress();
        // int dseg = module.getDataSegmentAddress();
        pw.println("******************* Hardware parameter  ****************");
        pw.println(String.format("Type : %s", module.getHwType().getName()));

        pw.println("StartSegmentAddress  	 : " + hexfmt(module.getStartSegmentAddress()));
        pw.println("DataSegmentAddress  	 : " + hexfmt(module.getDataSegmentAddress()));
        pw.println("DataSegmentChecksum 	 : " + hexfmt(module.getDataSegmentCheckSum()));
        pw.println("TaskSegmentChecksum 	 : " + hexfmt(module.getTasksCheckSum()));
        pw.println("HeadModuleSegmentAddress : " + hexfmt(hSeg));
        pw.println("WordConstOffset     	 : " + hexfmt(module.getWordConstOffset()));
        pw.println("WordConstCount     	     : " + module.getWordConstants().size() + module.getReferences().size());

        pw.println("FloatConstOffset         : " + hexfmt(module.getFloatConstOffset()));
        pw.println("FloatConstCount     	 : " + module.getFloatConstants().size());

        pw.println("WordVarsOffset     	 : " + hexfmt(module.getWordVarOffset()));
        pw.println("WordVarsCount     	     : " + module.getWordVariables().size());

        pw.println("FloatVarsOffset         : " + hexfmt(module.getFloatVarOffset()));
        pw.println("FloatVarsCount     	 : " + module.getFloatVariables().size());

        pw.println("PastValuesOffset         : " + hexfmt(module.getPastValuesOffset()));
        pw.println("PastValuesLastOffset     : " + hexfmt(module.getPastValuesLastOffset()));

        RtHeadModule hm = module.getHeadModul();
        pw.println("******************* HEAD Module ****************");
        pw.println("Task Count       : " + hm.getTaskCount());
        pw.println("Segment Address  : " + hexfmt(module.getHeadModuleSegmentAddress()));
        EList<RtTaskInfo> taskInfos = hm.getTaskInfos();
        for (RtTaskInfo rtTaskInfo : taskInfos) {
            pw.println("    TaskId                     : " + hexfmt(rtTaskInfo.getTask().getId()));
            pw.println("      Strategy                 : " + hexfmt(rtTaskInfo.getConvertedStrategy()));
            pw.println("      Task Segment  		   : " + hexfmt(rtTaskInfo.getTask().getSegment()));
            pw.println("      Task CyclTime 		   : " + hexfmt(rtTaskInfo.getTask().getCyclTime()));
            pw.println("      Task PastValues Offset   : " + hexfmt(rtTaskInfo.getTask().getPastValuesOffset()));
            pw.println("      Task PastValues Count    : " + rtTaskInfo.getTask().getPastValuesCount());
        }
        pw.println("******************* Task Details ****************");

        EList<RtTask> tasks = module.getTasks();
        for (RtTask rtTask : tasks) {
            pw.println("    TaskId                 : " + hexfmt(rtTask.getId()));
            pw.println("    Runtime                : " + rtTask.getRuntime());
            pw.println("    Task CyclTime 		   : " + hexfmt(rtTask.getCyclTime()));
            EList<RtModuleInvocation> invocations = rtTask.getModuleInvocations();

            for (RtModuleInvocation rtModuleInvocation : invocations) {
                pw.println("     Modulecall            : " + rtModuleInvocation.getName());
                pw.println("     pastvalues            : " + rtModuleInvocation.getPastValuesCount());
                pw.println("     opcode                : " + hexfmt(rtModuleInvocation.getOpcode()));
                EList<RtSymbolAccess> arguments = rtModuleInvocation.getArguments();
                for (RtSymbolAccess rtSymbolAccess : arguments) {
                    RtSymbol symbol = rtSymbolAccess.getSymbol();
                    if (symbol instanceof RtDirectValue) {
                        int value = ((RtDirectValue) symbol).getValue();
                        pw.println("          symbol  : " + " direct value");
                        pw.println("          read    : "
                                + (rtSymbolAccess.getType() == RtSymbolAccessType.READ ? "true" : "false"));
                        pw.println("          value  : " + value);

                    } else {
                        pw.println("          symbol  : " + symbol.getName());
                        pw.println("          read    : "
                                + (rtSymbolAccess.getType() == RtSymbolAccessType.READ ? "true" : "false"));
                        pw.println("          address : " + hexfmt(symbol.getAddress()));
                    }

                }
            }
            pw.println("    ******************************************");
        }

        return null;
    }

    @Override
    public MicReporter caseRtTask(RtTask task) {
        return null;
    }

    @Override
    public MicReporter caseRtModuleInvocation(RtModuleInvocation invocation) {
        return null;
    }

    public String generateReport(RtModule rtModule) {
        StringWriter writer = new StringWriter();
        pw = new PrintWriter(writer);
        doSwitch(rtModule);
        TreeIterator<EObject> i = rtModule.eAllContents();
        while (i.hasNext()) {
            doSwitch(i.next());
        }
        pastValueStatistics(rtModule);

        String string = writer.toString();
        pw.close();
        return string;
    }

    private void pastValueStatistics(RtModule rtModule) {
        pw.println("Task id;Modulename;Pastvaluecount");
        for (RtTask task : rtModule.getTasks()) {
            for (RtModuleInvocation rmi : task.getModuleInvocations()) {
                pw.println(" Task" + task.getId() + ";" + rmi.getName() + ";" + rmi.getPastValuesCount() + ";");
            }
        }

    }
}
