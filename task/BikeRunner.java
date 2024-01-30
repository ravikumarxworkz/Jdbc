package com.xworkz.bike.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BikeRunner {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String jdbcUrl = "jdbc:mysql://localhost:3306/Bike_database";
		String username = "root";
		String password = "12345678";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
			if(connection!=null) {
				System.out.println("connection is sucess");
			}
			else {
				System.out.println("connection is failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
