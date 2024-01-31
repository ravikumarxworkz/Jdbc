package com.xworkz.books.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.xworkz.books.constans.ConnectionData;

public class BooksRunner {
	
	public static void main(String[] args) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Connection connection=DriverManager.getConnection(ConnectionData.URL.getValue(),
				ConnectionData.USER_NAME.getValue(), ConnectionData.PASSWORD.getValue())){
			java.sql.Statement statement=connection.createStatement();
		       
			System.out.println("connection is done");
			String querry="INSERT INTO books_detailes(book_name,book_author) "
					+ "values('Mookajnana' ,'kuvempu'),"
					+ "('Maidana','S. L. Bhyrappa'),"
					+ "('Samskrutika Prashnegalu','U. R. Ananthamurthy'),"
					+ "('Karnataka Sahitya Charitre','Govinda Pai'),"
					+ "('Mysuru Malenadu','Ta. Ra. Su'),"
					+ "('Puthumaya',' G. P. Rajarathnam'),"
					+ "('Kanooru','Kuvempu'),"
					+ "('Ayyachararu Prashnisiidaru','K. Shivarama Karanth'),"
					+ "('Vasuki','S. L. Bhyrappa'),"
					+ "('Nagamangala','Triveni'),"
					+ "('Bhairava','Poornachandra Tejaswi'),"
					+ "('Krishnayana','Kuvempu'),"
					+ "('Itara Darshana','D. R. Bendre'),"
                    + "('(Nagamangala','Triven'),"
                    + "('Sarvamoola',' Vyaasa'),"
					+ "('Ramayana dardhanam','kuvempu');";
			statement.execute(querry);
		}
		catch (SQLException e) {
			e.printStackTrace();
			 System.out.println("connection is not done");

		}

	}

}
