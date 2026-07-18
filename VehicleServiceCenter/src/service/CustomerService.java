package service;

import dao.CustomerDAO;
import model.Customer;
import util.Validation;

import java.util.ArrayList;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public void addCustomer(Customer customer) {

        if (!Validation.isValidName(customer.getCustomerName())) {
            System.out.println("Invalid Customer Name.");
            return;
        }

        if (!Validation.isValidPhone(customer.getPhone())) {
            System.out.println("Invalid Phone Number.");
            return;
        }

        if (!Validation.isValidEmail(customer.getEmail())) {
            System.out.println("Invalid Email.");
            return;
        }

        if (!Validation.isValidAddress(customer.getAddress())) {
            System.out.println("Invalid Address.");
            return;
        }

        if (customerDAO.addCustomer(customer))
            System.out.println("Customer Added Successfully.");
        else
            System.out.println("Failed to Add Customer.");
    }

    public void viewCustomers() {

        ArrayList<Customer> list = customerDAO.getAllCustomers();

        if (list.isEmpty()) {
            System.out.println("No Customers Found.");
        } else {
            for (Customer c : list) {
                System.out.println(c);
                System.out.println("----------------------------");
            }
        }
    }

    public void searchCustomer(int id) {

        Customer customer = customerDAO.searchCustomer(id);

        if (customer != null)
            System.out.println(customer);
        else
            System.out.println("Customer Not Found.");
    }

    public void updateCustomer(Customer customer) {

        if (customerDAO.updateCustomer(customer))
            System.out.println("Customer Updated Successfully.");
        else
            System.out.println("Update Failed.");
    }

    public void deleteCustomer(int id) {

        if (customerDAO.deleteCustomer(id))
            System.out.println("Customer Deleted Successfully.");
        else
            System.out.println("Customer Not Found.");
    }
}