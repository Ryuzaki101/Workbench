package de.wisag.automation.micas.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.mIC.Module;

public class MicEObjectDocumentationProvider implements IEObjectDocumentationProvider {

    @Override
    public String getDocumentation(EObject o) {
        System.out.println("getDocumentation : " + o);
        StringBuilder sb = new StringBuilder();
        switch (o.eClass().getClassifierID()) {
        case MICPackage.MODULE:
            Module module2 = (Module) o;
            ModuleDefinition module = IHwModulesProvider.INSTANCE.findModuleByName(module2.getType());
            String hoverInfo2 = String.format(
                    "Modulname: %s \n" + "\tAnzahl Inputs\t\t: %d\n" + "\tAnzahl Outputs\t\t: %d\n"
                            + "\tAnzahl Vergangenheitswerte\t\t: %d",
                    module.getName(), module.getInputs().size(), module.getOutputs().size(),
                    module.getPastValueCount());
            sb.append(hoverInfo2);
            break;
        case MICPackage.TASK:
            sb.append("Micas Task");
            break;
        case MICPackage.FGA_MESSAGE_CONSTANT_REFERENCE:
            sb.append("IPAMB - Micas Meldungskonstante");
            break;
        case MICPackage.FGA_MEASURED_VALUE_REFERENCE:
            sb.append("IPAMW - Micas Messwertkonstante");
            break;
        case MICPackage.FGA_ANALOG_VALUE_REFERENCE:
            sb.append("IPAAW - Micas Analogwert");
            break;
        case MICPackage.FGA_VALUE_REFERENCE:
            sb.append("IPAZW - Micas Zaehlwert");
            break;
        case MICPackage.WORD_VAR:
            sb.append("Micas Wordvariable");
            break;
        case MICPackage.WORD_CONST:
            sb.append("Micas Wordconstante");
            break;
        case MICPackage.FLOAT_VAR:
            sb.append("Micas Floatvariable");
            break;
        case MICPackage.FLOAT_CONST:
            sb.append("Micas Floatconstante");
            break;

        }
        return sb.toString();
    }
}
