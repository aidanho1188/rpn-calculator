package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;

public class AdditionTest {

	@Test
	public void simpleAdditionTest() {
		RpnEngine test = new RpnEngine(16);
		test.enter("2");
		test.enter("10");
		test.execute("+");
		String result = test.output();
		assertEquals(result, "12");
	}
	
	@Test
	public void NineBitsAdditionTest() {
		RpnEngine test = new RpnEngine(9);
		test.enter("250");
		test.enter("250");
		test.execute("+");
		String result = test.output();
		assertEquals(result, "500");
	}
	
	@Test (expected = StackOverflowError.class)
	public void AdditionTruncatNumberTest() {
		RpnEngine test = new RpnEngine(8);
		test.enter("250");
		test.enter("250");
		test.execute("+");
		String result = test.output();
		assertEquals(result, "255");
	}
	
	@Test
	public void OverflowAdditionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.enter("250");
			calc.enter("250");
			calc.execute("+");
            fail();
        } catch (StackOverflowError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
	
	
	
}