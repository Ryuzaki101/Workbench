package de.wisag.automation.micas.rt;

import static org.junit.Assert.*;

import org.junit.Test;

public class MicasAddressUtilsTest {

	@Test
	public void testGetWordConstants() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTaskStrategy() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlignOffset() {
		int j = 0x80;
		for (int i=j;i<0xff;i++) {
			int k = MicasAddressUtils.alignOffset(i);
			System.out.println(String.format("Value %d %04x", i,k));
		}
	}

}
