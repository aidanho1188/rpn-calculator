package rpn.operations;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import rpn.RpnEngine;

public class ClearTest {

	@Test
	public void simpleClearTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("17");
		calc.enter("3");
		calc.enter("25");
		calc.enter("4");
		calc.execute("c");
		calc.execute("size");
		String result = calc.output();
		assertEquals(result, "0");
	}

}
