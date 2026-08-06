-- Create Database
CREATE DATABASE IF NOT EXISTS JdbcHealthClinicApp;

USE JdbcHealthClinicApp;

-- ==========================
-- Department Table
-- ==========================
CREATE TABLE department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL UNIQUE
);

-- ==========================
-- Doctor Table
-- ==========================
CREATE TABLE doctor (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(100) NOT NULL,
    doctor_fee DECIMAL(10,2) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id)
    REFERENCES department(department_id)
);

-- ==========================
-- Patient Table
-- ==========================
CREATE TABLE patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    dob DATE NOT NULL
);

-- ==========================
-- Appointment Table
-- ==========================
CREATE TABLE appointment (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status VARCHAR(30) DEFAULT 'Scheduled',

    FOREIGN KEY (patient_id)
    REFERENCES patient(patient_id),

    FOREIGN KEY (doctor_id)
    REFERENCES doctor(doctor_id)
);

DELIMITER $$

CREATE PROCEDURE getAllPatients()
BEGIN
    SELECT * FROM patient;
END $$

DELIMITER ;

-- create delete trigger in patient table
CREATE TABLE patient_log (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(100),
    deleted_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER $$

CREATE TRIGGER patientDeleteLog
AFTER DELETE
ON patient
FOR EACH ROW
BEGIN
    INSERT INTO patient_log(patient_name)
    VALUES(OLD.name);
END $$

DELIMITER ;
