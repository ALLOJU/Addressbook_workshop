import java.util.ArrayList;
import java.util.Scanner;


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
		System.out.println("Enter name of the person to Edit");
		String editpersonname=sc.next();
		for(int i=0;i<persons.size();i++) {
			Person p=(Person)persons.get(i);
			System.out.println("person details are");
			if(editpersonname.equalsIgnoreCase(p.getFirstname()))
			{


				System.out.println("Enter Last Name");
				String last_name=sc.next();

				System.out.println("Enter Address");
				String address=sc.next();

				System.out.println("Enter City");
				String city=sc.next();

				System.out.println("Enter State");
				String state=sc.next();

				System.out.println("Enter Zip code");
				int zip=sc.nextInt();

				System.out.println("Enter Phone Number");
				String phone_number=sc.next();

				System.out.println("Enter email");
				String email=sc.next();


				p.setLastname(last_name);
				p.setAddress(address);
				p.setCity(city);
				p.setState(state);
				p.setZip(zip);
				p.setPhone_number(phone_number);
				p.setEmail(email);
			}
		}
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
