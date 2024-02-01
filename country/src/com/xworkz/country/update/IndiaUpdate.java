package com.xworkz.country.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.country.conastans.ConnectionData;

public class IndiaUpdate {

	public static void main(String[] args) {

		String query = "UPDATE country_table set country_name=? where country_capital=?";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "bharta");
			preparedStatement.setString(2, "delhi");
			System.out.println("data is instert=" + preparedStatement.execute());
		} catch (SQLException e) {
			System.out.println("EROOR " + e.getMessage());
		}
	}

}
