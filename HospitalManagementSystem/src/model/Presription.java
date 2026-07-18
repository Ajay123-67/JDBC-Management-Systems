package model;

public class Presription {
	  private int prescriptionId;
	    private int appointmentId;
	    private String medicine;
	    private String dosage;
	    private String remarks;

	    // Default Constructor
	    public Presription() {

	    }

	    // Parameterized Constructor
	    public Presription(int prescriptionId, int appointmentId,
	                        String medicine, String dosage,
	                        String remarks) {

	        this.prescriptionId = prescriptionId;
	        this.appointmentId = appointmentId;
	        this.medicine = medicine;
	        this.dosage = dosage;
	        this.remarks = remarks;
	    }

	    // Getters and Setters

	    public int getPrescriptionId() {
	        return prescriptionId;
	    }

	    public void setPrescriptionId(int prescriptionId) {
	        this.prescriptionId = prescriptionId;
	    }

	    public int getAppointmentId() {
	        return appointmentId;
	    }

	    public void setAppointmentId(int appointmentId) {
	        this.appointmentId = appointmentId;
	    }

	    public String getMedicine() {
	        return medicine;
	    }

	    public void setMedicine(String medicine) {
	        this.medicine = medicine;
	    }

	    public String getDosage() {
	        return dosage;
	    }

	    public void setDosage(String dosage) {
	        this.dosage = dosage;
	    }

	    public String getRemarks() {
	        return remarks;
	    }

	    public void setRemarks(String remarks) {
	        this.remarks = remarks;
	    }

	    @Override
	    public String toString() {
	        return "Prescription [prescriptionId=" + prescriptionId +
	                ", appointmentId=" + appointmentId +
	                ", medicine=" + medicine +
	                ", dosage=" + dosage +
	                ", remarks=" + remarks + "]";
	    }

}
