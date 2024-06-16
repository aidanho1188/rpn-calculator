package rpn.operators.bitwise;

import java.math.BigInteger;


import rpn.operators.OneNumberCalculation;

public class Complement extends OneNumberCalculation{

	public BigInteger calculate(BigInteger x) {
		return complement(x);
	}
	
	public BigInteger complement(BigInteger original) {
		byte[] contents = original.toByteArray();

	    // prepend byte of opposite sign
	    byte[] result = new byte[contents.length + 1];
	    System.arraycopy(contents, 0, result, 1, contents.length);
	    int sign = (contents[0] < 0) ? 0 : (byte)-1;

	    // this will be two's complement
	    return new BigInteger(sign,result);
	}
}
