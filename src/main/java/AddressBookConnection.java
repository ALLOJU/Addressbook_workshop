import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddressBookConnection {
	/**
	 * Connecting program to database using URL,USERNAME and PASSWORD
	 */
	public static final String URL = "jdbc:mysql://localhost:3306/addressbookservicedb?useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "Admin@123";
	public static Connection connection = null;

	public static Connection getConnection() {
		try {
			/**
			 * Driver class name to connect the database
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
