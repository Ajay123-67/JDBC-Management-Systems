package service;

import dao.ServiceRecordDAO;
import model.ServiceRecord;
import util.Validation;

import java.util.ArrayList;

public class ServiceRecordService {

    private ServiceRecordDAO serviceDAO = new ServiceRecordDAO();

    public void addService(ServiceRecord service) {

        if (!Validation.isValidServiceType(service.getServiceType())) {
            System.out.println("Invalid Service Type.");
            return;
        }

        if (!Validation.isValidCost(service.getCost())) {
            System.out.println("Invalid Service Cost.");
            return;
        }

        if (!Validation.isValidStatus(service.getStatus())) {
            System.out.println("Invalid Service Status.");
            return;
        }

        if (serviceDAO.addService(service))
            System.out.println("Service Booked Successfully.");
        else
            System.out.println("Failed to Book Service.");
    }

    public void viewServices() {

        ArrayList<ServiceRecord> list = serviceDAO.getAllServices();

        if (list.isEmpty()) {
            System.out.println("No Service Records Found.");
        } else {
            for (ServiceRecord service : list) {
                System.out.println(service);
                System.out.println("----------------------------");
            }
        }
    }

    public void updateService(ServiceRecord service) {

        if (serviceDAO.updateService(service))
            System.out.println("Service Updated Successfully.");
        else
            System.out.println("Update Failed.");
    }

    public void deleteService(int id) {

        if (serviceDAO.deleteService(id))
            System.out.println("Service Deleted Successfully.");
        else
            System.out.println("Service Record Not Found.");
    }

    public void viewServiceHistory() {

        serviceDAO.viewServiceHistory();
    }
}
