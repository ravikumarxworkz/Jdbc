package com.xworkz.richperson.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.richperson.conastans.Conncetion;

public class Ratantataupdate {

	public static void main(String[] args) {

		String query = "UPDATE richperson_info set richperson_name=? where richperson_number=?";
		try (Connection connection = DriverManager.getConnection(Conncetion.URL.getValue(),
				Conncetion.USER_NAME.getValue(), Conncetion.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, "bill gate");
			preparedStatement.setDouble(2, 9632974675l);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
