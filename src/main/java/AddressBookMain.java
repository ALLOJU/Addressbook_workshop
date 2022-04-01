import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressBookMain {
	/**
	 * Created a array list of type ContactDetails and calling the function of
	 * createContact.
	 */
	/**
	 * 1.Creating arraylist object
	 */
	 ArrayList<Person> persons;

	/**
	 * 2.created constructor
	 */
	public AddressBookMain() {
		persons=new ArrayList<Person>();

	}


	/**
	 * This method is used to create contact and store the values into arraylist
	 * 
	 * @return - returns list of contacts
	 */
	public  void createContact() {
		
		/**
		 * for input taken using scanner object
		 */
		Validations v=new Validations();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the First name : ");
		String fname = sc.next();
		v.firstNameofUser(fname);
		System.out.print("Enter the Last name : ");
		String lname = sc.next();
		v.lastNameofUser(lname);
		
		System.out.print("Enter the Address : ");
		String address = sc.next();
		System.out.print("Enter the City : ");
		String city = sc.next();

		System.out.print("Enter the state : ");
		String state = sc.next();
		
		System.out.print("Enter the Zip Code : ");
		int zip = sc.nextInt();

		System.out.print("Enter the phone number: ");
		long phone = sc.nextLong();
		String phone_number=Long.toString(phone);
		v.mobileNumberOfUser(phone_number);
		
		System.out.print("Enter the Email: ");
		String email = sc.next();
		v.emaiIdofUser(email);
		/**
		 * Data is added into the personDetail list
		 */
		persons.add(new Person(fname, lname, address, city, state, zip, phone, email));
		
	}

	/**
	 * Method to edit contact details of person with their name
	 */
	public void editPerson() {
		Scanner sc=new Scanner(System.in);
		Validations v=new Validations();
		Person persons=findContacts();
		System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
				+ "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
				+ "\n 7.Edit phone number"  + "\n 8.Edit email");
		int choice = sc.nextInt();                                 //with the help of setters setting the new details
		switch (choice) {
		case 1:
			System.out.println("Enter new first name");
			String newFirstName = sc.next();
			v.firstNameofUser(newFirstName);
			persons.setFirstname(newFirstName);
			System.out.println("new first name updated");

			break;
		case 2:
			System.out.println("Enter new last name");
			String newLastName = sc.next();
			v.lastNameofUser(newLastName);
			persons.setLastname(newLastName);
			System.out.println("new last name updated");

			break;
		case 3:
			System.out.println("Enter new address");
			String newAddress = sc.next();
			persons.setAddress(newAddress);
			System.out.println("new newaddress updated");

			break;
		case 4:
			System.out.println("Enter new city");
			String newCity = sc.next();
			persons.setCity(newCity);
			System.out.println("new city updated");

			break;
		case 5:
			System.out.println("Enter new state");
			String newState = sc.next();
			persons.setState(newState);
			System.out.println("new state updated");

			break;
		case 6:
			System.out.println("Enter new zip code");
			int newZipCode = sc.nextInt();
			persons.setZip(newZipCode);
			System.out.println("new zip code updated");
			break;
			
		case 7:
			System.out.println("Enter new phone number");
			long newPhoneNumber = sc.nextLong();
			String phone=Long.toString(newPhoneNumber);
			v.mobileNumberOfUser(phone);
			persons.setPhone_number(newPhoneNumber);
			System.out.println("new phone number updated");

			break;
			
		case 8:
			System.out.println("Enter new email");
			String newEmail = sc.next();
			v.emaiIdofUser(newEmail);
			persons.setEmail(newEmail);
			System.out.println("new email updated");

			break;

		default:
			System.out.println("Please enter a number between 1 to 8 only...");
			break;
		}
		System.out.println("The contact after editing is : " + persons);
		
	}
	

	public Person findContacts() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Enter the first name of the contact to edit: ");
		String findname = sc.next();
		int duplicate = 0;                                                   //will increment the duplicate if found multiple contacts with same name
		Person temp = null;
		for (Person person : persons) {
			if (person.getFirstname().equals(findname)) {
				duplicate++;
				temp = person;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if( duplicate > 1) {
			System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
			String email = sc.next();
			for (Person person : persons) {
				if (person.getFirstname().equals(findname) && person.getEmail().equals(email)) {
					return person;
				}
			}
		}
		else{
			System.out.println("No contact with the given first name. Please enter the correct first name");
			findContacts();
		}
		return temp;
	}


	public  void display() {
		for (Person person : persons)

			System.out.println("Person details " + person.getFirstname() +"\t" +person.getLastname()+"\t"+person.getAddress()+"\t" 
					+person.getCity()+"\t"+person.getState()+ "\t"+person.getZip()+"\t"+person.getPhone_number()+"\t"+person.getEmail());

	}
	public static void main(String[] args) {
		AddressBookMain ab=new AddressBookMain();
		int num;

		do {

			System.out.println("Please Enter 1 to add person details in Address Book");
			System.out.println("Please Enter 2 to Edit person details in Address Book");

			System.out.println("Choose option to perform action");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();

			switch (num) {
			case 1:

				ab.createContact();
				ab.display();
	
				break;
				
			case 2:
				ab.editPerson();
				ab.display();
				break;
			}
		} while (num != 0);
	}
}
