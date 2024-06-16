package rpn.operators.logical;

import java.math.BigInteger;

import rpn.operators.OneNumberCalculation;

public class LogicalNot extends OneNumberCalculation{

	public BigInteger calculate(BigInteger x) {
		boolean logicX = false;
		logicX = (x.intValue() == 0) ? logicX==false : logicX==true;
		if (logicX) {
			return BigInteger.valueOf(1);
		} else {
			return BigInteger.valueOf(0);
		}
	}

}
