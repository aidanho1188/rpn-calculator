package rpn.operators.basicCalculation;

import java.util.Stack;

import rpn.RpnOperations;
import rpn.RpnStack;

public class Clear implements RpnOperations {

	public void perform(RpnStack numbers) {
		Stack<String> tempNumberStack = numbers.getStack();
		tempNumberStack.clear();
	}
}
