package rpn.operations.relational;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.relational.NotEqual;

public class NotEqualTest {

	@Test
	public void simpleNotEqualTest() {
		NotEqual test = new NotEqual();
		BigInteger x = BigInteger.valueOf(20);
		BigInteger y = BigInteger.valueOf(10);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(1));
	}

	@Test
	public void EngineNotEqualTest() {
		RpnEngine calc = new RpnEngine(32);

		calc.enter("10");
		calc.enter("20");
		calc.execute("!=");
		String result = calc.output();
		assertEquals(result, "1");
	}
}
