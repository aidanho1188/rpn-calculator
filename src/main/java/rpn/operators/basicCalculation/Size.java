package rpn.operators.basicCalculation;

import java.util.Stack;

import rpn.RpnOperations;
import rpn.RpnStack;

public class Size implements RpnOperations {

	public void perform(RpnStack numbers) {
		Stack<String> tempNumberStack = numbers.getStack();
		numbers.push(String.valueOf(tempNumberStack.size()));
	}
}
