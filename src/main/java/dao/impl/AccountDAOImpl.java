package dao.impl;
import dao.AccountDAO;
import entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import dao.base.BaseDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl extends BaseDAO implements AccountDAO {

    public AccountDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

//    @Override
//    public Account save(Account account) {
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
//            entityManager.persist(account);
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
//        return account;
//    }
//
//    @Override
//    public void deleteById(Long accountId) {
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
//            Account account = entityManager.find(Account.class, accountId);
//            if (account != null) {
//                entityManager.remove(account);
//            }
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
//    @Override
//    public Optional<Account> findById(Long accountId) {
//        EntityTransaction transaction = null;
//        Optional<Account> found = Optional.empty();
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
//            found = Optional.ofNullable(entityManager.find(Account.class, accountId));
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//
//        return found;
//    }
//
//    @Override
//    public List<Account> findAll() {
//        EntityTransaction transaction = null;
//        List<Account> resultList = new ArrayList<>();
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
//            resultList = entityManager.createQuery("FROM Account", Account.class).getResultList();
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//
//        return resultList;
//    }
//
//    @Override
//    public void deposit(Long accountId, Double amount) {
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
//            Account account = entityManager.find(Account.class, accountId);
//
//            if (account != null) {
//                double newBalance = account.getBalance() + amount;
//                account.setBalance(newBalance);
//                entityManager.persist(account);
//            } else {
//                throw new IllegalArgumentException("Account with id " + accountId + " does not exist.");
//            }
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw e;
//        }
//    }
//
//    @Override
//    public void withdraw(Long accountId, Double amount) {
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
//            Account account = entityManager.find(Account.class, accountId);
//
//            if (account != null) {
//                double newBalance = account.getBalance() - amount;
//                account.setBalance(newBalance);
//                entityManager.persist(account);
//
//            } else {
//                throw new IllegalArgumentException("Account with id " + accountId + " does not exist.");
//            }
//
//            // commit command
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw e;
//        }
//    }
//
//    @Override
//    public Double getBalance(Long accountId) {
//        return null;
//    }
}

