package de.wisag.automation.micas.export.mic.internal.transformers;

import de.wisag.automation.micas.module.util.ModuleUtil;

public class SOLKENInstanceTransformer extends REGLERInstanceTransformer {

    @Override
    protected String getReglerNumberProperty() {
        return ModuleUtil.SOLKEN_PROP_NUMBER;
    }
}
