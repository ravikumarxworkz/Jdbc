package com.xwrokz.pen.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.xworkz.pen.constans.ConnectionData;

public class PenRunner1 {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());) {
			java.sql.Statement statement = connection.createStatement();

			System.out.println("coonecgtion is done");
			String querry ="UPDATE pen_table set pen_name='yoyo' where id=2";
			int rs = statement.executeUpdate(querry);
			if (rs > 0) {
				System.out.println("data updated successfully");
			} else {
				System.out.println("data not updated successfully");
			}
		} catch (SQLException e) {
            e.printStackTrace();
			System.out.println("connection is not done");

		}

	}
}
