package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;

public class DivisionTest {

	@Test
	public void simpleDivisionTest() {
		RpnEngine test = new RpnEngine(32);

		test.enter("10");
		test.enter("5");
		test.execute("/");
		String result = test.output();
		assertEquals(result, "2");
	}

	@Test(expected = ArithmeticException.class)
	public void divideByZero() {
		RpnEngine test = new RpnEngine(32);

		test.enter("10");
		test.enter("0");
		test.execute("/");
		String result = test.output();
		assertEquals(result, "2");
	}

}
