package com.xworkz.bottles.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.xworkz.bottles.constans.BottleConnectionData;

public class BottleRunner11 {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(BottleConnectionData.URL.getValue(),
				BottleConnectionData.USER_NAME.getValue(), BottleConnectionData.PASSWORD.getValue())) {
			java.sql.Statement statement = connection.createStatement();

			System.out.println("connection is done");
			String querry = "UPDATE bottle_detailes set bottle_name='black&white' where bottle_name='Kingfisher'";
			int rs = statement.executeUpdate(querry);
			if (rs > 0) {
				System.out.println("data updated successfully");
			} else {
				System.out.println("data not updated successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
