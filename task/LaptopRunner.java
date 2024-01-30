package com.xworkz.laptop.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaptopRunner {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/laptop_database";
		String user_Name = "root";
		String password = "123456789";

		try (Connection connection = DriverManager.getConnection(url, user_Name, password)) {
			
			if(connection!=null) {
				System.out.println("connection is sucess");
			}
			else {
				System.out.println("connection is failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
