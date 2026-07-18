package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Presription;

public class PrescriptionDAO {
	
	// Add Prescription
    public boolean addPrescription(Presription prescription) {

        String sql = "INSERT INTO prescriptions(appointment_id, medicine, dosage, remarks) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, prescription.getAppointmentId());
            ps.setString(2, prescription.getMedicine());
            ps.setString(3, prescription.getDosage());
            ps.setString(4, prescription.getRemarks());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Prescription Added Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update Prescription
    public boolean updatePrescription(Presription prescription) {

        String sql = "UPDATE prescriptions SET appointment_id=?, medicine=?, dosage=?, remarks=? WHERE prescription_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, prescription.getAppointmentId());
            ps.setString(2, prescription.getMedicine());
            ps.setString(3, prescription.getDosage());
            ps.setString(4, prescription.getRemarks());
            ps.setInt(5, prescription.getPrescriptionId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Prescription Updated Successfully.");
                return true;
            } else {
                System.out.println("Prescription ID Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Prescription
    public boolean deletePrescription(int prescriptionId) {

        String sql = "DELETE FROM prescriptions WHERE prescription_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, prescriptionId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Prescription Deleted Successfully.");
                return true;
            } else {
                System.out.println("Prescription ID Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search Prescription by ID
    public Presription searchPrescription(int prescriptionId) {

        String sql = "SELECT * FROM prescriptions WHERE prescription_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, prescriptionId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Presription prescription = new Presription();

                prescription.setPrescriptionId(rs.getInt("prescription_id"));
                prescription.setAppointmentId(rs.getInt("appointment_id"));
                prescription.setMedicine(rs.getString("medicine"));
                prescription.setDosage(rs.getString("dosage"));
                prescription.setRemarks(rs.getString("remarks"));

                return prescription;

            } else {
                System.out.println("Prescription Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // View All Prescriptions
    public void viewAllPrescriptions() {

        String sql = "SELECT * FROM prescriptions";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== Prescription List ==========");

            while (rs.next()) {

                System.out.println("--------------------------------------");
                System.out.println("Prescription ID : " + rs.getInt("prescription_id"));
                System.out.println("Appointment ID  : " + rs.getInt("appointment_id"));
                System.out.println("Medicine        : " + rs.getString("medicine"));
                System.out.println("Dosage          : " + rs.getString("dosage"));
                System.out.println("Remarks         : " + rs.getString("remarks"));
            }

            System.out.println("--------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Prescription Report using JOIN
    public void viewPrescriptionDetails() {

        String sql =
            "SELECT pr.prescription_id, " +
            "p.patient_name, " +
            "d.doctor_name, " +
            "pr.medicine, " +
            "pr.dosage, " +
            "pr.remarks " +
            "FROM prescriptions pr " +
            "JOIN appointments a ON pr.appointment_id = a.appointment_id " +
            "JOIN patients p ON a.patient_id = p.patient_id " +
            "JOIN doctors d ON a.doctor_id = d.doctor_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== Prescription Report ==========");

            while (rs.next()) {

                System.out.println("-------------------------------------------");
                System.out.println("Prescription ID : " + rs.getInt("prescription_id"));
                System.out.println("Patient Name    : " + rs.getString("patient_name"));
                System.out.println("Doctor Name     : " + rs.getString("doctor_name"));
                System.out.println("Medicine        : " + rs.getString("medicine"));
                System.out.println("Dosage          : " + rs.getString("dosage"));
                System.out.println("Remarks         : " + rs.getString("remarks"));
            }

            System.out.println("-------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
