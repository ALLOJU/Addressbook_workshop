import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public String regex;
	public boolean firstNameofUser(String firstName) throws AddressBookException{
		/**
		 *  Regex to check valid username.
		 */
		regex="^[A-Z][a-z]{2}";

		/**
		 * To compile Regular Expression
		 */
		Pattern p=Pattern.compile(regex);
		// If the firstName is empty
		// return false
		if (firstName == null) {
			return false;
		}

		/**
		 * Pattern class contains matcher() method  to find matching between given firstName
           and regular expression.
		 */
		Matcher m=p.matcher(firstName);
		System.out.println(m.matches());
		if(m.matches()==true) {
			System.out.println("First Name Valid");
		}
		else {
			throw new AddressBookException("First name should start with Capital letter and has minimum 3 character");

		}
		return m.matches();



	}
	/**
	 * Method to perform validations on user input as last name
	 * @param lastName - input name of the user
	 * @return - returns true or false based on the condition
	 */
	public boolean lastNameofUser(String lastName) throws AddressBookException {
		regex="^[A-Z][a-z]{2}";
		Pattern p=Pattern.compile(regex);
		if (lastName == null) {
			return false;
		}
		/**
		 * Pattern class contains matcher() method  to find matching between given lastname
           and regular expression.
		 */
		Matcher m=p.matcher(lastName);
		System.out.println(m.matches());
		if(m.matches()==true) {
			System.out.println("Last Name  Valid");
		}
		else {
		throw new AddressBookException("Last name should start with Capital letter and has minimum 3 character");

		}
		return m.matches();
	}
	/**
	 * Method to perform validations on user input as Emails
	 * @param email - email ids of the user
	 * @return - returns true or false based on the condition
	 */
	public boolean emaiIdofUser(String email) throws AddressBookException {
		regex="^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern p=Pattern.compile(regex);
		if (email == null) {
			return false;
		}
		/**
		 * Pattern class contains matcher() method  to find matching between given lastname
           and regular expression.
		 */
		Matcher m=p.matcher(email);
		System.out.println(m.matches());
		if(m.matches()) {
			System.out.println("Email Id  Valid");
		}
		else {
			throw new AddressBookException("Email Id Not Valid");

		}
		return m.matches();
	}
	/**
	 * Method used to perform mobile number validations using regular expression
	 * @param phone - input phone number given by the user
	 * @return - it returns true or false based on the given regular expression
	 */
	public boolean mobileNumberOfUser(String phone)  {
		regex="^([0-9]{2}[\\s]){1}[0-9]{9,10}$";
		
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(phone);
		System.out.println(m.matches());
		if(m.matches()) {
			System.out.println("Phone NUmber is Valid");
		}
		else {
			System.out.println("Phone NUmber is Not Valid");

		}
		return m.matches();
	}
	
}
