package com.bridgelabz.jdbcpractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.jdbcpractice.model.Doctor;
import com.bridgelabz.jdbcpractice.util.DBConnection;


public class DoctorDAO {

    // Add Doctor
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctor(name, specialty, doctor_fee, department_id) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = DBConnection.DbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1,doctor.getName());
            ps.setString(2,doctor.getSpecialty());
            ps.setDouble(3,doctor.getDoctorFee());
            ps.setInt(4, doctor.getDepartmentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Doctors
 public void viewDoctors() {
        String sql = "SELECT * FROM doctor";
        try (
            Connection conn = DBConnection.DbConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {
                System.out.println("Doctor ID: " + rs.getInt("doctor_id"));
                System.out.println("Name " + rs.getString("name"));
                System.out.println("Specialty " + rs.getString("specialty"));
                System.out.println("Doctor Fee" + rs.getDouble("doctor_fee"));
                System.out.println("Department ID " + rs.getInt("department_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
