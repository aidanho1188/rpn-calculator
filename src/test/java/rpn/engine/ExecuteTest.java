package rpn.engine;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import rpn.RpnEngine;
import rpn.exception.InvalidVariableError;

public class ExecuteTest {

	@Test
	public void addExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("2");
		calc.execute("+");
		String result = calc.output();
		assertEquals(result, "7");
	}
	
	@Test
	public void subtractExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("2");
		calc.execute("-");
		String result = calc.output();
		assertEquals(result, "3");
	}

	@Test
	public void multiplyExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("2");
		calc.execute("*");
		String result = calc.output();
		assertEquals(result, "10");
	}
	
	@Test
	public void divideExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("2");
		calc.execute("/");
		String result = calc.output();
		assertEquals(result, "2");
	}
	
	@Test
	public void modExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		calc.enter("5");
		calc.enter("2");
		calc.execute("%");
		String result = calc.output();
		assertEquals(result, "1");
	}
	
	@Test
	public void clearExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		String result;
		calc.enter("5");
		calc.enter("2");
		calc.execute("c");
		calc.execute("s");
		result = calc.output();
		assertEquals(result, "0");
	}
	
	@Test
	public void flagExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		String result;
		calc.enter("5");
		calc.enter("2");
		result = calc.flags();
		assertEquals(result, "o");
	}
	
	@Test
	public void sizeExecuteTest() {
		RpnEngine calc = new RpnEngine(32);
		String result;
		calc.enter("5");
		calc.enter("2");
		calc.execute("s");
		result = calc.output();
		assertEquals(result, "2");
		
		calc.execute("size");
		result = calc.output();
		assertEquals(result, "3");
	}
	
	@Test
	public void emptyArgumentTest() {
		RpnEngine calc = new RpnEngine(32);
		try {
			calc.execute("");
            fail();
        } catch (RuntimeException e) {
            assertEquals(InvalidVariableError.class, e.getClass());
        }
	}
	
	@Test
	public void invalidOperatorTest() {
		RpnEngine calc = new RpnEngine(32);
		try {
			calc.execute("w");
            fail();
        } catch (RuntimeException e) {
            assertEquals(InvalidVariableError.class, e.getClass());
        }
	}
	
}
