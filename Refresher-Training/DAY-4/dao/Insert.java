package com.bridgelabz.jdbcpractice.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.Connection;
public class Insert {

	public static void main(String [] args) {
		String url ="jdbc:mysql://localhost:3306/studentpractice";
		String user = "root";
		String password = "root@";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
            Connection connection =  DriverManager.getConnection(url,user,password);
			
//            String sql ="use studentpractice;";
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            int rowsAffected = stmt.executeUpdate();
            
            String sql2 = "INSERT INTO students(name, email, age, grade) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql2);

       

            ps.setString(1, "Harshit");
            ps.setString(2, "harshit@gmail.com");
            ps.setInt(3, 21);
            ps.setString(4, "B");
            ps.executeUpdate();

            ps.setString(1, "Ritik");
            ps.setString(2, "ritik@gmail.com");
            ps.setInt(3, 20);
            ps.setString(4, "A");
            int rowsAffected =  ps.executeUpdate();
            System.out.println(rowsAffected + "inseerted");

            
            ps.close();
            connection.close();
			
			
		}catch(Exception e) {
					e.printStackTrace();
				}
		
		
			 
	}
}
