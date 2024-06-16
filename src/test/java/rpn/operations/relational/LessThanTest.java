package rpn.operations.relational;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.relational.LessThan;

public class LessThanTest {
	@Test
	public void simpleLessThanTest() {
		LessThan test = new LessThan();
		BigInteger x = BigInteger.valueOf(20);
		BigInteger y = BigInteger.valueOf(10);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(0));
	}

	@Test
	public void EngineLessThanTest() {
		RpnEngine calc = new RpnEngine(32);

		calc.enter("10");
		calc.enter("20");
		calc.execute("<");
		String result = calc.output();
		assertEquals(result, "0");
	}
}
