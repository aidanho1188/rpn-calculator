package rpn.operations.relational;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.relational.GreaterThan;

public class GreaterThanTest {
	@Test
	public void simpleGreaterThanTest() {
		GreaterThan test = new GreaterThan();
		BigInteger x = BigInteger.valueOf(20);
		BigInteger y = BigInteger.valueOf(10);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(1));
	}

	@Test
	public void EngineGreaterThanTest() {
		RpnEngine calc = new RpnEngine(32);

		calc.enter("10");
		calc.enter("20");
		calc.execute(">");
		String result = calc.output();
		assertEquals(result, "1");
	}
}
