package controller;

import dao.impl.AccountDAOImpl;
import entity.Account;
import entity.Customer;
import entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Transaction.class)
                .buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Customer customer1 = new Customer("John Doe", "john.doe@example.com", "123 Main St");
            Customer customer2 = new Customer("Jane Smith", "jane.smith@example.com", "456 Elm St");
            Customer customer3 = new Customer("Michael Johnson", "michael.johnson@example.com", "789 Oak St");
            Customer customer4 = new Customer("Emily Brown", "emily.brown@example.com", "101 Maple St");
            Customer customer5 = new Customer("David Wilson", "david.wilson@example.com", "202 Pine St");

            session.save(customer1);
            session.save(customer2);
            session.save(customer3);
            session.save(customer4);
            session.save(customer5);

            Account account1 = new Account(1000.00, customer1);
            Account account2 = new Account(2000.00, customer2);
            Account account3 = new Account(1500.00, customer3);
            Account account4 = new Account(2500.00, customer4);
            Account account5 = new Account(1800.00, customer5);

            session.save(account1);
            session.save(account2);
            session.save(account3);
            session.save(account4);
            session.save(account5);

            Transaction transaction1 = new Transaction("deposit", 500.00, customer1);
            Transaction transaction2 = new Transaction("withdrawal", 200.00, customer2);
            Transaction transaction3 = new Transaction("deposit", 1000.00, customer3);
            Transaction transaction4 = new Transaction("withdrawal", 300.00, customer4);
            Transaction transaction5 = new Transaction("deposit", 700.00, customer5);

//            session.save(transaction1);
//            session.save(transaction2);
//            session.save(transaction3);
//            session.save(transaction4);
//            session.save(transaction5);

            session.getTransaction().commit();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter account ID: ");
            Integer accountId = scanner.nextInt();
            System.out.println("Balance: " + new AccountDAOImpl(sessionFactory.createEntityManager()).getBalance(accountId.longValue()));

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
        } finally {
            sessionFactory.close();
        }
    }
}
