package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Doctor;

public class DoctorDAO {
	// Add Doctor
    public boolean addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors(doctor_name, specialization, phone, experience) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getExperience());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Added Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Update Doctor
    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctors SET doctor_name=?, specialization=?, phone=?, experience=? WHERE doctor_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getExperience());
            ps.setInt(5, doctor.getDoctorId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Updated Successfully.");
                return true;
            } else {
                System.out.println("Doctor ID Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Doctor
    public boolean deleteDoctor(int doctorId) {

        String sql = "DELETE FROM doctors WHERE doctor_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor Deleted Successfully.");
                return true;
            } else {
                System.out.println("Doctor ID Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search Doctor by ID
    public Doctor searchDoctor(int doctorId) {

        String sql = "SELECT * FROM doctors WHERE doctor_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setDoctorName(rs.getString("doctor_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setExperience(rs.getInt("experience"));

                return doctor;

            } else {
                System.out.println("Doctor Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // View All Doctors
    public void viewAllDoctors() {

        String sql = "SELECT * FROM doctors";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== Doctor List ==========");

            while (rs.next()) {

                System.out.println("-----------------------------------");
                System.out.println("Doctor ID       : " + rs.getInt("doctor_id"));
                System.out.println("Doctor Name     : " + rs.getString("doctor_name"));
                System.out.println("Specialization  : " + rs.getString("specialization"));
                System.out.println("Phone           : " + rs.getString("phone"));
                System.out.println("Experience      : " + rs.getInt("experience") + " Years");
            }

            System.out.println("-----------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
