package rpn.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.RpnStack;

public class PushTest {

	@Test
	public void pushSixNumbers() {
        RpnStack test = new RpnStack();
        String result;
		test.push("1");
		test.push("2");
		test.push("3");
		result = test.pop();
		assertEquals(result, "3");
		
		test.push("4");
		test.push("5");
		test.push("6");
		result = test.pop();
		assertEquals(result, "6");
	}

}
