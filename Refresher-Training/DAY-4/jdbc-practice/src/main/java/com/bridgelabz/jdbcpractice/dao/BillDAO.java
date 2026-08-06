package com.bridgelabz.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbcpractice.model.Doctor;
import com.bridgelabz.jdbcpractice.model.Patient;
import com.bridgelabz.jdbcpractice.util.DBConnection;

public class BillDAO {
	
	public void generateBill(int appointmentID, double medicineCharges){
		
		 String sql =
				    "SELECT p.name AS patient_name, d.name AS doctor_name, d.doctor_fee " +
				    "FROM appointment a " +
				    "JOIN patient p ON a.patient_id = p.patient_id " +
				    "JOIN doctor d ON a.doctor_id = d.doctor_id " +
				    "WHERE a.appointment_id = ?";

		 try (Connection con = DBConnection.DbConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {

		        ps.setInt(1, appointmentID);

		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {

		            String patientName = rs.getString("patient_name");
		            String doctorName = rs.getString("doctor_name");
		            double doctorFee = rs.getDouble("doctor_fee");

		            double total = doctorFee +  medicineCharges;

		            System.out.println("Patient Name : " + patientName);
		            System.out.println("Doctor Name: " + doctorName);
		            System.out.println("Doctor Fee   : " + doctorFee);
		            System.out.println("Medicine Charges  : " + medicineCharges);
		            System.out.println("------------------------------");
		            System.out.println("Total Bill        : " + total);

		        } else {

		            System.out.println("Appointment not found.");

		        }

		    } catch (SQLException e) {

		        e.printStackTrace();

		    }
	}
	}
