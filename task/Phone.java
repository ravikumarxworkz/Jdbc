package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Phone {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		     String url="jdbc:mysql://localhost:3306/phone_database";
		     String user_Name="root";
		     String password="123456789";
		try(Connection connection=DriverManager.getConnection(url, user_Name, password)){
			
			if (connection!=null) {
				 java.sql.Statement statement=connection.createStatement();
					
					  String query="select*from phone_database"; ResultSet
					  resultSet=statement.executeQuery(query); //
					  System.out.println(" connection is successfully done");
					  
					  while(resultSet.next()) { int id=resultSet.getInt("id"); String
					  name=resultSet.getString("name"); int ram=resultSet.getInt("ram"); double
					  price=resultSet.getDouble("price");
					  
					  
					  System.out.println("ID :"+id); System.out.println("Name :"+name);
					  System.out.println("Ram :"+ram+"GB");
					  System.out.println("Price :"+price+"US DOLLER"); }
					 
				 
				 String update = String.format("insert into phone_database(name, ram, price) values('%s', %d, %d)", "realme", 12, 120);
				 
			  int rowAffected=statement.executeUpdate(update);
			  
			  System.out.println("result ="+rowAffected);
			 
			 if(rowAffected>0) {
				 System.out.println("update successfully");
			 }
			 else {
				 System.out.println("data not inseted");
			 }
			}
			  
	
		} catch (SQLException e) {
			
				System.out.println(" connection is failed due "+e.getMessage());
		}
	}

}
