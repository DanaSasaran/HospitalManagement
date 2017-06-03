package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getDBConnection() throws ClassNotFoundException,
	SQLException {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection(
					"jdbc:mysql://localhost/hospital?useSSL=false", "root", "danas");
					System.out.println("CONECTAT LA DB");
	return c;
}
}
