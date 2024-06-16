package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;


import rpn.RpnEngine;

public class FlagsTest {

	@Test (expected = StackOverflowError.class)
	public void OverflowTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("10");
		calc.enter("20");
		calc.execute("-");
		String result = calc.flags();
		assertEquals(result, "O");
	}

	@Test
	public void NoOverflowTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("2");
		calc.enter("2");
		calc.execute("+");
		String result = calc.flags();
		assertEquals(result, "o");
	}

}
