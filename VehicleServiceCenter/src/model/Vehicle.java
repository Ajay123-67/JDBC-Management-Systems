package model;

public class Vehicle {

    private int vehicleId;
    private int customerId;
    private String vehicleNumber;
    private String brand;
    private String model;
    private int manufactureYear;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, int customerId,
            String vehicleNumber,
            String brand,
            String model,
            int manufactureYear) {

 this.vehicleId = vehicleId;
 this.customerId = customerId;
 this.vehicleNumber = vehicleNumber;
 this.brand = brand;
 this.model = model;
 this.manufactureYear = manufactureYear;
}

    public Vehicle(int customerId, String vehicleNumber,
                   String brand, String model, int manufactureYear) {
        this.customerId = customerId;
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    @Override
    public String toString() {
        return "Vehicle ID : " + vehicleId +
                "\nCustomer ID : " + customerId +
                "\nVehicle Number : " + vehicleNumber +
                "\nBrand : " + brand +
                "\nModel : " + model +
                "\nManufacture Year : " + manufactureYear;
    }
}
