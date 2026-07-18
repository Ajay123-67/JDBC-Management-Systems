package main;

import java.util.Scanner;

import Service.AppointmentService;
import Service.DoctorService;
import Service.PatientService;
import Service.PrescriptionService;

public class HospitalManagement {

		 public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        PatientService patientService = new PatientService();
		        DoctorService doctorService = new DoctorService();
		        AppointmentService appointmentService = new AppointmentService();
		        PrescriptionService prescriptionService = new PrescriptionService();

		        int choice;

		        do {

		            System.out.println("\n==========================================");
		            System.out.println("      HOSPITAL MANAGEMENT SYSTEM");
		            System.out.println("==========================================");
		            System.out.println("1. Register Patient");
		            System.out.println("2. View All Patients");
		            System.out.println("3. Search Patient");
		            System.out.println("4. Update Patient");
		            System.out.println("5. Delete Patient");
		            System.out.println("------------------------------------------");
		            System.out.println("6. Add Doctor");
		            System.out.println("7. View All Doctors");
		            System.out.println("8. Search Doctor");
		            System.out.println("9. Update Doctor");
		            System.out.println("10. Delete Doctor");
		            System.out.println("------------------------------------------");
		            System.out.println("11. Book Appointment");
		            System.out.println("12. View All Appointments");
		            System.out.println("13. Search Appointment");
		            System.out.println("14. Update Appointment");
		            System.out.println("15. Cancel Appointment");
		            System.out.println("16. Update Appointment Status");
		            System.out.println("17. Appointment Report (JOIN)");
		            System.out.println("------------------------------------------");
		            System.out.println("18. Add Prescription");
		            System.out.println("19. View All Prescriptions");
		            System.out.println("20. Search Prescription");
		            System.out.println("21. Update Prescription");
		            System.out.println("22. Delete Prescription");
		            System.out.println("23. Prescription Report (JOIN)");
		            System.out.println("------------------------------------------");
		            System.out.println("24. Exit");
		            System.out.println("==========================================");

		            System.out.print("Enter Your Choice : ");
		            choice = sc.nextInt();

		            switch (choice) {

		                // Patient Module
		                case 1:
		                    patientService.registerPatient();
		                    break;

		                case 2:
		                    patientService.viewAllPatients();
		                    break;

		                case 3:
		                    patientService.searchPatient();
		                    break;

		                case 4:
		                    patientService.updatePatient();
		                    break;

		                case 5:
		                    patientService.deletePatient();
		                    break;

		                // Doctor Module
		                case 6:
		                    doctorService.addDoctor();
		                    break;

		                case 7:
		                    doctorService.viewAllDoctors();
		                    break;

		                case 8:
		                    doctorService.searchDoctor();
		                    break;

		                case 9:
		                    doctorService.updateDoctor();
		                    break;

		                case 10:
		                    doctorService.deleteDoctor();
		                    break;

		                // Appointment Module
		                case 11:
		                    appointmentService.bookAppointment();
		                    break;

		                case 12:
		                    appointmentService.viewAllAppointments();
		                    break;

		                case 13:
		                    appointmentService.searchAppointment();
		                    break;

		                case 14:
		                    appointmentService.updateAppointment();
		                    break;

		                case 15:
		                    appointmentService.cancelAppointment();
		                    break;

		                case 16:
		                    appointmentService.updateAppointmentStatus();
		                    break;

		                case 17:
		                    appointmentService.viewAppointmentDetails();
		                    break;

		                // Prescription Module
		                case 18:
		                    prescriptionService.addPrescription();
		                    break;

		                case 19:
		                    prescriptionService.viewAllPrescriptions();
		                    break;

		                case 20:
		                    prescriptionService.searchPrescription();
		                    break;

		                case 21:
		                    prescriptionService.updatePrescription();
		                    break;

		                case 22:
		                    prescriptionService.deletePrescription();
		                    break;

		                case 23:
		                    prescriptionService.viewPrescriptionReport();
		                    break;

		                case 24:
		                    System.out.println("\nThank You for Using Hospital Management System.");
		                    break;

		                default:
		                    System.out.println("\nInvalid Choice! Please Try Again.");
		            }

		        } while (choice != 24);

		        sc.close();

	}

}
