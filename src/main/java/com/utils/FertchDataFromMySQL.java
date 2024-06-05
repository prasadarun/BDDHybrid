package com.utils;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FertchDataFromMySQL {

	static Map<String, String> dataValues = new HashMap<String, String>();

	public Map<String, String> connectDB(String user, String password, String account, String query) {
		String sqlurl = "jdbc:mysql://" + account + "/demo"; // Corrected URL

		try (Connection connection = DriverManager.getConnection(sqlurl, user, password)) {
			// Establishing the connection
			// Creating a statement object
			Statement statement = connection.createStatement();

			// Executing the query and getting the result set
			ResultSet resultSet = statement.executeQuery(query);
	

			// Processing the result set
			while (resultSet.next()) {
				// Accessing the columns by name
				// int id = resultSet.getInt("id");
				String usr = resultSet.getString("username"); // Adjusted column name
				String pwd = resultSet.getString("password");
				//boolean status = resultSet.getBoolean("loginStatus");
				
				// Do something with the retrieved data
				System.out.println("User: " + usr + ", Password: " + pwd);

				dataValues.put(usr,pwd);
			}
		} catch (SQLException e) {
			System.out.println("Connection failed! Error: " + e.getMessage());
		}

		return dataValues;
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		Properties prop = PropertiesUtils.readProperties();
		FertchDataFromMySQL d = new FertchDataFromMySQL();
		d.connectDB(prop.getProperty("user"), prop.getProperty("password"), prop.getProperty("account"), prop.getProperty("query"));
		System.out.println(dataValues);
	}

}
