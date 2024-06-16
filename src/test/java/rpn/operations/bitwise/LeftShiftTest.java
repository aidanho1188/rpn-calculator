package rpn.operations.bitwise;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.bitwise.LeftShift;

public class LeftShiftTest {

	@Test
	public void simpleLeftShiftTest() {
		LeftShift test = new LeftShift();
		BigInteger x = BigInteger.valueOf(3);
		BigInteger y = BigInteger.valueOf(1);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(8));
	}

	@Test
	public void EngineLeftShiftTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("1");
		calc.enter("3");
		calc.execute("<<");
		String result = calc.output();
		assertEquals(result, "8");
	}

	@Test
	public void OverflowLeftShiftExecpetionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(32);
			calc.enter("4294967295");
			calc.enter("1");
			calc.execute("<<");
			fail();
		} catch (StackOverflowError e) {
			caught = true;
			actualErrorMessage = e.getMessage();

		}
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}

}
