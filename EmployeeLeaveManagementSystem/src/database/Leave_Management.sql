create database leave_management;
use leave_management;
CREATE TABLE employees(
employee_id INT PRIMARY KEY AUTO_INCREMENT,
employee_name VARCHAR(100),
email VARCHAR(100) UNIQUE,
department VARCHAR(50),
joining_date DATE
);

CREATE TABLE leave_balance(
balance_id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT,
total_leave INT,
used_leave INT,
remaining_leave INT,
FOREIGN KEY(employee_id)
REFERENCES employees(employee_id)
);

CREATE TABLE leave_requests(
leave_id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT,
leave_type VARCHAR(30),
from_date DATE,
to_date DATE,
reason VARCHAR(200),
status VARCHAR(20),
FOREIGN KEY(employee_id)
REFERENCES employees(employee_id)
);

