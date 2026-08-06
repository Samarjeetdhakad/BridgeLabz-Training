package com.bridgelabz.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {
	public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentpractice";
        String user = "root";
        String password = "root@";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully");

            String sql = "SELECT * FROM students";

            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
            	System.out.println("ID:" + rs.getInt("id"));
            	System.out.println("Name:" + rs.getString("name"));
                System.out.println("Email:"+ rs.getString("email"));
                System.out.println("Age:" +rs.getInt("age"));
                System.out.println("Grade"+ rs.getString("grade"));
            }
            
            
            rs.close();
            stmt.close();
            connection.close();
            
            }catch(Exception e) {
            	e.printStackTrace();
            }
        
	}

}
