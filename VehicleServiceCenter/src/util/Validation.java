package util;

import java.util.regex.Pattern;

public class Validation {

    // Validate Customer Name
    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z ]{3,50}");
    }

    // Validate Phone Number (10 digits)
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("[6-9][0-9]{9}");
    }

    // Validate Email
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(regex, email);
    }

    // Validate Address
    public static boolean isValidAddress(String address) {
        return address != null && address.trim().length() >= 5;
    }

    // Validate Vehicle Number (Example: AP39AB1234)
    public static boolean isValidVehicleNumber(String vehicleNumber) {
        String regex = "^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$";
        return vehicleNumber != null &&
               Pattern.matches(regex, vehicleNumber.toUpperCase());
    }

    // Validate Vehicle Brand
    public static boolean isValidBrand(String brand) {
        return brand != null && brand.matches("[A-Za-z ]{2,30}");
    }

    // Validate Vehicle Model
    public static boolean isValidModel(String model) {
        return model != null && model.trim().length() >= 2;
    }

    // Validate Manufacture Year
    public static boolean isValidYear(int year) {
        return year >= 1980 && year <= 2035;
    }

    // Validate Service Type
    public static boolean isValidServiceType(String serviceType) {
        return serviceType != null && serviceType.trim().length() >= 3;
    }

    // Validate Service Cost
    public static boolean isValidCost(double cost) {
        return cost > 0;
    }

    // Validate Service Status
    public static boolean isValidStatus(String status) {

        if (status == null)
            return false;

        status = status.trim().toLowerCase();

        return status.equals("pending")
                || status.equals("in progress")
                || status.equals("completed");
    }
}
