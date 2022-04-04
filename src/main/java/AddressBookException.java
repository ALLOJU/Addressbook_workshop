/**
 * Creating custom exception
 * @author nani
 *
 */
public class AddressBookException extends Exception {
	private static final long serialVersionUID = 1L;
	public String message;
	public AddressBookException(String message) {
		super(message);
	}
	 enum ExceptionType {
	        DATABASE_EXCEPTION, NO_SUCH_CLASS
	    }

	    public ExceptionType type;

	    public AddressBookException(String message, ExceptionType type) {
	        super(message);
	        this.type = type;
	    }
}
