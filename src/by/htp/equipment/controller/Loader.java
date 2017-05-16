package by.htp.equipment.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Loader {
	
	public static Connection dbConnector; 
	
	private Loader() {
		
	}
	
	public static Connection LoaderDb() throws ClassNotFoundException, SQLException {
		if ( dbConnector == null ) {
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String dbUrl = rb.getString("db.url");
			String dbUser = rb.getString("db.login");
			String dbPass = rb.getString("db.pass");
			String driverName = rb.getString("db.driver.name");
			System.out.println(dbUrl);
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName(driverName);
			dbConnector = DriverManager.getConnection(dbUrl, dbUser, dbPass);

		}
		
		return dbConnector;
	}
}
