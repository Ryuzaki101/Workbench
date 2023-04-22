package de.wisag.automation.micas.export.mic.internal.transformers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Block;

import de.wisag.automation.micas.export.mic.internal.Policy;
import de.wisag.automation.micas.export.mic.internal.TransformerUtils;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.ModuleUtil;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbolAccess;

public class HXSTRATextInstanceTransformer extends DefaultInstanceTransformer {
	 @Override
	    public void transformInputs(RtModule rtm, RtModuleInvocation rmi, ModuleDefinition mdef, Page page, Block block) {
	        super.transformInputs(rtm, rmi, mdef, page, block);
	        EList<RtSymbolAccess> arguments = new BasicEList<>();
	        arguments.addAll(rmi.getArguments());
	        String sNumber = ModuleUtil.getArgumentValue(block, getReglerNumberProperty());
	        int number = 0;
	        try {
	            number = Integer.parseInt(sNumber);
	        } catch (NumberFormatException e) {
	            Policy.logError(e);
	        }
	        RtSymbolAccess sa = TransformerUtils.createDirectValueSymbolAccess(rtm, number);
	        rmi.getArguments().clear();
	        rmi.getArguments().add(sa);
	        rmi.getArguments().addAll(arguments);
	    }

	    protected String getReglerNumberProperty() {
	        return ModuleUtil.HXSTRA_PROP_TEXT;
	    }

}
