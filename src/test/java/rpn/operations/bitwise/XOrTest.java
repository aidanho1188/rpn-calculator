package rpn.operations.bitwise;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.bitwise.XOr;

public class XOrTest {

	@Test
	public void simpleXOrTest() {
		XOr test = new XOr();
		BigInteger x = BigInteger.valueOf(7);
		BigInteger y = BigInteger.valueOf(5);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(2));
	}

	@Test
	public void EngineXOrTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("7");
		calc.execute("^");
		String result = calc.output();
		assertEquals(result, "2");
	}

}
