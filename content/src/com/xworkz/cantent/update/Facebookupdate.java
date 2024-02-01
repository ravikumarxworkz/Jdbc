package com.xworkz.cantent.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.cantent.conastans.ConnectionData;

public class Facebookupdate {
	
	
	public static void main(String[] args) {

		String query = "UPDATE content_table set content_name=? where content_id=?";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "INstgram");
			preparedStatement.setInt(2, 1);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
