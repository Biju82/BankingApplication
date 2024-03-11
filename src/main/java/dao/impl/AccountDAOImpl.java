package dao.impl;

import dao.AccountDAO;
import entity.Account;
import entity.Customer;
import entity.Transaction;
import exception.InssuficientBalanceException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import dao.base.BaseDAO;
import org.w3c.dom.css.ElementCSSInlineStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl extends BaseDAO implements AccountDAO {

    public AccountDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void saveAccount(Account account) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }


            // sql command
            entityManager.persist(account);

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Something went wrong");
        }
        System.out.println("The account in currency : " + account.getCurrency() + " was created succesfully !");
    }

    @Override
    public void withdraw(Account account, Double ammount) throws InssuficientBalanceException {
        EntityTransaction transaction = null;

            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            if(account.getBalance()>= ammount) {
                Transaction withdrawTransaction = new Transaction(account.getCurrency(), ammount, account.getCustomer());
                withdrawTransaction.setDescription("Withdraw");
                account.setBalance(account.getBalance() - ammount);
                // sql command
                entityManager.persist(account);
                entityManager.persist(withdrawTransaction);
                transaction.commit();
                System.out.println("Withdraw amount : " + ammount + " succesfully !");
            }else
            {
                throw new InssuficientBalanceException("Insufficient founds !");
            }




    }

    @Override
    public void deposit(Account account, Double ammount) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            Transaction depositTransaction = new Transaction(account.getCurrency(), ammount, account.getCustomer());
            depositTransaction.setDescription("TopUp");
            account.setBalance(account.getBalance() + ammount);
            entityManager.persist(account);
            entityManager.persist(depositTransaction);

            //commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Something went wrong");
        }

        System.out.println("Amount : " + ammount + " succesfully deposit !");
    }


    @Override
    public void transfer(Account account, Account account2, Double ammount){
        EntityTransaction transaction = null;

        try{
            transaction = entityManager.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }

            Transaction transfer = new Transaction(account.getCurrency(),ammount,account.getCustomer());
            transfer.setDescription("Transfer from "+ account.getCustomer().getName() + " to " + account2.getCustomer().getName());
            account.setBalance(account.getBalance()-ammount);
            account2.setBalance(account2.getBalance()+ammount);
            entityManager.persist(transfer);
            entityManager.persist(account2);
            entityManager.persist(account);

            //commit
            transaction.commit();
        }   catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println("Something went wrong !");
        }

        System.out.println("Amount : "+ ammount + " succesfully transfered to : " + account2.getCustomer().getName() + " !");
    }
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
    @Override
    public Optional<Account> checkBalance(Account account) {
        EntityTransaction transaction = null;
        Optional<Account> found = Optional.empty();

        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }
            int id = account.getAccountId();
            // sql command
           found = Optional.ofNullable(entityManager.find(Account.class, id));
            // commit command
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return found;

    }
}

