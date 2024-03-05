package dao.impl;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import task.dao.TransactionDAO;
import dao.base.BaseDAO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionDAOImpl extends BaseDAO implements TransactionDAO {

    public TransactionDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Transaction save(Transaction transaction) {
        EntityTransaction entityTransaction = null;
        try {
            // Begin transaction if not already active
            entityTransaction = entityManager.getTransaction();
            if (!entityTransaction.isActive()) {
                entityTransaction.begin();
            }

            // Persist the transaction entity
            entityManager.persist(transaction);

            // Commit transaction
            entityTransaction.commit();
        } catch (Exception e) {
            // Rollback transaction in case of exception
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            return null;
        }

        return transaction;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction entityTransaction = null;
        try {
            // Begin transaction if not already active
            entityTransaction = entityManager.getTransaction();
            if (!entityTransaction.isActive()) {
                entityTransaction.begin();
            }

            // Find the transaction by ID and remove it
            Optional<Transaction> found = Optional.ofNullable(entityManager.find(Transaction.class, id));
            found.ifPresent(entityManager::remove);

            // Commit transaction
            entityTransaction.commit();
        } catch (Exception e) {
            // Rollback transaction in case of exception
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        }
    }

    @Override
    public Optional<Transaction> findById(Integer id) {
        EntityTransaction entityTransaction = null;
        Optional<Transaction> found = Optional.empty();

        try {
            // Begin transaction if not already active
            entityTransaction = entityManager.getTransaction();
            if (!entityTransaction.isActive()) {
                entityTransaction.begin();
            }

            // Find the transaction by ID
            found = Optional.ofNullable(entityManager.find(Transaction.class, id));

            // Commit transaction
            entityTransaction.commit();
        } catch (Exception e) {
            // Rollback transaction in case of exception
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        }

        return found;
    }

    @Override
    public List<Transaction> findAll() {
        EntityTransaction entityTransaction = null;
        List<Transaction> resultList = new ArrayList<>();

        try {
            // Begin transaction if not already active
            entityTransaction = entityManager.getTransaction();
            if (!entityTransaction.isActive()) {
                entityTransaction.begin();
            }

            // Retrieve all transactions
            resultList = entityManager.createQuery("FROM Transaction", Transaction.class).getResultList();

            // Commit transaction
            entityTransaction.commit();
        } catch (Exception e) {
            // Rollback transaction in case of exception
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        }

        return resultList;
    }
}
