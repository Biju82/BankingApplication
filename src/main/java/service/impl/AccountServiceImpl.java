package service.impl;

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import entity.Account;
import exception.InssuficientBalanceException;
import service.AccountService;
import service.base.BaseService;

import java.util.Optional;

public class AccountServiceImpl extends BaseService implements AccountService {

    private AccountDAO accountDAO;

    public AccountServiceImpl() {
        this.accountDAO = new AccountDAOImpl(sessionFactory.createEntityManager());
    }

   public Optional<Account> checkBalance(Account account){
        return this.accountDAO.checkBalance(account);
   }

    @Override
    public void saveAccount(Account account){
         accountDAO.saveAccount(account);
    }

    @Override
    public void withdraw(Account account, Double ammount) throws InssuficientBalanceException {
        this.accountDAO.withdraw(account,ammount);
    }
    @Override
    public void deposit(Account account, Double ammount){
        this.accountDAO.deposit(account,ammount);
    }

    @Override
    public void transfer(Account account, Account account2, Double ammount) {
        this.accountDAO.transfer(account, account2, ammount);
    }

//    @Override
//    @Transactional
//    public void deposit(Long accountNumber, double amount) {
//        accountDAO.deposit(accountNumber, amount);
//    }
//
//    @Override
//    @Transactional
//    public void withdraw(Long accountNumber, double amount) {
//        accountDAO.withdraw(accountNumber, -amount);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public double getBalance(Long accountNumber) {
//        return accountDAO.getBalance(accountNumber);
//    }
}
