package controller;
import entity.Account;
import entity.Customer;
import service.AccountService;
import service.CustomerService;
import service.impl.AccountServiceImpl;
import service.impl.CustomerServiceImpl;

import java.util.Scanner;

public abstract class  CustomerController {
//    private final CustomerService customerService;
    private final Scanner scanner3;

    public CustomerController() {
//        this.customerService = customerService;
        this.scanner3 = new Scanner(System.in);
    }

    public static void topUp(Account account){
        Scanner scanner = new Scanner(System.in);
        AccountService accountService = new AccountServiceImpl();
        System.out.println("Introdu suma pe care vrei sa o depui : ");
        Double ammount = scanner.nextDouble();
        accountService.deposit(account,ammount);

    }



    public void run() {
        // Implement the method
        boolean running = true;
        while (running) {
            System.out.println("Welcome to stoneAge banking it looks like you are new here, do you wish to create an account ? ");
            System.out.println("1. Yes");
            System.out.println("2. No, Exit");

            int option = scanner3.nextInt();
            scanner3.nextLine();

            switch (option) {
                case 1:
                    addCustomerFromInput();
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }


    public static void createAccountFromInput(Customer customer){
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        AccountService accountService = new AccountServiceImpl();

        System.out.println("Addin an account...");
        System.out.println("Choose currency : ");
        System.out.println("1.RON");
        System.out.println("2.EUR");
        System.out.println("3.USD");
        System.out.println("4.LEVA");
        int option = scanner.nextInt();
        scanner.nextLine();
        String currency= null;
        switch (option) {
            case 1: currency = "RON";
            break;
            case 2: currency = "EUR";
            break;
            case 3: currency = "USD";
            break;
            case 4: currency = "LEVA";
            default:
                System.out.println("Optiunea aleasa nu exista");
                break;
        }
        Account account = new Account();
        account.setCurrency(currency);
        account.setCustomer(customer);
        account.setBalance(0);
        accountService.saveAccount(account);

        System.out.println("Account succesfull created");
    }

    public static Customer addCustomerFromInput() {
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a customer...");

        System.out.println("Enter customer name:");
        String name = scanner.nextLine();

        System.out.println("Enter customer email:");
        String email = scanner.nextLine();

        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        System.out.println("Enter customer password :");
        String password = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setPassword(password);

        customerService.addCustomer(customer);
        return customer;
    }

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
