package com.xworkz.fruites.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.fruites.conastans.ConnectionData;

public class Apple {
	public static void main(String[] args) {

		String query = "INSERT INTO fruits_table(fruits_name,fruits_price,fruits_quantity)values(?,?,?)";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "APPLE");
			preparedStatement.setInt(2, 200);
			preparedStatement.setDouble(3, 1.5);
			System.out.println("data is instert=" + preparedStatement.execute());
		} catch (SQLException e) {
			System.out.println("EROOR " + e.getMessage());
		}
	}

}
