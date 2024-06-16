package rpn.operators.basicCalculation;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class Modulus extends Calculation{

	public BigInteger calculate(BigInteger x, BigInteger y) {
		return y.mod(x);
	}
	
}
