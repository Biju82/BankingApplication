package controller;
import entity.Customer;
import org.hibernate.Session;
import service.CustomerService;
import util.SessionManager;
import java.util.Scanner;

public class CustomerController {
//    private final CustomerService customerService;
//    private final Scanner scanner;
//
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void run() {
//        // Implement the method
//        boolean running = true;
//        while (running) {
//            System.out.println("Choose an option:");
//            System.out.println("1. Add Customer");
//            System.out.println("2. Remove Customer");
//            System.out.println("3. Make Transaction");
//            System.out.println("4. Exit");
//
//            int option = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (option) {
//                case 1:
//                    addCustomerFromInput();
//                    break;
//                case 2:
//                    removeCustomerByIdFromInput();
//                    break;
//                case 3:
//                    makeTransaction();
//                    break;
//                case 4:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid option. Please choose again.");
//            }
//        }
//    }
//
//    private void addCustomerFromInput() {
//        System.out.println("Adding a customer...");
//
//        System.out.println("Enter customer name:");
//        String name = scanner.nextLine();
//
//        System.out.println("Enter customer email:");
//        String email = scanner.nextLine();
//
//        System.out.println("Enter customer address:");
//        String address = scanner.nextLine();
//
//        Customer customer = new Customer();
//        customer.setName(name);
//        customer.setEmail(email);
//                customer.setAddress(address);
//
//        // Obtain a Hibernate Session using SessionManager
//        try (Session session = SessionManager.getSession()) {
//            // Begin a transaction
//            session.beginTransaction();
//
//            // Save the customer using the service method
//            customerService.addCustomer(customer);
//
//            // Commit the transaction
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Customer added successfully!");
//    }
//
//    private void removeCustomerByIdFromInput() {
//        System.out.println("Removing a customer...");
//
//        System.out.println("Enter customer ID to remove:");
//        Long customerId = scanner.nextLong();
//        scanner.nextLine(); // Consume newline
//
//        // Obtain a Hibernate Session using SessionManager
//        try (Session session = SessionManager.getSession()) {
//            // Begin a transaction
//            session.beginTransaction();
//
//            // Call the service method to remove the customer
//            customerService.deleteCustomer(customerId);
//
//            // Commit the transaction
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Customer removed successfully!");
//    }
//
//    private void makeTransaction() {
//        System.out.println("Making a transaction...");
//        // Implement transaction logic as needed
//    }
}
