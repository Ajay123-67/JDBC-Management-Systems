package service;

import dao.EmployeeDao;
import dao.LeaveBalanceDao;
import model.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDAO = new EmployeeDao();
    private LeaveBalanceDao leaveBalanceDAO = new LeaveBalanceDao();

    // Register Employee
    public boolean registerEmployee(Employee employee) {

        boolean employeeAdded = employeeDAO.addEmployee(employee);

        if (employeeAdded) {

            // Get newly added employee
            Employee emp = employeeDAO.getEmployeeById(
                    employeeDAO.getLastInsertedEmployeeId());

            if (emp != null) {
                leaveBalanceDAO.createLeaveBalance(emp.getEmployeeId());
            }

            return true;
        }

        return false;
    }

    // View All Employees
    public void viewEmployees() {
        employeeDAO.viewAllEmployees();
    }

    // Search Employee
    public Employee searchEmployee(int employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    // Update Employee
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    // Delete Employee
    public boolean deleteEmployee(int employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }

}
