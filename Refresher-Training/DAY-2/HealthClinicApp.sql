CREATE DATABASE health_clinic;

USE health_clinic;

CREATE TABLE patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone  VARCHAR(15),
    dob DATE
);

CREATE TABLE doctor (
    doctor_id  INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialty VARCHAR(50)
);


CREATE TABLE appointment (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status VARCHAR(20) DEFAULT 'Scheduled',
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);

INSERT INTO patient(name, phone, dob) VALUES 
('Ravi Kumar', '9876500000', '1990-01-01'),
('Meena S',     '9123400000', '1988-05-05');

INSERT INTO doctor (name, specialty) VALUES
('Dr. Anita',  'Cardiology'),
('Dr. Suresh', 'Orthopedic');

INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES
 (1, 1, '2026-08-05 10:00:00', 'Scheduled'),
 (1, 2, '2026-08-06 11:30:00', 'Scheduled'),
 (2, 1, '2026-08-07 09:00:00', 'Scheduled');
 
 -- WE CANNOT ADD THE DOCTOR_ID IN PATIENT TBALE BECAUSE IT DISTURB THE STRUCTURE OF THE TABLE 
 -- AND WE NEED TO CREATE MULTIPLE COLUMNS 

-- show dr name and patient name with appointment date 
SELECT p.name as patient, d.name as doctor, a.appointment_date
FROM appointment as  a
INNER JOIN patient as p
on a.patient_id = p.patient_id
JOIN doctor as d
ON a.doctor_id=d.doctor_id
ORDER BY a.appointment_date;


-- to perform normalization create bad tables 

CREATE TABLE appointment_bad (
    appt_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(100),
    patient_phone VARCHAR(15),
    doctor_name VARCHAR(100),
    doctor_specialty VARCHAR(50),
    appt_date DATETIME
);


INSERT INTO appointment_bad 
(patient_name, patient_phone, doctor_name, doctor_specialty, appt_date) VALUES
    ('Ravi Kumar', '9876500000', 'Dr. Anita',  'Cardiology', '2026-08-05 10:00:00'),
    ('Ravi Kumar', '9876500000', 'Dr. Suresh', 'Orthopedic', '2026-08-06 11:30:00'),
    ('Meena S',    '9123400000', 'Dr. Anita',  'Cardiology', '2026-08-07 09:00:00');

SELECT * FROM appointment_bad;


SET SQL_SAFE_UPDATES = 0;

UPDATE appointment_bad
SET patient_phone = '9993923999'
WHERE patient_name = 'Ravi Kumar';
SELECT ROW_COUNT(); 

UPDATE patient
SET phone = '9999999999'
WHERE name = 'Ravi Kumar';
SELECT ROW_COUNT(); 

-- creating transitive dependency in doctor

ALTER TABLE doctor ADD COLUMN department_name VARCHAR(50);
UPDATE doctor SET department_name = 'Cardiology Dept' WHERE specialty = 'Cardiology';
UPDATE doctor SET department_name = 'Ortho Dept' WHERE specialty = 'Orthopedic';

SELECT * FROM doctor;

-- removing this using 3 NF 

CREATE TABLE department (
    department_id   INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50) NOT NULL
);

-- =======================

ALTER TABLE doctor
DROP COLUMN department_name;

ALTER TABLE doctor ADD COLUMN department_id INT;

INSERT INTO department(department_name) VALUES 
('Cardiology Dept'), ('Ortho Dept');

UPDATE doctor SET department_id = 1 WHERE specialty = 'Cardiology';
UPDATE doctor SET department_id = 2 WHERE specialty = 'Orthopedic';

UPDATE department SET department_name = 'Cardiology Department' WHERE department_id = 1;

-- =========================

ALTER TABLE doctor 
ADD CONSTRAINT fk_doctor_department
FOREIGN KEY(department_id)
REFERENCES department(department_id);

ALTER TABLE doctor
DROP FOREIGN KEY fk_doctor_department;

-- ========================= INDEXING 

DELIMITER //
CREATE PROCEDURE seed_appointments(IN n INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i < n DO
        INSERT INTO appointment (patient_id, doctor_id, appointment_date, status)
        VALUES (
            1 + FLOOR(RAND() * 2),
            1 + FLOOR(RAND() * 2),
            DATE_ADD('2026-01-01', INTERVAL FLOOR(RAND()*365) DAY),
            'Scheduled'
        );
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;


SELECT *FROM  appointment;

CALL seed_appointments(50000);

DELETE FROM appointment WHERE patient_id = 1;
ALTER TABLE appointment AUTO_INCREMENT = 4;

-- ====
  
  SELECT * FROM appointment WHERE patient_id = 1;
  
CREATE INDEX idx_appointment_patient ON appointment(patient_id);
SELECT *FROM  appointment;


-- extra things=================
DROP INDEX idx_appointment_patient ON appointment;
SHOW CREATE TABLE department;
-- ==============


EXPLAIN
SELECT * FROM appointment
WHERE doctor_id = 1 AND appointment_date > '2026-06-01';

CREATE INDEX idx_doctor_date ON appointment(doctor_id, appointment_date);

EXPLAIN
SELECT * FROM appointment
WHERE doctor_id = 1 AND appointment_date > '2026-06-01';


-- ========== CLAUSE
-- starts with r
SELECT * FROM patient where name LIKE'R%';

-- ends with s
SELECT * FROM patient where name LIKE'%S';

SELECT * FROM patient where name LIKE'%avi%';
SELECT * FROM patient where name LIKE'_a%';

SELECT * FROM appointment where appointment_date BETWEEN '2026-08-05' AND '2026-08-07';
 
  
SELECT * FROM patient
WHERE patient_id IN (1,2);

-- increasing 
SELECT * FROM patient
ORDER BY name;
-- decreasing
SELECT * FROM patient
ORDER BY name DESC;


-- UNIQUE SPECIALTY
SELECT DISTINCT specialty
FROM doctor;

SELECT COUNT(*) AS total_patient FROM appointment;


SELECT doctor_id, COUNT(*) AS total_appointment FROM appointment 
GROUP BY doctor_id;



SELECT patient_id , COUNT(*) as total_appointment FROM appointment GROUP BY patient_id;



SELECT patient_id , COUNT(*) as total_appointment FROM appointment GROUP BY patient_id
HAVING COUNT(*)>1;

SELECT * FROM appointment
WHERE doctor_id = 1 AND appointment_date > '2026-06-01';

SELECT * FROM appointment
WHERE doctor_id = 1 OR patient_id = 2;

SELECT * FROM appointment WHERE NOT status = 'Scheduled';

SELECT name AS PatientName FROM patient;

-- ================================================================================


-- doctor with appointment numbers 

SELECT d.name AS doctor_name, COUNT(a.appointment_id) 
FROM doctor as d inner JOIN  appointment as a 
ON d.doctor_id = a.doctor_id
GROUP BY d.doctor_id, d.name
;

INSERT INTO department(department_name) VALUES 
('Dermatology'), ('Neurology') , ('Psychiatry'), ('Dentistry');





-- =================================================

SHOW TABLES;

SELECT * FROM doctor;

INSERT INTO patient (name, phone, dob) VALUES
    ('Samar', '9876500000', '1990-01-03'),
    ('harshit',     '1234567890', '1988-05-04'),
      ('ritik', '9875500000', '1990-01-01'),
    ('kartik',     '9090909090', '1988-05-04');
    
INSERT INTO doctor (name, specialty,department_id) VALUES
    ('Dr. shanti',  'Dermatology'),
    ('Dr. keshav', 'Neurology'),
     ('Dr. abhi',  'Psychiatry'),
    ('Dr. dev', 'Dentistry');
    
INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES
    (99999, 1, '2026-08-05 10:00:00', 'Pending'),
    (99923, 2, '2026-08-06 11:30:00', 'Pending ');
   
SELECT * FROM appointment WHERE appointment_date = '2026-08-05';

SELECT doctor_id, COUNT(*) TOTAL FROM appointment GROUP BY doctor_id ORDER BY TOTAL  LIMIT 1;

ALTER TABLE doctor ADD COLUMN doctor_fee DOUBLE(10,2) NOT NULL;

UPDATE doctor SET department_id = doctor_id WHERE doctor_id>2;

SHOW CREATE TABLE doctor;