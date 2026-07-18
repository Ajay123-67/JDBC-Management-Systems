package util;

import java.sql.Date;
import java.util.regex.Pattern;

public class Validation {
	// Validate Employee Name
    public static boolean isValidName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return Pattern.matches("[A-Za-z ]{3,50}", name);
    }

    // Validate Email
    public static boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(emailRegex, email);
    }

    // Validate Department
    public static boolean isValidDepartment(String department) {

        if (department == null || department.trim().isEmpty()) {
            return false;
        }

        return Pattern.matches("[A-Za-z ]{2,30}", department);
    }

    // Validate Leave Type
    public static boolean isValidLeaveType(String leaveType) {

        if (leaveType == null || leaveType.trim().isEmpty()) {
            return false;
        }

        return leaveType.equalsIgnoreCase("Casual Leave")
                || leaveType.equalsIgnoreCase("Sick Leave")
                || leaveType.equalsIgnoreCase("Earned Leave")
                || leaveType.equalsIgnoreCase("Maternity Leave")
                || leaveType.equalsIgnoreCase("Paternity Leave");
    }

    // Validate Reason
    public static boolean isValidReason(String reason) {

        return reason != null
                && reason.trim().length() >= 5
                && reason.trim().length() <= 200;
    }

    // Validate Date Range
    public static boolean isValidDateRange(Date fromDate, Date toDate) {

        if (fromDate == null || toDate == null) {
            return false;
        }

        return !fromDate.after(toDate);
    }

    // Validate Employee ID
    public static boolean isValidEmployeeId(int employeeId) {

        return employeeId > 0;
    }

    // Validate Leave ID
    public static boolean isValidLeaveId(int leaveId) {

        return leaveId > 0;
    }

}
