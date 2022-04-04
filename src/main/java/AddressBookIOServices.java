import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookIOServices {

		public long countEntries() {
			long entries = 0;
			try {
				entries = Files.lines(new File("address-file.txt").toPath()).count();
			} catch (IOException e) {

			}
			return entries;
		}

		/**
		 * method to write data to normal file which is in the text format
		 * @param persons - List of persons
		 */
		public void writeData(ArrayList<Person> persons) {
			StringBuffer empBuffer = new StringBuffer();
			persons.forEach(employee -> {
				String addressBookDataString = employee.toString().concat("\n");
				empBuffer.append(addressBookDataString);
			});
			try {
				Files.write(Paths.get("C:\\Users\\nani\\Documents\\Java Programs\\Workshop4\\src\\test\\resources\\address-file.txt"), empBuffer.toString().getBytes());

			} catch (IOException e) {
				System.out.println(e);

			}
		}
		/**
		 * read data from text file
		 * @param addresslList - list of address book contacts
		 * @return
		 */
		public long readData(ArrayList<Person> addresslList) {

			try {
				Files.lines(new File("address-file.txt").toPath()).map(line -> line.trim())
						.forEach(line -> System.out.println(line));

			} catch (IOException e) {

			}
			return addresslList.size();

		}
		
		
		/**
		 * Method to write contact details to csv file
		 * @param addressBook - list of contacts
		 * @return
		 * @throws IOException - throws exception when file is not exist
		 */
		public static int writeCsv(ArrayList<Person> addressBook) throws IOException {
			int count = 0;
			try (Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\nani\\Documents\\Java Programs\\Workshop4\\src\\test\\resources\\csvAddress.csv"));) {
				StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer).build();

				ArrayList<Person> adressBook = new ArrayList<Person>();
				for (Person addr : addressBook) {
					adressBook.add(addr);
					count++;
				}
				beanToCsv.write(adressBook);
			} catch (CsvRequiredFieldEmptyException e) {
				e.printStackTrace();
			} catch (CsvDataTypeMismatchException e) {
				e.printStackTrace();
			}
			return count;

		}

		/**
		 * Method to read Comma separated data file data
		 * @return
		 * @throws IOException
		 */
		public static int readCsv() throws IOException {
			int count = 0;
			try (Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\nani\\Documents\\Java Programs\\Workshop4\\src\\test\\resources\\csvAddress.csv"));) {
				CsvToBean<Person> csvToBean = new CsvToBeanBuilder<Person>(reader).withType(Person.class).build();
				Iterator<Person> csvUserIterator = csvToBean.iterator();

				while (csvUserIterator.hasNext()) {
					count++;
					Person adressBook = csvUserIterator.next();
					System.out.println("First Name : " + adressBook.getFirstname());
					System.out.println("Last Name : " + adressBook.getLastname());
					System.out.println("Address: " + adressBook.getAddress());
					System.out.println("City : " + adressBook.getCity());
					System.out.println("State : " + adressBook.getState());
					System.out.println("Zip : " + adressBook.getZip());
					System.out.println("Number : " + adressBook.getPhone_number());
					System.out.println("Email : " + adressBook.getEmail());
					System.out.println("*****************");
				}
			}
			return count;
		}
		/**
		 * Method to write data to json file using gson library
		 * @param addresBook --list of contacts
		 * @return -size of the list
		 * @throws IOException -throws IOException when input file is not exist
		 */
		public static int writeJson(ArrayList<Person> addresBook) throws IOException {
			Gson gson = new GsonBuilder().create();
			List<Person> list = addresBook.stream().collect(Collectors.toList());
			String json = gson.toJson(list);
			FileWriter writer = new FileWriter("C:\\Users\\nani\\Documents\\Java Programs\\Workshop4\\src\\test\\resources\\jsonAddress.json");
			writer.write(json);
			writer.close();
			return list.size();
		}
		/**
		 * Method to read json data from the address book list
		 * @return
		 */
		public static int readJson() {
			int count = 0;
			try {
				Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\nani\\Documents\\Java Programs\\Workshop4\\src\\test\\resources\\jsonAddress.json"));
				List<Person> addresBook = new Gson().fromJson(reader, new TypeToken<List<Person>>() {}.getType());
				Iterator<Person> jsonIterator = addresBook.iterator();

				while (jsonIterator.hasNext()) {
					count++;
					Person adressBook = jsonIterator.next();
					System.out.println("First Name : " + adressBook.getFirstname());
					System.out.println("Last Name : " + adressBook.getLastname());
					System.out.println("Address: " + adressBook.getAddress());
					System.out.println("City : " + adressBook.getCity());
					System.out.println("State : " + adressBook.getState());
					System.out.println("Zip : " + adressBook.getZip());
					System.out.println("Number : " + adressBook.getPhone_number());
					System.out.println("Email : " + adressBook.getEmail());
					System.out.println("*****************");
				}
				reader.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return count;
		}

}
