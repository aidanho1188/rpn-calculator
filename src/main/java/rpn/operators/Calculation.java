package rpn.operators;

import java.math.BigInteger;

import rpn.RpnOperations;
import rpn.RpnStack;

public abstract class Calculation implements RpnOperations{

	public void perform(RpnStack number) {
		BigInteger x = new BigInteger(number.pop());
		BigInteger y = new BigInteger(number.pop());
		number.push(String.valueOf(calculate(x,y)));
	}
	
	public abstract BigInteger calculate(BigInteger x, BigInteger y);
	
}
