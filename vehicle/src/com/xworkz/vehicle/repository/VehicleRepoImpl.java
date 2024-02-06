package com.xworkz.vehicle.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xworkz.vehicle.constans.ConnectionData;
import com.xworkz.vehicle.dto.VehicleDto;

public class VehicleRepoImpl implements VehicleRepo {

	@Override
	public boolean save(VehicleDto dto) {

		String query = "INSERT INTO vehicle_detailes (vehicle_name,vehicle_color,vehicle_price)values(?,?,?)";

		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			System.out.println("connection is  done");
             
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getColor());
			preparedStatement.setInt(3, dto.getPrice());
			 
			int rowAffected = preparedStatement.executeUpdate();
			if (rowAffected > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
