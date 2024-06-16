package rpn;

import java.math.BigInteger;
import java.util.HashMap;

import rpn.exception.InvalidVariableError;

public class RpnVariableMap {
	static HashMap<String, BigInteger> variablesMap = new HashMap<String, BigInteger>();

	public static void storeVariable(String variable, BigInteger variableValue) {
		if (variablesMap.containsKey(variable)) {
			overrideVariableValue(variable, variableValue);
		} else {
			variablesMap.put(variable, variableValue);
		}
	}

	private static void overrideVariableValue(String variable, BigInteger variableValue) {
		variablesMap.replace(variable, variableValue);
	}

	public static BigInteger getVariableValue(String variable) {
		BigInteger result;
		result = variablesMap.get(variable);
		if (result == null) {
			throw new InvalidVariableError("Variable not found.");
		} else {
			return result;
		}
	}
}
