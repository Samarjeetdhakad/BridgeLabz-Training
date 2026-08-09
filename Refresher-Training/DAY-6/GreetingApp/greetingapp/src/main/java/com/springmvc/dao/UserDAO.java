package com.springmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;
import com.springmvc.util.DbConnection;

@Repository
public class UserDAO {
	
	public boolean UserExists(String email) {
		String sql = "SELECT id FROM user WHERE email = ?;";
		
		try(Connection conn = DbConnection.DbConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			return rs.next();	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false ;
		
	}
	
	public void UserRegister(User user) {
		String sql = "INSERT INTO user (name, email, password) VALUES(?,?,?);";
	
		try(Connection conn = DbConnection.DbConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				 System.out.println("Registered successfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public User LoginUser(String email, String password) {
		String sql = "SELECT * FROM user WHERE email =? AND password = ?;";
		
		try(Connection conn = DbConnection.DbConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				return user;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	

}
