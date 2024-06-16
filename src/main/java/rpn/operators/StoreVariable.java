package rpn.operators;

import java.math.BigInteger;

import rpn.RpnEngine;
import rpn.RpnOperations;
import rpn.RpnStack;
import rpn.RpnVariable;
import rpn.RpnVariableMap;

public class StoreVariable implements RpnOperations{

	public void perform(RpnStack number) {
		String varValue = number.pop();
		String variable = RpnVariable.getVariable();
		RpnVariableMap.storeVariable(variable, new BigInteger(varValue));
		
	}

}
