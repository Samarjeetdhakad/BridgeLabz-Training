package com.springmvc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/greetingapp";
	private static String user = "root";
	private static String password = "root@";		
		
	public static Connection DbConnection() {
		
		Connection connection = null;
		
		 try {
			 connection = DriverManager.getConnection(url,user,password);		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		 return connection;
		
	}
		
	}


