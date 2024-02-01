package com.xworkz.richperson.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.richperson.conastans.Conncetion;

public class Ratantata {

	public static void main(String[] args) {

		String query = "INSERT INTO richperson_info(richperson_name,richperson_age,richperson_number,richperson_country)values(?,?,?,?)";
		try (Connection connection = DriverManager.getConnection(Conncetion.URL.getValue(),
				Conncetion.USER_NAME.getValue(), Conncetion.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "RATAN TATA");
			preparedStatement.setInt(2, 75);
			preparedStatement.setDouble(3, 9632974675L);
			preparedStatement.setString(4, "INDIA");
			System.out.println("data is instert=" + preparedStatement.execute());
		} catch (SQLException e) {
			System.out.println("EROOR " + e.getMessage());
		}
	}

}
