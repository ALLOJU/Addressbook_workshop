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
}
