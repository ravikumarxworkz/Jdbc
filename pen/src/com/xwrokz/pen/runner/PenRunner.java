package com.xwrokz.pen.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.xworkz.pen.constans.ConnectionData;

public class PenRunner {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue());) {
			java.sql.Statement statement = connection.createStatement();

			String pen_Name[] = { "Pilot", "Rorito", "Brite", "Marker", "Reyolands", "Cello", "Butterfly", "boll pen",
					"flair", "writo meter", "parker", "classmate", "doms", "unomax", "camlin" };

			int price[] = { 10, 20, 50, 30, 5, 15, 20, 10, 35, 20, 120, 10, 10, 15, 10 };

			for (int i = 0; i < pen_Name.length; i++) {
				String querry = String.format("INSERT INTO pen_table(pen_name,price) values('%s',%d)", pen_Name[i],
						price[i]);
				int rs = statement.executeUpdate(querry);
				if (rs > 0) {
					System.out.println("data insterd successfully");
				} else {
					System.out.println("data not insterd successfully");
				}
			}
		} catch (SQLException e) {

			System.out.println("connection is not done");

		}

	}

}
