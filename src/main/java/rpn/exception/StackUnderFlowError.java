package rpn.exception;

public class StackUnderFlowError extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public StackUnderFlowError(String message){ 
		super(message);	
	}

}
