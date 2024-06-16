package rpn.operations.bitwise;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.operators.bitwise.Complement;

public class ComplementTest {

	@Test
	public void simpleComplementTest() {
		Complement test = new Complement();
		BigInteger x = BigInteger.valueOf(5);
		BigInteger result = test.calculate(x);
		assertEquals(result, BigInteger.valueOf(-5));
	}
	
	// We're using unsigned number so this will cause stackoverflow 
	@Test (expected = StackOverflowError.class)
	public void OverflowComplementTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.execute("~");
		String result = calc.output();
		assertEquals(result, "-6");
	}

}
