package rpn.operators.relational;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class NotEqual extends Calculation {

	public BigInteger calculate(BigInteger x, BigInteger y) {
		if (!x.equals(y)) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(0);
		}
	}

}
