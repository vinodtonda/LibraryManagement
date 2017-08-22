package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	
	public static Connection dbconnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","admin");
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
		
	}
}
