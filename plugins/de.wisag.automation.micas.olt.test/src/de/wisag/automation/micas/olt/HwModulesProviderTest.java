package de.wisag.automation.micas.olt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;

public class HwModulesProviderTest {
    // ||'''Modul ID'''||'''DB_SEGMENT''' || '''DB_CHECKSUM'''||
    // '''ADR_CONV_LIST'''|| '''HEAD_SEGMENT'''||
    // '''END_MODUL'''||'''DATA_SEGMENT''' || '''STACK_SEGMENT''' ||
    // '''OF_SEGMENT'''|| '''MAX_PGM_SIZE'''||

    @Test
    public void testAC40() throws Exception {
        IHwModulesProvider provider = IHwModulesProvider.INSTANCE;
        assertTrue("AC40 not found", provider.supportsHardwareType("AC40"));
        HardwareTypeDefinition hw = provider.findHardwareTypeDefinition("AC40");
        HardwareType type = hw.getType();
        assertNotNull(type);
        assertEquals(HardwareType.ACXX, type);

    }

}
