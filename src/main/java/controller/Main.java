package controller;
import dao.impl.AccountDAOImpl;
import entity.Account;
import entity.Customer;
import entity.Transaction;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.AccountService;
import service.CustomerService;
import service.TransactionService;
import service.impl.CustomerServiceImpl;
import service.impl.TransactionServiceImpl;
import dao.AccountDAO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Transaction.class)   //va adauga clasele de entitate ca standarde pentru cmenzile sql
                .buildSessionFactory();

        Scanner scanner = new Scanner(System.in);

        // Get balance for a specific account ID
        System.out.println("Enter account ID: ");
        Integer accountId = scanner.nextInt();
        System.out.println("Balance: " + new AccountDAOImpl(sessionFactory.createEntityManager()).getBalance(accountId.longValue()));

        scanner.close();
    }
}
//



