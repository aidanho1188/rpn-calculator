package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;

public class ModuloTest {

	@Test
	public void simpleModulusTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("17");
		calc.enter("3");
		calc.execute("%");
		String result = calc.output();
		assertEquals(result, "2");
	}
}
