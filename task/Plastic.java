package com.xworkz.plastic.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Plastic {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	     String url="jdbc:mysql://localhost:3306/plastic_database";
	     String user_Name="root";
	     String password="123456789";
	try{
		Connection connection=DriverManager.getConnection(url, user_Name, password);
		 connection=null;
		if (connection!=null) {
			System.out.println(" connection is successfully done");
		}
		else {
			System.out.println("sjhfbsfdfbb");
		}
		
	
	} catch (SQLException e) {
		
			System.out.println(" connection is failed due "+e.getMessage());
	}
	}

}
