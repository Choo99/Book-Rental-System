package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection  {
	private String databaseName = "library system";
	private String username = "root";
	private String password = "";
	
	private String connectionPath = "jdbc:mysql://localhost:3307/" + databaseName + "?" +
            "user=" + username + "&password=" + password;

	
    public Connection getConnection() throws ClassNotFoundException, SQLException 
    {
		
		// Load database driver
    	Class.forName("com.mysql.jdbc.Driver");
		
		// Get connection object from the database
		Connection connection = DriverManager.getConnection(connectionPath);
		
		return connection;
  
    }
}


