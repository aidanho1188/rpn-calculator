package rpn;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import rpn.operators.basicCalculation.Addition;
import rpn.operators.basicCalculation.Clear;
import rpn.operators.Duplicate;
import rpn.operators.Reverse;
import rpn.operators.StoreVariable;
import rpn.operators.SwitchSignMode;
import rpn.operators.basicCalculation.Division;
import rpn.operators.basicCalculation.Modulus;
import rpn.operators.basicCalculation.Multiplication;
import rpn.operators.basicCalculation.Size;
import rpn.operators.basicCalculation.Subtraction;
import rpn.operators.bitwise.And;
import rpn.operators.bitwise.Complement;
import rpn.operators.bitwise.LeftShift;
import rpn.operators.bitwise.Or;
import rpn.operators.bitwise.RightShift;
import rpn.operators.bitwise.XOr;
import rpn.operators.logical.LogicalAnd;
import rpn.operators.logical.LogicalNot;
import rpn.operators.logical.LogicalOr;
import rpn.operators.relational.Equal;
import rpn.operators.relational.GreaterThan;
import rpn.operators.relational.GreaterThanOrEqual;
import rpn.operators.relational.LessThan;
import rpn.operators.relational.LessThanOrEqual;
import rpn.operators.relational.NotEqual;

public class OperatorFactory {
	static Map<String, RpnOperations> operationMap = new HashMap<String, RpnOperations>();
	static {
		operationMap.put("+", new Addition());
		operationMap.put("-", new Subtraction());
		operationMap.put("/", new Division());
		operationMap.put("*", new Multiplication());
		operationMap.put("%", new Modulus());
		operationMap.put("clear", new Clear());
		operationMap.put("c", new Clear());
		operationMap.put("size", new Size());
		operationMap.put("s", new Size());
		operationMap.put("&", new And());
		operationMap.put(">>", new RightShift());
		operationMap.put("<<", new LeftShift());
		operationMap.put("|", new Or());
		operationMap.put("^", new XOr());
		operationMap.put("==", new Equal());
		operationMap.put("!=", new NotEqual());
		operationMap.put("<", new LessThan());
		operationMap.put(">", new GreaterThan());
		operationMap.put("<=", new LessThanOrEqual());
		operationMap.put(">=", new GreaterThanOrEqual());
		operationMap.put("&&", new LogicalAnd());
		operationMap.put("||", new LogicalOr());
		operationMap.put("d", new Duplicate());
		operationMap.put("duplicate", new Duplicate());
		operationMap.put("r", new Reverse());
		operationMap.put("reverse", new Reverse());
		operationMap.put("~", new Complement());
		operationMap.put("!", new LogicalNot());
		operationMap.put("#", new SwitchSignMode());
	}

	public static Optional<RpnOperations> getOperation(String operator) {
		return Optional.ofNullable(operationMap.get(operator));
	}
	
	public static void addVariableOperation(String operator) {
		operationMap.put(operator, new StoreVariable());
	}
}
