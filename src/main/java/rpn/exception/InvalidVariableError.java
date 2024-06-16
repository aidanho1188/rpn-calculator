package rpn.exception;

public class InvalidVariableError extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidVariableError(String message){ 
		super(message);	
	}

}
