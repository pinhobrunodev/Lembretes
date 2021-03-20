package exception;

public class DbException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7754045020680440223L;
	
	public DbException(String msg) {
		super(msg);
	}

}
