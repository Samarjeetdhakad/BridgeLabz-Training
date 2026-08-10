package com.springmvc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public User getUserById(Long id) {
	    String sql = "SELECT * FROM user WHERE id = ?";
	    try (Connection conn = DbConnection.DbConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql))
	    {
	        stmt.setLong(1, id);
	        ResultSet rs = stmt.executeQuery();  

	        if (rs.next()) {
	            User user = new User();

	            user.setId(rs.getLong("id"));
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));

	            return user; 
	            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
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
			
			//memory purpose
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
	
	
	public boolean UpdateUser(User user) {

		String sql = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
		
	    try (
	        Connection connection = DbConnection.DbConnection();
	        PreparedStatement statement =
	            connection.prepareStatement(sql)
	    ) {

	        statement.setString(1, user.getName());
	        statement.setString(2, user.getEmail());
	        statement.setString(3, user.getPassword());
	        statement.setLong(4, user.getId());

	        return statement.executeUpdate() > 0;

	    } catch (SQLException e) {

	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public boolean deleteUser(Long id) {
	    String sql = "DELETE FROM user WHERE id = ?";
	    try (
	        Connection connection = DbConnection.DbConnection();
	        PreparedStatement statement =
	            connection.prepareStatement(sql)
	    ) {
	        statement.setLong(1, id);
	        return statement.executeUpdate() > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	
	public List<User> getAllUsers() {

	    List<User> users = new ArrayList<>();

	    String sql = "SELECT id, name, email, password FROM user";

	    try (
	        Connection connection = DbConnection.DbConnection();
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery()
	    ) {

	        while (resultSet.next()) {

	            User user = new User();

	            user.setId(resultSet.getLong("id"));
	            user.setName(resultSet.getString("name"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));

	            users.add(user);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return users;
	}
	
}
