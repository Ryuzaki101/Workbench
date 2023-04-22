package de.wisag.automation.micas.export.mic.internal.transformers;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;

public class ModuleTransformerFactory {
    // TODO: caching etc
    public static IInstanceTransformer createTransformer(String name) {

        if (WellknownSpecialBlocks.BEFAUS.equals(name)) {
            return new BEFAUSInstanceTransformer();
        } else if (WellknownSpecialBlocks.FKG.equals(name)) {
            return new FKGInstanceTransformer();
        } else if (WellknownSpecialBlocks.REGLER.equals(name)) {
            return new REGLERInstanceTransformer();
        } else if (WellknownSpecialBlocks.SOLKEN.equals(name)) {
            return new SOLKENInstanceTransformer();
    	} else if (WellknownSpecialBlocks.HXSTRA.equals(name)) {
    		return new HXSTRAInstanceTransformer();
    	} else if (WellknownSpecialBlocks.HXSTRA.equals(name)) {
    		return new HXSTRATextInstanceTransformer();
    	}
        
        return new DefaultInstanceTransformer();
    }
}
