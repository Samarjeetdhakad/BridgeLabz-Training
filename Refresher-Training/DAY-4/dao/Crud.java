package com.bridgelabz.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Crud {

	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url ="jdbc:mysql://localhost:3306/studentpractice";
		String user ="root";
		String pswrd ="root@";
		
		System.out.println("enter id");
		int id = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, user, pswrd);
			 
			//search
			String sql = "SELECT * FROM students WHERE id=?";
			PreparedStatement stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, id);
			 ResultSet rs = stmt.executeQuery();
			 
			 if(rs.next()) {
				 System.out.println("id "+ rs.getInt("id"));
	             System.out.println("Name " + rs.getString("name"));
	             System.out.println("email " + rs.getString("email"));
				 System.out.println("age "+ rs.getInt("age"));

	             System.out.println("grade " + rs.getString("grade"));

			 }else {
				 System.out.println("student not exists");
			 }
			 
			 // update
			 String sql2 = "UPDATE students SET grade=? WHERE id=?";

	            PreparedStatement ps = conn.prepareStatement(sql2);

	    		System.out.println("enter id, grade");
	            id = sc.nextInt();
	            String grade = sc.next();
	            
	            ps.setString(1, grade);
	            ps.setInt(2, id);
	            int rows = ps.executeUpdate();
	            System.out.println(rows+"record updated");
			 
	            
	            //delete
	        	System.out.println("enter id");
	            id = sc.nextInt();
	            
	            String sql3 = "DELETE FROM students WHERE id=?";
	            PreparedStatement stmt3 = conn.prepareStatement(sql3);
	            stmt3.setInt(1, id);
	             rows = stmt3.executeUpdate();

	            System.out.println(rows+"record deleted");
			 
			 
			 stmt3.close();
			 ps.close();
			 
			 rs.close();
			 stmt.close();
			 conn.close();
			

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
