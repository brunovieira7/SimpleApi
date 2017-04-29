package simpleapi.exception;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = 4401127057983103889L;
	
	public NotFoundException(String message) {
		super(message);
	}
}
