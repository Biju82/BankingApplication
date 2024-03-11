package dao.impl;

import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import dao.CustomerDAO;
import dao.base.BaseDAO;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtill;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

    public CustomerDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }



    @Override
    public List<Customer> getAllCustomers() {
        EntityTransaction transaction = null;
        List<Customer> resultList = new ArrayList<>();

        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM Customer", Customer.class).getResultList(); // atentie mare ca era From actors
            // commit command
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return resultList;

    }

    public Customer logIn(String email, String password) {
        HibernateUtill hibernateUtill = new HibernateUtill();
        try (Session session = hibernateUtill.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Customer WHERE email = :email AND password = :password", Customer.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Customer> customers = query.getResultList();
            if (!customers.isEmpty()) {
                System.out.println("Contulexista");
                return customers.get(0); // Return the first customer found with the given email and password
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if no customer found with the given email and password
    }

    @Override
    public void addCustomer(Customer customer) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(customer);

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("ceva nu a mers cum trebuie");
        }
        System.out.println("Contul cu numele : " + customer.getName() + " a fost creat !");
    }


    //
//    @Override
//    public void deleteById(Integer id) {
//        EntityTransaction transaction = null;
//        try {
//            // check transaction is in place
//            transaction = entityManager.getTransaction();
//
//            if (!transaction.isActive()) {
//                transaction.begin();
//            }
//
//            // sql command
//            Optional<Customer> found = Optional.ofNullable(entityManager.find(Customer.class, id));
//            found.ifPresent(entityManager::remove);
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }
//
////    @Override
////    public Customer getCustomerById(Integer id) {
////        EntityTransaction transaction = null;
////        Optional<Customer> found = Optional.empty();
////
////        try {
////            // check transaction is in place
////            transaction = entityManager.getTransaction();
////
////            if (!transaction.isActive()) {
////                transaction.begin();
////            }
////
////            // sql command
////            found = Optional.ofNullable(entityManager.find(Customer.class, id));
////
////            // commit command
////            transaction.commit();
////        } catch (Exception e) {
////            if (transaction != null) {
////                transaction.rollback();
////            }
////        }
////
////        return found;
////    }
//
//
//

}