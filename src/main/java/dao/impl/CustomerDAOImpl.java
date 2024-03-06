package dao.impl;

import entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import dao.CustomerDAO;
import dao.base.BaseDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

    public CustomerDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

//    @Override
//    public Customer addCustomer(Customer customer) {
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
//            entityManager.persist(customer);
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            return null;
//        }
//
//        return customer;
//    }
//
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
//    @Override
//    public List<Customer> getAllCustomers() {
//        EntityTransaction transaction = null;
//        List<Customer> customers = new ArrayList<>();
//
//        try {
//            // check transaction is in place
//            transaction = entityManager.getTransaction();
//
//            if (!transaction.isActive()) {
//                transaction.begin();
//            }
//
//            // sql command
//            customers = entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//
//        return customers;
//    }
}