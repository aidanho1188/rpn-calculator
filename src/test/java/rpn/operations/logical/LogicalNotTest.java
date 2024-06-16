package rpn.operations.logical;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.logical.LogicalNot;

public class LogicalNotTest {
	
	@Test
	public void SimpleLogicalAndTest() {
		LogicalNot test = new LogicalNot();
		BigInteger x = BigInteger.valueOf(0);
		BigInteger result = test.calculate(x);
		assertEquals(result, BigInteger.valueOf(1));
	}

	@Test
	public void EngineLogicalOrTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("0");
		calc.execute("!");
		String result = calc.output();
		assertEquals(result, "1");
	}
}
