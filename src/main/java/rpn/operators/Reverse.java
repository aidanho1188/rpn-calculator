package rpn.operators;

import java.math.BigInteger;

import rpn.RpnOperations;
import rpn.RpnStack;

public class Reverse implements RpnOperations{
	
	public void perform(RpnStack number) {
		BigInteger x = new BigInteger(number.pop());
		BigInteger y = new BigInteger(number.pop());
		number.push(String.valueOf(x));
		number.push(String.valueOf(y));
	}

}
