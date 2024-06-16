package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;

public class SizeTest {

	@Test
	public void sixNumbersSizeTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("4");
		calc.enter("3");
		calc.enter("2");
		calc.enter("1");
		calc.enter("0");
		calc.execute("s");
		String result = calc.output();
		assertEquals(result, "6");
	}

}
