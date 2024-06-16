package rpn.operators.relational;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class LessThanOrEqual extends Calculation {

	public BigInteger calculate(BigInteger x, BigInteger y) {
		if (x.compareTo(y) == -1 || x.compareTo(y) == 0) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(0);
		}
	}

}
