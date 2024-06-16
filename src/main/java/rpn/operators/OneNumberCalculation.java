package rpn.operators;

import java.math.BigInteger;

import rpn.RpnOperations;
import rpn.RpnStack;

public abstract class OneNumberCalculation implements RpnOperations{

	public void perform(RpnStack number) {
		BigInteger x = new BigInteger(number.pop());
		number.push(String.valueOf(calculate(x)));
	}
	
	public abstract BigInteger calculate(BigInteger x);
	
}
