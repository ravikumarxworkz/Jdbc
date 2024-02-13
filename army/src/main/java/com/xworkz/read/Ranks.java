package com.xworkz.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.army.constants.ConnectionData;

public class Ranks {
	
	public static void main(String[] args) {
		ConnectionData.URL.setValue("jdbc:mysql://localhost:3306/army");
		ConnectionData.USER_NAME.setValue("root");
		ConnectionData.PASSWORD.setValue("Ravikumar@7862");

		String query = "select*from army_data where ranks=?";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "Major");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("solider name=" + resultSet.getString(1));
				System.out.println("rank=" + resultSet.getString(2));
				System.out.println("division=" + resultSet.getString(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
