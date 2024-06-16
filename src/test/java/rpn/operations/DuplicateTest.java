package rpn.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.exception.StackUnderFlowError;

public class DuplicateTest {

	@Test
	public void simpleDuplicateTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("1");
		calc.enter("2");	
		calc.execute("d");	// stack is now 1,2,2
		calc.execute("+");	// 1,4
		String result = calc.output();	// peek top element which 4 now
		assertEquals(result, "4");
	}
	
	@Test
	public void UnderflowDuplicateExecpetionTest(){
		String expectedErrorMessage = "Not enough number on the stack.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(32);
			calc.execute("d");
            fail();
        } catch (StackUnderFlowError e) {
        	caught = true;
			actualErrorMessage = e.getMessage();
           
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
}
