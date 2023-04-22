package de.wisag.automation.micas.rt;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.rt.util.RtSwitch;

/**
 * Simple MIC Text file generator
 */
public class MicSourceGenerator extends RtSwitch<MicSourceGenerator> {
    private final RtModule rtModule;
    private PrintWriter output;
    private NumberFormat floatFormatter;
    private boolean generateSymbolAccess = false;

    public MicSourceGenerator(RtModule mrt) {
        floatFormatter = NumberFormat.getInstance(Locale.US);
        floatFormatter.setMinimumFractionDigits(2);
        floatFormatter.setGroupingUsed(false);

        this.rtModule = mrt;
    }

    public RtModule getRtModule() {
        return rtModule;
    }

    public String generate() {
        StringWriter sw = new StringWriter();
        output = new PrintWriter(sw);
        doGenerate();
        return sw.toString();
    }

    private void doGenerate() {
        doSwitch(rtModule);
        TreeIterator<EObject> i = this.rtModule.eAllContents();
        while (i.hasNext()) {
            doSwitch(i.next());
        }
        output.println("ENDMODUL");
    }

    @Override
    public MicSourceGenerator caseRtModule(RtModule rtModule) {
        EList<String> comments = rtModule.getComments();
        for (String comment : comments) {
            output.printf(";%s\r\n", comment);
        }
        output.printf("MODUL (%s,%d)\r\n", rtModule.getHwType().getLiteral(), rtModule.getFieldBus());
        return null;
    }

    @Override
    public MicSourceGenerator caseRtTask(RtTask task) {
        output.println(String.format(" ;%s", task.getComment()));
        if (task.getStrategy().getLiteral().equalsIgnoreCase("INIT")) {
            output.println(String.format(" TASK (%d,%s)", task.getId(), task.getStrategy().getLiteral().toLowerCase()));
        } else {
            output.println(String.format(" TASK (%d,%s,%d)", task.getId(),
                    task.getStrategy().getLiteral().toLowerCase(), task.getCyclTime()));
        }
        return null;
    }

    @Override
    public MicSourceGenerator caseRtWordConstant(RtWordConstant constant) {
        output.printf("  WordK %s (%d)\r\n", constant.getDisplayName(), constant.getValue());
        dumpAccess(output, constant);
        return super.caseRtWordConstant(constant);
    }

    private void dumpAccess(PrintWriter output, RtSymbol symbol) {
        if (!generateSymbolAccess) {
            return;
        }
        EList<RtSymbolAccess> accessors = symbol.getAccessors();
        for (RtSymbolAccess rtSymbolAccess : accessors) {
            int taskId = rtSymbolAccess.getModuleInvocation().getTask().getId();
            int modIndex = rtSymbolAccess.getModuleInvocation().getIndex();
            String modName = rtSymbolAccess.getModuleInvocation().getName();
            output.printf(String.format("   ; %s (%d,%d) %s\r\n", modName, taskId, modIndex,
                    rtSymbolAccess.getType().getLiteral()));
        }
    }

    @Override
    public MicSourceGenerator caseRtReferenceConstant(RtReferenceConstant reference) {
        switch (reference.getType()) {
        case FGA_ANALOG_VALUE:
            output.printf("  IPAAW %s (%d)\r\n", referenceName(reference), reference.getRow());
            break;
        case FGA_MEASURED_VALUE:
            output.printf("  IPAMW %s (%d)\r\n", referenceName(reference), reference.getRow());
            break;
        case FGA_MESSAGE_CONST:
            output.printf("  IPAMB %s (%d,%d)\r\n", referenceName(reference), reference.getRow(), reference.getCol());
            break;
        case FGA_VALUE:
            output.printf("  IPAZW %s (%d)\r\n", referenceName(reference), reference.getRow());
            break;

        default:
            break;
        }
        dumpAccess(output, reference);
        return null;
    }

    private String referenceName(RtReferenceConstant reference) {
        String name = reference.getDisplayName();
        if (!name.startsWith("&")) {
            name = "&" + name;
        }
        return name;
    }

    @Override
    public MicSourceGenerator caseRtFloatConstant(RtFloatConstant object) {
        output.printf("  FloatK %s (%s)\r\n", object.getDisplayName(), floatFormatter.format(object.getValue()));
        dumpAccess(output, object);
        return super.caseRtFloatConstant(object);
    }

    @Override
    public MicSourceGenerator caseRtWordVariable(RtWordVariable object) {
        output.printf("  WordV %s\r\n", object.getDisplayName());
        dumpAccess(output, object);
        return null;
    }

    @Override
    public MicSourceGenerator caseRtFloatVariable(RtFloatVariable object) {
        output.printf("  FloatV %s\r\n", object.getDisplayName());
        dumpAccess(output, object);
        return null;
    }

    @Override
    public MicSourceGenerator caseRtModuleInvocation(RtModuleInvocation moduleInvocation) {
        if (moduleInvocation instanceof RtCommentModuleInvocation) {
            RtCommentModuleInvocation comment = (RtCommentModuleInvocation) moduleInvocation;
            output.println(String.format(" ;%s", comment.getText()));
            return null;
        }
        StringWriter lineOut = new StringWriter();
        PrintWriter lineWriter = new PrintWriter(lineOut);
        String name = moduleInvocation.getName();
        if (WellknownSpecialBlocks.ENDE.equals(name)) {
            // indenation!
            lineWriter.printf(" %s ", name);
        } else {
            lineWriter.printf("  ;prio : %d \r\n", moduleInvocation.getIndex());
            lineWriter.printf("  %s ", name);
        }
        EList<RtSymbolAccess> arguments = moduleInvocation.getArguments();
        if (arguments.isEmpty()) {
            lineWriter.println();
            output.print(lineOut.toString());
            return null;
        }
        boolean first = true;
        lineWriter.print("(");
        for (RtSymbolAccess rtSymbolAccess : arguments) {
            if (!first) {
                lineWriter.print(",");
            }
            RtSymbol symbol = rtSymbolAccess.getSymbol();
            Assert.isNotNull(symbol, "RtSymbolAccess has no Symbol");
            printAddressable(lineWriter, symbol);
            if (first) {
                first = false;
            }
        }
        lineWriter.print(")");
        lineWriter.println();

        output.println(adjustLineLength(lineOut.toString(), 80));
        return null;
    }

    private static String adjustLineLength(String content, int maxCharsInLine) {
        Assert.isNotNull(content, "content must not be null");
        List<String> shortenedLines = new ArrayList<>();
        for (String line : Arrays.asList(StringUtils.split(content, "\r\n"))) {
            int length = StringUtils.length(line);
            if (length > maxCharsInLine) {
                int index = maxCharsInLine;
                if (line.length() > maxCharsInLine) {
                    char[] chars = line.toCharArray();
                    // find last comma
                    while (chars[index] != ',') {
                        index--;
                    }
                    index++;
                } else {
                    index = line.length();
                }
                shortenedLines.add(line.substring(0, index));
                shortenedLines.add(adjustLineLength("   " + line.substring(index), maxCharsInLine));
            } else {
                shortenedLines.add(line);
            }
        }
        return StringUtils.join(shortenedLines, "\r\n");
    }

    private void printAddressable(PrintWriter output, RtSymbol symbol) {
        Assert.isNotNull(symbol, "Symbol must not be null");
        if (symbol instanceof RtDirectValue) {
            output.print(((RtDirectValue) symbol).getValue());
        } else if (symbol instanceof RtReferenceConstant) {
            output.print(referenceName((RtReferenceConstant) symbol));
        } else {
            output.print(symbol.getDisplayName());
        }
    }

    public boolean isGenerateSymbolAccess() {
        return generateSymbolAccess;
    }

    public void setGenerateSymbolAccess(boolean generateSymbolAccess) {
        this.generateSymbolAccess = generateSymbolAccess;
    }

}
