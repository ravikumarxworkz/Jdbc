package com.xworkz.employee.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeUpdate {

	public static void main(String[] args) {

		String query = " UPDATE employee_table SET salary=? WHERE department=?";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "123456789");
				PreparedStatement statement = con.prepareStatement(query)) {

			System.out.println("connection is ok");
			statement.setInt(1, 50000);
			statement.setString(2, "it");

			statement.executeUpdate();

			System.out.println("data is saved");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
