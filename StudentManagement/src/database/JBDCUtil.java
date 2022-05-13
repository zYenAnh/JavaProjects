package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JBDCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//parameter
			String url = "jdbc:mySQL://localhost:3306/qlsv";
			String userName = "root";
			String password = "";
			
			c = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	} 
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
