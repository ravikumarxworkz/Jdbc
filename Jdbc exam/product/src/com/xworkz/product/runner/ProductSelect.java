package com.xworkz.product.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSelect {

	public static void main(String[] args) {

		String query = "SELECT*FROM product_table WHERE product_price=?";

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "123456789");
				PreparedStatement statement = con.prepareStatement(query)) {

			System.out.println("connection is ok");
			statement.setInt(1, 100);

			ResultSet s = statement.executeQuery();

			    while(s.next()) {
			    	
			    }
				System.out.println("product-name" + s.getString(1));
				
			}

			System.out.println();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	

}

