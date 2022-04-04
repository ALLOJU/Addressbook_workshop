import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import junit.framework.Assert;

public class AddressBookTest {
	Validations u=new Validations();
	
	/**
	 * 2.Test method to check first name is valid
	 * @throws UserRegistrationException 
	 */
	@Test
	public void checkValidFirstName() throws AddressBookException
	{
		boolean result=u.firstNameofUser("Mou");
		assertTrue(result);
	}
	
	/**
	 * 3.Test method to check last name is valid
	 * @throws UserRegistrationException 
	 */
	@Test
	public void checkValidLastName() throws AddressBookException
	{
		boolean result=u.lastNameofUser("Jav");
		assertTrue(result);
	}
	
	/**
	 * 4.Test method to check  email id is valid
	 * @throws UserRegistrationException 
	 */
	@Test
	public void checkValidEmail() throws AddressBookException
	{
		boolean result=u.emaiIdofUser("abc@yahoo.com");
		assertTrue(result);
	}
	
	/**
	 * 5.Test method to check  mobile number is valid
	 * @throws UserRegistrationException 
	 */
	@Test
	public void checkValidPhone() throws AddressBookException
	{
		boolean result=u.mobileNumberOfUser("91 9866349586");
		assertTrue(result);
	}
	
	/**
	 * 6.Test method to check  mobile number is valid
	 * @throws UserRegistrationException 
	 */
	@Test
	public void given_Contacts_Should_Write_To_A_File() {
		Person[] contacts = {
				new Person("Mou","All","warangal","warangal","Telangna",50602,9854646,"mounika.alloju@gmail.com"),
						
						
				new Person("Ram","Sri","warangal","warangal","Telangna",50602,96457326,"ramesh.sripadi@gmail.com"),};
		ArrayList<Person> arraylist = new ArrayList<>();
		arraylist.add(contacts[0]);
		arraylist.add(contacts[1]);
		AddressBookIOServices addressBook = new AddressBookIOServices();
		addressBook.writeData(arraylist);
		long entries = addressBook.countEntries();
		Assert.assertEquals(2, entries);

	}

	@Test
	public void given_Contacts_Should_Read_A_File_And_Give_Count() {
		Person[] contacts = {
				new Person("Mou","All","warangal","warangal","Telangna",50602,9854646,"mounika.alloju@gmail.com"),
						
						
				new Person("Ram","Sri","warangal","warangal","Telangna",50602,96457326,"ramesh.sripadi@gmail.com"),};
		ArrayList<Person> arraylist = new ArrayList<>();
		arraylist.add(contacts[0]);
		arraylist.add(contacts[1]);
		AddressBookIOServices addressBook = new AddressBookIOServices();
		addressBook.writeData(arraylist);
		long entries = addressBook.readData(arraylist);
		Assert.assertEquals(2, entries);

	}

	@Test
	public void writeInto_CSVFileShouldReturnTotalCountTrue() throws IOException {
		Person addr1 = new Person("Mounika", "Alloju", "girmajipet", "warangal", "telangana", 506002, 9866349,"mounika.alloju@gmail.com");
		Person addr2 = new Person("Ramesh", "Sripadi", "girmajipet", "hnk", "Telangana", 506002, 9705444,"ram@gmail.com");
		ArrayList<Person> addressBook = new ArrayList<>();
		addressBook.add(addr1);
		addressBook.add(addr2);
		int count = AddressBookIOServices.writeCsv(addressBook);
		Assert.assertEquals(2, count);
	}

	@Test
	public void readCSVFileShouldReturnTotalCountTrue() throws IOException {
		int count = AddressBookIOServices.readCsv();
		Assert.assertEquals(2, count);
	}
	
	@Test
	public void writeInto_JSONFileShouldReturnTotalCountTrue() throws IOException {
		Person addr1 = new Person("Mounika", "Alloju", "girmajipet", "warangal", "telangana", 506002, 98663495,"mounika.alloju@gmail.com");
		Person addr2 = new Person("Ramesh", "Sripadi", "girmajipet", "hnk", "Telangana", 506002, 9704616,"ram@gmail.com");
		ArrayList<Person> addressBook = new ArrayList<>();
		addressBook.add(addr1);
		addressBook.add(addr2);
		int count = AddressBookIOServices.writeJson(addressBook);
		Assert.assertEquals(2, count);
	}
	
	@Test
	public void readJSONFileShouldReturnTotalCountTrue() throws IOException {
		int count = AddressBookIOServices.readJson();
		System.out.println(count);
		Assert.assertEquals(2, count);
	}
}
