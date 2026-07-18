package model;

import java.sql.Date;

public class Employee {
	
	private int employeeId;
    private String employeeName;
    private String email;
    private String department;
    private Date joiningDate;

    // Default Constructor
    public Employee() {

    }

    // Parameterized Constructor (without employeeId)
    public Employee(String employeeName, String email,
                    String department, Date joiningDate) {

        this.employeeName = employeeName;
        this.email = email;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    // Parameterized Constructor (with employeeId)
    public Employee(int employeeId, String employeeName,
                    String email, String department,
                    Date joiningDate) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    // Getters and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId +
                ", employeeName=" + employeeName +
                ", email=" + email +
                ", department=" + department +
                ", joiningDate=" + joiningDate + "]";
    }

}
