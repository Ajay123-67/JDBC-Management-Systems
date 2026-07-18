CREATE DATABASE hospital_db;
USE hospital_db;
CREATE TABLE patients
(
patient_id INT PRIMARY KEY AUTO_INCREMENT,
patient_name VARCHAR(100),
gender VARCHAR(10),
age INT,
phone VARCHAR(15),
address VARCHAR(200)
);

CREATE TABLE doctors
(
doctor_id INT PRIMARY KEY AUTO_INCREMENT,
doctor_name VARCHAR(100),
specialization VARCHAR(100),
phone VARCHAR(15),
experience INT
);
CREATE TABLE appointments
(
appointment_id INT PRIMARY KEY AUTO_INCREMENT,
patient_id INT,
doctor_id INT,
appointment_date DATE,
appointment_time TIME,
status VARCHAR(30),
FOREIGN KEY(patient_id)
REFERENCES patients(patient_id)
);
CREATE TABLE prescriptions
(
prescription_id INT PRIMARY KEY AUTO_INCREMENT,
appointment_id INT,
medicine VARCHAR(200),
dosage VARCHAR(100),
remarks VARCHAR(300),
FOREIGN KEY(appointment_id)
REFERENCES appointments(appointment_id)
);
INSERT INTO patients(patient_name,gender,age,phone,address)
VALUES
('Ajay','Male',22,'9876543210','Hyderabad'),
('Ravi','Male',30,'9876543211','Vijayawada');
INSERT INTO doctors(doctor_name,specialization,phone,experience)
VALUES
('Dr. Kumar','Cardiologist','9000000011',10),
('Dr. Reddy','Dentist','9000000012',8);