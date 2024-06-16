package rpn;

import java.math.BigInteger;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import rpn.exception.InvalidVariableError;
import rpn.exception.StackUnderFlowError;

public class RpnEngine {
	private RpnStack numbers = new RpnStack();
	private RpnVariable rpn = new RpnVariable();
	private static BigInteger TWO = new BigInteger("2");
	public static BigInteger minValue;
	public static BigInteger maxValue;
	public static int wordsize;

	public RpnEngine(int incomingBit) {
		wordsize = incomingBit;
		numbers.setWordSize(incomingBit);
		setWordSizeRange(incomingBit);
		rpn.setNumbers(numbers);
	}

	public void enter(String input) {
		if (input.matches("^-?[0-9]*$")) {
			numbers.push(input);
		} else {
			String variableValue = RpnVariableMap.getVariableValue(input).toString();
			numbers.push(variableValue);
		}
	}

	public void setWordSizeRange(int wordSize) {
		if (isInRange(wordSize)) {
			setSignRange(numbers);
		} else if (wordSize <= 0) {
			throw new StackOverflowError("Bit representation must be a positive value.");
		} else {
			throw new StackOverflowError("Invalid word-size.");
		}
	}

	private boolean isInRange(int wordSize) {
		return (wordSize >= 8 && wordSize <= 64);
	}

	public static void setSignRange(RpnStack numberStack) {
		String mode = numberStack.getMode();
		minValue = findMinSignRange(mode);
		maxValue = findMaxSignRange(mode);
	}

	private static BigInteger findMinSignRange(String sign) {
		BigInteger result;
		if (sign.equals("Unsigned")) {
			return new BigInteger("0");
		} else {
			result = TWO.pow(wordsize).subtract(new BigInteger("1"));
			return result.negate();
		}
	}

	private static BigInteger findMaxSignRange(String sign) {
		if (sign.equals("Unsigned")) {
			return TWO.pow(wordsize).subtract(new BigInteger("1"));
		} else {
			return TWO.pow(wordsize - 1).subtract(new BigInteger("1"));
		}
	}

	public String output() throws EmptyStackException {
		execute("s");
		int size = Integer.parseInt(numbers.pop());
		return numbers.peek(size - 1);
	}

	public void execute(String operator) throws StackUnderFlowError {
		try {
			RpnOperations targetOperation = OperatorFactory.getOperation(operator).get();
			rpn.performOperator(operator, targetOperation);
		} catch (EmptyStackException e) {
			throw new StackUnderFlowError("Not enough number on the stack.");
		} catch (NoSuchElementException noVariable) {
			rpn.addNewVariable(operator);
		}
	}

	public String flags() {
		try {
			Integer.parseUnsignedInt(numbers.pop());
			return "o";
		} catch (Exception overflow) {
			return "O";
		}
	}
}
