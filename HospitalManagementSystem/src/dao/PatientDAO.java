package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Patient;

public class PatientDAO {
	
	// Insert Patient
    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO patients(patient_name, gender, age, phone, address) VALUES(?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setString(2, patient.getGender());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Registered Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update Patient
    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE patients SET patient_name=?, gender=?, age=?, phone=?, address=? WHERE patient_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setString(2, patient.getGender());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setInt(6, patient.getPatientId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Updated Successfully.");
                return true;
            } else {
                System.out.println("Patient ID Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Patient
    public boolean deletePatient(int patientId) {

        String sql = "DELETE FROM patients WHERE patient_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient Deleted Successfully.");
                return true;
            } else {
                System.out.println("Patient ID Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search Patient By ID
    public Patient searchPatient(int patientId) {

        String sql = "SELECT * FROM patients WHERE patient_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Patient patient = new Patient();

                patient.setPatientId(rs.getInt("patient_id"));
                patient.setPatientName(rs.getString("patient_name"));
                patient.setGender(rs.getString("gender"));
                patient.setAge(rs.getInt("age"));
                patient.setPhone(rs.getString("phone"));
                patient.setAddress(rs.getString("address"));

                return patient;
            } else {
                System.out.println("Patient Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Display All Patients
    public void viewAllPatients() {

        String sql = "SELECT * FROM patients";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== Patient List ==========");

            while (rs.next()) {

                System.out.println("----------------------------------");
                System.out.println("Patient ID   : " + rs.getInt("patient_id"));
                System.out.println("Name         : " + rs.getString("patient_name"));
                System.out.println("Gender       : " + rs.getString("gender"));
                System.out.println("Age          : " + rs.getInt("age"));
                System.out.println("Phone        : " + rs.getString("phone"));
                System.out.println("Address      : " + rs.getString("address"));
            }

            System.out.println("----------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
