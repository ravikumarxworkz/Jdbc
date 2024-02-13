package com.xworkz.army.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.army.constants.ConnectionData;
import com.xworkz.army.dto.ArmyDto;

public class SanjaySingh {
	public static void main(String[] args) {
		ConnectionData.URL.setValue("jdbc:mysql://localhost:3306/army");
		ConnectionData.USER_NAME.setValue("root");
		ConnectionData.PASSWORD.setValue("Ravikumar@7862");
		ArmyDto dto = new ArmyDto();

		dto.setSoldier_name("Sanjay Singh");
		dto.setRank("Major");
		dto.setDivision("Special Forces");

		String query = "INSERT INTO army_data(soldier_name,ranks,division)VALUES(?,?,?)";
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is done");
			preparedStatement.setString(1, dto.getSoldier_name());
			preparedStatement.setString(2, dto.getRank());
			preparedStatement.setString(3, dto.getDivision());
			int ra = preparedStatement.executeUpdate();

			if (ra > 0) {
				System.out.println("data saved sucessfully");
			} else {
				System.out.println("data not saved sucessfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
