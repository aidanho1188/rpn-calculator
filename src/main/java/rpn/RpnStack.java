package rpn;

import java.math.BigInteger;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class RpnStack {
	private Stack<String> numberStack = new Stack<String>();
	private String mode = "Unsigned";
	private int wordSize;

	public void push(String input) {
		BigInteger number = new BigInteger(input);
		BigInteger min = RpnEngine.minValue;
		BigInteger max = RpnEngine.maxValue;
		boolean numberIsUnderMinValue = (number.compareTo(min) == -1);
		boolean numberIsAboveMaxValue = (number.compareTo(max) == 1);
		try {
			if (numberIsUnderMinValue || numberIsAboveMaxValue) {
				String truncatedNumber = numberIsUnderMinValue ? min.toString() : max.toString();
				numberStack.push(truncatedNumber);
				throw new StackOverflowError("Word-size Overflowed.");
			} else if (input.matches("^-?[0-9]*$")) {
				numberStack.push(input);
			} else {
				throw new NumberFormatException("Input is not valid.");
			}
		} catch (Exception e) {
			throw new NumberFormatException("Input is not valid.");
		}
	}

	public String peek(int i) {
		if (!numberStack.isEmpty()) {
			return numberStack.elementAt(i);
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public String pop() {
		if (!numberStack.isEmpty()) {
			return numberStack.pop();
		} else {
			throw new EmptyStackException();
		}
	}

	public void setStack(Stack<String> numberStack) {
		this.numberStack = numberStack;
	}

	public Stack<String> getStack() {
		return numberStack;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return this.mode;
	}

	public int getWordSize() {
		return wordSize;
	}

	public void setWordSize(int wordSize) {
		this.wordSize = wordSize;
	}

}
