package rpn.operators.bitwise;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class RightShift extends Calculation {

	public BigInteger calculate(BigInteger x, BigInteger y) {
		return y.shiftRight(x.intValue());
	}

}
