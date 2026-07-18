package service;

import dao.VehicleDAO;
import model.Vehicle;
import util.Validation;

import java.util.ArrayList;

public class VehicleService {

    private VehicleDAO vehicleDAO = new VehicleDAO();

    public void addVehicle(Vehicle vehicle) {

        if (!Validation.isValidVehicleNumber(vehicle.getVehicleNumber())) {
            System.out.println("Invalid Vehicle Number.");
            return;
        }

        if (!Validation.isValidBrand(vehicle.getBrand())) {
            System.out.println("Invalid Brand.");
            return;
        }

        if (!Validation.isValidModel(vehicle.getModel())) {
            System.out.println("Invalid Model.");
            return;
        }

        if (!Validation.isValidYear(vehicle.getManufactureYear())) {
            System.out.println("Invalid Manufacture Year.");
            return;
        }

        if (vehicleDAO.addVehicle(vehicle))
            System.out.println("Vehicle Registered Successfully.");
        else
            System.out.println("Failed to Register Vehicle.");
    }

    public void viewVehicles() {

        ArrayList<Vehicle> list = vehicleDAO.getAllVehicles();

        if (list.isEmpty()) {
            System.out.println("No Vehicles Found.");
        } else {
            for (Vehicle vehicle : list) {
                System.out.println(vehicle);
                System.out.println("----------------------------");
            }
        }
    }

    public void searchVehicle(String vehicleNumber) {

        Vehicle vehicle = vehicleDAO.searchVehicle(vehicleNumber);

        if (vehicle != null)
            System.out.println(vehicle);
        else
            System.out.println("Vehicle Not Found.");
    }

    public void updateVehicle(Vehicle vehicle) {

        if (vehicleDAO.updateVehicle(vehicle))
            System.out.println("Vehicle Updated Successfully.");
        else
            System.out.println("Update Failed.");
    }

    public void deleteVehicle(int id) {

        if (vehicleDAO.deleteVehicle(id))
            System.out.println("Vehicle Deleted Successfully.");
        else
            System.out.println("Vehicle Not Found.");
    }
}