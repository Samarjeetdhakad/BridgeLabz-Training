CREATE DATABASE healthclinic;
USE healthclinic;

CREATE TABLE patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone  VARCHAR(15),
    dob DATE
);

CREATE TABLE doctor (
    doctor_id  INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(50),
    doctor_fee DOUBLE(10,2) NOT NULL
);

ALTER TABLE doctor ADD COLUMN department_id INT;

CREATE TABLE appointment (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status VARCHAR(20) DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);

CREATE TABLE department (
    department_id   INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50) NOT NULL
);

ALTER TABLE doctor 
ADD CONSTRAINT fk_doctor_department
FOREIGN KEY(department_id)
REFERENCES department(department_id);

INSERT INTO patient(name, phone, dob) VALUES 
('Ravi Kumar', '9876500000', '1990-01-01'),
('Meena S',     '9123400000', '1988-05-05'),
('Samar', '9876500000', '1990-01-03'),
('harshit',     '1234567890', '1988-05-04'),
('ritik', '9875500000', '1990-01-01'),
('kartik',     '9090909090', '1988-05-04');

INSERT INTO department(department_name) VALUES 
('Dermatology'), ('Neurology '), ('Psychiatry'),('Dentistry');

INSERT INTO doctor (name, specialty, doctor_fee,department_id) VALUES
('Dr. shanti',  'Dermatology','1000',1),
('Dr. keshav', 'Neurology','500',2),
('Dr. abhi',  'Psychiatry','2500',3),
('Dr. dev', 'Dentistry','1700',4);

INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES
 (1, 1, '2026-08-05 10:00:00', 'Scheduled'),
 (1, 2, '2026-08-06 11:30:00', 'Pending'),
 (2, 1, '2026-08-07 09:00:00', 'Completed'),
(2, 1, '2026-08-05 10:00:00', 'Pending'),
(1, 2, '2026-08-06 11:30:00', 'Pending');


-- ======================================

-- inner join

SELECT 
    p.patient_id,
    p.name AS patient_name,
    d.name AS doctor_name,
    a.appointment_date,
    a.status
FROM patient p
INNER JOIN appointment a
ON p.patient_id = a.patient_id
INNER JOIN doctor d
ON a.doctor_id = d.doctor_id;

-- left join

SELECT
    p.patient_id, p.name AS patient_name, d.name AS doctor_name, a.appointment_date, a.status
FROM patient p
LEFT JOIN appointment a
ON p.patient_id = a.patient_id
LEFT JOIN doctor d
ON a.doctor_id = d.doctor_id; 

-- right

SELECT  p.name AS patient_name, d.name AS doctor_name, a.appointment_date, a.status
FROM patient p
RIGHT JOIN appointment a
ON p.patient_id = a.patient_id
RIGHT JOIN doctor d
ON a.doctor_id = d.doctor_id;


-- full outer join 

SELECT p.name , d.name AS doctor_name, a.appointment_date
FROM patient p
LEFT JOIN appointment a
ON p.patient_id = a.patient_id
LEFT JOIN doctor d
ON a.doctor_id = d.doctor_id

UNION

SELECT p.name AS patient_name, d.name AS doctor_name, a.appointment_date
FROM patient p
RIGHT JOIN appointment a
ON p.patient_id = a.patient_id
RIGHT JOIN doctor d
ON a.doctor_id = d.doctor_id;

-- stored procedure 

DELIMITER //
CREATE PROCEDURE getAllPatients()
BEGIN
    SELECT * from patient;
END//
DELIMITER ;

call getAllPatients();

DROP PROCEDURE IF EXISTS getAllPatients;

DELIMITER //
 CREATE PROCEDURE getpatientbyid(IN id INT)
 BEGIN 
  SELECT * FROM patient WHERE patient_id = id;
  END // 
DELIMITER ;

CALL getpatientbyid(1);


-- triggers 

CREATE TABLE appointment_log ( log_id INT AUTO_INCREMENT PRIMARY KEY, appointment_id INT, message VARCHAR(255), log_time DATETIME);

-- after insert
DELIMITER // 
CREATE TRIGGER after_insert
AFTER INSERT 
ON appointment 
FOR EACH ROW
BEGIN 
   INSERT INTO appointment_log (appointment_id, message, log_time) VALUES
   (NEW.appointment_id, CONCAT('APPOINTMENT BOOKED',NEW.patient_id),NOW());
   END //
DELIMITER ;

INSERT INTO appointment(patient_id, doctor_id, appointment_date, status)
VALUES(3, 2, '2026-08-10 11:00:00','Scheduled');


SELECT  * FROM  appointment_log;


-- before insert 
DELIMITER //
 CREATE TRIGGER before_insert
 BEFORE INSERT 
 ON appointment 
 FOR EACH ROW 
 BEGIN 
	IF NEW.appointment_date < now() THEN 
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'appointment table connot be in the past';
    END IF ;
 END //
 DELIMITER ;

INSERT INTO appointment
(patient_id, doctor_id, appointment_date, status)
VALUES
(1,1,'2025-01-01 10:00:00','Scheduled');


-- AFTER UPDATE 

CREATE TABLE appointment_status_log
(
    id INT AUTO_INCREMENT PRIMARY KEY, old_status VARCHAR(20),
    new_status VARCHAR(20), updated_time DATETIME
);

DELIMITER //

CREATE TRIGGER after_status_update
AFTER UPDATE
ON appointment
FOR EACH ROW
BEGIN

    INSERT INTO appointment_status_log
    (old_status,new_status,updated_time)
    VALUES
    (
	OLD.status,
        NEW.status,
        NOW()
    );
END//
DELIMITER ;

UPDATE appointment
SET status='Completed'
WHERE appointment_id=1;

SELECT * FROM appointment_status_log;


