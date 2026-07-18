package model;

import java.sql.Date;

public class ServiceRecord {

    private int serviceId;
    private int vehicleId;
    private Date serviceDate;
    private String serviceType;
    private double cost;
    private String status;

    public ServiceRecord() {
    }

    public ServiceRecord(int serviceId, int vehicleId, Date serviceDate,
                         String serviceType, double cost, String status) {
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.cost = cost;
        this.status = status;
    }

    public ServiceRecord(int vehicleId, Date serviceDate,
                         String serviceType, double cost, String status) {
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.cost = cost;
        this.status = status;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service ID : " + serviceId +
                "\nVehicle ID : " + vehicleId +
                "\nService Date : " + serviceDate +
                "\nService Type : " + serviceType +
                "\nCost : " + cost +
                "\nStatus : " + status;
    }
}


