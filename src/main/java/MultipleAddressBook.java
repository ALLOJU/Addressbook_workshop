import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBook {
	/**
	 * Creating map for storing addressbook and its values
	 */
	Map<String, AddressBook> addressBookMap = new HashMap<String, AddressBook>();
	public Map<String, Person> persons = new HashMap<String, Person>();

	/**
	 * Method to add Address book to map
	 */
	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		// Check whether book is present or not
		if (addressBookMap.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {

			AddressBook addressBook = new AddressBook();
			addressBookMap.put(bookName, addressBook);
			System.out.println("Address Book " + bookName + " successfully added!!");
		}
	}

	/**
	 * Method to add contacts to particular addressbook here im add contacts to
	 * address book which is present
	 * 
	 * @throws AddressBookException
	 */

	public void addContact() throws AddressBookException {
		System.out.println("Enter the name of Address book to add the contact.");
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		// to check if the addressbook is present
		AddressBook addressBook = addressBookMap.get(newContact);
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			// if address book present then add it to Map
			addressBookMap.get(newContact).addContact();
		}
	}

	/**
	 * Method to edit contacts in particular address book
	 * 
	 * @throws AddressBookException
	 */
	public void editContactInBook() throws AddressBookException {
		System.out.println("Enter Name of Address Book you want to edit: ");
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			addressBookMap.get(editBookName).editPerson();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			editContactInBook();
		}
	}

	/**
	 * Method to delete address book if its already present
	 */
	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.remove(bookName);
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteAddressBook();
		}
	}

	/**
	 * delete contacts in address book
	 */
	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete : ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	/**
	 * Method to print list of addressbook
	 */
	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
		}
	}

	/*
	 * Method to display contacts in address book
	 */
	public void printContactsInBook() {
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
			System.out.println(addressBookMap.get(i).persons);
		}
		System.out.println(" ");
	}

	/**
	 * This method is used search person by city here we are using the streams
	 * filter to get the contact matching the city and then printing it.
	 */
	 public void searchByCity() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name of the City to get the persons : ");
			String cityName = sc.next();
			for (String i : addressBookMap.keySet()) {
			List<Person>	arr = (List<Person>) addressBookMap.get(i).persons;
			arr.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstname()));
	      }		
	    }

	/**
	 * This method is used to search person by state
	 */
	 public void searchByState() {
		 	Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name of the State to the get persons : ");
			String stateName = sc.next();
			for (String i : addressBookMap.keySet()) {
			List<Person>	arr = (List<Person>) addressBookMap.get(i).persons;
			arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstname()));
		  }		
		}

	/**
	 * Method to display people by using hashmap
	 * 
	 * @param addressBookMap
	 */
	public void displayPeopleByRegion(HashMap<String, ArrayList<Person>> addressBookMap) {
		List<Person> persons;
		for (String name : addressBookMap.keySet()) {
			System.out.println("People residing in: " + name);
			persons = addressBookMap.get(name);
			for (Person person : persons) {
				System.out.println(person);
			}
		}
	}

	/**
	 * In this method we are displaying the number of person in the city or state.
	 * 
	 * @param list - we are passing the list of city or state
	 */
	public void countPeopleByRegion(HashMap<String, ArrayList<Person>> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the region :");
		String regionName = sc.next();
		long countPeople = list.values().stream()
				.map(region -> region.stream()
						.filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.count();

		System.out.println("Number of People are " + regionName + " are: " + countPeople + "\n");

	}

	/**
	 * Method to sort the address book by name
	 */
	public void sortAddressBook(int sortingChoice){
		List<Person> sortedContactList;
		for (String i : addressBookMap.keySet()) {
			 Map<String,Person> contactList = addressBookMap.get(i).persons;
			
			 switch(sortingChoice) {
				
				case 1: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> firstperson.getFirstname().compareTo(secondperson.getFirstname()))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
					
				case 2: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> firstperson.getCity().compareTo(secondperson.getCity()))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
					
				case 3: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> firstperson.getState().compareTo(secondperson.getState()))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
					
				case 4: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> Long.valueOf(firstperson.getZip()).compareTo(Long.valueOf(secondperson.getZip())))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
			}
					
		}
	}
	public void printSortedList(List<Person> sortedContactList) {
		System.out.println("------ Sorted Address Book ------");
		Iterator iterator = sortedContactList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println();
		}
		System.out.println("-----------------------------------------");
	}

	
}
