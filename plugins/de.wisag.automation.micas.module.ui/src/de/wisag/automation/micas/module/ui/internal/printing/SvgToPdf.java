package de.wisag.automation.micas.module.ui.internal.printing;

import java.io.ByteArrayOutputStream;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.fop.svg.PDFTranscoder;
import org.eclipse.core.runtime.CoreException;
import org.w3c.dom.Document;

import de.wisag.automation.micas.module.ui.internal.Policy;

public class SvgToPdf {
    public byte[] transcode(Document document) throws CoreException {
        PDFTranscoder transcoder = new PDFTranscoder();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TranscoderInput input = new TranscoderInput(document);
        TranscoderOutput output = new TranscoderOutput(out);
        // Do the transformation
        try {
            transcoder.transcode(input, output);
        } catch (TranscoderException e) {
            Policy.newLoggedCoreException(e);
        }
        return out.toByteArray();
    }

}
