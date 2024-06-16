package rpn.operators.basicCalculation;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class Division extends Calculation{

	public BigInteger calculate(BigInteger x, BigInteger y) {
		return y.divide(x);
	}
	
}
