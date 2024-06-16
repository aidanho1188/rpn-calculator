package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.RpnStack;
import rpn.operators.SwitchSignMode;

public class SwitchSignModeTest {
	
	@Test
	public void SimpleSwitchModeTest() {
		SwitchSignMode test = new SwitchSignMode();
		RpnStack number = new RpnStack();
		test.perform(number); // switch from the default Unsigned to Signed
		assertEquals("Signed", number.getMode());
	}

	@Test
	public void SwitchToSignedModeTest() {
		RpnEngine calc = new RpnEngine(8);
		calc.enter("5");
		calc.enter("2");
		calc.execute("+");
		String unsignedResult = calc.output();
		assertEquals("7", unsignedResult);
		
		calc.execute("#");
		calc.enter("-5");
		calc.enter("-5");
		calc.execute("+");
		String signedResult = calc.output();
		assertEquals("-10", signedResult);
		
	}
	
	@Test
	public void SwitchToUnsignedModeTest() {
		RpnEngine calc = new RpnEngine(8);
		calc.execute("#");
		calc.enter("-5");
		calc.enter("-5");
		calc.execute("+");
		String signedResult = calc.output();
		assertEquals("-10", signedResult);
		
		
		calc.execute("#");
		calc.enter("100");
		calc.enter("100");
		calc.execute("+");
		String unsignedResult = calc.output();
		assertEquals("200", unsignedResult);
	}
	
	@Test
	public void SignedRangeTest() {
		RpnEngine calc = new RpnEngine(8); // -128 to 127
		calc.execute("#");
		calc.enter("-128");
		calc.enter("127");
		calc.execute("+");
		String result = calc.output();
		assertEquals("-1", result);
	}
	
	@Test
	public void UnSignedRangeTest() {
		RpnEngine calc = new RpnEngine(8); // 0 to 255
		calc.enter("128");
		calc.enter("127");
		calc.execute("+");
		String result = calc.output();
		assertEquals("255", result);
	}
	
	@Test
	public void OverflowAfterSwitchToSignedTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.execute("#");
			calc.enter("128");
            fail();
        } catch (StackOverflowError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}

	@Test
	public void ConverToSignedTest() {
		RpnEngine calc = new RpnEngine(8);
		calc.enter("0");
		calc.execute("#");
		String result = calc.output();
		assertEquals("-128", result);
	}
	
	
	@Test
	public void ConvertToUnSignedTest() {
		RpnEngine calc = new RpnEngine(8);
		calc.execute("#");
		calc.enter("-128");
		calc.execute("#");
		String result = calc.output();
		assertEquals("0", result);
	}
}
