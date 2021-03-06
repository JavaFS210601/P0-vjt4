package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {

		// For compatibility with other technologies/frameworks, we'll need to register
		// our Driver
		// This process makes the application aware of what Driver class (what SQL
		// dialect) we're using
		try {
			Class.forName("org.postgresql.Driver"); // try to find and return the postgresql Driver Class
		} catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found :(");
			e.printStackTrace(); // prints the exception message to the console
		}

		// We need to provide our database credentials
		// We'll hardcode them for now, but we'll see how to hide this username/password
		// in environment variables
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=uni";
		String username = "postgres";
		String password = "254808"; // this will be whatever password you set in postgres
									// hopefully you just left it as password...

		return DriverManager.getConnection(url, username, password);

	}

}
