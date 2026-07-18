package service;

import java.time.temporal.ChronoUnit;

import dao.LeaveBalanceDao;
import dao.LeaveRequestDao;
import model.Leave_Balance;
import model.Leave_Requests;

public class LeaveService {

    private LeaveRequestDao leaveDAO = new LeaveRequestDao();
    private LeaveBalanceDao balanceDAO = new LeaveBalanceDao();

    // Apply Leave
    public boolean applyLeave(Leave_Requests leave) {

        Leave_Balance balance =
                balanceDAO.getLeaveBalance(leave.getEmployeeId());

        if (balance == null) {
            System.out.println("Leave Balance Not Found.");
            return false;
        }

        long days = ChronoUnit.DAYS.between(
                leave.getFromDate().toLocalDate(),
                leave.getToDate().toLocalDate()) + 1;

        if (days > balance.getRemainingLeave()) {

            System.out.println("Insufficient Leave Balance.");

            return false;
        }

        leave.setStatus("Pending");

        return leaveDAO.applyLeave(leave);
    }

    // View Leave Requests
    public void viewLeaveRequests() {

        for (Leave_Requests leave : leaveDAO.getAllLeaveRequests()) {
            System.out.println(leave);
        }
    }

    // Approve Leave
    public boolean approveLeave(int leaveId) {

        Leave_Requests leave = leaveDAO.getLeaveById(leaveId);

        if (leave == null) {
            return false;
        }

        Leave_Balance balance =
                balanceDAO.getLeaveBalance(leave.getEmployeeId());

        long days = ChronoUnit.DAYS.between(
                leave.getFromDate().toLocalDate(),
                leave.getToDate().toLocalDate()) + 1;

        int used =
                balance.getUsedLeave() + (int) days;

        int remaining =
                balance.getRemainingLeave() - (int) days;

        boolean approved =
                leaveDAO.approveLeave(leaveId);

        if (approved) {

            balanceDAO.updateLeaveBalance(
                    leave.getEmployeeId(),
                    used,
                    remaining);

            return true;
        }

        return false;
    }

    // Reject Leave
    public boolean rejectLeave(int leaveId) {

        return leaveDAO.rejectLeave(leaveId);
    }

    // View Leave Balance
    public void viewLeaveBalance(int employeeId) {

        Leave_Balance balance =
                balanceDAO.getLeaveBalance(employeeId);

        if (balance != null) {
            System.out.println(balance);
        } else {
            System.out.println("No Leave Balance Found.");
        }
    }

}
