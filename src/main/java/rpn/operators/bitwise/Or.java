package rpn.operators.bitwise;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class Or extends Calculation{

	public BigInteger calculate(BigInteger x, BigInteger y) {
		return x.or(y);
	}

}
