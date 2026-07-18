package Util;

public class Validation {

	// Validate Name (Only Alphabets and Spaces)
    public static boolean isValidName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return name.matches("[A-Za-z ]{3,50}");
    }

    // Validate Age (1 - 120)
    public static boolean isValidAge(int age) {

        return age >= 1 && age <= 120;
    }

    // Validate Phone Number (10 Digits)
    public static boolean isValidPhone(String phone) {

        return phone.matches("[6-9][0-9]{9}");
    }

    // Validate Gender
    public static boolean isValidGender(String gender) {

        return gender.equalsIgnoreCase("Male")
                || gender.equalsIgnoreCase("Female")
                || gender.equalsIgnoreCase("Other");
    }

    // Validate Doctor Specialization
    public static boolean isValidSpecialization(String specialization) {

        if (specialization == null || specialization.trim().isEmpty()) {
            return false;
        }

        return specialization.matches("[A-Za-z ]{3,50}");
    }

    // Validate Appointment Status
    public static boolean isValidStatus(String status) {

        return status.equalsIgnoreCase("Booked")
                || status.equalsIgnoreCase("Completed")
                || status.equalsIgnoreCase("Cancelled");
    }

    // Validate Date Format (yyyy-mm-dd)
    public static boolean isValidDate(String date) {

        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    // Validate Time Format (HH:mm:ss)
    public static boolean isValidTime(String time) {

        return time.matches("([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d");
    }

    // Validate Medicine Name
    public static boolean isValidMedicine(String medicine) {

        if (medicine == null || medicine.trim().isEmpty()) {
            return false;
        }

        return medicine.matches("[A-Za-z0-9 ]{2,100}");
    }

    // Validate Dosage
    public static boolean isValidDosage(String dosage) {

        if (dosage == null || dosage.trim().isEmpty()) {
            return false;
        }

        return dosage.length() <= 100;
    }

    // Validate Remarks
    public static boolean isValidRemarks(String remarks) {

        return remarks != null && remarks.length() <= 250;
    }
}
