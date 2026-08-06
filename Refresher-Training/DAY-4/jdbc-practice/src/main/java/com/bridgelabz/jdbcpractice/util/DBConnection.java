package com.bridgelabz.jdbcpractice.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/JdbcHealthClinicApp";
	private static String user = "root";
	private static String password = "root@";

		
		
		public static Connection DbConnection() {
			Connection conn = null;
	
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("database connected successfully");
			
			
			}catch(Exception e) {
				e.printStackTrace();
		}
		
		return conn;
		}
		
	}


