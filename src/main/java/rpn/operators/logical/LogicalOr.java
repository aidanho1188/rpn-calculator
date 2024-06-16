package rpn.operators.logical;

import java.math.BigInteger;

import rpn.operators.Calculation;

public class LogicalOr extends Calculation {

	public BigInteger calculate(BigInteger x, BigInteger y) {
		boolean logicX = false;
		boolean logicY = false;
		logicX = (x.intValue() == 0) ? logicX==false : logicX==true;
		logicY = (y.intValue() == 0) ? logicY==false : logicY==true;
		if (logicX || logicY) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(0);
		}
	}

}
