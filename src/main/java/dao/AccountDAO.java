package dao;
import entity.Account;
import exception.InssuficientBalanceException;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    void saveAccount(Account account);
    void withdraw(Account account,Double amount) throws InssuficientBalanceException;
    void deposit(Account account, Double amount) ;

    Optional<Account> checkBalance(Account account);

    void transfer(Account account1, Account account2, Double ammount) ;
//
//    void deleteById(Long accountId);
//
//    Optional<Account> findById(Long accountId);
//
//    List<Account> findAll();
//
//    //method to update ballance
//    void deposit(Long id, Double balance);
//    void withdraw(Long id, Double amount);
//
//    //method to get balance
//    Double getBalance(Long accountId);
}
