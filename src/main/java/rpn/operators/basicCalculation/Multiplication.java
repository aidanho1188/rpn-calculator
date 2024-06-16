package rpn.operators.basicCalculation;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class Multiplication extends Calculation{

	public BigInteger calculate(BigInteger x, BigInteger y) {
		return x.multiply(y);
	}
	
}
