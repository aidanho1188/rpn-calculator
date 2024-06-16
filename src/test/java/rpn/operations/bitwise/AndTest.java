package rpn.operations.bitwise;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.bitwise.And;

public class AndTest {
	
	@Test
	public void SimpleAndTest() {
		And test = new And();
		BigInteger x = BigInteger.valueOf(5);
		BigInteger y = BigInteger.valueOf(7);
		BigInteger result = test.calculate(x, y);  // this was calculate(5,7)
		assertEquals(result, BigInteger.valueOf(5));
	}

	@Test
	public void EngineAndTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("7");
		calc.enter("5");
		calc.execute("&");
		String result = calc.output();
		assertEquals(result, "5");
	}
}
