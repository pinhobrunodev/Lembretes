package exception;

public class DbIntegrityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -202459781108966864L;
	
	
	
	public DbIntegrityException(String msg) {
		super(msg);
	}

}
