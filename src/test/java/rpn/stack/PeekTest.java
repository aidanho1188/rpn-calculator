package rpn.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnStack;

public class PeekTest {

	@Test
	public void peekIndexOne() {
		RpnStack test = new RpnStack();
		
		test.push("2");
		test.push("3");
		test.push("4");
		String result = test.peek(1);
		assertEquals(result, "3");
	}
	
	@Test
	public void peekExceptionTest() {
		RpnStack calc = new RpnStack();
		try {
			calc.peek(100);
            fail();
        } catch (RuntimeException e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
	}

}
