package de.wisag.automation.micas.compiler;

import de.wisag.automation.micas.compiler.mic.internal.bbc1988.BBCMicasCompiler;
import de.wisag.automation.micas.compiler.mic.internal.modern.MicasCompiler;

public class MicasCompilerFactory {

    public static IMicasCompiler create(CompilerFlavour flavour) {
        if (flavour == CompilerFlavour.WISAG) {
            return new MicasCompiler();
        } else {
            return new BBCMicasCompiler();
        }
    }
}
