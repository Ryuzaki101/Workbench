package de.wisag.automation.micas.rt;

import org.eclipse.core.runtime.Assert;
import org.junit.Test;

public class FloatConstTest {

	class FloatPair {
		public FloatPair(float micFloat, float newFloat) {
			super();
			this.micFloat = micFloat;
			this.newFloat = newFloat;
		}
		float micFloat;
		float newFloat;
		@Override
		public String toString() {
			return "FloatPair [micFloat=" + micFloat + ", newFloat=" + newFloat
					+ "]";
		}

	}
	@Test
	public void testFloat() throws Exception {
		//String micFloat = "9A99993E";
		//String newFloat = "9B99993E";
		//FloatPair x = parse(micFloat,newFloat);
		//System.out.println(x);
	}

	@Test
	public void testFloatCut() throws Exception {

		FloatPair x = null;
		// FloatK K_0_3Grd (0.30)
		System.out.println(x);
		x = parse("6766C640","6666C640");
		// FloatK K_0_3Grd (0.30)
		System.out.println(x);
		x = parse("9B99D93F","9A99D93F");
		// FloatK K_0_3Grd (0.30)
		System.out.println(x);

		x = parse("6766663F","6666663F");
		// FloatK K_0_3Grd (0.30)
		System.out.println(x);

		x = parse("49E17A3F","48E17A3F");
		// FloatK K_0_3Grd (0.30)
		System.out.println(x);
		x = parse("5D8F823F","5C8F823F");
		// FloatK K_0_3Grd (0.30)
		System.out.println(x);

	}

	@Test
	public void testFloatConversion() throws Exception {
		Double d = Double.valueOf("0.30");
		org.junit.Assert.assertNotNull(d);

	}


	private FloatPair parse(String micFloat, String newFloat) {
		return new FloatPair(floatFromHexString(micFloat),floatFromHexString(newFloat));
	}
	private float floatFromHexString(String hex) {
		int value = asInt32(hex);
		float floatv = Float.intBitsToFloat(value);
		return floatv;
	}

	private int asInt32(String hex) {
		Assert.isLegal(hex.length()==8);
		byte b0 = (byte) (Integer.parseInt(hex.substring(0, 2),16) & 0xff);
		byte b1 = (byte) (Integer.parseInt(hex.substring(2, 4),16) & 0xff);
		byte b2 = (byte) (Integer.parseInt(hex.substring(4, 6),16) & 0xff);
		byte b3 = (byte) (Integer.parseInt(hex.substring(6, 8),16) & 0xff);
		byte[] b = new byte[]{
				b0,
				b1,
				b2,
				b3
		};
		return BinaryUtils.getInt(b, 0);
	};

}
