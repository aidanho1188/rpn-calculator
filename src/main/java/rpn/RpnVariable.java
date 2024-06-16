package rpn;

import rpn.exception.InvalidVariableError;

public class RpnVariable {

	private static String variable;
	private RpnStack numbers;

	public void performOperator(String operator, RpnOperations targetOperation) {
		if (isVariable(operator)) {
			setVariable(operator);
			targetOperation.perform(numbers);
		} else {
			targetOperation.perform(numbers);
		}
	}

	public void addNewVariable(String operator) {
		if (isVariable(operator)) {
			addVariableOperatorAndPerform(operator);
		} else {
			throw new InvalidVariableError("Operator doesn't exist!");
		}
	}

	private void addVariableOperatorAndPerform(String operator) {
		OperatorFactory.addVariableOperation(operator);
		RpnOperations storeOperation = OperatorFactory.getOperation(operator).get();
		setVariable(operator);
		storeOperation.perform(numbers);
	}

	private boolean isVariable(String executedInput) {
		boolean input = (executedInput.matches("^=[a-zA-Z]+$")) ? true : false;
		return input;
	}

	private void setVariable(String operator) {
		variable = stripVariableInput(operator);
	}

	private String stripVariableInput(String input) {
		if (input.matches("^=[a-zA-Z]+$")) {
			input = input.replace("=", "");
			return input;
		} else {
			throw new InvalidVariableError("Variable is invalid.");
		}
	}

	public static String getVariable() {
		return variable;
	}

	public RpnStack getNumbers() {
		return numbers;
	}

	public void setNumbers(RpnStack numbers) {
		this.numbers = numbers;
	}

}
