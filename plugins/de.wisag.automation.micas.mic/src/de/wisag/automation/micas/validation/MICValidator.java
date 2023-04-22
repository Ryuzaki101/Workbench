package de.wisag.automation.micas.validation;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Check;

import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.mIC.MICPackage;
import de.wisag.automation.micas.mIC.MetaData;
import de.wisag.automation.micas.mIC.Module;
import de.wisag.automation.micas.mIC.ModuleInvokation;
import de.wisag.automation.micas.mIC.Symbol;
import de.wisag.automation.micas.mIC.SymbolAccessor;
import de.wisag.automation.micas.mIC.Task;
import de.wisag.automation.micas.utils.ParseUtils;

/**
 * This class contains custom validation rules. See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class MICValidator extends AbstractMICValidator {

    @Check
    public void checkModule(Module module) {
        String type = module.getType();
        if (!getModuleProvider().supportsHardwareType(type)) {
            error(String.format("Unsupported Module Type %s", type), MICPackage.Literals.MODULE__TYPE);
        }
    }

    @Check
    public void checkSymbol(Symbol symbol) {
        if (symbol instanceof MetaData) {
            return;
        }
        if (!isUnused(symbol)) {
            de.wisag.automation.micas.mIC.Module module = (de.wisag.automation.micas.mIC.Module) symbol.eContainer();
            int symbolIndex = module.getDecalarations().indexOf(symbol);
            if (symbolIndex > -1) {
                warning(String.format("Unused Symbol '%s'", symbol.getName()), module,
                        MICPackage.Literals.MODULE__DECALARATIONS, symbolIndex);
            }
        }

    }

    private boolean isUnused(Symbol symbol) {
        de.wisag.automation.micas.mIC.Module module = (de.wisag.automation.micas.mIC.Module) symbol.eContainer();
        EList<Task> tasks = module.getTasks();
        boolean symbolIsUsed = false;
        TASKS: for (Task task : tasks) {
            Collection<ModuleInvokation> invocations = EcoreUtil.getObjectsByType(task.getInstructions(),
                    MICPackage.eINSTANCE.getModuleInvokation());
            for (ModuleInvokation moduleInvokation : invocations) {
                EList<SymbolAccessor> accesses = moduleInvokation.getArguments();
                for (SymbolAccessor symbolAccessor : accesses) {
                    if (symbol.equals(symbolAccessor.getSymbol())) {
                        symbolIsUsed = true;
                        break TASKS;
                    }
                }
            }
        }
        return symbolIsUsed;
    }

    @Check
    public void checkMetaData(MetaData metaData) {
        ParseUtils.prepareMetadata(metaData);
    }

    @Check
    public void checkModuleInvocation(ModuleInvokation invokation) {
        String moduleName = invokation.getModuleName();
        IHwModulesProvider provider = getModuleProvider();
        ModuleDefinition module = provider.findModuleByName(moduleName);
        if (module == null) {
            error(String.format("Block  '%s' is not known", moduleName),
                    MICPackage.Literals.MODULE_INVOKATION__MODULE_NAME);
        }
    }

    @Check
    public void checkSymbolAccessor(SymbolAccessor accessor) {
        IHwModulesProvider provider = getModuleProvider();
        ModuleInvokation invokation = (ModuleInvokation) accessor.eContainer();
        int argIndex = invokation.getArguments().indexOf(accessor);
        ModuleDefinition module = provider.findModuleByName(invokation.getModuleName());
        boolean onOutputSide = false;
        if (module.getPortGroupsCount() > 0) {

        } else {
            // TODO: check if this works in all cases
            int inputs = module.getInputs().size();
            if (argIndex >= inputs) {
                onOutputSide = true;
            } else {

            }
        }
        // update the model from module definition
        accessor.setWriting(onOutputSide);
        if (onOutputSide && !isWritable(accessor.getSymbol(), accessor.getSymbol().eClass().getClassifierID())) {
            warning(String.format("Overriding %s ", accessor.getSymbol().getName()),
                    MICPackage.Literals.SYMBOL_ACCESSOR__SYMBOL);
        }
        // System.out.println("" + invokation.getModuleName() + " " + argIndex);
    }

    private IHwModulesProvider getModuleProvider() {
        return IHwModulesProvider.INSTANCE;
    }

    private boolean isWritable(Symbol symbol, int featureId) {
        boolean writable = false;
        switch (featureId) {
        case MICPackage.FGA_ANALOG_VALUE_REFERENCE:
            writable = true;
            break;
        case MICPackage.WORD_VAR:
            writable = true;
            break;
        case MICPackage.FLOAT_VAR:
            writable = true;
            break;
        default:
            break;
        }
        return writable;
    }

}
