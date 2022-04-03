import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookIOServices {
	/**
	 * This method is used to write the list of data into a textfile.
	 * @param contactlist -list of contact
	 */
		public void writeData(List<Person> contactlist) {
			StringBuffer temp=new StringBuffer();
			contactlist.forEach(person ->{
				String data=person.toString().concat("\n");
				temp.append(data);
			});
			try {
				Files.write(Paths.get("C:\\Users\\nani\\Desktop\\contacts\\contact.txt"),temp.toString().getBytes());
				System.out.println("write to file");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * This method is used to print the list of data from a text file to console.
		 * 
		 */
		public void printData() {
			try {
				Files.lines(new File("C:\\Users\\nani\\Desktop\\contacts\\contact.txt").toPath())
				.forEach(System.out::println);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
