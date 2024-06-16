package rpn.operators.bitwise;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class XOr extends Calculation {

	public BigInteger calculate(BigInteger x, BigInteger y) {
		return x.xor(y);
	}

}
