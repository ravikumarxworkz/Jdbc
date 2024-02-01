package com.xworkz.charger.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.charger.conastans.ConnectionData;

public class Mi {

	public static void main(String[] args) {

		String query = "UPDATE charger_table set charger_name=? where charger_id=?";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "poco");
			preparedStatement.setInt(2, 1);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
