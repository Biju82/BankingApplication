package controller;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Instantiate the CustomerService
        CustomerService customerService = new CustomerServiceImpl();

        // Instantiate the CustomerController with the CustomerService
        CustomerController customerController = new CustomerController(customerService);

        // Run the application
        customerController.run();
    }
}