package rpn.operations;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.exception.InvalidVariableError;
public class StoreVariableTest {
	
	@Test
	public void simpleStoreVariableTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("25");
		calc.execute("=x");	// register x and set it to 25
		calc.enter("5");
		calc.enter("x");	// push x on the stack
		calc.execute("+");
		String result = calc.output();
		assertEquals(result, "30");
	}
	
	@Test
	public void overrideStoredVariableTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("25");
		calc.execute("=x");
		calc.enter("5");
		calc.execute("=x");
		calc.enter("10");
		calc.enter("x");
		calc.execute("+");
		String result = calc.output();
		assertEquals(result, "15");
	}
	
	@Test
	public void variableAdditionTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("25");
		calc.execute("=x");
		calc.enter("5");
		calc.execute("=y");
		calc.enter("x");
		calc.enter("y");
		calc.execute("+");
		String result = calc.output();
		assertEquals(result, "30");
	}
	
	@Test
	public void variableSubtractionTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("25");
		calc.execute("=x");
		calc.enter("5");
		calc.execute("=y");
		calc.enter("x");
		calc.enter("y");
		calc.execute("-");	// x-y
		String result = calc.output();
		assertEquals(result, "20");
	}
	
	@Test
	public void wrongStoreVariableTest() {
		String expectedErrorMessage = "Variable not found.";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.enter("25");
			calc.execute("=x");
			calc.enter("5");
			calc.enter("z");
            fail();
        } catch (InvalidVariableError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void invalidVariableTest() {
		String expectedErrorMessage = "Operator doesn't exist!";
		String actualErrorMessage = "";
		boolean caught = false;
		try {
			RpnEngine calc = new RpnEngine(8);
			calc.enter("25");
			calc.execute("==y");
            fail();
        } catch (InvalidVariableError e) {
            caught = true;
			actualErrorMessage = e.getMessage();
        }
		assertTrue("Caught the exception for positive edge case", caught);
		assertEquals("Correct error message.", expectedErrorMessage, actualErrorMessage);
	}
	
	

}
