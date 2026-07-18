package Service;

import java.util.Scanner;

import dao.PrescriptionDAO;
import model.Presription;

public class PrescriptionService {
	Scanner sc = new Scanner(System.in);
    PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    // Add Prescription
    public void addPrescription() {

        Presription prescription = new Presription();

        System.out.println("\n===== Add Prescription =====");

        System.out.print("Enter Appointment ID : ");
        prescription.setAppointmentId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Medicine Name : ");
        prescription.setMedicine(sc.nextLine());

        System.out.print("Enter Dosage : ");
        prescription.setDosage(sc.nextLine());

        System.out.print("Enter Remarks : ");
        prescription.setRemarks(sc.nextLine());

        prescriptionDAO.addPrescription(prescription);
    }

    // Update Prescription
    public void updatePrescription() {

        Presription prescription = new Presription();

        System.out.print("Enter Prescription ID : ");
        prescription.setPrescriptionId(sc.nextInt());

        System.out.print("Enter Appointment ID : ");
        prescription.setAppointmentId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Medicine Name : ");
        prescription.setMedicine(sc.nextLine());

        System.out.print("Enter Dosage : ");
        prescription.setDosage(sc.nextLine());

        System.out.print("Enter Remarks : ");
        prescription.setRemarks(sc.nextLine());

        prescriptionDAO.updatePrescription(prescription);
    }

    // Delete Prescription
    public void deletePrescription() {

        System.out.print("Enter Prescription ID : ");
        int prescriptionId = sc.nextInt();

        prescriptionDAO.deletePrescription(prescriptionId);
    }

    // Search Prescription
    public void searchPrescription() {

        System.out.print("Enter Prescription ID : ");
        int prescriptionId = sc.nextInt();

        Presription prescription = prescriptionDAO.searchPrescription(prescriptionId);

        if (prescription != null) {
            System.out.println("\n===== Prescription Details =====");
            System.out.println(prescription);
        }
    }

    // View All Prescriptions
    public void viewAllPrescriptions() {

        prescriptionDAO.viewAllPrescriptions();
    }

    // View Prescription Report (JOIN)
    public void viewPrescriptionReport() {

        prescriptionDAO.viewPrescriptionDetails();
    }

}
