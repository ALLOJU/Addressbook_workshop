import java.util.ArrayList;
import java.util.Scanner;


public class AddressBookMain {
	public static void main(String[] args) {
		/**
		 * Created a array list of type ContactDetails and calling the function of
		 * createContact.
		 */
		ArrayList<Person> personDetail = createContact();

		/*
		 * This for each loop is use to print the data.
		 */
		for (Person str : personDetail) {
			System.out.println(str);
		}
	}
	/**
	 * This method is used to create contact and store the values into arraylist
	 * @return - returns list of contacts
	 */
	public static ArrayList<Person> createContact() {
		ArrayList<Person> PersonDetail = new ArrayList<Person>();
		/**
		 * for input taken using scanner object
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the First name : ");
		String fname = sc.next();
		System.out.print("Enter the Last name : ");
		String lname = sc.next();
		System.out.print("Enter the Address : ");
		String address = sc.next();
		System.out.print("Enter the City : ");
		String city = sc.next();

		System.out.print("Enter the state : ");
		String state = sc.next();

		System.out.print("Enter the Zip Code : ");
		int zip = sc.nextInt();

		System.out.print("Enter the phone number: ");
		String phone = sc.next();
		System.out.print("Enter the Email: ");
		String email = sc.next();

		PersonDetail.add(new Person(fname, lname, address, city, state, zip, phone, email));
		/**
		 * For each loop is use to print the data
		 */
		
		return PersonDetail;
	}
	
	
}
