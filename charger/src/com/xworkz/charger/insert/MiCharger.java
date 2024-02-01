package com.xworkz.charger.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.charger.conastans.ConnectionData;

public class MiCharger {

	public static void main(String[] args) {

		String query = "INSERT INTO charger_table(charger_name,charger_price,charger_capcity)values(?,?,?)";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                       System.out.println("connection is done");
			     preparedStatement.setString(1, "MI");
			     preparedStatement.setDouble(2, 200.0);
			     preparedStatement.setString(3, "35W");
			     
			    preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
