package de.wisag.automation.micas.workbench.licmgr.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.util.Objects;
import java.util.Optional;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

public final class PGPSignatureHelper {

    static final KeyFingerPrintCalculator FP_CALC = new BcKeyFingerprintCalculator();

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public PGPSignatureHelper() {

    }

    public String sign(String data, URL privateKey, char[] passphrase) throws Exception {
        Objects.requireNonNull(data, "'data'");
        Objects.requireNonNull(privateKey, "'pgpKeyRingFile'");
        Objects.requireNonNull(passphrase, "'passphrase'");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStream outputStream = new ArmoredOutputStream(out);
        Optional<PGPSecretKey> pgpSecretKey = readSecretKey(privateKey.openStream());

        PGPPrivateKey pgpPrivateKey = pgpSecretKey.get()
                .extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(passphrase));

        PGPSignatureGenerator signatureGenerator = new PGPSignatureGenerator(
                new JcaPGPContentSignerBuilder(pgpSecretKey.get().getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA1)
                        .setProvider("BC"));
        signatureGenerator.init(PGPSignature.BINARY_DOCUMENT, pgpPrivateKey);
        BCPGOutputStream bOut = new BCPGOutputStream(outputStream);
        signatureGenerator.update(data.getBytes(StandardCharsets.ISO_8859_1));
        signatureGenerator.generate().encode(bOut);
        outputStream.close();
        return new String(out.toByteArray(), StandardCharsets.ISO_8859_1);
    }

    public boolean verify(String data, String signature, URL publicKey) throws IOException, PGPException {
        Objects.requireNonNull(data, "'data'");
        Objects.requireNonNull(publicKey, "'publicKeyFile'");
        Objects.requireNonNull(signature, "'signature'");

        PGPPublicKeyRingCollection pgpPubRingCollection;
        try (InputStream decoderStream = PGPUtil.getDecoderStream(publicKey.openStream())) {
            pgpPubRingCollection = new PGPPublicKeyRingCollection(decoderStream, FP_CALC);
        }
        PGPSignature sig = decodeSignature(signature);
        PGPPublicKey pubKey = pgpPubRingCollection.getPublicKey(sig.getKeyID());
        sig.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), pubKey);
        sig.update(data.getBytes(StandardCharsets.ISO_8859_1));
        return sig.verify();
    }

    private PGPSignature decodeSignature(String signature) throws IOException, PGPException {
        PGPObjectFactory pgpObjFactory = new PGPObjectFactory(
                PGPUtil.getDecoderStream(new ByteArrayInputStream(signature.getBytes(StandardCharsets.ISO_8859_1))),
                FP_CALC);
        PGPSignatureList pgpSigList = null;
        Object obj = pgpObjFactory.nextObject();
        if (obj instanceof PGPCompressedData) {
            PGPCompressedData c1 = (PGPCompressedData) obj;
            pgpObjFactory = new PGPObjectFactory(c1.getDataStream(), FP_CALC);
            pgpSigList = (PGPSignatureList) pgpObjFactory.nextObject();
        } else {
            pgpSigList = (PGPSignatureList) obj;
        }
        PGPSignature sig = pgpSigList.get(0);
        return sig;
    }

    private static Optional<PGPSecretKey> readSecretKey(InputStream input) throws IOException, PGPException {
        PGPSecretKey secKey = null;
        try (InputStream decoderStream = PGPUtil.getDecoderStream(input)) {
            for (PGPSecretKeyRing keyRing : new PGPSecretKeyRingCollection(decoderStream, FP_CALC)) {
                for (PGPSecretKey key : keyRing) {
                    if (key.isSigningKey()) {
                        secKey = key;
                        break;
                    }
                }
            }
        }
        return Optional.ofNullable(secKey);
    }

    public Optional<Long> canUnlock(URL sk, char[] passphrase) {
        Optional<PGPSecretKey> pgpSecretKey;
        try {
            pgpSecretKey = readSecretKey(sk.openStream());
        } catch (Exception e) {
            return Optional.empty();
        }
        if (!pgpSecretKey.isPresent()) {
            return Optional.empty();
        }
        try {
            pgpSecretKey.get()
                    .extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC").build(passphrase));
        } catch (PGPException e) {
            return Optional.empty();
        }
        return Optional.of(Long.valueOf(pgpSecretKey.get().getKeyID()));
    }
}