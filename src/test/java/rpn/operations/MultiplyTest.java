package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;

public class MultiplyTest {

	@Test
	public void simpleMultiplicationTest() {
		RpnEngine test = new RpnEngine(32);
		test.enter("5");
		test.enter("90");
		test.execute("*");
		String result = test.output();
		assertEquals(result, "450");

	}
	
	@Test (expected = StackOverflowError.class)
	public void MultiplyTruncatNumberTest() {
		RpnEngine test = new RpnEngine(8);
		test.enter("250");
		test.enter("250");
		test.execute("*");
		String result = test.output();
		assertEquals(result, "255");
	}

	@Test
	public void OverflowMultiplicationTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.enter("250");
			calc.enter("250");
			calc.execute("*");
            fail();
        } catch (StackOverflowError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
}
