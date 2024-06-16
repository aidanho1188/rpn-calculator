package rpn.operations.logical;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.logical.LogicalAnd;

public class LogicalAndTest {
	
	@Test
	public void SimpleLogicalAndTest() {
		LogicalAnd test = new LogicalAnd();
		BigInteger x = BigInteger.valueOf(0);
		BigInteger y = BigInteger.valueOf(100);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(0));
	}

	@Test
	public void EngineLogicalOrTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("100");
		calc.enter("0");
		calc.execute("&&");
		String result = calc.output();
		assertEquals(result, "0");
	}
}
