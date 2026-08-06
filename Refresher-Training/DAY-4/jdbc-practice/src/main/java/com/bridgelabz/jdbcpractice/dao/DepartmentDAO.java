package com.bridgelabz.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbcpractice.model.Department;
import com.bridgelabz.jdbcpractice.util.DBConnection;

public class DepartmentDAO {
	public void addDepartment(Department department) {
	    String sql = "INSERT INTO department(department_name) VALUES (?)";
	    try (
	        Connection conn = DBConnection.DbConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);
	    ) {
	        ps.setString(1, department.getDepartmentName());
	        int rows=ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Department Added Successfully");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void viewDepartments() {
	    String sql = "SELECT * FROM department";
	    try (
	        Connection conn = DBConnection.DbConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	    ) {
	    	System.out.println("Department ID  " +"Department Name " );
	        while (rs.next()) {	            
	            System.out.println( rs.getInt("department_id") + rs.getString("department_name"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
