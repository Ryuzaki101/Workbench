package de.wisag.automation.micas.rt;

import static de.wisag.automation.micas.h86.DataRecordUtils.createDataRecords;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Content;
import de.wisag.automation.micas.h86.H86Factory;
import de.wisag.automation.micas.h86.RecordType;

public class MicasH86ContentCreator {
    public H86Content createH86Content(RtModule rtModule) {
        Assert.isNotNull(rtModule.getDataSegment(), "rtModule.dataSegment");
        Assert.isNotNull(rtModule.getHeadModuleSegment(), "rtModule.headModuleSegment");
        H86Content content = H86Factory.eINSTANCE.createH86Content();
        content.getRecords().add(createESARecord(rtModule.getStartSegmentAddress()));
        content.getRecords().addAll(createDataRecords(rtModule.getDataSegment(), 0, 0,
                RtPlatformConstants.PROGRAM_SEGMENT_FIRST_BLOCK_SIZE));

        /* write data segment */
        if (rtModule.getStartSegmentAddress() != rtModule.getDataSegmentAddress()) {
            content.getRecords().add(createESARecord(rtModule.getDataSegmentAddress()));
        }
        content.getRecords().addAll(createWordConstantRecords(rtModule));
        content.getRecords().addAll(createFloatConstantRecords(rtModule));
        /* write headmodule segment */
        content.getRecords().add(createESARecord(rtModule.getHeadModuleSegmentAddress()));
        content.getRecords().addAll(
                createDataRecords(rtModule.getHeadModuleSegment(), 0, 0, rtModule.getHeadModuleSegment().length));
        for (RtTask rtTask : rtModule.getTasks()) {
            /* task segment segment */
            content.getRecords().add(createESARecord(rtTask.getSegment()));
            content.getRecords().addAll(createDataRecords(rtTask.getData(), 0, 0, rtTask.getData().length));
        }
        content.getRecords().add(H86Factory.eINSTANCE.createEOFRecord());
        return content;
    }

    protected List<DataRecord> createFloatConstantRecords(RtModule rtModule) {
        EList<RtFloatConstant> floatConstants = rtModule.getFloatConstants();
        for (RtFloatConstant rtFloatConstant : floatConstants) {
            int address2 = rtFloatConstant.getAddress();
            Assert.isTrue(address2 < rtModule.getDataSegment().length);
            double value = rtFloatConstant.getValue();
            Double d = Double.valueOf(value);
            int n = Float.floatToIntBits(d.floatValue());
            // int n = Float.floatToRawIntBits(bd.floatValue());
            // 9B99 993E
            // TODO: this is an evil hack, because original
            for (int i = 0; i < 4; i++) {
                int j = n >> (i * 8) & 0xff;
                if (HardcodedValues.ENABLE_FLOAT_COMPATIBILTY_HACK) {
                    if (i == 0 && (j & 1) == 0 && j > 0) {
                        j |= 1;
                    }
                }
                rtModule.getDataSegment()[address2 + i] = (byte) j;
            }
        }
        return createDataRecords(rtModule.getDataSegment(), rtModule.getFloatConstOffset(),
                rtModule.getFloatConstOffset(), floatConstants.size() * 4);
    }

    protected ExtendedSegmentAddressRecord createESARecord(int startSegmentAddress) {
        ExtendedSegmentAddressRecord startEsa = H86Factory.eINSTANCE.createExtendedSegmentAddressRecord();
        startEsa.setAddress(startSegmentAddress);
        startEsa.setType(RecordType.EXTENDED_SEGMENT_ADDRESS);
        return startEsa;
    }

    protected List<DataRecord> createWordConstantRecords(RtModule rtModule) {
        EList<RtConstant> wordConstants = MicasAddressUtils.getWordConstants(rtModule);
        for (RtConstant rtConstant : wordConstants) {
            int address = rtConstant.getAddress();
            if (rtConstant instanceof RtWordConstant) {
                RtWordConstant constant = (RtWordConstant) rtConstant;
                rtModule.getDataSegment()[address++] = (byte) (constant.getValue());
                rtModule.getDataSegment()[address] = (byte) (constant.getValue() >> 8);
            } else if (rtConstant instanceof RtReferenceConstant) {
                RtReferenceConstant constant = (RtReferenceConstant) rtConstant;

                rtModule.getDataSegment()[address++] = (byte) (constant.getRow() & 0xff);
                rtModule.getDataSegment()[address] = (byte) (constant.getCol() & 0xff);
            }
        }
        return createDataRecords(rtModule.getDataSegment(), rtModule.getWordConstOffset(),
                RtPlatformConstants.PROGRAM_SEGMENT_FIRST_BLOCK_SIZE, wordConstants.size() * 2);
    }

}
