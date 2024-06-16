package rpn.operators;

import java.math.BigInteger;
import java.util.Stack;

import rpn.RpnEngine;
import rpn.RpnOperations;
import rpn.RpnStack;

public class SwitchSignMode implements RpnOperations{

	/**
	 * Set new mode and wordsize range, convert all number on stack
	 */
	public void perform(RpnStack number) {
		Stack<String> tempNumberStack = number.getStack();
		String mode = number.getMode();
		String newMode = (mode.equals("Unsigned")) ? "Signed" : "Unsigned";
		int size = findWordSizeRange(RpnEngine.wordsize);
		
		number.setMode(newMode);
		RpnEngine.setSignRange(number);
		
		convertNumberStackSign(tempNumberStack, size, newMode);
	}
	
	private void convertNumberStackSign(Stack<String> numberStack, int sizeRange, String mode) {
		BigInteger result, currentNumber;
		BigInteger y = BigInteger.valueOf(sizeRange/2);
		
		for (int i = 0; i < numberStack.size(); i++) {
			currentNumber = new BigInteger(numberStack.get(i));
			if (mode.equals("Signed")) {
				result = currentNumber.subtract(y);
			} else {
				result = currentNumber.add(y);
			}
			numberStack.set(i, result.toString());
		}
	}
	
	private int findWordSizeRange(int wordsize) {
		return (int) Math.pow(2, wordsize);
	}

}
