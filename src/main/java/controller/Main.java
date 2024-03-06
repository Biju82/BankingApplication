package controller;
import entity.Account;
import entity.Customer;
import entity.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.AccountService;
import service.CustomerService;
import service.TransactionService;
import service.impl.AccountServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.TransactionServiceImpl;

public class Main {
    public static void main(String[] args) {

       SessionFactory sessionFactory = new Configuration()
                .configure()                            //incarca configuratia din resources / hibernate.cfg.xml
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Transaction.class)   //va adauga clasele de entitate ca standarde pentru cmenzile sql
                .buildSessionFactory();

        System.out.println("adaugam");



    }
}