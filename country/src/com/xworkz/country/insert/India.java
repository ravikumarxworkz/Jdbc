package com.xworkz.country.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.country.conastans.ConnectionData;

public class India {

	public static void main(String[] args) {

		String query = "INSERT INTO country_table(country_name,country_capital,noOfStates)values(?,?,?)";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "INdia");
			preparedStatement.setString(2, "delhi");
			preparedStatement.setString(3, "29");
			System.out.println("data is instert=" + preparedStatement.execute());
		} catch (SQLException e) {
			System.out.println("EROOR " + e.getMessage());
		}
	}

}
