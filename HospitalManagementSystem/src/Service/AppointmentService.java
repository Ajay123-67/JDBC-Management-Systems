package Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import dao.AppointmentDAO;
import model.Appointment;

public class AppointmentService {
	 Scanner sc = new Scanner(System.in);
	    AppointmentDAO appointmentDAO = new AppointmentDAO();

	    // Book Appointment
	    public void bookAppointment() {

	        Appointment appointment = new Appointment();

	        System.out.println("\n===== Book Appointment =====");

	        System.out.print("Enter Patient ID : ");
	        appointment.setPatientId(sc.nextInt());

	        System.out.print("Enter Doctor ID : ");
	        appointment.setDoctorId(sc.nextInt());
	        sc.nextLine();

	        System.out.print("Enter Appointment Date (yyyy-mm-dd) : ");
	        String date = sc.nextLine();
	        appointment.setAppointmentDate(Date.valueOf(date));

	        System.out.print("Enter Appointment Time (HH:mm:ss) : ");
	        String time = sc.nextLine();
	        appointment.setAppointmentTime(Time.valueOf(time));

	        appointment.setStatus("Booked");

	        appointmentDAO.bookAppointment(appointment);
	    }

	    // Update Appointment
	    public void updateAppointment() {

	        Appointment appointment = new Appointment();

	        System.out.print("Enter Appointment ID : ");
	        appointment.setAppointmentId(sc.nextInt());

	        System.out.print("Enter Patient ID : ");
	        appointment.setPatientId(sc.nextInt());

	        System.out.print("Enter Doctor ID : ");
	        appointment.setDoctorId(sc.nextInt());
	        sc.nextLine();

	        System.out.print("Enter Appointment Date (yyyy-mm-dd) : ");
	        String date = sc.nextLine();
	        appointment.setAppointmentDate(Date.valueOf(date));

	        System.out.print("Enter Appointment Time (HH:mm:ss) : ");
	        String time = sc.nextLine();
	        appointment.setAppointmentTime(Time.valueOf(time));

	        System.out.print("Enter Status : ");
	        appointment.setStatus(sc.nextLine());

	        appointmentDAO.updateAppointment(appointment);
	    }

	    // Cancel Appointment
	    public void cancelAppointment() {

	        System.out.print("Enter Appointment ID : ");
	        int appointmentId = sc.nextInt();

	        appointmentDAO.deleteAppointment(appointmentId);
	    }

	    // Search Appointment
	    public void searchAppointment() {

	        System.out.print("Enter Appointment ID : ");
	        int appointmentId = sc.nextInt();

	        Appointment appointment = appointmentDAO.searchAppointment(appointmentId);

	        if (appointment != null) {
	            System.out.println("\nAppointment Details");
	            System.out.println(appointment);
	        }
	    }

	    // View All Appointments
	    public void viewAllAppointments() {

	        appointmentDAO.viewAllAppointments();
	    }

	    // View Appointment Details using JOIN
	    public void viewAppointmentDetails() {

	        appointmentDAO.viewAppointmentDetails();
	    }

	    // Update Appointment Status
	    public void updateAppointmentStatus() {

	        System.out.print("Enter Appointment ID : ");
	        int appointmentId = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter New Status (Booked/Completed/Cancelled) : ");
	        String status = sc.nextLine();

	        appointmentDAO.updateStatus(appointmentId, status);
	    }

}
