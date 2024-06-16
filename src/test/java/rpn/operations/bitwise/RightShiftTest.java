package rpn.operations.bitwise;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.bitwise.RightShift;

public class RightShiftTest {

	@Test
	public void SimpleRightShiftTest() {
		RightShift test = new RightShift();
		BigInteger x = BigInteger.valueOf(1);
		BigInteger y = BigInteger.valueOf(8);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(4));
	}

	@Test
	public void EngineRightShiftTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("8");
		calc.enter("1");
		calc.execute(">>");
		String result = calc.output();
		assertEquals(result, "4");
	}

}
