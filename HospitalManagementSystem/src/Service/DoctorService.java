package Service;

import java.util.Scanner;

import Util.Validation;
import dao.DoctorDAO;
import model.Doctor;

public class DoctorService {


    Scanner sc = new Scanner(System.in);
    DoctorDAO doctorDAO = new DoctorDAO();

    // Add Doctor
    public void addDoctor() {

        Doctor doctor = new Doctor();

        System.out.println("\n===== Add Doctor =====");

        System.out.print("Enter Doctor Name : ");
        String name = sc.nextLine();

        if (!Validation.isValidName(name)) {
            System.out.println("Invalid Doctor Name.");
            return;
        }
        doctor.setDoctorName(name);

        System.out.print("Enter Specialization : ");
        String specialization = sc.nextLine();

        if (!Validation.isValidSpecialization(specialization)) {
            System.out.println("Invalid Specialization.");
            return;
        }
        doctor.setSpecialization(specialization);

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        if (!Validation.isValidPhone(phone)) {
            System.out.println("Invalid Phone Number.");
            return;
        }
        doctor.setPhone(phone);

        System.out.print("Enter Experience (Years) : ");
        int experience = sc.nextInt();
        sc.nextLine();

        doctor.setExperience(experience);

        doctorDAO.addDoctor(doctor);
    }

    // Update Doctor
    public void updateDoctor() {

        Doctor doctor = new Doctor();

        System.out.print("Enter Doctor ID : ");
        doctor.setDoctorId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter New Doctor Name : ");
        String name = sc.nextLine();

        if (!Validation.isValidName(name)) {
            System.out.println("Invalid Doctor Name.");
            return;
        }
        doctor.setDoctorName(name);

        System.out.print("Enter Specialization : ");
        String specialization = sc.nextLine();

        if (!Validation.isValidSpecialization(specialization)) {
            System.out.println("Invalid Specialization.");
            return;
        }
        doctor.setSpecialization(specialization);

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        if (!Validation.isValidPhone(phone)) {
            System.out.println("Invalid Phone Number.");
            return;
        }
        doctor.setPhone(phone);

        System.out.print("Enter Experience : ");
        doctor.setExperience(sc.nextInt());

        doctorDAO.updateDoctor(doctor);
    }

    // Delete Doctor
    public void deleteDoctor() {

        System.out.print("Enter Doctor ID : ");
        int doctorId = sc.nextInt();

        doctorDAO.deleteDoctor(doctorId);
    }

    // Search Doctor
    public void searchDoctor() {

        System.out.print("Enter Doctor ID : ");
        int doctorId = sc.nextInt();

        Doctor doctor = doctorDAO.searchDoctor(doctorId);

        if (doctor != null) {
            System.out.println("\nDoctor Details");
            System.out.println(doctor);
        }
    }

    // View All Doctors
    public void viewAllDoctors() {

        doctorDAO.viewAllDoctors();
    }
}
