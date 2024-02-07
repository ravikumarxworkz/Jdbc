package com.xworkz.product.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductInsert {

	public static void main(String[] args) {
           
		String query = "INSERT INTO product_table(product_name,product_price)VALUES(?,?)";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "123456789");
				PreparedStatement statement = con.prepareStatement(query)) {
                
			System.out.println("connection is ok");
			statement.setString(1, "milk");
			statement.setInt(2, 50);

			statement.executeUpdate();
			System.out.println("data saved");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
