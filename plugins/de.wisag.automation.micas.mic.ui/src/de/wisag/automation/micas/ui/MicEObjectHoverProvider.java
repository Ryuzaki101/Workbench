package de.wisag.automation.micas.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.mIC.Module;

public class MicEObjectHoverProvider extends DefaultEObjectHoverProvider {
    @Override
    protected String getFirstLine(EObject o) {
        System.out.println("First Line : " + o);
        if (o.eClass().getClassifierID() == MICPackage.MODULE) {
            StringBuilder sb = new StringBuilder();
            Module module2 = (Module) o;
            ModuleDefinition module = IHwModulesProvider.INSTANCE.findModuleByName(module2.getType());
            String hoverInfo2 = String.format(
                    "Modulname: %s \n" + "\tAnzahl Inputs\t\t: %d\n" + "\tAnzahl Outputs\t\t: %d\n"
                            + "\tAnzahl Vergangenheitswerte\t\t: %d",
                    module.getName(), module.getInputs().size(), module.getOutputs().size(),
                    module.getPastValueCount());
            sb.append(hoverInfo2);
            return sb.toString();
        }
        return super.getFirstLine(o);
    }
}
