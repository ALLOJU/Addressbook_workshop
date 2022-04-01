/**
 * Model class to create data
 * @author mounika
 *
 */
public class Person {

	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phone_number;
	private String email;
	/**
	 * created setters and getters for setting data and retrieve data
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Parameterized constructor is created.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phoneNo
	 * @param email
	 */
	public Person(String firstname, String lastname, String address, String city, String state, int zip,
			long phone_number, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone_number = phone_number;
		this.email = email;
	}
	/**
	 * This method use to print all the value.
	 */
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone_number=" + phone_number + ", email=" + email + "]";
	}
	
	
	
}
