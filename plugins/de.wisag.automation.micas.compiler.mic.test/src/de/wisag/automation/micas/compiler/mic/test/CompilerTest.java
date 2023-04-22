package de.wisag.automation.micas.compiler.mic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;

import de.wisag.automation.micas.compiler.ICompileResult;
import de.wisag.automation.micas.compiler.mic.internal.modern.MicasCompiler;
import de.wisag.automation.micas.h86.H86Factory;
import de.wisag.automation.micas.rt.BinaryUtils;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class CompilerTest {

    private static final String TEST_RES_FMT = "/de/wisag/automation/micas/compiler/mic/test/types/%s/%s";
    private static final String NAME = "29AC4005";
    private ICompileResult result;

    @Before
    public void setUp() throws Exception {
        H86Factory.eINSTANCE.eClass();
        MicasCompiler compiler = new MicasCompiler();
        result = compiler.compile(new NullProgressMonitor(),
                getClass().getResourceAsStream(String.format(TEST_RES_FMT, NAME, NAME + ".MIC")), "iso-8859-1");
    }

    @Test
    public void testCompileDataTypesAC40() throws Exception {
        assertTrue(findSymbol(result.getRtModule(), "$IN-BEFAUS_ON2_25425") instanceof RtWordConstant);
        assertTrue(findSymbol(result.getRtModule(), "$IN-BEFAUS_ON3_22640") instanceof RtWordConstant);
        assertTrue(findSymbol(result.getRtModule(), "$IN-ZWAUS_DELTA_29919") instanceof RtFloatConstant);
        assertTrue(findSymbol(result.getRtModule(), "$IN-ZWAUS_MODE_22034") instanceof RtWordConstant);
        assertTrue(findSymbol(result.getRtModule(), "$WZERO") instanceof RtWordConstant);
        assertTrue(findSymbol(result.getRtModule(), "&ID_00002-000-00-C-BM") instanceof RtReferenceConstant);
        assertTrue(findSymbol(result.getRtModule(), "&ID_00002-006-00-C-MW") instanceof RtReferenceConstant);
        assertTrue(findSymbol(result.getRtModule(), "&ID_00002-007-00-C-MW") instanceof RtReferenceConstant);
        assertTrue(findSymbol(result.getRtModule(), "&ID_00002-016-00-C-AS") instanceof RtReferenceConstant);
        assertTrue(findSymbol(result.getRtModule(), "&ID_0002-028-00-C-ZW") instanceof RtReferenceConstant);
        assertTrue(findSymbol(result.getRtModule(), "&ZW_4711") instanceof RtReferenceConstant);
        assertTrue(findSymbol(result.getRtModule(), "BINK0") instanceof RtWordConstant);
        assertTrue(findSymbol(result.getRtModule(), "ERROR2") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINE1W") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINIE2") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINIE3") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINIE4R") instanceof RtFloatVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINIE5R") instanceof RtFloatVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINIE6R") instanceof RtFloatVariable);
        assertTrue(findSymbol(result.getRtModule(), "LINIE7R") instanceof RtFloatVariable);
        assertTrue(findSymbol(result.getRtModule(), "MP1") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "MP2") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "WERR-ANAUS-ERROR497") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "WERR-ANEIN-ERROR112") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "WERR-ANEIN2-ERROR289") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "WERR-BEFAUS-ERROR114") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "WERR-ZWAUS-ERROR89") instanceof RtWordVariable);
        assertTrue(findSymbol(result.getRtModule(), "WERR-ZWEIN-ERROR400") instanceof RtWordVariable);
    }

    @Test
    public void testCompileAddressesAC40() throws Exception {
        assertEquals(0x0030, findSymbolAddress(result.getRtModule(), "BINK0"));
        assertEquals(0x0032, findSymbolAddress(result.getRtModule(), "&ID_00002-000-00-C-BM"));
        assertEquals(0x0034, findSymbolAddress(result.getRtModule(), "&ID_00002-006-00-C-MW"));
        assertEquals(0x0036, findSymbolAddress(result.getRtModule(), "&ID_00002-007-00-C-MW"));
        assertEquals(0x0038, findSymbolAddress(result.getRtModule(), "&ID_00002-016-00-C-AS"));
        assertEquals(0x003A, findSymbolAddress(result.getRtModule(), "&ID_0002-028-00-C-ZW"));
        assertEquals(0x003C, findSymbolAddress(result.getRtModule(), "$WZERO"));
        assertEquals(0x003E, findSymbolAddress(result.getRtModule(), "&ZW_4711"));
        assertEquals(0x0040, findSymbolAddress(result.getRtModule(), "$IN-BEFAUS_ON2_25425"));
        assertEquals(0x0042, findSymbolAddress(result.getRtModule(), "$IN-BEFAUS_ON3_22640"));

        assertEquals(0x0044, findSymbolAddress(result.getRtModule(), "$IN-ZWAUS_MODE_22034"));
        assertEquals(0x0050, findSymbolAddress(result.getRtModule(), "$IN-ZWAUS_DELTA_29919"));
        assertEquals(0x0060, findSymbolAddress(result.getRtModule(), "LINIE2"));
        assertEquals(0x0062, findSymbolAddress(result.getRtModule(), "LINIE3"));
        assertEquals(0x0064, findSymbolAddress(result.getRtModule(), "ERROR2"));
        assertEquals(0x0066, findSymbolAddress(result.getRtModule(), "LINE1W"));
        assertEquals(0x0068, findSymbolAddress(result.getRtModule(), "MP1"));
        assertEquals(0x006A, findSymbolAddress(result.getRtModule(), "MP2"));
        assertEquals(0x006C, findSymbolAddress(result.getRtModule(), "WERR-ANEIN-ERROR112"));
        assertEquals(0x006E, findSymbolAddress(result.getRtModule(), "WERR-BEFAUS-ERROR114"));
        assertEquals(0x0070, findSymbolAddress(result.getRtModule(), "WERR-ANEIN2-ERROR289"));
        assertEquals(0x0072, findSymbolAddress(result.getRtModule(), "WERR-ANAUS-ERROR497"));
        assertEquals(0x0074, findSymbolAddress(result.getRtModule(), "WERR-ZWEIN-ERROR400"));
        assertEquals(0x0076, findSymbolAddress(result.getRtModule(), "WERR-ZWAUS-ERROR89"));
        assertEquals(0x0080, findSymbolAddress(result.getRtModule(), "LINIE4R"));
        assertEquals(0x0084, findSymbolAddress(result.getRtModule(), "LINIE5R"));
        assertEquals(0x0088, findSymbolAddress(result.getRtModule(), "LINIE6R"));
        assertEquals(0x008C, findSymbolAddress(result.getRtModule(), "LINIE7R"));
    }

    @Test
    public void testOffsetsAC40() throws Exception {
        assertEquals(0x30, result.getRtModule().getWordConstOffset());
        int wcCount = result.getRtModule().getWordConstants().size() + result.getRtModule().getReferences().size();
        assertEquals(11, wcCount);
        assertEquals(0x50, result.getRtModule().getFloatConstOffset());
        assertEquals(0x01, result.getRtModule().getFloatConstants().size());
        assertEquals(0x60, result.getRtModule().getWordVarOffset());
        assertEquals(12, result.getRtModule().getWordVariables().size());
        assertEquals(0x80, result.getRtModule().getFloatVarOffset());
        assertEquals(4, result.getRtModule().getFloatVariables().size());
        assertEquals(0xA0, result.getRtModule().getPastValuesOffset());
    }

    @Test
    public void testOffsetsOnImageAC40() throws Exception {
        byte[] dataSegment = result.getRtModule().getDataSegment();
        // wordConstOffset
        assertEquals(0x30, BinaryUtils.getUShort(dataSegment, 0x00));
        // floatConstOffset
        assertEquals(0x50, BinaryUtils.getUShort(dataSegment, 0x02));
        // wordVarOffset
        assertEquals(0x60, BinaryUtils.getUShort(dataSegment, 0x04));
        // floatVarOffset
        assertEquals(0x80, BinaryUtils.getUShort(dataSegment, 0x06));

        // vWwOff
        assertEquals(0xa0, BinaryUtils.getUShort(dataSegment, 0x08));
        // vWwEndOffset
        assertEquals(0xd0, BinaryUtils.getUShort(dataSegment, 0x0a));
        // dataSegment
        assertEquals(0x7700, BinaryUtils.getUShort(dataSegment, 0x0c));
    }

    @Test
    public void testSegmentsAC40() throws Exception {
        RtModule rtModule = result.getRtModule();
        assertEquals(0x7700, rtModule.getDataSegmentAddress());
        assertEquals(0x7c80, rtModule.getHeadModuleSegmentAddress());
        assertEquals(0x770d, rtModule.getFirstTaskSegmentAddress());
        assertEquals(0x770d, findTask(rtModule, 1).getSegment());
        assertEquals(0x770e, findTask(rtModule, 2).getSegment());
    }

    @Test
    public void testHeadModuleAC40() throws Exception {
        RtModule rtModule = result.getRtModule();
        byte[] headModule = null;
        // MicasAddressUtils.createHeadModule(rtModule);
        findTask(rtModule, 2);
        // 7C80:0000 F000
        assertEquals(0xf000, BinaryUtils.getUShort(headModule, 0x0));
        // 7C80:0002 2000
        assertEquals(0x2000, BinaryUtils.getUShort(headModule, 0x2));
        // 7C80:0004 0002
        assertEquals(0x0002, BinaryUtils.getUShort(headModule, 0x4));
        // now iterate over the tasks
        // 7C80:0006 0104 ;Task 1
        assertEquals(0x0104, BinaryUtils.getUShort(headModule, 0x6));
        // 7C80:0008 0000 ;Zykluszeit
        assertEquals(0x0000, BinaryUtils.getUShort(headModule, 0x8));
        // 7C80:000A 770D ;Segmentadresse
        assertEquals(0x770d, BinaryUtils.getUShort(headModule, 0x0a));
        // 7C80:000C 00A0 ;Vergangenheitswerte
        assertEquals(0x770d, BinaryUtils.getUShort(headModule, 0x0a));
        // 7C80:000E 0201 ;Task 2
        assertEquals(0x0201, BinaryUtils.getUShort(headModule, 0x0e));
        // 7C80:0010 03E8 ;Zykluszeit
        assertEquals(0x03e8, BinaryUtils.getUShort(headModule, 0x10));
        // 7C80:0012 770E ;Segmentadresse
        assertEquals(0x770e, BinaryUtils.getUShort(headModule, 0x12));
        // 7C80:0014 00B0 ;Vergangenheitswerte
        assertEquals(0x00b0, BinaryUtils.getUShort(headModule, 0x14));

    }

    @Test
    public void testDataSegmentChecksumAC40() throws Exception {
        RtModule rtModule = result.getRtModule();
        assertEquals(0x2071, rtModule.getDataSegmentCheckSum());
    }

    @Test
    public void testTaskChecksumAC40() throws Exception {
        RtModule rtModule = result.getRtModule();
        assertEquals(0xa6a1, rtModule.getTasksCheckSum());
    }

    @Test
    public void testH86AC40() throws Exception {
        System.out.println(result.getH86Data());
    }

    @Test
    public void testTask0AC40() throws Exception {
        RtModule rtModule = result.getRtModule();
        RtTask task = findTask(rtModule, 1);
        byte[] taskData = task.getData();
        assertEquals(0x770d, task.getSegment());
        // 770D:0000 F100
        assertEquals(0xf100, BinaryUtils.getUShort(taskData, 0x00));
        // 770D:0002 3000 ;ENDE
        assertEquals(0x3000, BinaryUtils.getUShort(taskData, 0x02));

    }

    @Test
    public void testTask1AC40() throws Exception {
        RtModule rtModule = result.getRtModule();
        RtTask task = findTask(rtModule, 2);
        byte[] taskData = task.getData();
        assertEquals(0x770e, task.getSegment());
        // 770E:0000 F200
        assertEquals(0xf200, BinaryUtils.getUShort(taskData, 0x0000));
        // 770E:0002 302F ;ANEIN
        assertEquals(0x302F, BinaryUtils.getUShort(taskData, 0x0002));
        // 770E:0004 0034 ;&ID_00002-006-00-C-MW
        assertEquals(0x0034, BinaryUtils.getUShort(taskData, 0x0004));
        // 770E:0006 0080 ;LINIE4R
        assertEquals(0x0080, BinaryUtils.getUShort(taskData, 0x0006));
        // 770E:0008 006C ;WERR-ANEIN-ERROR112
        assertEquals(0x006C, BinaryUtils.getUShort(taskData, 0x0008));
        // 770E:000A F201
        assertEquals(0xF201, BinaryUtils.getUShort(taskData, 0x000A));
        // 770E:000C 3017 ;NICHT
        assertEquals(0x3017, BinaryUtils.getUShort(taskData, 0x000C));
        // 770E:000E 0060 ;LINIE2
        assertEquals(0x0060, BinaryUtils.getUShort(taskData, 0x000E));
        // 770E:0010 0062 ;LINIE3
        assertEquals(0x0062, BinaryUtils.getUShort(taskData, 0x0010));
        // 770E:0012 F202
        assertEquals(0xF202, BinaryUtils.getUShort(taskData, 0x0012));
        // 770E:0014 3033 ;BEFAUS
        assertEquals(0x3033, BinaryUtils.getUShort(taskData, 0x0014));
        // 770E:0016 0002
        assertEquals(0x0002, BinaryUtils.getUShort(taskData, 0x0016));
        // 770E:0018 0062 ;LINIE3
        assertEquals(0x0062, BinaryUtils.getUShort(taskData, 0x0018));
        // 770E:001A 0066 ;LINE1W
        assertEquals(0x0066, BinaryUtils.getUShort(taskData, 0x001A));
        // 770E:001C 0040 ;$IN-BEFAUS_ON2_25425
        assertEquals(0x0040, BinaryUtils.getUShort(taskData, 0x001C));
        // 770E:001E 0042 ;$IN-BEFAUS_ON3_22640
        assertEquals(0x0042, BinaryUtils.getUShort(taskData, 0x001E));
        // 770E:0020 0032 ;&ID_00002-000-00-C-BM
        assertEquals(0x0032, BinaryUtils.getUShort(taskData, 0x0020));
        // 770E:0022 006E ;WERR-BEFAUS-ERROR114
        assertEquals(0x006E, BinaryUtils.getUShort(taskData, 0x0022));
        // 770E:0024 F203
        assertEquals(0xF203, BinaryUtils.getUShort(taskData, 0x0024));
        // 770E:0026 302F ;ANEIN
        assertEquals(0x302F, BinaryUtils.getUShort(taskData, 0x0026));
        // 770E:0028 0036 ;&ID_00002-007-00-C-MW
        assertEquals(0x0036, BinaryUtils.getUShort(taskData, 0x0028));
        // 770E:002A 0084 ;LINIE5R
        assertEquals(0x0084, BinaryUtils.getUShort(taskData, 0x002A));
        // 770E:002C 0070 ;WERR-ANEIN2-ERROR289
        assertEquals(0x0070, BinaryUtils.getUShort(taskData, 0x002C));
        // 770E:002E F204
        assertEquals(0xF204, BinaryUtils.getUShort(taskData, 0x002E));
        // 770E:0030 3003 ;ADD2
        assertEquals(0x3003, BinaryUtils.getUShort(taskData, 0x0030));
        // 770E:0032 0080 ;LINIE4R
        assertEquals(0x0080, BinaryUtils.getUShort(taskData, 0x0032));
        // 770E:0034 0084 ;LINIE5R
        assertEquals(0x0084, BinaryUtils.getUShort(taskData, 0x0034));
        // 770E:0036 0088 ;LINIE6R
        assertEquals(0x0088, BinaryUtils.getUShort(taskData, 0x0036));
        // 770E:0038 F205
        assertEquals(0xF205, BinaryUtils.getUShort(taskData, 0x0038));
        // 770E:003A 3032 ;ANAUS
        assertEquals(0x3032, BinaryUtils.getUShort(taskData, 0x003A));
        // 770E:003C 0088 ;LINIE6R
        assertEquals(0x0088, BinaryUtils.getUShort(taskData, 0x003C));
        // 770E:003E 0030 ;BINK0
        assertEquals(0x0030, BinaryUtils.getUShort(taskData, 0x003E));
        // 770E:0040 0038 ;&ID_00002-016-00-C-AS
        assertEquals(0x0038, BinaryUtils.getUShort(taskData, 0x0040));
        // 770E:0042 0072 ;WERR-ANAUS-ERROR497
        assertEquals(0x0072, BinaryUtils.getUShort(taskData, 0x0042));
        // 770E:0044 F206
        assertEquals(0xF206, BinaryUtils.getUShort(taskData, 0x0044));
        // 770E:0046 3030 ;ZWEIN
        assertEquals(0x3030, BinaryUtils.getUShort(taskData, 0x0046));
        // 770E:0048 003A ;&ID_0002-028-00-C-ZW
        assertEquals(0x003A, BinaryUtils.getUShort(taskData, 0x0048));
        // 770E:004A 008C ;LINIE7R
        assertEquals(0x008C, BinaryUtils.getUShort(taskData, 0x004A));
        // 770E:004C 0074 ;WERR-ZWEIN-ERROR400
        assertEquals(0x0074, BinaryUtils.getUShort(taskData, 0x004C));
        // 770E:004E F207
        assertEquals(0xF207, BinaryUtils.getUShort(taskData, 0x004E));
        // 770E:0050 3035 ;ZWAUS
        assertEquals(0x3035, BinaryUtils.getUShort(taskData, 0x0050));
        // 770E:0052 0030 ;BINK0
        assertEquals(0x0030, BinaryUtils.getUShort(taskData, 0x0052));
        // 770E:0054 0050 ;$IN-ZWAUS_DELTA_29919
        assertEquals(0x0050, BinaryUtils.getUShort(taskData, 0x0054));
        // 770E:0056 0044 ;$IN-ZWAUS_MODE_22034
        assertEquals(0x0044, BinaryUtils.getUShort(taskData, 0x0056));
        // 770E:0058 008C ;LINIE7R
        assertEquals(0x008C, BinaryUtils.getUShort(taskData, 0x0058));
        // 770E:005A 003E ;&ZW_4711
        assertEquals(0x003E, BinaryUtils.getUShort(taskData, 0x005A));
        // 770E:005C 0076 ;WERR-ZWAUS-ERROR89
        assertEquals(0x0076, BinaryUtils.getUShort(taskData, 0x005C));
        // 770E:005E F208
        assertEquals(0xF208, BinaryUtils.getUShort(taskData, 0x005E));
        // 770E:0060 3031 ;MELEIN
        assertEquals(0x3031, BinaryUtils.getUShort(taskData, 0x0060));
        // 770E:0062 0032 ;&ID_00002-000-00-C-BM
        assertEquals(0x0032, BinaryUtils.getUShort(taskData, 0x0062));
        // 770E:0064 0001
        assertEquals(0x0001, BinaryUtils.getUShort(taskData, 0x0064));
        // 770E:0066 0066 ;LINE1W
        assertEquals(0x0066, BinaryUtils.getUShort(taskData, 0x0066));
        // 770E:0068 0060 ;LINIE2
        assertEquals(0x0060, BinaryUtils.getUShort(taskData, 0x0068));
        // 770E:006A F209
        assertEquals(0xF209, BinaryUtils.getUShort(taskData, 0x006A));
        // 770E:006C 3034 ;SETMEL
        assertEquals(0x3034, BinaryUtils.getUShort(taskData, 0x006C));
        // 770E:006E 003C ;$WZERO
        assertEquals(0x003C, BinaryUtils.getUShort(taskData, 0x006E));
        // 770E:0070 0002
        assertEquals(0x0002, BinaryUtils.getUShort(taskData, 0x0070));
        // 770E:0072 0068 ;MP1
        assertEquals(0x0068, BinaryUtils.getUShort(taskData, 0x0072));
        // 770E:0074 006A ;MP2
        assertEquals(0x006A, BinaryUtils.getUShort(taskData, 0x0074));
        // 770E:0076 0032 ;&ID_00002-000-00-C-BM
        assertEquals(0x0032, BinaryUtils.getUShort(taskData, 0x0076));
        // 770E:0078 0064 ;ERROR2
        assertEquals(0x0064, BinaryUtils.getUShort(taskData, 0x0078));
        // 770E:007A F20A
        assertEquals(0xF20A, BinaryUtils.getUShort(taskData, 0x007A));
        // 770E:007C 3000 ;ENDE
        assertEquals(0x3000, BinaryUtils.getUShort(taskData, 0x007C));

    }

    public static RtTask findTask(RtModule rtModule, int taskId) {
        RtTask task = null;
        EList<RtTask> tasks = rtModule.getTasks();
        for (RtTask rtTask : tasks) {
            if (rtTask.getId() == taskId) {
                task = rtTask;
                break;
            }
        }
        return task;
    }

    public static int findSymbolAddress(RtModule rtModule, String name) {
        RtSymbol symbol = findSymbol(rtModule, name);
        return symbol != null ? symbol.getAddress() : -1;
    }

    public static RtSymbol findSymbol(RtModule rtModule, String name) {
        EList<RtSymbol> symbols = rtModule.getSymbols();
        RtSymbol symbol = null;
        for (RtSymbol rtSymbol : symbols) {
            if (name.equalsIgnoreCase(rtSymbol.getName())) {
                symbol = rtSymbol;
                break;
            }
        }
        return symbol;
    }

}
