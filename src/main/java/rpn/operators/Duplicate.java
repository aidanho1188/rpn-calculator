package rpn.operators;

import java.math.BigInteger;

import rpn.RpnOperations;
import rpn.RpnStack;

public class Duplicate implements RpnOperations{

	public void perform(RpnStack number) {
		BigInteger x = new BigInteger(number.pop());
		number.push(String.valueOf(x));
		number.push(String.valueOf(x));
	}

}
