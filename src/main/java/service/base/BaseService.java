package service.base;

import entity.Account;
import entity.Customer;
import entity.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class BaseService {
    protected final SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Account.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Transaction.class)
            .buildSessionFactory();

}
