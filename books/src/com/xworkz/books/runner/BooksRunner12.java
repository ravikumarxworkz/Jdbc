package com.xworkz.books.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.xworkz.books.constans.ConnectionData;

public class BooksRunner12 {
	public static void main(String[] args) {
		
		try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue())){
			java.sql.Statement statement=connection.createStatement();
		       
			System.out.println("connection is done");
			String querry="UPDATE books_detailes set book_name='indian ecanomy' where id=2";
			
			int rowAffected=statement.executeUpdate(querry);
			if(rowAffected>0) {
				System.out.println("data is updated sucessfully");
			}
			else {
				System.out.println("data is not updated");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();

		}
	}

}

