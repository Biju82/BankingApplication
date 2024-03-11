package controller;
import entity.Account;
import entity.Customer;
import entity.Transaction;
import exception.InssuficientBalanceException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.AccountService;
import service.CustomerService;
import service.TransactionService;
import service.impl.AccountServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.TransactionServiceImpl;

import java.util.Scanner;

public class Main extends CustomerController {
    public static void main(String[] args) throws InssuficientBalanceException {

        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();
        AccountService accountService = new AccountServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        System.out.println("aici");


        Customer customer = new Customer("Daniel Costinea", "danielos@gmail.com", "Cluj", "spassword");
        Customer customer2 = new Customer("Dabija Alexandru", "dabija@gmail.com", "Bucuresti", "apassword");
        Account account = new Account(200, "Lei", customer);
        Account account2 = new Account(500, "Lei", customer2);
        Transaction transaction = new Transaction("Euro", 20, customer);

        System.out.println(customer);

        customerService.addCustomer(customer);
        customerService.addCustomer(customer2);
        accountService.saveAccount(account);
        accountService.saveAccount(account2);
        transactionService.save(transaction);

        System.out.println("aici");
        try {
            accountService.withdraw(account, 20000.00);
        } catch (InssuficientBalanceException e) {
            System.out.println("Failed to withdraw , Insufficient funds ! ");
        }

        System.out.println("aici2");
        accountService.deposit(account2, 2000.00);
        System.out.println("acolo");
        accountService.transfer(account2, account, 100.00);
        System.out.println(customerService.getAllCustomers().toString());
        System.out.println(accountService.checkBalance(account));


        // customerController.addCustomerFromInput();
        //customerService.getAllCustomers();
        //customerService.logIn("daniel@gmail.com","password");


            System.out.println("Welcome to stoneAge banking it looks like you are new here, do you wish to create an account ? ");
            System.out.println("1. Yes");
            System.out.println("2. No, Exit");

            int option = scanner.nextInt();
            scanner.nextLine();
        Customer gogu= new Customer();
            switch (option) {
                case 1:
                    gogu = addCustomerFromInput();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }



        System.out.println("Great now that you have a customer account you need to make an account to deposit withdraw or transfer money, do you wish to ? ");
        System.out.println("1.Yes");
        System.out.println("1.No");
        int option2 = scanner.nextInt();
        scanner.nextLine();
            if(option2 == 1) {
                createAccountFromInput(gogu);
            }else if(option2==2){
                System.out.println("Bye bye");
            }
            else
            {
                    System.out.println("Invalid option. Please choose again.");
            }

        System.out.println("Now that u have an accout you can :");
        System.out.println("1:Top up your account !");
        System.out.println("2:Withdraw money ! if you already did a top up");
        System.out.println("3:Transfer money !");
        System.out.println("4: Check Balance !");
        option2 = scanner.nextInt();

    }

    }


