package com.bridgelabz.jdbcpractice.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {
	public static void main(String [] args ) {
		String url = "jdbc:mysql://localhost:3306/studentpractice";
		String user = "root";
		String password = "root@";
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(url,user,password);
			
            System.out.println("connection connected successfully");
            
            String sql = " USE studentpractice";
            PreparedStatement stmt = connection.prepareStatement(sql);            
            int rowsAffected = stmt.executeUpdate();            
            System.out.println(rowsAffected + " use db");
            
            String sql2 = "CREATE TABLE IF NOT EXISTS students ("
            		+ "id INT AUTO_INCREMENT PRIMARY KEY,"
            		+ "name VARCHAR(100) NOT NULL,"
            		+ "email VARCHAR(100) UNIQUE NOT NULL,"
            		+ "age INT,"
            		+ "grade VARCHAR(10));";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);   
            int rowsAffected2 = stmt2.executeUpdate();          
            System.out.println(rowsAffected2 + " table created successfully");
            
            String sql3 = "INSERT INTO students (name, email,age,grade) VALUES(?,?,?,?);";
            PreparedStatement stmt3 =  connection.prepareStatement(sql3);  
            stmt3.setString(1, "Samar");
            stmt3.setString(2, "samar@gmail.com");
            stmt3.setInt(3, 22);
            stmt3.setString(4, "A");
  
            int rowsAffected3 = stmt3.executeUpdate();
            System.out.println(rowsAffected3 + " inserted successfully");
 
            stmt.close();
            stmt2.close();
            stmt3.close();
            connection.close();
            
            
		}catch(Exception e){
			e.printStackTrace();		
		}
		
		
		
		
		
		
		
	}

}
