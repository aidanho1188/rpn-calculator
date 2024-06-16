package rpn.stack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

import rpn.RpnStack;

public class PopTest {

	@Test
	public void popTopElement() {
		RpnStack test = new RpnStack();
		
		test.push("1");
		test.push("2");
		test.push("3");
		test.push("4");
		test.push("5");
		test.push("6");
		String result = test.pop();
		assertEquals(result, "6");
		result = test.pop();
		assertEquals(result, "5");
	}
	
	@Test
	public void popExceptionTest() {
		RpnStack calc = new RpnStack();
		try {
			calc.pop();
            fail();
        } catch (RuntimeException e) {
            assertEquals(EmptyStackException.class, e.getClass());
        }
	}

}
