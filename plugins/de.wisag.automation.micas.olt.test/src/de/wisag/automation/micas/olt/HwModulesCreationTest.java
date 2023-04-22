package de.wisag.automation.micas.olt;

import org.junit.Test;

import de.wisag.automation.micas.hwmodules.HwTypesCreatorUtil;
import de.wisag.automation.micas.hwmodules.HwmodulesFactory;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModulesPersistentHelper;

public class HwModulesCreationTest {
    // ||'''Modul ID'''||'''DB_SEGMENT''' || '''DB_CHECKSUM'''||
    // '''ADR_CONV_LIST'''|| '''HEAD_SEGMENT'''||
    // '''END_MODUL'''||'''DATA_SEGMENT''' || '''STACK_SEGMENT''' ||
    // '''OF_SEGMENT'''|| '''MAX_PGM_SIZE'''||

    @Test
    public void create() throws Exception {

        MicasModules modules = HwmodulesFactory.eINSTANCE.createMicasModules();
        modules.getTypes().add(HwTypesCreatorUtil.createACXX());
        modules.getTypes().add(HwTypesCreatorUtil.createZPXX());
        modules.getTypes().add(HwTypesCreatorUtil.createERXX());
        modules.getTypes().add(HwTypesCreatorUtil.createMBXX());
        modules.getTypes().add(HwTypesCreatorUtil.createXX20());

        ModulesPersistentHelper.saveModules(modules, System.out);

        // ||'''''' |||| || || || || || || || ||
        // ||'''ZPXX''' ||0x1200|| 0x12f0|| 0x3ca0|| 0x3c80|| 0x3000|| 0x3700||
        // 0x3c00|| 0x3700|| 0x5000||
        // ||'''ERXX''' ||0x1200|| 0x12f0|| 0x0000|| 0x0500|| 0x3000|| 0x0510||
        // 0x0740|| 0x0510|| 0x2300||
        // ||'''MBXX''' ||0x1200|| 0x12f0|| 0x0000|| 0x0500|| 0x3000|| 0x0510||
        // 0x07e0|| 0x0510|| 0x2d00||
        // ||'''XX20''' ||0x1200|| 0x12f0|| 0x0000|| 0x1fd0|| 0x3000|| 0x0a00||
        // 0x1000|| 0x1fc0|| 0x6000||
    }
}
