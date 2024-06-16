package rpn.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import rpn.RpnEngine;

public class EnterTest {

	/**
	 **	Tests the Bit representation throw/catch with the correct message.
	 **/
	@Test
	public void NegativeWordsizeExecpetionTest() {
		String expectedErrorMessage = "Bit representation must be a positive value.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(-8);
			calc.enter("8");
            fail();
        } catch (StackOverflowError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void OverflowEightBitExecpetionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.enter("256");
            fail();
        } catch (StackOverflowError e) {
        	caught = true;
			actualErrorMessage = e.getMessage();
           
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void OverflowSixteenBitsExecpetionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(16);
			calc.enter("65536");
            fail();
        } catch (StackOverflowError e) {
        	caught = true;
			actualErrorMessage = e.getMessage();
           
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}

	@Test
	public void OverflowThirtyTwoBitsExecpetionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(32);
			calc.enter("4294967296");
            fail();
        } catch (StackOverflowError e) {
        	caught = true;
			actualErrorMessage = e.getMessage();
           
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void OverflowSixtyFourBitsExecpetionTest() {
		String expectedErrorMessage = "Word-size Overflowed.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(64);
			calc.enter("18446744073709551616");
            fail();
        } catch (StackOverflowError e) {
        	caught = true;
			actualErrorMessage = e.getMessage();
           
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}

}
