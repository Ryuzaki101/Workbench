package de.wisag.automation.micas.rt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86RecordMerger;
import de.wisag.automation.micas.h86.H86Unmarshaller;
import de.wisag.automation.micas.h86.IH86Unmarshaller;
import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;

public class Decompiler {
    private HardwareAlias hardwareAlias;
    private int fieldBusNumber;

    public String decompile(InputStream contents) throws IOException {
        RtModule mrt = createRtModel(contents);
        return new MicSourceGenerator(mrt).generate();
    }

    public RtModule createRtModel(InputStream contents) throws IOException {
        IH86Unmarshaller h86Parser = new H86Unmarshaller();
        H86Content data = h86Parser.unmarshall(contents);
        final Map<Integer, byte[]> segments = H86RecordMerger.getSegments(data);

        H86ToRtModuleTransformer rtModuleBuilder = new H86ToRtModuleTransformer(segments, IHwModulesProvider.INSTANCE);
        rtModuleBuilder.setHardwareAlias(hardwareAlias);
        RtModule mrt = rtModuleBuilder.build();
        mrt.setFieldBus(getFieldBusNumber());
        return mrt;
    }

    public int getFieldBusNumber() {
        return this.fieldBusNumber;
    }

    public void setFieldBusNumber(int fieldBusNumber) {
        this.fieldBusNumber = fieldBusNumber;
    }

    public HardwareAlias getHardwareAlias() {
        return hardwareAlias;
    }

    public void setHardwareAlias(HardwareAlias hardwareAlias) {
        this.hardwareAlias = hardwareAlias;
    }

}
