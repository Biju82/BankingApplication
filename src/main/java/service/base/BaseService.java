package service.base;

import entity.Account;
import entity.Customer;
import entity.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseService {
    protected final SessionFactory sessionFactory = new Configuration()
            .configure()                            //incarca configuratia din resources / hibernate.cfg.xml
            .addAnnotatedClass(Account.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Transaction.class)   //va adauga clasele de entitate ca standarde pentru cmenzile sql
            .buildSessionFactory();

}
