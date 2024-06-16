package rpn.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.exception.StackUnderFlowError;

public class ReverseTest {

	@Test
	public void simpleReverseTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("1");
		calc.enter("2");	
		calc.execute("r");	// stack is now 2,1
		String result = calc.output();	// peek top element which 1 
		assertEquals(result, "1");
	}
	
	@Test
	public void UnderflowReverseExecpetionTest() {
		String expectedErrorMessage = "Not enough number on the stack.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(32);
			calc.execute("r");
            fail();
        } catch (StackUnderFlowError e) {
        	caught = true;
			actualErrorMessage = e.getMessage();
           
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
}
