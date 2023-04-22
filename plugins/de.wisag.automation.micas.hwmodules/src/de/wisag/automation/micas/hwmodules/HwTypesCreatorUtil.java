package de.wisag.automation.micas.hwmodules;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for creation of Type definitions
 *
 * @author mkr
 */
public class HwTypesCreatorUtil {

    public static HardwareTypeDefinition createTypeDef(String name, int dbSegment, int dbChecksum, int adrConvList,
            int headSegment, int endModule, int dataSegment, int stackSegment, int ofSegment, int maxPgmSize) {
        HardwareTypeDefinition def = HwmodulesFactory.eINSTANCE.createHardwareTypeDefinition();
        def.setDatabaseSegment(dbSegment);
        def.setDatabaseChecksumAddress(dbChecksum);
        def.setAddressConversionListAddress(adrConvList);
        def.setHeadSegment(headSegment);
        def.setEndModuleOpcode(endModule);
        def.setDataSegment(dataSegment);
        def.setStackSegment(stackSegment);
        def.setProgramSegment(ofSegment);
        def.setMaxProgramSize(maxPgmSize);
        return def;
    }

    public static HardwareAlias createAlias(String name) {
        HardwareAlias alias = null;
        alias = HwmodulesFactory.eINSTANCE.createHardwareAlias();
        alias.setName(name);
        return alias;
    }

    public static List<HardwareTypeDefinition> allDefinitions() {
        List<HardwareTypeDefinition> typeDefs = new ArrayList<>();

        return typeDefs;
    }

    public static HardwareTypeDefinition createXX20() {
        HardwareTypeDefinition def;
        def = createTypeDef("XX20", 0x1200, 0x12f0, 0x0000, 0x1fd0, 0x3000, 0x0a00, 0x1000, 0x1fc0, 0x6000);
        def.getAliases().add(createAlias("AR20"));
        def.getAliases().add(createAlias("SP20"));
        return def;
    }

    public static HardwareTypeDefinition createMBXX() {
        HardwareTypeDefinition def;
        def = createTypeDef("MBXX", 0x1200, 0x12f0, 0x0000, 0x0500, 0x3000, 0x0510, 0x07e0, 0x0510, 0x2d00);
        def.getAliases().add(createAlias("MB11"));
        def.getAliases().add(createAlias("MB13"));
        def.getAliases().add(createAlias("AR11"));
        def.getAliases().add(createAlias("AR12"));
        def.getAliases().add(createAlias("SP11"));
        return def;
    }

    public static HardwareTypeDefinition createERXX() {
        HardwareTypeDefinition def;
        def = createTypeDef("ERXX", 0x1200, 0x12f0, 0x0000, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300);
        def.getAliases().add(createAlias("ER11"));
        return def;
    }

    public static HardwareTypeDefinition createZPXX() {
        HardwareTypeDefinition def;
        def = createTypeDef("ZPXX", 0x1200, 0x12f0, 0x3ca0, 0x3c80, 0x3000, 0x3700, 0x3c00, 0x3700, 0x5000);
        def.getAliases().add(createAlias("ZP11"));
        def.getAliases().add(createAlias("ZP12"));
        def.getAliases().add(createAlias("ZP13"));
        def.getAliases().add(createAlias("GW12"));
        def.getAliases().add(createAlias("GW13"));
        def.getAliases().add(createAlias("GW14"));
        def.getAliases().add(createAlias("ZM12"));
        def.getAliases().add(createAlias("ZM13"));
        def.getAliases().add(createAlias("ZM14"));
        def.getAliases().add(createAlias("ZM15"));
        return def;
    }

    public static HardwareTypeDefinition createACXX() {
        HardwareTypeDefinition def = null;
        def = createTypeDef("ACXX", 0x5200, 0x52f0, 0x7ca0, 0x7c80, 0x3000, 0x7700, 0x7c00, 0x7700, 0x5000);
        def.getAliases().add(createAlias("AC40"));
        def.getAliases().add(createAlias("ER12"));
        return def;
    }

}
