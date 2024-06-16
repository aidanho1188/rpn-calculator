package rpn.operations.bitwise;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.bitwise.Or;

public class OrTest {

	@Test
	public void simpleOrTest() {
		Or test = new Or();
		BigInteger x = BigInteger.valueOf(5);
		BigInteger y = BigInteger.valueOf(7);
		BigInteger result = test.calculate(x, y);
		assertEquals(result, BigInteger.valueOf(7));
	}

	@Test
	public void EngineOrTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("7");
		calc.execute("|");
		String result = calc.output();
		assertEquals(result, "7");
	}

}
