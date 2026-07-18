package model;

public class Patient {
	private int patientId;
    private String patientName;
    private String gender;
    private int age;
    private String phone;
    private String address;

    // Default Constructor
    public Patient() {

    }

    // Parameterized Constructor
    public Patient(int patientId, String patientName, String gender, int age, String phone, String address) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId +
                ", patientName=" + patientName +
                ", gender=" + gender +
                ", age=" + age +
                ", phone=" + phone +
                ", address=" + address + "]";
    }

}
