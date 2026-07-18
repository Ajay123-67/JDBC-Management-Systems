package model;

import java.sql.Date;

public class Leave_Requests {
	private int leaveId;
    private int employeeId;
    private String leaveType;
    private Date fromDate;
    private Date toDate;
    private String reason;
    private String status;

    // Default Constructor
    public Leave_Requests() {

    }

    // Parameterized Constructor (Without leaveId)
    public Leave_Requests(int employeeId, String leaveType,
                        Date fromDate, Date toDate,
                        String reason, String status) {

        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }

    // Parameterized Constructor (With leaveId)
    public Leave_Requests(int leaveId, int employeeId,
                        String leaveType, Date fromDate,
                        Date toDate, String reason,
                        String status) {

        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }

    // Getters and Setters

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeaveRequest [leaveId=" + leaveId +
                ", employeeId=" + employeeId +
                ", leaveType=" + leaveType +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", reason=" + reason +
                ", status=" + status + "]";
    }

}
