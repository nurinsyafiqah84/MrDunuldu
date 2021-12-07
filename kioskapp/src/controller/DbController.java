package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbController {

	private String databaseName = "kioskapp";
	private String username = "root";
	private String password = "";
	
	
	private String connectionPath = "jdbc:mysql://localhost/" + databaseName + "?" +
			"user=" + username + "&password=" + password;
	
	/*
	 * This method establish connection to RDBMS
	 * @return connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws Exception, SQLException{
		
		//load database driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Get connection object from the database
		Connection connection = DriverManager.getConnection(connectionPath);
		
		return connection;
	}
}

