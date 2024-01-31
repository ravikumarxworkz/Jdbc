package com.xworkz.bottles.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.xworkz.bottles.constans.BottleConnectionData;

public class BottleRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(BottleConnectionData.URL.getValue(),
				BottleConnectionData.USER_NAME.getValue(), BottleConnectionData.PASSWORD.getValue())) {
			java.sql.Statement statement = connection.createStatement();

			System.out.println("connection is done");
			String querry = "INSERT INTO bottle_detailes(bottle_name,bottle_price) " + "values('Kingfisher' ,150),"
					+ "('Bira 91',200)," + "('Kati Patang',150),"
					+ "('Royal Challenge',225)," + "('Mahou',175),"
					+ "('Haywards',250)," + "('Knock Out',275),"
					+ "('Tuborg',175)," + "('Godfather',200),"
					+ "('Old Monk',300)," + "('Indus Pride',180),"
					+ "('Fosters',200)," + "('Simba',400)," 
					+ "('white Owl',300)," + "('Goa Kings',110);";
			statement.execute(querry);
		} catch (SQLException e) {
			System.out.println("connection is not done"+e.getMessage());

		}

	}

}
