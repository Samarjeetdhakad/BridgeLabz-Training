package com.bridgelabz.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbcpractice.model.Appointment;
import com.bridgelabz.jdbcpractice.util.DBConnection;

public class AppointmentDAO {
	
	public void ScheduleAppointment(Appointment appointment) {
		String sql = "INSERT INTO appointment(patient_id,doctor_id, appointment_date, status) VALUES(?,?,?,?);";
		
		try(Connection conn = DBConnection.DbConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
				){
			stmt.setInt(1, appointment.getPatientId());
			stmt.setInt(2, appointment.getDoctorId());
			stmt.setString(3, appointment.getAppointmentDate());
			
			stmt.setString(4, appointment.getStatus());
			
			int rows = stmt.executeUpdate();
			if(rows>0) {
				System.out.println("Appointment scheduled successfully");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void ViewAppointment() {
		String sql = "SELECT * FROM appointment;";
		
		try(Connection conn = DBConnection.DbConnection();
		    PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
				){
			
			boolean found = false;
			while(rs.next()) {
				found = true;
				System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
	            System.out.println("Patient ID: " +rs.getInt("patient_id"));
	            System.out.println("Doctor ID: " +rs.getInt("doctor_id"));
	            System.out.println("Date " + rs.getString("appointment_date"));
	            System.out.println("Status: " +rs.getString("status"));
			}
			
			if (!found) {
				System.out.println("no appointment");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void CancelAppointment(int appointmentId) {
		String sql = " UPDATE appointment SET status = 'CANCELLED' WHERE appointment_id = ?";
		
		try(Connection conn = DBConnection.DbConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			stmt.setInt(1, appointmentId);
			int rows = stmt.executeUpdate();
			if(rows>0) {
				System.out.println("Cancelled successfully");
			}
			else {
				System.out.println("Appointment not found ");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
