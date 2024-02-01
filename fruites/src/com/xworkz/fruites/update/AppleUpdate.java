package com.xworkz.fruites.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.fruites.conastans.*;

public class AppleUpdate {

	public static void main(String[] args) {

		String query = "UPDATE fruits_table set fruits_name=? where fruits_price=?";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "BANANA");
			preparedStatement.setInt(2, 200);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
