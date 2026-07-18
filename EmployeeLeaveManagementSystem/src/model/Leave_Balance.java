package model;

public class Leave_Balance {
	
	  private int balanceId;
	    private int employeeId;
	    private int totalLeave;
	    private int usedLeave;
	    private int remainingLeave;

	    // Default Constructor
	    public Leave_Balance() {

	    }

	    // Parameterized Constructor (Without balanceId)
	    public Leave_Balance(int employeeId, int totalLeave,
	                        int usedLeave, int remainingLeave) {

	        this.employeeId = employeeId;
	        this.totalLeave = totalLeave;
	        this.usedLeave = usedLeave;
	        this.remainingLeave = remainingLeave;
	    }

	    // Parameterized Constructor (With balanceId)
	    public Leave_Balance(int balanceId, int employeeId,
	                        int totalLeave, int usedLeave,
	                        int remainingLeave) {

	        this.balanceId = balanceId;
	        this.employeeId = employeeId;
	        this.totalLeave = totalLeave;
	        this.usedLeave = usedLeave;
	        this.remainingLeave = remainingLeave;
	    }

	    // Getters and Setters

	    public int getBalanceId() {
	        return balanceId;
	    }

	    public void setBalanceId(int balanceId) {
	        this.balanceId = balanceId;
	    }

	    public int getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(int employeeId) {
	        this.employeeId = employeeId;
	    }

	    public int getTotalLeave() {
	        return totalLeave;
	    }

	    public void setTotalLeave(int totalLeave) {
	        this.totalLeave = totalLeave;
	    }

	    public int getUsedLeave() {
	        return usedLeave;
	    }

	    public void setUsedLeave(int usedLeave) {
	        this.usedLeave = usedLeave;
	    }

	    public int getRemainingLeave() {
	        return remainingLeave;
	    }

	    public void setRemainingLeave(int remainingLeave) {
	        this.remainingLeave = remainingLeave;
	    }

	    @Override
	    public String toString() {
	        return "LeaveBalance [balanceId=" + balanceId
	                + ", employeeId=" + employeeId
	                + ", totalLeave=" + totalLeave
	                + ", usedLeave=" + usedLeave
	                + ", remainingLeave=" + remainingLeave + "]";
	    }

}
