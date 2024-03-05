package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create a Hibernate Configuration object and configure it
            Configuration configuration = new Configuration().configure();

            // Build the SessionFactory using the configuration
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to obtain a Hibernate Session
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
