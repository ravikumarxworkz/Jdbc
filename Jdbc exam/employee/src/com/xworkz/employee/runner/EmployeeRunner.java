package com.xworkz.employee.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRunner {

	public static void main(String[] args) {

		String query = "INSERT INTO employee_table(department,salary)VALUES(?,?)";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "123456789");
				PreparedStatement statement = con.prepareStatement(query)) {
                
			System.out.println("connection is ok");
			statement.setString(1, "eee");
			statement.setInt(2, 25000);

			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
