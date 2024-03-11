package service;

import entity.Account;
import exception.InssuficientBalanceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountService {


    Optional<Account> checkBalance(Account account);
    void saveAccount(Account account);
    void withdraw(Account account,Double ammount) throws InssuficientBalanceException;
    void deposit(Account account, Double ammount);
    void transfer(Account account1, Account account2, Double ammount);

//    @Transactional
//    void deposit(Long accountNumber, double amount);
//
//    @Transactional
//    void withdraw(Long accountNumber, double amount);
//
//
//    @Transactional(readOnly = true)
//    double getBalance(Long accountNumber);
}
