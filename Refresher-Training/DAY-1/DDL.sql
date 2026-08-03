-- Create Database
CREATE DATABASE bharat_company;

-- Show All Databases
SHOW DATABASES;

-- Select Database
USE bharat_company;

-- Create Employee Table
CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    mobile_no CHAR(10),
    city VARCHAR(30) DEFAULT 'Bhopal',
    salary DECIMAL(10,2) CHECK (salary >= 15000)
);

-- Show All Tables
SHOW TABLES;

-- Create Department Table
CREATE TABLE department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

-- Describe Department Table
DESC department;

-- Create Employee Details Table with Foreign Key
CREATE TABLE employee_details (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);


-- Add Single Column

ALTER TABLE employee
ADD gender VARCHAR(10);


-- Add Multiple Columns
ALTER TABLE employee
ADD age INT,
ADD joining_date DATE;



-- Modify Column Data Type
ALTER TABLE employee
MODIFY emp_name VARCHAR(100);



-- Rename Column
ALTER TABLE employee
CHANGE COLUMN emp_name  employee_name VARCHAR(100);

SELECT VERSION();

-- Drop Single Column
ALTER TABLE employee
DROP COLUMN gender;



-- Drop Multiple Columns
ALTER TABLE employee
DROP COLUMN age,
DROP COLUMN joining_date;


-- Create Student Table
CREATE TABLE student (
    student_id INT,
    student_name VARCHAR(50)
);

-- Add Primary Key
ALTER TABLE student
ADD PRIMARY KEY(student_id);



-- Add  Constraint
ALTER TABLE employee
ADD CHECK(salary >= 20000);

-- Add Department ID Column
ALTER TABLE student
ADD dept_id INT;

-- Add Foreign Key
ALTER TABLE student
ADD CONSTRAINT fk_department
FOREIGN KEY(dept_id)
REFERENCES department(dept_id);

-- Drop Foreign Key
ALTER TABLE student
DROP FOREIGN KEY fk_department;

-- Rename Table
RENAME TABLE student TO students;

-- Show All Tables
SHOW TABLES;

-- Rename Table Using ALTER
ALTER TABLE students
RENAME TO college_students;

-- Show All Tables
SHOW TABLES;

-- Remove All Records from Employee Table
TRUNCATE TABLE employee;

-- Delete Employee Details Table
DROP TABLE employee_details;

-- Delete Multiple Tables
DROP TABLE employee, department, college_students;

-- Delete Database
DROP DATABASE bharat_company;