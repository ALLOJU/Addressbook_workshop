import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class AddressBook {
	/**
	 * PROCEDURE:
	 * 1.Creating arraylist object
	 * 2.created constructor
	 * 3.createContact- This method is used to create contact and store the values into arraylist
	 * 4.editPerson - Method to edit contact details of person with their name
	 * 5.findContacts - find contacts with the given name
	 * 
	 */
	/**
	 * Created a array list of type ContactDetails and calling the function of
	 * createContact.
	 */
	/**
	 * 1.Creating arraylist object
	 */
	Map<String, Person> persons;
	public static HashMap<String, ArrayList<Person>> personByCity  = new HashMap<String, ArrayList<Person>>();
	public static HashMap<String, ArrayList<Person>> personByState = new HashMap<String, ArrayList<Person>>();

	/**
	 * 2.created constructor
	 */
	public AddressBook() {
		persons=new HashMap<String,Person>();

	}

	public void addContact() throws AddressBookException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of contacts you want to enter");
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the contact details of person ");
			createContact();
		}
	}
	/*
	 * public void checkDuplicates() throws AddressBookException { Scanner sc=new
	 * Scanner(System.in); System.out.println(" Please enter the first name:");
	 * String name = sc.next(); for(Person i : persons) {
	 * if(i.getFirstname().equals(name)) {
	 * System.out.println(" Given name already exists"); } return; }
	 * createContact();
	 * 
	 * 
	 * }
	 */

	/**
	 * 3.This method is used to create contact and store the values into arraylist
	 * 
	 * @return - returns list of contacts
	 * @throws AddressBookException 
	 */
	public  void createContact() throws AddressBookException {

		/**
		 * for input taken using scanner object
		 */
		Validations v=new Validations();
		Person person = new Person();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the First name : ");
		String fname = sc.next();
		v.firstNameofUser(fname);
		if(persons.containsKey(fname)) {
			System.out.println("Contact Already Exists");
			return;
		} 
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
		
		person.setFirstname(fname);
		person.setLastname(lname);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setZip(zip);
		person.setPhone_number(phone);
		person.setEmail(email);
		addPersonToCity(person);
		addPersonToState(person);
		persons.put(fname, person);
	}

	/**
	 *4. Method to edit contact details of person with their name
	 * @throws AddressBookException 
	 */
	public void editPerson() throws AddressBookException {
		Scanner sc=new Scanner(System.in);
		Validations v=new Validations();
		Person person = new Person();

		System.out.println("Enter the first name:");
		String firstName = sc.next();
		
		if(persons.containsKey(firstName)) {
			person = persons.get(firstName);
		System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
				+ "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
				+ "\n 7.Edit phone number"  + "\n 8.Edit email");
		int choice = sc.nextInt();                                 //with the help of setters setting the new details
		switch (choice) {
		case 1:
			System.out.println("Enter new first name");
			String newFirstName = sc.next();
			v.firstNameofUser(newFirstName);
			person.setFirstname(newFirstName);
			System.out.println("new first name updated");

			break;
		case 2:
			System.out.println("Enter new last name");
			String newLastName = sc.next();
			v.lastNameofUser(newLastName);
			person.setLastname(newLastName);
			System.out.println("new last name updated");

			break;
		case 3:
			System.out.println("Enter new address");
			String newAddress = sc.next();
			person.setAddress(newAddress);
			System.out.println("new newaddress updated");

			break;
		case 4:
			System.out.println("Enter new city");
			String newCity = sc.next();
			person.setCity(newCity);
			System.out.println("new city updated");

			break;
		case 5:
			System.out.println("Enter new state");
			String newState = sc.next();
			person.setState(newState);
			System.out.println("new state updated");

			break;
		case 6:
			System.out.println("Enter new zip code");
			int newZipCode = sc.nextInt();
			person.setZip(newZipCode);
			System.out.println("new zip code updated");
			break;

		case 7:
			System.out.println("Enter new phone number");
			long newPhoneNumber = sc.nextLong();
			String phone=Long.toString(newPhoneNumber);
			v.mobileNumberOfUser(phone);
			person.setPhone_number(newPhoneNumber);
			System.out.println("new phone number updated");

			break;

		case 8:
			System.out.println("Enter new email");
			String newEmail = sc.next();
			v.emaiIdofUser(newEmail);
			person.setEmail(newEmail);
			System.out.println("new email updated");

			break;

		default:
			System.out.println("Please enter a number between 1 to 8 only...");
			break;
		}
		System.out.println("The contact after editing is : " + person);

	}
	}


	
	/**
	 * Method to delete contacts with the given name
	 */
	public void deleteContact() { 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first name of the person to be deleted");
		String firstName = sc.next();
		if(persons.containsKey(firstName)) {
			persons.remove(firstName);
			System.out.println("Successfully Deleted");
		}
		else {
			System.out.println("Contact Not Found!");
		}
		
	}
	/**
	 *  In this method we are checking the persob by city
	 * @param contact- We are pasing the contact there
	 */
	public void addPersonToCity(Person person) {
		if (personByCity.containsKey(person.getCity())) {
			personByCity.get(person.getCity()).add(person);
		}
		else {
			ArrayList<Person> cityList = new ArrayList<Person>();
			cityList.add(person);
			personByCity.put(person.getCity(), cityList);
		}
	}


	/**
	 *  In this method we are checking the person by state
	 * @param contact- We are parsing the contact there
	 */
	public void addPersonToState(Person person) {
		if (personByState.containsKey(person.getState())) {			
			personByState.get(person.getState()).add(person);
		}
		else {
			ArrayList<Person> stateList = new ArrayList<Person>();
			stateList.add(person);
			personByState.put(person.getState(), stateList);
		}
	}
	/* * Method display to list the contacts.
	 * This method will display the contacts of the list
	 */
	public void displayContact() {                                                       
			System.out.println(persons);
			System.out.println("Value is " + persons.values());
	}
	public static void main(String[] args) throws AddressBookException {
		AddressBook ab=new AddressBook();
		MultipleAddressBook ma=new MultipleAddressBook();
		while (true) {
			System.out.println("Enter \n 1. To add the new AddressBook\n 2. To add contact in AddressBook\n "
					+ "3. To edit the contact in AddressBook\n 4. To delete the contact in AddressBook\n 5. To delete the AddressBook\n "
					+ "6. To Print the AddressBook\n 7. To Print the contacts in AddressBook\n 8. Search Person By City. \n 9. Search Person by State \n 10. View Person by City \n 11. View Person by State  "
					+ "\n 12. Count People \n  0. To exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				ma.addAddressBook();
				break;
			case 2:
				ma.addContact();
				break;
			case 3:
				ma.editContactInBook();
				break;
			case 4:
				ma.deleteContactInBook();
				break;
			case 5:
				ma.deleteAddressBook();
				break;
			case 6:
				ma.printBook();
				break;
			case 7:
				ma.printContactsInBook();
			case 8:
				ma.searchByCity();
				break;
			case 9:
				ma.searchByState();
			case 10:
				ma.displayPeopleByRegion(AddressBook.personByCity);
				break;
			case 11:
				ma.displayPeopleByRegion(AddressBook.personByState);
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Enter the wrong input");
			}
		}
	}
}
