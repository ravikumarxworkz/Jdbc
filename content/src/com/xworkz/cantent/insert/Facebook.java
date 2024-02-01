package com.xworkz.cantent.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.cantent.conastans.ConnectionData;

public class Facebook {

	
	public static void main(String[] args) {

		String query = "INSERT INTO content_table(content_name,content_by,content_pages)values(?,?,?)";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "facebook");
			preparedStatement.setString(2, "soma");
			preparedStatement.setString(3, "10");
			System.out.println("data is instert="+preparedStatement.execute());
		} catch (SQLException e) {
			System.out.println("EROOR " + e.getMessage());
		}
	}
}
