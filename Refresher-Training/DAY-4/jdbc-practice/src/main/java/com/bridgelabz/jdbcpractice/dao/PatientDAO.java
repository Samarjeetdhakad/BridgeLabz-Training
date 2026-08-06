package com.bridgelabz.jdbcpractice.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbcpractice.model.Doctor;
import com.bridgelabz.jdbcpractice.model.Patient;
import com.bridgelabz.jdbcpractice.util.DBConnection;

public class PatientDAO {
	
	public void addPatient(Patient patient) {

	    

	    String sql = "INSERT INTO patient(name, phone, dob) VALUES (?, ?, ?)";

	    try(Connection conn = DBConnection.DbConnection();
	    	PreparedStatement ps = conn.prepareStatement(sql);	
	    	) {
	        
	        ps.setString(1, patient.getName());
	        ps.setString(2, patient.getPhone());
	        ps.setString(3, patient.getDob());

	        ps.executeUpdate();

	        System.out.println("Patient Added Successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void viewPatients() {
		  try (Connection con = DBConnection.DbConnection();
	            CallableStatement cs =  con.prepareCall("{call getAllPatients()}");)
				  {
	            ResultSet rs = cs.executeQuery();
	            while (rs.next()) {
	                System.out.println("Patient ID:"+ rs.getInt("patient_id"));
	                System.out.println("Name: " + rs.getString("name"));
	                System.out.println("Phone  : " + rs.getString("phone"));
	                System.out.println("DOB: " + rs.getDate("dob"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	    
	
	
	public void searchPatient(Patient patient) {
	    String sql = "SELECT * FROM patient WHERE patient_id = ?";
	    try (Connection conn = DBConnection.DbConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);	       	        
	    		){ 
	    	ps.setInt(1, patient.getPatientId());
	    	try( 
	   	    	 ResultSet rs = ps.executeQuery();){
	    		 if (rs.next()) {
	 	            System.out.println("Patient ID:" + rs.getInt("patient_id"));
	 	            System.out.println("Name:" + rs.getString("name"));
	 	            System.out.println("Phone:" + rs.getString("phone"));
	 	            System.out.println("DOB:" + rs.getDate("dob"));
	 	        }else {
	 	        	System.out.println("patient not found:");
	 	        }
	    		
	    	}
	    	
	    	 
	       

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void updatePatient(Patient patient) {

	    String sql = "UPDATE patient SET name=?, phone=?, dob=? WHERE patient_id=?";
	    try( Connection conn = DBConnection.DbConnection();
		     PreparedStatement ps = conn.prepareStatement(sql);
	    		) {
	       

	        ps.setString(1,patient.getName());
	        ps.setString(2,patient.getPhone());
	        ps.setString(3,patient.getDob());
	        ps.setInt(4, patient.getPatientId());

	        int rows= ps.executeUpdate();
	        if (rows >0) {
	            System.out.println("Patient Updated Successfully");
	        } else {
	            System.out.println("Patient Not Found");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
//	public void deletePatient(int patientId) {
//	    String sql = "DELETE FROM patient WHERE patient_id=?";
//
//	    try(Connection conn = DBConnection.DbConnection();
//	        PreparedStatement ps = conn.prepareStatement(sql);
//	        )
//	    {
//	    	ps.setInt(1, patientId);
//	    	int rows = ps.executeUpdate();
//
//	        if (rows > 0) {
//	            System.out.println("Patient Deleted Successfully");
//	        } else {
//	            System.out.println("Patient Not Found");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//	
	// using ttransactoin
	public void deletePatient(int patientId) {
		
		String sql1 = "DELETE FROM patient WHERE patient_id = ?;";
		Connection conn = null;
		PreparedStatement deleteAppointment = null;
		PreparedStatement deletePatient = null;
	    try{
	    	conn = DBConnection.DbConnection();
	    	
	    	conn.setAutoCommit(false);
	    	
	    	  String appointmentQuery = "DELETE FROM appointment WHERE patient_id = ?";
	    	  deleteAppointment = conn.prepareStatement(appointmentQuery);
	          deleteAppointment.setInt(1, patientId);
	          deleteAppointment.executeUpdate();
	          
	          String patientQuery = "DELETE FROM patient WHERE patient_id = ?";
	          deletePatient =  conn.prepareStatement(patientQuery);
	          deletePatient.setInt(1, patientId);
	          int rows = deletePatient.executeUpdate();
	    	
	          conn.commit();
	          
	          if (rows>0) {
	        	  System.out.println("patient deleted successfully");
	          }
	          else {
	        	  System.out.println("patient not found");
	          }
	           
	    	} catch (Exception e) {
	            try {
	                if (conn != null) {
	                    System.out.println("Transaction Failed");
	                    conn.rollback();
	                    System.out.println("Rollback Successful");
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (deleteAppointment != null)
	                    deleteAppointment.close();
	                if (deletePatient != null)
	                    deletePatient.close();
	                if (conn != null) {
	                    conn.setAutoCommit(true);
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	
	


