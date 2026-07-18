package Service;

import java.util.Scanner;

import Util.Validation;
import dao.PatientDAO;
import model.Patient;

public class PatientService {
	Scanner sc = new Scanner(System.in);
    PatientDAO patientDAO = new PatientDAO();

    // Register Patient
    public void registerPatient() {

        Patient patient = new Patient();

        System.out.println("\n===== Patient Registration =====");

        System.out.print("Enter Patient Name : ");
        String name = sc.nextLine();

        if (!Validation.isValidName(name)) {
            System.out.println("Invalid Patient Name.");
            return;
        }
        patient.setPatientName(name);

        System.out.print("Enter Gender (Male/Female) : ");
        patient.setGender(sc.nextLine());

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        if (!Validation.isValidAge(age)) {
            System.out.println("Invalid Age.");
            return;
        }
        patient.setAge(age);

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        if (!Validation.isValidPhone(phone)) {
            System.out.println("Invalid Phone Number.");
            return;
        }
        patient.setPhone(phone);

        System.out.print("Enter Address : ");
        patient.setAddress(sc.nextLine());

        patientDAO.addPatient(patient);
    }

    // Update Patient
    public void updatePatient() {

        Patient patient = new Patient();

        System.out.print("Enter Patient ID : ");
        patient.setPatientId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter New Name : ");
        String name = sc.nextLine();

        if (!Validation.isValidName(name)) {
            System.out.println("Invalid Name.");
            return;
        }
        patient.setPatientName(name);

        System.out.print("Enter Gender : ");
        patient.setGender(sc.nextLine());

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        if (!Validation.isValidAge(age)) {
            System.out.println("Invalid Age.");
            return;
        }
        patient.setAge(age);

        System.out.print("Enter Phone : ");
        String phone = sc.nextLine();

        if (!Validation.isValidPhone(phone)) {
            System.out.println("Invalid Phone Number.");
            return;
        }
        patient.setPhone(phone);

        System.out.print("Enter Address : ");
        patient.setAddress(sc.nextLine());

        patientDAO.updatePatient(patient);
    }

    // Delete Patient
    public void deletePatient() {

        System.out.print("Enter Patient ID : ");
        int id = sc.nextInt();

        patientDAO.deletePatient(id);
    }

    // Search Patient
    public void searchPatient() {

        System.out.print("Enter Patient ID : ");
        int id = sc.nextInt();

        Patient patient = patientDAO.searchPatient(id);

        if (patient != null) {
            System.out.println(patient);
        }
    }

    // View All Patients
    public void viewAllPatients() {

        patientDAO.viewAllPatients();
    }

}
