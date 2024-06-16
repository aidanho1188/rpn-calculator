package rpn.operators.relational;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class LessThan extends Calculation {

	public BigInteger calculate(BigInteger x, BigInteger y) {
		if (x.compareTo(y) == -1) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(0);
		}
	}

}
