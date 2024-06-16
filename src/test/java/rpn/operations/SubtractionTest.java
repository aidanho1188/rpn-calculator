package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;

public class SubtractionTest {

	@Test
	public void simpleSubtractTest() {
		RpnEngine test = new RpnEngine(32);

		test.enter("25");
		test.enter("24");
		test.execute("-");
		String result = test.output();
		assertEquals(result, "1");
	}

	@Test (expected = StackOverflowError.class)
	public void AdditionTruncatNumberTest() {
		RpnEngine test = new RpnEngine(8);
		test.enter("10");
		test.enter("250");
		test.execute("-");
		String result = test.output();
		assertEquals(result, "0");
	}
	
	@Test
	public void OverflowSubtractionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.enter("10");
			calc.enter("250");
			calc.execute("-");
            fail();
        } catch (StackOverflowError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
}
